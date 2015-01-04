package net.ilexiconn.jurassicraft.client.model.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelAmmonite extends ModelBase
{
    ModelRenderer Shellbase;
    ModelRenderer Shellside1;
    ModelRenderer Shellside2;
    ModelRenderer Headpiece;
    ModelRenderer Tentacle1;
    ModelRenderer Tentacle2;
    ModelRenderer Tentacle3;
    ModelRenderer Tentacle4;

    public ModelAmmonite()
    {
        super();
        this.textureWidth = 64;
        this.textureHeight = 32;
        (this.Shellbase = new ModelRenderer((ModelBase) this, 0, 4)).addBox(0.0f, 0.0f, 0.0f, 3, 5, 5);
        this.Shellbase.setRotationPoint(-1.5f, 18.0f, -2.0f);
        this.Shellbase.setTextureSize(64, 32);
        this.Shellbase.mirror = true;
        this.setRotation(this.Shellbase, 0.0f, 0.0f, 0.0f);
        (this.Shellside1 = new ModelRenderer((ModelBase) this, 25, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 3, 3);
        this.Shellside1.setRotationPoint(-2.0f, 19.0f, -1.0f);
        this.Shellside1.setTextureSize(64, 32);
        this.Shellside1.mirror = true;
        this.setRotation(this.Shellside1, 0.0f, 0.0f, 0.0f);
        (this.Shellside2 = new ModelRenderer((ModelBase) this, 25, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 3, 3);
        this.Shellside2.setRotationPoint(1.0f, 19.0f, -1.0f);
        this.Shellside2.setTextureSize(64, 32);
        this.Shellside2.mirror = true;
        this.setRotation(this.Shellside2, 0.0f, 0.0f, 0.0f);
        (this.Headpiece = new ModelRenderer((ModelBase) this, 9, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 2, 1);
        this.Headpiece.setRotationPoint(-1.0f, 20.5f, -2.5f);
        this.Headpiece.setTextureSize(64, 32);
        this.Headpiece.mirror = true;
        this.setRotation(this.Headpiece, 0.0f, 0.0f, 0.0f);
        (this.Tentacle1 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 2);
        this.Tentacle1.setRotationPoint(0.0f, 20.5f, -4.0f);
        this.Tentacle1.setTextureSize(64, 32);
        this.Tentacle1.mirror = true;
        this.setRotation(this.Tentacle1, 0.0f, 0.0f, 0.0f);
        (this.Tentacle2 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 2);
        this.Tentacle2.setRotationPoint(0.0f, 21.5f, -4.0f);
        this.Tentacle2.setTextureSize(64, 32);
        this.Tentacle2.mirror = true;
        this.setRotation(this.Tentacle2, 0.0f, 0.0f, 0.0f);
        (this.Tentacle3 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 2);
        this.Tentacle3.setRotationPoint(-1.0f, 21.5f, -4.0f);
        this.Tentacle3.setTextureSize(64, 32);
        this.Tentacle3.mirror = true;
        this.setRotation(this.Tentacle3, 0.0f, 0.0f, 0.0f);
        (this.Tentacle4 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 2);
        this.Tentacle4.setRotationPoint(-1.0f, 20.5f, -4.0f);
        this.Tentacle4.setTextureSize(64, 32);
        this.Tentacle4.mirror = true;
        this.setRotation(this.Tentacle4, 0.0f, 0.0f, 0.0f);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.Shellbase.render(f5);
        this.Shellside1.render(f5);
        this.Shellside2.render(f5);
        this.Headpiece.render(f5);
        this.Tentacle1.render(f5);
        this.Tentacle2.render(f5);
        this.Tentacle3.render(f5);
        this.Tentacle4.render(f5);
    }

    private void setRotation(final ModelRenderer model, final float x, final float y, final float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(final float f, final float f1, final float f2, final float f3, final float f4, final float f5, final Entity entity)
    {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    }
}
