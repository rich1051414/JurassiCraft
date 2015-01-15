package net.ilexiconn.jurassicraft.entity.render;

import net.ilexiconn.jurassicraft.entity.Creature;
import net.ilexiconn.jurassicraft.entity.EntityJurassiCraftCreature;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.EntityLivingBase;

import org.lwjgl.opengl.GL11;

public abstract class RenderArthropod extends RenderLiving
{

    private Creature arthropod;
    private float resizableShadow;

    public RenderArthropod(ModelBase model, Creature arthropod, float shadow)
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

    private void setArthropod(Creature arthropod)
    {
        this.arthropod = arthropod;
    }

    public Creature getArthropod()
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
