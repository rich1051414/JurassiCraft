package net.ilexiconn.jurassicraft.entity.render.arthropods;

import net.ilexiconn.jurassicraft.client.model.entity.ModelMeganeura;
import net.ilexiconn.jurassicraft.entity.Creature;
import net.ilexiconn.jurassicraft.entity.arthropods.EntityMeganeura;
import net.ilexiconn.jurassicraft.entity.render.RenderArthropod;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderMeganeura extends RenderArthropod
{
    public RenderMeganeura(Creature arthropod)
    {
        super(new ModelMeganeura(), arthropod, 0.25F);
    }

    @Override
    public ResourceLocation getEntityTexture(Entity var1)
    {
        EntityMeganeura dino = (EntityMeganeura) var1;

        int textureIndex = dino.getCreatureTexture() + 1;

        if (textureIndex > 1)
        {
            textureIndex = 1;
        }

        if (dino.getCreatureGender())
        {
            return new ResourceLocation("jurassicraft", "textures/entity/Meganeura_Male_" + textureIndex + ".png");
        }
        else
        {
            return new ResourceLocation("jurassicraft", "textures/entity/Meganeura_Female_" + textureIndex + ".png");
        }
    }
}
