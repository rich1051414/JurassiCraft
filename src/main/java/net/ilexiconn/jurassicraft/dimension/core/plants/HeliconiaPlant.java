package net.ilexiconn.jurassicraft.dimension.core.plants;

import net.ilexiconn.jurassicraft.JurassiCraft;
import net.minecraft.block.BlockDoublePlant;

public class HeliconiaPlant extends BlockDoublePlant {

    public HeliconiaPlant(String name) {
        super();
        setBlockName(name);
        setBlockTextureName(JurassiCraft.getModId() + "heliconia-2");
    }
}

