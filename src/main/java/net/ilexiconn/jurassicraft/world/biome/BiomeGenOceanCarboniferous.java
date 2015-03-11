package net.ilexiconn.jurassicraft.world.biome;

/**
 * @author ProPercivalalb
 **/
public class BiomeGenOceanCarboniferous extends BiomeGenBaseCarboniferous {
   
	public BiomeGenOceanCarboniferous(int par1) {
        super(par1);
        this.setHeight(BiomeGenBaseCarboniferous.height_carboniferous_ocean);
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.setBiomeName("Carboniferous Ocean");
    }

	@Override
    public int getSkyColorByTemp(float par1) {
        return 0x336666;
    }
}
