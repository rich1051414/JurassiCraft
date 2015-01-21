package net.ilexiconn.jurassicraft.ai.test;

import net.minecraft.entity.ai.EntityAIAvoidEntity;

public class JurassiCraftAIAvoidEntityIfNotTamed extends EntityAIAvoidEntity
{
	private EntityJurassiCraftSmart creature;

	public JurassiCraftAIAvoidEntityIfNotTamed(EntityJurassiCraftSmart entity, Class avoidClass, float distanceFromEntity, double farSpeed, double nearSpeed)
	{
		super(entity, avoidClass, distanceFromEntity, farSpeed, nearSpeed);
		this.creature = entity;
		this.setMutexBits(1);
	}

	@Override
	public boolean shouldExecute()
	{
		return !this.creature.isTamed() && super.shouldExecute();
	}
}
