package net.ilexiconn.jurassicraft.block.fence;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.ilexiconn.jurassicraft.tile.TileSecurityFenceHighPole;

public class BlockSecurityFenceHighPole extends BlockSecurityFence implements IFencePole
{
	public BlockSecurityFenceHighPole() 
	{
		this.setHardness(40.0F);
		this.setResistance(600.0F);
		this.setHarvestLevel("pickaxe", 2);
		this.setBlockName("block_High_Security_Fence_Pole");
		this.setBlockBounds(0.3F, 0.0F, 0.3F, 0.7F, 1.0F, 0.7F);
	}

	@Override
	public void breakBlock(World world, int x, int y, int z, Block block, int metadata) 
	{
		if (metadata != 4) 
		{
			if (world.getBlock(x, y + 1, z) instanceof BlockSecurityFenceHighPole) 
			{
				if (world.getTileEntity(x, y + 1, z) != (TileEntity) null)
					world.removeTileEntity(x, y + 1, z);
				world.setBlockToAir(x, y + 1, z);
			}
			if (world.getBlock(x, y, z + 1) instanceof BlockSecurityFenceHighGrid) 
			{
				if (world.getTileEntity(x, y, z + 1) != (TileEntity) null)
					world.removeTileEntity(x, y, z + 1);
				world.setBlockToAir(x, y, z + 1);
			}
			if (world.getBlock(x - 1, y, z) instanceof BlockSecurityFenceHighGrid) 
			{
				if (world.getTileEntity(x - 1, y, z) != (TileEntity) null)
					world.removeTileEntity(x - 1, y, z);
				world.setBlockToAir(x - 1, y, z);
			}
			if (world.getBlock(x, y, z - 1) instanceof BlockSecurityFenceHighGrid) 
			{
				if (world.getTileEntity(x, y, z - 1) != (TileEntity) null)
					world.removeTileEntity(x, y, z - 1);
				world.setBlockToAir(x, y, z - 1);
			}
			if (world.getBlock(x + 1, y, z) instanceof BlockSecurityFenceHighGrid) 
			{
				if (world.getTileEntity(x + 1, y, z) != (TileEntity) null)
					world.removeTileEntity(x + 1, y, z);
				world.setBlockToAir(x + 1, y, z);
			}
		}
		super.breakBlock(world, x, y, z, block, metadata);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int metadata) 
	{
		return new TileSecurityFenceHighPole();
	}
}
