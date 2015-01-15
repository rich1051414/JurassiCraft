package net.ilexiconn.jurassicraft.client.animation;

import net.ilexiconn.jurassicraft.entity.dinosaurs.EntityVelociraptor;
import net.ilexiconn.jurassicraft.ai.AIAnimation;

public class AIVelociraptorRoar extends AIAnimation
{
    private EntityVelociraptor entityRaptor;

    public AIVelociraptorRoar(EntityVelociraptor raptor)
    {
        super(raptor);
        entityRaptor = raptor;
    }

    public int getAnimationId()
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

