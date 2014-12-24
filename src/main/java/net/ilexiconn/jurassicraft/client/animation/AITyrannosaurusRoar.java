package net.ilexiconn.jurassicraft.client.animation;

import thehippomaster.AnimationAPI.AIAnimation;
import net.ilexiconn.jurassicraft.entity.dinosaurs.EntityTyrannosaurus;


public class AITyrannosaurusRoar extends AIAnimation
{
    private EntityTyrannosaurus entityTrex;

    public AITyrannosaurusRoar(EntityTyrannosaurus trex)
    {
        super(trex);
        entityTrex = trex;
    }

    public int getAnimID()
    {
        return 1;
    }

    public boolean isAutomatic()
    {
        return true;
    }

    public int getDuration()
    {
        return 75;
    }
}
