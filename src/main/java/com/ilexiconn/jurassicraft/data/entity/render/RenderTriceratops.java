package com.ilexiconn.jurassicraft.data.entity.render;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import com.ilexiconn.jurassicraft.JurassiCraft;
import com.ilexiconn.jurassicraft.data.entity.Dinosaur;
import com.ilexiconn.jurassicraft.data.entity.RenderDinosaur;
import com.ilexiconn.jurassicraft.data.entity.model.ModelTriceratops;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderTriceratops extends RenderDinosaur
{
    public RenderTriceratops(Dinosaur dino)
    {
        super(new ModelTriceratops(), dino, 1f);
    }

    public ResourceLocation getEntityTexture(Entity var1)
    {
        return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/triceratops1.png");
    }
}
