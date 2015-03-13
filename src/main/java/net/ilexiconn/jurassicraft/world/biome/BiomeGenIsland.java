package net.ilexiconn.jurassicraft.world.biome;

import net.ilexiconn.jurassicraft.world.feature.WorldGenLepidodendron;
import net.ilexiconn.jurassicraft.world.feature.WorldGenSigillaria;
import net.ilexiconn.jurassicraft.world.feature.WorldGenSmallTrees;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import java.util.Random;

/**
 * @author ProPercivalalb
 **/
public class BiomeGenIsland extends BiomeGenBaseCarboniferous {
  
	public BiomeGenIsland(int i) {
        super(i);
       // this.minHeight = -0.8F;
        //this.maxHeight = 0.8F;
        this.setHeight(BiomeGenBaseCarboniferous.height_island);
        this.theBiomeDecorator.treesPerChunk = 3;
        this.setBiomeName("Island");

    }

	@Override
    public int getSkyColorByTemp(float par1) {
        return 0x66cc99;
    }

	@Override
    public WorldGenAbstractTree func_150567_a(Random random) {
        int i = random.nextInt(10);
        if (i == 0) {
            return (WorldGenAbstractTree)new WorldGenLepidodendron(false);
        }
        if (i == 1) {
            return (WorldGenAbstractTree)new WorldGenSigillaria(false);
        }
        else {
            return (WorldGenAbstractTree)new WorldGenSmallTrees(false);
        }
    }
}
