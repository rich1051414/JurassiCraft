package net.ilexiconn.jurassicraft.world.biome;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.ilexiconn.jurassicraft.ModBlocks;
import net.minecraft.world.World;

import java.util.Random;

public class BiomeGenDinoPlains extends BiomeGenBaseCarboniferous {

    public BiomeGenDinoPlains(int par1) {
        super(par1);
        this.theBiomeDecorator = new BiomeDecoratorCarboniferous();
        this.topBlock = ModBlocks.grass;
        this.fillerBlock = ModBlocks.dirt;
        this.temperature = 2.0F;
        this.rainfall = 2.0F;
        this.waterColorMultiplier = 39219;
        this.setColor(0xfa9325);
        this.setBiomeName("Dino Plains");
    }

    @SideOnly(Side.CLIENT)
    @Override
    public int getBiomeGrassColor(int x, int y, int z) {
        return 3887907;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public int getBiomeFoliageColor(int x, int y, int z) {
        return 13056;
    }


    @Override
    public void decorate(World par1World, Random par2Random, int par3, int par4) {
        super.decorate(par1World, par2Random, par3, par4);
    }
}
