package net.ilexiconn.jurassicraft.ai.animation;

import net.ilexiconn.jurassicraft.ai.AIAnimation;
import net.ilexiconn.jurassicraft.entity.dinosaurs.EntityVelociraptor;
import net.ilexiconn.jurassicraft.enums.JurassiCraftAnimationIDs;
import net.ilexiconn.jurassicraft.interfaces.IAnimatedEntity;
import net.minecraft.entity.EntityLiving;

public class AnimationAIVelociraptorTwitchHead extends AIAnimation
{
    private EntityVelociraptor raptor;
    
    public AnimationAIVelociraptorTwitchHead(IAnimatedEntity animraptor)
    {
        super(animraptor);
        this.raptor = (EntityVelociraptor) animraptor;
    }
    
    public int getAnimationId()
    {
        return JurassiCraftAnimationIDs.TWITCH_HEAD.animID();
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
        EntityLiving living = getEntity();
        IAnimatedEntity entity = (IAnimatedEntity) living;
        return entity.getAnimationId() == 0 && living.getRNG().nextInt(45) == 0;
    }
}
