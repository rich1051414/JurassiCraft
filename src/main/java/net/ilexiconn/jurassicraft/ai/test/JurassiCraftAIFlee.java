package net.ilexiconn.jurassicraft.ai.test;

import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.util.Vec3;

public class JurassiCraftAIFlee extends EntityAIBase
{
	private EntityJurassiCraftSmart creature;
	private int fleeingVariation;
	private int fleeingTime;
	private double randPosX;
	private double randPosY;
	private double randPosZ;
	private double speed;

	public JurassiCraftAIFlee(EntityJurassiCraftSmart entity, int duration, double velocity)
	{
		this.creature = entity;
		this.speed = velocity;
		this.fleeingTime = duration;
		this.fleeingVariation = 0;
		this.setMutexBits(1);
	}

	@Override
	public boolean shouldExecute()
	{
		if (this.creature.isSleeping())
		{
			return false;
		}
		else if (this.creature.isFleeing())
		{
			Vec3 vec3 = RandomPositionGenerator.findRandomTarget(this.creature, 5, 4);
			if (vec3 == null)
			{
				return false;
			}
			else
			{
				this.randPosX = vec3.xCoord;
				this.randPosY = vec3.yCoord;
				this.randPosZ = vec3.zCoord;
				this.fleeingVariation = (int) (this.fleeingTime * (0.7F + 0.6F * this.creature.getRNG().nextFloat()));
				return true;
			}
		}
		else
		{
			return true;
		}
	}

	@Override
	public void startExecuting()
	{
		this.creature.setSleeping(false);
		this.creature.setPlaying(false);
		this.creature.setSocializing(false);
		this.creature.setEating(false);
		this.creature.setDrinking(false);
		this.creature.setDefending(false);
		this.creature.setAttacking(false);
		this.creature.setBreeding(false);
		this.creature.setInLove(false);
		this.creature.setSitting(false, null);
		this.creature.getNavigator().tryMoveToXYZ(this.randPosX, this.randPosY, this.randPosZ, this.speed);
	}

	@Override
	public void updateTask()
	{
		this.creature.setFleeingTick(this.creature.getFleeingTick() - 1);
	}

	@Override
	public boolean continueExecuting()
	{
		return !this.creature.getNavigator().noPath() && this.creature.getFleeingTick() < (this.fleeingTime + this.fleeingVariation);
	}

	@Override
	public void resetTask()
	{
		this.creature.setFleeingTick(0);
		this.creature.setFleeing(false);
	}
}
