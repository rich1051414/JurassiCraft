package net.ilexiconn.jurassicraft.world.core;

import com.google.common.collect.Lists;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

import java.util.List;

public class GenLayerBiomesDino extends GenLayer
{
    
    private static List<BiomeGenBase> biomes = Lists.newArrayList();
    
    public static void registerBiome(BiomeGenBase biome)
    {
        if (!biomes.contains(biome))
        {
            biomes.add(biome);
        }
    }
    
    public GenLayerBiomesDino(long var1, GenLayer var3)
    {
        super(var1);
        this.parent = var3;
    }
    
    public GenLayerBiomesDino(long var1)
    {
        super(var1);
    }
    
    @Override
    public int[] getInts(int x, int z, int width, int depth)
    {
        int[] dest = IntCache.getIntCache(width * depth);
        
        for (int dz = 0; dz < depth; dz++)
        {
            for (int dx = 0; dx < width; dx++)
            {
                this.initChunkSeed(dx + x, dz + z);
                dest[(dx + dz * width)] = this.biomes.get(this.nextInt(biomes.size())).biomeID;
            }
        }
        
        return dest;
    }
}
