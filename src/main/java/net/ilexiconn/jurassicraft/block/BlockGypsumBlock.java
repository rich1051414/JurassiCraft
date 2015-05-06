package net.ilexiconn.jurassicraft.block;

import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.ModBlocks;
import net.ilexiconn.jurassicraft.ModCreativeTabs;
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
        setBlockTextureName(JurassiCraft.getModId() + "block_Gypsum_Block");
    }
    
    @Override
    public Item getItemDropped(int id, Random random, int metadata)
    {
        return Item.getItemFromBlock(ModBlocks.gypsumCobblestone);
    }
}
