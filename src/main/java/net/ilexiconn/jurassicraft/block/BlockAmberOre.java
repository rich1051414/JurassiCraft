package net.ilexiconn.jurassicraft.block;

import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.ModCreativeTabs;
import net.ilexiconn.jurassicraft.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.Random;

public class BlockAmberOre extends Block
{
    public BlockAmberOre()
    {
        super(Material.rock);
        setBlockName("amber_ore");
        setBlockTextureName(JurassiCraft.getModId() + "amber_ore");
        setHardness(3.0F);
        setResistance(5.0F);
        setStepSound(Block.soundTypeStone);
        setHarvestLevel("pickaxe", 2);
        setCreativeTab(ModCreativeTabs.jcBlocks);
    }
    
    public Item getItemDropped(int value, Random random, int thing)
    {
        return ModItems.amber;
    }
}
