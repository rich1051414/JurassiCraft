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

    public AITyrannosaurusEatingGallimimus(EntityTyrannosaurus tyrannosaurus)
    {
        super(tyrannosaurus);
        this.tyrannosaurus = tyrannosaurus;
    }

    public int getAnimationId()
    {
        return 3;
    }

    public int getDuration()
    {
        return 50;
    }
	
    public boolean isAutomatic()
    {
        return false;
    }
	
	public boolean shouldExecute()
	{
		if (this.tyrannosaurus.riddenByEntity != null && this.tyrannosaurus.riddenByEntity instanceof EntityGallimimus)
		{
			EntityGallimimus gallimimus = (EntityGallimimus) this.tyrannosaurus.riddenByEntity;
			return this.tyrannosaurus.getAnimationId() == this.getAnimationId();
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
    	
	}
    
    public void resetTask()
    {
    	super.resetTask();
    	if (this.gallimimus != null)
		{
        	this.tyrannosaurus.dismountEntity(this.gallimimus);
			this.gallimimus.setHealth(0.0F);
        	this.gallimimus.setDead();
		}
    }
}
