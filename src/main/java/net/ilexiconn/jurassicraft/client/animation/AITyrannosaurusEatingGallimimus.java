package net.ilexiconn.jurassicraft.client.animation;

import net.ilexiconn.jurassicraft.AnimationHandler;
import net.ilexiconn.jurassicraft.ai.AIAnimation;
import net.ilexiconn.jurassicraft.entity.dinosaurs.EntityGallimimus;
import net.ilexiconn.jurassicraft.entity.dinosaurs.EntityTyrannosaurus;
import net.minecraft.entity.EntityLivingBase;

public class AITyrannosaurusEatingGallimimus extends AIAnimation
{
    private EntityTyrannosaurus tyrannosaurus;
    private EntityGallimimus gallimimus;
	private Class targetClass;

    public AITyrannosaurusEatingGallimimus(EntityTyrannosaurus tyrannosaurus, Class targetClass)
    {
        super(tyrannosaurus);
        this.tyrannosaurus = tyrannosaurus;
		this.targetClass = targetClass;
    }

    public int getAnimationId()
    {
        return 3;
    }

    public int getDuration()
    {
        return 75;
    }
	
    public boolean isAutomatic()
    {
        return true;
    }
	
	public boolean shouldExecute()
	{
		if (this.tyrannosaurus.riddenByEntity != null && this.tyrannosaurus.riddenByEntity instanceof EntityLivingBase)
		{
			EntityLivingBase entityLivingBase = (EntityLivingBase) this.tyrannosaurus.riddenByEntity;
			if (entityLivingBase.getClass() == this.targetClass && entityLivingBase.getHealth() <= 1.0F)
			{
				this.tyrannosaurus.setDrinking(false);
				AnimationHandler.sendAnimationPacket(this.tyrannosaurus, this.getAnimationId());
				return this.tyrannosaurus.getAnimationId() == this.getAnimationId();
			}
		}
		return false;
	}

    public void startExecuting()
    {
		super.startExecuting();
		this.tyrannosaurus.setDrinking(false);
		if (this.tyrannosaurus.riddenByEntity instanceof EntityGallimimus)
		{
			this.gallimimus = (EntityGallimimus) this.tyrannosaurus.riddenByEntity;
		}
	}

    public void updateTask()
    {
		if (this.gallimimus != null)
		{
			//Do more stuff
		}
	}
    
    public void resetTask()
    {
    	super.resetTask();
    	if (this.gallimimus != null)
		{
        	this.tyrannosaurus.dismountEntity(this.gallimimus);
        	//this.gallimimus.setDead();
		}
    }
}
