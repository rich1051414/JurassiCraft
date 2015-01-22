package net.ilexiconn.jurassicraft.ai;

import net.ilexiconn.jurassicraft.entity.EntityJurassiCraftSmart;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAITarget;

public class JurassiCraftAIFleeOwnerIsHurtByTarget extends EntityAITarget
{
	private EntityJurassiCraftSmart creature;
	private EntityLivingBase attacker;

	public JurassiCraftAIFleeOwnerIsHurtByTarget(EntityJurassiCraftSmart entity)
	{
		super(entity, true);
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
				this.attacker = (EntityLivingBase) owner.getAITarget();
				return attacker != null;
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
		this.attacker = null;
		return this.creature.isFleeing();
	}
}
