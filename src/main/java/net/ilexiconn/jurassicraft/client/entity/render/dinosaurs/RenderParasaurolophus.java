package net.ilexiconn.jurassicraft.client.entity.render.dinosaurs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.client.entity.render.RenderDinosaur;
import net.ilexiconn.jurassicraft.client.model.entity.ModelParasaurolophus;
import net.ilexiconn.jurassicraft.entity.Creature;
import net.ilexiconn.jurassicraft.entity.dinosaurs.EntityParasaurolophus;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderParasaurolophus extends RenderDinosaur
{
    public RenderParasaurolophus(Creature dinosaur)
    {
        super(new ModelParasaurolophus(), dinosaur, 0.8F);
    }

    @Override
    public ResourceLocation getEntityTexture(Entity entity)
    {
        EntityParasaurolophus dino = (EntityParasaurolophus) entity;
        if (dino.isMale())
        {
            return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Parasaurolophus_Male_1.png");
        }
        else
        {
            return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Parasaurolophus_Female_1.png");
        }
    }
}
