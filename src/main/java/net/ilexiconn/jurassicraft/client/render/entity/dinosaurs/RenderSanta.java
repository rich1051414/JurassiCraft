package net.ilexiconn.jurassicraft.client.render.entity.dinosaurs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.client.render.entity.RenderDinosaur;
import net.ilexiconn.jurassicraft.client.model.entity.ModelSanta;
import net.ilexiconn.jurassicraft.entity.Creature;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderSanta extends RenderDinosaur
{
    public RenderSanta(Creature dinosaur)
    {
        super(new ModelSanta(), dinosaur, 0.5F);
    }
    
    @Override
    public ResourceLocation getEntityTexture(Entity entity)
    {
        return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Santa.png");
    }
}
