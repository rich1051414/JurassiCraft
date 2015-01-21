package net.ilexiconn.jurassicraft.ai.test;

import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class JurassiCraftAIFollowFood extends EntityAIBase
{
	private EntityJurassiCraftSmart creature;
	private EntityPlayer temptingPlayer;
	private boolean avoidWater;
	private double speed;
	private int stealFoodChance;
	private int stealFoodTimer;

	public JurassiCraftAIFollowFood(EntityJurassiCraftSmart entity, int stealFoodChance, double velocity)
	{
		this.creature = entity;
		this.speed = velocity;
		this.stealFoodChance = stealFoodChance;
		this.setMutexBits(3);
	}

	@Override
	public boolean shouldExecute()
	{
		if (this.creature.isSitting() || this.creature.isFlying() || this.creature.riddenByEntity != null || this.creature.isSleeping() || this.creature.isEating() || this.creature.isDrinking())
		{
			return false;
		}
		else
		{
			this.temptingPlayer = this.creature.worldObj.getClosestPlayerToEntity(this.creature, 10.0D);
			if (this.temptingPlayer == null)
			{
				return false;
			}
			else
			{
				ItemStack itemStack = this.temptingPlayer.getHeldItem();
				return itemStack == null ? false : (this.creature.getAttackTarget() == null && this.creature.getCreature().isFavoriteFood(itemStack.getItem()));
			}
		}
	}

	@Override
	public void startExecuting()
	{
		this.creature.setPlaying(false);
		this.creature.setSocializing(false);
		this.creature.setEating(false);
		this.creature.setDrinking(false);
		this.creature.setDefending(false);
		this.creature.setAttacking(false);
		this.creature.setBreeding(false);
		this.creature.setSitting(false, null);
		this.avoidWater = this.creature.getNavigator().getAvoidsWater();
		this.creature.getNavigator().setAvoidsWater(false);
		this.stealFoodTimer = 50;
	}

	@Override
	public void updateTask()
	{
		this.creature.getLookHelper().setLookPositionWithEntity(this.temptingPlayer, 30.0F, (float) this.creature.getVerticalFaceSpeed());
		double distancesq = this.creature.getDistanceSqToEntity(this.temptingPlayer);
		if (distancesq < 6.25D * this.creature.getGeneticQuality())
		{
			this.creature.getNavigator().clearPathEntity();
			if (distancesq < 5.5D && this.creature.getRNG().nextInt(this.stealFoodChance) == 0 && stealFoodTimer < 0)
			{
				this.stealFoodTimer = 50;
				ItemStack heldItem = this.temptingPlayer.getHeldItem();
				heldItem.stackSize--;
				if (heldItem.stackSize < 1)
					heldItem = null;
			}
			else
			{
				this.stealFoodTimer--;
			}
		}
		else
		{
			this.creature.getNavigator().tryMoveToEntityLiving(this.temptingPlayer, this.speed);
		}
	}

	@Override
	public boolean continueExecuting()
	{
		ItemStack itemstack = this.temptingPlayer.getCurrentEquippedItem();
		return this.creature.isEntityAlive() && this.temptingPlayer.isEntityAlive() && !this.creature.isSitting() && !this.creature.hasBeenHurt() && this.creature.riddenByEntity == null && (itemstack != null && this.creature.getCreature().isFavoriteFood(itemstack.getItem()));
	}

	@Override
	public void resetTask()
	{
		this.temptingPlayer = null;
		this.creature.getNavigator().clearPathEntity();
		this.creature.getNavigator().setAvoidsWater(this.avoidWater);
	}
}
