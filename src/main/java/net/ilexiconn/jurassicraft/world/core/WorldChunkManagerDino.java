package net.ilexiconn.jurassicraft.world.core;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.ilexiconn.jurassicraft.ModBiomes;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeCache;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WorldChunkManagerDino extends WorldChunkManager
{
	private GenLayer genBiomes;
	private GenLayer biomeIndexLayer;
	private BiomeCache biomeCache;
	private List<BiomeGenBase> myBiomesToSpawnIn;

	protected WorldChunkManagerDino()
	{
		this.biomeCache = new BiomeCache(this);
		this.myBiomesToSpawnIn = new ArrayList<BiomeGenBase>();
		this.myBiomesToSpawnIn.add(ModBiomes.swamp);
		this.myBiomesToSpawnIn.add(ModBiomes.river);
		this.myBiomesToSpawnIn.add(ModBiomes.rainforest);
		this.myBiomesToSpawnIn.add(ModBiomes.ocean);
		this.myBiomesToSpawnIn.add(ModBiomes.bog);
		this.myBiomesToSpawnIn.add(ModBiomes.carboniferous);
        this.myBiomesToSpawnIn.add(ModBiomes.coalSwamp);
        this.myBiomesToSpawnIn.add(ModBiomes.highlands);
        this.myBiomesToSpawnIn.add(ModBiomes.island);
    }

	public WorldChunkManagerDino(long seed, WorldType worldtype)
	{
		this();
		
		GenLayer[] genLayer = GenLayerDino.makeTheWorld(seed);
		
		this.genBiomes = genLayer[0];
		this.biomeIndexLayer = genLayer[1];
	}

	public WorldChunkManagerDino(World world)
	{
		this(world.getSeed(), world.provider.terrainType);
	}

	/**
	 * Gets the list of valid biomes for the player to spawn in.
	 */
	public List<BiomeGenBase> getBiomesToSpawnIn()
	{
		return this.myBiomesToSpawnIn;
	}

	/**
	 * Returns the BiomeGenBase related to the x, z position on the world.
	 */
	public BiomeGenBase getBiomeGenAt(int x, int z)
	{
		BiomeGenBase biome = this.biomeCache.getBiomeGenAt(x, z);
		
		if (biome == null)
		{
			return ModBiomes.rainforest;
		}

		return biome;
	}

	/**
	 * Returns a list of rainfall values for the specified blocks. Args:
	 * listToReuse, x, z, width, length.
	 */
	public float[] getRainfall(float[] rainfallMap, int x, int y, int width, int length)
	{
		IntCache.resetIntCache();

		if (rainfallMap == null || rainfallMap.length < width * length)
		{
			rainfallMap = new float[width * length];
		}

		int[] aint = this.biomeIndexLayer.getInts(x, y, width, length);

		for (int i1 = 0; i1 < width * length; ++i1)
		{
			float f = (float) BiomeGenBase.getBiomeGenArray()[aint[i1]].getIntRainfall() / 65536.0F;

			if (f > 1.0F) 
			{
				f = 1.0F;
			}

			rainfallMap[i1] = f;
		}

		return rainfallMap;
	}

	/**
	 * Return an adjusted version of a given temperature based on the y height
	 */
	@SideOnly(Side.CLIENT)
	public float getTemperatureAtHeight(float par1, int par2)
	{
		return par1;
	}

	/**
	 * Returns a list of temperatures to use for the specified blocks. Args:
	 * listToReuse, x, y, width, length
	 */
	public float[] getTemperatures(float[] temperatureMap, int x, int y, int width, int length)
	{
		IntCache.resetIntCache();

		if (temperatureMap == null || temperatureMap.length < width * length)
		{
			temperatureMap = new float[width * length];
		}

		int[] aint = this.biomeIndexLayer.getInts(x, y, width, length);

		for (int i = 0; i < width * length; ++i)
		{
			float f = (float) BiomeGenBase.getBiomeGenArray()[aint[i]].temperature / 65536.0F;

			if (f > 1.0F) 
			{
				f = 1.0F;
			}

			temperatureMap[i] = f;
		}

		return temperatureMap;
	}

	/**
	 * Returns an array of biomes for the location input.
	 */
	public BiomeGenBase[] getBiomesForGeneration(BiomeGenBase[] biomes, int x, int y, int width, int height)
	{
		IntCache.resetIntCache();

		if (biomes == null || biomes.length < width * height)
		{
			biomes = new BiomeGenBase[width * height];
		}

		int[] aint = this.genBiomes.getInts(x, y, width, height);

		for (int i = 0; i < width * height; ++i)
		{
			if (aint[i] >= 0) 
			{
				biomes[i] = BiomeGenBase.getBiomeGenArray()[aint[i]];
			}
			else 
			{
				biomes[i] = ModBiomes.rainforest;
			}
		}

		return biomes;
	}

	/**
	 * Returns biomes to use for the blocks and loads the other data like
	 * temperature and humidity onto the WorldChunkManager Args: oldBiomeList,
	 * x, z, width, depth
	 */
	public BiomeGenBase[] loadBlockGeneratorData(BiomeGenBase[] biomeList, int x, int y, int width, int depth)
	{
		return this.getBiomeGenAt(biomeList, x, y, width, depth, true);
	}

	/**
	 * Return a list of biomes for the specified blocks. Args: listToReuse, x,
	 * y, width, length, cacheFlag (if false, don't check biomeCache to avoid
	 * infinite loop in BiomeCacheBlock)
	 */
	public BiomeGenBase[] getBiomeGenAt(BiomeGenBase[] biomes, int x, int y, int width, int length, boolean cacheFlag) 
	{
		IntCache.resetIntCache();

		if (biomes == null || biomes.length < width * length)
		{
			biomes = new BiomeGenBase[width * length];
		}

		if (cacheFlag && width == 16 && length == 16 && (x & 15) == 0 && (y & 15) == 0)
		{
			BiomeGenBase[] chachedBiomes = this.biomeCache.getCachedBiomes(x, y);
			System.arraycopy(chachedBiomes, 0, biomes, 0, width * length);
			
			return biomes;
		}
		else 
		{
			int[] aint = this.biomeIndexLayer.getInts(x, y, width, length);

			for (int i = 0; i < width * length; ++i) 
			{
				if (aint[i] >= 0) 
				{
					biomes[i] = BiomeGenBase.getBiomeGenArray()[aint[i]];
				} 
				else 
				{
					biomes[i] = ModBiomes.rainforest;
				}
			}

			return biomes;
		}
	}

	/**
	 * checks given Chunk's Biomes against List of allowed ones
	 */
	public boolean areBiomesViable(int par1, int par2, int par3, List biomes)
	{
		IntCache.resetIntCache();
		int l = par1 - par3 >> 2;
		int i1 = par2 - par3 >> 2;
		int j1 = par1 + par3 >> 2;
		int k1 = par2 + par3 >> 2;
		int l1 = j1 - l + 1;
		int i2 = k1 - i1 + 1;
		int[] aint = this.genBiomes.getInts(l, i1, l1, i2);

		for (int j2 = 0; j2 < l1 * i2; ++j2) 
		{
			BiomeGenBase biome = BiomeGenBase.getBiomeGenArray()[aint[j2]];

			if (!biomes.contains(biome))
			{
				return false;
			}
		}

		return true;
	}

	/**
	 * Finds a valid position within a range, that is in one of the listed
	 * biomes. Searches {par1,par2} +-par3 blocks. Strongly favors positive y
	 * positions.
	 */
	public ChunkPosition findBiomePosition(int par1, int par2, int par3, List biomes, Random rand) 
	{
		IntCache.resetIntCache();
		int l = par1 - par3 >> 2;
		int i1 = par2 - par3 >> 2;
		int j1 = par1 + par3 >> 2;
		int k1 = par2 + par3 >> 2;
		int l1 = j1 - l + 1;
		int i2 = k1 - i1 + 1;
		int[] aint = this.genBiomes.getInts(l, i1, l1, i2);
		ChunkPosition chunkposition = null;
		int j2 = 0;

		for (int k2 = 0; k2 < l1 * i2; ++k2) 
		{
			int l2 = l + k2 % l1 << 2;
			int i3 = i1 + k2 / l1 << 2;
			BiomeGenBase biome = BiomeGenBase.getBiomeGenArray()[aint[k2]];

			if (biomes.contains(biome) && (chunkposition == null || rand.nextInt(j2 + 1) == 0)) 
			{
				chunkposition = new ChunkPosition(l2, 0, i3);
				++j2;
			}
		}

		return chunkposition;
	}

	/**
	 * Calls the WorldChunkManager's biomeCache.cleanupCache()
	 */
	public void cleanupCache()
	{
		this.biomeCache.cleanupCache();
	}
}