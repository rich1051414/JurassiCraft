package thehippomaster.AnimationAPI;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIBase;

public abstract class AIAnimation extends EntityAIBase
{
	private IAnimatedEntity animatedEntity;

	public AIAnimation(IAnimatedEntity entity)
	{
		animatedEntity = entity;
		setMutexBits(7);
	}
	
	public abstract int getAnimationId();
	
	public <T extends EntityLiving> T getEntity()
	{
		return (T) animatedEntity;
	}
	
	public abstract boolean isAutomatic();
	
	public abstract int getDuration();
	
	public boolean shouldAnimate()
	{
		return false;
	}
	
	public boolean shouldExecute()
	{
		if(isAutomatic()) return animatedEntity.getAnimationId() == getAnimationId();
		return shouldAnimate();
	}
	
	public void startExecuting()
	{
		if(!isAutomatic()) AnimationAPI.sendAnimationPacket(animatedEntity, getAnimationId());
		animatedEntity.setAnimationTick(0);
	}
	
	public boolean continueExecuting()
	{
		return animatedEntity.getAnimationTick() < getDuration();
	}
	
	public void resetTask()
	{
		AnimationAPI.sendAnimationPacket(animatedEntity, 0);
	}
}
