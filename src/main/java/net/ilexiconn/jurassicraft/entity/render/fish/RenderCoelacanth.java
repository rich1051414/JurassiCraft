package net.ilexiconn.jurassicraft.entity.render.fish;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.client.model.entity.ModelCoelacanth;
import net.ilexiconn.jurassicraft.entity.Entities;
import net.ilexiconn.jurassicraft.entity.render.RenderSwimming;

@SideOnly(Side.CLIENT)
public class RenderCoelacanth extends RenderSwimming
{

    public RenderCoelacanth(Entities dino)
    {
        super(new ModelCoelacanth(), dino, 0.5F);
    }

    @Override
    public ResourceLocation getEntityTexture(Entity var1)
    {
        return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Coelacanth.png");
    }

}
