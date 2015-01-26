package net.ilexiconn.jurassicraft.entity.render.fish;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.client.model.entity.ModelCoelacanth;
import net.ilexiconn.jurassicraft.entity.Creature;
import net.ilexiconn.jurassicraft.entity.render.RenderSwimming;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderCoelacanth extends RenderSwimming
{

    public RenderCoelacanth(Creature fish)
    {
        super(new ModelCoelacanth(), fish, 0.5F);
    }

    @Override
    public ResourceLocation getEntityTexture(Entity var1)
    {
        return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Coelacanth_Male_1.png");
    }

}
