package net.ilexiconn.jurassicraft.entity.render.cephalopods;

import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.client.model.entity.ModelBrachiopod;
import net.ilexiconn.jurassicraft.entity.Creature;
import net.ilexiconn.jurassicraft.entity.cephalopods.EntityBrachiopod;
import net.ilexiconn.jurassicraft.entity.render.RenderCephalopod;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderBrachiopod extends RenderCephalopod
{
    public RenderBrachiopod(Creature cephalopod)
    {
        super(new ModelBrachiopod(), cephalopod, 0.5F);
    }

    @Override
    public ResourceLocation getEntityTexture(Entity entity)
    {
        EntityBrachiopod cephalopod = (EntityBrachiopod) entity;
        if (cephalopod.isMale())
        {
            return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/brachiopod.png");
        }
        else
        {
            return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/brachiopod.png");
        }
    }
}
