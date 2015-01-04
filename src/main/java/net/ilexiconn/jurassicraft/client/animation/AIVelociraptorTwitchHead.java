package net.ilexiconn.jurassicraft.client.animation;

import net.ilexiconn.jurassicraft.entity.dinosaurs.EntityVelociraptor;
import net.minecraft.entity.EntityLiving;
import thehippomaster.AnimationAPI.AIAnimation;
import thehippomaster.AnimationAPI.IAnimatedEntity;

public class AIVelociraptorTwitchHead extends AIAnimation
{
    private EntityVelociraptor raptor;

    public AIVelociraptorTwitchHead(IAnimatedEntity animraptor)
    {
        super(animraptor);
        this.raptor = (EntityVelociraptor) animraptor;
    }

    public int getAnimationId()
    {
        return 1;
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
        return entity.getAnimationId() == 0 && living.getRNG().nextInt(45) == 0 && raptor.getAttackTarget() == null;
    }
}
