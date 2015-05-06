package net.ilexiconn.jurassicraft.client.model.extension;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.ilexiconn.llibrary.client.render.IModelExtension;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

@SideOnly(Side.CLIENT)
public class ExtensionHat implements IModelExtension
{
    public ModelRenderer base;
    public ModelRenderer peak;

    public void init(ModelBase model)
    {
        ModelBiped biped = (ModelBiped) model;

        peak = new ModelRenderer(model, 0, 45);
        peak.setRotationPoint(0.0F, 3.7F, 0.0F);
        peak.addBox(-6.5F, 0.0F, -6.5F, 13, 1, 13, 0.0F);
        base = new ModelRenderer(model, 0, 27);
        base.setRotationPoint(0.0F, -9.8F, 0.0F);
        base.addBox(-4.5F, 0.0F, -4.5F, 9, 4, 9, 0.0F);
        base.addChild(peak);
        biped.bipedHead.addChild(base);
    }

    public void setRotationAngles(ModelBase model, float limbSwing, float limbSwingAmount, float rotationFloat, float rotationYaw, float rotationPitch, float partialTicks, Entity entity)
    {

    }

    public void preRender(Entity entity, ModelBase model, float partialTicks)
    {

    }

    public void postRender(Entity entity, ModelBase model, float partialTicks)
    {

    }
}
