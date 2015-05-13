package net.ilexiconn.jurassicraft.common.tileentity;

import cpw.mods.fml.common.registry.GameRegistry;
import net.ilexiconn.jurassicraft.common.data.loader.IContentHandler;
import net.ilexiconn.jurassicraft.common.tileentity.fence.TileSecurityFenceLowBase;
import net.ilexiconn.jurassicraft.common.tileentity.fence.TileSecurityFenceLowCorner;
import net.ilexiconn.jurassicraft.common.tileentity.fence.TileSecurityFenceLowGrid;
import net.ilexiconn.jurassicraft.common.tileentity.fence.TileSecurityFenceLowPole;

public class JCTileEntityRegistry implements IContentHandler
{
    public void init()
    {
        GameRegistry.registerTileEntity(TileDNACombinator.class, "jurassicraft:dna_combinator");
        GameRegistry.registerTileEntity(TileDNAExtractor.class, "jurassicraft:dna_extractor");
        GameRegistry.registerTileEntity(TileCultivate.class, "jurassicraft:cultivator");
        GameRegistry.registerTileEntity(TileEgg.class, "jurassicraft:tile_egg");
        GameRegistry.registerTileEntity(TileDinoPad.class, "jurassicraft:dino_pad");
        GameRegistry.registerTileEntity(TileSecurityFenceLowCorner.class, "jurassicraft:BlockSecurityFenceLowCorner");
        GameRegistry.registerTileEntity(TileSecurityFenceLowBase.class, "jurassicraft:BlockSecurityFenceLowBase");
        GameRegistry.registerTileEntity(TileSecurityFenceLowGrid.class, "jurassicraft:BlockSecurityFenceLowGrid");
        GameRegistry.registerTileEntity(TileSecurityFenceLowPole.class, "jurassicraft:BlockSecurityFenceLowPole");
        
        /*
        GameRegistry.registerTileEntity(TileSecurityFenceMediumCorner.class, "jurassicraft:BlockSecurityFenceMediumCorner");
        GameRegistry.registerTileEntity(TileSecurityFenceMediumBase.class, "jurassicraft:BlockSecurityFenceMediumBase");
        GameRegistry.registerTileEntity(TileSecurityFenceMediumGrid.class, "jurassicraft:BlockSecurityFenceMediumGrid");
        GameRegistry.registerTileEntity(TileSecurityFenceMediumPole.class, "jurassicraft:BlockSecurityFenceMediumPole");
        
        GameRegistry.registerTileEntity(TileSecurityFenceHighCorner.class, "jurassicraft:BlockSecurityFenceHighCorner");
        GameRegistry.registerTileEntity(TileSecurityFenceHighBase.class, "jurassicraft:BlockSecurityFenceHighBase");
        GameRegistry.registerTileEntity(TileSecurityFenceHighGrid.class, "jurassicraft:BlockSecurityFenceHighGrid");
        GameRegistry.registerTileEntity(TileSecurityFenceHighPole.class, "jurassicraft:BlockSecurityFenceHighPole");
        */
    }
}
