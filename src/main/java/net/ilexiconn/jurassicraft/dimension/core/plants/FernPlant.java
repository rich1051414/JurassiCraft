package net.ilexiconn.jurassicraft.dimension.core.plants;

import net.ilexiconn.jurassicraft.JurassiCraft;
import net.minecraft.block.BlockBush;

public class FernPlant extends BlockBush {

    public FernPlant(String name) {
        super();
        setBlockName(name);
        setBlockTextureName(JurassiCraft.getModId() + "Fern_2");
    }
}
