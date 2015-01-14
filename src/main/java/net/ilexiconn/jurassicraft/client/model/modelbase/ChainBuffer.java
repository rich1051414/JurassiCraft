package net.ilexiconn.jurassicraft.client.model.modelbase;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;

/**
 * This is a buffer used to delay a chain of parented boxes by using the yaw and pitch 
 * of the entity.
 * 
 * @author RafaMv
 */
public class ChainBuffer
{
	/** Used to delay the tail animation when the entity rotates. */
	private int yawTimer;
	/** Rotation amount (rotateY) of the tail buffer. Added when the entity rotates. */
	private float yawVariation;
	/** Used to delay the tail animation when the entity rotates. */
	private int pitchTimer;
	/** Rotation amount (rotateY) of the tail buffer. Added when the entity rotates. */
	private float pitchVariation;

	public ChainBuffer()
	{
		this.yawTimer = 0;
		this.pitchTimer = 0;
		this.yawVariation = 0.0F;
		this.pitchVariation = 0.0F;
	}
	
	/**
	 * Adds a specific rotation to a chain of parented boxes based on the entity movement (rotateAngleY).
	 * 
	 * @param boxes are the ModelRenderers to be animated;
	 * @param maxAngle is the maximum angle that the tail can have. 
	 * Try values about 40.0F to 90.0F degrees;
	 * @param bufferTime is the number of ticks necessary to start reducing the tail angle. 
	 * Try values about 5 to 30 ticks;
	 * @param angleDecrement is the amount of angle that will be reduced each tick. 
	 * Try values about 3.0F degrees;
	 * @param divider reduces the amount of angle added to the buffer. 
	 * Try values about 5.0F.
	 * @param entity is the EntityLivingBase that will be used to animate the tail;
	 */
	public void chainSwingBuffer(MowzieModelRenderer[] boxes, float maxAngle, int bufferTime, float angleDecrement, float divider, EntityLivingBase entity) 
	{
		if (Minecraft.getMinecraft().isGamePaused()) return;
		
		if (entity.renderYawOffset != entity.prevRenderYawOffset && MathHelper.abs(this.yawVariation) < maxAngle)
			this.yawVariation += (entity.prevRenderYawOffset - entity.renderYawOffset) / divider;
		
		if (this.yawVariation > 0.7F * angleDecrement) 
		{
			if (this.yawTimer > bufferTime) 
			{
				this.yawVariation -= angleDecrement;
				if (MathHelper.abs(this.yawVariation) < angleDecrement) 
				{
					this.yawVariation = 0.0F;
					this.yawTimer = 0;
				}
			}
			else
			{
				this.yawTimer++;
			}
		} 
		else if (this.yawVariation < -0.7F * angleDecrement) 
		{
			if (this.yawTimer > bufferTime) 
			{
				this.yawVariation += angleDecrement;
				if (MathHelper.abs(this.yawVariation) < angleDecrement) 
				{
					this.yawVariation = 0.0F;
					this.yawTimer = 0;
				}
			}
			else
			{
				this.yawTimer++;
			}
		}
		
		for (int i = 0; i < boxes.length; i++)
			boxes[i].rotateAngleY += 0.01745329251F * this.yawVariation / (1 + i);
	}
	
	/**
	 * Adds a specific rotation to a chain of parented boxes based on the entity movement (rotateAngleX).
	 * 
	 * @param boxes are the ModelRenderers to be animated;
	 * @param maxAngle is the maximum angle that the tail can have. 
	 * Try values about 40.0F to 90.0F degrees;
	 * @param bufferTime is the number of ticks necessary to start reducing the tail angle. 
	 * Try values about 5 to 30 ticks;
	 * @param angleDecrement is the amount of angle that will be reduced each tick. 
	 * Try values about 3.0F degrees;
	 * @param divider reduces the amount of angle added to the buffer. 
	 * Try values about 5.0F.
	 * @param entity is the EntityLivingBase that will be used to animate the tail;
	 */
	public void chainWaveBuffer(MowzieModelRenderer[] boxes, float maxAngle, int bufferTime, float angleDecrement, float divider, EntityLivingBase entity) 
	{
		if (Minecraft.getMinecraft().isGamePaused()) return;
		
		if (entity.rotationPitch != entity.prevRotationPitch && MathHelper.abs(this.pitchVariation) < maxAngle)
			this.pitchVariation += (entity.prevRotationPitch - entity.rotationPitch) / divider;
		
		if (this.pitchVariation > 0.7F * angleDecrement) 
		{
			if (this.pitchTimer > bufferTime) 
			{
				this.pitchVariation -= angleDecrement;
				if (MathHelper.abs(this.pitchVariation) < angleDecrement) 
				{
					this.pitchVariation = 0.0F;
					this.pitchTimer = 0;
				}
			}
			else
			{
				this.pitchTimer++;
			}
		} 
		else if (this.pitchVariation < -0.7F * angleDecrement) 
		{
			if (this.pitchTimer > bufferTime) 
			{
				this.pitchVariation += angleDecrement;
				if (MathHelper.abs(this.pitchVariation) < angleDecrement) 
				{
					this.pitchVariation = 0.0F;
					this.pitchTimer = 0;
				}
			}
			else
			{
				this.pitchTimer++;
			}
		}
		
		for (int i = 0; i < boxes.length; i++)
			boxes[i].rotateAngleY += 0.01745329251F * this.yawVariation / (1 + i);
	}
	
	/**
	 * Returns a float array with all rotation buffers to be used in a chain of parented boxes based on 
	 * the entity movement. Useful when two or more chains should be animated using the same rotations.
	 * 
	 * @param partLength is the number of parts to be animated. This represents the length of the final array;
	 * @param maxAngle is the maximum angle that the tail can have. 
	 * Try values about 40.0F to 90.0F degrees;
	 * @param bufferTime is the number of ticks necessary to start reducing the tail angle. 
	 * Try values about 5 to 30 ticks;
	 * @param angleDecrement is the amount of angle that will be reduced each tick. 
	 * Try values about 3.0F degrees;
	 * @param divider reduces the amount of angle added to the buffer. 
	 * Try values about 5.0F.
	 * @param entity is the EntityLivingBase that will be used to animate the tail;
	 */
	public float[] chainSwingBufferArray(int partLength, float maxAngle, int bufferTime, float angleDecrement, float divider, EntityLivingBase entity) 
	{
		float[] rotations = new float[partLength];
		
		if (entity.renderYawOffset != entity.prevRenderYawOffset && MathHelper.abs(this.yawVariation) < maxAngle)
			this.yawVariation += (entity.prevRenderYawOffset - entity.renderYawOffset) / divider;
		
		if (this.yawVariation > 0.7F * angleDecrement) 
		{
			if (this.yawTimer > bufferTime) 
			{
				this.yawVariation -= angleDecrement;
				if (MathHelper.abs(this.yawVariation) < angleDecrement) 
				{
					this.yawVariation = 0.0F;
					this.yawTimer = 0;
				}
			}
			else
			{
				this.yawTimer++;
			}
		} 
		else if (this.yawVariation < -0.7F * angleDecrement) 
		{
			if (this.yawTimer > bufferTime) 
			{
				this.yawVariation += angleDecrement;
				if (MathHelper.abs(this.yawVariation) < angleDecrement) 
				{
					this.yawVariation = 0.0F;
					this.yawTimer = 0;
				}
			}
			else
			{
				this.yawTimer++;
			}
		}
		
		for (int i = 0; i < rotations.length; i++)
			rotations[i] += 0.01745329251F * this.yawVariation / (1 + i);
		
		return rotations;
	}
	
	/**
	 * Returns a float array with all rotation buffers to be used in a chain of parented boxes based on 
	 * the entity movement. Useful when two or more chains should be animated using the same rotations.
	 * 
	 * @param partLength is the number of parts to be animated. This represents the length of the final array;
	 * @param maxAngle is the maximum angle that the tail can have. 
	 * Try values about 40.0F to 90.0F degrees;
	 * @param bufferTime is the number of ticks necessary to start reducing the tail angle. 
	 * Try values about 5 to 30 ticks;
	 * @param angleDecrement is the amount of angle that will be reduced each tick. 
	 * Try values about 3.0F degrees;
	 * @param divider reduces the amount of angle added to the buffer. 
	 * Try values about 5.0F.
	 * @param entity is the EntityLivingBase that will be used to animate the tail;
	 */
	public float[] chainWaveBufferArray(int partLength, float maxAngle, int bufferTime, float angleDecrement, float divider, EntityLivingBase entity) 
	{
		float[] rotations = new float[partLength];
		
		if (entity.rotationPitch != entity.prevRotationPitch && MathHelper.abs(this.pitchVariation) < maxAngle)
			this.pitchVariation += (entity.prevRotationPitch - entity.rotationPitch) / divider;
		
		if (this.pitchVariation > 0.7F * angleDecrement) 
		{
			if (this.pitchTimer > bufferTime) 
			{
				this.pitchVariation -= angleDecrement;
				if (MathHelper.abs(this.pitchVariation) < angleDecrement) 
				{
					this.pitchVariation = 0.0F;
					this.pitchTimer = 0;
				}
				else
				{
					this.pitchTimer++;
				}
			}
		} 
		else if (this.pitchVariation < -0.7F * angleDecrement) 
		{
			if (this.pitchTimer > bufferTime) 
			{
				this.pitchVariation += angleDecrement;
				if (MathHelper.abs(this.pitchVariation) < angleDecrement) 
				{
					this.pitchVariation = 0.0F;
					this.pitchTimer = 0;
				}
			}
			else
			{
				this.pitchTimer++;
			}
		}
		
		for (int i = 0; i < rotations.length; i++)
			rotations[i] += 0.01745329251F * this.yawVariation / (1 + i);

		return rotations;
	}
}
