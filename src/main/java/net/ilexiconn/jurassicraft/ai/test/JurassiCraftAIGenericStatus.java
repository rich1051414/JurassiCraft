package net.ilexiconn.jurassicraft.ai.test;

import net.minecraft.entity.ai.EntityAIBase;

public class JurassiCraftAIGenericStatus extends EntityAIBase
{

	private EntityJurassiCraftSmart creature;
	private boolean status;
	private int startTime;
	private int duration;
	private int variation;
	private int timer;

	public JurassiCraftAIGenericStatus(EntityJurassiCraftSmart creature, int duration, int variation, int startTime)
	{
		this.creature = creature;
		this.startTime = startTime;
		this.duration = duration;
		this.variation = (int) (variation * this.creature.getRNG().nextFloat());
		this.timer = 0;
	}

	@Override
	public boolean shouldExecute()
	{
		this.timer++;
		return this.timer >= this.startTime + this.variation && this.creature.isEntityAlive();
	}

	@Override
	public void startExecuting()
	{
		this.setStatus(true);
		this.timer = 0;
	}

	public void updateTask()
	{
		this.timer++;
	}

	public boolean continueExecuting()
	{
		return this.creature.isEntityAlive() && this.timer < this.duration + this.variation;
	}

	@Override
	public void resetTask()
	{
		this.setStatus(false);
		this.timer = 0;
	}

	public void setStatus(boolean flag)
	{
		this.status = flag;
	}
}
