package net.ilexiconn.jurassicraft;

import cpw.mods.fml.common.registry.GameRegistry;
import net.ilexiconn.jurassicraft.content.IContentHandler;
import net.ilexiconn.jurassicraft.tile.*;

public class ModTileEntities implements IContentHandler
{
    public void init()
    {
        GameRegistry.registerTileEntity(TileDNACombinator.class, "jurassicraft:dna_combinator");
        GameRegistry.registerTileEntity(TileDNAExtractor.class, "jurassicraft:dna_extractor");
        GameRegistry.registerTileEntity(TileCultivate.class, "jurassicraft:cultivator");
        GameRegistry.registerTileEntity(TileEgg.class, "jurassicraft:tile_egg");
        GameRegistry.registerTileEntity(TileDinoPad.class, "jurassicraft:dino_pad");
        GameRegistry.registerTileEntity(TileSecurityFence.class, "jurassicraft:securityFenceBase");
        GameRegistry.registerTileEntity(TileSecurityFenceHighBase.class, "jurassicraft:BlockSecurityFenceHighBase");
        GameRegistry.registerTileEntity(TileSecurityFenceHighGrid.class, "jurassicraft:BlockSecurityFenceHighGrid");
        GameRegistry.registerTileEntity(TileSecurityFenceHighPole.class, "jurassicraft:BlockSecurityFenceHighPole");
        GameRegistry.registerTileEntity(TileSecurityFenceMediumBase.class, "jurassicraft:BlockSecurityFenceMediumBase");
        GameRegistry.registerTileEntity(TileSecurityFenceMediumGrid.class, "jurassicraft:BlockSecurityFenceMediumGrid");
        GameRegistry.registerTileEntity(TileSecurityFenceMediumPole.class, "jurassicraft:BlockSecurityFenceMediumPole");
        GameRegistry.registerTileEntity(TileSecurityFenceLowBase.class, "jurassicraft:BlockSecurityFenceLowBase");
        GameRegistry.registerTileEntity(TileSecurityFenceLowGrid.class, "jurassicraft:BlockSecurityFenceLowGrid");
        GameRegistry.registerTileEntity(TileSecurityFenceLowPole.class, "jurassicraft:BlockSecurityFenceLowPole");
    }
}
