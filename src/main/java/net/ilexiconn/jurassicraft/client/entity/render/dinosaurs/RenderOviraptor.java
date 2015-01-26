package net.ilexiconn.jurassicraft.client.entity.render.dinosaurs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.client.entity.render.RenderDinosaur;
import net.ilexiconn.jurassicraft.client.model.entity.ModelOviraptor;
import net.ilexiconn.jurassicraft.entity.Creature;
import net.ilexiconn.jurassicraft.entity.dinosaurs.EntityOviraptor;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderOviraptor extends RenderDinosaur
{
    public RenderOviraptor(Creature dinosaur)
    {
        super(new ModelOviraptor(), dinosaur, 0.6F);
    }

    @Override
    public ResourceLocation getEntityTexture(Entity entity)
    {
        EntityOviraptor dino = (EntityOviraptor) entity;
        if (dino.isMale())
        {
            return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Oviraptor_Male_1.png");
        }
        else
        {
            return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Oviraptor_Female_1.png");
        }
    }
}
