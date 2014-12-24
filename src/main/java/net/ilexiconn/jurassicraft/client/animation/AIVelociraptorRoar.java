package net.ilexiconn.jurassicraft.client.animation;

import thehippomaster.AnimationAPI.AIAnimation;
import net.ilexiconn.jurassicraft.entity.dinosaurs.EntityVelociraptor;

public class AIVelociraptorRoar extends AIAnimation
{
    private EntityVelociraptor entityRaptor;

    public AIVelociraptorRoar(EntityVelociraptor raptor)
    {
        super(raptor);
        entityRaptor = raptor;
    }

    public int getAnimID()
    {
        return 2;
    }

    public boolean isAutomatic()
    {
        return true;
    }

    public int getDuration()
    {
        return 20;
    }
}

