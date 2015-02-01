package net.ilexiconn.jurassicraft.dimension.core;

import net.ilexiconn.jurassicraft.ModBlocks;
import net.ilexiconn.jurassicraft.ModCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class BlockKeyStone extends Block
{
public BlockKeyStone()
{
         super(Material.rock);
         this.setCreativeTab(ModCreativeTabs.blocks);
}
/**
 * Called whenever the block is added into the world. Args: world, x, y, z
 */
public void onBlockAdded(World par1World, int par2, int par3, int par4)
{
	if ((par1World.getBlock(par2, par3 - 1, par4) != Blocks.stonebrick) || (!((BlockDinoPortal) ModBlocks.DinoPortal).tryToCreatePortal(par1World, par2, par3, par4)))
	{
	if ((!par1World.doesBlockHaveSolidTopSurface(par1World, par2, par3 - 1, par4)))
	{
	par1World.setBlockToAir(par2, par3, par4);
	}
	else
	{
	par1World.scheduleBlockUpdate(par2, par3, par4, this, tickRate(par1World) + par1World.rand.nextInt(10));
	}
	}
}
}