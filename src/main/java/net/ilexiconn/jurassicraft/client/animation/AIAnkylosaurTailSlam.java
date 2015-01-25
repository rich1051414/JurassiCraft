package net.ilexiconn.jurassicraft.client.animation;

import net.minecraft.entity.EntityLiving;
import net.ilexiconn.jurassicraft.ai.AIAnimation;
import net.ilexiconn.jurassicraft.interfaces.IAnimatedEntity;

public class AIAnkylosaurTailSlam extends AIAnimation
{
    public AIAnkylosaurTailSlam(IAnimatedEntity entity)
    {
        super(entity);
    }

    public int getAnimationId()
    {
        return JurassiCraftAnimationIDs.TAIL_SLAM.animID();
    }

    public boolean isAutomatic()
    {
        return false;
    }

    public int getDuration()
    {
        return 30;
    }

    public boolean shouldAnimate()
    {
        //accessor method in AIAnimation that gives access to the entity
        EntityLiving living = getEntity();

        //must have an attack target
        if (living.getAttackTarget() == null) return false;

        //should already have lost enough health for healing to be effective
        if (living.getHealth() > living.getMaxHealth() - 4) return false;

        IAnimatedEntity entity = (IAnimatedEntity) living;
        return entity.getAnimationId() == 0 && living.getRNG().nextInt(30) == 0;
    }
}
