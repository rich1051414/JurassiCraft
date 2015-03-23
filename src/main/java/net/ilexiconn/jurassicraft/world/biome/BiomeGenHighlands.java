package net.ilexiconn.jurassicraft.world.biome;

import net.ilexiconn.jurassicraft.world.feature.WorldGenLepidodendron;
import net.ilexiconn.jurassicraft.world.feature.WorldGenSmallTrees;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import java.util.Random;

/**
 * @author ProPercivalalb
 **/
public class BiomeGenHighlands extends BiomeGenBaseCarboniferous
{
    
    public BiomeGenHighlands(int par1)
    {
        super(par1);
        this.setHeight(BiomeGenBaseCarboniferous.height_highlands);
        this.setBiomeName("Highlands");
        this.theBiomeDecorator.treesPerChunk = 4;
        
    }
    
    @Override
    public int getSkyColorByTemp(float var1)
    {
        return 0x669933;
    }
    
    @Override
    public WorldGenAbstractTree func_150567_a(Random random)
    {
        int i = random.nextInt(10);
        if (i == 0)
        {
            return (WorldGenAbstractTree) new WorldGenLepidodendron(false);
        }
        else
        {
            return (WorldGenAbstractTree) new WorldGenSmallTrees(false);
        }
    }
}
