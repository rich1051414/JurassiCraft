package net.ilexiconn.jurassicraft.common.block.gypsum;

import net.ilexiconn.jurassicraft.common.JurassiCraft;
import net.ilexiconn.jurassicraft.common.creativetab.ModCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockGypsumBrick extends Block
{
    public BlockGypsumBrick()
    {
        super(Material.rock);
        this.setHardness(2.0f);
        this.setResistance(5.0f);
        setBlockName("block_Gypsum_Brick");
        this.setStepSound(soundTypeStone);
        this.setHarvestLevel("pickaxe", 1);
        setCreativeTab(ModCreativeTabs.blocks);
        setBlockTextureName(JurassiCraft.getModId() + "gypsum_brick");
    }
}
