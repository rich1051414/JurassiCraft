package net.ilexiconn.jurassicraft.entity.render.dinosaurs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.client.model.entity.ModelStegosaur;
import net.ilexiconn.jurassicraft.entity.Creature;
import net.ilexiconn.jurassicraft.entity.dinosaurs.EntityStegosaur;
import net.ilexiconn.jurassicraft.entity.render.RenderDinosaur;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderStegosaur extends RenderDinosaur
{
    public RenderStegosaur(Creature dino)
    {
        super(new ModelStegosaur(), dino, 1.0F);
    }

    @Override
    public ResourceLocation getEntityTexture(Entity entity)
    {
        EntityStegosaur dino = (EntityStegosaur) entity;
        if (dino.isMale())
        {
            return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Stegosaurus_Male_1.png");
        }
        else
        {
            return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Stegosaurus_Female_1.png");
        }
    }
}
