package net.ilexiconn.jurassicraft;

import net.ilexiconn.jurassicraft.content.IContentHandler;
import net.ilexiconn.jurassicraft.dimension.biomes.*;
import net.ilexiconn.jurassicraft.dimension.core.WorldProviderDino;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.DimensionManager;

public class ModBiomes implements IContentHandler
{
	public static int biomeStartID = 70;

	public static BiomeGenBase dinoPlains;
	public static BiomeGenBase dinoMountains;
	public static BiomeGenBase dinoOcean;
	public static BiomeGenBase dinoIslands;
	public static BiomeGenBase dinoJungle;
	public static BiomeGenBase dinoRiver;

	@Override
	public void init() 
	{
		int dinoBiomeColor = 6546587;
		
		dinoPlains = new BiomeGenDinoPlains(biomeStartID).setColor(dinoBiomeColor).setBiomeName("Dino Plains");
		dinoMountains = new BiomeGenDinoMountains(biomeStartID++).setColor(dinoBiomeColor).setBiomeName("Dino Mountains");
		dinoOcean = new BiomeGenDinoOcean(biomeStartID++).setColor(dinoBiomeColor).setBiomeName("Dino Ocean");
		dinoIslands = new BiomeGenDinoIslands(biomeStartID++).setColor(dinoBiomeColor).setBiomeName("Dino Islands");
		dinoJungle = new BiomeGenDinoJungle(biomeStartID++).setColor(dinoBiomeColor).setBiomeName("Dino Jungle");
		dinoRiver = new BiomeGenDinoRiver(biomeStartID++).setColor(dinoBiomeColor).setBiomeName("Dino River");

		DimensionManager.registerProviderType(JurassiCraft.dimensionID, WorldProviderDino.class, false);
		DimensionManager.registerDimension(JurassiCraft.dimensionID, JurassiCraft.dimensionID);
	}
}
