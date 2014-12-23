package net.ilexiconn.jurassicraft.entity.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.EntityLivingBase;

import org.lwjgl.opengl.GL11;

import net.ilexiconn.jurassicraft.config.JsonCreatureDefinition;
import net.ilexiconn.jurassicraft.entity.EntityJurassiCraftCreature;

public abstract class RenderCephalopod extends RenderLiving
{

    private JsonCreatureDefinition cephalopod;
    private float resizableShadow;

    public RenderCephalopod(ModelBase model, JsonCreatureDefinition cephalopod, float shadow)
    {
        super(model, 1.0F);
        this.setCephalopod(cephalopod);
        this.setShadow(shadow);
    }

    private void setShadow(float shadow)
    {
        this.resizableShadow = shadow;
    }

    public float getShadow()
    {
        return this.resizableShadow;
    }

    public void setCephalopod(JsonCreatureDefinition cephalopod)
    {
        this.cephalopod = cephalopod;
    }

    public JsonCreatureDefinition getCephalopod()
    {
        return this.cephalopod;
    }

    @Override
    public void preRenderCallback(EntityLivingBase entity, float side)
    {
        float scale = (float) ((EntityJurassiCraftCreature) entity).getCreatureScale();
        this.shadowSize = scale * this.getShadow();
        GL11.glScalef(scale, scale, scale);
    }
}
