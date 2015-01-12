package net.ilexiconn.jurassicraft.client.model.modelbase;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class MowzieModelBase extends ModelBase 
{
	/** Store every MowzieModelRenderer in this array */
	protected MowzieModelRenderer[] parts;
	/** Used to delay the tail animation when the entity rotates. */
	protected int yawTimer;
	/** Rotation amount (rotateY) of the tail buffer. Added when the entity rotates. */
	protected float yawVariation;
	/** Used to delay the tail animation when the entity rotates. */
	protected int pitchTimer;
	/** Rotation amount (rotateY) of the tail buffer. Added when the entity rotates. */
	protected float pitchVariation;

	/**
	 * Saves the initial rotate angles and initial rotation points.
	 * Note: Call this at the end of the constructor.
	 */
	protected void setInitPose() 
	{
		for (int i = 0; i < this.parts.length; i++)
			this.parts[i].setInitValuesToCurrentPose();
	}

	/**
	 * Resets the rotate angles and rotation points to its original value if they were saved before. 
	 * Note: Call this at the beginning of setRotationAngles.
	 * 
	 * @see setInitPose() method in MowzieModelBase class.
	 */
	protected void setToInitPose() 
	{
		for (int i = 0; i < this.parts.length; i++)
			this.parts[i].setCurrentPoseToInitValues();
	}

	/**
	 * Calculates the relative positions and rotations easily.
	 * 
	 * Note: When parenting a chain of boxes, such as a head to a neck to a
	 * body, the end of the chain should start first. In this case the head
	 * should be parented to the neck before parenting the neck to the body.
	 * 
	 * Some corrections and adjustments to the rotation point may be needed.
	 * 
	 * @param child is the child box;
	 * @param parent is the parent box.
	 */
	protected void addChildTo(ModelRenderer child, ModelRenderer parent) 
	{
		float distance = (float) Math.sqrt(Math.pow((child.rotationPointZ - parent.rotationPointZ), 2) + Math.pow((child.rotationPointY - parent.rotationPointY), 2));
		float oldRotateAngleX = parent.rotateAngleX;
		float parentToChildAngle = (float) Math.atan((child.rotationPointZ - parent.rotationPointZ) / (child.rotationPointY - parent.rotationPointY));
		float childRelativeRotation = parentToChildAngle - parent.rotateAngleX;
		float newRotationPointY = (float) (distance * (Math.cos(childRelativeRotation)));
		float newRotationPointZ = (float) (distance * (Math.sin(childRelativeRotation)));
		parent.rotateAngleX = 0F;
		child.setRotationPoint(child.rotationPointX - parent.rotationPointX, newRotationPointY, newRotationPointZ);
		parent.addChild(child);
		parent.rotateAngleX = oldRotateAngleX;
		child.rotateAngleX -= parent.rotateAngleX;
		child.rotateAngleY -= parent.rotateAngleY;
		child.rotateAngleZ -= parent.rotateAngleZ;
	}

	/**
	 * Don't use this yet. I'm trying to refine the parenting method, but it's not ready yet.
	 */
	protected void newAddChildTo(ModelRenderer child, ModelRenderer parent) 
	{
		float distance = (float) Math.sqrt(Math.pow((child.rotationPointZ - parent.rotationPointZ), 2) + Math.pow((child.rotationPointY - parent.rotationPointY), 2));
		float angle = (float) Math.atan2(child.rotationPointY - parent.rotationPointY, child.rotationPointZ - parent.rotationPointZ);
		float newRotationPointZ = (float) (distance * (Math.cos(angle)));
		float newRotationPointY = (float) (distance * (Math.sin(angle)));
		parent.addChild(child);
		child.rotateAngleX -= parent.rotateAngleX;
		child.rotateAngleY -= parent.rotateAngleY;
		child.rotateAngleZ -= parent.rotateAngleZ;
	}
	
	/**
	 * Rotates a box to face where the entity is looking.
	 * 
	 * Note: Just keep f3 and f4 from the setRotationAngles() method.
	 * 
	 * @param divider is the number of boxes being used. (i.e. if you are 
	 * using this on a head and neck, set it to 2. Just a head, 1);
	 * @param f3 is the rotationYaw of the EntityLivingBase;
	 * @param f4 is the rotationPitch of the EntityLivingBase.
	 */
	public void faceTarget(MowzieModelRenderer box, int divider, float f3, float f4) 
	{
		box.rotateAngleY += (f3 / (180f / (float) Math.PI)) / divider;
		box.rotateAngleX += (f4 / (180f / (float) Math.PI)) / divider;
	}

	/**
	 * Rotates a box back and forth (rotateAngleX). Useful for arms and legs.
	 * 
	 * Note: Just keep f and f1 from the setRotationAngles() method.
	 * 
	 * @param box is the ModelRenderer to be animated;
	 * @param speed is how fast the animation runs;
	 * @param degree is how far the box will rotate;
	 * @param invert will invert the rotation;
	 * @param offset will offset the timing of the animation;
	 * @param weight will make the animation favor one direction 
	 * more based on how fast the mob is moving;
	 * @param f is the walked distance;
	 * @param f1 is the walk speed.
	 */
	public void walk(MowzieModelRenderer box, float speed, float degree, boolean invert, float offset, float weight, float f, float f1) 
	{
		int inverted = 1;
		if (invert)
			inverted = -1;
		box.rotateAngleX += MathHelper.cos(f * speed + offset) * degree * inverted * f1 + weight * f1;
	}
	
	/**
	 * Rotates a box up and down (rotateAngleZ). Useful for wings and ears.
	 * 
	 * Note: Just keep f and f1 from the setRotationAngles() method.
	 * 
	 * @param box is the ModelRenderer to be animated;
	 * @param speed is how fast the animation runs;
	 * @param degree is how far the box will rotate;
	 * @param invert will invert the rotation;
	 * @param offset will offset the timing of the animation;
	 * @param weight will make the animation favor one direction 
	 * more based on how fast the mob is moving;
	 * @param f is the walked distance;
	 * @param f1 is the walk speed.
	 */
	public void flap(MowzieModelRenderer box, float speed, float degree, boolean invert, float offset, float weight, float f, float f1) 
	{
		int inverted = 1;
		if (invert)
			inverted = -1;
		box.rotateAngleZ += MathHelper.cos(f * speed + offset) * degree * inverted * f1 + weight * f1;
	}
	
	/**
	 * Moves a box up and down (rotationPointY). Useful for bodies.
	 * 
	 * Note: Just keep f and f1 from the setRotationAngles() method.
	 * 
	 * @param box is the ModelRenderer to be animated;
	 * @param speed is how fast the animation runs;
	 * @param degree is how far the box will move;
	 * @param bounce will make the box bounce;
	 * @param f is the walked distance;
	 * @param f1 is the walk speed.
	 */
	public void bob(MowzieModelRenderer box, float speed, float degree, boolean bounce, float f, float f1) 
	{
		float bob = (float) (Math.sin(f * speed) * f1 * degree - f1 * degree);
		if (bounce)
			bob = (float) -Math.abs((Math.sin(f * speed) * f1 * degree));
		box.rotationPointY += bob;
	}

	/**
	 * Swings a chain of parented boxes back and forth (rotateAngleY). Useful for tails.
	 * 
	 * Note: Just keep f and f1 from the setRotationAngles() method.
	 * 
	 * @param boxes are the ModelRenderers to be animated;
	 * @param speed is how fast the animation runs;
	 * @param degree is how far the box will move;
	 * @param rootOffset changes the delay between boxes. 
	 * Try values from 0.0D to 5.0D or so until you like the effect;
	 * @param f is the walked distance;
	 * @param f1 is the walk speed.
	 */
	public void chainSwing(MowzieModelRenderer[] boxes, float speed, float degree, double rootOffset, float f, float f1) 
	{
		int numberOfSegments = boxes.length;
		float offset = (float) ((rootOffset * Math.PI) / (2 * numberOfSegments));
		for (int i = 0; i < numberOfSegments; i++)
			boxes[i].rotateAngleY += MathHelper.cos(f * speed + offset * i) * f1 * degree;
	}

	/**
	 * Swings a chain of parented boxes up and down (rotateAngleX). Useful for tails.
	 * 
	 * Note: Just keep f and f1 from the setRotationAngles() method.
	 * 
	 * @param boxes are the ModelRenderers to be animated;
	 * @param speed is how fast the animation runs;
	 * @param degree is how far the box will move;
	 * @param rootOffset changes the delay between boxes. 
	 * Try values from 0.0D to 5.0D or so until you like the effect;
	 * @param f is the walked distance;
	 * @param f1 is the walk speed.
	 */
	public void chainWave(MowzieModelRenderer[] boxes, float speed, float degree, double rootOffset, float f, float f1) 
	{
		int numberOfSegments = boxes.length;
		float offset = (float) ((rootOffset * Math.PI) / (2 * numberOfSegments));
		for (int i = 0; i < numberOfSegments; i++)
			boxes[i].rotateAngleX += MathHelper.cos(f * speed + offset * i) * f1 * degree;
	}
	
	/**
	 * Adds a specific rotation to a chain of parented boxes based on the entity movement (rotateAngleY).
	 * 
	 * @param boxes are the ModelRenderers to be animated;
	 * @param maxAngle is the maximum angle that the tail can have. 
	 * Try values about 60.0F to 90.0F degrees;
	 * @param bufferTime is the number of ticks necessary to start reducing the tail angle. 
	 * Try values about 20 to 60 ticks;
	 * @param angleDecrement is the amount of angle that will be reduced each tick. 
	 * Try values about 3.0F degrees;
	 * @param divider reduces the amount of angle added to the buffer. 
	 * Try values about 5.0F.
	 * @param entity is the EntityLivingBase that will be used to animate the tail;
	 */
	public void chainSwingBuffer(MowzieModelRenderer[] boxes, float maxAngle, int bufferTime, float angleDecrement, float divider, EntityLivingBase entity) 
	{
		if (entity.renderYawOffset != entity.prevRenderYawOffset && MathHelper.abs(this.yawVariation) < maxAngle) 
		{
			this.yawVariation += (entity.prevRenderYawOffset - entity.renderYawOffset) / divider;
		}
		if (this.yawVariation > 0.7F * angleDecrement) 
		{
			this.yawTimer++;
			if (this.yawTimer > bufferTime) 
			{
				this.yawVariation -= angleDecrement;
				if (MathHelper.abs(this.yawVariation) < angleDecrement) 
				{
					this.yawVariation = 0.0F;
					this.yawTimer = 0;
				}
			}
		} else if (this.yawVariation < -0.7F * angleDecrement) 
		{
			this.yawTimer++;
			if (this.yawTimer > bufferTime) 
			{
				this.yawVariation += angleDecrement;
				if (MathHelper.abs(this.yawVariation) < angleDecrement) 
				{
					this.yawVariation = 0.0F;
					this.yawTimer = 0;
				}
			}
		}
		for (int i = 0; i < boxes.length; i++) 
		{
			boxes[i].rotateAngleY += 0.01745329251F * this.yawVariation / (boxes.length - i);
		}
	}
	
	/**
	 * Adds a specific rotation to a chain of parented boxes based on the entity movement (rotateAngleX).
	 * 
	 * @param boxes are the ModelRenderers to be animated;
	 * @param maxAngle is the maximum angle that the tail can have. 
	 * Try values about 60.0F to 90.0F degrees;
	 * @param bufferTime is the number of ticks necessary to start reducing the tail angle. 
	 * Try values about 20 to 60 ticks;
	 * @param angleDecrement is the amount of angle that will be reduced each tick. 
	 * Try values about 3.0F degrees;
	 * @param divider reduces the amount of angle added to the buffer. 
	 * Try values about 5.0F.
	 * @param entity is the EntityLivingBase that will be used to animate the tail;
	 */
	public void chainWaveBuffer(MowzieModelRenderer[] boxes, float maxAngle, int bufferTime, float angleDecrement, float divider, EntityLivingBase entity) 
	{
		if (entity.rotationPitch != entity.prevRotationPitch && MathHelper.abs(this.pitchVariation) < maxAngle) 
		{
			this.pitchVariation += (entity.prevRotationPitch - entity.rotationPitch) / divider;
		}
		if (this.pitchVariation > 0.7F * angleDecrement) 
		{
			this.pitchTimer++;
			if (this.pitchTimer > bufferTime) 
			{
				this.pitchVariation -= angleDecrement;
				if (MathHelper.abs(this.pitchVariation) < angleDecrement) 
				{
					this.pitchVariation = 0.0F;
					this.pitchTimer = 0;
				}
			}
		} else if (this.pitchVariation < -0.7F * angleDecrement) 
		{
			this.pitchTimer++;
			if (this.pitchTimer > bufferTime) 
			{
				this.pitchVariation += angleDecrement;
				if (MathHelper.abs(this.pitchVariation) < angleDecrement) 
				{
					this.pitchVariation = 0.0F;
					this.pitchTimer = 0;
				}
			}
		}
		for (int i = 0; i < boxes.length; i++) 
		{
			boxes[i].rotateAngleY += 0.01745329251F * this.yawVariation / (1+ i);
		}
	}
}
