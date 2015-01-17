package net.ilexiconn.jurassicraft.block.fence;

import net.ilexiconn.jurassicraft.ModBlocks;
import net.ilexiconn.jurassicraft.ModCreativeTabs;
import net.ilexiconn.jurassicraft.interfaces.IFenceGrid;
import net.ilexiconn.jurassicraft.interfaces.IFencePole;
import net.ilexiconn.jurassicraft.tile.TileSecurityFenceLowPole;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockSecurityFenceLowPole extends BlockSecurityFence implements IFencePole
{
	
	public BlockSecurityFenceLowPole()
	{
		super(7.5F, 112.5F, 2, "block_Low_Security_Fence_Pole");
		this.setBlockBounds(0.3F, 0.0F, 0.3F, 0.7F, 1.0F, 0.7F);
        this.setCreativeTab(ModCreativeTabs.blocks);
	}

    @Override
    public int getRenderType()
    {
        return -1;
    }

    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }

	@Override
	public void breakBlock(World world, int x, int y, int z, Block block, int metadata)
	{
		if (world.getBlock(x, y + 1, z) instanceof IFencePole)
		{
			if (world.getTileEntity(x, y + 1, z) != (TileEntity) null)
				world.removeTileEntity(x, y + 1, z);
			world.setBlockToAir(x, y + 1, z);
		}
		if (world.getBlock(x, y, z + 1) instanceof IFenceGrid)
		{
			if (world.getTileEntity(x, y, z + 1) != (TileEntity) null)
				world.removeTileEntity(x, y, z + 1);
			world.setBlockToAir(x, y, z + 1);
		}
		if (world.getBlock(x - 1, y, z) instanceof IFenceGrid)
		{
			if (world.getTileEntity(x - 1, y, z) != (TileEntity) null)
				world.removeTileEntity(x - 1, y, z);
			world.setBlockToAir(x - 1, y, z);
		}
		if (world.getBlock(x, y, z - 1) instanceof IFenceGrid)
		{
			if (world.getTileEntity(x, y, z - 1) != (TileEntity) null)
				world.removeTileEntity(x, y, z - 1);
			world.setBlockToAir(x, y, z - 1);
		}
		if (world.getBlock(x + 1, y, z) instanceof IFenceGrid)
		{
			if (world.getTileEntity(x + 1, y, z) != (TileEntity) null)
				world.removeTileEntity(x + 1, y, z);
			world.setBlockToAir(x + 1, y, z);
		}
		super.breakBlock(world, x, y, z, block, metadata);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int metadata)
	{
		return new TileSecurityFenceLowPole();
	}
}
