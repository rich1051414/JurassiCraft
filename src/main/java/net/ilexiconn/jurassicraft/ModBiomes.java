package net.ilexiconn.jurassicraft;

import net.ilexiconn.jurassicraft.api.Properties;
import net.ilexiconn.jurassicraft.content.IContentHandler;
import net.ilexiconn.jurassicraft.world.biome.*;
import net.ilexiconn.jurassicraft.world.core.WorldProviderDino;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.DimensionManager;

public class ModBiomes implements IContentHandler
{
	public static int biomeStartID = 70;

	public static BiomeDecorator decorator;
	public static BiomeGenBase carboniferous;
	public static BiomeGenBase bog;
	public static BiomeGenBase swamp;
	public static BiomeGenBase coalSwamp;
	public static BiomeGenBase island;
    public static BiomeGenBase highlands;
    public static BiomeGenBase ocean;
    public static BiomeGenBase rainforest;
    public static BiomeGenBase river;

	@Override
	public void init() 
	{

        decorator = new BiomeDecoratorCarboniferous();
		carboniferous = new BiomeGenBaseCarboniferous(1);
		bog = new BiomeGenBog(1);
		swamp = new BiomeGenCalamitesSwamp(1);
		coalSwamp = new BiomeGenCoalSwamp(1);
		island = new BiomeGenIsland(1);
        highlands = new BiomeGenHighlands(1);
        ocean = new BiomeGenOceanCarboniferous(1);
        rainforest = new BiomeGenRainforest(1);
        river = new BiomeGenRiverCarboniferous(1);

		DimensionManager.registerProviderType(Properties.dimensionID, WorldProviderDino.class, false);
		DimensionManager.registerDimension(Properties.dimensionID, Properties.dimensionID);
	}
}
