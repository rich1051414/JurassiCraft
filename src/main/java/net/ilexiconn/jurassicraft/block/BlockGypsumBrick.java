package net.ilexiconn.jurassicraft.block;

import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.ModCreativeTabs;
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
        setCreativeTab(ModCreativeTabs.jcBlocks);
        setBlockTextureName(JurassiCraft.getModId() + "block_Gypsum_Brick");
    }
}
