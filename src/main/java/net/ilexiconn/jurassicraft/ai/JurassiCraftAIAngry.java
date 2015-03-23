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
        if (this.creature.isTakingOff())
            this.creature.setTakingOff(false);
        
        if (this.creature.isFlying())
            this.creature.setFlying(false);
        
        if (this.creature.isPlaying())
            this.creature.setPlaying(false);
        
        if (this.creature.isSocializing())
            this.creature.setSocializing(false);
        
        if (this.creature.isEating())
            this.creature.setEating(false);
        
        if (this.creature.isDrinking())
            this.creature.setDrinking(false);
        
        if (this.creature.isFleeing())
            this.creature.setFleeing(false);
        
        if (this.creature.isDefending())
            this.creature.setDefending(false);
        
        if (this.creature.isBreeding())
            this.creature.setBreeding(false);
        
        if (this.creature.isInLove())
            this.creature.setInLove(false);
        
        if (this.creature.isSitting())
            this.creature.setSitting(false, null);
        
        if (this.creature.isSleeping())
            this.creature.setSleeping(false);
        
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
