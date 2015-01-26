package net.ilexiconn.jurassicraft.entity.render.reptiles;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.client.model.entity.ModelDeinosuchus;
import net.ilexiconn.jurassicraft.entity.Creature;
import net.ilexiconn.jurassicraft.entity.render.RenderReptile;
import net.ilexiconn.jurassicraft.entity.reptiles.EntityDeinosuchus;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderDeinosuchus extends RenderReptile
{
    public RenderDeinosuchus(Creature reptile)
    {
        super(new ModelDeinosuchus(), reptile, 0.5F);
    }

    @Override
    public ResourceLocation getEntityTexture(Entity entity)
    {
        EntityDeinosuchus reptile = (EntityDeinosuchus) entity;
        if (reptile.isMale())
        {
            return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Deinosuchus_Male_1.png");
        }
        else
        {
            return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Deinosuchus_Female_1.png");
        }
    }
}
