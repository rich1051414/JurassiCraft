package net.ilexiconn.jurassicraft.client.model.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.ilexiconn.jurassicraft.client.model.modelbase.MowzieModelBase;
import net.ilexiconn.jurassicraft.client.model.modelbase.MowzieModelRenderer;
import net.ilexiconn.jurassicraft.entity.dinosaurs.EntityTyrannosaurus;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;
import thehippomaster.AnimationAPI.IAnimatedEntity;
import thehippomaster.AnimationAPI.client.Animator;

@SideOnly(Side.CLIENT)
public class ModelTyrannosaurus extends MowzieModelBase
{
    int mouthCounter = 0;

    private Animator animator;

    MowzieModelRenderer Left_Calf_1;
    MowzieModelRenderer Right_Calf_1;
    MowzieModelRenderer Left_Thigh;
    MowzieModelRenderer Right_Thigh;
    MowzieModelRenderer Body_1;
    MowzieModelRenderer Body_2;
    MowzieModelRenderer Neck;
    MowzieModelRenderer Head;
    MowzieModelRenderer Upper_Jaw;
    MowzieModelRenderer Lower_Jaw;
    MowzieModelRenderer Tail_1;
    MowzieModelRenderer Tail_2;
    MowzieModelRenderer Tail_3;
    MowzieModelRenderer Tail_4;
    MowzieModelRenderer Tail_5;
    MowzieModelRenderer Lower_Arm_Left;
    MowzieModelRenderer Lower_Arm_Right;
    MowzieModelRenderer Hand_Left;
    MowzieModelRenderer Hand_Right;
    MowzieModelRenderer Hand_Left_Claw_Left;
    MowzieModelRenderer Hand_Left_Claw_Right;
    MowzieModelRenderer Hand_Right_Claw_Right;
    MowzieModelRenderer Hand_Right_Claw_Left;
    MowzieModelRenderer Left_Calf_2;
    MowzieModelRenderer Right_Calf_2;
    MowzieModelRenderer Foot_Left;
    MowzieModelRenderer Foot_Right;
    MowzieModelRenderer headJoint;
    MowzieModelRenderer NeckJoint;
    MowzieModelRenderer Teeth;

    public ModelTyrannosaurus()
    {
        animator = new Animator(this);

        textureWidth = 256;
        textureHeight = 256;

        Left_Calf_1 = new MowzieModelRenderer(this, 65, 80);
        Left_Calf_1.addBox(-2F, 0F, 0F, 4, 8, 4);
        Left_Calf_1.setRotationPoint(7F, 13F, 3F);
        Left_Calf_1.setTextureSize(256, 256);
        setRotation(Left_Calf_1, 0.7063936F, 0F, 0F);
        Right_Calf_1 = new MowzieModelRenderer(this, 65, 80);
        Right_Calf_1.addBox(-2F, 0F, 0F, 4, 8, 4);
        Right_Calf_1.setRotationPoint(-7F, 13.5F, 3F);
        Right_Calf_1.setTextureSize(256, 256);
        setRotation(Right_Calf_1, 0.7063936F, 0F, 0F);
        Left_Thigh = new MowzieModelRenderer(this, 28, 58);
        Left_Thigh.addBox(0F, 0F, -11F, 5, 6, 11);
        Left_Thigh.setRotationPoint(4.5F, 3F, 8F);
        Left_Thigh.setTextureSize(256, 256);
        setRotation(Left_Thigh, 0.8179294F, 0F, 0F);
        Right_Thigh = new MowzieModelRenderer(this, 28, 75);
        Right_Thigh.addBox(-5F, 0F, -11F, 5, 6, 11);
        Right_Thigh.setRotationPoint(-4.5F, 3F, 7.6F);
        Right_Thigh.setTextureSize(256, 256);
        setRotation(Right_Thigh, 0.8179294F, 0F, 0F);
        Body_1 = new MowzieModelRenderer(this, 118, 0);
        Body_1.addBox(-5F, 0F, -15F, 10, 12, 21);
        Body_1.setRotationPoint(0F, -1F, 8F);
        Body_1.setTextureSize(256, 256);
        setRotation(Body_1, -0.0371786F, 0F, 0F);
        Body_2 = new MowzieModelRenderer(this, 183, 1);
        Body_2.addBox(-4F, 0F, 0F, 8, 12, 7);
        Body_2.setRotationPoint(0F, -2F, -9F);
        Body_2.setTextureSize(256, 256);
        Body_2.mirror = true;
        setRotation(Body_2, -0.1858931F, 0F, 0F);
        Neck = new MowzieModelRenderer(this, 218, 1);
        Neck.addBox(-3.5F, 0.5F, -9F, 7, 9, 11);
        Neck.setRotationPoint(0F, -0.7F, -10.6F);
        Neck.setTextureSize(256, 256);
        Neck.mirror = true;
        setRotation(Neck, -0.5576792F, 0F, 0F);
        Head = new MowzieModelRenderer(this, 0, 92);
        Head.addBox(-4F, 0F, -8F, 8, 9, 8);
        Head.setRotationPoint(0F, -5F, -13.5F);
        Head.setTextureSize(256, 256);
        setRotation(Head, 0F, 0F, 0F);
        Upper_Jaw = new MowzieModelRenderer(this, 0, 120);
        Upper_Jaw.addBox(-3.5F, 0F, 0F, 7, 6, 9);
        Upper_Jaw.setRotationPoint(0F, 1.8F, -20F);
        Upper_Jaw.setTextureSize(256, 256);
        setRotation(Upper_Jaw, -3.141593F, 0F, 0F);
        Lower_Jaw = new MowzieModelRenderer(this, 71, 27);
        Lower_Jaw.addBox(-2.5F, 0F, 0F, 5, 2, 8);
        Lower_Jaw.setRotationPoint(0F, 3.5F, -20F);
        Lower_Jaw.setTextureSize(256, 256);
        setRotation(Lower_Jaw, -3F/*-2.881342F*/, 0F, 0F);
        Tail_1 = new MowzieModelRenderer(this, 118, 39);
        Tail_1.addBox(-4.5F, 0F, 0F, 9, 9, 10);
        Tail_1.setRotationPoint(0F, -0.2F, 11F);
        Tail_1.setTextureSize(256, 256);
        setRotation(Tail_1, -0.1115358F, 0F, 0F);
        Tail_2 = new MowzieModelRenderer(this, 118, 61);
        Tail_2.addBox(-4F, 0F, 0F, 8, 7, 8);
        Tail_2.setRotationPoint(0F, 1.5F, 19F);
        Tail_2.setTextureSize(256, 256);
        setRotation(Tail_2, -0.0743572F, 0F, 0F);
        Tail_3 = new MowzieModelRenderer(this, 118, 122);
        Tail_3.addBox(-3F, 0F, 0F, 6, 6, 8);
        Tail_3.setRotationPoint(0F, 2.5F, 24F);
        Tail_3.setTextureSize(256, 256);
        setRotation(Tail_3, -0.0371786F, 0F, 0F);
        Tail_4 = new MowzieModelRenderer(this, 118, 80);
        Tail_4.addBox(-2F, 0F, 0F, 4, 5, 9);
        Tail_4.setRotationPoint(0F, 3.3F, 29F);
        Tail_4.setTextureSize(256, 256);
        setRotation(Tail_4, 0F, 0F, 0F);
        Tail_5 = new MowzieModelRenderer(this, 118, 100);
        Tail_5.addBox(-1.5F, 0F, 0F, 3, 4, 11);
        Tail_5.setRotationPoint(0F, 3.8F, 35F);
        Tail_5.setTextureSize(256, 256);
        setRotation(Tail_5, 0.0371786F, 0F, 0F);
        Lower_Arm_Left = new MowzieModelRenderer(this, 0, 68);
        Lower_Arm_Left.addBox(0F, 0F, 0F, 2, 5, 2);
        Lower_Arm_Left.setRotationPoint(5F, 8F, -6F);
        Lower_Arm_Left.setTextureSize(256, 256);
        setRotation(Lower_Arm_Left, -0.6320364F, 0F, 0F);
        Lower_Arm_Right = new MowzieModelRenderer(this, 0, 68);
        Lower_Arm_Right.addBox(-2F, 0F, 0F, 2, 5, 2);
        Lower_Arm_Right.setRotationPoint(-5F, 8F, -6F);
        Lower_Arm_Right.setTextureSize(256, 256);
        setRotation(Lower_Arm_Right, -0.6320364F, 0F, 0F);
        Hand_Left = new MowzieModelRenderer(this, 81, 54);
        Hand_Left.addBox(0F, 0F, -1F, 1, 2, 2);
        Hand_Left.setRotationPoint(6F, 12F, -8.7F);
        Hand_Left.setTextureSize(256, 256);
        Hand_Left.mirror = true;
        setRotation(Hand_Left, 0F, 1.169371F, 0F);
        Hand_Right = new MowzieModelRenderer(this, 81, 54);
        Hand_Right.addBox(-1F, 0F, -1F, 1, 2, 2);
        Hand_Right.setRotationPoint(-6F, 12F, -8.7F);
        Hand_Right.setTextureSize(256, 256);
        Hand_Right.mirror = true;
        setRotation(Hand_Right, 0F, -1.169371F, 0F);
        Hand_Left_Claw_Left = new MowzieModelRenderer(this, 81, 45);
        Hand_Left_Claw_Left.addBox(-0.2F, 1F, -0.5F, 1, 2, 1);
        Hand_Left_Claw_Left.setRotationPoint(6F, 12F, -8.7F);
        Hand_Left_Claw_Left.setTextureSize(256, 256);
        Hand_Left_Claw_Left.mirror = true;
        setRotation(Hand_Left_Claw_Left, 0.4363323F, 1.169371F, 0F);
        Hand_Left_Claw_Right = new MowzieModelRenderer(this, 81, 45);
        Hand_Left_Claw_Right.addBox(-0.2F, 1F, -0.5F, 1, 2, 1);
        Hand_Left_Claw_Right.setRotationPoint(6F, 12F, -8.7F);
        Hand_Left_Claw_Right.setTextureSize(256, 256);
        Hand_Left_Claw_Right.mirror = true;
        setRotation(Hand_Left_Claw_Right, -0.4363323F, 1.169371F, 0F);
        Hand_Right_Claw_Right = new MowzieModelRenderer(this, 81, 45);
        Hand_Right_Claw_Right.addBox(-0.8F, 1F, -0.5F, 1, 2, 1);
        Hand_Right_Claw_Right.setRotationPoint(-6F, 12F, -8.7F);
        Hand_Right_Claw_Right.setTextureSize(256, 256);
        Hand_Right_Claw_Right.mirror = true;
        setRotation(Hand_Right_Claw_Right, 0.4363323F, -1.169371F, 0F);
        Hand_Right_Claw_Left = new MowzieModelRenderer(this, 81, 45);
        Hand_Right_Claw_Left.addBox(-0.8F, 1F, -0.5F, 1, 2, 1);
        Hand_Right_Claw_Left.setRotationPoint(-6F, 12F, -8.7F);
        Hand_Right_Claw_Left.setTextureSize(256, 256);
        Hand_Right_Claw_Left.mirror = true;
        setRotation(Hand_Right_Claw_Left, -0.4363323F, -1.169371F, 0F);
        Left_Calf_2 = new MowzieModelRenderer(this, 65, 0);
        Left_Calf_2.addBox(-2F, 0F, 0F, 3, 9, 3);
        Left_Calf_2.setRotationPoint(7.5F, 15.2F, 8.4F);
        Left_Calf_2.setTextureSize(256, 256);
        setRotation(Left_Calf_2, -0.5576792F, 0F, 0F);
        Right_Calf_2 = new MowzieModelRenderer(this, 65, 0);
        Right_Calf_2.addBox(-1F, 0F, 0F, 3, 8, 3);
        Right_Calf_2.setRotationPoint(-7.5F, 15.2F, 8.4F);
        Right_Calf_2.setTextureSize(256, 256);
        setRotation(Right_Calf_2, -0.5576792F, 0F, 0F);
        Foot_Left = new MowzieModelRenderer(this, 0, 0);
        Foot_Left.addBox(-2.5F, 0F, -4F, 5, 2, 7);
        Foot_Left.setRotationPoint(7F, 22F, 5F);
        Foot_Left.setTextureSize(256, 256);
        setRotation(Foot_Left, 0F, 0F, 0F);
        Foot_Right = new MowzieModelRenderer(this, 0, 0);
        Foot_Right.addBox(-2.5F, 0F, -4F, 5, 2, 7);
        Foot_Right.setRotationPoint(-7F, 22F, 5F);
        Foot_Right.setTextureSize(256, 256);
        setRotation(Foot_Right, 0F, 0F, 0F);
        headJoint = new MowzieModelRenderer(this, 0, 0);
        headJoint.addBox(0F, 0F, 0F, 0, 0, 0);
        headJoint.setRotationPoint(0F, -5F, -13.5F);
        headJoint.setTextureSize(256, 256);
        setRotation(headJoint, 0F, 0F, 0F);
        NeckJoint = new MowzieModelRenderer(this, 218, 1);
        NeckJoint.addBox(0F, 0F, 0F, 0, 0, 0);
        NeckJoint.setRotationPoint(0F, -5F, -10.5F);
        NeckJoint.setTextureSize(256, 256);
        setRotation(NeckJoint, 0F, 0F, 0F);
        Teeth = new MowzieModelRenderer(this, 53, 120);
        Teeth.addBox(-3.5F, -1F, 0F, 7, 1, 9);
        Teeth.setRotationPoint(0F, 1.8F, -25F);
        Teeth.setTextureSize(256, 256);
        Teeth.mirror = true;
        setRotation(Teeth, -3.141593F, 0F, 0F);

        addChildTo(Teeth, Upper_Jaw);
        addChildTo(Upper_Jaw, Head);
        addChildTo(Lower_Jaw, Head);
 /*       addChildTo(Head, headJoint);
        addChildTo(headJoint, Neck);
        addChildTo(Neck, NeckJoint);
        addChildTo(NeckJoint, Body_2);*/
        addChildTo(Head, Neck);
        addChildTo(Neck, Body_2);
        addChildTo(Body_2, Body_1);

        addChildTo(Hand_Left_Claw_Left, Hand_Left);
        addChildTo(Hand_Left_Claw_Right, Hand_Left);
        addChildTo(Hand_Left, Lower_Arm_Left);
        addChildTo(Lower_Arm_Left, Body_1);

        addChildTo(Hand_Right_Claw_Left, Hand_Right);
        addChildTo(Hand_Right_Claw_Right, Hand_Right);
        addChildTo(Hand_Right, Lower_Arm_Right);
        addChildTo(Lower_Arm_Right, Body_1);

        addChildTo(this.Foot_Left, this.Left_Calf_2);
        addChildTo(this.Left_Calf_2, this.Left_Calf_1);
        addChildTo(this.Left_Calf_1, this.Left_Thigh);

        addChildTo(this.Foot_Right, this.Right_Calf_2);
        addChildTo(this.Right_Calf_2, this.Right_Calf_1);
        addChildTo(this.Right_Calf_1, this.Right_Thigh);

        addChildTo(this.Tail_5, this.Tail_4);
        addChildTo(this.Tail_4, this.Tail_3);
        addChildTo(this.Tail_3, this.Tail_2);
        addChildTo(this.Tail_2, this.Tail_1);
        addChildTo(this.Tail_1, this.Body_1);

        //Corrections
        //        Head.setRotationPoint(0, 0, 0);
        //        NeckJoint.setRotationPoint(0, -2, -3);
        //        Neck.setRotationPoint(0, 0, 0);
        Neck.setRotationPoint(0, 1F, 2);
        Head.rotationPointZ -= 13;
        Head.rotationPointY -= 2;
        Teeth.rotationPointZ -= 5;
        Body_2.rotationPointY -= 1;
        Body_2.rotationPointZ -= 34;
        Hand_Right_Claw_Right.setRotationPoint(0, 0, 0);
        Hand_Left_Claw_Right.setRotationPoint(0, 0, 0);
        Hand_Right_Claw_Left.setRotationPoint(0, 0, 0);
        Hand_Left_Claw_Left.setRotationPoint(0, 0, 0);
        Hand_Left.rotateAngleZ += 0.5;
        Hand_Right.rotateAngleZ -= 0.5;

        Left_Calf_1.setInitValuesToCurrentPose();
        Right_Calf_1.setInitValuesToCurrentPose();
        Left_Thigh.setInitValuesToCurrentPose();
        Right_Thigh.setInitValuesToCurrentPose();
        Body_1.setInitValuesToCurrentPose();
        Body_2.setInitValuesToCurrentPose();
        Neck.setInitValuesToCurrentPose();
        Head.setInitValuesToCurrentPose();
        Upper_Jaw.setInitValuesToCurrentPose();
        Lower_Jaw.setInitValuesToCurrentPose();
        Tail_1.setInitValuesToCurrentPose();
        Tail_2.setInitValuesToCurrentPose();
        Tail_3.setInitValuesToCurrentPose();
        Tail_4.setInitValuesToCurrentPose();
        Tail_5.setInitValuesToCurrentPose();
        Lower_Arm_Left.setInitValuesToCurrentPose();
        Lower_Arm_Right.setInitValuesToCurrentPose();
        Hand_Left.setInitValuesToCurrentPose();
        Hand_Right.setInitValuesToCurrentPose();
        Hand_Left_Claw_Left.setInitValuesToCurrentPose();
        Hand_Left_Claw_Right.setInitValuesToCurrentPose();
        Hand_Right_Claw_Right.setInitValuesToCurrentPose();
        Hand_Right_Claw_Left.setInitValuesToCurrentPose();
        Left_Calf_2.setInitValuesToCurrentPose();
        Right_Calf_2.setInitValuesToCurrentPose();
        Foot_Left.setInitValuesToCurrentPose();
        Foot_Right.setInitValuesToCurrentPose();
        headJoint.setInitValuesToCurrentPose();
        NeckJoint.setInitValuesToCurrentPose();
        Teeth.setInitValuesToCurrentPose();
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        animate((IAnimatedEntity) entity, f, f1, f2, f3, f4, f5);
        if (isChild)
        {
            float var8 = 2.0F;
            GL11.glPushMatrix();
            GL11.glTranslatef(0.0F, 5.0F * f5, 2.0F * f5);
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glScalef(1.0F / var8, 1.0F / var8, 1.0F / var8);
            GL11.glTranslatef(0.0F, 24.0F * f5, 0.0F);
            Left_Calf_1.render(f5);
            Right_Calf_1.render(f5);
            Left_Thigh.render(f5);
            Right_Thigh.render(f5);
            Body_1.render(f5);
            //           Body_2.render(f5);
            //           Neck.render(f5);
            Lower_Arm_Left.render(f5);
            Lower_Arm_Right.render(f5);
            GL11.glPopMatrix();
        }
        else
        {
            Left_Thigh.render(f5);
            Right_Thigh.render(f5);
            Body_1.render(f5);
            //            Body_2.render(f5);
            //            Neck.render(f5);
            //            Lower_Arm_Left.render(f5);
            //            Lower_Arm_Right.render(f5);
            //            Hand_Left.render(f5);
            //            Hand_Right.render(f5);
            //            Hand_Left_Claw_Left.render(f5);
            //            Hand_Left_Claw_Right.render(f5);
            //            Hand_Right_Claw_Right.render(f5);
            //            Hand_Right_Claw_Left.render(f5);
        }
    }

    private void setRotation(MowzieModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    private void resetPose()
    {
        Left_Calf_1.setCurrentPoseToInitValues();
        Right_Calf_1.setCurrentPoseToInitValues();
        Left_Thigh.setCurrentPoseToInitValues();
        Right_Thigh.setCurrentPoseToInitValues();
        Body_1.setCurrentPoseToInitValues();
        Body_2.setCurrentPoseToInitValues();
        Neck.setCurrentPoseToInitValues();
        Head.setCurrentPoseToInitValues();
        Upper_Jaw.setCurrentPoseToInitValues();
        Lower_Jaw.setCurrentPoseToInitValues();
        Tail_1.setCurrentPoseToInitValues();
        Tail_2.setCurrentPoseToInitValues();
        Tail_3.setCurrentPoseToInitValues();
        Tail_4.setCurrentPoseToInitValues();
        Tail_5.setCurrentPoseToInitValues();
        Lower_Arm_Left.setCurrentPoseToInitValues();
        Lower_Arm_Right.setCurrentPoseToInitValues();
        Hand_Left.setCurrentPoseToInitValues();
        Hand_Right.setCurrentPoseToInitValues();
        Hand_Left_Claw_Left.setCurrentPoseToInitValues();
        Hand_Left_Claw_Right.setCurrentPoseToInitValues();
        Hand_Right_Claw_Right.setCurrentPoseToInitValues();
        Hand_Right_Claw_Left.setCurrentPoseToInitValues();
        Left_Calf_2.setCurrentPoseToInitValues();
        Right_Calf_2.setCurrentPoseToInitValues();
        Foot_Left.setCurrentPoseToInitValues();
        Foot_Right.setCurrentPoseToInitValues();
        headJoint.setCurrentPoseToInitValues();
        NeckJoint.setCurrentPoseToInitValues();
        Teeth.setCurrentPoseToInitValues();
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
    {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        resetPose();
        EntityTyrannosaurus trex = (EntityTyrannosaurus) entity;
 /*   	f = trex.frame;
        f1 = (float) Math.cos(f/20)*0.25F + 0.5F;*/
        float scaleFactor = 0.5F;
        float height = 1.5F * f1;
        faceTarget(Head, 2, f3, f4);
        faceTarget(Neck, 2, f3, f4);
        bob(Body_1, 1F * scaleFactor, height, false, f, f1);
        bob(Left_Thigh, 1F * scaleFactor, height, false, f, f1);
        bob(Right_Thigh, 1F * scaleFactor, height, false, f, f1);
        walk(Body_1, 1F * scaleFactor, height / 10, true, 0F, 0.15F, f, f1);
        walk(Body_2, 1F * scaleFactor, height / 20, true, -0.5F, 0F, f, f1);
        walk(Neck, 1F * scaleFactor, height / 20, true, -1F, 0.5F, f, f1);
        walk(Head, 1F * scaleFactor, height / 10F, false, 0.5F, -0.2F, f, f1);

        walk(Lower_Arm_Right, 1F * scaleFactor, height / 5, true, -1F, -0.5F, f, f1);
        walk(Lower_Arm_Left, 1F * scaleFactor, height / 5, true, -1F, -0.5F, f, f1);

        walk(Left_Thigh, 0.5F * scaleFactor, 0.5F, false, 0F, 0.7F, f, f1);
        walk(Left_Calf_1, 0.5F * scaleFactor, 0.3F, true, 1.5F, 0F, f, f1);
        walk(Left_Calf_2, 0.5F * scaleFactor, 0.7F, false, 0.5F, -0.4F, f, f1);
        walk(Foot_Left, 0.5F * scaleFactor, 1F, true, 0.5F, 0.5F, f, f1);

        walk(Right_Thigh, 0.5F * scaleFactor, 0.5F, true, 0F, 0.7F, f, f1);
        walk(Right_Calf_1, 0.5F * scaleFactor, 0.3F, false, 1.5F, 0F, f, f1);
        walk(Right_Calf_2, 0.5F * scaleFactor, 0.7F, true, 0.5F, -0.4F, f, f1);
        walk(Foot_Right, 0.5F * scaleFactor, 1F, false, 0.5F, 0.5F, f, f1);

        MowzieModelRenderer[] tailParts = {this.Tail_5, this.Tail_4, this.Tail_3, this.Tail_2, this.Tail_1};
        chainWave(tailParts, 1F * scaleFactor, 0.07F, 2, f, f1);

        //Idling
        walk(Neck, 0.1F, 0.07F, false, -1F, 0F, trex.frame, 1F);
        walk(Head, 0.1F, 0.07F, true, 0F, 0F, trex.frame, 1F);
        walk(Body_1, 0.1F, 0.05F, false, 0F, 0F, trex.frame, 1F);
        walk(Lower_Arm_Right, 0.1F, 0.07F, false, -1F, 0F, trex.frame, 1F);
        walk(Lower_Arm_Left, 0.1F, 0.07F, false, -1F, 0F, trex.frame, 1F);

        tailSwing(tailParts, 0.1F, 0.05F, 1, trex.frame);
        chainWave(tailParts, 0.1F, -0.05F, 2, trex.frame, 1F);

        //Specialized animations
        Head.rotateAngleZ += Math.cos(trex.frame / 3) * trex.roarTiltDegree.value / 3;
        Lower_Jaw.rotateAngleX += Math.cos(trex.frame) * trex.roarTiltDegree.value / 7;

        Neck.rotateAngleX += trex.roarCount.value * 0.4;
        Head.rotateAngleX -= trex.roarCount.value * 0.7;
        Head.rotationPointZ += trex.roarCount.value * 0.7;
        Lower_Jaw.rotateAngleX += trex.roarCount.value * 0.5;
    }

    public void animate(IAnimatedEntity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        animator.update(entity);
        setRotationAngles(f, f1, f2, f3, f4, f5, (Entity) entity);
        //        EntityTyrannosaurus trex = (EntityTyrannosaurus) entity;

        animator.setAnimation(1);
        animator.startPhase(15);
        animator.move(Body_1, 0, -3, -5);
        animator.move(Right_Thigh, 0, -3, -5);
        animator.move(Left_Thigh, 0, -3, -5);
        animator.rotate(Body_1, -0.3F, 0, 0);
        animator.rotate(Head, 0.3F, 0, 0);
        animator.rotate(Right_Thigh, 0.3F, 0, 0);
        animator.rotate(Right_Calf_1, -0.4F, 0, 0);
        animator.rotate(Right_Calf_2, 0.4F, 0, 0);
        animator.rotate(Foot_Right, -0.3F, 0, 0);
        animator.rotate(Left_Thigh, -0.7F, 0, 0);
        animator.rotate(Left_Calf_1, 0.7F, 0, 0);
        animator.rotate(Left_Calf_2, -0.5F, 0, 0);
        animator.rotate(Foot_Left, 0.7F, 0, 0);
        animator.endPhase();
        animator.startPhase(10);
        animator.move(Body_1, 0, 3, -10);
        animator.move(Right_Thigh, 0, 3, -10);
        animator.move(Left_Thigh, 0, 3, -10);
        animator.move(Head, 0, 1, 2);
        animator.move(Lower_Jaw, 0, 0, 1);
        animator.rotate(Body_1, 0.2F, 0, 0);
        animator.rotate(Neck, 0.5F, 0, 0);
        animator.rotate(Head, -0.9F, 0, 0);
        animator.rotate(Lower_Jaw, 0.9F, 0, 0);
        animator.rotate(Right_Thigh, 0.6F, 0, 0);
        animator.rotate(Right_Calf_1, 0.2F, 0, 0);
        animator.rotate(Right_Calf_2, -0.4F, 0, 0);
        animator.rotate(Foot_Right, -0.4F, 0, 0);
        animator.rotate(Left_Thigh, -0.3F, 0, 0);
        animator.rotate(Left_Calf_1, 0.2F, 0, 0);
        animator.rotate(Left_Calf_2, -0.2F, 0, 0);
        animator.rotate(Foot_Left, 0.3F, 0, 0);
        animator.endPhase();
        animator.setStationaryPhase(35);
        animator.resetPhase(15);
    }
}
