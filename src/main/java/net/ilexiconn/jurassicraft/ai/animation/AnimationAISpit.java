package net.ilexiconn.jurassicraft.ai.animation;

import net.ilexiconn.jurassicraft.ai.AIAnimation;
import net.ilexiconn.jurassicraft.entity.EntityJurassiCraftCreature;
import net.ilexiconn.jurassicraft.enums.JurassiCraftAnimationIDs;
import net.minecraft.entity.EntityLivingBase;

public class AnimationAISpit extends AIAnimation
{
    private EntityJurassiCraftCreature entityBiting;
    private EntityLivingBase entityTarget;
    private int duration;

    public AnimationAISpit(EntityJurassiCraftCreature dino, int duration)
    {
        super(dino);
        this.entityBiting = dino;
        this.entityTarget = null;
        this.duration = duration;
    }

    public int getAnimationId()
    {
        return JurassiCraftAnimationIDs.BITE.animID();
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
        this.entityTarget = this.entityBiting.getAttackTarget();
    }

    public void updateTask()
    {
        super.updateTask();
        if (this.entityTarget != null)
        {

        }
    }

    @Override
    public void resetTask()
    {
        super.resetTask();
    }
}
