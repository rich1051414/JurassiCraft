package net.ilexiconn.jurassicraft.world.core;

import net.ilexiconn.jurassicraft.ModBlocks;
import net.ilexiconn.jurassicraft.world.biome.BiomeDecoratorCarboniferous;
import net.ilexiconn.jurassicraft.world.feature.*;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class DimensionProperties {

    /*
     * Made just to clean up classes
     */

    public static void decoratorProperties(BiomeDecoratorCarboniferous decorator) {
        decorator.dirtGen = new WorldGenMinable(ModBlocks.dirt, 32, ModBlocks.multiBlock1);
        decorator.limestoneGen = new WorldGenLimestone(ModBlocks.multiBlock1, 3, 32, ModBlocks.multiBlock1);
        decorator.sedimentGen = new WorldGenSediment(6);
        decorator.clayPerChunk = 1;
        decorator.sandPerChunk = decorator.sandPerChunk2 = 1;
        decorator.reedsPerChunk = 0;
        decorator.grassPerChunk = 0;
        decorator.flowersPerChunk = 0;
        decorator.sedimentPerChunk = 1;
        decorator.antHillsPerChunk = 1;
        decorator.coralPerChunk = 5;
        decorator.goldGen = new WorldGenMinable(ModBlocks.multiBlock1, 11, 10, ModBlocks.multiBlock1);
        decorator.diamondGen = new WorldGenMinable(ModBlocks.multiBlock1, 10, 10, ModBlocks.multiBlock1);
        decorator.hermiteGen = new WorldGenMinable(ModBlocks.multiBlock1, 12, 5, ModBlocks.multiBlock1);
        decorator.pyriteGen = new WorldGenMinable(ModBlocks.multiBlock1, 13, 2, ModBlocks.multiBlock1);
        decorator.antHillGen = new WorldGenAntHill(true);
        decorator.sandGen = new WorldGenSand(ModBlocks.sand, 5);
        decorator.coralGen = new WorldGenCoral(true);
    }
}
