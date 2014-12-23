package net.ilexiconn.jurassicraft.entity.render.dinosaurs;

import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.client.model.entity.ModelSanta;
import net.ilexiconn.jurassicraft.entity.Creature;
import net.ilexiconn.jurassicraft.entity.render.RenderDinosaur;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderSanta extends RenderDinosaur
{
    public RenderSanta(Creature dino)
    {
        super(new ModelSanta(), dino, 0.5F);
    }

    @Override
    public ResourceLocation getEntityTexture(Entity entity)
    {
            return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Santa.png");
    }
}
