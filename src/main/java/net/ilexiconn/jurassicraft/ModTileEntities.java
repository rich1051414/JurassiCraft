package net.ilexiconn.jurassicraft;

import net.ilexiconn.jurassicraft.content.IContentHandler;
import net.ilexiconn.jurassicraft.tile.TileCultivate;
import net.ilexiconn.jurassicraft.tile.TileDNACombinator;
import net.ilexiconn.jurassicraft.tile.TileDNAExtractor;
import net.ilexiconn.jurassicraft.tile.TileDinoPad;
import net.ilexiconn.jurassicraft.tile.TileEgg;
import net.ilexiconn.jurassicraft.tile.TileSecurityFenceLowBase;
import net.ilexiconn.jurassicraft.tile.TileSecurityFenceLowGrid;
import net.ilexiconn.jurassicraft.tile.TileSecurityFenceLowMain;
import net.ilexiconn.jurassicraft.tile.TileSecurityFenceLowPole;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModTileEntities implements IContentHandler
{
    public void init()
    {
        GameRegistry.registerTileEntity(TileDNACombinator.class, "jurassicraft:dna_combinator");
        GameRegistry.registerTileEntity(TileDNAExtractor.class, "jurassicraft:dna_extractor");
        GameRegistry.registerTileEntity(TileCultivate.class, "jurassicraft:cultivator");
        GameRegistry.registerTileEntity(TileEgg.class, "jurassicraft:tile_egg");
        GameRegistry.registerTileEntity(TileDinoPad.class, "jurassicraft:dino_pad");
        GameRegistry.registerTileEntity(TileSecurityFenceLowMain.class, "jurassicraft:securityFenceBase");
        GameRegistry.registerTileEntity(TileSecurityFenceLowBase.class, "jurassicraft:BlockSecurityFenceLowBase");
        GameRegistry.registerTileEntity(TileSecurityFenceLowGrid.class, "jurassicraft:BlockSecurityFenceLowGrid");
        GameRegistry.registerTileEntity(TileSecurityFenceLowPole.class, "jurassicraft:BlockSecurityFenceLowPole");
    }
}
