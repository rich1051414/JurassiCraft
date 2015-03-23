package net.ilexiconn.jurassicraft.client.model.entity;

import net.ilexiconn.jurassicraft.client.model.animation.Animator;
import net.ilexiconn.jurassicraft.client.model.modelbase.ResettableModelRenderer;
import net.ilexiconn.jurassicraft.interfaces.IAnimatedEntity;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelParaceratherium extends ModelBase
{
    
    private Animator animator;
    public static final float PI = (float) Math.PI;
    ResettableModelRenderer legBackLeft1, legBackLeft2, legBackLeft3, legBackRight1, legBackRight2, legBackRight3, legFrontRight1, legFrontRight2, legFrontRight3, legFrontLeft1, legFrontLeft2, legFrontLeft3, bodyBack, bodyFront, bodyNeck, tail1, tail2, tail3, neck1, neck2, earRight, earLeft, head1, head2, head3, mouth;
    
    public ModelParaceratherium()
    {
        animator = new Animator(this);
        textureWidth = 512;
        textureHeight = 256;
        
        legBackLeft1 = new ResettableModelRenderer(this, 145, 70);
        legBackLeft1.addBox(-8F, -4F, -10F, 12, 22, 20);
        legBackLeft1.setRotationPoint(16F, -20F, 20F);
        legBackLeft1.setTextureSize(512, 256);
        legBackLeft1.mirror = true;
        setRotation(legBackLeft1, 0F, 0F, 0F);
        legBackLeft2 = new ResettableModelRenderer(this, 145, 120);
        legBackLeft2.addBox(0F, -4F, -5F, 8, 23, 10);
        legBackLeft2.setRotationPoint(11F, -4F, 18F);
        legBackLeft2.setTextureSize(512, 256);
        legBackLeft2.mirror = true;
        setRotation(legBackLeft2, 0.7853982F, 0F, 0F);
        legBackLeft3 = new ResettableModelRenderer(this, 145, 155);
        legBackLeft3.addBox(-3.5F, -1F, -3F, 7, 18, 8);
        legBackLeft3.setRotationPoint(15F, 7F, 30F);
        legBackLeft3.setTextureSize(512, 256);
        legBackLeft3.mirror = true;
        setRotation(legBackLeft3, 0F, 0F, 0F);
        legBackRight1 = new ResettableModelRenderer(this, 215, 70);
        legBackRight1.addBox(-4F, -4F, -10F, 12, 22, 20);
        legBackRight1.setRotationPoint(-16F, -20F, 20F);
        legBackRight1.setTextureSize(512, 256);
        legBackRight1.mirror = true;
        setRotation(legBackRight1, 0F, 0F, 0F);
        legBackRight2 = new ResettableModelRenderer(this, 215, 120);
        legBackRight2.addBox(-4F, -4F, -5F, 8, 23, 10);
        legBackRight2.setRotationPoint(-15F, -4F, 18F);
        legBackRight2.setTextureSize(512, 256);
        legBackRight2.mirror = true;
        setRotation(legBackRight2, 0.7853982F, 0F, 0F);
        legBackRight3 = new ResettableModelRenderer(this, 215, 155);
        legBackRight3.addBox(-3.5F, -1F, -3F, 7, 18, 8);
        legBackRight3.setRotationPoint(-15F, 7F, 30F);
        legBackRight3.setTextureSize(512, 256);
        legBackRight3.mirror = true;
        setRotation(legBackRight3, 0F, 0F, 0F);
        legFrontRight1 = new ResettableModelRenderer(this, 75, 70);
        legFrontRight1.addBox(-6F, -4F, -11F, 12, 28, 20);
        legFrontRight1.setRotationPoint(-15F, -26F, -14F);
        legFrontRight1.setTextureSize(512, 256);
        legFrontRight1.mirror = true;
        setRotation(legFrontRight1, 0F, 0F, 0F);
        legFrontRight2 = new ResettableModelRenderer(this, 75, 120);
        legFrontRight2.addBox(-4F, 0F, -4F, 8, 26, 10);
        legFrontRight2.setRotationPoint(-15F, -8F, -16F);
        legFrontRight2.setTextureSize(512, 256);
        legFrontRight2.mirror = true;
        setRotation(legFrontRight2, 0F, 0F, 0F);
        legFrontRight3 = new ResettableModelRenderer(this, 75, 160);
        legFrontRight3.addBox(-3.5F, 0F, -4.5F, 7, 10, 9);
        legFrontRight3.setRotationPoint(-15F, 14F, -15F);
        legFrontRight3.setTextureSize(512, 256);
        legFrontRight3.mirror = true;
        setRotation(legFrontRight3, 0F, 0F, 0F);
        legFrontLeft1 = new ResettableModelRenderer(this, 0, 70);
        legFrontLeft1.addBox(-5F, -4F, -11F, 12, 28, 20);
        legFrontLeft1.setRotationPoint(15F, -26F, -14F);
        legFrontLeft1.setTextureSize(512, 256);
        legFrontLeft1.mirror = true;
        setRotation(legFrontLeft1, 0F, 0F, 0F);
        legFrontLeft2 = new ResettableModelRenderer(this, 0, 120);
        legFrontLeft2.addBox(-4F, 0F, -4F, 8, 26, 10);
        legFrontLeft2.setRotationPoint(16F, -8F, -16F);
        legFrontLeft2.setTextureSize(512, 256);
        legFrontLeft2.mirror = true;
        setRotation(legFrontLeft2, 0F, 0F, 0F);
        legFrontLeft3 = new ResettableModelRenderer(this, 0, 160);
        legFrontLeft3.addBox(-3.5F, 0F, -4.5F, 7, 10, 9);
        legFrontLeft3.setRotationPoint(16F, 14F, -15F);
        legFrontLeft3.setTextureSize(512, 256);
        legFrontLeft3.mirror = true;
        setRotation(legFrontLeft3, 0F, 0F, 0F);
        bodyBack = new ResettableModelRenderer(this, 135, 0);
        bodyBack.addBox(-14F, -5.2F, -12F, 28, 32, 32);
        bodyBack.setRotationPoint(0F, -28F, 13F);
        bodyBack.setTextureSize(512, 256);
        bodyBack.mirror = true;
        setRotation(bodyBack, -0.0698132F, 0F, 0F);
        bodyFront = new ResettableModelRenderer(this, 0, 0);
        bodyFront.addBox(-16F, -8F, -42F, 32, 34, 34);
        bodyFront.setRotationPoint(0F, -25F, 13F);
        bodyFront.setTextureSize(512, 256);
        bodyFront.mirror = true;
        setRotation(bodyFront, -0.2094395F, 0F, 0F);
        bodyNeck = new ResettableModelRenderer(this, 260, 0);
        bodyNeck.addBox(-12F, -7F, -49F, 22, 23, 8);
        bodyNeck.setRotationPoint(0F, -25F, 13F);
        bodyNeck.setTextureSize(512, 256);
        bodyNeck.mirror = true;
        setRotation(bodyNeck, -0.2094395F, 0F, 0F);
        tail1 = new ResettableModelRenderer(this, 260, 35);
        tail1.addBox(-2F, -2F, 0F, 4, 4, 5);
        tail1.setRotationPoint(0F, -25F, 32F);
        tail1.setTextureSize(512, 256);
        tail1.mirror = true;
        setRotation(tail1, -0.2617994F, 0F, 0F);
        tail2 = new ResettableModelRenderer(this, 260, 44);
        tail2.addBox(-1.5F, 1F, 1F, 3, 15, 4);
        tail2.setRotationPoint(0F, -25F, 32F);
        tail2.setTextureSize(512, 256);
        tail2.mirror = true;
        setRotation(tail2, 0.2617994F, 0F, 0F);
        tail3 = new ResettableModelRenderer(this, 275, 44);
        tail3.addBox(-1F, 0F, -1.5F, 2, 16, 3);
        tail3.setRotationPoint(0F, -12F, 38.5F);
        tail3.setTextureSize(512, 256);
        tail3.mirror = true;
        setRotation(tail3, 0F, 0F, 0F);
        neck1 = new ResettableModelRenderer(this, 325, 0);
        neck1.addBox(-8F, -12F, -14F, 16, 20, 22);
        neck1.setRotationPoint(0F, -32F, -38F);
        neck1.setTextureSize(512, 256);
        neck1.mirror = true;
        setRotation(neck1, -0.7853982F, 0F, 0F);
        neck2 = new ResettableModelRenderer(this, 325, 50);
        neck2.addBox(-7F, -17F, -26F, 14, 17, 20);
        neck2.setRotationPoint(0F, -32F, -38F);
        neck2.setTextureSize(512, 256);
        neck2.mirror = true;
        setRotation(neck2, -0.2617994F, 0F, 0F);
        earRight = new ResettableModelRenderer(this, 400, 80);
        earRight.addBox(-7.5F, -23F, -29F, 2, 10, 4);
        earRight.setRotationPoint(0F, -32F, -38F);
        earRight.setTextureSize(512, 256);
        earRight.mirror = true;
        setRotation(earRight, -0.3490659F, 0F, 0F);
        earLeft = new ResettableModelRenderer(this, 420, 80);
        earLeft.addBox(5.5F, -23F, -29F, 2, 10, 4);
        earLeft.setRotationPoint(0F, -32F, -38F);
        earLeft.setTextureSize(512, 256);
        earLeft.mirror = true;
        setRotation(earLeft, -0.3490659F, 0F, 0F);
        head1 = new ResettableModelRenderer(this, 325, 90);
        head1.addBox(-8F, -25F, -28F, 16, 16, 10);
        head1.setRotationPoint(0F, -32F, -38F);
        head1.setTextureSize(512, 256);
        head1.mirror = true;
        setRotation(head1, 0.0872665F, 0F, 0F);
        head2 = new ResettableModelRenderer(this, 325, 120);
        head2.addBox(-7F, -31F, -36F, 14, 12, 16);
        head2.setRotationPoint(0F, -32F, -38F);
        head2.setTextureSize(512, 256);
        head2.mirror = true;
        setRotation(head2, 0.3490659F, 0F, 0F);
        head3 = new ResettableModelRenderer(this, 325, 150);
        head3.addBox(-6F, -9F, -46.8F, 12, 11, 7);
        head3.setRotationPoint(0F, -32F, -38F);
        head3.setTextureSize(512, 256);
        head3.mirror = true;
        setRotation(head3, -0.1745329F, 0F, 0F);
        mouth = new ResettableModelRenderer(this, 400, 50);
        mouth.addBox(-6F, -20F, -35F, 12, 4, 12);
        mouth.setRotationPoint(0F, -32F, -38F);
        mouth.setTextureSize(512, 256);
        mouth.mirror = true;
        setRotation(mouth, 0.3490659F, 0F, 0F);
        
        legBackLeft1.savefirstParameters();
        legBackLeft2.savefirstParameters();
        legBackLeft3.savefirstParameters();
        legBackRight1.savefirstParameters();
        legBackRight2.savefirstParameters();
        legBackRight3.savefirstParameters();
        legFrontRight1.savefirstParameters();
        legFrontRight2.savefirstParameters();
        legFrontRight3.savefirstParameters();
        legFrontLeft1.savefirstParameters();
        legFrontLeft2.savefirstParameters();
        legFrontLeft3.savefirstParameters();
        bodyBack.savefirstParameters();
        bodyFront.savefirstParameters();
        bodyNeck.savefirstParameters();
        tail1.savefirstParameters();
        tail2.savefirstParameters();
        tail3.savefirstParameters();
        neck1.savefirstParameters();
        neck2.savefirstParameters();
        earRight.savefirstParameters();
        earLeft.savefirstParameters();
        head1.savefirstParameters();
        head2.savefirstParameters();
        head3.savefirstParameters();
        mouth.savefirstParameters();
    }
    
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        animate(entity, f, f1, f2, f3, f4, f5);
        
        legBackLeft1.render(f5);
        legBackLeft2.render(f5);
        legBackLeft3.render(f5);
        legBackRight1.render(f5);
        legBackRight2.render(f5);
        legBackRight3.render(f5);
        legFrontRight1.render(f5);
        legFrontRight2.render(f5);
        legFrontRight3.render(f5);
        legFrontLeft1.render(f5);
        legFrontLeft2.render(f5);
        legFrontLeft3.render(f5);
        bodyBack.render(f5);
        bodyFront.render(f5);
        bodyNeck.render(f5);
        tail1.render(f5);
        tail2.render(f5);
        tail3.render(f5);
        neck1.render(f5);
        neck2.render(f5);
        earRight.render(f5);
        earLeft.render(f5);
        head1.render(f5);
        head2.render(f5);
        head3.render(f5);
        mouth.render(f5);
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
        
        float tailNaturalMovement = 0.15F * MathHelper.cos(0.05F * f2);
        float legsMovement1 = f1 * MathHelper.cos(f);
        float legsMovement2 = f1 * MathHelper.cos(f + this.PI);
        
        legFrontLeft1.rotateAngleX = 1.2F * legsMovement1 + legFrontLeft1.firstRotateAngleX;
        legFrontLeft2.pinLegPlaneYZ(legFrontLeft1, 16.881943F, legFrontLeft1.rotateAngleX);
        legFrontLeft2.rotateAngleX = legsMovement1 * legsMovement2;
        legFrontLeft3.pinLegPlaneYZ(legFrontLeft2, 22.022715F, legFrontLeft2.rotateAngleX);
        legFrontLeft3.rotateAngleX = 0.25F * legsMovement2;
        
        legFrontRight1.rotateAngleX = 1.2F * legsMovement2 + legFrontRight1.firstRotateAngleX;
        legFrontRight2.pinLegPlaneYZ(legFrontRight1, 16.881943F, legFrontRight1.rotateAngleX);
        legFrontRight2.rotateAngleX = legsMovement1 * legsMovement2;
        legFrontRight3.pinLegPlaneYZ(legFrontRight2, 22.022715F, legFrontRight2.rotateAngleX);
        legFrontRight3.rotateAngleX = 0.25F * legsMovement1;
        
        legBackRight1.rotateAngleX = legsMovement1 + legBackRight1.firstRotateAngleX;
        legBackRight2.pinLegPlaneYZ(legBackRight1, 16.124516F, legBackRight1.rotateAngleX);
        legBackRight2.rotateAngleX = legsMovement1 / 2.0F + legBackRight2.firstRotateAngleX;
        legBackRight3.pinLegPlaneYZ(legBackRight2, 16.27882F, legBackRight2.rotateAngleX);
        legBackRight3.rotateAngleX = 1.25F * legsMovement1;
        
        legBackLeft1.rotateAngleX = legsMovement2 + legBackLeft1.firstRotateAngleX;
        legBackLeft2.pinLegPlaneYZ(legBackLeft1, 16.124516F, legBackLeft1.rotateAngleX);
        legBackLeft2.rotateAngleX = legsMovement2 / 2.0F + legBackLeft2.firstRotateAngleX;
        legBackLeft3.pinLegPlaneYZ(legBackLeft2, 16.27882F, legBackLeft2.rotateAngleX);
        legBackLeft3.rotateAngleX = 1.25F * legsMovement2;
        
        tail1.rotateAngleX = tailNaturalMovement + tail1.firstRotateAngleX;
        tail2.rotateAngleX = tailNaturalMovement / 2.0F + tail2.firstRotateAngleX;
        tail3.pinLegPlaneYZ(tail2, 14.534442F, tail2.rotateAngleX);
    }
    
    public void animate(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        animator.update((IAnimatedEntity) entity);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    }
}
