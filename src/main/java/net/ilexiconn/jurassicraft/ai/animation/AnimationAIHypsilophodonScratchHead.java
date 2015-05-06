package net.ilexiconn.jurassicraft.ai.animation;

import net.ilexiconn.jurassicraft.ai.AIAnimation;
import net.ilexiconn.jurassicraft.enums.JurassiCraftAnimationIDs;
import net.ilexiconn.jurassicraft.interfaces.IAnimatedEntity;
import net.minecraft.entity.EntityLiving;

public class AnimationAIHypsilophodonScratchHead extends AIAnimation
{

    public AnimationAIHypsilophodonScratchHead(IAnimatedEntity entity)
    {
        super(entity);
    }

    public int getAnimationId()
    {
        return JurassiCraftAnimationIDs.SCRATCH.animID();
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
        return entity.getAnimationId() == 0 && living.getRNG().nextInt(60) == 0;
    }
}
