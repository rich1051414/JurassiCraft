package net.ilexiconn.jurassicraft.entity.render.dinosaurs;

import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.client.model.entity.ModelStegosaurus;
import net.ilexiconn.jurassicraft.entity.Creature;
import net.ilexiconn.jurassicraft.entity.dinosaurs.EntityStegosaurus;
import net.ilexiconn.jurassicraft.entity.render.RenderDinosaur;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderStegosaurus extends RenderDinosaur
{
    public RenderStegosaurus(Creature dinosaur)
    {
        super(new ModelStegosaurus(), dinosaur, 1.0F);
    }

    @Override
    public ResourceLocation getEntityTexture(Entity entity)
    {
        EntityStegosaurus dino = (EntityStegosaurus) entity;
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
