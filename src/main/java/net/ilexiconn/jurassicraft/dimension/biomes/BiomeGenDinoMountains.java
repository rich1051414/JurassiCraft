package net.ilexiconn.jurassicraft.dimension.biomes;

import java.util.Random;

import net.ilexiconn.jurassicraft.dimension.worldgen.WorldGenBigDinoTree;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenMutated;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class BiomeGenDinoMountains extends BiomeGenBase 
{
    protected WorldGenBigDinoTree worldGeneratorBigDinoTree;
    
    public BiomeGenDinoMountains(int id)
    {
        super(id);
        this.theBiomeDecorator.treesPerChunk = 1;
        this.theBiomeDecorator.grassPerChunk = 25;
        this.theBiomeDecorator.flowersPerChunk = 4;
        this.setTemperatureRainfall(1.9F, 17F);
        this.setHeight(this.height_LowHills); 
        this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.waterColorMultiplier = -12133;
    }
    
    public WorldGenAbstractTree func_150567_a(Random p_150567_1_)
    {
        return (WorldGenAbstractTree)(new WorldGenBigDinoTree(true));
    }
    
    public int getBiomeGrassColor(int p_150558_1_, int p_150558_2_, int p_150558_3)
    {
        return (0x168D16);
    }
    public int getBiomeFoliageColor(int p_150571_1_, int p_150571_2_, int p_150571_3_)
    {
        return (0x1E5921);
    }
    
    /**
     * Creates a mutated version of the biome and places it into the biomeList with an index equal to the original plus
     * 128
     */
    public BiomeGenBase createMutation()
    {
        BiomeGenDinoMountains.Mutated mutated = new BiomeGenDinoMountains.Mutated(this.biomeID + 128, this);
        mutated.temperature = (this.temperature + 1.0F) * 0.5F;
        mutated.rootHeight = this.rootHeight * 0.5F + 0.3F;
        mutated.heightVariation = this.heightVariation * 0.5F + 1.2F;
        return mutated;
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
    
    
    public static class Mutated extends BiomeGenMutated
    {
        public Mutated(int p_i45382_1_, BiomeGenBase biome)
        {
            super(p_i45382_1_, biome);
            this.theBiomeDecorator.treesPerChunk = 2;
            this.theBiomeDecorator.flowersPerChunk = 2;
            this.theBiomeDecorator.grassPerChunk = 5;
        }

        public void genTerrainBlocks(World world, Random rand, Block[] blocks, byte[] p_150573_4_, int chunkX, int chunkZ, double p_150573_7_)
        {
            this.topBlock = Blocks.grass;
            this.field_150604_aj = 0;
            this.fillerBlock = Blocks.dirt;

            if (p_150573_7_ > 1.75D)
            {
                this.topBlock = Blocks.stone;
                this.fillerBlock = Blocks.stone;
            }
            else if (p_150573_7_ > -0.5D)
            {
                this.topBlock = Blocks.dirt;
                this.field_150604_aj = 1;
            }

            this.genBiomeTerrain(world, rand, blocks, p_150573_4_, chunkX, chunkZ, p_150573_7_);
        }

        public void decorate(World world, Random rand, int chunkX, int chunkZ)
        {
            this.theBiomeDecorator.decorateChunk(world, rand, this, chunkX, chunkZ);
        }
    }
}