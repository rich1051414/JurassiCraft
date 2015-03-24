package net.ilexiconn.jurassicraft.ai.animation;

import net.ilexiconn.jurassicraft.entity.EntityJurassiCraftSmart;
import net.ilexiconn.jurassicraft.enums.JurassiCraftAnimationIDs;

public class AnimationAIWalkRoar extends AIAnimation
{
    private int duration;
    
    public AnimationAIWalkRoar(EntityJurassiCraftSmart creature, int duration)
    {
        super(creature);
        this.duration = duration;
    }
    
    public int getAnimationId()
    {
        return JurassiCraftAnimationIDs.WALK_ROAR.animID();
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
