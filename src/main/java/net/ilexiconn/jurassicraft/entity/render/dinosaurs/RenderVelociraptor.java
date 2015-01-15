package net.ilexiconn.jurassicraft.entity.render.dinosaurs;

import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.client.model.entity.ModelVelociraptor;
import net.ilexiconn.jurassicraft.entity.Creature;
import net.ilexiconn.jurassicraft.entity.dinosaurs.EntityVelociraptor;
import net.ilexiconn.jurassicraft.entity.render.RenderDinosaur;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderVelociraptor extends RenderDinosaur
{
    public RenderVelociraptor(Creature dinosaur)
    {
        super(new ModelVelociraptor(), dinosaur, 0.65F);
    }

    @Override
    public ResourceLocation getEntityTexture(Entity entity)
    {
        EntityVelociraptor dino = (EntityVelociraptor) entity;
        if (dino.isMale())
        {
            return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Velociraptor_Male_1.png");
        }
        else
        {
            return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Velociraptor_Female_1.png");
        }
    }
}
