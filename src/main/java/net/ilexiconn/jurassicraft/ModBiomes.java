package net.ilexiconn.jurassicraft;

import net.ilexiconn.jurassicraft.api.CarboniferousApi;
import net.ilexiconn.jurassicraft.api.Properties;
import net.ilexiconn.jurassicraft.content.IContentHandler;
import net.ilexiconn.jurassicraft.world.biome.BiomeGenBaseCarboniferous;
import net.ilexiconn.jurassicraft.world.core.WorldProviderDino;
import net.minecraftforge.common.DimensionManager;

public class ModBiomes implements IContentHandler
{
    @Override
    public void init()
    {
        CarboniferousApi.registerBiome(BiomeGenBaseCarboniferous.calamitesSwamp);
        CarboniferousApi.registerBiome(BiomeGenBaseCarboniferous.dinoPlains);
        CarboniferousApi.registerBiome(BiomeGenBaseCarboniferous.highlands);
        CarboniferousApi.registerBiome(BiomeGenBaseCarboniferous.island);
        CarboniferousApi.registerBiome(BiomeGenBaseCarboniferous.coalSwamp);
        CarboniferousApi.registerBiome(BiomeGenBaseCarboniferous.rainforest);
        CarboniferousApi.registerBiome(BiomeGenBaseCarboniferous.carboniferousOcean);
        
        DimensionManager.registerProviderType(Properties.dimensionID, WorldProviderDino.class, false);
        DimensionManager.registerDimension(Properties.dimensionID, Properties.dimensionID);
    }
}
