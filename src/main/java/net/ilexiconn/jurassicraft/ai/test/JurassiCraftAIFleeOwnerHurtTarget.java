package net.ilexiconn.jurassicraft.ai.test;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAITarget;

public class JurassiCraftAIFleeOwnerHurtTarget extends EntityAITarget
{
	EntityJurassiCraftSmart creature;
	EntityLivingBase target;

	public JurassiCraftAIFleeOwnerHurtTarget(EntityJurassiCraftSmart entity)
	{
		super(entity, false);
		this.creature = entity;
		this.setMutexBits(1);
	}

	@Override
	public boolean shouldExecute()
	{
		if (!this.creature.isTamed() || this.creature.isSleeping() || !this.creature.isFleeing())
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
				this.target = owner.getLastAttacker();
				return target != null && owner.getDistanceSqToEntity(this.creature) < 256.0D;
			}
		}
	}

	@Override
	public void startExecuting()
	{
		this.creature.setFleeing(true);
		super.startExecuting();
	}

	@Override
	public boolean continueExecuting()
	{
		return this.creature.isFleeing();
	}
}
