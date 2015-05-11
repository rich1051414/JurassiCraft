package net.ilexiconn.jurassicraft.common.entity.ai.animation;

import net.ilexiconn.jurassicraft.common.entity.EntityJurassiCraftSmart;
import net.ilexiconn.jurassicraft.common.entity.ai.AIAnimation;
import net.ilexiconn.jurassicraft.common.enums.JurassiCraftAnimationIDs;

public class AnimationAIRoar extends AIAnimation
{
    private int duration;

    public AnimationAIRoar(EntityJurassiCraftSmart creature, int duration)
    {
        super(creature);
        this.duration = duration;
    }

    public int getAnimationId()
    {
        return JurassiCraftAnimationIDs.ROAR.animID();
    }

    public boolean isAutomatic()
    {
        return true;
    }

    public int getDuration()
    {
        return this.duration;
    }
}
