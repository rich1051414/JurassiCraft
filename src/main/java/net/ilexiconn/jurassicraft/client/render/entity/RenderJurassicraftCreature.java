package net.ilexiconn.jurassicraft.client.render.entity;

import com.google.common.collect.Maps;
import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.common.data.CreatureContainer;
import net.ilexiconn.jurassicraft.common.entity.EntityJurassiCraftCreature;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import java.util.Map;

public class RenderJurassicraftCreature extends RenderLiving
{
    private Map<String, ResourceLocation> textureCache = Maps.newHashMap();

    private CreatureContainer creature;
    private float resizableShadow;
    private String creatureCat;
    private String creatureName;

    public RenderJurassicraftCreature(CreatureContainer creature, String creatureName, String creatureCat, float shadow) throws ClassNotFoundException, IllegalAccessException, InstantiationException
    {
        super((ModelBase) Class.forName("net.ilexiconn.jurassicraft.client.model.entity.Model" + creatureName).newInstance(), shadow);
        this.setCreature(creature);
        this.setShadow(shadow);
        this.creatureCat = creatureCat;
        this.creatureName = creatureName;
    }

    public float getShadow()
    {
        return this.resizableShadow;
    }

    private void setShadow(float shadow)
    {
        this.resizableShadow = shadow;
    }

    public CreatureContainer getCreature()
    {
        return this.creature;
    }

    private void setCreature(CreatureContainer creature)
    {
        this.creature = creature;
    }

    public void preRenderCallback(EntityLivingBase entity, float side)
    {
        float scale = ((EntityJurassiCraftCreature) entity).getCreatureScale();
        this.shadowSize = scale * this.getShadow();
        GL11.glScalef(scale, scale, scale);
    }

    public ResourceLocation getEntityTexture(Entity entity)
    {
        EntityJurassiCraftCreature dino = (EntityJurassiCraftCreature) entity;
        if (dino.isMale())
        {
            return getTexture(JurassiCraft.getModId() + "textures/entity/" + creatureCat.toLowerCase() + "/" + creatureName.toLowerCase() + "/" + creatureName.toLowerCase() + "Male1.png");
        }
        else
        {
            return getTexture(JurassiCraft.getModId() + "textures/entity/" + creatureCat.toLowerCase() + "/" + creatureName.toLowerCase() + "/" + creatureName.toLowerCase() + "Female1.png");
        }
    }

    public ResourceLocation getTexture(String texture)
    {
        if (textureCache.containsKey(texture)) return textureCache.get(texture);
        else return textureCache.put(texture, new ResourceLocation(texture));
    }
}