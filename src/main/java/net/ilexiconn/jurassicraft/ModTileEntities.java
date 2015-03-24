package net.ilexiconn.jurassicraft;

import cpw.mods.fml.common.registry.GameRegistry;
import net.ilexiconn.jurassicraft.content.IContentHandler;
import net.ilexiconn.jurassicraft.tile.*;
import net.ilexiconn.jurassicraft.tile.fence.TileSecurityFenceLowBase;
import net.ilexiconn.jurassicraft.tile.fence.TileSecurityFenceLowCorner;
import net.ilexiconn.jurassicraft.tile.fence.TileSecurityFenceLowGrid;
import net.ilexiconn.jurassicraft.tile.fence.TileSecurityFenceLowPole;
import net.minecraft.tileentity.TileEntity;

public class ModTileEntities implements IContentHandler
{
    public void init()
    {
        registerTileEntity(TileDNACombinator.class, "dna_combinator");
        registerTileEntity(TileDNAExtractor.class, "dna_extractor");
        registerTileEntity(TileCultivate.class, "cultivator");
        registerTileEntity(TileEgg.class, "tile_egg");
        registerTileEntity(TileDinoPad.class, "dino_pad");
        registerTileEntity(TileSecurityFenceLowCorner.class, "BlockSecurityFenceLowCorner");
        registerTileEntity(TileSecurityFenceLowBase.class, "BlockSecurityFenceLowBase");
        registerTileEntity(TileSecurityFenceLowGrid.class, "BlockSecurityFenceLowGrid");
        registerTileEntity(TileSecurityFenceLowPole.class, "BlockSecurityFenceLowPole");
        
        registerTileEntity(TileEntityCompressor.class, "Compressor");
        registerTileEntity(TileEntityGrinder.class, "Grinder");
        registerTileEntity(TileEntityTimeBox.class, "Timebox");
        registerTileEntity(TileEntityWallShell.class, "Wallshell");
        
        /*
        registerTileEntity(TileSecurityFenceMediumCorner.class, "BlockSecurityFenceMediumCorner");
        registerTileEntity(TileSecurityFenceMediumBase.class, "BlockSecurityFenceMediumBase");
        registerTileEntity(TileSecurityFenceMediumGrid.class, "BlockSecurityFenceMediumGrid");
        registerTileEntity(TileSecurityFenceMediumPole.class, "BlockSecurityFenceMediumPole");
        
        registerTileEntity(TileSecurityFenceHighCorner.class, "BlockSecurityFenceHighCorner");
        registerTileEntity(TileSecurityFenceHighBase.class, "BlockSecurityFenceHighBase");
        registerTileEntity(TileSecurityFenceHighGrid.class, "BlockSecurityFenceHighGrid");
        registerTileEntity(TileSecurityFenceHighPole.class, "BlockSecurityFenceHighPole");
         */
    }
    
    private void registerTileEntity(Class<? extends TileEntity> te, String name)
    {
        GameRegistry.registerTileEntity(te, "jurassicraft:" + name);
    }
}
