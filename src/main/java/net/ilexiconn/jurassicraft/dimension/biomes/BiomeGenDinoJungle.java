package net.ilexiconn.jurassicraft.dimension.biomes;

import java.util.Random;

import net.ilexiconn.jurassicraft.dimension.worldgen.WorldGenBigDinoTree;
import net.ilexiconn.jurassicraft.dimension.worldgen.WorldGenDinoShrub;
import net.ilexiconn.jurassicraft.dimension.worldgen.WorldGenDinoTrees;
import net.ilexiconn.jurassicraft.dimension.worldgen.WorldGenMegaDinoTree;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class BiomeGenDinoJungle extends BiomeGenBase 
{
    protected WorldGenBigDinoTree worldGeneratorBigDinoTree;
    public BiomeGenDinoJungle(int par1)
    {
        super(par1);
        this.theBiomeDecorator.treesPerChunk = 12;
        this.theBiomeDecorator.grassPerChunk = 25;
        this.theBiomeDecorator.flowersPerChunk = 10;
        this.setTemperatureRainfall(1.9F, 17F);
        this.setHeight(new BiomeGenBase.Height(0.2F, 0.1F)); 
        this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.waterColorMultiplier = -12133;
    }
    public WorldGenAbstractTree func_150567_a(Random p_150567_1_)
    {
        return (WorldGenAbstractTree)((p_150567_1_.nextInt(2) == 0 ? new WorldGenBigDinoTree(true) : (p_150567_1_.nextInt(2) == 0 ? new WorldGenDinoShrub(3, 0) : ( p_150567_1_.nextInt(3) == 0 ? new WorldGenMegaDinoTree(false, 10, 20, 3, 3) : new WorldGenDinoTrees(false, 4 + p_150567_1_.nextInt(7), 3, 3, true)))));
    }
    public int getBiomeGrassColor(int p_150558_1_, int p_150558_2_, int p_150558_3)
    {
        return (0x1E5921);
    }
    public int getBiomeFoliageColor(int p_150571_1_, int p_150571_2_, int p_150571_3_)
    {
        return (0x1E5921);
    }

    /**
     * takes temperature, returns color
     */
    public int getSkyColorByTemp(float f) {
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