package net.ilexiconn.jurassicraft.ai;

import net.ilexiconn.jurassicraft.entity.EntityJurassiCraftSmart;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;

public class JurassiCraftAIAngry extends EntityAIBase
{
    private EntityJurassiCraftSmart creature;
	private int angryTime;

    public JurassiCraftAIAngry(EntityJurassiCraftSmart entity, int duration)
    {
        this.creature = entity;
        this.angryTime = duration;
    }

    @Override
    public boolean shouldExecute()
    {
		return this.creature.isAngry() && !this.creature.isSleeping();
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
		this.creature.setSitting(false, null);
		this.creature.setAngerLevel(this.angryTime + (int) (this.angryTime * 0.6F * this.creature.getRNG().nextFloat()));
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
		return this.creature.getAngerLevel() > 0 && this.creature.getAttackTarget() != null && !this.creature.isSitting() && !this.creature.isSleeping() && this.creature.riddenByEntity == null;
	}

	@Override
	public void resetTask()
	{
        this.creature.setAngerLevel(0);
		this.creature.setAttacking(false);
		this.creature.setAngry(false);
		this.creature.setAttackTarget((EntityLivingBase) null);
	}
}
