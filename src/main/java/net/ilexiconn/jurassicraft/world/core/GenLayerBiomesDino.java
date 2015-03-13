package net.ilexiconn.jurassicraft.world.core;

import net.ilexiconn.jurassicraft.world.biome.BiomeGenBaseCarboniferous;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerBiomesDino extends GenLayer {

    public BiomeGenBase[] dimensionBiomes = {BiomeGenBaseCarboniferous.rainforest, BiomeGenBaseCarboniferous.calamitesSwamp,
    BiomeGenBaseCarboniferous.highlands, BiomeGenBaseCarboniferous.island, BiomeGenBaseCarboniferous.coalSwamp, BiomeGenBaseCarboniferous.carboniferousOcean};

    public GenLayerBiomesDino(long var1, GenLayer var3) {
        super(var1);
        this.parent = var3;
    }

    public GenLayerBiomesDino(long var1) {
        super(var1);
    }

    @Override
    public int[] getInts(int x, int z, int width, int depth)
    {
        int[] dest = IntCache.getIntCache(width * depth);

        for (int dz = 0; dz < depth; dz++)
        {
            for (int dx = 0; dx  <width; dx++)
            {
                this.initChunkSeed(dx + x, dz + z);
                dest[(dx + dz * width)] = this.dimensionBiomes[nextInt(this.dimensionBiomes.length)].biomeID;
            }
        }

        return dest;
    }
}
