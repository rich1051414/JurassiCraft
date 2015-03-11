package net.ilexiconn.jurassicraft.world.feature;

import net.ilexiconn.jurassicraft.JurassiCraft;
import net.minecraft.block.BlockDoublePlant;

public class HeliconiaPlant extends BlockDoublePlant 
{
	//TODO Fix this thing!
	
    public HeliconiaPlant(String name)
    {
        setBlockName(name);
        setBlockTextureName(JurassiCraft.getModId() + "heliconia-2");
    }
}

