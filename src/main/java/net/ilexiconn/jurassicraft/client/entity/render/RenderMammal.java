package net.ilexiconn.jurassicraft.client.entity.render;

import net.ilexiconn.jurassicraft.entity.Creature;
import net.ilexiconn.jurassicraft.entity.EntityJurassiCraftCreature;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.EntityLivingBase;
import org.lwjgl.opengl.GL11;

public abstract class RenderMammal extends RenderLiving
{
    private Creature mammal;
    private float resizableShadow;

    public RenderMammal(ModelBase model, Creature mammal, float shadow)
    {
        super(model, 1.0F);
        this.setMammal(mammal);
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

    private void setMammal(Creature mammal)
    {
        this.mammal = mammal;
    }

    public Creature getMammal()
    {
        return this.mammal;
    }

    @Override
    public void preRenderCallback(EntityLivingBase entity, float side)
    {
        float scale = (float) ((EntityJurassiCraftCreature) entity).getCreatureScale();
        this.shadowSize = scale * this.getShadow();
        GL11.glScalef(scale, scale, scale);
    }
}
