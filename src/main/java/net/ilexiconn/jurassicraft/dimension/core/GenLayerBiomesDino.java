package net.ilexiconn.jurassicraft.dimension.core;

import net.ilexiconn.jurassicraft.ModBiomes;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerBiomesDino extends GenLayer {

	public BiomeGenBase[] dimensionBiomes = {ModBiomes.DinoIslands, ModBiomes.DinoJungle, ModBiomes.DinoMountains, ModBiomes.DinoOcean, ModBiomes.DinoPlains};

	public GenLayerBiomesDino(long seed, GenLayer genlayer) {
	super(seed);
	this.parent = genlayer;
	}

	public GenLayerBiomesDino(long seed) {
	super(seed);
	}

	@Override
	public int[] getInts(int x, int z, int width, int depth)
	{
	int[] dest = IntCache.getIntCache(width*depth);

	for (int dz=0; dz<depth; dz++)
	{
	for (int dx=0; dx<width; dx++)
	{
	this.initChunkSeed(dx+x, dz+z);
	dest[(dx+dz*width)] = this.dimensionBiomes[nextInt(this.dimensionBiomes.length)].biomeID;
	}
	}
	return dest;
	}
	}