package net.ilexiconn.jurassicraft.client.model.modelbase;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.util.MathHelper;

@SideOnly(Side.CLIENT)
public class MowzieModelBase extends ModelBase
{
	//Store every MowzieModelRenderer in this array
	protected MowzieModelRenderer[] parts;
	
	//Call this at the end of the constructor. It will make the parts remember what the default pose is.
	protected void setInitPose() {
		 for(int i = 0; i < parts.length; i++) parts[i].setInitValuesToCurrentPose();
	}
	
	//Call this at the beginning of setRotationAngles. It will restore the parts to their default pose, which is important for animating.
	protected void setToInitPose() {
		 for(int i = 0; i < parts.length; i++) parts[i].setCurrentPoseToInitValues();
	}
	
	//This parenting method calculates the relative positions and rotations for you!
	//When parenting a chain of boxes, (such as a head to a neck to a body) start at the end of the chain (parent the head to the neck before parenting the neck to the body).
	//Sometimes this method will not calculate the new position properly (I have no idea why). In this case, simply make corrections and adjustments to the rotation point after calling this method.
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
    
    //Don't use this yet. I'm trying to refine the parenting method, but it's not ready.
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

    //This method rotates a box to face whatever the entity is looking at.
    //"Divider" is the number of boxes being used. (i.e. if you are using this on a head and neck, set it to 2. Just a head, 1.)
    //Keep f3 and f4 as f3 and f4 respectively.
    public void faceTarget(MowzieModelRenderer box, int divider, float f3, float f4)
    {
        box.rotateAngleY += (f3 / (180f / (float) Math.PI)) / divider;
        box.rotateAngleX += (f4 / (180f / (float) Math.PI)) / divider;
    }

    //This method rotates a box back and forth.
    //Speed is how fast the animation plays. Degree is how far it will rotate. Invert will make the box rotate the other way. Offset will offset the timing of the animation. Weight will make the animation favor one direction more based on how fast the mob is moving.
    //Keep f and f1 as f and f1 respectively.
    public void walk(MowzieModelRenderer box, float speed, float degree, boolean invert, float offset, float weight, float f, float f1)
    {
        int inverted = 1;
        if (invert) inverted = -1;
        box.rotateAngleX += MathHelper.cos(f * speed + offset) * degree * inverted * f1 + weight * f1;
    }

    //This method rotates a box up and down.
    //Speed is how fast the animation plays. Degree is how far it will rotate. Invert will make the box rotate the other way. Offset will offset the timing of the animation. Weight will make the animation favor one direction more based on how fast the mob is moving.
    //Keep f and f1 as f and f1 respectively.
    public void flap(MowzieModelRenderer box, float speed, float degree, boolean invert, float offset, float weight, float f, float f1)
    {
        int inverted = 1;
        if (invert) inverted = -1;
        box.rotateAngleZ += MathHelper.cos(f * speed + offset) * degree * inverted * f1 + weight * f1;
    }

    //This method moves a box up and down.
    //Speed is how fast the animation plays. Degree is how far it will move. Bounce will make the box, well... bounce.
    //Keep f and f1 as f and f1 respectively.
    public void bob(MowzieModelRenderer box, float speed, float degree, boolean bounce, float f, float f1)
    {
        float bob = (float) (Math.sin(f * speed) * f1 * degree - f1 * degree);
        if (bounce) bob = (float) -Math.abs((Math.sin(f * speed) * f1 * degree));
        box.rotationPointY += bob;
    }

    //This method swings a chain of parented boxes back and forth.
    //Speed is how fast the animation plays. Degree is how much it will swing. RootOffset changes the delay between boxes (try values from 0 to 5 or so until you like the effect).
    //Keep f and f1 as f and f1 respectively.
    public void chainSwing(MowzieModelRenderer[] boxes, float speed, float degree, double rootOffset, float f, float f1)
    {
        int numberOfSegments = boxes.length;
        float offset = (float) ((rootOffset * Math.PI) / (2 * numberOfSegments));
        for (int i = 0; i < numberOfSegments; i++)
            boxes[i].rotateAngleY += MathHelper.cos(f * speed + offset * i) * f1 * degree;
    }

    //This method swings a chain of parented boxes up and down.
    //Speed is how fast the animation plays. Degree is how much it will swing. RootOffset changes the delay between boxes (try values from 0 to 5 or so until you like the effect).
    //Keep f and f1 as f and f1 respectively.
    public void chainWave(MowzieModelRenderer[] boxes, float speed, float degree, double rootOffset, float f, float f1)
    {
        int numberOfSegments = boxes.length;
        float offset = (float) ((rootOffset * Math.PI) / (2 * numberOfSegments));
        for (int i = 0; i < numberOfSegments; i++)
            boxes[i].rotateAngleX += MathHelper.cos(f * speed + offset * i) * f1 * degree;
    }
}