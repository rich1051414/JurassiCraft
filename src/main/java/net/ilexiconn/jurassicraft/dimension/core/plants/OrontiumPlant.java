package net.ilexiconn.jurassicraft.dimension.core.plants;

import net.ilexiconn.jurassicraft.JurassiCraft;
import net.minecraft.block.BlockBush;

public class OrontiumPlant extends BlockBush {

    public OrontiumPlant(String name) {
        setBlockName(name);
        setBlockTextureName(JurassiCraft.getModId() + "Orontium_Mackii_2");
    }
}
