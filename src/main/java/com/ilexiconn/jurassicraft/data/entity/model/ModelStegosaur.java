package com.ilexiconn.jurassicraft.data.entity.model;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class ModelStegosaur extends ModelBase
{
    ModelRenderer body_1;
    ModelRenderer leg_left_1;
    ModelRenderer leg_right_1;
    ModelRenderer neck_1;
    ModelRenderer tail_1;
    ModelRenderer tail_2;
    ModelRenderer tail_3;
    ModelRenderer tail_4;
    ModelRenderer leg_left_2;
    ModelRenderer leg_right_2;
    ModelRenderer leg_right_3;
    ModelRenderer leg_left_3;
    ModelRenderer foot_left;
    ModelRenderer arm_right_1;
    ModelRenderer arm_left_1;
    ModelRenderer arm_left_2;
    ModelRenderer arm_right_2;
    ModelRenderer head_back;
    ModelRenderer upper_jaw_1;
    ModelRenderer head_;
    ModelRenderer tail_end;
    ModelRenderer lower_jaw;
    ModelRenderer plate_1;
    ModelRenderer plate_2;
    ModelRenderer plate_3;
    ModelRenderer plate_4;
    ModelRenderer plate_5;
    ModelRenderer plate_6;
    ModelRenderer plate_7;
    ModelRenderer front_left_spike;
    ModelRenderer front_right_spike;
    ModelRenderer back_right_spike;
    ModelRenderer back_left_spike;
    ModelRenderer plate_8;
    ModelRenderer plate_9;
    ModelRenderer plate_10;
    ModelRenderer plate_11;
    ModelRenderer upper_jaw_2;

    public ModelStegosaur()
    {
        textureWidth = 256;
        textureHeight = 128;

        body_1 = new ModelRenderer(this, 149, 98);
        body_1.addBox(-6F, -0.5F, 0F, 12, 14, 15);
        body_1.setRotationPoint(0F, 3.3F, -4F);
        body_1.setTextureSize(256, 128);
        body_1.mirror = true;
        setRotation(body_1, 0.0523599F, 0F, 0F);
        leg_left_1 = new ModelRenderer(this, 10, 91);
        leg_left_1.addBox(0F, 0F, 0F, 4, 11, 8);
        leg_left_1.setRotationPoint(6F, 2F, 6F);
        leg_left_1.setTextureSize(256, 128);
        leg_left_1.mirror = true;
        setRotation(leg_left_1, -0.2094395F, 0F, 0F);
        leg_right_1 = new ModelRenderer(this, 10, 91);
        leg_right_1.addBox(-4F, 0F, 0F, 4, 11, 8);
        leg_right_1.setRotationPoint(-6F, 2F, 6F);
        leg_right_1.setTextureSize(256, 128);
        leg_right_1.mirror = true;
        setRotation(leg_right_1, -0.2094395F, 0F, 0F);
        neck_1 = new ModelRenderer(this, 67, 82);
        neck_1.addBox(-3F, -0.2F, 0F, 6, 7, 5);
        neck_1.setRotationPoint(0F, 8.3F, -16.2F);
        neck_1.setTextureSize(256, 128);
        neck_1.mirror = true;
        setRotation(neck_1, 0.3148822F, 0F, 0F);
        tail_1 = new ModelRenderer(this, 151, 72);
        tail_1.addBox(-5F, 0.6F, 0F, 10, 10, 8);
        tail_1.setRotationPoint(0F, 3F, 11F);
        tail_1.setTextureSize(256, 128);
        tail_1.mirror = true;
        setRotation(tail_1, -0.0523599F, 0F, 0F);
        tail_2 = new ModelRenderer(this, 210, 105);
        tail_2.addBox(-4F, 1.2F, 4F, 8, 7, 10);
        tail_2.setRotationPoint(0F, 3F, 11F);
        tail_2.setTextureSize(256, 128);
        tail_2.mirror = true;
        setRotation(tail_2, -0.181349F, 0F, 0F);
        tail_3 = new ModelRenderer(this, 211, 80);
        tail_3.addBox(-3F, 2.9F, 13F, 6, 5, 7);
        tail_3.setRotationPoint(0F, 3F, 11F);
        tail_3.setTextureSize(256, 128);
        tail_3.mirror = true;
        setRotation(tail_3, -0.1570796F, 0F, 0F);
        tail_4 = new ModelRenderer(this, 155, 51);
        tail_4.addBox(-2F, 5.4F, 19F, 4, 3, 7);
        tail_4.setRotationPoint(0F, 3F, 11F);
        tail_4.setTextureSize(256, 128);
        tail_4.mirror = true;
        setRotation(tail_4, -0.0804504F, 0F, 0F);
        leg_left_2 = new ModelRenderer(this, 22, 69);
        leg_left_2.addBox(0.5F, 8F, -7.5F, 3, 9, 4);
        leg_left_2.setRotationPoint(6F, 2F, 6F);
        leg_left_2.setTextureSize(256, 128);
        leg_left_2.mirror = true;
        setRotation(leg_left_2, 0.6108652F, 0F, 0F);
        leg_right_2 = new ModelRenderer(this, 22, 69);
        leg_right_2.addBox(-3.5F, 8F, -7.5F, 3, 9, 4);
        leg_right_2.setRotationPoint(-6F, 2F, 6F);
        leg_right_2.setTextureSize(256, 128);
        leg_right_2.mirror = false;
        setRotation(leg_right_2, 0.6108652F, 0F, 0F);
        leg_right_3 = new ModelRenderer(this, 3, 75);
        leg_right_3.addBox(-3.5F, 16F, 3F, 3, 6, 4);
        leg_right_3.setRotationPoint(-5.8F, 2F, 5.8F);
        leg_right_3.setTextureSize(256, 128);
        leg_right_3.mirror = false;
        setRotation(leg_right_3, 0F, 0F, 0F);
        leg_left_3 = new ModelRenderer(this, 3, 75);
        leg_left_3.addBox(0.5F, 16F, 3F, 3, 6, 4);
        leg_left_3.setRotationPoint(6F, 2F, 5.8F);
        leg_left_3.setTextureSize(256, 128);
        leg_left_3.mirror = true;
        setRotation(leg_left_3, 0F, 0F, 0F);
        foot_left = new ModelRenderer(this, 106, 107);
        foot_left.addBox(-5.5F, -1.5F, 0F, 11, 11, 9);
        foot_left.setRotationPoint(0F, 7F, -12F);
        foot_left.setTextureSize(256, 128);
        foot_left.mirror = true;
        setRotation(foot_left, 0.2443461F, 0F, 0F);
        arm_right_1 = new ModelRenderer(this, 2, 52);
        arm_right_1.addBox(-0.8F, 3.5F, 3.4F, 3, 7, 4);
        arm_right_1.setRotationPoint(-6F, 13F, -8F);
        arm_right_1.setTextureSize(256, 128);
        arm_right_1.mirror = false;
        setRotation(arm_right_1, -0.296706F, 0F, 0F);
        arm_left_1 = new ModelRenderer(this, 2, 52);
        arm_left_1.addBox(-2.2F, 3.5F, 3.4F, 3, 7, 4);
        arm_left_1.setRotationPoint(6F, 13F, -8F);
        arm_left_1.setTextureSize(256, 128);
        arm_left_1.mirror = true;
        setRotation(arm_left_1, -0.296706F, 0F, 0F);
        arm_left_2 = new ModelRenderer(this, 26, 50);
        arm_left_2.addBox(-2F, 0F, 0F, 3, 7, 4);
        arm_left_2.setRotationPoint(6F, 13F, -8F);
        arm_left_2.setTextureSize(256, 128);
        arm_left_2.mirror = true;
        setRotation(arm_left_2, 0.296706F, 0F, 0F);
        arm_right_2 = new ModelRenderer(this, 26, 50);
        arm_right_2.addBox(-1F, 0F, 0F, 3, 7, 4);
        arm_right_2.setRotationPoint(-6F, 13F, -8F);
        arm_right_2.setTextureSize(256, 128);
        arm_right_2.mirror = false;
        setRotation(arm_right_2, 0.296706F, 0F, 0F);
        head_back = new ModelRenderer(this, 42, 101);
        head_back.addBox(-2.5F, 1F, 0F, 5, 5, 6);
        head_back.setRotationPoint(0F, 7.5F, -20F);
        head_back.setTextureSize(256, 128);
        head_back.mirror = true;
        setRotation(head_back, -0.0622742F, 0F, 0F);
        upper_jaw_1 = new ModelRenderer(this, 51, 116);
        upper_jaw_1.addBox(-0.9F, -1F, -7.5F, 2, 3, 5);
        upper_jaw_1.setRotationPoint(0F, 9.8F, -22F);
        upper_jaw_1.setTextureSize(256, 128);
        upper_jaw_1.mirror = true;
        setRotation(upper_jaw_1, 0F, 0F, 0F);
        head_ = new ModelRenderer(this, 78, 116);
        head_.addBox(-2F, -4F, -4F, 4, 5, 5);
        head_.setRotationPoint(0F, 12.5F, -21F);
        head_.setTextureSize(256, 128);
        head_.mirror = true;
        setRotation(head_, 0F, 0F, 0F);
        tail_end = new ModelRenderer(this, 184, 51);
        tail_end.addBox(-1F, 4.7F, 26F, 2, 2, 6);
        tail_end.setRotationPoint(0F, 3F, 11F);
        tail_end.setTextureSize(256, 128);
        tail_end.mirror = true;
        setRotation(tail_end, -0.115357F, 0F, 0F);
        lower_jaw = new ModelRenderer(this, 20, 121);
        lower_jaw.addBox(-1F, 1.5F, -7F, 2, 2, 4);
        lower_jaw.setRotationPoint(0F, 9.6F, -22F);
        lower_jaw.setTextureSize(256, 128);
        lower_jaw.mirror = true;
        setRotation(lower_jaw, 0F, 0F, 0F);
        plate_1 = new ModelRenderer(this, 101, 2);
        plate_1.addBox(-5.5F, -13F, -1F, 1, 8, 8);
        plate_1.setRotationPoint(0F, 3F, -4F);
        plate_1.setTextureSize(256, 128);
        plate_1.mirror = true;
        setRotation(plate_1, -0.7853982F, 0F, 0F);
        plate_2 = new ModelRenderer(this, 76, 1);
        plate_2.addBox(4.5F, -7.5F, -3.5F, 1, 7, 7);
        plate_2.setRotationPoint(0F, 3F, -4F);
        plate_2.setTextureSize(256, 128);
        plate_2.mirror = true;
        setRotation(plate_2, -0.715585F, 0F, 0F);
        plate_3 = new ModelRenderer(this, 76, 1);
        plate_3.addBox(4.5F, -16.5F, 3F, 1, 7, 7);
        plate_3.setRotationPoint(0F, 3F, -4F);
        plate_3.setTextureSize(256, 128);
        plate_3.mirror = true;
        setRotation(plate_3, -0.8552113F, 0F, 0F);
        plate_4 = new ModelRenderer(this, 52, 1);
        plate_4.addBox(-5F, -10F, -1.5F, 1, 6, 6);
        plate_4.setRotationPoint(0F, 6.5F, -12.5F);
        plate_4.setTextureSize(256, 128);
        plate_4.mirror = true;
        setRotation(plate_4, -0.6632251F, 0F, 0F);
        plate_5 = new ModelRenderer(this, 23, 13);
        plate_5.addBox(1F, -3.5F, -0.5F, 1, 3, 3);
        plate_5.setRotationPoint(0F, 8.5F, -20F);
        plate_5.setTextureSize(256, 128);
        plate_5.mirror = true;
        setRotation(plate_5, -0.5850468F, 0F, 0F);
        plate_6 = new ModelRenderer(this, 52, 1);
        plate_6.addBox(-4F, -7.6F, -2F, 1, 6, 6);
        plate_6.setRotationPoint(0F, 3F, 11F);
        plate_6.setTextureSize(256, 128);
        plate_6.mirror = true;
        setRotation(plate_6, -0.9424778F, 0F, 0F);
        plate_7 = new ModelRenderer(this, 36, 4);
        plate_7.addBox(2.5F, -10F, 2F, 1, 5, 5);
        plate_7.setRotationPoint(0F, 3F, 11F);
        plate_7.setTextureSize(256, 128);
        plate_7.mirror = true;
        setRotation(plate_7, -1.047198F, 0F, 0F);
        front_left_spike = new ModelRenderer(this, 211, 59);
        front_left_spike.addBox(-18.5F, 12.5F, 7F, 1, 1, 7);
        front_left_spike.setRotationPoint(0F, 3F, 11.5F);
        front_left_spike.setTextureSize(256, 128);
        front_left_spike.mirror = true;
        setRotation(front_left_spike, 0.5410521F, 1.047198F, 0F);
        front_right_spike = new ModelRenderer(this, 211, 59);
        front_right_spike.addBox(17.5F, 12.5F, 7F, 1, 1, 7);
        front_right_spike.setRotationPoint(0F, 3F, 11.5F);
        front_right_spike.setTextureSize(256, 128);
        front_right_spike.mirror = true;
        setRotation(front_right_spike, 0.5410521F, -1.047198F, 0F);
        back_right_spike = new ModelRenderer(this, 211, 45);
        back_right_spike.addBox(21.9F, 13F, 10.7F, 1, 1, 6);
        back_right_spike.setRotationPoint(0F, 3.8F, 11F);
        back_right_spike.setTextureSize(256, 128);
        back_right_spike.mirror = true;
        setRotation(back_right_spike, 0.3739991F, -0.997331F, 0F);
        back_left_spike = new ModelRenderer(this, 211, 45);
        back_left_spike.addBox(-22.9F, 13.5F, 9.5F, 1, 1, 6);
        back_left_spike.setRotationPoint(0F, 2.9F, 11.5F);
        back_left_spike.setTextureSize(256, 128);
        back_left_spike.mirror = true;
        setRotation(back_left_spike, 0.3914524F, 1.017278F, 0F);
        plate_8 = new ModelRenderer(this, 36, 4);
        plate_8.addBox(4F, -7F, -3F, 1, 5, 5);
        plate_8.setRotationPoint(0F, 7F, -12F);
        plate_8.setTextureSize(256, 128);
        plate_8.mirror = true;
        setRotation(plate_8, -0.4363323F, 0F, 0F);
        plate_9 = new ModelRenderer(this, 23, 13);
        plate_9.addBox(-2.5F, -4F, -1F, 1, 3, 3);
        plate_9.setRotationPoint(0F, 8F, -16.5F);
        plate_9.setTextureSize(256, 128);
        plate_9.mirror = true;
        setRotation(plate_9, -0.5850468F, 0F, 0F);
        plate_10 = new ModelRenderer(this, 139, 2);
        plate_10.addBox(1F, -13.53333F, 8F, 1, 3, 3);
        plate_10.setRotationPoint(0F, 3F, 11F);
        plate_10.setTextureSize(256, 128);
        plate_10.mirror = true;
        setRotation(plate_10, -1.191368F, 0F, 0F);
        plate_11 = new ModelRenderer(this, 126, 2);
        plate_11.addBox(-3F, -11.66667F, 5F, 1, 4, 4);
        plate_11.setRotationPoint(0F, 3F, 11F);
        plate_11.setTextureSize(256, 128);
        plate_11.mirror = true;
        setRotation(plate_11, -1.191368F, 0F, 0F);
        upper_jaw_2 = new ModelRenderer(this, 51, 116);
        upper_jaw_2.addBox(-1.1F, -1F, -7.5F, 2, 3, 5);
        upper_jaw_2.setRotationPoint(0F, 9.8F, -22F);
        upper_jaw_2.setTextureSize(256, 128);
        upper_jaw_2.mirror = true;
        setRotation(upper_jaw_2, 0F, 0F, 0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);

        if (isChild)
        {
            float var8 = 2.0F;
            GL11.glPushMatrix();
            GL11.glTranslatef(0.0F, 5.0F * f5, 2.0F * f5);
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glScalef(1.0F / var8, 1.0F / var8, 1.0F / var8);
            GL11.glTranslatef(0.0F, 24.0F * f5, 0.0F);
            body_1.render(f5);
            leg_left_1.render(f5);
            leg_right_1.render(f5);
            neck_1.render(f5);
            tail_1.render(f5);
            tail_2.render(f5);
            tail_3.render(f5);
            tail_4.render(f5);
            leg_left_2.render(f5);
            leg_right_2.render(f5);
            leg_right_3.render(f5);
            leg_left_3.render(f5);
            foot_left.render(f5);
            arm_right_1.render(f5);
            arm_left_1.render(f5);
            arm_left_2.render(f5);
            arm_right_2.render(f5);
            head_back.render(f5);
            upper_jaw_1.render(f5);
            head_.render(f5);
            tail_end.render(f5);
            lower_jaw.render(f5);
            plate_1.render(f5);
            plate_2.render(f5);
            plate_3.render(f5);
            plate_4.render(f5);
            plate_5.render(f5);
            plate_6.render(f5);
            plate_7.render(f5);
            front_left_spike.render(f5);
            front_right_spike.render(f5);
            back_right_spike.render(f5);
            back_left_spike.render(f5);
            plate_8.render(f5);
            plate_9.render(f5);
            plate_10.render(f5);
            plate_11.render(f5);
            upper_jaw_2.render(f5);
            GL11.glPopMatrix();
        }
        else
        {
            body_1.render(f5);
            leg_left_1.render(f5);
            leg_right_1.render(f5);
            neck_1.render(f5);
            tail_1.render(f5);
            tail_2.render(f5);
            tail_3.render(f5);
            tail_4.render(f5);
            leg_left_2.render(f5);
            leg_right_2.render(f5);
            leg_right_3.render(f5);
            leg_left_3.render(f5);
            foot_left.render(f5);
            arm_right_1.render(f5);
            arm_left_1.render(f5);
            arm_left_2.render(f5);
            arm_right_2.render(f5);
            head_back.render(f5);
            upper_jaw_1.render(f5);
            head_.render(f5);
            tail_end.render(f5);
            lower_jaw.render(f5);
            plate_1.render(f5);
            plate_2.render(f5);
            plate_3.render(f5);
            plate_4.render(f5);
            plate_5.render(f5);
            plate_6.render(f5);
            plate_7.render(f5);
            front_left_spike.render(f5);
            front_right_spike.render(f5);
            back_right_spike.render(f5);
            back_left_spike.render(f5);
            plate_8.render(f5);
            plate_9.render(f5);
            plate_10.render(f5);
            plate_11.render(f5);
            upper_jaw_2.render(f5);
        }
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
    {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    }
}