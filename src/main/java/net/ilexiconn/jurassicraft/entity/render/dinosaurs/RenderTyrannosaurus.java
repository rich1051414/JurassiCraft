package net.ilexiconn.jurassicraft.entity.render.dinosaurs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.client.model.entity.ModelTyrannosaurus;
import net.ilexiconn.jurassicraft.entity.Entities;
import net.ilexiconn.jurassicraft.entity.dinosaurs.EntityTyrannosaurus;
import net.ilexiconn.jurassicraft.entity.render.RenderDinosaur;

@SideOnly(Side.CLIENT)
public class RenderTyrannosaurus extends RenderDinosaur
{
    public RenderTyrannosaurus(Entities dino)
    {
        super(new ModelTyrannosaurus(), dino, 0.8F);
    }

    @Override
    public ResourceLocation getEntityTexture(Entity entity)
    {
        EntityTyrannosaurus dino = (EntityTyrannosaurus) entity;
        if (dino.isMale())
        {
            return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Tyrannosaurus_Male_1.png");
        } 
        else 
        {
            return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Tyrannosaurus_Female_1.png");
        }
    }
}
