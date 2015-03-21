package net.ilexiconn.jurassicraft.client.render.entity.mammals;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.client.render.entity.RenderMammal;
import net.ilexiconn.jurassicraft.client.model.entity.ModelLeptictidium;
import net.ilexiconn.jurassicraft.entity.Creature;
import net.ilexiconn.jurassicraft.entity.mammals.EntityLeptictidium;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderLeptictidium extends RenderMammal
{
    public RenderLeptictidium(Creature mammal)
    {
        super(new ModelLeptictidium(), mammal, 0.5F);
    }

    @Override
    public ResourceLocation getEntityTexture(Entity entity)
    {
        EntityLeptictidium mammal = (EntityLeptictidium) entity;
        if (mammal.isMale())
        {
            return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Leptictidium_Male_1.png");
        }
        else
        {
            return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Leptictidium_Female_1.png");
        }
    }
}
