package net.ilexiconn.jurassicraft.client.entity.render.cephalopods;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.client.entity.render.RenderCephalopod;
import net.ilexiconn.jurassicraft.client.model.entity.ModelAmmonite;
import net.ilexiconn.jurassicraft.entity.Creature;
import net.ilexiconn.jurassicraft.entity.cephalopods.EntityAmmonite;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderAmmonite extends RenderCephalopod
{
    public RenderAmmonite(Creature cephalopod)
    {
        super(new ModelAmmonite(), cephalopod, 0.5F);
    }

    @Override
    public ResourceLocation getEntityTexture(Entity entity)
    {
        EntityAmmonite cephalopod = (EntityAmmonite) entity;
        if (cephalopod.isMale())
        {
            return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Ammonite.png");
        }
        else
        {
            return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Ammonite.png");
        }
    }
}
