package net.ilexiconn.jurassicraft.entity.render.dinosaurs;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.client.model.entity.ModelVelociraptor;
import net.ilexiconn.jurassicraft.entity.Entities;
import net.ilexiconn.jurassicraft.entity.dinosaurs.EntityVelociraptor;
import net.ilexiconn.jurassicraft.entity.render.RenderDinosaur;

public class RenderVelociraptor extends RenderDinosaur
{
    public RenderVelociraptor(Entities dino)
    {
        super(new ModelVelociraptor(), dino, 0.65F);
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
