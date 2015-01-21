package net.ilexiconn.jurassicraft.ai.test;

import net.minecraft.entity.ai.EntityAINearestAttackableTarget;

/**
 * This AI makes an EntityJurassiCraftSmart attack a desirable mob when the creature is not tamed
 * and has enough age.
 * 
 * @author RafaMv
 */
public class JurassiCraftAITargetIfHasAgeAndNonTamed extends EntityAINearestAttackableTarget
{
	private EntityJurassiCraftSmart creature;
	private float age;

	public JurassiCraftAITargetIfHasAgeAndNonTamed(EntityJurassiCraftSmart entity, Class targetClass, int chanceToAttack, float ageToAttack)
	{
		super(entity, targetClass, chanceToAttack, false);
		this.creature = entity;
		this.age = ageToAttack;
	}

	@Override
	public boolean shouldExecute()
	{
		return !this.creature.isTamed() && this.creature.isCreatureOlderThan(this.age) && !this.creature.isSleeping() && !this.creature.isAttacking() && super.shouldExecute();
	}

	@Override
	public void startExecuting()
	{
		super.startExecuting();
		this.creature.setAttacking(true);
	}

	@Override
	public void resetTask()
	{
		super.resetTask();
		this.creature.setAttacking(false);
	}
}
