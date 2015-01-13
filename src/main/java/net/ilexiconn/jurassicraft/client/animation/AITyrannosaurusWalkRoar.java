package net.ilexiconn.jurassicraft.client.animation;

import net.ilexiconn.jurassicraft.entity.dinosaurs.EntityTyrannosaurus;
import thehippomaster.AnimationAPI.AIAnimation;

public class AITyrannosaurusWalkRoar extends AIAnimation
{
    private EntityTyrannosaurus entityTrex;

    public AITyrannosaurusWalkRoar(EntityTyrannosaurus trex)
    {
        super(trex);
        entityTrex = trex;
    }

    public int getAnimationId()
    {
        return 2;
    }

    public boolean isAutomatic()
    {
        return true;
    }
    
    public void startExecuting()
    {
        super.startExecuting();
        System.out.println("Walk Roar");
    }

    public int getDuration()
    {
        return 75;
    }
}
