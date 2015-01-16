package net.ilexiconn.jurassicraft.client.model.entity;

import net.ilexiconn.jurassicraft.client.model.modelbase.MowzieModelBase;
import net.ilexiconn.jurassicraft.client.model.modelbase.MowzieModelRenderer;
import net.ilexiconn.jurassicraft.entity.dinosaurs.EntityTriceratops;
import net.minecraft.entity.Entity;
import net.ilexiconn.jurassicraft.interfaces.IAnimatedEntity;
import net.ilexiconn.jurassicraft.client.model.animation.Animator;

public class ModelTriceratops extends MowzieModelBase
{
    private Animator animator;

    public MowzieModelRenderer BackCalfLeft;
    public MowzieModelRenderer BackCalfRight;
    public MowzieModelRenderer BackThighLeft;
    public MowzieModelRenderer BackThighRight;
    public MowzieModelRenderer FrontCalfLeft;
    public MowzieModelRenderer FrontCalfRight;
    public MowzieModelRenderer FrontThighLeft;
    public MowzieModelRenderer FrontThighRight;
    public MowzieModelRenderer Tail1;
    public MowzieModelRenderer Tail2;
    public MowzieModelRenderer Tail3;
    public MowzieModelRenderer Tail4;
    public MowzieModelRenderer Tail5;
    public MowzieModelRenderer Chest;
    public MowzieModelRenderer Neck;
    public MowzieModelRenderer Head;
    public MowzieModelRenderer Mouth;
    public MowzieModelRenderer Shieldthingy1;
    public MowzieModelRenderer Shieldthingy2;
    public MowzieModelRenderer Shieldthingy3;
    public MowzieModelRenderer MiddleHorn;
    public MowzieModelRenderer LeftHorn;
    public MowzieModelRenderer RightBackFoot;
    public MowzieModelRenderer LeftBackFoot;
    public MowzieModelRenderer Waist;
    public MowzieModelRenderer RightHorn;
    public MowzieModelRenderer Shieldthingy4;
    public MowzieModelRenderer Shieldthingy5;
    public MowzieModelRenderer Shieldthingy6;
    public MowzieModelRenderer Shieldthingy7;
    public MowzieModelRenderer Shieldthingy8;
    public MowzieModelRenderer Shieldthingy9;
    public MowzieModelRenderer Shieldthingy10;
    public MowzieModelRenderer Shieldthingy11;
    public MowzieModelRenderer Shieldthingy12;
    public MowzieModelRenderer Shieldthingy13;
    public MowzieModelRenderer Collar;
    public MowzieModelRenderer LeftFrontFoot;
    public MowzieModelRenderer RightFrontFoot;
    public MowzieModelRenderer[] tailParts;

    public ModelTriceratops()
    {
        this.textureWidth = 256;
        this.textureHeight = 256;
        animator = new Animator(this);

        this.Tail3 = new MowzieModelRenderer(this, 37, 141);
        this.Tail3.setRotationPoint(0.0F, 2.5F, 28.0F);
        this.Tail3.addBox(-4.0F, -3.0F, 0.0F, 8, 9, 7);
        this.setRotation(Tail3, -0.10471975511965977F, -0.0F, 0.0F);
        this.Shieldthingy3 = new MowzieModelRenderer(this, 31, 219);
        this.Shieldthingy3.setRotationPoint(0.0F, -2.9000000953674316F, -22.0F);
        this.Shieldthingy3.addBox(1.2999999523162842F, -1.600000023841858F, -2.5F, 4, 3, 4);
        this.setRotation(Shieldthingy3, -0.6806784272193909F, -0.0F, 0.0F);
        this.LeftHorn = new MowzieModelRenderer(this, 36, 52);
        this.LeftHorn.setRotationPoint(0.0F, -2.9000000953674316F, -22.0F);
        this.LeftHorn.addBox(2.299999952316284F, -16.0F, -0.8999999761581421F, 2, 16, 2);
        this.setRotation(LeftHorn, 0.8901179432868958F, -0.0F, 0.0F);
        this.FrontThighLeft = new MowzieModelRenderer(this, 182, 29);
        this.FrontThighLeft.setRotationPoint(8.0F, 1.0F, -10.0F);
        this.FrontThighLeft.addBox(-2.0F, 0.0F, -3.5F, 5, 15, 7);
        this.setRotation(FrontThighLeft, 0.303530216217041F, -0.01745329238474369F, 0.0F);
        this.Tail4 = new MowzieModelRenderer(this, 0, 147);
        this.Tail4.setRotationPoint(0.0F, 3.0F, 30.0F);
        this.Tail4.addBox(-3.0F, -2.0F, 0.0F, 6, 7, 11);
        this.setRotation(Tail4, -0.04782202150464463F, -0.0F, 0.0F);
        this.Mouth = new MowzieModelRenderer(this, 0, 168);
        this.Mouth.setRotationPoint(0.0F, -2.9000000953674316F, -22.0F);
        this.Mouth.addBox(-3.0F, 1.7000000476837158F, -15.0F, 6, 7, 6);
        this.setRotation(Mouth, 0.30806612968444824F, -0.0F, 0.0F);
        this.FrontThighRight = new MowzieModelRenderer(this, 147, 29);
        this.FrontThighRight.setRotationPoint(-8.0F, 1.0F, -10.0F);
        this.FrontThighRight.addBox(-3.0F, 0.0F, -3.5F, 5, 15, 7);
        this.setRotation(FrontThighRight, 0.303530216217041F, -0.0F, 0.0F);
        this.BackThighRight = new MowzieModelRenderer(this, 147, 0);
        this.BackThighRight.setRotationPoint(-8.5F, -2.0F, 10.0F);
        this.BackThighRight.addBox(-4.5F, 0.0F, -3.5F, 5, 16, 9);
        this.setRotation(BackThighRight, -0.3262369334697723F, -0.0F, 0.0F);
        this.RightHorn = new MowzieModelRenderer(this, 36, 52);
        this.RightHorn.setRotationPoint(0.0F, -2.9000000953674316F, -22.0F);
        this.RightHorn.addBox(-4.300000190734863F, -16.0F, -0.8999999761581421F, 2, 16, 2);
        this.setRotation(RightHorn, 0.8901179432868958F, -0.0F, 0.0F);
        this.Tail1 = new MowzieModelRenderer(this, 0, 95);
        this.Tail1.setRotationPoint(0.0F, -5.800000190734863F, 15.0F);
        this.Tail1.addBox(-6.0F, 0.0F, 0.0F, 12, 14, 10);
        this.setRotation(Tail1, -0.2382529377937317F, -0.0F, 0.0F);
        this.BackCalfLeft = new MowzieModelRenderer(this, 236, 0);
        this.BackCalfLeft.setRotationPoint(10.5F, 9.399999618530273F, 2.700000047683716F);
        this.BackCalfLeft.addBox(-2.0F, 0.0F, 0.0F, 4, 13, 5);
        this.setRotation(BackCalfLeft, 0.3436956107616424F, -0.0F, 0.0F);
        this.Shieldthingy12 = new MowzieModelRenderer(this, 26, 40);
        this.Shieldthingy12.setRotationPoint(0.0F, -2.9000000953674316F, -22.0F);
        this.Shieldthingy12.addBox(8.0F, -8.0F, 0.5F, 2, 3, 1);
        this.setRotation(Shieldthingy12, -0.3171542286872864F, -0.0F, 0.01745329238474369F);
        this.Neck = new MowzieModelRenderer(this, 0, 184);
        this.Neck.setRotationPoint(0.0F, -3.0999999046325684F, -15.0F);
        this.Neck.addBox(-4.5F, 0.0F, -7.0F, 9, 10, 8);
        this.setRotation(Neck, 0.01745329238474369F, -0.0F, 0.0F);
        this.Shieldthingy7 = new MowzieModelRenderer(this, 26, 40);
        this.Shieldthingy7.setRotationPoint(0.0F, -2.9000000953674316F, -22.0F);
        this.Shieldthingy7.addBox(-4.0F, -10.5F, 0.5F, 3, 2, 1);
        this.setRotation(Shieldthingy7, -0.3141592741012573F, -0.0F, 0.0F);
        this.RightBackFoot = new MowzieModelRenderer(this, 0, 0);
        this.RightBackFoot.setRotationPoint(-10.5F, 20.0F, 11.800000190734863F);
        this.RightBackFoot.addBox(-2.0F, 0.0F, -5.0F, 4, 4, 5);
        this.setRotation(RightBackFoot, -2.790294876053932E-16F, -0.0F, 0.0F);
        this.Chest = new MowzieModelRenderer(this, 14, 219);
        this.Chest.setRotationPoint(0.0F, -6.2F, 0.6F);
        this.Chest.addBox(-8.0F, 0.0F, -16.0F, 16, 17, 17);
        this.setRotation(Chest, 0.11152653920243764F, -0.0F, 0.0F);
        this.Shieldthingy1 = new MowzieModelRenderer(this, 0, 71);
        this.Shieldthingy1.setRotationPoint(0.0F, -2.9000000953674316F, -22.0F);
        this.Shieldthingy1.addBox(-9.0F, -9.5F, 0.0F, 18, 18, 2);
        this.setRotation(Shieldthingy1, -0.3141592741012573F, -0.0F, 0.0F);
        this.Shieldthingy6 = new MowzieModelRenderer(this, 26, 40);
        this.Shieldthingy6.setRotationPoint(0.0F, -2.9000000953674316F, -22.0F);
        this.Shieldthingy6.addBox(1.0F, -10.5F, 0.5F, 3, 2, 1);
        this.setRotation(Shieldthingy6, -0.3141592741012573F, -0.0F, 0.0F);
        this.Shieldthingy11 = new MowzieModelRenderer(this, 26, 40);
        this.Shieldthingy11.setRotationPoint(0.0F, -2.9000000953674316F, -22.0F);
        this.Shieldthingy11.addBox(8.0F, 0.0F, 0.5F, 2, 3, 1);
        this.setRotation(Shieldthingy11, -0.3171542286872864F, -0.0F, 0.01745329238474369F);
        this.FrontCalfLeft = new MowzieModelRenderer(this, 235, 23);
        this.FrontCalfLeft.setRotationPoint(8.5F, 13.0F, -3.4000000953674316F);
        this.FrontCalfLeft.addBox(-2.0F, 0.0F, -5.0F, 4, 9, 5);
        this.setRotation(FrontCalfLeft, -0.32324737310409546F, -0.0F, 0.0F);
        this.Shieldthingy9 = new MowzieModelRenderer(this, 26, 40);
        this.Shieldthingy9.setRotationPoint(0.0F, -2.9000000953674316F, -22.0F);
        this.Shieldthingy9.addBox(-10.0F, -4.0F, 0.5F, 2, 3, 1);
        this.setRotation(Shieldthingy9, -0.3171542286872864F, -0.0F, 0.01745329238474369F);
        this.Tail5 = new MowzieModelRenderer(this, 37, 162);
        this.Tail5.setRotationPoint(0.0F, 4.0F, 38.0F);
        this.Tail5.addBox(-2.0F, -2.0F, 0.0F, 4, 5, 11);
        this.setRotation(Tail5, -0.01064650843716541F, -0.0F, 0.0F);
        this.Tail2 = new MowzieModelRenderer(this, 0, 123);
        this.Tail2.setRotationPoint(0.0F, 0.0F, 22.0F);
        this.Tail2.addBox(-4.5F, -3.0F, 0.0F, 9, 12, 8);
        this.setRotation(Tail2, -0.1616174887346749F, -0.0F, 0.0F);
        this.FrontCalfRight = new MowzieModelRenderer(this, 212, 24);
        this.FrontCalfRight.setRotationPoint(-8.5F, 13.0F, -3.4000000953674316F);
        this.FrontCalfRight.addBox(-2.0F, 0.0F, -5.0F, 4, 9, 5);
        this.setRotation(FrontCalfRight, -0.32325243949890137F, -0.0F, 0.0F);
        this.LeftFrontFoot = new MowzieModelRenderer(this, 0, 0);
        this.LeftFrontFoot.setRotationPoint(8.5F, 20.0F, -11.0F);
        this.LeftFrontFoot.addBox(-2.0F, 0.0F, 0.0F, 4, 4, 5);
        this.setRotation(LeftFrontFoot, -2.790294876053932E-16F, -0.0F, 0.0F);
        this.Shieldthingy4 = new MowzieModelRenderer(this, 26, 40);
        this.Shieldthingy4.setRotationPoint(0.0F, -2.9000000953674316F, -22.0F);
        this.Shieldthingy4.addBox(-10.0F, -8.0F, 0.5F, 2, 3, 1);
        this.setRotation(Shieldthingy4, -0.3171542286872864F, -0.0F, 0.01745329238474369F);
        this.Waist = new MowzieModelRenderer(this, 94, 217);
        this.Waist.setRotationPoint(0.0F, -2.0F, 10.0F);
        this.Waist.addBox(-8.5F, -5.0F, -10.4F, 17, 18, 17);
        this.setRotation(Waist, -0.03717551306747922F, -0.0F, 0.0F);
        this.Shieldthingy2 = new MowzieModelRenderer(this, 31, 219);
        this.Shieldthingy2.setRotationPoint(0.0F, -2.9000000953674316F, -22.0F);
        this.Shieldthingy2.addBox(-5.300000190734863F, -1.600000023841858F, -2.5F, 4, 3, 4);
        this.setRotation(Shieldthingy2, -0.6806784272193909F, -0.0F, 0.0F);
        this.Shieldthingy8 = new MowzieModelRenderer(this, 26, 40);
        this.Shieldthingy8.setRotationPoint(0.0F, -2.9000000953674316F, -22.0F);
        this.Shieldthingy8.addBox(-8.0F, -10.5F, 0.5F, 3, 2, 1);
        this.setRotation(Shieldthingy8, -0.3141592741012573F, -0.0F, 0.0F);
        this.RightFrontFoot = new MowzieModelRenderer(this, 0, 0);
        this.RightFrontFoot.setRotationPoint(-8.5F, 20.0F, -11.0F);
        this.RightFrontFoot.addBox(-2.0F, 0.0F, 0.0F, 4, 4, 5);
        this.setRotation(RightFrontFoot, -2.790294876053932E-16F, -0.0F, 0.0F);
        this.Collar = new MowzieModelRenderer(this, 28, 229);
        this.Collar.setRotationPoint(0.0F, -2.8F, -8.0F);
        this.Collar.addBox(-6.0F, 0.0F, 0.0F, 12, 14, 7);
        this.setRotation(Collar, -0.8042477193189871F, -0.0F, 0.0F);
        this.BackThighLeft = new MowzieModelRenderer(this, 180, 0);
        this.BackThighLeft.setRotationPoint(8.5F, -2.0F, 10.0F);
        this.BackThighLeft.addBox(-0.5F, 0.0F, -3.5F, 5, 16, 9);
        this.setRotation(BackThighLeft, -0.3284709652253328F, -0.0F, 0.0F);
        this.BackCalfRight = new MowzieModelRenderer(this, 213, 0);
        this.BackCalfRight.setRotationPoint(-10.5F, 9.399999618530273F, 2.700000047683716F);
        this.BackCalfRight.addBox(-2.0F, 0.0F, 0.0F, 4, 13, 5);
        this.setRotation(BackCalfRight, 0.3436902165412903F, -0.0F, 0.0F);
        this.Head = new MowzieModelRenderer(this, 37, 182);
        this.Head.setRotationPoint(0.0F, -2.9000000953674316F, -22.0F);
        this.Head.addBox(-5.0F, 0.0F, -10.0F, 10, 10, 10);
        this.setRotation(Head, 0.17907698452472687F, -0.0F, 0.0F);
        this.MiddleHorn = new MowzieModelRenderer(this, 23, 59);
        this.MiddleHorn.setRotationPoint(0.0F, -2.9000000953674316F, -22.0F);
        this.MiddleHorn.addBox(-1.0F, 2.5F, -13.0F, 2, 4, 2);
        this.setRotation(MiddleHorn, 0.03490658476948738F, -0.0F, 0.0F);
        this.LeftBackFoot = new MowzieModelRenderer(this, 0, 0);
        this.LeftBackFoot.setRotationPoint(10.5F, 20.0F, 11.800000190734863F);
        this.LeftBackFoot.addBox(-2.0F, 0.0F, -5.0F, 4, 4, 5);
        this.setRotation(LeftBackFoot, -2.790294876053932E-16F, -0.0F, 0.0F);
        this.Shieldthingy13 = new MowzieModelRenderer(this, 26, 40);
        this.Shieldthingy13.setRotationPoint(0.0F, -2.9000000953674316F, -22.0F);
        this.Shieldthingy13.addBox(8.0F, -4.0F, 0.5F, 2, 3, 1);
        this.setRotation(Shieldthingy13, -0.3171542286872864F, -0.0F, 0.01745329238474369F);
        this.Shieldthingy5 = new MowzieModelRenderer(this, 26, 40);
        this.Shieldthingy5.setRotationPoint(0.0F, -2.9000000953674316F, -22.0F);
        this.Shieldthingy5.addBox(5.0F, -10.5F, 0.5F, 3, 2, 1);
        this.setRotation(Shieldthingy5, -0.3141592741012573F, -0.0F, 0.0F);
        this.Shieldthingy10 = new MowzieModelRenderer(this, 26, 40);
        this.Shieldthingy10.setRotationPoint(0.0F, -2.9000000953674316F, -22.0F);
        this.Shieldthingy10.addBox(-10.0F, 0.0F, 0.5F, 2, 3, 1);
        this.setRotation(Shieldthingy10, -0.3171542286872864F, -0.0F, 0.01745329238474369F);

        addChildTo(MiddleHorn, Mouth);
        addChildTo(Mouth, Head);
        addChildTo(Shieldthingy1, Head);
        addChildTo(Shieldthingy2, Head);
        addChildTo(Shieldthingy3, Head);
        addChildTo(Shieldthingy4, Head);
        addChildTo(Shieldthingy5, Head);
        addChildTo(Shieldthingy6, Head);
        addChildTo(Shieldthingy7, Head);
        addChildTo(Shieldthingy8, Head);
        addChildTo(Shieldthingy9, Head);
        addChildTo(Shieldthingy9, Head);
        addChildTo(Shieldthingy10, Head);
        addChildTo(Shieldthingy11, Head);
        addChildTo(Shieldthingy12, Head);
        addChildTo(Shieldthingy13, Head);
        addChildTo(LeftHorn, Head);
        addChildTo(RightHorn, Head);

        addChildTo(LeftFrontFoot, FrontCalfLeft);
        addChildTo(FrontCalfLeft, FrontThighLeft);
        addChildTo(RightFrontFoot, FrontCalfRight);
        addChildTo(FrontCalfRight, FrontThighRight);
        addChildTo(FrontThighRight, Chest);
        addChildTo(FrontThighLeft, Chest);

        addChildTo(LeftBackFoot, BackCalfLeft);
        addChildTo(BackCalfLeft, BackThighLeft);
        addChildTo(RightBackFoot, BackCalfRight);
        addChildTo(BackCalfRight, BackThighRight);

        addChildTo(Head, Neck);
        addChildTo(Neck, Chest);
        addChildTo(Collar, Chest);
        addChildTo(Chest, Waist);

        addChildTo(Tail5, Tail4);
        addChildTo(Tail4, Tail3);
        addChildTo(Tail3, Tail2);
        addChildTo(Tail2, Tail1);
        addChildTo(Tail1, Waist);

        //Corrections
        MiddleHorn.setRotationPoint(0, 0, 0);
        Shieldthingy1.setRotationPoint(0, 0, 0);
        Shieldthingy2.setRotationPoint(0, 0, 0);
        Shieldthingy3.setRotationPoint(0, 0, 0);
        Shieldthingy4.setRotationPoint(0, 0, 0);
        Shieldthingy5.setRotationPoint(0, 0, 0);
        Shieldthingy6.setRotationPoint(0, 0, 0);
        Shieldthingy7.setRotationPoint(0, 0, 0);
        Shieldthingy8.setRotationPoint(0, 0, 0);
        Shieldthingy9.setRotationPoint(0, 0, 0);
        Shieldthingy10.setRotationPoint(0, 0, 0);
        Shieldthingy11.setRotationPoint(0, 0, 0);
        Shieldthingy12.setRotationPoint(0, 0, 0);
        Shieldthingy13.setRotationPoint(0, 0, 0);
        LeftHorn.setRotationPoint(0, 0, 0);
        RightHorn.setRotationPoint(0, 0, 0);
        Mouth.setRotationPoint(0, 0, 0);
        Chest.setRotationPoint(0, -5, -10);
        Tail1.setRotationPoint(0, -4F, 5);
        Tail1.rotateAngleX -= 0.2;
        Tail2.rotateAngleX -= 0.3;
        Tail3.rotateAngleX += 0.1;
        Tail4.rotateAngleX += 0.1;
        Tail5.rotateAngleX += 0.05;
        Waist.rotateAngleX += 0.07;
        FrontThighLeft.rotateAngleX -= 0.07;
        FrontThighRight.rotateAngleX -= 0.07;
        Neck.rotateAngleX -= 0.07;

		this.tailParts = new MowzieModelRenderer[] { this.Tail5, this.Tail4, this.Tail3, this.Tail2, this.Tail1 };

        BackCalfLeft.setInitValuesToCurrentPose();
        BackCalfRight.setInitValuesToCurrentPose();
        BackThighLeft.setInitValuesToCurrentPose();
        BackThighRight.setInitValuesToCurrentPose();
        FrontCalfLeft.setInitValuesToCurrentPose();
        FrontCalfRight.setInitValuesToCurrentPose();
        FrontThighLeft.setInitValuesToCurrentPose();
        FrontThighRight.setInitValuesToCurrentPose();
        Tail1.setInitValuesToCurrentPose();
        Tail2.setInitValuesToCurrentPose();
        Tail3.setInitValuesToCurrentPose();
        Tail4.setInitValuesToCurrentPose();
        Tail5.setInitValuesToCurrentPose();
        Chest.setInitValuesToCurrentPose();
        Neck.setInitValuesToCurrentPose();
        Head.setInitValuesToCurrentPose();
        Mouth.setInitValuesToCurrentPose();
        Shieldthingy1.setInitValuesToCurrentPose();
        Shieldthingy2.setInitValuesToCurrentPose();
        Shieldthingy3.setInitValuesToCurrentPose();
        MiddleHorn.setInitValuesToCurrentPose();
        LeftHorn.setInitValuesToCurrentPose();
        RightBackFoot.setInitValuesToCurrentPose();
        LeftBackFoot.setInitValuesToCurrentPose();
        Waist.setInitValuesToCurrentPose();
        RightHorn.setInitValuesToCurrentPose();
        Shieldthingy4.setInitValuesToCurrentPose();
        Shieldthingy5.setInitValuesToCurrentPose();
        Shieldthingy6.setInitValuesToCurrentPose();
        Shieldthingy7.setInitValuesToCurrentPose();
        Shieldthingy8.setInitValuesToCurrentPose();
        Shieldthingy9.setInitValuesToCurrentPose();
        Shieldthingy10.setInitValuesToCurrentPose();
        Shieldthingy11.setInitValuesToCurrentPose();
        Shieldthingy12.setInitValuesToCurrentPose();
        Shieldthingy13.setInitValuesToCurrentPose();
        Collar.setInitValuesToCurrentPose();
        LeftFrontFoot.setInitValuesToCurrentPose();
        RightFrontFoot.setInitValuesToCurrentPose();
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        animate((IAnimatedEntity) entity, f, f1, f2, f3, f4, f5);
        //       BackCalfLeft.render(f5);
        //       BackCalfRight.render(f5);
        BackThighLeft.render(f5);
        BackThighRight.render(f5);
 /*       FrontCalfLeft.render(f5);
        FrontCalfRight.render(f5);
        FrontThighLeft.render(f5);
        FrontThighRight.render(f5);*/
/*        Tail1.render(f5);
        Tail2.render(f5);
        Tail3.render(f5);
        Tail4.render(f5);
        Tail5.render(f5);
        Chest.render(f5);
        Neck.render(f5);
        Head.render(f5);
        Mouth.render(f5);
        Shieldthingy1.render(f5);
        Shieldthingy2.render(f5);
        Shieldthingy3.render(f5);
        MiddleHorn.render(f5);
        LeftHorn.render(f5);
        RightBackFoot.render(f5);
        LeftBackFoot.render(f5);*/
        Waist.render(f5);
/*        RightHorn.render(f5);
        Shieldthingy4.render(f5);
        Shieldthingy5.render(f5);
        Shieldthingy6.render(f5);
        Shieldthingy7.render(f5);
        Shieldthingy8.render(f5);
        Shieldthingy9.render(f5);
        Shieldthingy10.render(f5);
        Shieldthingy11.render(f5);
        Shieldthingy12.render(f5);
        Shieldthingy13.render(f5);
        Collar.render(f5);
        LeftFrontFoot.render(f5);
        RightFrontFoot.render(f5);*/
    }

    private void setRotation(MowzieModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void resetPose()
    {
        BackCalfLeft.setCurrentPoseToInitValues();
        BackCalfRight.setCurrentPoseToInitValues();
        BackThighLeft.setCurrentPoseToInitValues();
        BackThighRight.setCurrentPoseToInitValues();
        FrontCalfLeft.setCurrentPoseToInitValues();
        FrontCalfRight.setCurrentPoseToInitValues();
        FrontThighLeft.setCurrentPoseToInitValues();
        FrontThighRight.setCurrentPoseToInitValues();
        Tail1.setCurrentPoseToInitValues();
        Tail2.setCurrentPoseToInitValues();
        Tail3.setCurrentPoseToInitValues();
        Tail4.setCurrentPoseToInitValues();
        Tail5.setCurrentPoseToInitValues();
        Chest.setCurrentPoseToInitValues();
        Neck.setCurrentPoseToInitValues();
        Head.setCurrentPoseToInitValues();
        Mouth.setCurrentPoseToInitValues();
        Shieldthingy1.setCurrentPoseToInitValues();
        Shieldthingy2.setCurrentPoseToInitValues();
        Shieldthingy3.setCurrentPoseToInitValues();
        MiddleHorn.setCurrentPoseToInitValues();
        LeftHorn.setCurrentPoseToInitValues();
        RightBackFoot.setCurrentPoseToInitValues();
        LeftBackFoot.setCurrentPoseToInitValues();
        Waist.setCurrentPoseToInitValues();
        RightHorn.setCurrentPoseToInitValues();
        Shieldthingy4.setCurrentPoseToInitValues();
        Shieldthingy5.setCurrentPoseToInitValues();
        Shieldthingy6.setCurrentPoseToInitValues();
        Shieldthingy7.setCurrentPoseToInitValues();
        Shieldthingy8.setCurrentPoseToInitValues();
        Shieldthingy9.setCurrentPoseToInitValues();
        Shieldthingy10.setCurrentPoseToInitValues();
        Shieldthingy11.setCurrentPoseToInitValues();
        Shieldthingy12.setCurrentPoseToInitValues();
        Shieldthingy13.setCurrentPoseToInitValues();
        Collar.setCurrentPoseToInitValues();
        LeftFrontFoot.setCurrentPoseToInitValues();
        RightFrontFoot.setCurrentPoseToInitValues();
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, EntityTriceratops tric)
    {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, tric);
		this.resetPose();

		/*
		 * f = tric.frame; 
		 * f1 = (float) Math.cos(f/50)*0.5F + 1F; 
		 * f1 = 1.5F;
		 */

        //Sprinting functionality parameters
        float sprintModifier = (float) (1 / (1 + Math.exp(30 * (-f1 + 0.9))));
        float legOffsetModifier = 2.5F;
        float bobBase = 2F;
        if (sprintModifier >= 0.9) bobBase = 1F;

        float scaleFactor = 0.5F;
        float height = 0.5F;
        float frontOffset = -2F;
        float animationDegree = 2 - sprintModifier * 0.2F;

        faceTarget(Head, 2, f3, f4);
        faceTarget(Neck, 2, f3, f4);

        bob(Waist, bobBase * scaleFactor, height, false, f, f1);
        bob(BackThighLeft, bobBase * scaleFactor, height, false, f, f1);
        bob(BackThighRight, bobBase * scaleFactor, height, false, f, f1);
        walk(Waist, bobBase * scaleFactor, 0.1F * height, true, -1.5F, 0F, f, f1);
        walk(Head, bobBase * scaleFactor, 0.1F * height, false, -1.5F, 0F, f, f1);
        Waist.rotateAngleX += 0.1 * sprintModifier;
        Head.rotateAngleX += 0.6 * sprintModifier;

        walk(BackThighLeft, 1F * scaleFactor, 0.2F * animationDegree, false, 0F + sprintModifier * legOffsetModifier, 0F + sprintModifier * 0.2F, f, f1);
        walk(BackCalfLeft, 1F * scaleFactor, 0.2F * animationDegree - sprintModifier * 0.1F, true, 1F + sprintModifier * legOffsetModifier, 0F, f, f1);
        walk(LeftBackFoot, 1F * scaleFactor, 0.2F * animationDegree - sprintModifier * 0.1F, false, 1.5F + sprintModifier * legOffsetModifier, 0F, f, f1);

        walk(BackThighRight, 1F * scaleFactor, 0.2F * animationDegree, true, 0F, 0F + sprintModifier * 0.2F, f, f1);
        walk(BackCalfRight, 1F * scaleFactor, 0.2F * animationDegree - sprintModifier * 0.1F, false, 1F, 0F, f, f1);
        walk(RightBackFoot, 1F * scaleFactor, 0.2F * animationDegree - sprintModifier * 0.1F, true, 1.5F, 0F, f, f1);

        walk(FrontThighRight, 1F * scaleFactor, 0.2F * animationDegree, true, frontOffset + 0F, -0.1F + sprintModifier * 0.2F, f, f1);
        walk(FrontCalfRight, 1F * scaleFactor, 0.1F * animationDegree, true, frontOffset + 1F, -0.2F, f, f1);
        walk(RightFrontFoot, 1F * scaleFactor, 0.2F * animationDegree - sprintModifier * 0.1F, false, frontOffset + 1.5F, 0F, f, f1);

        walk(FrontThighLeft, 1F * scaleFactor, 0.2F * animationDegree, false, frontOffset + 0F + sprintModifier * legOffsetModifier, -0.1F + sprintModifier * 0.2F, f, f1);
        walk(FrontCalfLeft, 1F * scaleFactor, 0.1F * animationDegree, false, frontOffset + 1F + sprintModifier * legOffsetModifier, -0.2F, f, f1);
        walk(LeftFrontFoot, 1F * scaleFactor, 0.2F * animationDegree - sprintModifier * 0.1F, true, frontOffset + 1.5F + sprintModifier * legOffsetModifier, 0F, f, f1);

        chainWave(tailParts, bobBase * scaleFactor, 0.03F, 1F, f, f1);

        //Idling
        walk(Neck, 0.1F, 0.07F, false, -1F, 0F, tric.frame, 1F);
        walk(Head, 0.1F, 0.07F, true, 0F, 0F, tric.frame, 1F);
        walk(Waist, 0.1F, 0.025F, false, 0F, 0F, tric.frame, 1F);

        float inverseKinematicsConstant = 0.3F;
        walk(FrontThighRight, 0.1F, 0.1F * inverseKinematicsConstant, false, 0F, 0F, tric.frame, 1F);
        walk(FrontCalfRight, 0.1F, 0.3F * inverseKinematicsConstant, true, 0F, 0F, tric.frame, 1F);
        walk(RightFrontFoot, 0.1F, 0.175F * inverseKinematicsConstant, false, 0F, 0F, tric.frame, 1F);
        walk(FrontThighLeft, 0.1F, 0.1F * inverseKinematicsConstant, false, 0F, 0F, tric.frame, 1F);
        walk(FrontCalfLeft, 0.1F, 0.3F * inverseKinematicsConstant, true, 0F, 0F, tric.frame, 1F);
        walk(LeftFrontFoot, 0.1F, 0.175F * inverseKinematicsConstant, false, 0F, 0F, tric.frame, 1F);
        FrontThighRight.rotationPointZ -= 0.5 * Math.cos(tric.frame * 0.1F);
        FrontThighLeft.rotationPointZ -= 0.5 * Math.cos(tric.frame * 0.1F);

        chainSwing(tailParts, 0.1F, 0.05F, 2, tric.frame, 1F);
        chainWave(tailParts, 0.1F, -0.05F, 1, tric.frame, 1F);

        tric.tailBuffer.applyChainSwingBuffer(this.tailParts);

        //Specialized animations
        Head.rotateAngleZ += Math.cos(tric.frame) * tric.flailDegree.value / 3;
        FrontThighRight.rotateAngleX += Math.cos(tric.frame / 3) * tric.flailDegree.value * 0.3;
        FrontCalfRight.rotateAngleX += Math.cos((tric.frame + 1.5) / 3) * tric.flailDegree.value * 0.4;
        RightFrontFoot.rotateAngleX += Math.cos((-tric.frame + 3) / 3) * tric.flailDegree.value * 0.3;
        FrontThighLeft.rotateAngleX += Math.cos(tric.frame / 3) * tric.flailDegree.value * -0.3;
        FrontCalfLeft.rotateAngleX += Math.cos((tric.frame + 1.5) / 3) * tric.flailDegree.value * -0.4;
        LeftFrontFoot.rotateAngleX += Math.cos((tric.frame - 3) / 3) * tric.flailDegree.value * -0.3;
    }

    public void animate(IAnimatedEntity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        animator.update(entity);
        setRotationAngles(f, f1, f2, f3, f4, f5, (EntityTriceratops) entity);

        animator.setAnimation(1);
        animator.startPhase(4);
        animator.rotate(Waist, 0.25F, 0, 0);
        animator.rotate(FrontThighLeft, 0.125F, 0, 0);
        animator.rotate(FrontThighRight, 0.125F, 0, 0);
        animator.rotate(FrontCalfLeft, -0.55F, 0, 0);
        animator.rotate(FrontCalfRight, -0.55F, 0, 0);
        animator.rotate(LeftFrontFoot, 0.25F, 0, 0);
        animator.rotate(RightFrontFoot, 0.25F, 0, 0);
        animator.rotate(Tail1, -0.2F, 0, 0);
        animator.endPhase();
        animator.setStationaryPhase(2);
        animator.startPhase(8);
        animator.rotate(Waist, -0.4F, 0, 0);
        animator.rotate(Chest, 0.2F, 0, 0);
        animator.rotate(Head, 0.2F, 0, 0);
        animator.rotate(Tail1, 0.3F, 0, 0);
        animator.rotate(FrontThighLeft, 0.1F, 0, 0);
        animator.rotate(FrontThighRight, 0.1F, 0, 0);
        animator.rotate(FrontCalfLeft, -0.4F, 0, 0);
        animator.rotate(FrontCalfRight, -0.4F, 0, 0);
        animator.rotate(LeftFrontFoot, 0.1F, 0, 0);
        animator.rotate(RightFrontFoot, 0.1F, 0, 0);
        animator.endPhase();
        animator.setStationaryPhase(3);
        animator.startPhase(6);
        animator.rotate(Waist, 0.25F, 0, 0);
        animator.rotate(FrontThighLeft, -0.4F, 0, 0);
        animator.rotate(FrontThighRight, -0.4F, 0, 0);
        animator.rotate(FrontCalfLeft, -0.49F, 0, 0);
        animator.rotate(FrontCalfRight, -0.49F, 0, 0);
        animator.rotate(LeftFrontFoot, 0.6F, 0, 0);
        animator.rotate(RightFrontFoot, 0.6F, 0, 0);
        animator.rotate(Head, 0.2F, 0, 0);
        animator.rotate(Tail1, -0.2F, 0, 0);
        animator.endPhase();
        animator.setStationaryPhase(2);
        animator.startPhase(3);
        animator.rotate(Waist, 0.25F, 0, 0);
        animator.rotate(FrontThighLeft, -0.4F, 0, 0);
        animator.rotate(FrontThighRight, -0.4F, 0, 0);
        animator.rotate(FrontCalfLeft, -0.49F, 0, 0);
        animator.rotate(FrontCalfRight, -0.49F, 0, 0);
        animator.rotate(LeftFrontFoot, 0.6F, 0, 0);
        animator.rotate(RightFrontFoot, 0.6F, 0, 0);
        animator.rotate(Head, 0.2F, 0.3F, 0);
        animator.rotate(Tail1, -0.2F, 0, 0);
        animator.rotate(Chest, 0, -0.3F, 0);
        animator.rotate(FrontThighLeft, 0.7F, 0, 0);
        animator.rotate(FrontCalfLeft, 0.3F, 0, 0);
        animator.rotate(FrontThighRight, 0F, 0.5F, 0.0F);
        animator.endPhase();
        animator.setStationaryPhase(1);
        animator.startPhase(10);
        animator.rotate(Waist, 0.25F, 0, 0);
        animator.rotate(FrontThighLeft, -0.4F, 0, 0);
        animator.rotate(FrontThighRight, -0.4F, 0, 0);
        animator.rotate(FrontCalfLeft, -0.49F, 0, 0);
        animator.rotate(FrontCalfRight, -0.49F, 0, 0);
        animator.rotate(LeftFrontFoot, 0.6F, 0, 0);
        animator.rotate(RightFrontFoot, 0.6F, 0, 0);
        animator.rotate(Head, 0.2F, 0, 0);
        animator.rotate(Tail1, -0.2F, 0, 0);
        animator.endPhase();
        animator.resetPhase(10);
        //49 frames
        animator.setStationaryPhase(51);
    }
}
