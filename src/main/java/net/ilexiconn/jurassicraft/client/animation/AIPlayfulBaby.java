package net.ilexiconn.jurassicraft.client.animation;

import net.ilexiconn.jurassicraft.ai.AIAnimation;
import net.ilexiconn.jurassicraft.entity.EntityJurassiCraftSmart;

public class AIPlayfulBaby extends AIAnimation
{
    private int duration;

    public AIPlayfulBaby(EntityJurassiCraftSmart creature, int duration)
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
