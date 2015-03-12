package net.ilexiconn.jurassicraft;

import net.ilexiconn.jurassicraft.api.Properties;
import net.ilexiconn.jurassicraft.content.IContentHandler;
import net.ilexiconn.jurassicraft.world.WorldProviderCarboniferous;
import net.ilexiconn.jurassicraft.world.biome.*;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.DimensionManager;

public class ModBiomes implements IContentHandler
{
	public static int biomeStartID = 70;

	public static BiomeDecorator Decorator;
	public static BiomeGenBase Carboniferous;
	public static BiomeGenBaseCarboniferous Bog;
	public static BiomeGenBase Swamp;
	public static BiomeGenBaseCarboniferous CoalSwamp;
	public static BiomeGenBase Island;
    public static BiomeGenBase Highlands;
    public static BiomeGenBase Ocean;
    public static BiomeGenBase Rainforest;
    public static BiomeGenBase river;

	@Override
	public void init() 
	{
		int dinoBiomeColor = 6546587;

        Decorator = new BiomeDecoratorCarboniferous();
		Carboniferous = new BiomeGenBaseCarboniferous(1);
		Bog = new BiomeGenBog(1);
		Swamp = new BiomeGenCalamitesSwamp(1);
		CoalSwamp = new BiomeGenCoalSwamp(1);
		Island = new BiomeGenIsland(1);
        Highlands = new BiomeGenHighlands(1);
        Ocean = new BiomeGenOceanCarboniferous(1);
        Rainforest = new BiomeGenRainforest(1);
        river = new BiomeGenRiverCarboniferous(1);

		DimensionManager.registerProviderType(Properties.dimensionID, WorldProviderCarboniferous.class, false);
		DimensionManager.registerDimension(Properties.dimensionID, Properties.dimensionID);
	}
}
