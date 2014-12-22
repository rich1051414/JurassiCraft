package net.ilexiconn.jurassicraft.entity.render.reptiles;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.client.model.entity.ModelTylosaurus;
import net.ilexiconn.jurassicraft.entity.Entities;
import net.ilexiconn.jurassicraft.entity.render.RenderSwimming;
import net.ilexiconn.jurassicraft.entity.reptiles.EntityTylosaurus;

@SideOnly(Side.CLIENT)
public class RenderTylosaurus extends RenderSwimming
{
    public RenderTylosaurus(Entities dino)
    {
        super(new ModelTylosaurus(), dino, 0.5F);
    }

    @Override
    public ResourceLocation getEntityTexture(Entity entity)
    {
    	EntityTylosaurus dino = (EntityTylosaurus) entity;
        if (dino.isMale())
        {
            switch(dino.getCreatureTexture()) {
            	case 0:
            		return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Tylosaurus_Male_1.png");
            	case 1:
            		return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Tylosaurus_Male_2.png");
            	default:
            		return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Tylosaurus_Male_1.png");
            }
        } 
        else 
        {
        	switch(dino.getCreatureTexture()) {
            	case 0:
            		return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Tylosaurus_Female_1.png");
            	case 1:
            		return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Tylosaurus_Female_2.png");
            	default:
            		return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Tylosaurus_Female_1.png");
            }
        }
    }
}
