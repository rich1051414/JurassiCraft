package net.ilexiconn.jurassicraft.entity.render.dinosaurs;

import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.client.model.entity.ModelLeaellynasaur;
import net.ilexiconn.jurassicraft.entity.Creature;
import net.ilexiconn.jurassicraft.entity.dinosaurs.EntityLeaellynasaur;
import net.ilexiconn.jurassicraft.entity.render.RenderDinosaur;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderLeaellynasaur extends RenderDinosaur
{
    public RenderLeaellynasaur(Creature dinosaur)
    {
        super(new ModelLeaellynasaur(), dinosaur, 0.45F);
    }

    @Override
    public ResourceLocation getEntityTexture(Entity entity)
    {
        EntityLeaellynasaur dino = (EntityLeaellynasaur) entity;
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
