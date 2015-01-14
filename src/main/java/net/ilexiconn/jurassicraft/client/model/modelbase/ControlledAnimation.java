package net.ilexiconn.jurassicraft.client.model.modelbase;

import net.minecraft.client.Minecraft;


public class ControlledAnimation
{
	protected double timer;
	protected double limitTime;
	protected boolean shouldExecute;

	public ControlledAnimation(int limitTime)
	{
		this.timer = 0;
		this.limitTime = (double) limitTime;
	}

	public void resetTimer()
	{
		this.timer = 0;
		this.limitTime = 50;
	}

	public void increaseTimer()
	{
		if (!Minecraft.getMinecraft().isGamePaused() && this.timer < this.limitTime) this.timer++;
	}

	public void increaseTimer(int time)
	{
		if (!Minecraft.getMinecraft().isGamePaused() && this.timer + (double) time < this.limitTime) this.timer += (double) time;
	}

	public void decreaseTimer()
	{
		if (!Minecraft.getMinecraft().isGamePaused() && this.timer > 0) this.timer--;
	}

	public void decreaseTimer(int time)
	{
		if (!Minecraft.getMinecraft().isGamePaused() && this.timer - (double) time > 0) this.timer -= (double) time;
	}

	public void setTimer(int time)
	{
		if ((double) time < this.limitTime) this.timer = (double) time;
	}
	
	public float getAnimationProgress()
	{
		if (this.timer > 0.0D)
		{
			if (this.timer < this.limitTime)
			{
				return (float) (1.0D / (1.0D + Math.exp(4.0D - 8.0D * (this.timer / this.limitTime))));
			}
			else
			{
				return 1.0F;
			}
		}
		return 0.0F;
	}
}
