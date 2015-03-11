package net.ilexiconn.jurassicraft.world.biome;

import net.ilexiconn.jurassicraft.world.feature.WorldGenCordaites;
import net.ilexiconn.jurassicraft.world.feature.WorldGenLepidodendron;
import net.ilexiconn.jurassicraft.world.feature.WorldGenSmallTrees;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import java.util.Random;

/**
 * @author ProPercivalalb
 **/
public class BiomeGenRainforest extends BiomeGenBaseCarboniferous {
  
	public BiomeGenRainforest(int par1) {
        super(par1);
        this.setHeight(BiomeGenBaseCarboniferous.height_rainforest);
        this.theBiomeDecorator.treesPerChunk = 4;
        this.theBiomeDecorator.grassPerChunk = 16;
        this.setBiomeName("Rainforest");
        this.setTemperatureRainfall(2.0F, 2.0F);
    }

    @Override
    public int getSkyColorByTemp(float par1) {
        return 0x339933;
    }

    @Override
    public WorldGenAbstractTree func_150567_a(Random random) {
        int i = random.nextInt(6);
        if (i <= 1) {
            return (WorldGenAbstractTree)new WorldGenSmallTrees(false);
        }
        if (i == 2) {
            return (WorldGenAbstractTree)new WorldGenCordaites(false);
        }
        else {
            return (WorldGenAbstractTree)new WorldGenLepidodendron(false);
        }
    }
}
