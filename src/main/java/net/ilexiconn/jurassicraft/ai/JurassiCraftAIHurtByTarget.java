package net.ilexiconn.jurassicraft.ai;

import net.ilexiconn.jurassicraft.entity.EntityJurassiCraftSmart;
import net.minecraft.entity.ai.EntityAIHurtByTarget;

public class JurassiCraftAIHurtByTarget extends EntityAIHurtByTarget
{
    private EntityJurassiCraftSmart creature;
    
    public JurassiCraftAIHurtByTarget(EntityJurassiCraftSmart entity, boolean friendsShouldHelp)
    {
        super(entity, friendsShouldHelp);
        this.creature = entity;
        this.shouldCheckSight = true;
        this.setMutexBits(1);
    }
    
    @Override
    public boolean shouldExecute()
    {
        if (this.creature.isSleeping())
        {
            return false;
        }
        else
        {
            return super.shouldExecute();
        }
    }
    
    @Override
    public void startExecuting()
    {
        this.creature.setSleeping(false);
        this.creature.setEating(false);
        this.creature.setDrinking(false);
        this.creature.setDefending(false);
        this.creature.setPlaying(false);
        this.creature.setBreeding(false);
        this.creature.setSocializing(false);
        this.creature.setStalking(false);
        this.creature.setInLove(false);
        this.creature.setAttacking(true);
        super.startExecuting();
    }
    
    @Override
    public void resetTask()
    {
        this.creature.setAttacking(false);
        super.resetTask();
    }
}
