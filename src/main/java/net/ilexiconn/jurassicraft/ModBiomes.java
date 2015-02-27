package net.ilexiconn.jurassicraft;

import net.ilexiconn.jurassicraft.content.IContentHandler;
import net.ilexiconn.jurassicraft.dimension.biomes.*;
import net.ilexiconn.jurassicraft.dimension.core.WorldProviderDino;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.DimensionManager;

public class ModBiomes implements IContentHandler
{
	public static int BiomeStartID = 70;
	
	public static  BiomeGenBase DinoPlains;
	public static  BiomeGenBase DinoMountains;
	public static  BiomeGenBase DinoOcean;
	public static  BiomeGenBase DinoIslands;
	public static  BiomeGenBase DinoJungle;
    public static  BiomeGenBase DinoRiver;
	
	@Override
	public void init() 
	{
		 DinoPlains = new BiomeGenDinoPlains(BiomeStartID).setColor(6546587).setBiomeName("Dino Plains");
		 DinoMountains = new BiomeGenDinoMountains(BiomeStartID+1).setColor(6546587).setBiomeName("Dino Mountains");
		 DinoOcean = new BiomeGenDinoOcean(BiomeStartID+2).setColor(6546587).setBiomeName("Dino Ocean");
		 DinoIslands = new BiomeGenDinoIslands(BiomeStartID+3).setColor(6546587).setBiomeName("Dino Islands");
		 DinoJungle = new BiomeGenDinoJungle(BiomeStartID+4).setColor(6546587).setBiomeName("Dino Jungle");
         DinoRiver = new BiomeGenDinoRiver(BiomeStartID+5).setColor(6546587).setBiomeName("Dino River");

		
		 
		DimensionManager.registerProviderType(JurassiCraft.dimensionID, WorldProviderDino.class, false);
		DimensionManager.registerDimension(JurassiCraft.dimensionID, JurassiCraft.dimensionID);
	}

}
