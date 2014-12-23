package net.ilexiconn.jurassicraft.entity.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.EntityLivingBase;

import org.lwjgl.opengl.GL11;

import net.ilexiconn.jurassicraft.config.JsonCreatureDefinition;
import net.ilexiconn.jurassicraft.entity.EntityJurassiCraftCreature;

public abstract class RenderArthropod extends RenderLiving
{

    private JsonCreatureDefinition arthropod;
    private float resizableShadow;

    public RenderArthropod(ModelBase model, JsonCreatureDefinition arthropod, float shadow)
    {
        super(model, 1.0F);
        this.setArthropod(arthropod);
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

    public void setArthropod(JsonCreatureDefinition arthropod)
    {
        this.arthropod = arthropod;
    }

    public JsonCreatureDefinition getArthropod()
    {
        return this.arthropod;
    }

    @Override
    public void preRenderCallback(EntityLivingBase entity, float side)
    {
        float scale = (float) ((EntityJurassiCraftCreature) entity).getCreatureScale();
        this.shadowSize = scale * this.getShadow();
        GL11.glScalef(scale, scale, scale);
    }
}
