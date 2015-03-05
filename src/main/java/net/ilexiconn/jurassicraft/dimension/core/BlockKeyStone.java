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
	public void onBlockAdded(World world, int x, int y, int z)
	{
		if ((world.getBlock(x, y - 1, z) != Blocks.stonebrick) || (!((BlockDinoPortal) ModBlocks.dinoPortal).tryToCreatePortal(world, x, y, z)))
		{
			if ((!world.doesBlockHaveSolidTopSurface(world, x, y - 1, z)))
			{
				world.setBlockToAir(x, y, z);
			}
			else
			{
				world.scheduleBlockUpdate(x, y, z, this, tickRate(world) + world.rand.nextInt(10));
			}
		}
	}
}