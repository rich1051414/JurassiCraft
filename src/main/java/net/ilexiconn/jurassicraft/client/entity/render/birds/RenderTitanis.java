package net.ilexiconn.jurassicraft.client.entity.render.birds;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.client.entity.render.RenderBird;
import net.ilexiconn.jurassicraft.client.model.entity.ModelTitanis;
import net.ilexiconn.jurassicraft.entity.Creature;
import net.ilexiconn.jurassicraft.entity.birds.EntityTitanis;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderTitanis extends RenderBird
{
    public RenderTitanis(Creature bird)
    {
        super(new ModelTitanis(), bird, 0.5F);
    }

    @Override
    public ResourceLocation getEntityTexture(Entity entity)
    {
        EntityTitanis dino = (EntityTitanis) entity;
        if (dino.isMale())
        {
            return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Titanis_Male_1.png");
        }
        else
        {
            return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Titanis_Female_1.png");
        }
    }
}
