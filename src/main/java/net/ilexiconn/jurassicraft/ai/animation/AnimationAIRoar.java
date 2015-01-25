package net.ilexiconn.jurassicraft.ai.animation;

import net.ilexiconn.jurassicraft.ai.AIAnimation;
import net.ilexiconn.jurassicraft.entity.EntityJurassiCraftSmart;
import net.ilexiconn.jurassicraft.enums.JurassiCraftAnimationIDs;

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

