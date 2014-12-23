package net.ilexiconn.jurassicraft.entity.render.reptiles;

import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.client.model.entity.ModelCearadactylus;
import net.ilexiconn.jurassicraft.entity.Creature;
import net.ilexiconn.jurassicraft.entity.render.RenderReptile;
import net.ilexiconn.jurassicraft.entity.reptiles.EntityCearadactylus;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderCearadactylus extends RenderReptile
{
    public RenderCearadactylus(Creature reptile)
    {
        super(new ModelCearadactylus(), reptile, 0.5F);
    }

    @Override
    public ResourceLocation getEntityTexture(Entity entity)
    {
        EntityCearadactylus reptile = (EntityCearadactylus) entity;
        if (reptile.isMale())
        {
            return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Cearadactylus_Male_1.png");
        } 
        else 
        {
            return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Cearadactylus_Female_1.png");
        }
    }
}
