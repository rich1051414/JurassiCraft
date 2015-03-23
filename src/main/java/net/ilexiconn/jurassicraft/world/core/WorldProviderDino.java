package net.ilexiconn.jurassicraft.world.core;

import net.ilexiconn.jurassicraft.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldProviderDino extends WorldProvider
{
    public void registerWorldChunkManager()
    {
        this.worldChunkMgr = new WorldChunkManagerDino(worldObj.getSeed(), terrainType);
        this.hasNoSky = false;
    }
    
    @Override
    public String getDimensionName()
    {
        return "DinoWorld";
    }
    
    public String getWelcomeMessage()
    {
        return "Entering the Dinosaur Dimension";
    }
    
    public IChunkProvider createChunkGenerator()
    {
        return new ChunkProviderDino(worldObj, worldObj.getSeed(), true);
    }
    
    public boolean canRespawnHere()
    {
        return false;
    }
    
    public int getRespawnDimension(EntityPlayerMP player)
    {
        return 0;
    }
    
    public double getMovementFactor()
    {
        return 10.0;
    }
    
    @Override
    public boolean canCoordinateBeSpawn(int par1, int par2)
    {
        Block k = this.worldObj.getTopBlock(par1, par2);
        return k == ModBlocks.grass;
    }
}