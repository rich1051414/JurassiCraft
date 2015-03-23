package net.ilexiconn.jurassicraft.client.model.entity;

import net.ilexiconn.jurassicraft.client.model.animation.Animator;
import net.ilexiconn.jurassicraft.client.model.modelbase.ResettableModelRenderer;
import net.ilexiconn.jurassicraft.interfaces.IAnimatedEntity;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelBasilosaurus extends ModelBase
{
    
    private Animator animator;
    public static final float PI = (float) Math.PI;
    boolean hasBeenInWater = false;
    ResettableModelRenderer body12, body11, body10, body9, body8, body7, body6, body5, body4, body3, body2, body1, neck, head, snout1, mouth1, snout2, mouth2, flipperleftfront, flipperrightfront, flipperleftback, flipperrightback, bigflippersbase, bigflippersleft, bigflippersright, teethlowerjaw1, Teethupperjaw1, Teethupperjaw2, teethlowerjaw2;
    
    public ModelBasilosaurus()
    {
        animator = new Animator(this);
        textureWidth = 512;
        textureHeight = 256;
        
        body12 = new ResettableModelRenderer(this, 340, 95);
        body12.addBox(-8F, 142F, -6F, 16, 26, 12);
        body12.setRotationPoint(0F, 8F, 0F);
        body12.setTextureSize(512, 256);
        body12.mirror = true;
        setRotation(body12, 1.570796F, 0F, 0F);
        body11 = new ResettableModelRenderer(this, 270, 100);
        body11.addBox(-9F, 122F, -7.5F, 18, 20, 15);
        body11.setRotationPoint(0F, 8F, 0F);
        body11.setTextureSize(512, 256);
        body11.mirror = true;
        setRotation(body11, 1.570796F, 0F, 0F);
        body10 = new ResettableModelRenderer(this, 190, 100);
        body10.addBox(-10F, 104F, -9F, 20, 18, 18);
        body10.setRotationPoint(0F, 8F, 0F);
        body10.setTextureSize(512, 256);
        body10.mirror = true;
        setRotation(body10, 1.570796F, 0F, 0F);
        body9 = new ResettableModelRenderer(this, 100, 100);
        body9.addBox(-11F, 88F, -10.5F, 22, 16, 21);
        body9.setRotationPoint(0F, 8F, 0F);
        body9.setTextureSize(512, 256);
        body9.mirror = true;
        setRotation(body9, 1.570796F, 0F, 0F);
        body8 = new ResettableModelRenderer(this, 0, 100);
        body8.addBox(-12F, 72F, -12F, 24, 16, 24);
        body8.setRotationPoint(0F, 8F, 0F);
        body8.setTextureSize(512, 256);
        body8.mirror = true;
        setRotation(body8, 1.570796F, 0F, 0F);
        body7 = new ResettableModelRenderer(this, 240, 50);
        body7.addBox(-13F, 56F, -13F, 26, 16, 26);
        body7.setRotationPoint(0F, 8F, 0F);
        body7.setTextureSize(512, 256);
        body7.mirror = true;
        setRotation(body7, 1.570796F, 0F, 0F);
        body6 = new ResettableModelRenderer(this, 125, 50);
        body6.addBox(-14F, 40F, -14F, 28, 16, 28);
        body6.setRotationPoint(0F, 8F, 0F);
        body6.setTextureSize(512, 256);
        body6.mirror = true;
        setRotation(body6, 1.570796F, 0F, 0F);
        body5 = new ResettableModelRenderer(this, 0, 50);
        body5.addBox(-15F, 24F, -15F, 30, 16, 30);
        body5.setRotationPoint(0F, 8F, 0F);
        body5.setTextureSize(512, 256);
        body5.mirror = true;
        setRotation(body5, 1.570796F, 0F, 0F);
        body4 = new ResettableModelRenderer(this, 370, 0);
        body4.addBox(-16F, -24F, -16F, 32, 48, 32);
        body4.setRotationPoint(0F, 8F, 0F);
        body4.setTextureSize(512, 256);
        body4.mirror = true;
        setRotation(body4, 1.570796F, 0F, 0F);
        body3 = new ResettableModelRenderer(this, 240, 0);
        body3.addBox(-15.5F, -40F, -15.5F, 31, 16, 31);
        body3.setRotationPoint(0F, 8F, 0F);
        body3.setTextureSize(512, 256);
        body3.mirror = true;
        setRotation(body3, 1.570796F, 0F, 0F);
        body2 = new ResettableModelRenderer(this, 115, 0);
        body2.addBox(-15F, -56F, -15F, 30, 16, 30);
        body2.setRotationPoint(0F, 8F, 0F);
        body2.setTextureSize(512, 256);
        body2.mirror = true;
        setRotation(body2, 1.570796F, 0F, 0F);
        body1 = new ResettableModelRenderer(this, 0, 0);
        body1.addBox(-14F, -72F, -14F, 28, 16, 28);
        body1.setRotationPoint(0F, 8F, 0F);
        body1.setTextureSize(512, 256);
        body1.mirror = true;
        setRotation(body1, 1.570796F, 0F, 0F);
        neck = new ResettableModelRenderer(this, 0, 200);
        neck.addBox(-13F, -89F, -20F, 26, 20, 27);
        neck.setRotationPoint(0F, 8F, 0F);
        neck.setTextureSize(512, 256);
        neck.mirror = true;
        setRotation(neck, 1.48353F, 0F, 0F);
        head = new ResettableModelRenderer(this, 110, 200);
        head.addBox(-14F, -100F, 4F, 28, 16, 26);
        head.setRotationPoint(0F, 8F, 0F);
        head.setTextureSize(512, 256);
        head.mirror = true;
        setRotation(head, 1.745329F, 0F, 0F);
        snout1 = new ResettableModelRenderer(this, 225, 200);
        snout1.addBox(-11F, -114F, 28F, 22, 18, 10);
        snout1.setRotationPoint(0F, 8F, 0F);
        snout1.setTextureSize(512, 256);
        snout1.mirror = true;
        setRotation(snout1, 1.832596F, 0F, 0F);
        mouth1 = new ResettableModelRenderer(this, 345, 200);
        mouth1.addBox(-11F, -116F, 4F, 22, 16, 8);
        mouth1.setRotationPoint(0F, 8F, 0F);
        mouth1.setTextureSize(512, 256);
        mouth1.mirror = true;
        setRotation(mouth1, 1.745329F, 0F, 0F);
        snout2 = new ResettableModelRenderer(this, 290, 200);
        snout2.addBox(-9F, -132F, 19F, 18, 16, 9);
        snout2.setRotationPoint(0F, 8F, 0F);
        snout2.setTextureSize(512, 256);
        snout2.mirror = true;
        setRotation(snout2, 1.745329F, 0F, 0F);
        mouth2 = new ResettableModelRenderer(this, 410, 200);
        mouth2.addBox(-9F, -132F, 5F, 18, 16, 7);
        mouth2.setRotationPoint(0F, 8F, 0F);
        mouth2.setTextureSize(512, 256);
        mouth2.mirror = true;
        setRotation(mouth2, 1.745329F, 0F, 0F);
        flipperleftfront = new ResettableModelRenderer(this, 285, 140);
        flipperleftfront.addBox(0F, -10F, -7F, 6, 32, 20);
        flipperleftfront.setRotationPoint(15F, 20F, -40F);
        flipperleftfront.setTextureSize(512, 256);
        flipperleftfront.mirror = true;
        setRotation(flipperleftfront, 0.5235988F, 0F, -0.8726646F);
        flipperrightfront = new ResettableModelRenderer(this, 340, 140);
        flipperrightfront.addBox(-6F, -10F, -7F, 6, 32, 20);
        flipperrightfront.setRotationPoint(-15F, 20F, -40F);
        flipperrightfront.setTextureSize(512, 256);
        flipperrightfront.mirror = true;
        setRotation(flipperrightfront, 0.5235988F, 0F, 0.8726646F);
        flipperleftback = new ResettableModelRenderer(this, 250, 140);
        flipperleftback.addBox(-1F, -2F, -2F, 2, 6, 12);
        flipperleftback.setRotationPoint(14.5F, 16F, 48F);
        flipperleftback.setTextureSize(512, 256);
        flipperleftback.mirror = true;
        setRotation(flipperleftback, 0F, 0.2617994F, -0.7853982F);
        flipperrightback = new ResettableModelRenderer(this, 250, 160);
        flipperrightback.addBox(-1F, -2F, -2F, 2, 6, 12);
        flipperrightback.setRotationPoint(-14.5F, 16F, 48F);
        flipperrightback.setTextureSize(512, 256);
        flipperrightback.mirror = true;
        setRotation(flipperrightback, 0F, -0.2617994F, 0.7853982F);
        bigflippersbase = new ResettableModelRenderer(this, 0, 150);
        bigflippersbase.addBox(-28F, 142F, -4F, 56, 24, 8);
        bigflippersbase.setRotationPoint(0F, 8F, 0F);
        bigflippersbase.setTextureSize(512, 256);
        bigflippersbase.mirror = true;
        setRotation(bigflippersbase, 1.570796F, 0F, 0F);
        bigflippersleft = new ResettableModelRenderer(this, 130, 150);
        bigflippersleft.addBox(94.5F, 111F, -2F, 24, 24, 4);
        bigflippersleft.setRotationPoint(0F, 8F, 0F);
        bigflippersleft.setTextureSize(512, 256);
        bigflippersleft.mirror = true;
        setRotation(bigflippersleft, 1.570796F, -0.5235988F, 0F);
        bigflippersright = new ResettableModelRenderer(this, 190, 150);
        bigflippersright.addBox(-119F, 111F, -2F, 24, 24, 4);
        bigflippersright.setRotationPoint(0F, 8F, 0F);
        bigflippersright.setTextureSize(512, 256);
        bigflippersright.mirror = true;
        setRotation(bigflippersright, 1.570796F, 0.5235988F, 0F);
        teethlowerjaw1 = new ResettableModelRenderer(this, 400, 150);
        teethlowerjaw1.addBox(-11F, -116F, 12F, 22, 16, 2);
        teethlowerjaw1.setRotationPoint(0F, 8F, 0F);
        teethlowerjaw1.setTextureSize(512, 256);
        teethlowerjaw1.mirror = true;
        setRotation(teethlowerjaw1, 1.745329F, 0F, 0F);
        Teethupperjaw1 = new ResettableModelRenderer(this, 450, 150);
        Teethupperjaw1.addBox(-11F, -114F, 26F, 22, 16, 2);
        Teethupperjaw1.setRotationPoint(0F, 8F, 0F);
        Teethupperjaw1.setTextureSize(512, 256);
        Teethupperjaw1.mirror = true;
        setRotation(Teethupperjaw1, 1.832596F, 0F, 0F);
        Teethupperjaw2 = new ResettableModelRenderer(this, 450, 120);
        Teethupperjaw2.addBox(-9F, -132.5F, 14F, 18, 16, 2);
        Teethupperjaw2.setRotationPoint(0F, 5F, 0F);
        Teethupperjaw2.setTextureSize(512, 256);
        Teethupperjaw2.mirror = true;
        setRotation(Teethupperjaw2, 1.745329F, 0F, 0F);
        teethlowerjaw2 = new ResettableModelRenderer(this, 400, 120);
        teethlowerjaw2.addBox(-9F, -132F, 12F, 18, 16, 2);
        teethlowerjaw2.setRotationPoint(0F, 8F, 0F);
        teethlowerjaw2.setTextureSize(512, 256);
        teethlowerjaw2.mirror = true;
        setRotation(teethlowerjaw2, 1.745329F, 0F, 0F);
        
        body12.savefirstParameters();
        body11.savefirstParameters();
        body10.savefirstParameters();
        body9.savefirstParameters();
        body8.savefirstParameters();
        body7.savefirstParameters();
        body6.savefirstParameters();
        body5.savefirstParameters();
        body4.savefirstParameters();
        body3.savefirstParameters();
        body2.savefirstParameters();
        body1.savefirstParameters();
        neck.savefirstParameters();
        head.savefirstParameters();
        snout1.savefirstParameters();
        snout2.savefirstParameters();
        mouth1.savefirstParameters();
        mouth2.savefirstParameters();
        flipperleftfront.savefirstParameters();
        flipperrightfront.savefirstParameters();
        flipperleftback.savefirstParameters();
        flipperrightback.savefirstParameters();
        bigflippersbase.savefirstParameters();
        bigflippersleft.savefirstParameters();
        bigflippersright.savefirstParameters();
        teethlowerjaw1.savefirstParameters();
        Teethupperjaw1.savefirstParameters();
        Teethupperjaw2.savefirstParameters();
        teethlowerjaw2.savefirstParameters();
    }
    
    public void resetOffsetY()
    {
        body12.resetYOffsets();
        body11.resetYOffsets();
        body10.resetYOffsets();
        body9.resetYOffsets();
        body8.resetYOffsets();
        body7.resetYOffsets();
        body6.resetYOffsets();
        body5.resetYOffsets();
        body4.resetYOffsets();
        body3.resetYOffsets();
        body2.resetYOffsets();
        body1.resetYOffsets();
        neck.resetYOffsets();
        head.resetYOffsets();
        mouth1.resetYOffsets();
        snout2.resetYOffsets();
        mouth2.resetYOffsets();
        snout1.resetYOffsets();
        snout1.resetZOffsets();
        flipperleftfront.resetYOffsets();
        flipperrightfront.resetYOffsets();
        flipperleftback.resetYOffsets();
        flipperrightback.resetYOffsets();
        bigflippersbase.resetYOffsets();
        bigflippersleft.resetYOffsets();
        bigflippersright.resetYOffsets();
        teethlowerjaw1.resetYOffsets();
        Teethupperjaw1.resetZOffsets();
        Teethupperjaw2.resetYOffsets();
    }
    
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        
        body12.render(f5);
        body11.render(f5);
        body10.render(f5);
        body9.render(f5);
        body8.render(f5);
        body7.render(f5);
        body6.render(f5);
        body5.render(f5);
        body4.render(f5);
        body3.render(f5);
        body2.render(f5);
        body1.render(f5);
        neck.render(f5);
        head.render(f5);
        snout1.render(f5);
        snout2.render(f5);
        mouth1.render(f5);
        mouth2.render(f5);
        flipperleftfront.render(f5);
        flipperrightfront.render(f5);
        flipperleftback.render(f5);
        flipperrightback.render(f5);
        bigflippersbase.render(f5);
        bigflippersleft.render(f5);
        bigflippersright.render(f5);
        teethlowerjaw1.render(f5);
        Teethupperjaw1.render(f5);
        Teethupperjaw2.render(f5);
        teethlowerjaw2.render(f5);
    }
    
    private void setRotation(ResettableModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
    
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
    {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        
        if (entity.isInWater())
        {
            if (hasBeenInWater)
            {
                resetOffsetY();
            }
            float naturalMovement = 1.50F * MathHelper.sin(0.10F * f2 + (float) Math.PI);
            float swimmingMovement = 2.25F * f1 * MathHelper.sin(0.25F * f + (float) Math.PI);
            float headMovement = 0.014F * naturalMovement + 0.06F * swimmingMovement;
            snout2.rotateAngleX = headMovement + snout2.firstRotateAngleX;
            snout1.rotateAngleX = headMovement + snout1.firstRotateAngleX;
            mouth2.rotateAngleX = headMovement + mouth2.firstRotateAngleX;
            mouth1.rotateAngleX = headMovement + mouth1.firstRotateAngleX;
            teethlowerjaw1.rotateAngleX = headMovement + teethlowerjaw1.firstRotateAngleX;
            teethlowerjaw2.rotateAngleX = headMovement + teethlowerjaw2.firstRotateAngleX;
            Teethupperjaw1.rotateAngleX = headMovement + Teethupperjaw1.firstRotateAngleX;
            Teethupperjaw2.rotateAngleX = headMovement + Teethupperjaw2.firstRotateAngleX;
            head.rotateAngleX = 0.014F * naturalMovement + 0.055F * swimmingMovement + head.firstRotateAngleX;
            neck.rotateAngleX = 0.013F * naturalMovement + 0.050F * swimmingMovement + neck.firstRotateAngleX;
            body1.rotateAngleX = 0.012F * naturalMovement + 0.050F * swimmingMovement + body1.firstRotateAngleX;
            body2.rotateAngleX = 0.011F * naturalMovement + 0.040F * swimmingMovement + body2.firstRotateAngleX;
            body3.rotateAngleX = 0.010F * naturalMovement + 0.030F * swimmingMovement + body3.firstRotateAngleX;
            flipperleftfront.rotateAngleX = 0.10F * naturalMovement + 0.30F * swimmingMovement + flipperleftfront.firstRotateAngleX;
            flipperrightfront.rotateAngleX = 0.10F * naturalMovement + 0.30F * swimmingMovement + flipperrightfront.firstRotateAngleX;
            flipperleftfront.rotateAngleY = flipperleftfront.firstRotateAngleY;
            flipperrightfront.rotateAngleY = flipperrightfront.firstRotateAngleY;
            flipperleftfront.rotateAngleZ = flipperleftfront.firstRotateAngleZ;
            flipperrightfront.rotateAngleZ = flipperrightfront.firstRotateAngleZ;
            body5.rotateAngleX = -0.01F * MathHelper.sin(0.10F * f2) + 0.03F * swimmingMovement + body5.firstRotateAngleX;
            body6.rotateAngleX = -0.011F * MathHelper.sin(0.10F * f2) + 0.045F * swimmingMovement + body6.firstRotateAngleX;
            flipperleftback.rotateAngleX = -0.05F * MathHelper.sin(0.10F * f2) + 0.045F * swimmingMovement + flipperleftback.firstRotateAngleX;
            flipperrightback.rotateAngleX = -0.05F * MathHelper.sin(0.10F * f2) + 0.045F * swimmingMovement + flipperrightback.firstRotateAngleX;
            flipperleftback.rotateAngleY = 0.05F * swimmingMovement + flipperleftback.firstRotateAngleY;
            flipperrightback.rotateAngleY = 0.05F * swimmingMovement + flipperrightfront.firstRotateAngleY;
            flipperleftback.rotateAngleZ = 0.05F * swimmingMovement + flipperleftback.firstRotateAngleZ;
            flipperrightback.rotateAngleZ = 0.05F * swimmingMovement + flipperrightfront.firstRotateAngleZ;
            float bodySwing = MathHelper.sin(0.10F * f2);
            body7.rotateAngleX = -0.012F * bodySwing + 0.06F * swimmingMovement + body7.firstRotateAngleX;
            body8.rotateAngleX = -0.013F * bodySwing + 0.075F * swimmingMovement + body8.firstRotateAngleX;
            body9.rotateAngleX = -0.014F * bodySwing + 0.09F * swimmingMovement + body9.firstRotateAngleX;
            body10.rotateAngleX = -0.015F * bodySwing + 0.105F * swimmingMovement + body10.firstRotateAngleX;
            body11.rotateAngleX = -0.016F * bodySwing + 0.12F * swimmingMovement + body11.firstRotateAngleX;
            body12.rotateAngleX = -0.017F * bodySwing + 0.135F * swimmingMovement + body12.firstRotateAngleX;
            bigflippersbase.rotateAngleX = -0.017F * bodySwing + 0.135F * swimmingMovement + bigflippersbase.firstRotateAngleX;
            bigflippersleft.rotateAngleX = -0.017F * bodySwing + 0.135F * swimmingMovement + bigflippersleft.firstRotateAngleX;
            bigflippersright.rotateAngleX = -0.017F * bodySwing + 0.135F * swimmingMovement + bigflippersright.firstRotateAngleX;
        }
        else
        {
            resetOffsetY();
            float naturalMovement = MathHelper.sin(0.5F * f2);
            float jumptranslation = 0.2F * (MathHelper.sin(0.8F * f2) - 1);
            bigflippersbase.offsetY = jumptranslation + 0.8F * naturalMovement;
            bigflippersright.offsetY = jumptranslation + 0.8F * naturalMovement;
            bigflippersleft.offsetY = jumptranslation + 0.8F * naturalMovement;
            body12.offsetY = jumptranslation + 0.8F * naturalMovement;
            body11.offsetY = jumptranslation + 0.7F * naturalMovement;
            body10.offsetY = jumptranslation + 0.5F * naturalMovement;
            body9.offsetY = jumptranslation + 0.4F * naturalMovement;
            body8.offsetY = jumptranslation + 0.3F * naturalMovement;
            body7.offsetY = jumptranslation + 0.3F * naturalMovement;
            body6.offsetY = jumptranslation + 0.2F * naturalMovement;
            flipperleftback.offsetY = jumptranslation + 0.2F * naturalMovement;
            flipperrightback.offsetY = jumptranslation + 0.2F * naturalMovement;
            flipperleftback.rotateAngleX = jumptranslation;
            flipperrightback.rotateAngleX = jumptranslation;
            body5.offsetY = jumptranslation + 0.1F * naturalMovement;
            body4.offsetY = jumptranslation;
            flipperleftfront.offsetY = jumptranslation;
            flipperrightfront.offsetY = jumptranslation;
            flipperleftfront.rotateAngleX = jumptranslation;
            flipperrightfront.rotateAngleX = jumptranslation;
            body3.offsetY = jumptranslation;
            body2.offsetY = jumptranslation + 0.1F * naturalMovement;
            body1.offsetY = jumptranslation + 0.2F * naturalMovement;
            neck.offsetY = jumptranslation + -0.4F + 0.2F * naturalMovement;
            neck.rotateAngleX = (float) Math.PI / 2;
            head.offsetY = jumptranslation + 1.0F + 0.2F * naturalMovement;
            head.rotateAngleX = (float) Math.PI / 2;
            snout1.offsetY = jumptranslation + 1.6F + 0.2F * naturalMovement;
            snout1.offsetZ = -0.2F;
            snout1.rotateAngleX = (float) Math.PI / 2;
            Teethupperjaw1.offsetY = jumptranslation + 1.6F + 0.2F * naturalMovement;
            Teethupperjaw1.offsetZ = -0.2F;
            Teethupperjaw1.rotateAngleX = (float) Math.PI / 2;
            snout2.offsetY = jumptranslation + 1.05F + 0.2F * naturalMovement;
            snout2.rotateAngleX = (float) Math.PI / 2;
            Teethupperjaw2.offsetY = jumptranslation + 1.05F + 0.2F * naturalMovement;
            Teethupperjaw2.rotateAngleX = (float) Math.PI / 2;
            mouth1.offsetY = jumptranslation + 1.0F + 0.2F * naturalMovement;
            mouth1.rotateAngleX = (float) Math.PI / 2;
            teethlowerjaw1.offsetY = jumptranslation + 1.0F + 0.2F * naturalMovement;
            teethlowerjaw1.rotateAngleX = (float) Math.PI / 2;
            mouth2.offsetY = jumptranslation + 1.0F + 0.2F * naturalMovement;
            mouth2.rotateAngleX = (float) Math.PI / 2;
            teethlowerjaw2.offsetY = jumptranslation + 1.0F + 0.2F * naturalMovement;
            teethlowerjaw2.rotateAngleX = (float) Math.PI / 2;
            hasBeenInWater = true;
        }
    }
    
    public void animate(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        animator.update((IAnimatedEntity) entity);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    }
    
}
