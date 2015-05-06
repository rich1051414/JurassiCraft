package net.ilexiconn.jurassicraft.client.model.entity.player;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelSantaHat extends ModelBase
{
    public ModelRenderer shape1;
    public ModelRenderer shape3;
    public ModelRenderer shape2;
    public ModelRenderer shape5;
    public ModelRenderer shape4;

    public ModelSantaHat()
    {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.shape3 = new ModelRenderer(this, 33, 4);
        this.shape3.setRotationPoint(-2.4F, 13.0F, -0.5F);
        this.shape3.addBox(0.0F, 0.0F, 0.0F, 5, 3, 5);
        this.setRotateAngle(shape3, -0.31869712141416456F, 0.0F, 0.0F);
        this.shape4 = new ModelRenderer(this, 44, 20);
        this.shape4.setRotationPoint(-2.3F, 8.0F, 7.3F);
        this.shape4.addBox(0.0F, 0.0F, 0.0F, 5, 5, 5);
        this.setRotateAngle(shape4, -1.2292353921796064F, 0.0F, 0.0F);
        this.shape2 = new ModelRenderer(this, 0, 0);
        this.shape2.setRotationPoint(-3.9F, 15.3F, -2.8F);
        this.shape2.addBox(0.0F, 0.0F, 0.0F, 8, 5, 8);
        this.setRotateAngle(shape2, -0.22759093446006054F, 0.0F, 0.0F);
        this.shape5 = new ModelRenderer(this, 52, 0);
        this.shape5.setRotationPoint(-1.3F, 10.3F, 3.5F);
        this.shape5.addBox(0.0F, 0.0F, 0.0F, 3, 5, 3);
        this.setRotateAngle(shape5, -0.6829473363053812F, 0.0F, 0.0F);
        this.shape1 = new ModelRenderer(this, 0, 15);
        this.shape1.setRotationPoint(-5.5F, 19.9F, -5.2F);
        this.shape1.addBox(0.0F, 0.0F, 0.0F, 11, 4, 11);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        this.shape3.render(f5);
        this.shape4.render(f5);
        this.shape2.render(f5);
        this.shape5.render(f5);
        this.shape1.render(f5);
    }

    public void renderAll()
    {
        this.shape3.render(0.0625f);
        this.shape4.render(0.0625f);
        this.shape2.render(0.0625f);
        this.shape5.render(0.0625f);
        this.shape1.render(0.0625f);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
    {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
