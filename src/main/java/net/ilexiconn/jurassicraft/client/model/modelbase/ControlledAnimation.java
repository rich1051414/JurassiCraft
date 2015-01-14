package net.ilexiconn.jurassicraft.client.model.modelbase;

import net.minecraft.client.Minecraft;
import net.minecraft.util.MathHelper;

public class ControlledAnimation
{
	/** It is the timer used to animate */
	protected double timer;
	/**
	 * It is the limit time, the maximum value that the timer can be. I
	 * represents the duration of the animation
	 */
	protected double limitTime;

	public ControlledAnimation(int limitTime)
	{
		this.timer = 0;
		this.limitTime = (double) limitTime;
	}

	/**
	 * Sets the duration of the animation in ticks. Try values around 50.
	 * 
	 * @param limitTime is the maximum number of ticks that the timer can reach.
	 */
	public void setLimitTime(int limitTime)
	{
		this.timer = 0;
		this.limitTime = (double) limitTime;
	}

	/**
	 * Sets the timer to a specific value.
	 * 
	 * @param time is the number of ticks to be set.
	 */
	public void setTimer(int time)
	{
		if ((double) time < this.limitTime)
			this.timer = (double) time;
	}

	/** Sets the timer to 0. */
	public void resetTimer()
	{
		this.timer = 0;
	}

	/** Increases the timer by 1. */
	public void increaseTimer()
	{
		if (!Minecraft.getMinecraft().isGamePaused() && this.timer < this.limitTime)
			this.timer++;
	}

	/**
	 * Increases the timer by a specific value.
	 * 
	 * @param time is the number of ticks to be increased in the timer
	 */
	public void increaseTimer(int time)
	{
		if (!Minecraft.getMinecraft().isGamePaused() && this.timer + (double) time < this.limitTime)
			this.timer += (double) time;
	}

	/** Decreases the timer by 1. */
	public void decreaseTimer()
	{
		if (!Minecraft.getMinecraft().isGamePaused() && this.timer > 0)
			this.timer--;
	}

	/**
	 * Decreases the timer by a specific value.
	 * 
	 * @param time is the number of ticks to be decreased in the timer
	 */
	public void decreaseTimer(int time)
	{
		if (!Minecraft.getMinecraft().isGamePaused() && this.timer - (double) time > 0)
			this.timer -= (double) time;
	}

	/**
	 * Returns a value between 0.0F and 1.0F depending on the timer and duration
	 * of the animation (limitTime).It reaches 1.0F using 1/(1 + e^(4-8*x)). It
	 * is quite uniform and needs if statements.
	 */
	public float getAnimationProgressSmooth()
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

	/**
	 * Returns a value between 0.0F and 1.0F depending on the timer and duration
	 * of the animation (limitTime).It reaches 1.0F using 1/(1 + e^(6-12*x)). It
	 * is quite uniform.
	 */
	public float getAnimationProgressSharp()
	{
		return (float) (1.0D / (1.0D + Math.exp(6.0D - 12.0D * (this.timer / this.limitTime))));
	}

	/**
	 * Returns a value between 0.0F and 1.0F depending on the timer and duration
	 * of the animation (limitTime).It reaches 1.0F using a sine function. It is
	 * fast in the beginning and slow in the end.
	 */
	public float getAnimationProgressSin()
	{
		return MathHelper.sin(1.57079632679F * (float) (this.timer / this.limitTime));
	}

	/**
	 * Returns a value between 0.0F and 1.0F depending on the timer and duration
	 * of the animation (limitTime).It reaches 1.0F using a sine function
	 * squared. It is very smooth.
	 */
	public float getAnimationProgressSinSqrt()
	{
		float result = MathHelper.sin(1.57079632679F * (float) (this.timer / this.limitTime));
		return result * result;
	}

	/**
	 * Returns a value between 0.0F and 1.0F depending on the timer and duration
	 * of the animation (limitTime).It reaches 1.0F using a sine function to the
	 * power of ten. It is slow in the beginning and fast in the end.
	 */
	public float getAnimationProgressSinToTen()
	{
		return (float) Math.pow((double) MathHelper.sin(1.57079632679F * (float) (this.timer / this.limitTime)), 10);
	}

	/**
	 * Returns a value between 0.0F and 1.0F depending on the timer and duration
	 * of the animation (limitTime).It reaches 1.0F using a sine function to a
	 * specific power "i."
	 * 
	 * @param i is the power of the sine function.
	 */
	public float getAnimationProgressSinPowerOf(int i)
	{
		return (float) Math.pow((double) MathHelper.sin(1.57079632679F * (float) (this.timer / this.limitTime)), i);
	}

	/**
	 * Returns a value between 0.0F and 1.0F depending on the timer and duration
	 * of the animation (limitTime).It reaches 1.0F using 0.5 + arctan(PI * (x -
	 * 0.5)) / 2.00776964. It is super smooth.
	 */
	public float getAnimationProgressArcTan()
	{
		return (float) (0.5F + 0.49806510671F * Math.atan(3.14159265359D * ((double) (this.timer / this.limitTime) - 0.5D)));
	}
}
