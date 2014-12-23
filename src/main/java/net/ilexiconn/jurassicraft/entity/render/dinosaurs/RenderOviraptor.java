package net.ilexiconn.jurassicraft.entity.render.dinosaurs;

import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.client.model.entity.ModelOviraptor;
import net.ilexiconn.jurassicraft.entity.Creature;
import net.ilexiconn.jurassicraft.entity.dinosaurs.EntityOviraptor;
import net.ilexiconn.jurassicraft.entity.render.RenderDinosaur;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderOviraptor extends RenderDinosaur
{
    public RenderOviraptor(Creature dino)
    {
        super(new ModelOviraptor(), dino, 0.6F);
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
