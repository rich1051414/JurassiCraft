package net.ilexiconn.jurassicraft.entity.render.mammals;

import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.client.model.entity.ModelMoeritherium;
import net.ilexiconn.jurassicraft.entity.Creature;
import net.ilexiconn.jurassicraft.entity.mammals.EntityMoeritherium;
import net.ilexiconn.jurassicraft.entity.render.RenderMammal;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderMoeritherium extends RenderMammal
{
    public RenderMoeritherium(Creature mammal)
    {
        super(new ModelMoeritherium(), mammal, 0.5F);
    }

    @Override
    public ResourceLocation getEntityTexture(Entity entity)
    {
        EntityMoeritherium mammal = (EntityMoeritherium) entity;
        if (mammal.isMale())
        {
            return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Moeritherium_Male_1.png");
        }
        else
        {
            return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Moeritherium_Female_1.png");
        }
    }
}
