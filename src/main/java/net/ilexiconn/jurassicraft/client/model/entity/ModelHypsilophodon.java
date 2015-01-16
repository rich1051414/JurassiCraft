package net.ilexiconn.jurassicraft.client.model.entity;

import net.ilexiconn.jurassicraft.client.model.animation.Animator;
import net.ilexiconn.jurassicraft.client.model.modelbase.MowzieModelBase;
import net.ilexiconn.jurassicraft.client.model.modelbase.MowzieModelRenderer;
import net.ilexiconn.jurassicraft.entity.dinosaurs.EntityHypsilophodon;
import net.ilexiconn.jurassicraft.interfaces.IAnimatedEntity;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelHypsilophodon extends MowzieModelBase
{
    private Animator animator;
    MowzieModelRenderer body1;
    MowzieModelRenderer neck;
    MowzieModelRenderer head;
    MowzieModelRenderer mouthtop;
    MowzieModelRenderer upperlegright;
    MowzieModelRenderer upperlegleft;
    MowzieModelRenderer midlegright;
    MowzieModelRenderer midlegleft;
    MowzieModelRenderer lowerlegright;
    MowzieModelRenderer lowerlegleft;
    MowzieModelRenderer feetleft;
    MowzieModelRenderer feetright;
    MowzieModelRenderer shoulderleft;
    MowzieModelRenderer armleft;
    MowzieModelRenderer shoulderright;
    MowzieModelRenderer armright;
    MowzieModelRenderer body2;
    MowzieModelRenderer tail2;
    MowzieModelRenderer tail1;
    MowzieModelRenderer tail3;
    MowzieModelRenderer HeadJoint;
    MowzieModelRenderer[] tailParts;

    public ModelHypsilophodon()
    {
        textureWidth = 128;
        textureHeight = 64;

        animator = new Animator(this);

        body1 = new MowzieModelRenderer(this, 0, 32);
        body1.addBox(-2.5F, -2.5F, -5F, 5, 5, 5);
        body1.setRotationPoint(0F, 13.7F, -1F);
        body1.setTextureSize(128, 64);
        body1.mirror = true;
        setRotation(body1, 0F, 0F, 0F);
        neck = new MowzieModelRenderer(this, 20, 0);
        neck.addBox(-1.5F, -1F, -4F, 3, 3, 7);
        neck.setRotationPoint(0F, 11.7F, -6.7F);
        neck.setTextureSize(128, 64);
        neck.mirror = true;
        setRotation(neck, -0.7769283F, 0F, 0F);
        head = new MowzieModelRenderer(this, 0, 0);
        head.addBox(-2F, -0.4F, -4F, 4, 4, 4);
        head.setRotationPoint(0F, 8.5F, -8.8F);
        head.setTextureSize(128, 64);
        head.mirror = true;
        setRotation(head, 0F, 0F, 0F);
        mouthtop = new MowzieModelRenderer(this, 0, 16);
        mouthtop.addBox(-1.5F, 0F, -3F, 3, 3, 3);
        mouthtop.setRotationPoint(0F, 8.7F, -12.3F);
        mouthtop.setTextureSize(128, 64);
        mouthtop.mirror = true;
        setRotation(mouthtop, 0.5576792F, 0F, 0F);
        upperlegright = new MowzieModelRenderer(this, 35, 35);
        upperlegright.addBox(-2F, 0F, 0F, 2, 6, 3);
        upperlegright.setRotationPoint(-2.5F, 13F, 3F);
        upperlegright.setTextureSize(128, 64);
        upperlegright.mirror = true;
        setRotation(upperlegright, -0.5948606F, 0F, 0F);
        upperlegleft = new MowzieModelRenderer(this, 35, 35);
        upperlegleft.addBox(0F, 0F, 0F, 2, 6, 3);
        upperlegleft.setRotationPoint(2.5F, 13F, 3F);
        upperlegleft.setTextureSize(128, 64);
        upperlegleft.mirror = true;
        setRotation(upperlegleft, -0.5948578F, 0F, 0F);
        midlegright = new MowzieModelRenderer(this, 12, 20);
        midlegright.addBox(-1F, 0F, 0F, 2, 4, 2);
        midlegright.setRotationPoint(-3.5F, 19F, 1F);
        midlegright.setTextureSize(128, 64);
        midlegright.mirror = true;
        setRotation(midlegright, 1F, 0F, 0F);
        midlegleft = new MowzieModelRenderer(this, 12, 20);
        midlegleft.addBox(-1F, 0F, 0F, 2, 4, 2);
        midlegleft.setRotationPoint(3.5F, 19F, 1F);
        midlegleft.setTextureSize(128, 64);
        midlegleft.mirror = true;
        setRotation(midlegleft, 1F, 0F, 0F);
        lowerlegright = new MowzieModelRenderer(this, 0, 25);
        lowerlegright.addBox(-0.5F, 0F, 0F, 1, 4, 1);
        lowerlegright.setRotationPoint(-3.5F, 20F, 4F);
        lowerlegright.setTextureSize(128, 64);
        lowerlegright.mirror = true;
        setRotation(lowerlegright, -0.4461411F, 0F, 0F);
        lowerlegleft = new MowzieModelRenderer(this, 0, 25);
        lowerlegleft.addBox(-0.5F, 0F, 0F, 1, 4, 1);
        lowerlegleft.setRotationPoint(3.5F, 20F, 4F);
        lowerlegleft.setTextureSize(128, 64);
        lowerlegleft.mirror = true;
        setRotation(lowerlegleft, -0.4461433F, 0F, 0F);
        feetleft = new MowzieModelRenderer(this, 25, 25);
        feetleft.addBox(-1F, 0F, -3F, 2, 1, 4);
        feetleft.setRotationPoint(3.5F, 23F, 3.2F);
        feetleft.setTextureSize(128, 64);
        feetleft.mirror = true;
        setRotation(feetleft, 0F, 0F, 0F);
        feetright = new MowzieModelRenderer(this, 25, 25);
        feetright.addBox(-1F, 0F, -3F, 2, 1, 4);
        feetright.setRotationPoint(-3.5F, 23F, 3.2F);
        feetright.setTextureSize(128, 64);
        feetright.mirror = true;
        setRotation(feetright, 0F, 0F, 0F);
        shoulderleft = new MowzieModelRenderer(this, 50, 0);
        shoulderleft.addBox(0F, 0F, 0F, 1, 3, 1);
        shoulderleft.setRotationPoint(2.5F, 15F, -5.5F);
        shoulderleft.setTextureSize(128, 64);
        shoulderleft.mirror = true;
        setRotation(shoulderleft, 0.4089647F, 0F, 0F);
        armleft = new MowzieModelRenderer(this, 50, 22);
        armleft.addBox(-0.5F, 0F, 0F, 1, 3, 1);
        armleft.setRotationPoint(3F, 16.5F, -4F);
        armleft.setTextureSize(128, 64);
        armleft.mirror = true;
        setRotation(armleft, -1F, 0F, 0F);
        shoulderright = new MowzieModelRenderer(this, 50, 0);
        shoulderright.addBox(-1F, 0F, 0F, 1, 3, 1);
        shoulderright.setRotationPoint(-2.5F, 15F, -5.5F);
        shoulderright.setTextureSize(128, 64);
        shoulderright.mirror = true;
        setRotation(shoulderright, 0.4089656F, 0F, 0F);
        armright = new MowzieModelRenderer(this, 50, 22);
        armright.addBox(-0.5F, 0F, 0F, 1, 3, 1);
        armright.setRotationPoint(-3F, 16.5F, -4F);
        armright.setTextureSize(128, 64);
        armright.mirror = true;
        setRotation(armright, -1F, 0F, 0F);
        body2 = new MowzieModelRenderer(this, 0, 50);
        body2.addBox(-2.5F, -2F, -4F, 5, 6, 7);
        body2.setRotationPoint(0F, 13F, 3F);
        body2.setTextureSize(128, 64);
        body2.mirror = true;
        setRotation(body2, 0F, 0F, 0F);
        tail2 = new MowzieModelRenderer(this, 48, 0);
        tail2.addBox(-1.5F, 0F, 0F, 3, 3, 7);
        tail2.setRotationPoint(0F, 11.9F, 10F);
        tail2.setTextureSize(128, 64);
        tail2.mirror = true;
        setRotation(tail2, -0.0743572F, 0F, 0F);
        tail1 = new MowzieModelRenderer(this, 50, 50);
        tail1.addBox(-2F, 0F, 0F, 4, 4, 5);
        tail1.setRotationPoint(0F, 11F, 6F);
        tail1.setTextureSize(128, 64);
        tail1.mirror = true;
        setRotation(tail1, -0.1115358F, 0F, 0F);
        tail3 = new MowzieModelRenderer(this, 48, 12);
        tail3.addBox(-1F, 0F, 0F, 2, 2, 7);
        tail3.setRotationPoint(0F, 12.8F, 16F);
        tail3.setTextureSize(128, 64);
        tail3.mirror = true;
        setRotation(tail3, 0F, 0F, 0F);
        HeadJoint = new MowzieModelRenderer(this, 0, 0);
        HeadJoint.addBox(0F, 0F, 0F, 0, 0, 0);
        HeadJoint.setRotationPoint(0F, 8.5F, -8.8F);
        HeadJoint.setTextureSize(256, 256);
        HeadJoint.mirror = true;
        setRotation(HeadJoint, 0F, 0F, 0F);

        addChildTo(feetleft, lowerlegleft);
        addChildTo(lowerlegleft, midlegleft);
        addChildTo(midlegleft, upperlegleft);

        addChildTo(feetright, lowerlegright);
        addChildTo(lowerlegright, midlegright);
        addChildTo(midlegright, upperlegright);

        addChildTo(mouthtop, head);
        addChildTo(head, HeadJoint);
        addChildTo(HeadJoint, neck);
        addChildTo(neck, body1);

        addChildTo(armleft, shoulderleft);
        addChildTo(armright, shoulderright);
        addChildTo(shoulderleft, body1);
        addChildTo(shoulderright, body1);
        addChildTo(body1, body2);
        addChildTo(tail3, tail2);
        addChildTo(tail2, tail1);
        addChildTo(tail1, body2);

        //Corrections
        neck.setRotationPoint(0, -2, -5F);
        HeadJoint.rotationPointZ -= 7.5;
        HeadJoint.rotationPointY -= 1.5;
        head.setRotationPoint(0, 0, 0);
        body1.rotationPointZ += 0.3;
        tail1.rotationPointZ += 5.5;
        tail1.rotationPointY -= 4;

		tailParts = new MowzieModelRenderer[] { this.tail3, this.tail2, this.tail1 };
        
        body1.setInitValuesToCurrentPose();
        neck.setInitValuesToCurrentPose();
        head.setInitValuesToCurrentPose();
        mouthtop.setInitValuesToCurrentPose();
        upperlegright.setInitValuesToCurrentPose();
        upperlegleft.setInitValuesToCurrentPose();
        midlegright.setInitValuesToCurrentPose();
        midlegleft.setInitValuesToCurrentPose();
        lowerlegright.setInitValuesToCurrentPose();
        lowerlegleft.setInitValuesToCurrentPose();
        feetleft.setInitValuesToCurrentPose();
        feetright.setInitValuesToCurrentPose();
        shoulderleft.setInitValuesToCurrentPose();
        armleft.setInitValuesToCurrentPose();
        shoulderright.setInitValuesToCurrentPose();
        armright.setInitValuesToCurrentPose();
        body2.setInitValuesToCurrentPose();
        tail2.setInitValuesToCurrentPose();
        tail1.setInitValuesToCurrentPose();
        tail3.setInitValuesToCurrentPose();
        HeadJoint.setInitValuesToCurrentPose();
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        animate((IAnimatedEntity) entity, f, f1, f2, f3, f4, f5);
        //   body1.render(f5);
        //    neck.render(f5);
        //    head.render(f5);
        //    mouthtop.render(f5);
        upperlegright.render(f5);
        upperlegleft.render(f5);
        //    midlegright.render(f5);
        //    midlegleft.render(f5);
        //    lowerlegright.render(f5);
        //    lowerlegleft.render(f5);
        //    feetleft.render(f5);
        //    feetright.render(f5);
        //    shoulderleft.render(f5);
        //    armleft.render(f5);
        //    shoulderright.render(f5);
        //    armright.render(f5);
        body2.render(f5);
        //    tail2.render(f5);
        //    tail1.render(f5);
        //    tail3.render(f5);
    }

    private void resetPose()
    {
        body1.setCurrentPoseToInitValues();
        neck.setCurrentPoseToInitValues();
        head.setCurrentPoseToInitValues();
        mouthtop.setCurrentPoseToInitValues();
        upperlegright.setCurrentPoseToInitValues();
        upperlegleft.setCurrentPoseToInitValues();
        midlegright.setCurrentPoseToInitValues();
        midlegleft.setCurrentPoseToInitValues();
        lowerlegright.setCurrentPoseToInitValues();
        lowerlegleft.setCurrentPoseToInitValues();
        feetleft.setCurrentPoseToInitValues();
        feetright.setCurrentPoseToInitValues();
        shoulderleft.setCurrentPoseToInitValues();
        armleft.setCurrentPoseToInitValues();
        shoulderright.setCurrentPoseToInitValues();
        armright.setCurrentPoseToInitValues();
        body2.setCurrentPoseToInitValues();
        tail2.setCurrentPoseToInitValues();
        tail1.setCurrentPoseToInitValues();
        tail3.setCurrentPoseToInitValues();
        HeadJoint.setCurrentPoseToInitValues();
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, EntityHypsilophodon hypster)
    {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, null);
		/*
		 * f = hypster.frame;
		 * f1 = (float) Math.cos(f/20)*0.25F + 0.5F;
		 */
        resetPose();
        float scaleFactor = 0.6F;
        float height = 12F * f1;

        faceTarget(head, 1, f3, f4);

        bob(body2, 0.5F * scaleFactor, height, true, f, f1);
        bob(upperlegright, 0.5F * scaleFactor, height, true, f, f1);
        bob(upperlegleft, 0.5F * scaleFactor, height, true, f, f1);

        walk(upperlegleft, 1F * scaleFactor, 0.75F, true, 1F, 0.25F, f, f1);
        walk(upperlegright, 1F * scaleFactor, 0.75F, true, 0.5F, 0.25F, f, f1);
        walk(midlegleft, 1F * scaleFactor, 0.75F, false, 1.5F, 0F, f, f1);
        walk(midlegright, 1F * scaleFactor, 0.75F, false, 1F, 0F, f, f1);
        walk(lowerlegright, 1F * scaleFactor, 0.75F, true, 0.5F, 0F, f, f1);
        walk(lowerlegleft, 1F * scaleFactor, 0.75F, true, 1F, 0F, f, f1);
        walk(feetleft, 1F * scaleFactor, 0.5F, true, 1F, 0.75F, f, f1);
        walk(feetright, 1F * scaleFactor, 0.5F, true, 0.5F, 0.75F, f, f1);

        walk(body2, 1F * scaleFactor, 0.3F, false, 0.5F, 0F, f, f1);
        walk(body1, 1F * scaleFactor, 0.5F, true, 1.0F, 0F, f, f1);
        walk(neck, 1F * scaleFactor, 0.3F, true, 0.25F, 0.3F, f, f1);
        walk(head, 1F * scaleFactor, 0.3F, false, 0.25F, -0.3F, f, f1);

        walk(shoulderright, 1 * scaleFactor, 0.3F, true, 1, 0.2F, f, f1);
        walk(shoulderleft, 1 * scaleFactor, 0.3F, true, 1, 0.2F, f, f1);
        walk(armright, 1 * scaleFactor, 0.3F, false, 1, -0.2F, f, f1);
        walk(armleft, 1 * scaleFactor, 0.3F, false, 1, -0.2F, f, f1);

        chainWave(tailParts, 0.2F, -0.05F, 2, hypster.frame, 1F);
        walk(neck, 0.2F, 0.1F, false, -1F, 0F, hypster.frame, 1F);
        walk(head, 0.2F, 0.1F, true, 0F, 0F, hypster.frame, 1F);
        walk(body1, 0.2F, 0.1F, true, 0F, 0F, hypster.frame, 1F);
        walk(body2, 0.2F, 0.1F, false, 0F, 0F, hypster.frame, 1F);
        walk(shoulderright, 0.2F, 0.1F, true, 0F, 0F, hypster.frame, 1F);
        walk(shoulderleft, 0.2F, 0.1F, true, 0F, 0F, hypster.frame, 1F);
        walk(armright, 0.2F, 0.1F, false, 0F, 0F, hypster.frame, 1F);
        walk(armleft, 0.2F, 0.1F, false, 0F, 0F, hypster.frame, 1F);

        chainWave(tailParts, 1F * scaleFactor, 0.15F, 2, f, f1);
        
        hypster.tailBuffer.applyChainSwingBuffer(tailParts);
    }

    public void animate(IAnimatedEntity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        animator.update(entity);
        setRotationAngles(f, f1, f2, f3, f4, f5, (EntityHypsilophodon) entity);
        EntityHypsilophodon hysilophodon = (EntityHypsilophodon) entity;

        animator.setAnimation(1);
        animator.startPhase(5);
        animator.rotate(neck, 0.9F, -0.4F, 0);
        animator.rotate(head, -0.8F, -0.25F, 0.7F);
        animator.rotate(shoulderleft, -2.6F, 0, 0);
        animator.rotate(armleft, 0.5F, 0, 0);
        animator.endPhase();
        animator.startPhase(2);
        animator.rotate(neck, 0.9F, -0.35F, 0);
        animator.rotate(head, -0.8F, -0.15F, 0.7F);
        animator.rotate(shoulderleft, -0.5F, 0, 0);
        animator.rotate(armleft, -0.5F, 0, 0);
        animator.endPhase();
        animator.startPhase(3);
        animator.rotate(neck, 0.9F, -0.4F, 0);
        animator.rotate(head, -0.8F, -0.25F, 0.7F);
        animator.rotate(shoulderleft, -2.6F, 0, 0);
        animator.rotate(armleft, 0.5F, 0, 0);
        animator.endPhase();
        animator.startPhase(2);
        animator.rotate(neck, 0.9F, -0.35F, 0);
        animator.rotate(head, -0.8F, -0.15F, 0.7F);
        animator.rotate(shoulderleft, -0.5F, 0, 0);
        animator.rotate(armleft, -0.5F, 0, 0);
        animator.endPhase();
        animator.startPhase(3);
        animator.rotate(neck, 0.9F, -0.4F, 0);
        animator.rotate(head, -0.8F, -0.25F, 0.7F);
        animator.rotate(shoulderleft, -2.6F, 0, 0);
        animator.rotate(armleft, 0.5F, 0, 0);
        animator.endPhase();
        animator.startPhase(2);
        animator.rotate(neck, 0.9F, -0.35F, 0);
        animator.rotate(head, -0.8F, -0.15F, 0.7F);
        animator.rotate(shoulderleft, -0.5F, 0, 0);
        animator.rotate(armleft, -0.5F, 0, 0);
        animator.endPhase();
        animator.startPhase(3);
        animator.rotate(neck, 0.9F, -0.4F, 0);
        animator.rotate(head, -0.8F, -0.25F, 0.7F);
        animator.rotate(shoulderleft, -2.6F, 0, 0);
        animator.rotate(armleft, 0.5F, 0, 0);
        animator.endPhase();
        animator.startPhase(2);
        animator.rotate(neck, 0.9F, -0.35F, 0);
        animator.rotate(head, -0.8F, -0.15F, 0.7F);
        animator.rotate(shoulderleft, -0.5F, 0, 0);
        animator.rotate(armleft, -0.5F, 0, 0);
        animator.endPhase();
        animator.startPhase(3);
        animator.rotate(neck, 0.9F, -0.4F, 0);
        animator.rotate(head, -0.8F, -0.25F, 0.7F);
        animator.rotate(shoulderleft, -2.6F, 0, 0);
        animator.rotate(armleft, 0.5F, 0, 0);
        animator.endPhase();
        animator.startPhase(2);
        animator.rotate(neck, 0.9F, -0.35F, 0);
        animator.rotate(head, -0.8F, -0.15F, 0.7F);
        animator.rotate(shoulderleft, -0.5F, 0, 0);
        animator.rotate(armleft, -0.5F, 0, 0);
        animator.endPhase();
        animator.startPhase(3);
        animator.rotate(neck, 0.9F, -0.4F, 0);
        animator.rotate(head, -0.8F, -0.25F, 0.7F);
        animator.rotate(shoulderleft, -2.6F, 0, 0);
        animator.rotate(armleft, 0.5F, 0, 0);
        animator.endPhase();
        animator.resetPhase(5);
    }
}
