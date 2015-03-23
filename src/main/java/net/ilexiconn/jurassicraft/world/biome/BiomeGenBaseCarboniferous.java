package net.ilexiconn.jurassicraft.world.biome;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.ilexiconn.jurassicraft.ModBlocks;
import net.ilexiconn.jurassicraft.api.Properties;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

import java.util.Random;

/**
 * @author ProPercivalalb
 **/
public class BiomeGenBaseCarboniferous extends BiomeGenBase
{
    
    protected static final BiomeGenBase.Height height_carboniferous_river = new BiomeGenBase.Height(-0.5F, 0.0F);
    protected static final BiomeGenBase.Height height_carboniferous_ocean = new BiomeGenBase.Height(-1.5F, 0.0F);
    protected static final BiomeGenBase.Height height_calamites_swamp = new BiomeGenBase.Height(-0.15F, 0.15F);
    protected static final BiomeGenBase.Height height_highlands = new BiomeGenBase.Height(1.5F, 0.5F);
    protected static final BiomeGenBase.Height height_island = new BiomeGenBase.Height(-0.2F, 0.6F);
    protected static final BiomeGenBase.Height height_coal_swamp = new BiomeGenBase.Height(-0.05F, 0.15F);
    protected static final BiomeGenBase.Height height_rainforest = new BiomeGenBase.Height(0.25F, 0.25F);
    protected static final BiomeGenBase.Height height_bog = new BiomeGenBase.Height(0.0F, 0.4F);
    
    public static final BiomeGenBaseCarboniferous carboniferousRiver = new BiomeGenRiverCarboniferous(Properties.BIOME_ID_RIVER);
    public static final BiomeGenBaseCarboniferous carboniferousOcean = new BiomeGenOceanCarboniferous(Properties.BIOME_ID_OCEAN);
    public static final BiomeGenBase dinoPlains = new BiomeGenDinoPlains(Properties.BIOME_ID_PLAINS);
    public static final BiomeGenBaseCarboniferous calamitesSwamp = new BiomeGenCalamitesSwamp(Properties.BIOME_ID_CALAMITESSWAMP);
    public static final BiomeGenBaseCarboniferous highlands = new BiomeGenHighlands(Properties.BIOME_ID_HIGHLANDS);
    public static final BiomeGenBaseCarboniferous island = new BiomeGenIsland(Properties.BIOME_ID_ISLAND);
    public static final BiomeGenBaseCarboniferous coalSwamp = new BiomeGenCoalSwamp(Properties.BIOME_ID_COALSWAMP);
    public static final BiomeGenBaseCarboniferous rainforest = new BiomeGenRainforest(Properties.BIOME_ID_RAINFOREST);
    public static final BiomeGenBaseCarboniferous bog = new BiomeGenBog(Properties.BIOME_ID_BOG);
    
    /*
     * Thanks to Carboniferous Mod for letting us merge their mod into ours.
     * Thanks to JTGhawk137 for merging all the code
     */
    
    public BiomeGenBaseCarboniferous(int par1)
    {
        super(par1);
        this.theBiomeDecorator = new BiomeDecoratorCarboniferous();
        this.topBlock = ModBlocks.grass;
        this.fillerBlock = ModBlocks.dirt;
        this.spawnableCreatureList.clear();
        this.spawnableMonsterList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableCaveCreatureList.clear();
        this.temperature = 2.0F;
        this.rainfall = 2.0F;
        this.waterColorMultiplier = 39219;
        this.setColor(0xfa9325);
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public int getBiomeGrassColor(int x, int y, int z)
    {
        return 3887907;
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public int getBiomeFoliageColor(int x, int y, int z)
    {
        return 13056;
    }
    
    public BiomeDecoratorCarboniferous getBiomeDecorator()
    {
        return (BiomeDecoratorCarboniferous) this.theBiomeDecorator;
    }
    
    @Override
    public void decorate(World par1World, Random par2Random, int par3, int par4)
    {
        super.decorate(par1World, par2Random, par3, par4);
    }
}
