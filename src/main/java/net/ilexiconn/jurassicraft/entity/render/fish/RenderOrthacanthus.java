package net.ilexiconn.jurassicraft.entity.render.fish;

import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.client.model.entity.ModelOrthacanthus;
import net.ilexiconn.jurassicraft.entity.Creature;
import net.ilexiconn.jurassicraft.entity.fish.EntityOrthacanthus;
import net.ilexiconn.jurassicraft.entity.render.RenderSwimming;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderOrthacanthus extends RenderSwimming 
{

	public RenderOrthacanthus(Creature fish) 
	{
		super(new ModelOrthacanthus(), fish, 0.5F);
	}

	@Override
	public ResourceLocation getEntityTexture(Entity entity) 
	{
		EntityOrthacanthus fish = (EntityOrthacanthus) entity;
		if (fish.isMale()) 
		{
			return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Orthacanthus_Male_1.png");
		} 
		else 
		{
			return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Orthacanthus_Female_1.png");
		}
	}
}
