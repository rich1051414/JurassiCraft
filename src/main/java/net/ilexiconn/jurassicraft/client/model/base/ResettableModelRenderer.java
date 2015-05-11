package net.ilexiconn.jurassicraft.client.model.base;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

public class ResettableModelRenderer extends ModelRenderer
{
    public float firstRotateAngleX;
    public float firstRotateAngleY;
    public float firstRotateAngleZ;
    public float firstRotationPointX;
    public float firstRotationPointY;
    public float firstRotationPointZ;
    public float firstOffsetX;
    public float firstOffsetY;
    public float firstOffsetZ;

    public ResettableModelRenderer(ModelBase modelBase, int par1, int par2)
    {
        super(modelBase, par1, par2);
    }

    public void savefirstParameters()
    {
        firstRotationPointX = this.rotationPointX;
        firstRotationPointY = this.rotationPointY;
        firstRotationPointZ = this.rotationPointZ;
        firstRotateAngleX = this.rotateAngleX;
        firstRotateAngleY = this.rotateAngleY;
        firstRotateAngleZ = this.rotateAngleZ;
        firstOffsetX = this.offsetX;
        firstOffsetY = this.offsetY;
        firstOffsetZ = this.offsetZ;
    }

    /**
     * Resets all parameters.
     */
    public void resetAllParameters()
    {
        this.rotationPointX = this.firstRotationPointX;
        this.rotationPointY = this.firstRotationPointY;
        this.rotationPointZ = this.firstRotationPointZ;
        this.rotateAngleX = this.firstRotateAngleX;
        this.rotateAngleY = this.firstRotateAngleY;
        this.rotateAngleZ = this.firstRotateAngleZ;
        this.offsetX = this.firstOffsetX;
        this.offsetY = this.firstOffsetY;
        this.offsetZ = this.firstOffsetZ;
    }

    /**
     * Resets all rotation points.
     */
    public void resetAllRotationPoints()
    {
        this.rotationPointX = this.firstRotationPointX;
        this.rotationPointY = this.firstRotationPointY;
        this.rotationPointZ = this.firstRotationPointZ;
    }

    /**
     * Resets X rotation point.
     */
    public void resetXRotationPoints()
    {
        this.rotationPointX = this.firstRotationPointX;
    }

    /**
     * Resets Y rotation point.
     */
    public void resetYRotationPoints()
    {
        this.rotationPointY = this.firstRotationPointY;
    }

    /**
     * Resets Z rotation point.
     */
    public void resetZRotationPoints()
    {
        this.rotationPointZ = this.firstRotationPointZ;
    }

    /**
     * Resets all rotations.
     */
    public void resetAllRotations()
    {
        this.rotateAngleX = this.firstRotateAngleX;
        this.rotateAngleY = this.firstRotateAngleY;
        this.rotateAngleZ = this.firstRotateAngleZ;
    }

    /**
     * Resets X rotation.
     */
    public void resetXRotations()
    {
        this.rotateAngleX = this.firstRotateAngleX;
    }

    /**
     * Resets Y rotation.
     */
    public void resetYRotations()
    {
        this.rotateAngleY = this.firstRotateAngleY;
    }

    /**
     * Resets Z rotation.
     */
    public void resetZRotations()
    {
        this.rotateAngleZ = this.firstRotateAngleZ;
    }

    /**
     * Resets all offsets.
     */
    public void resetAllOffsets()
    {
        this.offsetX = this.firstOffsetX;
        this.offsetY = this.firstOffsetY;
        this.offsetZ = this.firstOffsetZ;
    }

    /**
     * Resets X offset.
     */
    public void resetXOffsets()
    {
        this.offsetX = this.firstOffsetX;
    }

    /**
     * Resets Y offset.
     */
    public void resetYOffsets()
    {
        this.offsetY = this.firstOffsetY;
    }

    /**
     * Resets Z offset.
     */
    public void resetZOffsets()
    {
        this.offsetZ = this.firstOffsetZ;
    }

    /**
     * Copies all rotation points.
     */
    public void copyAllRotationPoints(ResettableModelRenderer target)
    {
        this.rotationPointX = target.rotationPointX;
        this.rotationPointY = target.rotationPointY;
        this.rotationPointZ = target.rotationPointZ;
    }

    /**
     * Copies X rotation points.
     */
    public void copyXRotationPoint(ResettableModelRenderer target)
    {
        this.rotationPointX = target.rotationPointX;
    }

    /**
     * Copies Y rotation points.
     */
    public void copyYRotationPoint(ResettableModelRenderer target)
    {
        this.rotationPointY = target.rotationPointY;
    }

    /**
     * Copies Z rotation points.
     */
    public void copyZRotationPoint(ResettableModelRenderer target)
    {
        this.rotationPointZ = target.rotationPointZ;
    }

    /**
     * Pins a leg in the plane YZ. The angle used should be rotationX.
     */
    public void pinLegPlaneYZ(ResettableModelRenderer parentBox, float radius, float rotationX)
    {
        this.rotationPointY = parentBox.rotationPointY + radius * (float) Math.cos(rotationX);
        this.rotationPointZ = parentBox.rotationPointZ + radius * (float) Math.sin(rotationX);
    }

    /**
     * Pins a tail in the plane YZ. The angle used should be rotationX.
     */
    public void pinTailPlaneYZ(ResettableModelRenderer parentBox, float radius, float rotationX)
    {
        this.rotationPointY = parentBox.rotationPointY + radius * (float) Math.cos(rotationX + Math.PI / 2);
        this.rotationPointZ = parentBox.rotationPointZ + radius * (float) Math.sin(rotationX + Math.PI / 2);
    }

    /**
     * Calculates the distance between two origins ignoring the X rotation
     * point.
     */
    public float calculateDistanceYZ(ResettableModelRenderer target)
    {
        return (float) Math.sqrt(Math.pow((target.firstRotationPointY - this.firstRotationPointY), 2) + Math.pow((target.firstRotationPointZ - this.firstRotationPointZ), 2));
    }

    /**
     * Calculates the distance between two origins.
     */
    public float calculateRadius(ResettableModelRenderer target)
    {
        return (float) Math.sqrt(Math.pow((target.firstRotationPointX - this.firstRotationPointX), 2) + Math.pow((target.firstRotationPointY - this.firstRotationPointY), 2) + Math.pow((target.firstRotationPointZ - this.firstRotationPointZ), 2));
    }
}