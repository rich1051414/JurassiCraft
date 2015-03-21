package net.ilexiconn.jurassicraft.client.render.entity.mammals;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.client.render.entity.RenderMammal;
import net.ilexiconn.jurassicraft.client.model.entity.ModelParaceratherium;
import net.ilexiconn.jurassicraft.entity.Creature;
import net.ilexiconn.jurassicraft.entity.mammals.EntityParaceratherium;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderParaceratherium extends RenderMammal
{
    public RenderParaceratherium(Creature mammal)
    {
        super(new ModelParaceratherium(), mammal, 1.6F);
    }

    @Override
    public ResourceLocation getEntityTexture(Entity entity)
    {
        EntityParaceratherium mammal = (EntityParaceratherium) entity;
        if (mammal.isMale())
        {
            return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Paraceratherium_Male_1.png");
        }
        else
        {
            return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Paraceratherium_Female_1.png");
        }
    }
}
