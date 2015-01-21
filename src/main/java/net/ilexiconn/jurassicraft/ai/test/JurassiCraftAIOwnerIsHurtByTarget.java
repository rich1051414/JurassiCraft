package net.ilexiconn.jurassicraft.ai.test;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAITarget;

public class JurassiCraftAIOwnerIsHurtByTarget extends EntityAITarget
{
	EntityJurassiCraftSmart creature;
	EntityLivingBase target;

	public JurassiCraftAIOwnerIsHurtByTarget(EntityJurassiCraftSmart entity)
	{
		super(entity, false);
		this.creature = entity;
		this.setMutexBits(1);
	}

	@Override
	public boolean shouldExecute()
	{
		if (!this.creature.isTamed() || this.creature.isSleeping())
		{
			return false;
		}
		else
		{
			EntityLivingBase owner = this.creature.getOwner();
			if (owner == null)
			{
				return false;
			}
			else
			{
				this.target = owner.getAITarget();
				if (this.target instanceof EntityJurassiCraftSmart)
				{
					return this.isSuitableTarget(this.target, false) && !((EntityJurassiCraftSmart) this.target).isOwner(owner);
				}
				else
				{
					return this.isSuitableTarget(this.target, false);
				}
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
		this.creature.setBreeding(false);
		this.creature.setInLove(false);
		this.creature.setStalking(false);
		this.creature.setSitting(false, null);
		this.creature.setAttackTarget(this.target);
		this.creature.setAttacking(true);
		super.startExecuting();
	}

	@Override
	public boolean continueExecuting()
	{
		return !this.creature.isSitting() && this.creature.riddenByEntity == null && super.continueExecuting();
	}

	@Override
	public void resetTask()
	{
		this.target = null;
		this.creature.setAttacking(false);
		super.resetTask();
	}
}
