package net.ilexiconn.jurassicraft.client.model.entity;

import com.rafamv.bygoneage.client.renderer.ResettableModelRenderer;
import com.rafamv.bygoneage.enums.BygoneAgeAnimationIDs;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import thehippomaster.AnimationAPI.IAnimatedEntity;
import thehippomaster.AnimationAPI.client.Animator;

public class ModelLeptictidium extends ModelBase
{

    private Animator animator;
    public ResettableModelRenderer mouth1, mouth2, mouth3, snout1, snout2, head1, head2, ear1, ear2, neck, body1, body2, butt, tail1, tail2, tail3, tail4, lefthand1, lefthand2, righthand1, righthand2, leftleg1, leftleg2, leftleg3, leftfoot, rightleg1, rightleg2, rightleg3, rightfoot;

    public ModelLeptictidium()
    {
        animator = new Animator(this);
        textureWidth = 64;
        textureHeight = 32;

        mouth2 = new ResettableModelRenderer(this, 40, 16);
        mouth2.addBox(-1F, 1F, -4F, 2, 1, 2);
        mouth2.setRotationPoint(0F, 13.5F, -5F);
        mouth2.setTextureSize(64, 32);
        mouth2.mirror = true;
        setRotation(mouth2, 0.0872665F, 0F, 0F);
        head1 = new ResettableModelRenderer(this, 30, 24);
        head1.addBox(-1.5F, -2F, -4F, 3, 3, 4);
        head1.setRotationPoint(0F, 13.5F, -5F);
        head1.setTextureSize(64, 32);
        head1.mirror = true;
        setRotation(head1, 0.0872665F, 0F, 0F);
        head2 = new ResettableModelRenderer(this, 44, 25);
        head2.addBox(-1F, -1.8F, -6.5F, 2, 2, 3);
        head2.setRotationPoint(0F, 13.5F, -5F);
        head2.setTextureSize(64, 32);
        head2.mirror = true;
        setRotation(head2, 0.2617994F, 0F, 0F);
        snout1 = new ResettableModelRenderer(this, 55, 28);
        snout1.addBox(-0.5F, -2.6F, -8F, 1, 1, 2);
        snout1.setRotationPoint(0F, 13.5F, -5F);
        snout1.setTextureSize(64, 32);
        snout1.mirror = true;
        setRotation(snout1, 0.5235988F, 0F, 0F);
        mouth3 = new ResettableModelRenderer(this, 45, 21);
        mouth3.addBox(-0.5F, 1F, -6F, 1, 1, 2);
        mouth3.setRotationPoint(0F, 13.5F, -5F);
        mouth3.setTextureSize(64, 32);
        mouth3.mirror = true;
        setRotation(mouth3, 0.0872665F, 0F, 0F);
        snout2 = new ResettableModelRenderer(this, 55, 25);
        snout2.addBox(-0.5F, -4.5F, -8F, 1, 1, 1);
        snout2.setRotationPoint(0F, 13.5F, -5F);
        snout2.setTextureSize(64, 32);
        snout2.mirror = true;
        setRotation(snout2, 0.7853982F, 0F, 0F);
        ear1 = new ResettableModelRenderer(this, 25, 20);
        ear1.addBox(0.5F, -4F, -2F, 1, 3, 1);
        ear1.setRotationPoint(0F, 13.5F, -5F);
        ear1.setTextureSize(64, 32);
        ear1.mirror = true;
        setRotation(ear1, -0.2617994F, 0F, 0.1570796F);
        ear2 = new ResettableModelRenderer(this, 31, 20);
        ear2.addBox(-1.5F, -4F, -2F, 1, 3, 1);
        ear2.setRotationPoint(0F, 13.5F, -5F);
        ear2.setTextureSize(64, 32);
        ear2.mirror = true;
        setRotation(ear2, -0.2617994F, 0F, -0.1570796F);
        neck = new ResettableModelRenderer(this, 20, 25);
        neck.addBox(-1F, -0.5F, -1F, 2, 2, 2);
        neck.setRotationPoint(0F, 13.5F, -4.5F);
        neck.setTextureSize(64, 32);
        neck.mirror = true;
        setRotation(neck, 0.0872665F, 0F, 0F);
        body1 = new ResettableModelRenderer(this, 20, 0);
        body1.addBox(-2F, -2F, -8F, 4, 4, 6);
        body1.setRotationPoint(0F, 16F, 4F);
        body1.setTextureSize(64, 32);
        body1.mirror = true;
        setRotation(body1, -0.1745329F, 0F, 0F);
        body2 = new ResettableModelRenderer(this, 0, 0);
        body2.addBox(-2.5F, -2.5F, -3.6F, 5, 5, 5);
        body2.setRotationPoint(0F, 16F, 4F);
        body2.setTextureSize(64, 32);
        body2.mirror = true;
        setRotation(body2, 0F, 0F, 0F);
        butt = new ResettableModelRenderer(this, 40, 0);
        butt.addBox(-1.5F, -2F, 0F, 3, 3, 4);
        butt.setRotationPoint(0F, 16F, 4F);
        butt.setTextureSize(64, 32);
        butt.mirror = true;
        setRotation(butt, 0F, 0F, 0F);
        tail1 = new ResettableModelRenderer(this, 54, 0);
        tail1.addBox(-1F, -1F, -0.2F, 2, 2, 3);
        tail1.setRotationPoint(0F, 15.5F, 8F);
        tail1.setTextureSize(64, 32);
        tail1.mirror = true;
        setRotation(tail1, 0.1745329F, 0F, 0F);
        tail2 = new ResettableModelRenderer(this, 54, 5);
        tail2.addBox(-0.5F, -1F, 2F, 1, 1, 3);
        tail2.setRotationPoint(0F, 15.5F, 8F);
        tail2.setTextureSize(64, 32);
        tail2.mirror = true;
        setRotation(tail2, 0F, 0F, 0F);
        tail3 = new ResettableModelRenderer(this, 54, 9);
        tail3.addBox(-0.5F, -0.2F, 4.7F, 1, 1, 4);
        tail3.setRotationPoint(0F, 15.5F, 8F);
        tail3.setTextureSize(64, 32);
        tail3.mirror = true;
        setRotation(tail3, 0.1745329F, 0F, 0F);
        tail4 = new ResettableModelRenderer(this, 52, 14);
        tail4.addBox(-0.5F, -1F, 8.5F, 1, 1, 5);
        tail4.setRotationPoint(0F, 15.5F, 8F);
        tail4.setTextureSize(64, 32);
        tail4.mirror = true;
        setRotation(tail4, 0.0872665F, 0F, 0F);
        lefthand1 = new ResettableModelRenderer(this, 25, 10);
        lefthand1.addBox(1F, -1F, -0.7F, 1, 3, 1);
        lefthand1.setRotationPoint(0F, 17F, -2.5F);
        lefthand1.setTextureSize(64, 32);
        lefthand1.mirror = true;
        setRotation(lefthand1, 0.1745329F, 0F, 0F);
        righthand1 = new ResettableModelRenderer(this, 30, 10);
        righthand1.addBox(-2F, -1F, -0.7F, 1, 3, 1);
        righthand1.setRotationPoint(0F, 17F, -2.5F);
        righthand1.setTextureSize(64, 32);
        righthand1.mirror = true;
        setRotation(righthand1, 0.1745329F, 0F, 0F);
        rightleg1 = new ResettableModelRenderer(this, 0, 10);
        rightleg1.addBox(-0.5F, 0F, -2F, 2, 4, 4);
        rightleg1.setRotationPoint(2F, 15F, 3F);
        rightleg1.setTextureSize(64, 32);
        rightleg1.mirror = true;
        setRotation(rightleg1, 0.1745329F, 0F, 0F);
        leftleg1 = new ResettableModelRenderer(this, 12, 10);
        leftleg1.addBox(-1F, 0F, -2F, 2, 4, 4);
        leftleg1.setRotationPoint(-2F, 15F, 3F);
        leftleg1.setTextureSize(64, 32);
        leftleg1.mirror = true;
        setRotation(leftleg1, 0.1745329F, 0F, 0F);
        rightleg3 = new ResettableModelRenderer(this, 0, 18);
        rightleg3.addBox(0F, 2.5F, 3.2F, 1, 5, 1);
        rightleg3.setRotationPoint(2F, 15F, 3F);
        rightleg3.setTextureSize(64, 32);
        rightleg3.mirror = true;
        setRotation(rightleg3, -0.5235988F, 0F, 0F);
        leftleg3 = new ResettableModelRenderer(this, 12, 18);
        leftleg3.addBox(-0.5F, 2.5F, 3.2F, 1, 5, 1);
        leftleg3.setRotationPoint(-2F, 15F, 3F);
        leftleg3.setTextureSize(64, 32);
        leftleg3.mirror = true;
        setRotation(leftleg3, -0.5235988F, 0F, 0F);
        rightfoot = new ResettableModelRenderer(this, 0, 24);
        rightfoot.addBox(0F, 8F, -2.1F, 1, 1, 2);
        rightfoot.setRotationPoint(2F, 15F, 3F);
        rightfoot.setTextureSize(64, 32);
        rightfoot.mirror = true;
        setRotation(rightfoot, 0F, 0F, 0F);
        leftfoot = new ResettableModelRenderer(this, 12, 24);
        leftfoot.addBox(-0.5F, 8F, -2.1F, 1, 1, 2);
        leftfoot.setRotationPoint(-2F, 15F, 3F);
        leftfoot.setTextureSize(64, 32);
        leftfoot.mirror = true;
        setRotation(leftfoot, 0F, 0F, 0F);
        lefthand2 = new ResettableModelRenderer(this, 25, 14);
        lefthand2.addBox(1F, 0.6F, 0.8F, 1, 3, 1);
        lefthand2.setRotationPoint(0F, 17F, -2.5F);
        lefthand2.setTextureSize(64, 32);
        lefthand2.mirror = true;
        setRotation(lefthand2, -0.9599311F, 0F, 0F);
        righthand2 = new ResettableModelRenderer(this, 30, 14);
        righthand2.addBox(-2F, 0.6F, 0.8F, 1, 3, 1);
        righthand2.setRotationPoint(0F, 17F, -2.5F);
        righthand2.setTextureSize(64, 32);
        righthand2.mirror = true;
        setRotation(righthand2, -0.9599311F, 0F, 0F);
        rightleg2 = new ResettableModelRenderer(this, 4, 18);
        rightleg2.addBox(0F, 2F, -2F, 1, 3, 2);
        rightleg2.setRotationPoint(2F, 15F, 3F);
        rightleg2.setTextureSize(64, 32);
        rightleg2.mirror = true;
        setRotation(rightleg2, 0.5235988F, 0F, 0F);
        leftleg2 = new ResettableModelRenderer(this, 16, 18);
        leftleg2.addBox(-0.5F, 2F, -2F, 1, 3, 2);
        leftleg2.setRotationPoint(-2F, 15F, 3F);
        leftleg2.setTextureSize(64, 32);
        leftleg2.mirror = true;
        setRotation(leftleg2, 0.5235988F, 0F, 0F);
        mouth1 = new ResettableModelRenderer(this, 38, 10);
        mouth1.addBox(-1.5F, 1F, -2.977778F, 3, 1, 3);
        mouth1.setRotationPoint(0F, 13.5F, -5F);
        mouth1.setTextureSize(64, 32);
        mouth1.mirror = true;
        setRotation(mouth1, 0.0872665F, 0F, 0F);

        mouth1.savefirstParameters();
        mouth2.savefirstParameters();
        mouth3.savefirstParameters();
        snout1.savefirstParameters();
        snout2.savefirstParameters();
        head1.savefirstParameters();
        head2.savefirstParameters();
        ear1.savefirstParameters();
        ear2.savefirstParameters();
        neck.savefirstParameters();
        body1.savefirstParameters();
        body2.savefirstParameters();
        butt.savefirstParameters();
        tail1.savefirstParameters();
        tail2.savefirstParameters();
        tail3.savefirstParameters();
        tail4.savefirstParameters();
        lefthand1.savefirstParameters();
        lefthand2.savefirstParameters();
        righthand1.savefirstParameters();
        righthand2.savefirstParameters();
        leftleg1.savefirstParameters();
        leftleg2.savefirstParameters();
        leftleg3.savefirstParameters();
        leftfoot.savefirstParameters();
        rightleg1.savefirstParameters();
        rightleg2.savefirstParameters();
        rightleg3.savefirstParameters();
        rightfoot.savefirstParameters();
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        animate(entity, f, f1, f2, f3, f4, f5);

        mouth1.render(f5);
        head1.render(f5);
        head2.render(f5);
        snout1.render(f5);
        mouth2.render(f5);
        mouth3.render(f5);
        snout2.render(f5);
        ear1.render(f5);
        ear2.render(f5);
        neck.render(f5);
        body1.render(f5);
        body2.render(f5);
        butt.render(f5);
        tail1.render(f5);
        tail2.render(f5);
        tail3.render(f5);
        tail4.render(f5);
        lefthand1.render(f5);
        lefthand2.render(f5);
        righthand2.render(f5);
        righthand1.render(f5);
        rightleg1.render(f5);
        leftleg1.render(f5);
        rightleg2.render(f5);
        leftleg2.render(f5);
        rightleg3.render(f5);
        leftleg3.render(f5);
        rightfoot.render(f5);
        leftfoot.render(f5);
    }

    private void setRotation(ResettableModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    @Override
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
    {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);

        float legMovementX1 = f1 * MathHelper.cos(f * 0.67F);
        float legMovementX2 = f1 * MathHelper.cos(f * 0.67F + (float) Math.PI);

        float headMovementX = f4 / (180F / (float) Math.PI);
        float headMovementY = f3 / (180F / (float) Math.PI);
        float handMovementX1 = f1 * MathHelper.cos(0.67F * f + (float) Math.PI);
        float handMovementX2 = f1 * MathHelper.cos(0.67F * f);

        float snoutNaturalMovementX = 0.02F * MathHelper.cos(0.05F * f2);
        float tailNaturalMovementX = MathHelper.sin(0.04F * f2);
        float tailNaturalMovementZ = MathHelper.sin(0.08F * f2);

        head1.rotateAngleX = headMovementX + head1.firstRotateAngleX;
        head2.rotateAngleX = headMovementX + head2.firstRotateAngleX;
        snout1.rotateAngleX = headMovementX + snoutNaturalMovementX + snout1.firstRotateAngleX;
        snout2.rotateAngleX = headMovementX + snoutNaturalMovementX + snout2.firstRotateAngleX;
        mouth1.rotateAngleX = headMovementX + mouth1.firstRotateAngleX;
        mouth2.rotateAngleX = headMovementX + mouth2.firstRotateAngleX;
        mouth3.rotateAngleX = headMovementX + mouth3.firstRotateAngleX;
        ear1.rotateAngleX = headMovementX + ear1.firstRotateAngleX;
        ear2.rotateAngleX = headMovementX + ear2.firstRotateAngleX;

        head1.rotateAngleY = headMovementY + head1.firstRotateAngleY;
        head2.rotateAngleY = headMovementY + head2.firstRotateAngleY;
        snout1.rotateAngleY = headMovementY + snout1.firstRotateAngleY;
        snout2.rotateAngleY = headMovementY + snout2.firstRotateAngleY;
        mouth1.rotateAngleY = headMovementY + mouth1.firstRotateAngleY;
        mouth2.rotateAngleY = headMovementY + mouth2.firstRotateAngleY;
        mouth3.rotateAngleY = headMovementY + mouth3.firstRotateAngleY;
        ear1.rotateAngleY = headMovementY + ear1.firstRotateAngleY;
        ear2.rotateAngleY = headMovementY + ear2.firstRotateAngleY;

        lefthand1.rotateAngleX = handMovementX1 + righthand1.firstRotateAngleX;
        lefthand2.rotateAngleX = handMovementX1 + righthand2.firstRotateAngleX;
        righthand1.rotateAngleX = handMovementX2 + lefthand1.firstRotateAngleX;
        righthand2.rotateAngleX = handMovementX2 + lefthand2.firstRotateAngleX;

        rightleg1.rotateAngleX = legMovementX1 + rightleg1.firstRotateAngleX;
        rightleg2.rotateAngleX = legMovementX1 + rightleg2.firstRotateAngleX;
        rightleg3.rotateAngleX = legMovementX1 + rightleg3.firstRotateAngleX;
        rightfoot.rotateAngleX = legMovementX1 + rightfoot.firstRotateAngleX;

        leftleg1.rotateAngleX = legMovementX2 + leftleg1.firstRotateAngleX;
        leftleg2.rotateAngleX = legMovementX2 + leftleg2.firstRotateAngleX;
        leftleg3.rotateAngleX = legMovementX2 + leftleg3.firstRotateAngleX;
        leftfoot.rotateAngleX = legMovementX2 + leftfoot.firstRotateAngleX;

        butt.rotateAngleX = 0.025F * tailNaturalMovementX + butt.firstRotateAngleZ;
        tail1.rotateAngleX = 0.20F * tailNaturalMovementX + tail1.firstRotateAngleX;
        tail2.rotateAngleX = 0.15F * tailNaturalMovementX + tail2.firstRotateAngleX;
        tail3.rotateAngleX = 0.20F * tailNaturalMovementX + tail3.firstRotateAngleX;
        tail4.rotateAngleX = 0.20F * tailNaturalMovementX + tail4.firstRotateAngleX;

        butt.rotateAngleZ = 0.025F * tailNaturalMovementZ + butt.firstRotateAngleZ;
        tail1.rotateAngleZ = 0.20F * tailNaturalMovementZ + tail1.firstRotateAngleZ;
        tail2.rotateAngleZ = 0.15F * tailNaturalMovementZ + tail2.firstRotateAngleZ;
        tail3.rotateAngleZ = 0.225F * tailNaturalMovementZ + tail3.firstRotateAngleZ;
        tail4.rotateAngleZ = 0.225F * tailNaturalMovementZ + tail4.firstRotateAngleZ;
    }

    public void animate(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        animator.update((IAnimatedEntity) entity);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);

        float mouthOpenRotation = (float) Math.PI / 8.0F;
        float mouthCloseRotation = (float) Math.PI / 16.0F;

        animator.setAnim(BygoneAgeAnimationIDs.ANIMATION_BITE.getAnimationID());
        animator.startPhase(5);
        animator.rotate(mouth1, mouthOpenRotation, 0F, 0F);
        animator.rotate(mouth2, mouthOpenRotation, 0F, 0F);
        animator.rotate(mouth3, mouthOpenRotation, 0F, 0F);
        animator.rotate(head1, -mouthOpenRotation, 0F, 0F);
        animator.rotate(head2, -mouthOpenRotation, 0F, 0F);
        animator.rotate(snout1, -mouthOpenRotation, 0F, 0F);
        animator.rotate(snout2, -mouthOpenRotation, 0F, 0F);
        animator.rotate(ear1, -mouthOpenRotation, 0F, 0F);
        animator.rotate(ear2, -mouthOpenRotation, 0F, 0F);
        animator.endPhase();
        animator.setStationaryPhase(2);
        animator.startPhase(1);
        animator.rotate(mouth1, mouthCloseRotation, 0F, 0F);
        animator.rotate(head1, mouthCloseRotation, 0F, 0F);
        animator.rotate(head2, mouthCloseRotation, 0F, 0F);
        animator.rotate(snout1, mouthCloseRotation, 0F, 0F);
        animator.rotate(snout2, mouthCloseRotation, 0F, 0F);
        animator.rotate(ear1, mouthCloseRotation, 0F, 0F);
        animator.rotate(ear2, mouthCloseRotation, 0F, 0F);
        animator.endPhase();
        animator.resetPhase(10);
    }
}
