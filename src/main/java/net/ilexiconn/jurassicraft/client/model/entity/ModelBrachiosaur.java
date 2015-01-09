package net.ilexiconn.jurassicraft.client.model.entity;

import net.ilexiconn.jurassicraft.client.model.modelbase.MowzieModelBase;
import net.ilexiconn.jurassicraft.client.model.modelbase.MowzieModelRenderer;
import net.ilexiconn.jurassicraft.entity.dinosaurs.EntityBrachiosaur;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBrachiosaur extends MowzieModelBase
{
    //fields
    MowzieModelRenderer hips;
    MowzieModelRenderer body_1;
    MowzieModelRenderer body_2;
    MowzieModelRenderer body_3;
    MowzieModelRenderer top_leg_left;
    MowzieModelRenderer bottom_leg_left;
    MowzieModelRenderer left_back_foot;
    MowzieModelRenderer front_left_top_leg;
    MowzieModelRenderer bottom_front_left_leg;
    MowzieModelRenderer front_left_foot;
    MowzieModelRenderer tail1;
    MowzieModelRenderer tail2;
    MowzieModelRenderer tail3;
    MowzieModelRenderer tail4;
    MowzieModelRenderer tail5;
    MowzieModelRenderer neck1;
    MowzieModelRenderer neck2;
    MowzieModelRenderer neck3;
    MowzieModelRenderer neck4;
    MowzieModelRenderer neck5;
    MowzieModelRenderer neck6;
    MowzieModelRenderer neck7;
    MowzieModelRenderer head;
    MowzieModelRenderer snout;
    MowzieModelRenderer jaw;
    MowzieModelRenderer front_right_top_leg;
    MowzieModelRenderer bottom_front_right_leg;
    MowzieModelRenderer front_right_foot;
    MowzieModelRenderer top_leg_right;
    MowzieModelRenderer bottom_leg_right;
    MowzieModelRenderer right_back_foot;
    MowzieModelRenderer nose;
    MowzieModelRenderer headJoint;

    public ModelBrachiosaur()
    {
        textureWidth = 512;
        textureHeight = 256;

        hips = new MowzieModelRenderer(this, 0, 155);
        hips.addBox(-9F, -9F, -11F, 18, 17, 19);
        hips.setRotationPoint(0F, -7F, 0F);
        hips.setTextureSize(512, 256);
        hips.mirror = true;
        setRotation(hips, -0.1152878F, 0F, 0F);
        body_1 = new MowzieModelRenderer(this, 0, 109);
        body_1.addBox(-10F, -1F, -16F, 20, 20, 20);
        body_1.setRotationPoint(0F, -17F, -6F);
        body_1.setTextureSize(512, 256);
        body_1.mirror = true;
        setRotation(body_1, -0.2312985F, 0F, 0F);
        body_2 = new MowzieModelRenderer(this, 0, 53);
        body_2.addBox(-11F, 0F, 0F, 22, 23, 20);
        body_2.setRotationPoint(0F, -28F, -30F);
        body_2.setTextureSize(512, 256);
        body_2.mirror = true;
        setRotation(body_2, -0.3432994F, 0F, 0F);
        body_3 = new MowzieModelRenderer(this, 300, 53);
        body_3.addBox(-8F, 0F, -3F, 16, 20, 15);
        body_3.setRotationPoint(0F, -21.4F, -20F);
        body_3.setTextureSize(512, 256);
        body_3.mirror = true;
        setRotation(body_3, -1.421479F, 0F, 0F);
        top_leg_left = new MowzieModelRenderer(this, 124, 0);
        top_leg_left.addBox(0F, 0F, -4F, 7, 21, 11);
        top_leg_left.setRotationPoint(9F, -12F, 1F);
        top_leg_left.setTextureSize(512, 256);
        top_leg_left.mirror = true;
        setRotation(top_leg_left, -0.4363323F, 0F, 0F);
        bottom_leg_left = new MowzieModelRenderer(this, 173, 0);
        bottom_leg_left.addBox(-3F, 0F, 0F, 6, 18, 7);
        bottom_leg_left.setRotationPoint(12.5F, 4.7F, -11F);
        bottom_leg_left.setTextureSize(512, 256);
        bottom_leg_left.mirror = true;
        setRotation(bottom_leg_left, 0.5061455F, 0F, 0F);
        left_back_foot = new MowzieModelRenderer(this, 217, 0);
        left_back_foot.addBox(-3F, 0F, -3F, 6, 7, 7);
        left_back_foot.setRotationPoint(12.5F, 17F, -0.2F);
        left_back_foot.setTextureSize(512, 256);
        left_back_foot.mirror = true;
        setRotation(left_back_foot, 0F, 0F, 0F);
        front_left_top_leg = new MowzieModelRenderer(this, 173, 39);
        front_left_top_leg.addBox(0F, -2F, -5F, 6, 16, 9);
        front_left_top_leg.setRotationPoint(10F, -8F, -27F);
        front_left_top_leg.setTextureSize(512, 256);
        front_left_top_leg.mirror = true;
        setRotation(front_left_top_leg, 0.3839724F, 0F, 0F);
        bottom_front_left_leg = new MowzieModelRenderer(this, 173, 78);
        bottom_front_left_leg.addBox(-3F, -6F, -1F, 6, 18, 7);
        bottom_front_left_leg.setRotationPoint(13F, 5.5F, -27F);
        bottom_front_left_leg.setTextureSize(512, 256);
        bottom_front_left_leg.mirror = true;
        setRotation(bottom_front_left_leg, -0.4283017F, 0F, 0F);
        front_left_foot = new MowzieModelRenderer(this, 172, 117);
        front_left_foot.addBox(-3F, 0F, -3F, 6, 8, 7);
        front_left_foot.setRotationPoint(13F, 16F, -30F);
        front_left_foot.setTextureSize(512, 256);
        front_left_foot.mirror = true;
        setRotation(front_left_foot, 0F, 0F, 0F);
        tail1 = new MowzieModelRenderer(this, 0, 205);
        tail1.addBox(-8F, -5F, 0F, 16, 14, 12);
        tail1.setRotationPoint(0F, -10.5F, 5F);
        tail1.setTextureSize(512, 256);
        tail1.mirror = true;
        setRotation(tail1, -0.4322299F, 0F, 0F);
        tail2 = new MowzieModelRenderer(this, 78, 189);
        tail2.addBox(-6F, -5F, 0F, 12, 11, 13);
        tail2.setRotationPoint(0F, -5.8F, 12F);
        tail2.setTextureSize(512, 256);
        tail2.mirror = true;
        setRotation(tail2, -0.50385F, 0F, 0F);
        tail3 = new MowzieModelRenderer(this, 165, 215);
        tail3.addBox(-4F, -7F, 0F, 8, 8, 17);
        tail3.setRotationPoint(0F, 0.5F, 15F);
        tail3.setTextureSize(512, 256);
        tail3.mirror = true;
        setRotation(tail3, -0.4240186F, 0F, 0F);
        tail4 = new MowzieModelRenderer(this, 99, 223);
        tail4.addBox(-2F, 0F, 0F, 4, 6, 21);
        tail4.setRotationPoint(0F, -2F, 22F);
        tail4.setTextureSize(512, 256);
        tail4.mirror = true;
        setRotation(tail4, -0.3469243F, 0F, 0F);
        tail5 = new MowzieModelRenderer(this, 229, 222);
        tail5.addBox(-1.5F, 0F, 0F, 3, 4, 17);
        tail5.setRotationPoint(0F, 4.3F, 34F);
        tail5.setTextureSize(512, 256);
        tail5.mirror = true;
        setRotation(tail5, -0.2353885F, 0F, 0F);
        neck1 = new MowzieModelRenderer(this, 400, 120);
        neck1.addBox(-6F, -3F, -15F, 12, 11, 15);
        neck1.setRotationPoint(0F, -18.7F, -27F);
        neck1.setTextureSize(512, 256);
        neck1.mirror = true;
        setRotation(neck1, -0.8425631F, 0F, 0F);
        neck2 = new MowzieModelRenderer(this, 400, 86);
        neck2.addBox(-4.5F, -5F, -21F, 9, 8, 18);
        neck2.setRotationPoint(0F, -23.2F, -37.5F);
        neck2.setTextureSize(512, 256);
        neck2.mirror = true;
        setRotation(neck2, -1.097366F, 0F, 0F);
        neck3 = new MowzieModelRenderer(this, 400, 58);
        neck3.addBox(-3.5F, -3F, -21F, 7, 6, 12);
        neck3.setRotationPoint(0F, -30.1F, -42F);
        neck3.setTextureSize(512, 256);
        neck3.mirror = true;
        setRotation(neck3, -1.237303F, 0F, 0F);
        neck4 = new MowzieModelRenderer(this, 400, 39);
        neck4.addBox(-3.5F, -3F, -5F, 7, 6, 5);
        neck4.setRotationPoint(0F, -49F, -48.5F);
        neck4.setTextureSize(512, 256);
        neck4.mirror = true;
        setRotation(neck4, -0.9378305F, 0F, 0F);
        neck5 = new MowzieModelRenderer(this, 431, 0);
        neck5.addBox(-3.5F, -5F, -3F, 7, 6, 3);
        neck5.setRotationPoint(0F, -51F, -52.3F);
        neck5.setTextureSize(512, 256);
        neck5.mirror = true;
        setRotation(neck5, -0.7147588F, 0F, 0F);
        neck6 = new MowzieModelRenderer(this, 431, 0);
        neck6.addBox(-3.5F, -6F, 0F, 7, 6, 3);
        neck6.setRotationPoint(0F, -52.8F, -56.7F);
        neck6.setTextureSize(512, 256);
        neck6.mirror = true;
        setRotation(neck6, -0.4916871F, 0F, 0F);
        neck7 = new MowzieModelRenderer(this, 431, 0);
        neck7.addBox(-3.5F, -6F, 0F, 7, 6, 3);
        neck7.setRotationPoint(0F, -52.6F, -57.8F);
        neck7.setTextureSize(512, 256);
        neck7.mirror = true;
        setRotation(neck7, -0.1570796F, 0F, 0F);
        head = new MowzieModelRenderer(this, 99, 71);
        head.addBox(-4F, 0F, -8F, 8, 7, 8);
        head.setRotationPoint(0F, -59F, -56F);
        head.setTextureSize(512, 256);
        head.mirror = true;
        setRotation(head, 0F, 0F, 0F);
        snout = new MowzieModelRenderer(this, 45, 13);
        snout.addBox(-2.5F, -2F, -7F, 5, 4, 7);
        snout.setRotationPoint(0F, -55.5F, -63F);
        snout.setTextureSize(512, 256);
        snout.mirror = true;
        setRotation(snout, 0F, 0F, 0F);
        jaw = new MowzieModelRenderer(this, 0, 23);
        jaw.addBox(-2F, 0F, -6F, 4, 1, 6);
        jaw.setRotationPoint(0F, -53.5F, -63.5F);
        jaw.setTextureSize(512, 256);
        jaw.mirror = true;
        setRotation(jaw, 0F, 0F, 0F);
        front_right_top_leg = new MowzieModelRenderer(this, 173, 39);
        front_right_top_leg.addBox(-6F, -2F, -5F, 6, 16, 9);
        front_right_top_leg.setRotationPoint(-10F, -8F, -27F);
        front_right_top_leg.setTextureSize(512, 256);
        front_right_top_leg.mirror = true;
        setRotation(front_right_top_leg, 0.3839724F, 0F, 0F);
        bottom_front_right_leg = new MowzieModelRenderer(this, 173, 78);
        bottom_front_right_leg.addBox(-3F, -6F, -1F, 6, 18, 7);
        bottom_front_right_leg.setRotationPoint(-13F, 5.5F, -27F);
        bottom_front_right_leg.setTextureSize(512, 256);
        bottom_front_right_leg.mirror = true;
        setRotation(bottom_front_right_leg, -0.4283017F, 0F, 0F);
        front_right_foot = new MowzieModelRenderer(this, 172, 117);
        front_right_foot.addBox(-3F, 0F, -3F, 6, 8, 7);
        front_right_foot.setRotationPoint(-13F, 16F, -30F);
        front_right_foot.setTextureSize(512, 256);
        front_right_foot.mirror = true;
        setRotation(front_right_foot, 0F, 0F, 0F);
        top_leg_right = new MowzieModelRenderer(this, 124, 0);
        top_leg_right.addBox(-7F, 0F, -4F, 7, 21, 11);
        top_leg_right.setRotationPoint(-9F, -12F, 1F);
        top_leg_right.setTextureSize(512, 256);
        top_leg_right.mirror = true;
        setRotation(top_leg_right, -0.4363323F, 0F, 0F);
        bottom_leg_right = new MowzieModelRenderer(this, 173, 0);
        bottom_leg_right.addBox(-3F, 0F, 0F, 6, 18, 7);
        bottom_leg_right.setRotationPoint(-12.5F, 4.7F, -11F);
        bottom_leg_right.setTextureSize(512, 256);
        bottom_leg_right.mirror = true;
        setRotation(bottom_leg_right, 0.5061455F, 0F, 0F);
        right_back_foot = new MowzieModelRenderer(this, 217, 0);
        right_back_foot.addBox(-3F, 0F, -3F, 6, 7, 7);
        right_back_foot.setRotationPoint(-12.5F, 17F, -0.2F);
        right_back_foot.setTextureSize(512, 256);
        right_back_foot.mirror = true;
        setRotation(right_back_foot, 0F, 0F, 0F);
        nose = new MowzieModelRenderer(this, 35, 30);
        nose.addBox(-1.5F, -8F, -4F, 3, 8, 8);
        nose.setRotationPoint(0F, -54.5F, -62F);
        nose.setTextureSize(512, 256);
        nose.mirror = true;
        setRotation(nose, 0F, 0F, 0F);
        headJoint = new MowzieModelRenderer(this, 0, 0);
        headJoint.addBox(0F, 0F, 0F, 0, 0, 0);
        headJoint.setRotationPoint(0F, -59F, -56F);
        headJoint.setTextureSize(512, 256);
        headJoint.mirror = true;
        setRotation(head, 0F, 0F, 0F);

        addChildTo(left_back_foot, bottom_leg_left);
        addChildTo(bottom_leg_left, top_leg_left);

        addChildTo(right_back_foot, bottom_leg_right);
        addChildTo(bottom_leg_right, top_leg_right);

        addChildTo(front_left_foot, bottom_front_left_leg);
        addChildTo(bottom_front_left_leg, front_left_top_leg);

        addChildTo(front_right_foot, bottom_front_right_leg);
        addChildTo(bottom_front_right_leg, front_right_top_leg);

        addChildTo(front_left_top_leg, body_3);
        addChildTo(front_right_top_leg, body_3);

        addChildTo(tail5, tail4);
        addChildTo(tail4, tail3);
        addChildTo(tail3, tail2);
        addChildTo(tail2, tail1);
        addChildTo(tail1, hips);

        addChildTo(hips, body_1);
        addChildTo(body_3, body_1);
        addChildTo(body_2, body_1);

        addChildTo(nose, head);
        addChildTo(snout, head);
        addChildTo(jaw, head);
        addChildTo(head, headJoint);
        addChildTo(headJoint, neck7);
        addChildTo(neck7, neck6);
        addChildTo(neck6, neck5);
        addChildTo(neck5, neck4);
        addChildTo(neck4, neck3);
        addChildTo(neck3, neck2);
        addChildTo(neck2, neck1);
        addChildTo(neck1, body_1);

        //Corrections
        body_2.setRotationPoint(0, -4, -26);
        body_3.setRotationPoint(0, 0, -15);
        head.setRotationPoint(0, 0, 0);
        headJoint.setRotationPoint(0, -6, 0);
        neck5.setRotationPoint(0, 6, -9);
        neck4.setRotationPoint(0, 0, -20);
        neck3.setRotationPoint(0, 0, -11);
        neck2.setRotationPoint(0, 5, -10);
        neck1.setRotationPoint(0, 0, -25);
        tail1.setRotationPoint(0, -2, 6);
        tail4.setRotationPoint(0, -6, 15);
        tail5.setRotationPoint(0, 1, 20);

        hips.setInitValuesToCurrentPose();
        body_1.setInitValuesToCurrentPose();
        body_2.setInitValuesToCurrentPose();
        body_3.setInitValuesToCurrentPose();
        top_leg_left.setInitValuesToCurrentPose();
        bottom_leg_left.setInitValuesToCurrentPose();
        left_back_foot.setInitValuesToCurrentPose();
        front_left_top_leg.setInitValuesToCurrentPose();
        bottom_front_left_leg.setInitValuesToCurrentPose();
        front_left_foot.setInitValuesToCurrentPose();
        tail1.setInitValuesToCurrentPose();
        tail2.setInitValuesToCurrentPose();
        tail3.setInitValuesToCurrentPose();
        tail4.setInitValuesToCurrentPose();
        tail5.setInitValuesToCurrentPose();
        neck1.setInitValuesToCurrentPose();
        neck2.setInitValuesToCurrentPose();
        neck3.setInitValuesToCurrentPose();
        neck4.setInitValuesToCurrentPose();
        neck5.setInitValuesToCurrentPose();
        neck6.setInitValuesToCurrentPose();
        neck7.setInitValuesToCurrentPose();
        head.setInitValuesToCurrentPose();
        snout.setInitValuesToCurrentPose();
        jaw.setInitValuesToCurrentPose();
        front_right_top_leg.setInitValuesToCurrentPose();
        bottom_front_right_leg.setInitValuesToCurrentPose();
        front_right_foot.setInitValuesToCurrentPose();
        top_leg_right.setInitValuesToCurrentPose();
        bottom_leg_right.setInitValuesToCurrentPose();
        right_back_foot.setInitValuesToCurrentPose();
        nose.setInitValuesToCurrentPose();
        headJoint.setInitValuesToCurrentPose();
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        //        hips.render(f5);
        body_1.render(f5);
        //        body_2.render(f5);
        //        body_3.render(f5);
        top_leg_left.render(f5);
        //    bottom_leg_left.render(f5);
        //    left_back_foot.render(f5);
        //        front_left_top_leg.render(f5);
        //    bottom_front_left_leg.render(f5);
        //    front_left_foot.render(f5);
        //        tail1.render(f5);
        //        tail2.render(f5);
        //        tail3.render(f5);
        //        tail4.render(f5);
        //        tail5.render(f5);
        //        neck1.render(f5);
        //        neck2.render(f5);
        //       neck3.render(f5);
        //       neck4.render(f5);
        //       neck5.render(f5);
        //       neck6.render(f5);
        //        neck7.render(f5);
        //       head.render(f5);
        //        snout.render(f5);
        //        jaw.render(f5);
        //        front_right_top_leg.render(f5);
        //    bottom_front_right_leg.render(f5);
        //    front_right_foot.render(f5);
        top_leg_right.render(f5);
        //    bottom_leg_right.render(f5);
        //    right_back_foot.render(f5);
        //        nose.render(f5);
    }

    private void resetPose()
    {
        hips.setCurrentPoseToInitValues();
        body_1.setCurrentPoseToInitValues();
        body_2.setCurrentPoseToInitValues();
        body_3.setCurrentPoseToInitValues();
        top_leg_left.setCurrentPoseToInitValues();
        bottom_leg_left.setCurrentPoseToInitValues();
        left_back_foot.setCurrentPoseToInitValues();
        front_left_top_leg.setCurrentPoseToInitValues();
        bottom_front_left_leg.setCurrentPoseToInitValues();
        front_left_foot.setCurrentPoseToInitValues();
        tail1.setCurrentPoseToInitValues();
        tail2.setCurrentPoseToInitValues();
        tail3.setCurrentPoseToInitValues();
        tail4.setCurrentPoseToInitValues();
        tail5.setCurrentPoseToInitValues();
        neck1.setCurrentPoseToInitValues();
        neck2.setCurrentPoseToInitValues();
        neck3.setCurrentPoseToInitValues();
        neck4.setCurrentPoseToInitValues();
        neck5.setCurrentPoseToInitValues();
        neck6.setCurrentPoseToInitValues();
        neck7.setCurrentPoseToInitValues();
        head.setCurrentPoseToInitValues();
        snout.setCurrentPoseToInitValues();
        jaw.setCurrentPoseToInitValues();
        front_right_top_leg.setCurrentPoseToInitValues();
        bottom_front_right_leg.setCurrentPoseToInitValues();
        front_right_foot.setCurrentPoseToInitValues();
        top_leg_right.setCurrentPoseToInitValues();
        bottom_leg_right.setCurrentPoseToInitValues();
        right_back_foot.setCurrentPoseToInitValues();
        nose.setCurrentPoseToInitValues();
        headJoint.setCurrentPoseToInitValues();
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
    {
        EntityBrachiosaur brachObama = (EntityBrachiosaur) entity;
        super.setRotationAngles(f, f1, f2, f3, f4, f5, null);
        resetPose();
        /*f = brachObama.frame;
        f1 = 0.2F;*/
        MowzieModelRenderer[] neckParts = {this.head, this.neck7, this.neck6, this.neck5, this.neck4, this.neck3, this.neck2, this.neck1};
        MowzieModelRenderer[] tailParts = {tail5, tail4, tail3};
        MowzieModelRenderer[] tailParts2 = {tail5, tail4, tail3, tail2, tail1};
        
        float scaleFactor = 0.2F;
        float height = 1.7F;
        float frontOffset = -2F;
        float animationDegree = 0.5F;
        
        bob(body_1, 2 * scaleFactor, height * animationDegree, false, f, f1);
        bob(top_leg_left, 2 * scaleFactor, height * animationDegree, false, f, f1);
        bob(top_leg_right, 2 * scaleFactor, height * animationDegree, false, f, f1);
        walk(body_1, 2 * scaleFactor, 0.15F * height * animationDegree, true, -1.5F, 0F, f, f1);
        chainWave(tailParts2, 2 * scaleFactor, 0.08F * animationDegree, 2, f, f1);
        chainWave(neckParts, 2 * scaleFactor, 0.3F * animationDegree, 4, f, f1);
        tail1.rotateAngleX += 0.1*f1;
        
        walk(top_leg_left, 1F * scaleFactor, 1F * animationDegree, false, 0F, 0F, f, f1);
        walk(bottom_leg_left, 1F * scaleFactor, 1F * animationDegree, true, 1F, 0F, f, f1);
        walk(left_back_foot, 1F * scaleFactor, 1F * animationDegree, false, 1.5F, 0F, f, f1);

        walk(top_leg_right, 1F * scaleFactor, 1F * animationDegree, true, 0F, 0F, f, f1);
        walk(bottom_leg_right, 1F * scaleFactor, 1F * animationDegree, false, 1F, 0F, f, f1);
        walk(right_back_foot, 1F * scaleFactor, 1F * animationDegree, true, 1.5F, 0F, f, f1);

        walk(front_right_top_leg, 1F * scaleFactor, 2F * animationDegree, true, frontOffset + 0F, -0.1F, f, f1);
        walk(bottom_front_right_leg, 1F * scaleFactor, 1.5F * animationDegree, true, frontOffset + 2F, -0.2F, f, f1);
        walk(front_right_foot, 1F * scaleFactor, 1.3F * animationDegree, false, frontOffset + 1.5F, 0F, f, f1);

        walk(front_left_top_leg, 1F * scaleFactor, 2F * animationDegree, false, frontOffset+ 0F, -0.1F, f, f1);
        walk(bottom_front_left_leg, 1F * scaleFactor, 1.5F * animationDegree, false, frontOffset + 2F, -0.2F, f, f1);
        walk(front_left_foot, 1F * scaleFactor, 1.3F * animationDegree, true, frontOffset + 1.5F, 0F, f, f1);


        //Idle
        walk(body_1, 0.05F, 0.025F, false, 0, 0, brachObama.frame, 1);
        walk(front_right_top_leg, 0.05F, 0.1F, false, 0, 0, brachObama.frame, 1);
        walk(front_left_top_leg, 0.05F, 0.1F, false, 0, 0, brachObama.frame, 1);
        walk(bottom_front_right_leg, 0.05F, 0.3F, true, 0, 0, brachObama.frame, 1);
        walk(bottom_front_left_leg, 0.05F, 0.3F, true, 0, 0, brachObama.frame, 1);
        walk(front_right_foot, 0.05F, 0.175F, false, 0, 0, brachObama.frame, 1);
        walk(front_left_foot, 0.05F, 0.175F, false, 0, 0, brachObama.frame, 1);
        chainWave(neckParts, 0.05F, -0.05F, -4, brachObama.frame, 1);
        chainWave(tailParts, 0.05F, -0.05F, 1, brachObama.frame, 1);
        chainSwing(tailParts, 0.05F, 0.2F, 2, brachObama.frame, 1);
    }
}
