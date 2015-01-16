package net.ilexiconn.jurassicraft.client.model.modelbase;

import net.minecraft.client.Minecraft;
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
	private int yawTimer;
	/** Rotation amount (rotateY) of the tail buffer. Added when the entity rotates. */
	private float yawVariation;
	/** Used to delay the tail animation when the entity rotates. */
	private int pitchTimer;
	/** Rotation amount (rotateY) of the tail buffer. Added when the entity rotates. */
	private float pitchVariation;

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
	 * @param f is the number of boxes being used. (i.e. if you are 
	 * using this on a head and neck, set it to 2. Just a head, 1);
	 * @param f3 is the rotationYaw of the EntityLivingBase;
	 * @param f4 is the rotationPitch of the EntityLivingBase.
	 */
	public void faceTarget(MowzieModelRenderer box, float f, float f3, float f4) 
	{
		box.rotateAngleY += (f3 / (180f / (float) Math.PI)) / f;
		box.rotateAngleX += (f4 / (180f / (float) Math.PI)) / f;
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
}
