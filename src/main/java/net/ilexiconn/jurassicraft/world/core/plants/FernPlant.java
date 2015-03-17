package net.ilexiconn.jurassicraft.world.core.plants;

import net.ilexiconn.jurassicraft.JurassiCraft;
import net.minecraft.block.BlockFlower;

public class FernPlant extends BlockFlower
{
	public FernPlant(String name)
	{
		super(1);
		setBlockName(name);
		setBlockTextureName(JurassiCraft.getModId() + "Fern_2");
	}
}
