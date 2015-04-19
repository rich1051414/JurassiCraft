package net.ilexiconn.jurassicraft.client.model.entity;

import net.ilexiconn.jurassicraft.client.model.animation.Animator;
import net.ilexiconn.jurassicraft.client.model.modelbase.MowzieModelBase;
import net.ilexiconn.jurassicraft.client.model.modelbase.MowzieModelRenderer;
import net.ilexiconn.jurassicraft.entity.dinosaurs.EntityParasaurolophus;
import net.ilexiconn.jurassicraft.enums.JurassiCraftAnimationIDs;
import net.ilexiconn.jurassicraft.interfaces.IAnimatedEntity;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

public class ModelParasaurolophus extends MowzieModelBase
{
    public boolean isAlarmed;
    private Animator animator;

    public double[] modelScale = new double[] { 0.7D, 0.7D, 0.7D };
    public MowzieModelRenderer LeftThigh;
    public MowzieModelRenderer RightThigh;
    public MowzieModelRenderer Body3;
    public MowzieModelRenderer LeftCalf1;
    public MowzieModelRenderer LeftUpperFoot;
    public MowzieModelRenderer FootLeft;
    public MowzieModelRenderer RightCalf1;
    public MowzieModelRenderer RightUpperFoot;
    public MowzieModelRenderer FootRight;
    public MowzieModelRenderer Tail1;
    public MowzieModelRenderer Body1;
    public MowzieModelRenderer Tail2;
    public MowzieModelRenderer Tail3;
    public MowzieModelRenderer Tail4;
    public MowzieModelRenderer Tail5;
    public MowzieModelRenderer Tail6;
    public MowzieModelRenderer Body2;
    public MowzieModelRenderer UpperArmLeft;
    public MowzieModelRenderer UpperArmRight;
    public MowzieModelRenderer Neck;
    public MowzieModelRenderer Neck2;
    public MowzieModelRenderer NeckMerge;
    public MowzieModelRenderer Neck3;
    public MowzieModelRenderer Neck6;
    public MowzieModelRenderer Neck8;
    public MowzieModelRenderer Head;
    public MowzieModelRenderer Snout1;
    public MowzieModelRenderer Jaw;
    public MowzieModelRenderer Crest1;
    public MowzieModelRenderer Crestmembrane;
    public MowzieModelRenderer Neck7Chin;
    public MowzieModelRenderer Snout2;
    public MowzieModelRenderer Crest2;
    public MowzieModelRenderer Crest3;
    public MowzieModelRenderer Crest4;
    public MowzieModelRenderer LowerArmLeft;
    public MowzieModelRenderer LeftHand;
    public MowzieModelRenderer LeftFingers;
    public MowzieModelRenderer LowerArmRight;
    public MowzieModelRenderer RightHand;
    public MowzieModelRenderer RightFingers;
    
    public ModelParasaurolophus()
    {
        textureWidth = 256;
        textureHeight = 256;
        
        animator = new Animator(this);

        this.Tail1 = new MowzieModelRenderer(this, 0, 92);
        this.Tail1.setRotationPoint(2.0F, -10.3F, 3.3F);
        this.Tail1.addBox(-4.5F, 0.0F, 2.0F, 11, 13, 12, 0.0F);
        this.setRotateAngle(Tail1, -0.0747000919853573F, -0.0F, 0.0F);
        this.LeftThigh = new MowzieModelRenderer(this, 121, 165);
        this.LeftThigh.setRotationPoint(6.0F, -8.8F, 2.3F);
        this.LeftThigh.addBox(0.0F, -2.1F, -13.9F, 5, 10, 20, 0.0F);
        this.setRotateAngle(LeftThigh, 1.0276498635742612F, -0.0F, 0.0F);
        this.RightThigh = new MowzieModelRenderer(this, 65, 165);
        this.RightThigh.setRotationPoint(-6.0F, -8.8F, 2.3F);
        this.RightThigh.addBox(-5.0F, -2.1F, -13.9F, 5, 10, 20, 0.0F);
        this.setRotateAngle(RightThigh, 1.0276498635742612F, -0.0F, 0.0F);
        this.LeftHand = new MowzieModelRenderer(this, 15, 76);
        this.LeftHand.setRotationPoint(-0.5F, 9.9F, 1.1F);
        this.LeftHand.addBox(-1.0F, -1.0F, -0.5F, 3, 3, 1, 0.0F);
        this.setRotateAngle(LeftHand, 0.5171410573659198F, -0.0F, 0.0F);
        this.Snout1 = new MowzieModelRenderer(this, 29, 202);
        this.Snout1.setRotationPoint(0.0F, 1.9F, -4.0F);
        this.Snout1.addBox(-2.5F, 0.0F, -6.0F, 5, 3, 4, 0.0F);
        this.Tail6 = new MowzieModelRenderer(this, 191, 102);
        this.Tail6.setRotationPoint(0.0F, 0.2F, 8.9F);
        this.Tail6.addBox(-1.0F, 0.0F, 0.8F, 2, 3, 10, 0.0F);
        this.setRotateAngle(Tail6, -0.038571776469074684F, -0.0F, 0.0F);
        this.Neck3 = new MowzieModelRenderer(this, 62, 145);
        this.Neck3.setRotationPoint(0.5F, 2.1F, -2.0F);
        this.Neck3.addBox(-2.5F, 0.0F, -5.0F, 5, 6, 5, 0.0F);
        this.setRotateAngle(Neck3, -0.3986332011555048F, -0.0F, 0.0F);
        this.UpperArmRight = new MowzieModelRenderer(this, 0, 45);
        this.UpperArmRight.setRotationPoint(-6.0F, 14.2F, -8.5F);
        this.UpperArmRight.addBox(0.0F, 0.0F, 0.0F, 3, 4, 9, 0.0F);
        this.setRotateAngle(UpperArmRight, -1.5437437233889846F, -0.0F, 0.0F);
        this.RightUpperFoot = new MowzieModelRenderer(this, 65, 220);
        this.RightUpperFoot.setRotationPoint(0.5F, 6.9F, -0.7F);
        this.RightUpperFoot.addBox(-2.0F, 0.5F, 0.5F, 3, 8, 3, 0.0F);
        this.setRotateAngle(RightUpperFoot, -0.9679596031560551F, -0.0F, 0.0F);
        this.LeftFingers = new MowzieModelRenderer(this, 15, 87);
        this.LeftFingers.setRotationPoint(0.0F, 1.8F, -1.1F);
        this.LeftFingers.addBox(-1.0F, -1.0F, -0.5F, 3, 1, 1, 0.0F);
        this.setRotateAngle(LeftFingers, -1.3042845500153626F, -0.0F, 0.0F);
        this.FootRight = new MowzieModelRenderer(this, 110, 200);
        this.FootRight.setRotationPoint(-0.6F, 7.0F, 3.3F);
        this.FootRight.addBox(-2.0F, -2.0F, -1.0F, 4, 2, 6, 0.0F);
        this.setRotateAngle(FootRight, -2.7209683038591597F, -0.0F, 0.0F);
        this.Body3 = new MowzieModelRenderer(this, 9, 13);
        this.Body3.setRotationPoint(-3.0F, -9.9F, 4.7F);
        this.Body3.addBox(-5.5F, -10.0F, -5.2F, 17, 18, 11, 0.0F);
        this.setRotateAngle(Body3, 0.03874630939427412F, -0.0F, 0.0F);
        this.LowerArmRight = new MowzieModelRenderer(this, 0, 60);
        this.LowerArmRight.setRotationPoint(1.5F, 2.7F, 7.0F);
        this.LowerArmRight.addBox(-1.0F, 0.0F, 0.0F, 2, 9, 2, 0.0F);
        this.setRotateAngle(LowerArmRight, 0.7430693057604804F, -0.0F, 0.0F);
        this.Crest3 = new MowzieModelRenderer(this, 0, 170);
        this.Crest3.setRotationPoint(0.0F, 4.3F, 0.1F);
        this.Crest3.addBox(-1.0F, 0.0F, 0.0F, 2, 5, 2, 0.0F);
        this.setRotateAngle(Crest3, -0.12756633457745262F, -0.0F, 0.0F);
        this.Snout2 = new MowzieModelRenderer(this, 29, 190);
        this.Snout2.setRotationPoint(0.0F, -2.2F, -0.2F);
        this.Snout2.addBox(-2.0F, 0.0F, -6.0F, 4, 2, 5, 0.0F);
        this.setRotateAngle(Snout2, 0.39706240482870997F, -0.0F, 0.0F);
        this.UpperArmLeft = new MowzieModelRenderer(this, 31, 45);
        this.UpperArmLeft.setRotationPoint(9.0F, 14.2F, -8.5F);
        this.UpperArmLeft.addBox(0.0F, 0.0F, 0.0F, 3, 4, 9, 0.0F);
        this.setRotateAngle(UpperArmLeft, -1.5437437233889846F, -0.0F, 0.0F);
        this.LeftCalf1 = new MowzieModelRenderer(this, 90, 200);
        this.LeftCalf1.setRotationPoint(2.5F, 3.0F, -9.5F);
        this.LeftCalf1.addBox(-1.5F, 0.0F, -4.1F, 3, 11, 5, 0.0F);
        this.setRotateAngle(LeftCalf1, -0.49253191491279974F, -0.0F, 0.0F);
        this.Head = new MowzieModelRenderer(this, 0, 197);
        this.Head.setRotationPoint(0.0F, -0.6F, -5.6F);
        this.Head.addBox(-3.0F, 0.0F, -6.0F, 6, 6, 7, 0.0F);
        this.setRotateAngle(Head, 0.9560913642424937F, -0.0F, 0.0F);
        this.Neck7Chin = new MowzieModelRenderer(this, 153, 145);
        this.Neck7Chin.setRotationPoint(0.5F, 3.1F, -1.1F);
        this.Neck7Chin.addBox(-2.5F, 0.0F, -2.9F, 4, 4, 7, 0.0F);
        this.setRotateAngle(Neck7Chin, -0.5009094953223726F, -0.0F, 0.0F);
        this.Crest1 = new MowzieModelRenderer(this, 0, 170);
        this.Crest1.setRotationPoint(0.0F, 3.5F, -8.1F);
        this.Crest1.addBox(-1.0F, 0.0F, 0.0F, 2, 5, 2, 0.0F);
        this.setRotateAngle(Crest1, 2.090555378038808F, -0.0F, 0.0F);
        this.RightHand = new MowzieModelRenderer(this, 0, 76);
        this.RightHand.setRotationPoint(-0.5F, 9.9F, 1.1F);
        this.RightHand.addBox(-1.0F, -1.0F, -0.5F, 3, 3, 1, 0.0F);
        this.setRotateAngle(RightHand, 0.517209334765626F, -0.0F, 0.0F);
        this.Tail5 = new MowzieModelRenderer(this, 157, 99);
        this.Tail5.setRotationPoint(0.0F, 0.6F, 7.0F);
        this.Tail5.addBox(-1.5F, 0.0F, 0.0F, 3, 4, 12, 0.0F);
        this.setRotateAngle(Tail5, -0.079412480965742F, -0.0F, 0.0F);
        this.Body2 = new MowzieModelRenderer(this, 151, 15);
        this.Body2.setRotationPoint(2.0F, -0.8F, -8.4F);
        this.Body2.addBox(-4.0F, 0.0F, -6.0F, 10, 17, 8, 0.0F);
        this.setRotateAngle(Body2, 0.12461650859239512F, -0.0F, 0.0F);
        this.FootLeft = new MowzieModelRenderer(this, 135, 200);
        this.FootLeft.setRotationPoint(-0.5F, 7.0F, 3.3F);
        this.FootLeft.addBox(-2.0F, -2.0F, -1.0F, 4, 2, 6, 0.0F);
        this.setRotateAngle(FootLeft, -2.7225391001859545F, -0.0F, 0.0F);
        this.LeftUpperFoot = new MowzieModelRenderer(this, 80, 220);
        this.LeftUpperFoot.setRotationPoint(0.5F, 6.9F, -0.7F);
        this.LeftUpperFoot.addBox(-2.1F, 0.5F, 0.5F, 3, 8, 3, 0.0F);
        this.setRotateAngle(LeftUpperFoot, -0.9679596031560551F, -0.0F, 0.0F);
        this.Crest2 = new MowzieModelRenderer(this, 0, 170);
        this.Crest2.setRotationPoint(0.0F, 4.5F, 0.0F);
        this.Crest2.addBox(-1.0F, 0.0F, 0.0F, 2, 5, 2, 0.0F);
        this.setRotateAngle(Crest2, -0.18133970928221083F, -0.0F, 0.0F);
        this.Crestmembrane = new MowzieModelRenderer(this, 0, 185);
        this.Crestmembrane.setRotationPoint(2.0F, -1.1F, 2.7F);
        this.Crestmembrane.addBox(-2.5F, 0.0F, -2.9F, 1, 5, 3, 0.0F);
        this.setRotateAngle(Crestmembrane, -0.42167154728183F, -0.0F, 0.0F);
        this.Tail2 = new MowzieModelRenderer(this, 48, 98);
        this.Tail2.setRotationPoint(1.0F, 0.9F, 13.2F);
        this.Tail2.addBox(-4.0F, 0.0F, 0.0F, 8, 10, 10, 0.0F);
        this.setRotateAngle(Tail2, -0.05288347633542818F, -0.0F, 0.0F);
        this.NeckMerge = new MowzieModelRenderer(this, 33, 139);
        this.NeckMerge.setRotationPoint(1.0F, 1.2F, -3.2F);
        this.NeckMerge.addBox(-2.5F, 0.0F, -5.0F, 5, 5, 5, 0.0F);
        this.setRotateAngle(NeckMerge, 0.8503244115716373F, -0.0F, 0.0F);
        this.LowerArmLeft = new MowzieModelRenderer(this, 21, 60);
        this.LowerArmLeft.setRotationPoint(1.5F, 2.7F, 7.0F);
        this.LowerArmLeft.addBox(-1.0F, 0.0F, 0.0F, 2, 9, 2, 0.0F);
        this.setRotateAngle(LowerArmLeft, 0.742986662573986F, -0.0F, 0.0F);
        this.Body1 = new MowzieModelRenderer(this, 73, 5);
        this.Body1.setRotationPoint(0.0F, -7.4F, -16.6F);
        this.Body1.addBox(-4.5F, -2.0F, -10.0F, 15, 21, 22, 0.0F);
        this.setRotateAngle(Body1, 0.13456488532876282F, -0.0F, 0.0F);
        this.Jaw = new MowzieModelRenderer(this, 29, 214);
        this.Jaw.setRotationPoint(-0.5F, 5.8F, -5.5F);
        this.Jaw.addBox(-1.5F, 0.0F, 0.0F, 4, 1, 4, 0.0F);
        this.setRotateAngle(Jaw, 3.114766367906106F, -0.0F, 0.0F);
        this.Neck2 = new MowzieModelRenderer(this, 34, 154);
        this.Neck2.setRotationPoint(0.5F, 5.5F, -1.9F);
        this.Neck2.addBox(-2.5F, 0.0F, -5.0F, 6, 8, 5, 0.0F);
        this.setRotateAngle(Neck2, -0.26162485487395F, 0.0F, 0.0F);
        this.RightFingers = new MowzieModelRenderer(this, 0, 87);
        this.RightFingers.setRotationPoint(0.0F, 1.8F, -1.2F);
        this.RightFingers.addBox(-1.0F, -1.0F, -0.5F, 3, 1, 1, 0.0F);
        this.setRotateAngle(RightFingers, -1.3042845500153626F, -0.0F, 0.0F);
        this.Tail3 = new MowzieModelRenderer(this, 89, 100);
        this.Tail3.setRotationPoint(0.0F, 0.6F, 8.4F);
        this.Tail3.addBox(-3.0F, 0.0F, 0.0F, 6, 7, 12, 0.0F);
        this.setRotateAngle(Tail3, -0.012740903539558604F, -0.0F, 0.0F);
        this.Neck = new MowzieModelRenderer(this, 0, 139);
        this.Neck.setRotationPoint(0.0F, 2.3F, -5.0F);
        this.Neck.addBox(-2.5F, 0.0F, -4.3F, 7, 14, 7, 0.0F);
        this.setRotateAngle(Neck, 0.006283185307179587F, -0.0F, -0.008377580409572781F);
        this.Neck6 = new MowzieModelRenderer(this, 108, 149);
        this.Neck6.setRotationPoint(0.0F, 4.4F, -5.7F);
        this.Neck6.addBox(-2.5F, -4.9F, -3.5F, 5, 6, 5, 0.0F);
        this.setRotateAngle(Neck6, -0.4553564018453205F, -0.0F, 0.0F);
        this.Neck8 = new MowzieModelRenderer(this, 128, 144);
        this.Neck8.setRotationPoint(0.0F, -3.95F, -3.0F);
        this.Neck8.addBox(-2.5F, -1.0F, -4.9F, 5, 6, 5, 0.0F);
        this.setRotateAngle(Neck8, 0.31869712141416456F, -0.0F, 0.0F);
        this.Crest4 = new MowzieModelRenderer(this, 15, 170);
        this.Crest4.setRotationPoint(0.0F, 4.3F, 0.1F);
        this.Crest4.addBox(-1.0F, 0.0F, 0.0F, 2, 6, 2, 0.0F);
        this.setRotateAngle(Crest4, -0.15603243512829304F, 0.0F, 0.0F);
        this.Tail4 = new MowzieModelRenderer(this, 126, 100);
        this.Tail4.setRotationPoint(0.0F, 0.3F, 11.3F);
        this.Tail4.addBox(-2.0F, 0.0F, 0.0F, 4, 6, 10, 0.0F);
        this.setRotateAngle(Tail4, -0.04782202150464463F, -0.0F, 0.0F);
        this.RightCalf1 = new MowzieModelRenderer(this, 65, 200);
        this.RightCalf1.setRotationPoint(-2.5F, 3.0F, -9.5F);
        this.RightCalf1.addBox(-1.5F, 0.0F, -4.1F, 3, 11, 5, 0.0F);
        this.setRotateAngle(RightCalf1, -0.49253191491279974F, -0.0F, 0.0F);
        this.Body3.addChild(this.Tail1);
        this.LowerArmLeft.addChild(this.LeftHand);
        this.Head.addChild(this.Snout1);
        this.Tail5.addChild(this.Tail6);
        this.Neck2.addChild(this.Neck3);
        this.Body1.addChild(this.UpperArmRight);
        this.RightCalf1.addChild(this.RightUpperFoot);
        this.LeftHand.addChild(this.LeftFingers);
        this.RightUpperFoot.addChild(this.FootRight);
        this.UpperArmRight.addChild(this.LowerArmRight);
        this.Crest2.addChild(this.Crest3);
        this.Snout1.addChild(this.Snout2);
        this.Body1.addChild(this.UpperArmLeft);
        this.LeftThigh.addChild(this.LeftCalf1);
        this.Neck8.addChild(this.Head);
        this.Head.addChild(this.Neck7Chin);
        this.Head.addChild(this.Crest1);
        this.LowerArmRight.addChild(this.RightHand);
        this.Tail4.addChild(this.Tail5);
        this.Body1.addChild(this.Body2);
        this.LeftUpperFoot.addChild(this.FootLeft);
        this.LeftCalf1.addChild(this.LeftUpperFoot);
        this.Crest1.addChild(this.Crest2);
        this.Head.addChild(this.Crestmembrane);
        this.Tail1.addChild(this.Tail2);
        this.Neck.addChild(this.NeckMerge);
        this.UpperArmLeft.addChild(this.LowerArmLeft);
        this.Body3.addChild(this.Body1);
        this.Head.addChild(this.Jaw);
        this.Neck.addChild(this.Neck2);
        this.RightHand.addChild(this.RightFingers);
        this.Tail2.addChild(this.Tail3);
        this.Body2.addChild(this.Neck);
        this.Neck3.addChild(this.Neck6);
        this.Neck6.addChild(this.Neck8);
        this.Crest3.addChild(this.Crest4);
        this.Tail3.addChild(this.Tail4);
        this.RightThigh.addChild(this.RightCalf1);
        
        parts = new MowzieModelRenderer[] {LeftThigh, RightThigh, Body3, LeftCalf1, LeftUpperFoot, FootLeft, RightCalf1, RightUpperFoot, FootRight, Tail1, Body1, Tail2, Tail3, Tail4, Tail5, Tail6, Body2, UpperArmLeft, UpperArmRight, Neck, Neck2, NeckMerge, Neck3, Neck6, Neck8, Head, Snout1, Jaw, Crest1, Crestmembrane, Neck7Chin, Snout2, Crest2, Crest3, Crest4, LowerArmLeft, LeftHand, LeftFingers, LowerArmRight, RightHand, RightFingers};
        setInitPose();
    }
    
    public boolean setAlarmed(boolean setAlarm)
    {
        return this.isAlarmed = setAlarm;
    }
    
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        animate((IAnimatedEntity) entity, f, f1, f2, f3, f4, f5);
        GL11.glPushMatrix();
        GL11.glScaled(1D / modelScale[0], 1D / modelScale[1], 1D / modelScale[2]);
        this.LeftThigh.render(f5);
        this.RightThigh.render(f5);
        this.Body3.render(f5);
        GL11.glPopMatrix();
    }
    
    private void setRotateAngle(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
    
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, EntityParasaurolophus para)
    {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, para);
        setToInitPose();
        /*
         * f = para.frame; 
         * f1 = (float) Math.cos(f/20)*0.25F + 0.5F;
         */

    }
    
    public void animate(IAnimatedEntity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        animator.update(entity);
        setRotationAngles(f, f1, f2, f3, f4, f5, (EntityParasaurolophus) entity);
        EntityParasaurolophus para = (EntityParasaurolophus) entity;
        
        animator.setAnimation(JurassiCraftAnimationIDs.TRUMPET.animID());
        /*animator.startPhase(15);
        animator.rotate(Body_3, 0.3F, 0, 0);
        animator.rotate(Body_1, 0.1F, 0, 0);
        animator.rotate(Body_2, 0.1F, 0, 0);
        animator.rotate(Neck, -0.6F, 0, 0);
        animator.move(Neck, 0, -2, 0);
        animator.rotate(Head, 0.7F, 0, 0);
        animator.rotate(Upper_Arm_Right, 0.4F, 0, 0);
        animator.rotate(Upper_Arm_Left, 0.4F, 0, 0);
        animator.rotate(Lower_Arm_Right, -0.6F, 0, 0);
        animator.rotate(Lower_Arm_Left, -0.6F, 0, 0);
        animator.rotate(Right_Hand, 0.4F, 0, 0);
        animator.rotate(Left_Hand, 0.4F, 0, 0);
        animator.endPhase();
        animator.setStationaryPhase(5);
        animator.startPhase(10);
        animator.rotate(Body_3, -0.5F, 0, 0);
        animator.rotate(Neck, 0.5F, 0, 0);
        animator.rotate(Head, -0.5F, 0, 0);
        animator.rotate(Jaw, 0.2F, 0, 0);
        animator.move(Neck, 0, -2.3F, 0);
        animator.rotate(Tail_1, 0.2F, 0, 0);
        animator.rotate(Tail_2, 0.2F, 0, 0);
        animator.rotate(Tail_3, 0.2F, 0, 0);
        animator.rotate(Tail_4, 0.2F, 0, 0);
        animator.rotate(Tail_5, 0.2F, 0, 0);
        animator.rotate(Tail_6, 0.2F, 0, 0);
        animator.endPhase();
        animator.setStationaryPhase(20);
        animator.resetPhase(10);*/
    }
}
