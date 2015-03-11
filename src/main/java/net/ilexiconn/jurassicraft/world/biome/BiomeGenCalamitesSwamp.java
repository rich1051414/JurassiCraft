package net.ilexiconn.jurassicraft.world.biome;

import net.ilexiconn.jurassicraft.world.feature.WorldGenCalamites;
import net.ilexiconn.jurassicraft.world.feature.WorldGenLepidodendron;
import net.ilexiconn.jurassicraft.world.feature.WorldGenSmallTrees;
import net.ilexiconn.jurassicraft.world.feature.WorldGenWaterCalamites;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import java.util.Random;

/**
 * @author ProPercivalalb
 **/
public class BiomeGenCalamitesSwamp extends BiomeGenBaseCarboniferous {

	public BiomeGenCalamitesSwamp(int par1) {
		super(par1);
		this.setColor(0xfa9418);
		this.setBiomeName("Calamites Swamp");
		this.setHeight(BiomeGenBaseCarboniferous.height_calamites_swamp);
		this.waterColorMultiplier = 0x333300;
		this.theBiomeDecorator.treesPerChunk = 6;
	}

	@Override
	public int getSkyColorByTemp(float par1) {
        return 26163;
    }

	@Override
    public WorldGenAbstractTree func_150567_a(Random random) {
		int i = random.nextInt(30);
        if (i <= 6) {
            return (WorldGenAbstractTree)new WorldGenSmallTrees(false);
        }
        if (i > 6 && i <= 16) {
            return (WorldGenAbstractTree)new WorldGenWaterCalamites(false);
        }
        if (i > 16 && i <= 24) {
            return (WorldGenAbstractTree)new WorldGenCalamites(false);
        }
        else {
            return (WorldGenAbstractTree)new WorldGenLepidodendron(false);
        }
    }
}
