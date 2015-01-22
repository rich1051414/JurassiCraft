package net.ilexiconn.jurassicraft.ai;

import net.ilexiconn.jurassicraft.entity.EntityJurassiCraftSmart;
import net.minecraft.entity.ai.EntityAIBase;

public class JurassiCraftAIPlaying extends EntityAIBase
{
	private EntityJurassiCraftSmart creature;
	private int duration;
	private int timer;

	public JurassiCraftAIPlaying(EntityJurassiCraftSmart creature, int duration)
	{
		this.creature = creature;
		if (duration > 0)
		{
			this.duration = duration;
		}
		else
		{
			this.duration = 30;
		}
		this.timer = 0;
	}

	@Override
	public boolean shouldExecute()
	{
		return !this.creature.isSitting() || this.creature.riddenByEntity != null || !this.creature.isSleeping() || !this.creature.isAttacking() || !this.creature.isDefending() || !this.creature.isDrinking() || !this.creature.isEating() || !this.creature.isInjured() || !this.creature.isStalking();
	}

	@Override
	public void startExecuting()
	{
		this.creature.getNavigator().clearPathEntity();
		this.creature.setSleeping(false);
		this.creature.setEating(false);
		this.creature.setDrinking(false);
		this.creature.setDefending(false);
		this.creature.setAttacking(false);
		this.creature.setBreeding(false);
		this.creature.setStalking(false);
		this.creature.setPlaying(true);
		this.timer = this.duration;
	}

	public void updateTask()
	{
		this.timer--;
	}

	public boolean continueExecuting()
	{
		return this.timer >= 0 && !this.creature.isSitting() && !this.creature.isSleeping() && this.creature.riddenByEntity == null;
	}

	@Override
	public void resetTask()
	{
		this.creature.setPlaying(false);
		this.timer = 0;
	}
}
