package net.ilexiconn.jurassicraft.ai.animation;

import net.ilexiconn.jurassicraft.ai.AIAnimation;
import net.ilexiconn.jurassicraft.entity.EntityJurassiCraftCreature;
import net.ilexiconn.jurassicraft.enums.JurassiCraftAnimationIDs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;

public class AnimationAISpit extends AIAnimation
{
    private EntityJurassiCraftCreature entitySpitting;
    private EntityLivingBase entityTarget;
    private int duration;
    private int spitFrame;
    private String spitSound;

    public AnimationAISpit(EntityJurassiCraftCreature dino, int duration, int spitFrame, String spitSound)
    {
        super(dino);
        setMutexBits(8);
        this.entitySpitting = dino;
        this.entityTarget = null;
        this.duration = duration;
        this.spitFrame = spitFrame;
        this.spitSound = spitSound;
    }

    public int getAnimationId()
    {
        return JurassiCraftAnimationIDs.SPITTING.animID();
    }

    public boolean isAutomatic()
    {
        return true;
    }

    public int getDuration()
    {
        return this.duration;
    }

    public void startExecuting()
    {
        super.startExecuting();
        this.entityTarget = this.entitySpitting.getAttackTarget();
    }

    public void updateTask()
    {
        super.updateTask();
        if (this.entityTarget != null)
        {
            if (entitySpitting.getAnimationTick() <= spitFrame)
                entitySpitting.getLookHelper().setLookPositionWithEntity(entityTarget, 30F, 30F);
            if (entitySpitting.getAnimationTick() == spitFrame)
                ((IRangedAttackMob) entitySpitting).attackEntityWithRangedAttack(entityTarget, 0);
        }
    }

    @Override
    public void resetTask()
    {
        super.resetTask();
    }
}
