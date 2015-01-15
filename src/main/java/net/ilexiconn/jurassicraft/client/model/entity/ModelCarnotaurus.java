package net.ilexiconn.jurassicraft.client.model.entity;

import net.ilexiconn.jurassicraft.client.model.modelbase.MowzieModelBase;
import net.ilexiconn.jurassicraft.client.model.modelbase.MowzieModelRenderer;
import net.ilexiconn.jurassicraft.entity.dinosaurs.EntityCarnotaurus;
import net.minecraft.entity.Entity;

public class ModelCarnotaurus extends MowzieModelBase 
{
	public MowzieModelRenderer bodyMain;
	public MowzieModelRenderer upperArmRight;
	public MowzieModelRenderer upperArmLeft;
	public MowzieModelRenderer tail1;
	public MowzieModelRenderer body2;
	public MowzieModelRenderer leftThigh;
	public MowzieModelRenderer rightThigh;
	public MowzieModelRenderer tail2;
	public MowzieModelRenderer tail3;
	public MowzieModelRenderer tail4;
	public MowzieModelRenderer tail5;
	public MowzieModelRenderer tail6;
	public MowzieModelRenderer body1;
	public MowzieModelRenderer neck;
	public MowzieModelRenderer head;
	public MowzieModelRenderer hornLeft;
	public MowzieModelRenderer hornRight;
	public MowzieModelRenderer upperJaw;
	public MowzieModelRenderer teeth;
	public MowzieModelRenderer lowerJaw;
	public MowzieModelRenderer leftCalf1;
	public MowzieModelRenderer leftUpperFoot;
	public MowzieModelRenderer footLeft;
	public MowzieModelRenderer rightCalf1;
	public MowzieModelRenderer rightUpperFoot;
	public MowzieModelRenderer footRight;
	public MowzieModelRenderer rightHand;
	public MowzieModelRenderer leftHand;
	public MowzieModelRenderer[] tailParts;

	public ModelCarnotaurus() 
	{
        this.textureWidth = 256;
        this.textureHeight = 256;
        
        this.hornLeft = new MowzieModelRenderer(this, 1, 110);
        this.hornLeft.setRotationPoint(1.0F, -1.0F, -1.0F);
        this.hornLeft.addBox(-1.25F, -3.25F, -0.5F, 2, 3, 1);
        this.setRotateAngle(hornLeft, 2.530727415391778F, -1.48352986419518F, -1.5707963267948966F);
        this.footRight = new MowzieModelRenderer(this, 20, 0);
        this.footRight.setRotationPoint(0.0F, 4.4F, -0.5F);
        this.footRight.addBox(-2.0F, 0.0F, -3.0F, 4, 2, 6);
        this.setRotateAngle(footRight, 0.6457718232379019F, 0.0F, 0.0F);
        this.upperArmLeft = new MowzieModelRenderer(this, 0, 56);
        this.upperArmLeft.setRotationPoint(4.5F, 4.0F, -6.0F);
        this.upperArmLeft.addBox(-1.0F, 0.0F, 0.0F, 2, 2, 5);
        this.setRotateAngle(upperArmLeft, -0.9599310885968813F, 0.0F, 0.0F);
        this.tail2 = new MowzieModelRenderer(this, 119, 61);
        this.tail2.setRotationPoint(0.0F, 0.0F, 6.5F);
        this.tail2.addBox(-3.5F, -3.5F, 0.0F, 7, 7, 8);
        this.setRotateAngle(tail2, 0.05235987755982988F, 0.0F, 0.0F);
        this.tail3 = new MowzieModelRenderer(this, 152, 82);
        this.tail3.setRotationPoint(0.0F, 0.0F, 6.5F);
        this.tail3.addBox(-3.0F, -3.0F, 0.0F, 6, 6, 8);
        this.setRotateAngle(tail3, 0.05235987755982988F, 0.0F, 0.0F);
        this.tail5 = new MowzieModelRenderer(this, 118, 100);
        this.tail5.setRotationPoint(0.0F, 0.0F, 7.0F);
        this.tail5.addBox(-1.5F, -2.0F, 0.0F, 3, 4, 11);
        this.setRotateAngle(tail5, 0.017453292519943295F, 0.0F, 0.0F);
        this.body2 = new MowzieModelRenderer(this, 118, 139);
        this.body2.setRotationPoint(0.0F, 0.0F, -11.0F);
        this.body2.addBox(-4.5F, -4.0F, -9.0F, 9, 10, 11);
        this.setRotateAngle(body2, -0.017453292519943295F, 0.0F, 0.0F);
        this.bodyMain = new MowzieModelRenderer(this, 118, 0);
        this.bodyMain.setRotationPoint(0.0F, 4.5F, 7.0F);
        this.bodyMain.addBox(-5.0F, -4.2F, -11.0F, 10, 11, 11);
        this.setRotateAngle(bodyMain, -0.06981317007977318F, 0.0F, 0.0F);
        this.teeth = new MowzieModelRenderer(this, 30, 36);
        this.teeth.setRotationPoint(0.0F, 0.2F, -1.2F);
        this.teeth.addBox(-2.5F, -3.5F, 0.0F, 5, 1, 6);
        this.setRotateAngle(teeth, -3.1066860685499065F, 0.0F, 0.0F);
        this.rightThigh = new MowzieModelRenderer(this, 57, 57);
        this.rightThigh.setRotationPoint(-5.0F, 2.0F, -3.25F);
        this.rightThigh.addBox(-2.5F, -3.0F, -8.0F, 5, 6, 10);
        this.setRotateAngle(rightThigh, 1.1519173063162573F, 0.0F, 0.0F);
        this.lowerJaw = new MowzieModelRenderer(this, 71, 27);
        this.lowerJaw.setRotationPoint(0.0F, 2.75F, -1.2F);
        this.lowerJaw.addBox(-2.0F, -1.5F, 0.0F, 4, 2, 5);
        this.setRotateAngle(lowerJaw, 3.1066860685499065F, 0.0F, 0.0F);
        this.leftCalf1 = new MowzieModelRenderer(this, 65, 0);
        this.leftCalf1.setRotationPoint(0.0F, -1.4F, -6.1F);
        this.leftCalf1.addBox(-1.5F, 0.0F, -1.5F, 3, 10, 3);
        this.setRotateAngle(leftCalf1, -0.5585053606381855F, 0.0F, 0.0F);
        this.body1 = new MowzieModelRenderer(this, 182, 0);
        this.body1.setRotationPoint(0.0F, 0.0F, -8.0F);
        this.body1.addBox(-4.0F, -3.5F, -3.5F, 8, 8, 8);
        this.setRotateAngle(body1, -0.12217304763960307F, 0.0F, 0.0F);
        this.neck = new MowzieModelRenderer(this, 217, 0);
        this.neck.setRotationPoint(0.0F, 0.0F, -3.0F);
        this.neck.addBox(-2.5F, -2.75F, -9.0F, 5, 6, 11);
        this.setRotateAngle(neck, -0.3490658503988659F, 0.0F, 0.0F);
        this.head = new MowzieModelRenderer(this, 0, 93);
        this.head.setRotationPoint(0.0F, 0.0F, -9.0F);
        this.head.addBox(-3.0F, -2.5F, -3.0F, 6, 7, 5);
        this.setRotateAngle(head, 0.6457718232379019F, 0.0F, 0.0F);
        this.rightUpperFoot = new MowzieModelRenderer(this, 89, 3);
        this.rightUpperFoot.setRotationPoint(0.0F, 9.0F, 0.0F);
        this.rightUpperFoot.addBox(-1.5F, -1.0F, -1.25F, 3, 6, 3);
        this.setRotateAngle(rightUpperFoot, -1.1693705988362009F, 0.0F, 0.0F);
        this.rightCalf1 = new MowzieModelRenderer(this, 53, 0);
        this.rightCalf1.setRotationPoint(0.0F, -1.4F, -6.1F);
        this.rightCalf1.addBox(-1.5F, 0.0F, -1.5F, 3, 10, 3);
        this.setRotateAngle(rightCalf1, -0.5585053606381855F, 0.0F, 0.0F);
        this.rightHand = new MowzieModelRenderer(this, 0, 68);
        this.rightHand.setRotationPoint(-0.5F, 1.0F, 5.0F);
        this.rightHand.addBox(-1.0F, -0.75F, -1.25F, 1, 2, 2);
        this.setRotateAngle(rightHand, 2.0943951023931953F, 0.0F, 0.0F);
        this.leftHand = new MowzieModelRenderer(this, 0, 68);
        this.leftHand.setRotationPoint(0.5F, 1.0F, 5.0F);
        this.leftHand.addBox(0.0F, -0.75F, -1.25F, 1, 2, 2);
        this.setRotateAngle(leftHand, 2.0943951023931953F, 0.0F, 0.0F);
        this.leftThigh = new MowzieModelRenderer(this, 27, 57);
        this.leftThigh.setRotationPoint(5.0F, 2.0F, -3.25F);
        this.leftThigh.addBox(-2.5F, -3.0F, -8.0F, 5, 6, 10);
        this.setRotateAngle(leftThigh, 1.1519173063162573F, 0.0F, 0.0F);
        this.tail1 = new MowzieModelRenderer(this, 121, 41);
        this.tail1.setRotationPoint(0.0F, 0.0F, -1.0F);
        this.tail1.addBox(-4.0F, -4.0F, 0.0F, 8, 8, 8);
        this.setRotateAngle(tail1, -0.05235987755982988F, 0.0F, 0.0F);
        this.footLeft = new MowzieModelRenderer(this, 0, 0);
        this.footLeft.setRotationPoint(0.0F, 4.4F, -0.5F);
        this.footLeft.addBox(-2.0F, 0.0F, -3.0F, 4, 2, 6);
        this.setRotateAngle(footLeft, 0.6457718232379019F, 0.0F, 0.0F);
        this.tail4 = new MowzieModelRenderer(this, 119, 79);
        this.tail4.setRotationPoint(0.0F, 0.0F, 6.0F);
        this.tail4.addBox(-2.0F, -2.5F, 0.0F, 4, 5, 9);
        this.setRotateAngle(tail4, -0.05235987755982988F, 0.0F, 0.0F);
        this.hornRight = new MowzieModelRenderer(this, 1, 110);
        this.hornRight.setRotationPoint(-1.0F, -1.0F, -1.0F);
        this.hornRight.addBox(-1.25F, -3.25F, -0.5F, 2, 3, 1);
        this.setRotateAngle(hornRight, 0.6108652381980153F, -1.48352986419518F, -1.5707963267948966F);
        this.upperJaw = new MowzieModelRenderer(this, 30, 21);
        this.upperJaw.setRotationPoint(0.0F, 0.2F, -1.2F);
        this.upperJaw.addBox(-2.5F, -2.5F, 0.0F, 5, 5, 6);
        this.setRotateAngle(upperJaw, -3.1066860685499065F, 0.0F, 0.0F);
        this.leftUpperFoot = new MowzieModelRenderer(this, 77, 3);
        this.leftUpperFoot.setRotationPoint(0.0F, 9.0F, 0.0F);
        this.leftUpperFoot.addBox(-1.5F, -1.0F, -1.25F, 3, 6, 3);
        this.setRotateAngle(leftUpperFoot, -1.1693705988362009F, 0.0F, 0.0F);
        this.upperArmRight = new MowzieModelRenderer(this, 0, 56);
        this.upperArmRight.setRotationPoint(-4.5F, 4.0F, -6.0F);
        this.upperArmRight.addBox(-1.0F, 0.0F, 0.0F, 2, 2, 5);
        this.setRotateAngle(upperArmRight, -0.9599310885968813F, 0.0F, 0.0F);
        this.tail6 = new MowzieModelRenderer(this, 119, 118);
        this.tail6.setRotationPoint(0.0F, 0.0F, 9.0F);
        this.tail6.addBox(-1.0F, -1.5F, 0.0F, 2, 3, 11);
        this.setRotateAngle(tail6, 0.05235987755982988F, 0.0F, 0.0F);

        this.bodyMain.addChild(this.body2);
        this.body2.addChild(this.body1);
        this.body1.addChild(this.neck);
        this.neck.addChild(this.head);
        this.head.addChild(this.hornRight);
        this.head.addChild(this.hornLeft);
        this.head.addChild(this.upperJaw);
        this.head.addChild(this.lowerJaw);
        this.head.addChild(this.teeth);

        this.body2.addChild(this.upperArmLeft);
        this.upperArmLeft.addChild(this.leftHand);
        
        this.body2.addChild(this.upperArmRight);
        this.upperArmRight.addChild(this.rightHand);

        this.bodyMain.addChild(this.leftThigh);
        this.leftThigh.addChild(this.leftCalf1);
        this.leftCalf1.addChild(this.leftUpperFoot);
        this.leftUpperFoot.addChild(this.footLeft);
        
        this.bodyMain.addChild(this.rightThigh);
        this.rightThigh.addChild(this.rightCalf1);
        this.rightCalf1.addChild(this.rightUpperFoot);
        this.rightUpperFoot.addChild(this.footRight);

        this.bodyMain.addChild(this.tail1);
        this.tail1.addChild(this.tail2);
        this.tail2.addChild(this.tail3);
        this.tail3.addChild(this.tail4);
        this.tail4.addChild(this.tail5);
        this.tail5.addChild(this.tail6);

		this.tailParts = new MowzieModelRenderer[] { this.tail5, this.tail4, this.tail3, this.tail2, this.tail1 };

        this.bodyMain.setInitValuesToCurrentPose();
        this.upperArmRight.setInitValuesToCurrentPose();
        this.upperArmLeft.setInitValuesToCurrentPose();
        this.tail1.setInitValuesToCurrentPose();
        this.body2.setInitValuesToCurrentPose();
        this.leftThigh.setInitValuesToCurrentPose();
        this.rightThigh.setInitValuesToCurrentPose();
        this.tail2.setInitValuesToCurrentPose();
        this.tail3.setInitValuesToCurrentPose();
        this.tail4.setInitValuesToCurrentPose();
        this.tail5.setInitValuesToCurrentPose();
        this.tail6.setInitValuesToCurrentPose();
        this.body1.setInitValuesToCurrentPose();
        this.neck.setInitValuesToCurrentPose();
        this.head.setInitValuesToCurrentPose();
        this.hornLeft.setInitValuesToCurrentPose();
        this.hornRight.setInitValuesToCurrentPose();
        this.upperJaw.setInitValuesToCurrentPose();
        this.teeth.setInitValuesToCurrentPose();
        this.lowerJaw.setInitValuesToCurrentPose();
        this.leftCalf1.setInitValuesToCurrentPose();
        this.leftUpperFoot.setInitValuesToCurrentPose();
        this.footLeft.setInitValuesToCurrentPose();
        this.rightCalf1.setInitValuesToCurrentPose();
        this.rightUpperFoot.setInitValuesToCurrentPose();
        this.footRight.setInitValuesToCurrentPose();
        this.rightHand.setInitValuesToCurrentPose();
        this.leftHand.setInitValuesToCurrentPose();
    }

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) 
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		this.setRotationAngles(f, f1, f2, f3, f4, f5, (EntityCarnotaurus) entity);
		this.bodyMain.render(f5);
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, EntityCarnotaurus carnotaurus) 
	{
		super.setRotationAngles(f, f1, f2, f3, f4, f5, carnotaurus);
		this.resetPose();

		//running
		this.walk(this.bodyMain, 0.125F, 0.05F, false, 0.0F, 0.15F, f, f1);
		this.walk(this.tail1, 0.125F, 0.01F, false, 0.0F, -0.1F, f, f1);
		
		this.walk(this.upperArmRight, 0.25F, 0.0F, false, 0.0F, 0.85F, 1.0F, f1);
		this.walk(this.upperArmLeft, 0.25F, 0.0F, false, 0.0F, 0.85F, 1.0F, f1);
		
		this.walk(this.leftThigh, 0.25F, 0.5F, false, 0.0F, 0.25F, f, f1);
		this.walk(this.leftCalf1, 0.25F, 0.4F, true, 1.0F, 0.4F, f, f1);
		this.walk(this.leftUpperFoot, 0.25F, 0.4F, false, 0.0F, 0.0F, f, f1);
		this.walk(this.footLeft, 0.25F, 0.4F, true, 0.4F, -0.15F, f, f1);

		this.walk(this.rightThigh, 0.25F, 0.5F, true, 0.0F, 0.25F, f, f1);
		this.walk(this.rightCalf1, 0.25F, 0.4F, false, 1.0F, 0.4F, f, f1);
		this.walk(this.rightUpperFoot, 0.25F, 0.4F, true, 0.0F, 0.0F, f, f1);
		this.walk(this.footRight, 0.25F, 0.4F, false, 0.4F, -0.15F, f, f1);
		
		
		//Idle
		
		this.faceTarget(this.body2, 4, f3, f4);
		this.faceTarget(this.body1, 4, f3, f4);
		this.faceTarget(this.neck, 4, f3, f4);
		this.faceTarget(this.head, 4, f3, f4);

		this.walk(this.body2, 0.03F, 0.08F, false, 0.0F, 0.025F, carnotaurus.frame, 1.0F);
		this.walk(this.bodyMain, 0.03F, 0.03F, false, 0.05F, 0.015F, carnotaurus.frame, 1.0F);
		this.walk(this.leftThigh, 0.03F, 0.03F, true, 0.05F, 0.015F, carnotaurus.frame, 1.0F);
		this.walk(this.rightThigh, 0.03F, 0.03F, true, 0.05F, 0.015F, carnotaurus.frame, 1.0F);
		
		this.walk(this.upperArmRight, 0.03F, 0.3F, true, 0.05F, 0.0F, carnotaurus.frame, 1.0F);
		this.walk(this.upperArmLeft, 0.03F, 0.3F, true, 0.05F, 0.0F, carnotaurus.frame, 1.0F);

		this.walk(this.lowerJaw, 0.03F, 0.1F, false, 0.005F, 0.0F, carnotaurus.frame, 1.0F);
		
		this.chainSwing(this.tailParts, 0.08F, 0.06F, 1, carnotaurus.frame, 1.0F);
		this.chainWave(this.tailParts, 0.08F, -0.06F, 2, carnotaurus.frame, 1.0F);
		
		carnotaurus.tailBuffer.chainSwingBuffer(this.tailParts, 70.0F, 5, 2.5F, 5.0F, carnotaurus);
	}
	
	public void setRotateAngle(MowzieModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

    public void resetPose()
    {
        this.bodyMain.setCurrentPoseToInitValues();
        this.upperArmRight.setCurrentPoseToInitValues();
        this.upperArmLeft.setCurrentPoseToInitValues();
        this.tail1.setCurrentPoseToInitValues();
        this.body2.setCurrentPoseToInitValues();
        this.leftThigh.setCurrentPoseToInitValues();
        this.rightThigh.setCurrentPoseToInitValues();
        this.tail2.setCurrentPoseToInitValues();
        this.tail3.setCurrentPoseToInitValues();
        this.tail4.setCurrentPoseToInitValues();
        this.tail5.setCurrentPoseToInitValues();
        this.tail6.setCurrentPoseToInitValues();
        this.body1.setCurrentPoseToInitValues();
        this.neck.setCurrentPoseToInitValues();
        this.head.setCurrentPoseToInitValues();
        this.hornLeft.setCurrentPoseToInitValues();
        this.hornRight.setCurrentPoseToInitValues();
        this.upperJaw.setCurrentPoseToInitValues();
        this.teeth.setCurrentPoseToInitValues();
        this.lowerJaw.setCurrentPoseToInitValues();
        this.leftCalf1.setCurrentPoseToInitValues();
        this.leftUpperFoot.setCurrentPoseToInitValues();
        this.footLeft.setCurrentPoseToInitValues();
        this.rightCalf1.setCurrentPoseToInitValues();
        this.rightUpperFoot.setCurrentPoseToInitValues();
        this.footRight.setCurrentPoseToInitValues();
        this.rightHand.setCurrentPoseToInitValues();
        this.leftHand.setCurrentPoseToInitValues();
    }
}
