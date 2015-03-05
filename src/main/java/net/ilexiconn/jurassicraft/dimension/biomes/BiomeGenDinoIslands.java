package net.ilexiconn.jurassicraft.dimension.biomes;

import java.util.Random;

import net.ilexiconn.jurassicraft.dimension.worldgen.WorldGenBigDinoTree;
import net.ilexiconn.jurassicraft.dimension.worldgen.WorldGenDinoShrub;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class BiomeGenDinoIslands extends BiomeGenBase 
{
	protected WorldGenBigDinoTree worldGeneratorBigDinoTree;
	
	public BiomeGenDinoIslands(int id)
	{
		super(id);
		this.theBiomeDecorator.treesPerChunk = 3;
		this.theBiomeDecorator.grassPerChunk = 25;
		this.theBiomeDecorator.flowersPerChunk = 10;
		this.setTemperatureRainfall(1.9F, 17F);
		this.setHeight(height_PartiallySubmerged); 
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableWaterCreatureList.clear();
		this.waterColorMultiplier = -12133;
	}
	
	public WorldGenAbstractTree func_150567_a(Random p_150567_1_)
	{
		return (WorldGenAbstractTree)(new WorldGenDinoShrub(3, 0));
	}
	
	public int getBiomeGrassColor(int p_150558_1_, int p_150558_2_, int p_150558_3)
	{
		return (0x1E8C1E);
	}
	
	public int getBiomeFoliageColor(int p_150571_1_, int p_150571_2_, int p_150571_3_)
	{
		return (0x057005);
	}

	/**
	 * takes temperature, returns color
	 */
	public int getSkyColorByTemp(float temp) 
	{
		return 0x05587E;
	}
	/**
	 * Provides the basic grass color based on the biome temperature and rainfall
	 */
	/*   public int getBiomeGrassColor()
    {
        double d0 = (double)this.getFloatTemperature();
        double d1 = (double)this.getFloatRainfall();
        return ((ColorizerGrass.getGrassColor(d0, d1) & 16711422) + 5115470) / 2;
    }*/
}