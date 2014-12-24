package net.ilexiconn.jurassicraft.block.fence;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.ilexiconn.jurassicraft.tile.TileSecurityFenceMediumPole;


public class BlockSecurityFenceMediumPole extends BlockSecurityFence implements IFencePole
{
	public BlockSecurityFenceMediumPole() 
	{
		this.setHardness(15.0F);
		this.setResistance(200.0F);
		this.setHarvestLevel("pickaxe", 2);
		this.setBlockName("block_Medium_Security_Fence_Pole");
		this.setBlockBounds(0.3F, 0.0F, 0.3F, 0.7F, 1.0F, 0.7F);
	}

	@Override
	public void breakBlock(World world, int x, int y, int z, Block block, int metadata) 
	{
		if (metadata != 4) 
		{
			if (world.getBlock(x, y + 1, z) instanceof BlockSecurityFenceMediumPole) 
			{
				if (world.getTileEntity(x, y + 1, z) != (TileEntity) null)
					world.removeTileEntity(x, y + 1, z);
				world.setBlockToAir(x, y + 1, z);
			}
			if (world.getBlock(x, y, z + 1) instanceof BlockSecurityFenceMediumGrid) 
			{
				if (world.getTileEntity(x, y, z + 1) != (TileEntity) null)
					world.removeTileEntity(x, y, z + 1);
				world.setBlockToAir(x, y, z + 1);
			}
			if (world.getBlock(x - 1, y, z) instanceof BlockSecurityFenceMediumGrid) 
			{
				if (world.getTileEntity(x - 1, y, z) != (TileEntity) null)
					world.removeTileEntity(x - 1, y, z);
				world.setBlockToAir(x - 1, y, z);
			}
			if (world.getBlock(x, y, z - 1) instanceof BlockSecurityFenceMediumGrid) 
			{
				if (world.getTileEntity(x, y, z - 1) != (TileEntity) null)
					world.removeTileEntity(x, y, z - 1);
				world.setBlockToAir(x, y, z - 1);
			}
			if (world.getBlock(x + 1, y, z) instanceof BlockSecurityFenceMediumGrid) 
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
		return new TileSecurityFenceMediumPole();
	}
}
