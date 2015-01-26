package net.ilexiconn.jurassicraft.client.entity.render.dinosaurs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.client.entity.render.RenderDinosaur;
import net.ilexiconn.jurassicraft.client.model.entity.ModelLeaellynasaura;
import net.ilexiconn.jurassicraft.entity.Creature;
import net.ilexiconn.jurassicraft.entity.dinosaurs.EntityLeaellynasaura;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderLeaellynasaura extends RenderDinosaur
{
    public RenderLeaellynasaura(Creature dinosaur)
    {
        super(new ModelLeaellynasaura(), dinosaur, 0.45F);
    }

    @Override
    public ResourceLocation getEntityTexture(Entity entity)
    {
        EntityLeaellynasaura dino = (EntityLeaellynasaura) entity;
        if (dino.isMale())
        {
            return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Leaellynasaura_Male_1.png");
        }
        else
        {
            return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Leaellynasaura_Female_1.png");
        }
    }
}
