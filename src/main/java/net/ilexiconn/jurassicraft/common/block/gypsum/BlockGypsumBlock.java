package net.ilexiconn.jurassicraft.common.block.gypsum;

import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.common.block.ModBlocks;
import net.ilexiconn.jurassicraft.common.creativetab.ModCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

import java.util.Random;

public class BlockGypsumBlock extends Block
{
    public BlockGypsumBlock()
    {
        super(Material.rock);
        this.setHardness(1.5f);
        this.setResistance(3.0f);
        setBlockName("block_Gypsum_Block");
        this.setStepSound(soundTypeStone);
        this.setHarvestLevel("pickaxe", 1);
        setCreativeTab(ModCreativeTabs.blocks);
        setBlockTextureName(JurassiCraft.getModId() + "gypsum");
    }

    public Item getItemDropped(int id, Random random, int metadata)
    {
        return Item.getItemFromBlock(ModBlocks.gypsumCobblestone);
    }
}
