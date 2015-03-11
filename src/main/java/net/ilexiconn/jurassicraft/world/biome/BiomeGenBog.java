package net.ilexiconn.jurassicraft.world.biome;

import net.ilexiconn.jurassicraft.world.feature.WorldGenCalamites;
import net.ilexiconn.jurassicraft.world.feature.WorldGenCordaites;
import net.ilexiconn.jurassicraft.world.feature.WorldGenLepidodendron;
import net.ilexiconn.jurassicraft.world.feature.WorldGenSmallTrees;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import java.awt.*;
import java.util.Random;

/**
 * @author ProPercivalalb
 **/
public class BiomeGenBog extends BiomeGenBaseCarboniferous {
    
	public BiomeGenBog(int i) {
        super(i);
        //this.minHeight = -0.25F;
        //this.maxHeight = -0.5F;
        this.setHeight(BiomeGenBaseCarboniferous.height_bog);
        this.waterColorMultiplier = 0x333300;
        this.setBiomeName("Bog");
        this.theBiomeDecorator.treesPerChunk = 6;
    }

	@Override
    public int getSkyColorByTemp(float f) {
		return Color.getHSBColor(0.14F, 0.22F, 0.39F).getRGB();
    }

	@Override
    public WorldGenAbstractTree func_150567_a(Random random) {
        int i = random.nextInt(30);
        if (i <= 6) {
            return (WorldGenAbstractTree)new WorldGenSmallTrees(false);
        }
        if (i > 6 && i <= 10) {
            return (WorldGenAbstractTree)new WorldGenCalamites(false);
        }
        if (i == 13) {
            return (WorldGenAbstractTree)new WorldGenCordaites(false);
        }
        else {
            return (WorldGenAbstractTree)new WorldGenLepidodendron(false);
        }
    }
}
