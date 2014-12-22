package net.ilexiconn.jurassicraft.entity.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.EntityLivingBase;
import org.lwjgl.opengl.GL11;
import net.ilexiconn.jurassicraft.entity.Entities;
import net.ilexiconn.jurassicraft.entity.EntityJurassiCraftCreature;

public abstract class RenderFish extends RenderLiving
{

    private Entities fish;
    private float resizableShadow;

    public RenderFish(ModelBase model, Entities fish, float shadow)
    {
        super(model, 1.0F);
        this.setFish(fish);
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

    public void setFish(Entities fish)
    {
        this.fish = fish;
    }

    public Entities getFish()
    {
        return this.fish;
    }

    @Override
    public void preRenderCallback(EntityLivingBase entity, float side)
    {
        float scale = (float) ((EntityJurassiCraftCreature) entity).getCreatureScale();
        this.shadowSize = scale * this.getShadow();
        GL11.glScalef(scale, scale, scale);
    }
}
