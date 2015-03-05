package net.ilexiconn.jurassicraft.dimension.biomes;

import net.ilexiconn.jurassicraft.dimension.worldgen.WorldGenBigDinoTree;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenDinoOcean extends BiomeGenBase 
{
    protected WorldGenBigDinoTree worldGeneratorBigDinoTree;
    
    public BiomeGenDinoOcean(int id)
    {
        super(id);
        this.theBiomeDecorator.treesPerChunk = 0;
        this.theBiomeDecorator.grassPerChunk = 0;
        this.theBiomeDecorator.flowersPerChunk = 0;
        this.setTemperatureRainfall(1.9F, 17F);
        this.setHeight(height_Oceans); 
        this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.waterColorMultiplier = -12133;
    }
 
    /**
     * takes temperature, returns color
     */
    public int getSkyColorByTemp(float f) 
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