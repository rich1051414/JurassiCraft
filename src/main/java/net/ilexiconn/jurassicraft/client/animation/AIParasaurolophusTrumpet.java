package net.ilexiconn.jurassicraft.client.animation;

import java.util.List;

import net.ilexiconn.jurassicraft.AnimationHandler;
import net.ilexiconn.jurassicraft.entity.dinosaurs.EntityParasaurolophus;
import net.ilexiconn.jurassicraft.ai.AIAnimation;
import net.ilexiconn.jurassicraft.interfaces.IAnimatedEntity;

public class AIParasaurolophusTrumpet extends AIAnimation
{

    private EntityParasaurolophus entityPara;

    public AIParasaurolophusTrumpet(IAnimatedEntity entity)
    {
        super(entity);
        entityPara = (EntityParasaurolophus) entity;
    }

    public int getAnimationId()
    {
        return 1;
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
    	entityPara.timeUntilCanCall = 300;
    }

    public void updateTask()
    {
        if (entityPara.getAnimationTick() == 3)
        {
            double I = Math.random();
            if (I <= 0.3)
            {
                entityPara.playSound("jurassicraft:parasaurolophusCall03", 5.0F, 1.0F);
            }
            else if (I <= 0.6 && I > 0.3)
            {
                entityPara.playSound("jurassicraft:parasaurolophusCall04", 5.0F, 1.0F);
            }
            else
            {
                entityPara.playSound("jurassicraft:parasaurolophusCall05", 5.0F, 1.0F);
            }
        }
        if (entityPara.getAnimationTick() == 50) {
        	List<EntityParasaurolophus> recipients = entityPara.getParasaurolophusNearby(20, 10, 20);
        	for (int i = 0; i < recipients.size(); i++) {
        		if (recipients.get(i).timeUntilCanCall == 0 && recipients.get(i).getAnimationId() == 0)AnimationHandler.sendAnimationPacket(recipients.get(i), 1);
        	}
        }
    }
}
