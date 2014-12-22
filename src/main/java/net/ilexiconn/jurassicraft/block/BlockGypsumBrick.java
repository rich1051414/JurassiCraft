package net.ilexiconn.jurassicraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.ilexiconn.jurassicraft.ModCreativeTabs;
import net.ilexiconn.jurassicraft.Util;

public class BlockGypsumBrick extends Block {
	
	public BlockGypsumBrick() {
		super(Material.rock);
		this.setHardness(2.0f);
		this.setResistance(5.0f);
        setBlockName("block_Gypsum_Brick");
		this.setStepSound(soundTypeStone);
		this.setHarvestLevel("pickaxe", 1);
        setCreativeTab(ModCreativeTabs.blocks);
        setBlockTextureName(Util.getModId() + "block_Gypsum_Brick");
	}
}
