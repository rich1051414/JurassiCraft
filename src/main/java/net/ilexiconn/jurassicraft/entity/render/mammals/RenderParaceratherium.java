package net.ilexiconn.jurassicraft.entity.render.mammals;

import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.client.model.entity.ModelParaceratherium;
import net.ilexiconn.jurassicraft.entity.Creature;
import net.ilexiconn.jurassicraft.entity.mammals.EntityParaceratherium;
import net.ilexiconn.jurassicraft.entity.render.RenderMammal;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

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
