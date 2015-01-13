package net.ilexiconn.jurassicraft.client.animation;

import net.ilexiconn.jurassicraft.entity.dinosaurs.EntityTyrannosaurus;
import thehippomaster.AnimationAPI.AIAnimation;


public class AITyrannosaurusRoar extends AIAnimation
{
    private EntityTyrannosaurus entityTrex;

    public AITyrannosaurusRoar(EntityTyrannosaurus trex)
    {
        super(trex);
        entityTrex = trex;
    }

    public int getAnimationId()
    {
        return 1;
    }

    public boolean isAutomatic()
    {
        return true;
    }
    
    public void startExecuting()
    {
        super.startExecuting();
    }

    public int getDuration()
    {
        return 75;
    }
}
