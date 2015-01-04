package net.ilexiconn.jurassicraft.client.animation;

import net.minecraft.entity.EntityLiving;
import thehippomaster.AnimationAPI.AIAnimation;
import thehippomaster.AnimationAPI.IAnimatedEntity;

public class AIHypsilophodonScratchHead extends AIAnimation
{

    public AIHypsilophodonScratchHead(IAnimatedEntity entity)
    {
        super(entity);
    }

    public int getAnimID()
    {
        return 1;
    }

    public boolean isAutomatic()
    {
        return false;
    }

    public int getDuration()
    {
        return 35;
    }

    public boolean shouldAnimate()
    {
        EntityLiving living = getEntity();
        IAnimatedEntity entity = (IAnimatedEntity) living;
        return entity.getAnimID() == 0 && living.getRNG().nextInt(60) == 0;
    }
}
