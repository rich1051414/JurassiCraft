package net.ilexiconn.jurassicraft.entity.render.dinosaurs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.client.model.entity.ModelBrachiosaur;
import net.ilexiconn.jurassicraft.entity.Creature;
import net.ilexiconn.jurassicraft.entity.dinosaurs.EntityBrachiosaur;
import net.ilexiconn.jurassicraft.entity.render.RenderDinosaur;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderBrachiosaur extends RenderDinosaur
{
    public RenderBrachiosaur(Creature dino)
    {
        super(new ModelBrachiosaur(), dino, 1.6F);
    }

    @Override
    public ResourceLocation getEntityTexture(Entity entity)
    {
        EntityBrachiosaur dino = (EntityBrachiosaur) entity;
        if (dino.isMale())
        {
            return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Brachiosaurus_Male_1.png");
        }
        else
        {
            return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Brachiosaurus_Female_1.png");
        }
    }
}
