package net.ilexiconn.jurassicraft.client.animation;

import java.util.List;

import net.ilexiconn.jurassicraft.AnimationHandler;
import net.ilexiconn.jurassicraft.ai.AIAnimation;
import net.ilexiconn.jurassicraft.entity.dinosaurs.EntityParasaurolophus;
import net.ilexiconn.jurassicraft.interfaces.IAnimatedEntity;

public class AIParasaurolophusTrumpet extends AIAnimation
{

    private EntityParasaurolophus parasaurolophus;

    public AIParasaurolophusTrumpet(IAnimatedEntity entity)
    {
        super(entity);
        this.parasaurolophus = (EntityParasaurolophus) entity;
    }

    public int getAnimationId()
    {
        return JurassiCraftAnimationIDs.TRUMPET.animID();
    }

    public boolean isAutomatic()
    {
        return true;
    }

    public int getDuration()
    {
        return 60;
    }
    
    public void resetTask()
    {
    	super.resetTask();
    	this.parasaurolophus.timeUntilCanCall = 300;
    }

    public void updateTask()
    {
        if (this.parasaurolophus.getAnimationTick() == 3)
        {
            double I = Math.random();
            if (I <= 0.3)
            {
            	this.parasaurolophus.playSound("jurassicraft:parasaurolophusCall03", 5.0F, 1.0F);
            }
            else if (I <= 0.6 && I > 0.3)
            {
            	this.parasaurolophus.playSound("jurassicraft:parasaurolophusCall04", 5.0F, 1.0F);
            }
            else
            {
            	this.parasaurolophus.playSound("jurassicraft:parasaurolophusCall05", 5.0F, 1.0F);
            }
        }
        if (this.parasaurolophus.getAnimationTick() == 50) {
        	List<EntityParasaurolophus> recipients = this.parasaurolophus.getParasaurolophusNearby(20.0D, 10.0D, 20.0D);
        	for (EntityParasaurolophus nearbyParasaurolophus : recipients) {
        		if (nearbyParasaurolophus.timeUntilCanCall == 0 && nearbyParasaurolophus.getAnimationId() == 0) 
        			AnimationHandler.sendAnimationPacket(nearbyParasaurolophus, JurassiCraftAnimationIDs.TRUMPET.animID());
        	}
        }
    }
}
