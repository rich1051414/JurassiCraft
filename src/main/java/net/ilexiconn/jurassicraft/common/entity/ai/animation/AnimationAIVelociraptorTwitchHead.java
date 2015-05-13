package net.ilexiconn.jurassicraft.common.entity.ai.animation;

import net.ilexiconn.jurassicraft.common.entity.ai.AIAnimation;
import net.ilexiconn.jurassicraft.common.entity.dinosaurs.EntityVelociraptor;
import net.ilexiconn.jurassicraft.common.data.enums.JurassiCraftAnimationIDs;
import net.ilexiconn.jurassicraft.common.api.IAnimatedEntity;
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
