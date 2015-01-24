package net.ilexiconn.jurassicraft.client.model.entity;

import net.ilexiconn.jurassicraft.client.model.animation.Animator;
import net.ilexiconn.jurassicraft.client.model.modelbase.MowzieModelBase;
import net.ilexiconn.jurassicraft.client.model.modelbase.MowzieModelRenderer;
import net.ilexiconn.jurassicraft.entity.dinosaurs.EntityTyrannosaurus;
import net.ilexiconn.jurassicraft.interfaces.IAnimatedEntity;
import net.minecraft.entity.Entity;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelTyrannosaurus extends MowzieModelBase
{
    private Animator animator;
    public MowzieModelRenderer LeftCalf1;
    public MowzieModelRenderer RightCalf1;
    public MowzieModelRenderer LeftThigh;
    public MowzieModelRenderer RightThigh;
    public MowzieModelRenderer Waist;
    public MowzieModelRenderer Chest;
    public MowzieModelRenderer Neck;
    public MowzieModelRenderer Head;
    public MowzieModelRenderer LowerJaw;
    public MowzieModelRenderer Tail1;
    public MowzieModelRenderer Tail2;
    public MowzieModelRenderer Tail3;
    public MowzieModelRenderer Tail4;
    public MowzieModelRenderer Tail5;
    public MowzieModelRenderer LowerArmLeft;
    public MowzieModelRenderer LowerArmRight;
    public MowzieModelRenderer HandLeft;
    public MowzieModelRenderer HandRight;
    public MowzieModelRenderer HandLeftClawLeft;
    public MowzieModelRenderer HandLeftClawRight;
    public MowzieModelRenderer HandRightClawRight;
    public MowzieModelRenderer HandRightClawLeft;
    public MowzieModelRenderer LeftCalf2;
    public MowzieModelRenderer RightCalf2;
    public MowzieModelRenderer FootLeft;
    public MowzieModelRenderer FootRight;
    public MowzieModelRenderer UpperArmRight;
    public MowzieModelRenderer UpperArmLeft;
    public MowzieModelRenderer UpperJaw;
    public MowzieModelRenderer Teeth;
    public MowzieModelRenderer Body;
    public MowzieModelRenderer[] tailParts;
    public MowzieModelRenderer[] bodyParts;
    public MowzieModelRenderer[] leftArmParts;
    public MowzieModelRenderer[] rightArmParts;

    public ModelTyrannosaurus() {
    	this.animator = new Animator(this);
        this.textureWidth = 256;
        this.textureHeight = 256;
        
        this.HandRightClawLeft = new MowzieModelRenderer(this, 81, 45);
        this.HandRightClawLeft.setRotationPoint(-4.5F, 14.5F, -10.0F);
        this.HandRightClawLeft.addBox(-0.8F, 0.5F, -1.0F, 1, 2, 1);
        this.setRotation(HandRightClawLeft, 0.1413716694115407F, -1.1693705988362009F, 0.0F);
        this.HandLeft = new MowzieModelRenderer(this, 81, 54);
        this.HandLeft.setRotationPoint(4.5F, 14.5F, -10.0F);
        this.HandLeft.addBox(0.0F, -1.0F, -1.0F, 1, 2, 2);
        this.setRotation(HandLeft, 0.03717551306747922F, 1.1693705988362009F, 0.0F);
        this.HandLeftClawLeft = new MowzieModelRenderer(this, 81, 45);
        this.HandLeftClawLeft.setRotationPoint(4.5F, 14.5F, -10.0F);
        this.HandLeftClawLeft.addBox(-0.2F, 0.0F, -0.5F, 1, 2, 1);
        this.setRotation(HandLeftClawLeft, 0.4735078260660616F, 1.1693705988362009F, 0.0F);
        this.LowerArmLeft = new MowzieModelRenderer(this, 0, 69);
        this.LowerArmLeft.setRotationPoint(4.5F, 13.0F, -9.1F);
        this.LowerArmLeft.addBox(-1.0F, -0.7F, -1.5F, 2, 2, 2);
        this.setRotation(LowerArmLeft, -0.40893064374227134F, -0.0F, 0.0F);
        this.FootRight = new MowzieModelRenderer(this, 0, 0);
        this.FootRight.setRotationPoint(-7.0F, 22.0F, 4.5F);
        this.FootRight.addBox(-2.5F, 0.0F, -5.0F, 5, 2, 7);
        this.LeftCalf1 = new MowzieModelRenderer(this, 65, 80);
        this.LeftCalf1.setRotationPoint(7.0F, 14.0F, 0.0F);
        this.LeftCalf1.addBox(-2.0F, 0.0F, 1.0F, 4, 8, 4);
        this.setRotation(LeftCalf1, 0.6692115950921859F, -0.0F, 0.0F);
        this.Tail1 = new MowzieModelRenderer(this, 118, 39);
        this.Tail1.setRotationPoint(0.0F, 0.8F, 10.0F);
        this.Tail1.addBox(-4.5F, 0.0F, -1.0F, 9, 9, 10);
        this.setRotation(Tail1, -0.056897733615015135F, -0.0F, 0.0F);
        this.Teeth = new MowzieModelRenderer(this, 53, 120);
        this.Teeth.setRotationPoint(0.0F, 3.7F, -24.3F);
        this.Teeth.addBox(-3.5F, -1.2F, 0.0F, 7, 1, 9);
        this.setRotation(Teeth, -3.1066860685499065F, -0.0F, 0.0F);
        this.Waist = new MowzieModelRenderer(this, 130, 12);
        this.Waist.setRotationPoint(0.0F, 3.0F, 4.0F);
        this.Waist.addBox(-5.0F, -2.7F, -3.0F, 10, 12, 9);
        this.Tail4 = new MowzieModelRenderer(this, 118, 80);
        this.Tail4.setRotationPoint(0.0F, 3.9F, 31.0F);
        this.Tail4.addBox(-2.0F, -1.0F, -1.0F, 4, 5, 9);
        this.setRotation(Tail4, -0.07435102613495843F, -0.0F, 0.0F);
        this.Tail3 = new MowzieModelRenderer(this, 118, 122);
        this.Tail3.setRotationPoint(0.0F, 3.8F, 26.0F);
        this.Tail3.addBox(-3.0F, -1.0F, -1.0F, 6, 6, 8);
        this.setRotation(Tail3, 0.03717551306747922F, -0.0F, 0.0F);
        this.Tail5 = new MowzieModelRenderer(this, 118, 100);
        this.Tail5.setRotationPoint(0.0F, 5.4F, 37.0F);
        this.Tail5.addBox(-1.5F, -1.5F, 1.0F, 3, 4, 11);
        this.setRotation(Tail5, -0.1115439924949576F, -0.0F, 0.0F);
        this.RightCalf2 = new MowzieModelRenderer(this, 65, 0);
        this.RightCalf2.setRotationPoint(-7.0F, 16.5F, 6.8F);
        this.RightCalf2.addBox(-1.5F, 0.0F, -1.0F, 3, 8, 3);
        this.setRotation(RightCalf2, -0.557685055889748F, -0.0F, 0.0F);
        this.RightThigh = new MowzieModelRenderer(this, 29, 76);
        this.RightThigh.setRotationPoint(-4.5F, 3.0F, 4.0F);
        this.RightThigh.addBox(-5.0F, -1.0F, -11.0F, 5, 6, 10);
        this.setRotation(RightThigh, 1.2815254565693563F, -0.0F, 0.0F);
        this.Chest = new MowzieModelRenderer(this, 183, 1);
        this.Chest.setRotationPoint(0.0F, 5.2F, -6.0F);
        this.Chest.addBox(-4.0F, -4.8F, -6.5F, 8, 11, 7);
        this.setRotation(Chest, -0.08953539062730911F, -0.0F, 0.0F);
        this.Neck = new MowzieModelRenderer(this, 218, 1);
        this.Neck.setRotationPoint(0.0F, 3.1F, -10.6F);
        this.Neck.addBox(-3.5F, -2.4F, -9.1F, 7, 9, 11);
        this.setRotation(Neck, -0.44837508483734323F, -0.0F, 0.0F);
        this.HandLeftClawRight = new MowzieModelRenderer(this, 81, 45);
        this.HandLeftClawRight.setRotationPoint(4.5F, 14.5F, -10.0F);
        this.HandLeftClawRight.addBox(-0.2F, 0.5F, -1.0F, 1, 2, 1);
        this.setRotation(HandLeftClawRight, 0.153588974175501F, 1.1693705988362009F, 0.0F);
        this.UpperArmLeft = new MowzieModelRenderer(this, 0, 68);
        this.UpperArmLeft.setRotationPoint(3.5F, 9.0F, -11.0F);
        this.UpperArmLeft.addBox(0.0F, 0.0F, 0.0F, 2, 4, 2);
        this.setRotation(UpperArmLeft, 0.18587756533739608F, -0.0F, 0.0F);
        this.Head = new MowzieModelRenderer(this, 0, 92);
        this.Head.setRotationPoint(0.0F, -0.1F, -18.7F);
        this.Head.addBox(-4.0F, -2.9F, -6.9F, 8, 9, 8);
        this.setRotation(Head, 0.05235987755982988F, -0.0F, 0.0F);
        this.LowerJaw = new MowzieModelRenderer(this, 71, 27);
        this.LowerJaw.setRotationPoint(0.0F, 3.7F, -24.8F);
        this.LowerJaw.addBox(-2.5F, -2.4F, 0.0F, 5, 2, 8);
        this.setRotation(LowerJaw, -3.141592653589793F, -0.0F, 0.0F);
        this.HandRightClawRight = new MowzieModelRenderer(this, 81, 45);
        this.HandRightClawRight.setRotationPoint(-4.5F, 14.5F, -10.0F);
        this.HandRightClawRight.addBox(-0.8F, 0.0F, -0.5F, 1, 2, 1);
        this.setRotation(HandRightClawRight, 0.4735078260660616F, -1.1693705988362009F, 0.0F);
        this.LeftThigh = new MowzieModelRenderer(this, 29, 59);
        this.LeftThigh.setRotationPoint(4.5F, 3.0F, 4.0F);
        this.LeftThigh.addBox(0.0F, -1.0F, -11.0F, 5, 6, 10);
        this.setRotation(LeftThigh, 1.2815254565693563F, -0.0F, 0.0F);
        this.RightCalf1 = new MowzieModelRenderer(this, 65, 80);
        this.RightCalf1.setRotationPoint(-7.0F, 14.0F, 0.0F);
        this.RightCalf1.addBox(-2.0F, 0.0F, 1.0F, 4, 8, 4);
        this.setRotation(RightCalf1, 0.6692115950921859F, -0.0F, 0.0F);
        this.HandRight = new MowzieModelRenderer(this, 81, 54);
        this.HandRight.setRotationPoint(-4.5F, 14.5F, -10.0F);
        this.HandRight.addBox(-1.0F, -1.0F, -1.0F, 1, 2, 2);
        this.setRotation(HandRight, 0.03717551306747922F, -1.1693705988362009F, 0.0F);
        this.UpperArmRight = new MowzieModelRenderer(this, 0, 68);
        this.UpperArmRight.setRotationPoint(-3.5F, 9.0F, -11.0F);
        this.UpperArmRight.addBox(-2.0F, 0.0F, 0.0F, 2, 4, 2);
        this.setRotation(UpperArmRight, 0.18587756533739608F, -0.0F, 0.0F);
        this.Body = new MowzieModelRenderer(this, 132, 13);
        this.Body.setRotationPoint(0.0F, 5.0F, 1.1F);
        this.Body.addBox(-4.5F, -4.5F, -7.31F, 9, 11, 8);
        this.FootLeft = new MowzieModelRenderer(this, 0, 0);
        this.FootLeft.setRotationPoint(7.0F, 22.0F, 4.5F);
        this.FootLeft.addBox(-2.5F, 0.0F, -5.0F, 5, 2, 7);
        this.Tail2 = new MowzieModelRenderer(this, 118, 61);
        this.Tail2.setRotationPoint(0.0F, 3.299999952316284F, 18.0F);
        this.Tail2.addBox(-4.0F, -1.0F, 0.0F, 8, 7, 8);
        this.setRotation(Tail2, -9.198856669657585E-18F, -0.0F, 0.0F);
        this.LowerArmRight = new MowzieModelRenderer(this, 0, 69);
        this.LowerArmRight.setRotationPoint(-4.5F, 13.0F, -9.1F);
        this.LowerArmRight.addBox(-1.0F, -0.7F, -1.5F, 2, 2, 2);
        this.setRotation(LowerArmRight, -0.40893064374227134F, -0.0F, 0.0F);
        this.UpperJaw = new MowzieModelRenderer(this, 0, 120);
        this.UpperJaw.setRotationPoint(0.0F, 3.7F, -24.3F);
        this.UpperJaw.addBox(-3.5F, -0.2F, 0.0F, 7, 6, 9);
        this.setRotation(UpperJaw, -3.1066860685499065F, -0.0F, 0.0F);
        this.LeftCalf2 = new MowzieModelRenderer(this, 65, 0);
        this.LeftCalf2.setRotationPoint(7.0F, 16.5F, 6.8F);
        this.LeftCalf2.addBox(-1.5F, 0.0F, -1.0F, 3, 8, 3);
        this.setRotation(LeftCalf2, -0.5576326960121882F, -0.0F, 0.0F);

        this.addChildTo(this.Teeth, this.UpperJaw);
        this.addChildTo(this.UpperJaw, this.Head);
        this.addChildTo(this.LowerJaw, this.Head);
        this.addChildTo(this.Head, this.Neck);
        this.addChildTo(this.Neck, this.Chest);

        this.addChildTo(this.HandLeftClawLeft, this.HandLeft);
        this.addChildTo(this.HandLeftClawRight, this.HandLeft);
        this.addChildTo(this.HandLeft, this.LowerArmLeft);
        this.addChildTo(this.LowerArmLeft, this.UpperArmLeft);
        this.addChildTo(this.UpperArmLeft, this.Chest);

        this.addChildTo(this.HandRightClawLeft, this.HandRight);
        this.addChildTo(this.HandRightClawRight, this.HandRight);
        this.addChildTo(this.HandRight, this.LowerArmRight);
        this.addChildTo(this.LowerArmRight, this.UpperArmRight);
        this.addChildTo(this.UpperArmRight, this.Chest);
        
        this.addChildTo(this.Chest, this.Body);
        this.addChildTo(this.Body, this.Waist);

        this.addChildTo(this.FootLeft, this.LeftCalf2);
        this.addChildTo(this.LeftCalf2, this.LeftCalf1);
        this.addChildTo(this.LeftCalf1, this.LeftThigh);

        this.addChildTo(this.FootRight, this.RightCalf2);
        this.addChildTo(this.RightCalf2, this.RightCalf1);
        this.addChildTo(this.RightCalf1, this.RightThigh);

        this.addChildTo(this.Tail5, this.Tail4);
        this.addChildTo(this.Tail4, this.Tail3);
        this.addChildTo(this.Tail3, this.Tail2);
        this.addChildTo(this.Tail2, this.Tail1);
        this.addChildTo(this.Tail1, this.Waist);

        //Corrections
        this.Tail1.rotationPointZ += 12;
        this.Tail1.rotationPointY -= 4;
        this.Chest.rotationPointZ -= 0;
        this.Head.rotationPointZ -= 17;
        this.Head.rotationPointY += 1;
        this.Neck.rotationPointZ -= 9;
        this.Neck.rotationPointY -= 3;
        this.Teeth.setRotationPoint(0, 0, 0);
        this.HandRightClawRight.setRotationPoint(0, 0, 0);
        this.HandLeftClawRight.setRotationPoint(0, 0, 0);
        this.HandRightClawLeft.setRotationPoint(0, 0, 0);
        this.HandLeftClawLeft.setRotationPoint(0, 0, 0);
        this.HandLeft.rotateAngleZ += 0.5;
        this.HandRight.rotateAngleZ -= 0.5;
        this.FootLeft.rotationPointZ -= 2;
        this.FootRight.rotationPointZ -= 2;
        this.FootLeft.rotationPointY += 1.75;
        this.FootRight.rotationPointY += 1.75;
        
        this.parts = new MowzieModelRenderer[]{this.LeftCalf1, this.RightCalf1, this.LeftThigh, this.RightThigh, this.Waist, this.Chest, this.Neck, this.Head, this.LowerJaw, this.Tail1, this.Tail2, this.Tail3, this.Tail4, this.Tail5, this.LowerArmLeft, this.LowerArmRight, this.HandLeft, this.HandRight, this.HandLeftClawLeft, this.HandLeftClawRight, this.HandRightClawRight, this.HandRightClawLeft, this.LeftCalf2, this.RightCalf2, this.FootLeft, this.FootRight, this.UpperArmRight, this.UpperArmLeft, this.UpperJaw, this.Teeth, this.Body};
        this.tailParts = new MowzieModelRenderer[]{this.Tail5, this.Tail4, this.Tail3, this.Tail2, this.Tail1};
        this.bodyParts = new MowzieModelRenderer[]{this.Head, this.Neck, this.Chest, this.Body, this.Waist};
        this.leftArmParts = new MowzieModelRenderer[]{this.HandLeft, this.LowerArmLeft, this.UpperArmLeft};
        this.rightArmParts = new MowzieModelRenderer[]{this.HandRight, this.LowerArmRight, this.UpperArmRight};
        
        this.setInitPose();
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.animate((IAnimatedEntity) entity, f, f1, f2, f3, f4, f5);
        this.Waist.render(f5);
        this.RightThigh.render(f5);
        this.LeftThigh.render(f5);
    }

    private void setRotation(MowzieModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, EntityTyrannosaurus trex)
    {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, trex);
		this.setToInitPose();
		
		/*
		f = trex.frame;
		f1 = (float) Math.cos(f/20)*0.25F + 0.5F;
		f1 = 0.5F;
		*/
		
		if(!trex.isSitting()) {
		//Walking-dependent animation
		float globalSpeed = 0.45F;
		float globalDegree = 0.4F;
		float height = 1.0F;
		
		this.faceTarget(Head, 2, f3, f4);
		this.faceTarget(Neck, 2, f3, f4);
		
		this.bob(Waist, 1F * globalSpeed, height, false, f, f1);
		this.bob(LeftThigh, 1F * globalSpeed, height, false, f, f1);
		this.bob(RightThigh, 1F * globalSpeed, height, false, f, f1);
		this.LeftThigh.rotationPointY -= -2 * f1 * Math.cos(f * 0.5 * globalSpeed);
		this.RightThigh.rotationPointY -= 2 * f1 * Math.cos(f * 0.5 * globalSpeed);
		this.walk(Neck, 1F * globalSpeed, 0.15F, false, 0F, 0.2F, f, f1);
		this.walk(Head, 1F * globalSpeed, 0.15F, true, 0F, -0.2F, f, f1);

		this.walk(LeftThigh, 0.5F * globalSpeed, 0.8F * globalDegree, false, 0F, 0.4F, f, f1);
		this.walk(LeftCalf1, 0.5F * globalSpeed, 1F * globalDegree, true, 1F, 0.4F, f, f1);
		this.walk(LeftCalf2, 0.5F * globalSpeed, 1F * globalDegree, false, 0F, 0F, f, f1);
		this.walk(FootLeft, 0.5F * globalSpeed, 1.5F * globalDegree, true, 0.5F, -0.15F, f, f1);

		this.walk(RightThigh, 0.5F * globalSpeed, 0.8F * globalDegree, true, 0F, 0.4F, f, f1);
		this.walk(RightCalf1, 0.5F * globalSpeed, 1F * globalDegree, false, 1F, 0.4F, f, f1);
		this.walk(RightCalf2, 0.5F * globalSpeed, 1F * globalDegree, true, 0F, 0F, f, f1);
		this.walk(FootRight, 0.5F * globalSpeed, 1.5F * globalDegree, false, 0.5F, -0.15F, f, f1);

		this.chainWave(tailParts, 1F * globalSpeed, 0.05F, 2, f, f1);
		this.chainWave(bodyParts, 1F * globalSpeed, 0.05F, 3, f, f1);
		this.chainWave(leftArmParts, 1F * globalSpeed, 0.2F, 1, f, f1);
		this.chainWave(rightArmParts, 1F * globalSpeed, 0.2F, 1, f, f1);
		}
		
		//Sitting Pose
		float sittingProgress = trex.sittingProgress.getAnimationProgressSinSqrt();
		float sittingProgressFast = trex.sittingProgress.getAnimationProgressSinToTen();
		float restHeadProgress = trex.restHeadProgress.getAnimationProgressSinSqrt();
		
		Head.rotateAngleY += ((f3 / (180f / (float) Math.PI)) / 2) * sittingProgress - (((f3 / (180f / (float) Math.PI)) / 2)*restHeadProgress);
		Neck.rotateAngleY += ((f3 / (180f / (float) Math.PI)) / 2) * sittingProgress - (((f3 / (180f / (float) Math.PI)) / 2)*restHeadProgress);
		
		this.Waist.rotationPointY += 11.5F * sittingProgress;
		this.RightThigh.rotationPointY += 11.5F * sittingProgress;
		this.LeftThigh.rotationPointY += 11.5F * sittingProgress;
		this.RightThigh.rotationPointZ += 5F * sittingProgress;
		this.LeftThigh.rotationPointZ += 5F * sittingProgress;

		this.UpperArmRight.rotateAngleX += 0.25F * sittingProgress;
		this.UpperArmLeft.rotateAngleX += 0.25F * sittingProgress;
		this.LowerArmRight.rotateAngleX -= 1.2F * sittingProgress;
		this.LowerArmLeft.rotateAngleX -= 1.2F * sittingProgress;
		this.LowerArmRight.rotationPointY -= 1F * sittingProgress;
		this.LowerArmLeft.rotationPointY -= 1F * sittingProgress;
		this.LowerArmRight.rotationPointZ -= 1F * sittingProgress;
		this.LowerArmLeft.rotationPointZ -= 1F * sittingProgress;

		this.RightThigh.rotateAngleX -= 1.2F * sittingProgress;
		this.LeftThigh.rotateAngleX -= 1.2F * sittingProgress;

		this.RightCalf1.rotationPointY += 6.0F * sittingProgress;
		this.LeftCalf1.rotationPointY += 6.0F * sittingProgress;
		this.RightCalf1.rotateAngleX += 1.7F * sittingProgress;
		this.LeftCalf1.rotateAngleX += 1.7F * sittingProgress;

		this.RightCalf2.rotationPointY += 2.0F * sittingProgress;
		this.LeftCalf2.rotationPointY += 2.0F * sittingProgress;
		this.RightCalf2.rotateAngleX -= 1.2F * sittingProgress;
		this.LeftCalf2.rotateAngleX -= 1.2F * sittingProgress;

		this.FootRight.rotateAngleX += 0.7F * sittingProgress;
		this.FootLeft.rotateAngleX += 0.7F * sittingProgress;
		
		this.Tail1.rotateAngleX -= 0.3F * sittingProgress;
		this.Tail2.rotateAngleX += 0.1F * sittingProgress;
		this.Tail3.rotateAngleX += 0.15F * sittingProgress;
		this.Tail4.rotateAngleX += 0.15F * sittingProgress;
		this.Tail4.rotationPointY += 0.5F * sittingProgress;
		walk(Tail1, 0.1F, 0.03F * sittingProgress - (0.03F * restHeadProgress), true, 1, 0, trex.frame, 0.4F);
		Tail1.rotationPointY += (0.1F * sittingProgress - (0.1F * restHeadProgress)) * Math.cos((trex.frame + 1) * 0.1);
		
		this.Neck.rotateAngleX += 0.55F * restHeadProgress;
		this.Head.rotateAngleX -= 0.75F * restHeadProgress;
		this.Chest.rotateAngleX += 0.15F * restHeadProgress;
		this.UpperArmRight.rotateAngleX += 0.3F * restHeadProgress;
		this.UpperArmLeft.rotateAngleX += 0.3F * restHeadProgress;
		this.LowerArmRight.rotateAngleX -= 0.3F * restHeadProgress;
		this.LowerArmLeft.rotateAngleX -= 0.3F * restHeadProgress;
		walk(Waist, 0.08F, 0.04F * restHeadProgress, false, 0, 0, trex.frame, 1F);
		walk(Tail1, 0.08F, 0.04F * restHeadProgress, true, 0, 0, trex.frame, 1F);
		Tail1.rotationPointY += (0.2F * restHeadProgress) * Math.cos((trex.frame + 1) * 0.08);
		walk(Chest, 0.08F, 0.08F * restHeadProgress, true, 0, 0, trex.frame, 1F);
		walk(Neck, 0.08F, 0.02F * restHeadProgress, false, 0, 0, trex.frame, 1F);
		walk(Head, 0.08F, 0.02F * restHeadProgress, false, 0, 0, trex.frame, 1F);

		this.Waist.rotateAngleX += 0.38F * (sittingProgress - sittingProgressFast);
		for (int i = 0; i < this.tailParts.length; i++) {
			this.tailParts[i].rotateAngleX += 0.15F * (sittingProgress - sittingProgressFast);
		}
		
		//Idling
		this.chainWave(bodyParts, 0.1F, -0.03F - (-0.03F * restHeadProgress), 3, trex.frame, 1.0F - 0.6F * sittingProgress);
		this.chainWave(rightArmParts, -0.1F, 0.2F - (0.2F * restHeadProgress), 4, trex.frame, 1.0F - 0.6F * sittingProgress);
		this.chainWave(leftArmParts, -0.1F, 0.2F - (0.2F * restHeadProgress), 4, trex.frame, 1.0F - 0.6F * sittingProgress);

		this.chainSwing(tailParts, 0.1F, 0.05F - (0.05F * sittingProgress), 1, trex.frame, 1.0F - 0.6F * sittingProgress);
		this.chainWave(tailParts, 0.1F, -0.05F - (-0.05F * sittingProgress), 2, trex.frame, 1.0F - 0.6F * sittingProgress);

		trex.tailBuffer.applyChainSwingBuffer(tailParts);

		//Specialized animations
		this.Head.rotateAngleZ += Math.cos(trex.frame / 3) * trex.roarTiltDegree.value / 3;
		this.LowerJaw.rotateAngleX += Math.cos(trex.frame) * trex.roarTiltDegree.value / 7;
    }

    public void animate(IAnimatedEntity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
    	this.animator.update(entity);
    	this.setRotationAngles(f, f1, f2, f3, f4, f5, (EntityTyrannosaurus) entity);

        this.animator.setAnimation(1);
        this.animator.startPhase(15);
        this.animator.move(Waist, 0, -3, -5);
        this.animator.move(RightThigh, 0, -3, -5);
        this.animator.move(LeftThigh, 0, -3, -5);
        this.animator.rotate(Waist, -0.3F, 0, 0);
        this.animator.rotate(Head, 0.3F, 0, 0);
        this.animator.rotate(RightThigh, 0.3F, 0, 0);
        this.animator.rotate(RightCalf1, -0.4F, 0, 0);
        this.animator.rotate(RightCalf2, 0.4F, 0, 0);
        this.animator.rotate(FootRight, -0.3F, 0, 0);
        this.animator.rotate(LeftThigh, -0.7F, 0, 0);
        this.animator.rotate(LeftCalf1, 0.7F, 0, 0);
        this.animator.rotate(LeftCalf2, -0.5F, 0, 0);
        this.animator.rotate(FootLeft, 0.7F, 0, 0);
        this.animator.endPhase();
        this.animator.startPhase(10);
        this.animator.move(Waist, 0, 3, -10);
        this.animator.move(RightThigh, 0, 3, -10);
        this.animator.move(LeftThigh, 0, 3, -10);
        this.animator.move(Head, 0, 1, 2);
        this.animator.move(LowerJaw, 0, 0, 1);
        this.animator.rotate(Waist, 0.2F, 0, 0);
        this.animator.rotate(Neck, 0.5F, 0, 0);
        this.animator.rotate(Head, -0.9F, 0, 0);
        this.animator.rotate(LowerJaw, 0.9F, 0, 0);
        this.animator.rotate(RightThigh, 0.6F, 0, 0);
        this.animator.rotate(RightCalf1, 0.2F, 0, 0);
        this.animator.rotate(RightCalf2, -0.4F, 0, 0);
        this.animator.rotate(FootRight, -0.4F, 0, 0);
        this.animator.rotate(LeftThigh, -0.3F, 0, 0);
        this.animator.rotate(LeftCalf1, 0.2F, 0, 0);
        this.animator.rotate(LeftCalf2, -0.2F, 0, 0);
        this.animator.rotate(FootLeft, 0.3F, 0, 0);
        this.animator.endPhase();
        this.animator.setStationaryPhase(35);
        this.animator.resetPhase(15);

        this.animator.setAnimation(2);
        this.animator.startPhase(15);
        this.animator.rotate(Neck, -0.4F, 0, 0);
        this.animator.rotate(Head, 0.8F, 0, 0);
        this.animator.endPhase();
        this.animator.startPhase(10);
        this.animator.rotate(Neck, 0.8F, 0, 0);
        this.animator.rotate(Head, -0.8F, 0, 0);
        this.animator.rotate(LowerJaw, 0.8F, 0, 0);
        this.animator.endPhase();
        this.animator.setStationaryPhase(35);
        this.animator.resetPhase(15);

        this.animator.setAnimation(3);
        this.animator.startPhase(8);
        this.animator.rotate(Waist, -0.35F, 0.0F, 0.0F);
        this.animator.rotate(Tail1, 0.15F, 0.0F, 0.0F);
        this.animator.rotate(Tail2, 0.125F, 0.0F, 0.0F);
        this.animator.rotate(Tail3, 0.1F, 0.0F, 0.0F);
        this.animator.rotate(Tail4, 0.1F, 0.0F, 0.0F);
        this.animator.rotate(Tail5, 0.1F, 0.0F, 0.0F);
        this.animator.rotate(LowerJaw, 0.3F, 0.0F, 0.0F);
        this.animator.endPhase();
        this.animator.setStationaryPhase(2);
        this.animator.startPhase(4);
        this.animator.rotate(Waist, -0.15F, 0.0F, 0.0F);
        this.animator.rotate(Body, 0.25F, 0.0F, 0.0F);
        this.animator.rotate(Chest, 0.3F, 0.0F, 0.0F);
        this.animator.rotate(Neck, 0.25F, 0.0F, 0.0F);
        this.animator.rotate(LowerJaw, 0.6F, 0.0F, 0.0F);
        this.animator.endPhase();
        this.animator.startPhase(4);
        this.animator.rotate(Body, 0.0F, -0.05F, 0.0F);
        this.animator.rotate(Chest, 0.0F, -0.05F, 0.0F);
        this.animator.rotate(Neck, 0.0F, -0.2F, 0.0F);
        this.animator.rotate(Head, 0.0F, -0.1F, 0.0F);
        this.animator.rotate(LowerJaw, 0.7F, 0.0F, 0.0F);
        this.animator.endPhase();
        this.animator.startPhase(4);
        this.animator.rotate(Body, 0.0F, -0.05F, 0.0F);
        this.animator.rotate(Chest, 0.0F, -0.05F, 0.0F);
        this.animator.rotate(Neck, 0.0F, -0.2F, 0.0F);
        this.animator.rotate(Head, 0.0F, -0.1F, 0.0F);
        this.animator.rotate(LowerJaw, 0.7F, 0.0F, 0.0F);
        this.animator.endPhase();
        this.animator.startPhase(8);
        this.animator.rotate(Body, 0.0F, 0.2F, 0.0F);
        this.animator.rotate(Chest, 0.0F, 0.2F, 0.0F);
        this.animator.rotate(Neck, 0.0F, 0.8F, 0.0F);
        this.animator.rotate(Head, 0.0F, 0.4F, 0.0F);
        this.animator.rotate(LowerJaw, 0.7F, 0.0F, 0.0F);
        this.animator.endPhase();
        this.animator.startPhase(8);
        this.animator.rotate(Body, 0.0F, -0.2F, 0.0F);
        this.animator.rotate(Chest, 0.0F, -0.2F, 0.0F);
        this.animator.rotate(Neck, 0.0F, -0.8F, 0.0F);
        this.animator.rotate(Head, 0.0F, -0.4F, 0.0F);
        this.animator.rotate(LowerJaw, 0.7F, 0.0F, 0.0F);
        this.animator.endPhase();
        this.animator.startPhase(8);
        this.animator.rotate(Body, 0.0F, 0.2F, 0.0F);
        this.animator.rotate(Chest, 0.0F, 0.2F, 0.0F);
        this.animator.rotate(Neck, 0.0F, 0.8F, 0.0F);
        this.animator.rotate(Head, 0.0F, 0.4F, 0.0F);
        this.animator.rotate(LowerJaw, 0.7F, 0.0F, 0.0F);
        this.animator.endPhase();
        this.animator.startPhase(2);
        this.animator.rotate(LowerJaw, 0.0F, 0.0F, 0.0F);
        this.animator.endPhase();
        this.animator.resetPhase(2);
        
        this.animator.setAnimation(5);
        this.animator.startPhase(6);
        this.animator.rotate(Neck, -0.3F, 0, 0);
        this.animator.rotate(Head, 0.5F, 0, 0);
        this.animator.rotate(LowerJaw, 1F, 0, 0);
        this.animator.endPhase();
        this.animator.setStationaryPhase(1);
        this.animator.startPhase(3);
        this.animator.rotate(Neck, 0.8F, 0, 0);
        this.animator.rotate(Head, -0.5F, 0, 0);
        this.animator.endPhase();
        this.animator.setStationaryPhase(2);
        this.animator.resetPhase(8);
    }
}
