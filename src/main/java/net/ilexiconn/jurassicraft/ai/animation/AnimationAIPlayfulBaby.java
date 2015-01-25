package net.ilexiconn.jurassicraft.ai.animation;

import net.ilexiconn.jurassicraft.ai.AIAnimation;
import net.ilexiconn.jurassicraft.entity.EntityJurassiCraftSmart;
import net.ilexiconn.jurassicraft.enums.JurassiCraftAnimationIDs;

public class AnimationAIPlayfulBaby extends AIAnimation
{
    private int duration;

    public AnimationAIPlayfulBaby(EntityJurassiCraftSmart creature, int duration)
    {
        super(creature);
        this.duration = duration;
    }

	@Override
    public int getAnimationId()
    {
        return JurassiCraftAnimationIDs.PLAYING.animID();
    }

	@Override
    public int getDuration()
    {
        return this.duration;
    }

	@Override
    public boolean isAutomatic()
    {
        return true;
    }
}
