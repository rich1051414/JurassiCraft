package net.ilexiconn.jurassicraft.entity.render.dinosaurs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.client.model.entity.ModelHypsilophodon;
import net.ilexiconn.jurassicraft.entity.Creature;
import net.ilexiconn.jurassicraft.entity.dinosaurs.EntityHypsilophodon;
import net.ilexiconn.jurassicraft.entity.render.RenderDinosaur;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderHypsilophodon extends RenderDinosaur
{

    public RenderHypsilophodon(Creature dino)
    {
        super(new ModelHypsilophodon(), dino, 0.55F);
    }

    @Override
    public ResourceLocation getEntityTexture(Entity entity)
    {
        EntityHypsilophodon dino = (EntityHypsilophodon) entity;
        if (dino.isMale())
        {
            return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Hypsilophodon_Male_1.png");
        }
        else
        {
            return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Hypsilophodon_Female_1.png");
        }
    }
}
