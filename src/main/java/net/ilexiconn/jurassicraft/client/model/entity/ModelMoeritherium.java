package net.ilexiconn.jurassicraft.client.model.entity;

import com.rafamv.bygoneage.client.renderer.ResettableModelRenderer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelMoeritherium extends ModelBase {

	ResettableModelRenderer snout1, snout2, head1, head2, earleft, earright, mouth1, mouth2, body1, body2, body3, tail1, tail2, backlegleft1, backlegleft2, backlegleft3, backlegleft4, backlegright1, backlegright2, backlegright3, backlegright4, frontlegleft1, frontlegleft2, frontlegleft3,
			frontlegleft4, frontlegright1, frontlegright2, frontlegright3, frontlegright4;

	public ModelMoeritherium() {
		textureWidth = 128;
		textureHeight = 64;

		snout1 = new ResettableModelRenderer(this, 110, 0);
		snout1.addBox(-2.5F, -8.2F, -12F, 5, 3, 4);
		snout1.setRotationPoint(0F, 14.5F, -8.5F);
		snout1.setTextureSize(128, 64);
		snout1.mirror = true;
		setRotation(snout1, 0.5235988F, 0F, 0F);
		snout2 = new ResettableModelRenderer(this, 110, 7);
		snout2.addBox(-2F, -13F, -9.4F, 4, 3, 3);
		snout2.setRotationPoint(0F, 14.5F, -8.5F);
		snout2.setTextureSize(128, 64);
		snout2.mirror = true;
		setRotation(snout2, 1.047198F, 0F, 0F);
		mouth2 = new ResettableModelRenderer(this, 110, 13);
		mouth2.addBox(-2F, 0.2F, -12.2F, 4, 2, 4);
		mouth2.setRotationPoint(0F, 14.5F, -8.5F);
		mouth2.setTextureSize(128, 64);
		mouth2.mirror = true;
		setRotation(mouth2, 0F, 0F, 0F);
		head1 = new ResettableModelRenderer(this, 56, 11);
		head1.addBox(-4F, -5F, -4.5F, 8, 7, 4);
		head1.setRotationPoint(0F, 14.5F, -8.5F);
		head1.setTextureSize(128, 64);
		head1.mirror = true;
		setRotation(head1, 0F, 0F, 0F);
		head2 = new ResettableModelRenderer(this, 80, 10);
		head2.addBox(-4F, -6F, -10F, 8, 4, 7);
		head2.setRotationPoint(0F, 14.5F, -8.5F);
		head2.setTextureSize(128, 64);
		head2.mirror = true;
		setRotation(head2, 0.2617994F, 0F, 0F);
		mouth1 = new ResettableModelRenderer(this, 80, 21);
		mouth1.addBox(-3.5F, -1F, -9.5F, 7, 3, 5);
		mouth1.setRotationPoint(0F, 14.5F, -8.5F);
		mouth1.setTextureSize(128, 64);
		mouth1.mirror = true;
		setRotation(mouth1, 0F, 0F, 0F);
		body1 = new ResettableModelRenderer(this, 0, 0);
		body1.addBox(-5.5F, -4.5F, -7F, 11, 9, 17);
		body1.setRotationPoint(0F, 14F, 0F);
		body1.setTextureSize(128, 64);
		body1.mirror = true;
		setRotation(body1, 0F, 0F, 0F);
		body2 = new ResettableModelRenderer(this, 56, 0);
		body2.addBox(-5F, -4F, 7F, 10, 7, 4);
		body2.setRotationPoint(0F, 14F, 3F);
		body2.setTextureSize(128, 64);
		body2.mirror = true;
		setRotation(body2, 0F, 0F, 0F);
		body3 = new ResettableModelRenderer(this, 84, 0);
		body3.addBox(-5F, -4F, -10F, 10, 7, 3);
		body3.setRotationPoint(0F, 14F, 0F);
		body3.setTextureSize(128, 64);
		body3.mirror = true;
		setRotation(body3, 0F, 0F, 0F);
		tail1 = new ResettableModelRenderer(this, 40, 32);
		tail1.addBox(-0.5F, -1F, -1F, 1, 5, 1);
		tail1.setRotationPoint(0F, 11F, 14F);
		tail1.setTextureSize(128, 64);
		tail1.mirror = true;
		setRotation(tail1, 0.5235988F, 0F, 0F);
		tail2 = new ResettableModelRenderer(this, 44, 32);
		tail2.addBox(-0.5F, 3F, 1.5F, 1, 5, 1);
		tail2.setRotationPoint(0F, 11F, 14F);
		tail2.setTextureSize(128, 64);
		tail2.mirror = true;
		setRotation(tail2, -0.1745329F, 0F, 0F);
		backlegleft1 = new ResettableModelRenderer(this, 0, 26);
		backlegleft1.addBox(-3F, -3.25F, -2F, 5, 9, 7);
		backlegleft1.setRotationPoint(4F, 13F, 9.5F);
		backlegleft1.setTextureSize(128, 64);
		backlegleft1.mirror = true;
		setRotation(backlegleft1, 0F, 0F, 0F);
		backlegleft2 = new ResettableModelRenderer(this, 24, 26);
		backlegleft2.addBox(-2F, 5.7F, 0F, 4, 2, 4);
		backlegleft2.setRotationPoint(4F, 13F, 9.5F);
		backlegleft2.setTextureSize(128, 64);
		backlegleft2.mirror = true;
		setRotation(backlegleft2, 0F, 0F, 0F);
		backlegleft3 = new ResettableModelRenderer(this, 24, 37);
		backlegleft3.addBox(-1.5F, 5.5F, 3F, 3, 3, 3);
		backlegleft3.setRotationPoint(4F, 13F, 9.5F);
		backlegleft3.setTextureSize(128, 64);
		backlegleft3.mirror = true;
		setRotation(backlegleft3, -0.3490659F, 0F, 0F);
		backlegleft4 = new ResettableModelRenderer(this, 40, 26);
		backlegleft4.addBox(-2F, 9F, -1.2F, 4, 2, 4);
		backlegleft4.setRotationPoint(4F, 13F, 9.5F);
		backlegleft4.setTextureSize(128, 64);
		backlegleft4.mirror = true;
		setRotation(backlegleft4, 0F, 0F, 0F);
		backlegright1 = new ResettableModelRenderer(this, 0, 26);
		backlegright1.addBox(-2F, -3.25F, -2F, 5, 9, 7);
		backlegright1.setRotationPoint(-4F, 13F, 9.5F);
		backlegright1.setTextureSize(128, 64);
		backlegright1.mirror = true;
		setRotation(backlegright1, 0F, 0F, 0F);
		backlegright2 = new ResettableModelRenderer(this, 24, 26);
		backlegright2.addBox(-2F, 5.7F, 0F, 4, 2, 4);
		backlegright2.setRotationPoint(-4F, 13F, 9.5F);
		backlegright2.setTextureSize(128, 64);
		backlegright2.mirror = true;
		setRotation(backlegright2, 0F, 0F, 0F);
		backlegright3 = new ResettableModelRenderer(this, 24, 37);
		backlegright3.addBox(-1.5F, 5.8F, 2F, 3, 3, 3);
		backlegright3.setRotationPoint(-4F, 13F, 10.5F);
		backlegright3.setTextureSize(128, 64);
		backlegright3.mirror = true;
		setRotation(backlegright3, -0.3490659F, 0F, 0F);
		backlegright4 = new ResettableModelRenderer(this, 40, 26);
		backlegright4.addBox(-2F, 9F, -1.2F, 4, 2, 4);
		backlegright4.setRotationPoint(-4F, 13F, 9.5F);
		backlegright4.setTextureSize(128, 64);
		backlegright4.mirror = true;
		setRotation(backlegright4, 0F, 0F, 0F);
		frontlegleft1 = new ResettableModelRenderer(this, 0, 26);
		frontlegleft1.addBox(-3F, -2F, -3F, 5, 9, 7);
		frontlegleft1.setRotationPoint(4F, 13F, -5.5F);
		frontlegleft1.setTextureSize(128, 64);
		frontlegleft1.mirror = true;
		setRotation(frontlegleft1, 0F, 0F, 0F);
		frontlegleft2 = new ResettableModelRenderer(this, 24, 32);
		frontlegleft2.addBox(-2.5F, 7F, -0.5F, 4, 1, 4);
		frontlegleft2.setRotationPoint(4F, 13F, -5.5F);
		frontlegleft2.setTextureSize(128, 64);
		frontlegleft2.mirror = true;
		setRotation(frontlegleft2, 0F, 0F, 0F);
		frontlegleft3 = new ResettableModelRenderer(this, 24, 37);
		frontlegleft3.addBox(-2F, 6.2F, 2.8F, 3, 3, 3);
		frontlegleft3.setRotationPoint(4F, 13F, -5.5F);
		frontlegleft3.setTextureSize(128, 64);
		frontlegleft3.mirror = true;
		setRotation(frontlegleft3, -0.3490659F, 0F, 0F);
		frontlegleft4 = new ResettableModelRenderer(this, 40, 26);
		frontlegleft4.addBox(-2.5F, 9F, -1.2F, 4, 2, 4);
		frontlegleft4.setRotationPoint(4F, 13F, -5.5F);
		frontlegleft4.setTextureSize(128, 64);
		frontlegleft4.mirror = true;
		setRotation(frontlegleft4, 0F, 0F, 0F);
		frontlegright1 = new ResettableModelRenderer(this, 0, 26);
		frontlegright1.addBox(-2F, -2F, -3F, 5, 9, 7);
		frontlegright1.setRotationPoint(-4F, 13F, -5.5F);
		frontlegright1.setTextureSize(128, 64);
		frontlegright1.mirror = true;
		setRotation(frontlegright1, 0F, 0F, 0F);
		frontlegright2 = new ResettableModelRenderer(this, 24, 32);
		frontlegright2.addBox(-1.5F, 7F, -0.5F, 4, 1, 4);
		frontlegright2.setRotationPoint(-4F, 13F, -5.5F);
		frontlegright2.setTextureSize(128, 64);
		frontlegright2.mirror = true;
		setRotation(frontlegright2, 0F, 0F, 0F);
		frontlegright3 = new ResettableModelRenderer(this, 24, 37);
		frontlegright3.addBox(-1F, 6.2F, 2.8F, 3, 3, 3);
		frontlegright3.setRotationPoint(-4F, 13F, -5.5F);
		frontlegright3.setTextureSize(128, 64);
		frontlegright3.mirror = true;
		setRotation(frontlegright3, -0.3490659F, 0F, 0F);
		frontlegright4 = new ResettableModelRenderer(this, 40, 26);
		frontlegright4.addBox(-1.5F, 9F, -1.2F, 4, 2, 4);
		frontlegright4.setRotationPoint(-4F, 13F, -5.5F);
		frontlegright4.setTextureSize(128, 64);
		frontlegright4.mirror = true;
		setRotation(frontlegright4, 0F, 0F, 0F);
		earleft = new ResettableModelRenderer(this, 114, 19);
		earleft.addBox(1.5F, -1.5F, -5F, 2, 3, 0);
		earleft.setRotationPoint(0F, 14.5F, -10F);
		earleft.setTextureSize(128, 64);
		earleft.mirror = true;
		setRotation(earleft, -0.2617994F, -0.6981317F, -0.5235988F);
		earright = new ResettableModelRenderer(this, 110, 19);
		earright.addBox(-3.5F, -1.5F, -5F, 2, 3, 0);
		earright.setRotationPoint(0F, 14.5F, -10F);
		earright.setTextureSize(128, 64);
		earright.mirror = true;
		setRotation(earright, -0.2617994F, 0.6981317F, 0.5235988F);

		snout1.savefirstParameters();
		snout2.savefirstParameters();
		mouth2.savefirstParameters();
		head1.savefirstParameters();
		head2.savefirstParameters();
		mouth1.savefirstParameters();
		body1.savefirstParameters();
		body2.savefirstParameters();
		body3.savefirstParameters();
		tail1.savefirstParameters();
		tail2.savefirstParameters();
		backlegleft1.savefirstParameters();
		backlegleft2.savefirstParameters();
		backlegleft3.savefirstParameters();
		backlegleft4.savefirstParameters();
		backlegright1.savefirstParameters();
		backlegright2.savefirstParameters();
		backlegright3.savefirstParameters();
		backlegright4.savefirstParameters();
		frontlegleft1.savefirstParameters();
		frontlegleft2.savefirstParameters();
		frontlegleft3.savefirstParameters();
		frontlegleft4.savefirstParameters();
		frontlegright1.savefirstParameters();
		frontlegright2.savefirstParameters();
		frontlegright3.savefirstParameters();
		frontlegright4.savefirstParameters();
		earleft.savefirstParameters();
		earright.savefirstParameters();
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);

		snout1.render(f5);
		snout2.render(f5);
		mouth2.render(f5);
		head1.render(f5);
		head2.render(f5);
		mouth1.render(f5);
		body1.render(f5);
		body2.render(f5);
		body3.render(f5);
		tail1.render(f5);
		tail2.render(f5);
		backlegleft1.render(f5);
		backlegleft2.render(f5);
		backlegleft3.render(f5);
		backlegleft4.render(f5);
		backlegright1.render(f5);
		backlegright2.render(f5);
		backlegright3.render(f5);
		backlegright4.render(f5);
		frontlegleft1.render(f5);
		frontlegleft2.render(f5);
		frontlegleft3.render(f5);
		frontlegleft4.render(f5);
		frontlegright1.render(f5);
		frontlegright2.render(f5);
		frontlegright3.render(f5);
		frontlegright4.render(f5);
		earleft.render(f5);
		earright.render(f5);
	}

	private void setRotation(ResettableModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);

		float headMovementX = f4 / (180F / (float) Math.PI);
		float headMovementY = f3 / (180F / (float) Math.PI);
		float snoutNaturalMovement = MathHelper.cos(0.10F * f2);
		float legMovement1 = MathHelper.cos(f * 0.6662F + (float) Math.PI) * 1.4F * f1;
		float legMovement2 = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
		float tailMovement1 = 0.05F * MathHelper.cos(0.10F * f2);
		float tailMovement2 = 0.05F * MathHelper.sin(0.10F * f2);

		body1.rotateAngleX = body1.firstRotateAngleX;
		body2.rotateAngleX = body1.firstRotateAngleX;
		body3.rotateAngleX = body1.firstRotateAngleX;

		head1.rotateAngleX = headMovementX + head1.firstRotateAngleX;
		head2.rotateAngleX = headMovementX + head2.firstRotateAngleX;
		snout1.rotateAngleX = headMovementX + 0.01F * snoutNaturalMovement + snout1.firstRotateAngleX;
		snout2.rotateAngleX = headMovementX + 0.02F * snoutNaturalMovement + snout2.firstRotateAngleX;
		mouth1.rotateAngleX = headMovementX + mouth1.firstRotateAngleX;
		mouth2.rotateAngleX = headMovementX + mouth2.firstRotateAngleX;
		earright.rotateAngleX = headMovementX + earright.firstRotateAngleX;
		earleft.rotateAngleX = headMovementX + earleft.firstRotateAngleX;

		head1.rotateAngleY = headMovementY + head1.firstRotateAngleY;
		head2.rotateAngleY = headMovementY + head2.firstRotateAngleY;
		snout1.rotateAngleY = headMovementY + snout1.firstRotateAngleY;
		snout2.rotateAngleY = headMovementY + snout2.firstRotateAngleY;
		mouth1.rotateAngleY = headMovementY + mouth1.firstRotateAngleY;
		mouth2.rotateAngleY = headMovementY + mouth2.firstRotateAngleY;
		earright.rotateAngleY = headMovementY + earright.firstRotateAngleY;
		earleft.rotateAngleY = headMovementY + earleft.firstRotateAngleY;

		earright.rotateAngleZ = earright.firstRotateAngleZ;
		earleft.rotateAngleZ = earleft.firstRotateAngleZ;

		frontlegleft1.rotateAngleX = legMovement1 + frontlegleft1.firstRotateAngleX;
		frontlegleft2.rotateAngleX = legMovement1 + frontlegleft2.firstRotateAngleX;
		frontlegleft3.rotateAngleX = legMovement1 + frontlegleft3.firstRotateAngleX;
		frontlegleft4.rotateAngleX = legMovement1 + frontlegleft4.firstRotateAngleX;

		backlegright1.rotateAngleX = legMovement1 + backlegright1.firstRotateAngleX;
		backlegright2.rotateAngleX = legMovement1 + backlegright2.firstRotateAngleX;
		backlegright3.rotateAngleX = legMovement1 + backlegright3.firstRotateAngleX;
		backlegright4.rotateAngleX = legMovement1 + backlegright4.firstRotateAngleX;

		frontlegright1.rotateAngleX = legMovement2 + frontlegright1.firstRotateAngleX;
		frontlegright2.rotateAngleX = legMovement2 + frontlegright2.firstRotateAngleX;
		frontlegright3.rotateAngleX = legMovement2 + frontlegright3.firstRotateAngleX;
		frontlegright4.rotateAngleX = legMovement2 + frontlegright4.firstRotateAngleX;

		backlegleft1.rotateAngleX = legMovement2 + backlegleft1.firstRotateAngleX;
		backlegleft2.rotateAngleX = legMovement2 + backlegleft2.firstRotateAngleX;
		backlegleft3.rotateAngleX = legMovement2 + backlegleft3.firstRotateAngleX;
		backlegleft4.rotateAngleX = legMovement2 + backlegleft4.firstRotateAngleX;

		tail1.rotateAngleZ = tailMovement1 + tail1.firstRotateAngleZ;
		tail2.rotateAngleZ = tailMovement1 + tail2.firstRotateAngleZ;
		tail1.rotateAngleY = tailMovement2 + tail1.firstRotateAngleY;
		tail2.rotateAngleY = tailMovement2 + tail2.firstRotateAngleY;
		tail1.rotateAngleX = tailMovement2 + tail1.firstRotateAngleX;
		tail2.rotateAngleX = tailMovement2 + tail2.firstRotateAngleX;
	}

}
