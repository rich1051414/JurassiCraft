// Date: 12.06.2014 20:21:55
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX


package net.ilexiconn.jurassicraft.client.model.entity;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.ilexiconn.jurassicraft.entity.dinosaurs.EntityHerrerasaur;
import net.ilexiconn.jurassicraft.client.model.modelbase.MowzieModelBase;
import net.ilexiconn.jurassicraft.client.model.modelbase.MowzieModelRenderer;

public class ModelHerrerasaur extends MowzieModelBase
{
    //fields
    MowzieModelRenderer Left_Upper_Foot;
    MowzieModelRenderer Right_Upper_Foot;
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
    MowzieModelRenderer Tail_6;
    MowzieModelRenderer Upper_Arm_Right;
    MowzieModelRenderer Upper_Arm_Left;
    MowzieModelRenderer Lower_Arm_Left;
    MowzieModelRenderer Lower_Arm_Right;
    MowzieModelRenderer Hand_Left;
    MowzieModelRenderer Hand_Right;
    MowzieModelRenderer Hand_Left_Claw_Left;
    MowzieModelRenderer Hand_Left_Claw_Right;
    MowzieModelRenderer Hand_Left_Claw_Middle;
    MowzieModelRenderer Hand_Right_Claw_Right;
    MowzieModelRenderer Hand_Right_Claw_Left;
    MowzieModelRenderer Hand_Right_Claw_Middle;
    MowzieModelRenderer Foot_Left;
    MowzieModelRenderer Foot_Right;

    public ModelHerrerasaur()
    {
        textureWidth = 256;
        textureHeight = 256;

        Left_Upper_Foot = new MowzieModelRenderer(this, 68, 0);
        Left_Upper_Foot.addBox(-1F, 0F, -2F, 2, 7, 2);
        Left_Upper_Foot.setRotationPoint(6F, 18F, 4F);
        Left_Upper_Foot.setTextureSize(256, 256);
        Left_Upper_Foot.mirror = true;
        setRotation(Left_Upper_Foot, -0.6283185F, 0F, 0F);
        Right_Upper_Foot = new MowzieModelRenderer(this, 68, 0);
        Right_Upper_Foot.addBox(-1F, 0F, -2F, 2, 7, 2);
        Right_Upper_Foot.setRotationPoint(-6F, 18F, 4F);
        Right_Upper_Foot.setTextureSize(256, 256);
        Right_Upper_Foot.mirror = true;
        setRotation(Right_Upper_Foot, -0.6283185F, 0F, 0F);
        Left_Calf_1 = new MowzieModelRenderer(this, 65, 0);
        Left_Calf_1.addBox(-1.5F, 0F, 0F, 3, 10, 3);
        Left_Calf_1.setRotationPoint(6F, 12.5F, -4.5F);
        Left_Calf_1.setTextureSize(256, 256);
        Left_Calf_1.mirror = true;
        setRotation(Left_Calf_1, 0.7063936F, 0F, 0F);
        Right_Calf_1 = new MowzieModelRenderer(this, 65, 0);
        Right_Calf_1.addBox(-1.5F, 0F, 0F, 3, 10, 3);
        Right_Calf_1.setRotationPoint(-6F, 12.5F, -4.5F);
        Right_Calf_1.setTextureSize(256, 256);
        Right_Calf_1.mirror = true;
        setRotation(Right_Calf_1, 0.7238469F, 0F, 0F);
        Left_Thigh = new MowzieModelRenderer(this, 27, 57);
        Left_Thigh.addBox(0F, 0F, -12F, 5, 5, 12);
        Left_Thigh.setRotationPoint(3.5F, 3F, 2.4F);
        Left_Thigh.setTextureSize(256, 256);
        Left_Thigh.mirror = true;
        setRotation(Left_Thigh, 0.8231159F, 0F, 0F);
        Right_Thigh = new MowzieModelRenderer(this, 27, 57);
        Right_Thigh.addBox(-5F, 0F, -12F, 5, 5, 12);
        Right_Thigh.setRotationPoint(-3.5F, 3F, 2.4F);
        Right_Thigh.setTextureSize(256, 256);
        Right_Thigh.mirror = true;
        setRotation(Right_Thigh, 0.8231159F, 0F, 0F);
        Body_1 = new MowzieModelRenderer(this, 118, 0);
        Body_1.addBox(-4.5F, -5F, -13.5F, 9, 10, 21);
        Body_1.setRotationPoint(0F, 5.5F, 0F);
        Body_1.setTextureSize(256, 256);
        Body_1.mirror = true;
        setRotation(Body_1, -0.0248833F, 0F, 0F);
        Body_2 = new MowzieModelRenderer(this, 182, 0);
        Body_2.addBox(-4F, 0F, -4F, 8, 9, 4);
        Body_2.setRotationPoint(0F, 0.7F, -12.5F);
        Body_2.setTextureSize(256, 256);
        Body_2.mirror = true;
        setRotation(Body_2, 0.1458569F, 0F, 0F);
        Neck = new MowzieModelRenderer(this, 217, 0);
        Neck.addBox(-2.5F, 0F, -13F, 5, 6, 13);
        Neck.setRotationPoint(0F, 2F, -10.5F);
        Neck.setTextureSize(256, 256);
        Neck.mirror = true;
        setRotation(Neck, 0.0589777F, 0F, 0F);
        Head = new MowzieModelRenderer(this, 0, 92);
        Head.addBox(-3.5F, -1F, -6F, 7, 7, 6);
        Head.setRotationPoint(0F, 3F, -22.5F);
        Head.setTextureSize(256, 256);
        Head.mirror = true;
        setRotation(Head, 0F, 0F, 0F);
        Upper_Jaw = new MowzieModelRenderer(this, 11, 26);
        Upper_Jaw.addBox(-2.5F, -4F, -8F, 5, 4, 8);
        Upper_Jaw.setRotationPoint(0F, 7.5F, -26.5F);
        Upper_Jaw.setTextureSize(256, 256);
        Upper_Jaw.mirror = true;
        setRotation(Upper_Jaw, 0.0174533F, 0F, 0F);
        Lower_Jaw = new MowzieModelRenderer(this, 71, 27);
        Lower_Jaw.addBox(-1.5F, -1F, 0F, 3, 1, 7);
        Lower_Jaw.setRotationPoint(0F, 7.5F, -26.5F);
        Lower_Jaw.setTextureSize(256, 256);
        Lower_Jaw.mirror = true;
        setRotation(Lower_Jaw, -3.141593F, 0F, 0F);
        Tail_1 = new MowzieModelRenderer(this, 118, 39);
        Tail_1.addBox(-4F, 0F, 0F, 8, 8, 10);
        Tail_1.setRotationPoint(0F, 1.1F, 4.5F);
        Tail_1.setTextureSize(256, 256);
        Tail_1.mirror = true;
        setRotation(Tail_1, -0.1797784F, 0F, 0F);
        Tail_2 = new MowzieModelRenderer(this, 118, 61);
        Tail_2.addBox(-3.5F, 0F, 0F, 7, 7, 8);
        Tail_2.setRotationPoint(0F, 3.3F, 12.5F);
        Tail_2.setTextureSize(256, 256);
        Tail_2.mirror = true;
        setRotation(Tail_2, -0.1627677F, 0F, 0F);
        Tail_3 = new MowzieModelRenderer(this, 118, 119);
        Tail_3.addBox(-3F, 0F, 0F, 6, 6, 8);
        Tail_3.setRotationPoint(0F, 5.1F, 17.5F);
        Tail_3.setTextureSize(256, 256);
        Tail_3.mirror = true;
        setRotation(Tail_3, -0.0640412F, 0F, 0F);
        Tail_4 = new MowzieModelRenderer(this, 118, 80);
        Tail_4.addBox(-2F, 0F, 0F, 4, 5, 9);
        Tail_4.setRotationPoint(0F, 6F, 22.5F);
        Tail_4.setTextureSize(256, 256);
        Tail_4.mirror = true;
        setRotation(Tail_4, -0.0122953F, 0F, 0F);
        Tail_5 = new MowzieModelRenderer(this, 118, 101);
        Tail_5.addBox(-1.5F, 0F, 0F, 3, 4, 10);
        Tail_5.setRotationPoint(0F, 6.5F, 28.5F);
        Tail_5.setTextureSize(256, 256);
        Tail_5.mirror = true;
        setRotation(Tail_5, -0.0122953F, 0F, 0F);
        Tail_6 = new MowzieModelRenderer(this, 118, 134);
        Tail_6.addBox(-1F, 0F, 0F, 2, 3, 8);
        Tail_6.setRotationPoint(0F, 7F, 37.5F);
        Tail_6.setTextureSize(256, 256);
        Tail_6.mirror = true;
        setRotation(Tail_6, 0.0494739F, 0F, 0F);
        Upper_Arm_Right = new MowzieModelRenderer(this, 0, 56);
        Upper_Arm_Right.addBox(-2F, 0F, 0F, 3, 3, 7);
        Upper_Arm_Right.setRotationPoint(-4.5F, 7F, -11.5F);
        Upper_Arm_Right.setTextureSize(256, 256);
        Upper_Arm_Right.mirror = true;
        setRotation(Upper_Arm_Right, -0.8512869F, 0F, 0F);
        Upper_Arm_Left = new MowzieModelRenderer(this, 0, 56);
        Upper_Arm_Left.addBox(-1F, 0F, 0F, 3, 3, 7);
        Upper_Arm_Left.setRotationPoint(4.5F, 7F, -11.5F);
        Upper_Arm_Left.setTextureSize(256, 256);
        Upper_Arm_Left.mirror = true;
        setRotation(Upper_Arm_Left, -0.8512869F, 0F, 0F);
        Lower_Arm_Left = new MowzieModelRenderer(this, 0, 68);
        Lower_Arm_Left.addBox(-1F, 0F, 0F, 2, 5, 2);
        Lower_Arm_Left.setRotationPoint(5F, 12F, -10F);
        Lower_Arm_Left.setTextureSize(256, 256);
        Lower_Arm_Left.mirror = true;
        setRotation(Lower_Arm_Left, -0.6320364F, 0F, 0F);
        Lower_Arm_Right = new MowzieModelRenderer(this, 0, 68);
        Lower_Arm_Right.addBox(-1F, 0F, 0F, 2, 5, 2);
        Lower_Arm_Right.setRotationPoint(-5F, 12F, -10F);
        Lower_Arm_Right.setTextureSize(256, 256);
        Lower_Arm_Right.mirror = true;
        setRotation(Lower_Arm_Right, -0.6320364F, 0F, 0F);
        Hand_Left = new MowzieModelRenderer(this, 68, 7);
        Hand_Left.addBox(-1F, 0F, -1F, 2, 2, 1);
        Hand_Left.setRotationPoint(5F, 16F, -12F);
        Hand_Left.setTextureSize(256, 256);
        Hand_Left.mirror = true;
        setRotation(Hand_Left, 0F, -0.3490659F, 0F);
        Hand_Right = new MowzieModelRenderer(this, 68, 7);
        Hand_Right.addBox(-1F, 0F, -1F, 2, 2, 1);
        Hand_Right.setRotationPoint(-5F, 16F, -12F);
        Hand_Right.setTextureSize(256, 256);
        Hand_Right.mirror = true;
        setRotation(Hand_Right, 0F, 0.3490659F, 0F);
        Hand_Left_Claw_Left = new MowzieModelRenderer(this, 81, 45);
        Hand_Left_Claw_Left.addBox(-0.8F, 1F, -0.5F, 1, 2, 1);
        Hand_Left_Claw_Left.setRotationPoint(5F, 16F, -12F);
        Hand_Left_Claw_Left.setTextureSize(256, 256);
        Hand_Left_Claw_Left.mirror = true;
        setRotation(Hand_Left_Claw_Left, -0.5235988F, -1.919862F, 0F);
        Hand_Left_Claw_Right = new MowzieModelRenderer(this, 81, 45);
        Hand_Left_Claw_Right.addBox(-0.5F, 1F, -1.2F, 1, 2, 1);
        Hand_Left_Claw_Right.setRotationPoint(5F, 16F, -12F);
        Hand_Left_Claw_Right.setTextureSize(256, 256);
        Hand_Left_Claw_Right.mirror = true;
        setRotation(Hand_Left_Claw_Right, 0F, -0.3490659F, 0F);
        Hand_Left_Claw_Middle = new MowzieModelRenderer(this, 81, 45);
        Hand_Left_Claw_Middle.addBox(-0.8F, 1F, -0.5F, 1, 2, 1);
        Hand_Left_Claw_Middle.setRotationPoint(5F, 16F, -12F);
        Hand_Left_Claw_Middle.setTextureSize(256, 256);
        Hand_Left_Claw_Middle.mirror = true;
        setRotation(Hand_Left_Claw_Middle, 0.5235988F, -1.919862F, 0F);
        Hand_Right_Claw_Right = new MowzieModelRenderer(this, 81, 45);
        Hand_Right_Claw_Right.addBox(0.2F, 1F, -0.5F, 1, 2, 1);
        Hand_Right_Claw_Right.setRotationPoint(-5F, 16F, -12F);
        Hand_Right_Claw_Right.setTextureSize(256, 256);
        Hand_Right_Claw_Right.mirror = true;
        setRotation(Hand_Right_Claw_Right, 0F, 1.919862F, 0F);
        Hand_Right_Claw_Left = new MowzieModelRenderer(this, 81, 45);
        Hand_Right_Claw_Left.addBox(-0.2F, 1F, -0.5F, 1, 2, 1);
        Hand_Right_Claw_Left.setRotationPoint(-5F, 16F, -12F);
        Hand_Right_Claw_Left.setTextureSize(256, 256);
        Hand_Right_Claw_Left.mirror = true;
        setRotation(Hand_Right_Claw_Left, 0.5235988F, 1.919862F, 0F);
        Hand_Right_Claw_Middle = new MowzieModelRenderer(this, 81, 45);
        Hand_Right_Claw_Middle.addBox(-0.2F, 1F, -0.5F, 1, 2, 1);
        Hand_Right_Claw_Middle.setRotationPoint(-5F, 16F, -12F);
        Hand_Right_Claw_Middle.setTextureSize(256, 256);
        Hand_Right_Claw_Middle.mirror = true;
        setRotation(Hand_Right_Claw_Middle, -0.5235988F, 1.919862F, 0F);
        Foot_Left = new MowzieModelRenderer(this, 0, 0);
        Foot_Left.addBox(-1.5F, 0F, -4F, 3, 2, 6);
        Foot_Left.setRotationPoint(6F, 22F, 0F);
        Foot_Left.setTextureSize(256, 256);
        Foot_Left.mirror = true;
        setRotation(Foot_Left, 0F, 0F, 0F);
        Foot_Right = new MowzieModelRenderer(this, 0, 0);
        Foot_Right.addBox(-1.5F, 0F, -4F, 3, 2, 6);
        Foot_Right.setRotationPoint(-6F, 22F, 0F);
        Foot_Right.setTextureSize(256, 256);
        Foot_Right.mirror = true;
        setRotation(Foot_Right, 0F, 0F, 0F);

        addChildTo(Upper_Jaw, Head);
        addChildTo(Lower_Jaw, Head);
        addChildTo(Head, Neck);
        addChildTo(Head, Neck);
        addChildTo(Neck, Body_2);
        addChildTo(Body_2, Body_1);
        
        addChildTo(Hand_Left_Claw_Left, Hand_Left);
        addChildTo(Hand_Left_Claw_Middle, Hand_Left);
        addChildTo(Hand_Left_Claw_Right, Hand_Left);
        addChildTo(Hand_Left, Lower_Arm_Left);
        addChildTo(Lower_Arm_Left, Upper_Arm_Left);
        addChildTo(Upper_Arm_Left, Body_1);
        
        addChildTo(Hand_Right_Claw_Left, Hand_Right);
        addChildTo(Hand_Right_Claw_Middle, Hand_Right);
        addChildTo(Hand_Right_Claw_Right, Hand_Right);
        addChildTo(Hand_Right, Lower_Arm_Right);
        addChildTo(Lower_Arm_Right, Upper_Arm_Right);
        addChildTo(Upper_Arm_Right, Body_1);
        
        addChildTo(Tail_6, Tail_5);
        addChildTo(Tail_5, Tail_4);
        addChildTo(Tail_4, Tail_3);
        addChildTo(Tail_3, Tail_2);
        addChildTo(Tail_2, Tail_1);
        addChildTo(Tail_1, Body_1);

        addChildTo(Foot_Left, Left_Upper_Foot);
        addChildTo(Left_Upper_Foot, Left_Calf_1);
        addChildTo(Left_Calf_1, Left_Thigh);
        addChildTo(Foot_Right, Right_Upper_Foot);
        addChildTo(Right_Upper_Foot, Right_Calf_1);
        addChildTo(Right_Calf_1, Right_Thigh);

        //Corrections
        Head.rotationPointZ -= 12;
        Head.rotationPointY -= 1.2;
        Head.rotateAngleX += 0.1;
        Body_2.setRotationPoint(0, -4.8F, -13);
        
        Hand_Left_Claw_Left.setRotationPoint(0, 0, 0);
        Hand_Left_Claw_Middle.setRotationPoint(0, 0, 0);
        Hand_Left_Claw_Right.setRotationPoint(0, 0, 0);
        
        Hand_Right_Claw_Left.setRotationPoint(0, 0, 0);
        Hand_Right_Claw_Middle.setRotationPoint(0, 0, 0);
        Hand_Right_Claw_Right.setRotationPoint(0, 0, 0);
        
        Tail_1.setRotationPoint(0, -4.7F, 7);
        
        Left_Upper_Foot.setInitValuesToCurrentPose();
        Right_Upper_Foot.setInitValuesToCurrentPose();
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
        Tail_6.setInitValuesToCurrentPose();
        Upper_Arm_Right.setInitValuesToCurrentPose();
        Upper_Arm_Left.setInitValuesToCurrentPose();
        Lower_Arm_Left.setInitValuesToCurrentPose();
        Lower_Arm_Right.setInitValuesToCurrentPose();
        Hand_Left.setInitValuesToCurrentPose();
        Hand_Right.setInitValuesToCurrentPose();
        Hand_Left_Claw_Left.setInitValuesToCurrentPose();
        Hand_Left_Claw_Right.setInitValuesToCurrentPose();
        Hand_Left_Claw_Middle.setInitValuesToCurrentPose();
        Hand_Right_Claw_Right.setInitValuesToCurrentPose();
        Hand_Right_Claw_Left.setInitValuesToCurrentPose();
        Hand_Right_Claw_Middle.setInitValuesToCurrentPose();
        Foot_Left.setInitValuesToCurrentPose();
        Foot_Right.setInitValuesToCurrentPose();
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
//    Left_Upper_Foot.render(f5);
//    Right_Upper_Foot.render(f5);
//    Left_Calf_1.render(f5);
//    Right_Calf_1.render(f5);
        Left_Thigh.render(f5);
        Right_Thigh.render(f5);
        Body_1.render(f5);
 //       Body_2.render(f5);
//        Neck.render(f5);
 //       Head.render(f5);
//        Upper_Jaw.render(f5);
//        Lower_Jaw.render(f5);
/*        Tail_1.render(f5);
        Tail_2.render(f5);
        Tail_3.render(f5);
        Tail_4.render(f5);
        Tail_5.render(f5);
        Tail_6.render(f5);*/
/*        Upper_Arm_Right.render(f5);
        Upper_Arm_Left.render(f5);
        Lower_Arm_Left.render(f5);
        Lower_Arm_Right.render(f5);
        Hand_Left.render(f5);
        Hand_Right.render(f5);
        Hand_Left_Claw_Left.render(f5);
        Hand_Left_Claw_Right.render(f5);
        Hand_Left_Claw_Middle.render(f5);
        Hand_Right_Claw_Right.render(f5);
        Hand_Right_Claw_Left.render(f5);
        Hand_Right_Claw_Middle.render(f5);*/
//    Foot_Left.render(f5);
//    Foot_Right.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void resetPose()
    {
        Left_Upper_Foot.setCurrentPoseToInitValues();
        Right_Upper_Foot.setCurrentPoseToInitValues();
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
        Tail_6.setCurrentPoseToInitValues();
        Upper_Arm_Right.setCurrentPoseToInitValues();
        Upper_Arm_Left.setCurrentPoseToInitValues();
        Lower_Arm_Left.setCurrentPoseToInitValues();
        Lower_Arm_Right.setCurrentPoseToInitValues();
        Hand_Left.setCurrentPoseToInitValues();
        Hand_Right.setCurrentPoseToInitValues();
        Hand_Left_Claw_Left.setCurrentPoseToInitValues();
        Hand_Left_Claw_Right.setCurrentPoseToInitValues();
        Hand_Left_Claw_Middle.setCurrentPoseToInitValues();
        Hand_Right_Claw_Right.setCurrentPoseToInitValues();
        Hand_Right_Claw_Left.setCurrentPoseToInitValues();
        Hand_Right_Claw_Middle.setCurrentPoseToInitValues();
        Foot_Left.setCurrentPoseToInitValues();
        Foot_Right.setCurrentPoseToInitValues();
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
    {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        EntityHerrerasaur herrera = (EntityHerrerasaur) entity;
        resetPose();
/*    f = herrera.frame;
    f1 = 1F;*/
        float scaleFactor = 0.77F;
        float height = 2F * f1;
        bob(Body_1, 1F * scaleFactor, height, false, f, f1);
        bob(Left_Thigh, 1F * scaleFactor, height, false, f, f1);
        bob(Right_Thigh, 1F * scaleFactor, height, false, f, f1);
        bob(Neck, 1F * scaleFactor, height / 2, false, f, f1);

        walk(Neck, 1F * scaleFactor, 0.25F, false, 1F, 0.1F, f, f1);
        walk(Head, 1F * scaleFactor, 0.25F, true, 1F, -0.1F, f, f1);
        walk(Body_1, 1F * scaleFactor, 0.1F, true, 0F, 0.07F, f, f1);
        
        walk(Left_Thigh, 0.5F * scaleFactor, 0.8F, false, 0F, 0.4F, f, f1);
        walk(Left_Calf_1, 0.5F * scaleFactor, 0.5F, true, 1F, 0F, f, f1);
        walk(Left_Upper_Foot, 0.5F * scaleFactor, 0.5F, false, 0F, 0F, f, f1);
        walk(Foot_Left, 0.5F * scaleFactor, 1.5F, true, 0.5F, 1F, f, f1);

        walk(Right_Thigh, 0.5F * scaleFactor, 0.8F, true, 0F, 0.4F, f, f1);
        walk(Right_Calf_1, 0.5F * scaleFactor, 0.5F, false, 1F, 0F, f, f1);
        walk(Right_Upper_Foot, 0.5F * scaleFactor, 0.5F, true, 0F, 0F, f, f1);
        walk(Foot_Right, 0.5F * scaleFactor, 1.5F, false, 0.5F, 1F, f, f1);

        faceTarget(Head, 2, f3, f4);
        faceTarget(Neck, 2, f3, f4);

        MowzieModelRenderer[] rightArmParts = {this.Hand_Right, this.Lower_Arm_Right, this.Upper_Arm_Right};
        MowzieModelRenderer[] leftArmParts = {this.Hand_Left, this.Lower_Arm_Left, this.Upper_Arm_Left};
        MowzieModelRenderer[] tailParts = {this.Tail_6, this.Tail_5, this.Tail_4, this.Tail_3, this.Tail_2, this.Tail_1};
        tailSwing(tailParts, 0.5F * scaleFactor, -0.1F * f1, 2, f);
        chainWave(tailParts, 1F * scaleFactor, -0.03F, 2, f, f1);
        chainWave(rightArmParts, 1F * scaleFactor, -0.3F, 4, f, f1);
        chainWave(leftArmParts, 1F * scaleFactor, -0.3F, 4, f, f1);
        
        //Idling
        chainWave(tailParts, 0.1F, -0.05F, 2, herrera.frame, 1F);
        walk(Neck, 0.1F, 0.07F, false, -1F, 0F, herrera.frame, 1F);
        walk(Head, 0.1F, 0.07F, true, 0F, 0F, herrera.frame, 1F);
        walk(Body_1, 0.1F, 0.05F, false, 0F, 0F, herrera.frame, 1F);
        chainWave(rightArmParts, 0.1F, -0.1F, 4, herrera.frame, 1F);
        chainWave(leftArmParts, 0.1F, -0.1F, 4, herrera.frame, 1F);
    }
}