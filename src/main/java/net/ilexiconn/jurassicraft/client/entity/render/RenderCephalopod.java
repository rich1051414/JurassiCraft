package net.ilexiconn.jurassicraft.client.entity.render;

import net.ilexiconn.jurassicraft.entity.Creature;
import net.ilexiconn.jurassicraft.entity.EntityJurassiCraftCreature;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.EntityLivingBase;

import org.lwjgl.opengl.GL11;

public abstract class RenderCephalopod extends RenderLiving
{

    private Creature cephalopod;
    private float resizableShadow;

    public RenderCephalopod(ModelBase model, Creature cephalopod, float shadow)
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

    private void setCephalopod(Creature cephalopod)
    {
        this.cephalopod = cephalopod;
    }

    public Creature getCephalopod()
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
