package net.ilexiconn.jurassicraft.ai.test;

import net.minecraft.entity.ai.EntityAIBase;

public class JurassiCraftAIAngry extends EntityAIBase
{
    private EntityJurassiCraftSmart creature;

    public JurassiCraftAIAngry(EntityJurassiCraftSmart entity)
    {
        this.creature = entity;
    }

    @Override
    public boolean shouldExecute()
    {
        return this.creature.isAngry();
    }
    
	@Override
	public void startExecuting()
	{
		super.startExecuting();
		this.creature.setAttacking(true);
	}

    @Override
    public void updateTask()
    {
        this.creature.setAngerLevel(creature.getAngerLevel() - 1);
    }

	@Override
	public boolean continueExecuting()
	{
		return this.creature.isAngry() && this.creature.isSitting() && this.creature.isSleeping() && this.creature.riddenByEntity == null;
	}

	@Override
	public void resetTask()
	{
		super.resetTask();
		this.creature.setAttacking(false);
        this.creature.setAngerLevel(0);
        this.creature.setAttackTarget(null);
	}
}
