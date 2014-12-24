package net.ilexiconn.jurassicraft.client.animation;

import thehippomaster.AnimationAPI.AIAnimation;
import thehippomaster.AnimationAPI.IAnimatedEntity;
import net.ilexiconn.jurassicraft.entity.dinosaurs.EntityParasaurolophus;

public class AIParasaurolophusTrumpet extends AIAnimation {

	private EntityParasaurolophus entityPara;
	
	public AIParasaurolophusTrumpet(IAnimatedEntity entity) {
		super(entity);
		entityPara = (EntityParasaurolophus) entity;
	}

	public int getAnimID() {
		return 1;
	}

	public boolean isAutomatic() {
		return true;
	}

	public int getDuration() {
		return 60;
	}
	
	public void updateTask()
	{
		if (entityPara.getAnimTick() == 3) {
			double I = Math.random();
	        if (I <= 0.3)
	        {
				entityPara.playSound("jurassicraft:ParaCall03", 5.0F, 1.0F);
	        }
	        else if (I <= 0.6 && I > 0.3)
	        {
				entityPara.playSound("jurassicraft:ParaCall04", 5.0F, 1.0F);
	        }
	        else
	        {
				entityPara.playSound("jurassicraft:ParaCall05", 5.0F, 1.0F);
	        }
		}
	}		
}
