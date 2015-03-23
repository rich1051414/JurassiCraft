package net.ilexiconn.jurassicraft.world.biome;

/**
 * @author ProPercivalalb
 **/

public class BiomeGenRiverCarboniferous extends BiomeGenBaseCarboniferous
{
    
    public BiomeGenRiverCarboniferous(int par1)
    {
        super(par1);
        this.setHeight(BiomeGenBaseCarboniferous.height_carboniferous_river);
        this.setBiomeName("Old River");
    }
    
    @Override
    public int getSkyColorByTemp(float f)
    {
        return 0x336666;
    }
}
