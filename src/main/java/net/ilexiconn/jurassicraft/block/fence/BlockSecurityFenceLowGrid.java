package net.ilexiconn.jurassicraft.block.fence;

import java.util.Random;

import net.ilexiconn.jurassicraft.interfaces.IFenceGrid;
import net.ilexiconn.jurassicraft.tile.TileSecurityFenceLowGrid;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class BlockSecurityFenceLowGrid extends BlockSecurityFence implements IFenceGrid
 {
	
    public BlockSecurityFenceLowGrid()
    {
    	super(5.0F, 75.0F, 2, "low_Security_Fence_Grid");
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
		switch (metadata) 
		{
			/** South and North (On/Off) */
			case 0:
			case 2:
			case 4:
			case 6:
				if (world.getBlock(x - 1, y, z) instanceof BlockSecurityFenceLowGrid)
				{
					if (world.getTileEntity(x - 1, y, z) != (TileEntity) null)
						world.removeTileEntity(x - 1, y, z);
					world.setBlockToAir(x - 1, y, z);
				}
				if (world.getBlock(x + 1, y, z) instanceof BlockSecurityFenceLowGrid)
				{
					if (world.getTileEntity(x + 1, y, z) != (TileEntity) null)
						world.removeTileEntity(x + 1, y, z);
					world.setBlockToAir(x + 1, y, z);
				}
				break;
				/** West and East (On/Off) */
			case 1:
			case 3:
			case 5:
			case 7:
				if (world.getBlock(x, y, z + 1) instanceof BlockSecurityFenceLowGrid)
				{
					if (world.getTileEntity(x, y, z + 1) != (TileEntity) null)
						world.removeTileEntity(x, y, z + 1);
					world.setBlockToAir(x, y, z + 1);
				}
				if (world.getBlock(x, y, z - 1) instanceof BlockSecurityFenceLowGrid)
				{
					if (world.getTileEntity(x, y, z - 1) != (TileEntity) null)
						world.removeTileEntity(x, y, z - 1);
					world.setBlockToAir(x, y, z - 1);
				}
				break;
		}
		super.breakBlock(world, x, y, z, block, metadata);
    }

	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) 
	{
		double widthInPixels = 6 * 0.03125D;
		int metadata = world.getBlockMetadata(x, y, z);
		switch (metadata) 
		{
			/** South and North (On/Off) */
			case 0:
			case 2:
			case 4:
			case 6:
				return AxisAlignedBB.getBoundingBox((double) x, (double) y, (double) (z + 0.5D - widthInPixels), (double) (x + 1.0D), (double) (y + 1.0D), (double) (z + 0.5D + widthInPixels));
			/** West and East (On/Off) */
			case 1:
			case 3:
			case 5:
			case 7:
				return AxisAlignedBB.getBoundingBox((double) (x + 0.5D - widthInPixels), (double) y, (double) z, (double) (x + 0.5D + widthInPixels), (double) (y + 1.0D), (double) (z + 1.0D));
			default:
				return AxisAlignedBB.getBoundingBox((double) x, (double) y, (double) z, (double) (x + 1.0D), (double) (y + 1.0D), (double) (z + 1.0D));
		}
	}

    @Override
    public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int x, int y, int z)
    {
        double widthInPixels = 6 * 0.03125D;
        int metadata = world.getBlockMetadata(x, y, z);
		switch (metadata) 
		{
			/** South and North (On/Off) */
			case 0:
			case 2:
			case 4:
			case 6:
	            return AxisAlignedBB.getBoundingBox((double) x, (double) y, (double) (z + 0.5D - widthInPixels), (double) (x + 1.0D), (double) (y + 1.0D), (double) (z + 0.5D + widthInPixels));
			/** West and East (On/Off) */
			case 1:
			case 3:
			case 5:
			case 7:
	            return AxisAlignedBB.getBoundingBox((double) (x + 0.5D - widthInPixels), (double) y, (double) z, (double) (x + 0.5D + widthInPixels), (double) (y + 1.0D), (double) (z + 1.0D));
			default:
		        return AxisAlignedBB.getBoundingBox((double) x, (double) y, (double) z, (double) (x + 1.0D), (double) (y + 1.0D), (double) (z + 1.0D));
		}
    }

    @Override
    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
    {
    	int metadata = world.getBlockMetadata(x, y, z);
    	if (metadata == 4 || metadata == 5 || metadata == 6 || metadata == 7)
    		entity.attackEntityFrom(DamageSource.generic, 4.0F);
    }

    @Override
    public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z)
    {
        return null;
    }

    @Override
    public int quantityDropped(Random rand)
    {
        return 0;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int metadata)
    {
        return new TileSecurityFenceLowGrid();
    }
}
