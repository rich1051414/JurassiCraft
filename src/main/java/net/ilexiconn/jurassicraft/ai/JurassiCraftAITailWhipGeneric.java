package net.ilexiconn.jurassicraft.ai;

import java.util.ArrayList;
import java.util.List;

import net.ilexiconn.jurassicraft.AnimationHandler;
import net.ilexiconn.jurassicraft.client.animation.JurassiCraftAnimationIDs;
import net.ilexiconn.jurassicraft.entity.EntityJurassiCraftSmart;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;

public class JurassiCraftAITailWhipGeneric extends EntityAIBase
{
	private EntityJurassiCraftSmart creature;
	private EntityLivingBase attacker;
	private double distanceSqFromAttacker;
	private Class targetClass;

	public JurassiCraftAITailWhipGeneric(EntityJurassiCraftSmart creature, Class targetClass)
	{
		this.creature = creature;
		this.targetClass = targetClass;
		this.distanceSqFromAttacker = 0;
		this.attacker = null;
	}

	@Override
	public boolean shouldExecute()
	{
		if (this.creature.getRNG().nextInt(50) > 0)
		{
			return false;
		}
		else
		{
			if (!this.creature.isSitting() && !this.creature.isSleeping() && !this.creature.isTakingOff() && !this.creature.isFlying() && !this.creature.isFleeing())
			{
				List<Entity> list = this.creature.worldObj.getEntitiesWithinAABBExcludingEntity(this.creature, this.creature.boundingBox.expand(20.0D, 8.0D, 20.0D));
				ArrayList<EntityLivingBase> listOfTargets = new ArrayList<EntityLivingBase>();
				for (Entity entity : list)
				{
					if (entity.getClass() == targetClass)
					{
						listOfTargets.add((EntityLivingBase) entity);
					}
				}
				if (!listOfTargets.isEmpty())
				{
					this.distanceSqFromAttacker = 864.0D;
					for (EntityLivingBase closeTarget : listOfTargets)
					{
						double nextDistance = this.creature.getDistanceSqToEntity(closeTarget);
						if (nextDistance < this.distanceSqFromAttacker)
						{
							this.distanceSqFromAttacker = nextDistance;
							this.attacker = closeTarget;
						}
					}
					return this.attacker != null;
				}
			}
		}
		return false;
	}

	@Override
	public void startExecuting()
	{
		this.creature.getNavigator().clearPathEntity();
		this.creature.setTakingOff(false);
		this.creature.setFlying(false);
		this.creature.setSitting(false, null);
		this.creature.setSleeping(false);
		this.creature.setAttacking(false);
		this.creature.setFleeing(false);
		this.creature.setStalking(false);
		this.creature.setEating(false);
		this.creature.setDrinking(false);
		this.creature.setPlaying(false);
		this.creature.setBreeding(false);
		this.creature.setInLove(false);
		this.creature.setDefending(true);
	}

	public void updateTask()
	{
		if (this.creature.getRNG().nextBoolean())
			this.distanceSqFromAttacker = this.creature.getDistanceSqToEntity(this.attacker);
		
		if (this.distanceSqFromAttacker < 36.0D && this.creature.getAnimationId() == 0)
            AnimationHandler.sendAnimationPacket(this.creature, JurassiCraftAnimationIDs.TAIL_WHIP.animID());
	}

	public boolean continueExecuting()
	{
		return this.attacker.isEntityAlive() && this.creature.isDefending() && this.distanceSqFromAttacker < 864 && !this.creature.isSitting() && this.creature.riddenByEntity == null;
	}

	@Override
	public void resetTask()
	{
		this.creature.setDefending(false);
		this.distanceSqFromAttacker = 0;
		this.attacker = null;
	}
}
