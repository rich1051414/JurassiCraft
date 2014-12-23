package net.ilexiconn.jurassicraft.ai;

import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.item.EntityItem;
import net.ilexiconn.jurassicraft.Util;
import net.ilexiconn.jurassicraft.entity.EntityJurassiCraftTameable;

import java.util.List;

public class JurassiCraftEntityAIEatDroppedFood extends EntityAIBase 
{

	private EntityJurassiCraftTameable hungryCreature;
	private double searchDistance;
	private double timeTryingToEat;
	private EntityItem droppedFood;

	public JurassiCraftEntityAIEatDroppedFood(EntityJurassiCraftTameable creature, double distance)
	{
		this.hungryCreature = creature;
		this.searchDistance = distance;
		this.timeTryingToEat = 0;
	}

	@Override
	public boolean isInterruptible() 
	{
		return true;
	}

	@Override
	public boolean shouldExecute()
	{
		if (this.hungryCreature.getAttackTarget() != null || this.hungryCreature.getRNG().nextInt(100) < 90) 
		{
			return false;
		}
		List nearEntityList = this.hungryCreature.worldObj.getEntitiesWithinAABBExcludingEntity(this.hungryCreature, this.hungryCreature.boundingBox.expand(searchDistance, 8.0D, searchDistance));
		if (!nearEntityList.isEmpty())
		{
			for (int i = nearEntityList.size() - 1; i > -1; i--) 
			{
				if (nearEntityList.get(i) instanceof EntityItem && this.hungryCreature.getCreature().isFavoriteFood(((EntityItem) nearEntityList.get(i)).getEntityItem().getItem())) 
				{
					this.droppedFood = (EntityItem) nearEntityList.get(i);
					return this.droppedFood != (EntityItem) null;
				}
			}
		}
		
		return false;
	}

	@Override
	public void startExecuting() 
	{
		if (this.hungryCreature.isTamed())
		{
			this.hungryCreature.setSitting(false);
		}
		
		this.hungryCreature.getNavigator().tryMoveToXYZ(droppedFood.posX, droppedFood.posY, droppedFood.posZ, this.hungryCreature.getCreatureSpeed());
		super.startExecuting();
	}

	@Override
	public void updateTask()
	{
		if (this.hungryCreature.getNavigator() == null) 
		{
			this.hungryCreature.getNavigator().tryMoveToXYZ(this.droppedFood.posX, this.droppedFood.posY, this.droppedFood.posZ, this.hungryCreature.getCreatureSpeed());
		}
		
		double distance = Math.sqrt(Math.pow((double) (this.hungryCreature.posX - this.droppedFood.posX), 2.0D) + Math.pow((double) (this.hungryCreature.posY - this.droppedFood.posY), 2.0D) + Math.pow((double) (this.hungryCreature.posZ - this.droppedFood.posZ), 2.0D));
		
		if (distance < 1.0D)
		{
			this.droppedFood.setDead();
		} 
		else 
		{
			this.timeTryingToEat++;
		}
	}

	@Override
	public boolean continueExecuting()
	{
		return (this.timeTryingToEat < 100 && !this.droppedFood.isDead && !this.hungryCreature.isDead);
	}

	@Override
	public void resetTask() 
	{
		this.hungryCreature.getNavigator().clearPathEntity();
		this.droppedFood = (EntityItem) null;
		this.timeTryingToEat = 0;
	}
}