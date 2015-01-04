package net.ilexiconn.jurassicraft.block.fence;

import net.ilexiconn.jurassicraft.tile.TileSecurityFenceMediumGrid;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class BlockSecurityFenceMediumGrid extends BlockSecurityFence implements IFenceGrid
{
    public BlockSecurityFenceMediumGrid()
    {
        this.setHardness(10.0F);
        this.setResistance(150.0F);
        this.setHarvestLevel("pickaxe", 2);
        this.setBlockName("block_Medium_Security_Fence_Grid");
    }

    @Override
    public void breakBlock(World world, int x, int y, int z, Block block, int direction)
    {
        switch (direction)
        {
            case 0:
            case 2:
                if (world.getBlock(x - 1, y, z) instanceof BlockSecurityFenceMediumGrid)
                {
                    if (world.getTileEntity(x - 1, y, z) != (TileEntity) null) world.removeTileEntity(x - 1, y, z);
                    world.setBlockToAir(x - 1, y, z);
                }
                if (world.getBlock(x + 1, y, z) instanceof BlockSecurityFenceMediumGrid)
                {
                    if (world.getTileEntity(x + 1, y, z) != (TileEntity) null) world.removeTileEntity(x + 1, y, z);
                    world.setBlockToAir(x + 1, y, z);
                }
                break;
            case 1:
            case 3:
                if (world.getBlock(x, y, z + 1) instanceof BlockSecurityFenceMediumGrid)
                {
                    if (world.getTileEntity(x, y, z + 1) != (TileEntity) null) world.removeTileEntity(x, y, z + 1);
                    world.setBlockToAir(x, y, z + 1);
                }
                if (world.getBlock(x, y, z - 1) instanceof BlockSecurityFenceMediumGrid)
                {
                    if (world.getTileEntity(x, y, z - 1) != (TileEntity) null) world.removeTileEntity(x, y, z - 1);
                    world.setBlockToAir(x, y, z - 1);
                }
                break;
        }
        super.breakBlock(world, x, y, z, block, direction);
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
    {
        int widthInPixels = 6;
        int direction = world.getBlockMetadata(x, y, z);
        if (direction == 0 || direction == 2)
        {
            return AxisAlignedBB.getBoundingBox((double) x, (double) y, (double) (z + 0.5D - widthInPixels * 0.03125D), (double) (x + 1.0D), (double) (y + 1.0D), (double) (z + 0.5D + widthInPixels * 0.03125D));
        }
        else if (direction == 1 || direction == 3)
        {
            return AxisAlignedBB.getBoundingBox((double) (x + 0.5D - widthInPixels * 0.03125D), (double) y, (double) z, (double) (x + 0.5D + widthInPixels * 0.03125D), (double) (y + 1.0D), (double) (z + 1.0D));
        }
        else
        {
            return AxisAlignedBB.getBoundingBox((double) x, (double) y, (double) z, (double) (x + 1.0D), (double) (y + 1.0D), (double) (z + 1.0D));
        }
    }

    @Override
    public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int x, int y, int z)
    {
        int widthInPixels = 6;
        int direction = world.getBlockMetadata(x, y, z);
        if (direction == 0 || direction == 2)
        {
            return AxisAlignedBB.getBoundingBox((double) x, (double) y, (double) (z + 0.5D - widthInPixels * 0.03125D), (double) (x + 1.0D), (double) (y + 1.0D), (double) (z + 0.5D + widthInPixels * 0.03125D));
        }
        else if (direction == 1 || direction == 3)
        {
            return AxisAlignedBB.getBoundingBox((double) (x + 0.5D - widthInPixels * 0.03125D), (double) y, (double) z, (double) (x + 0.5D + widthInPixels * 0.03125D), (double) (y + 1.0D), (double) (z + 1.0D));
        }
        else
        {
            return AxisAlignedBB.getBoundingBox((double) x, (double) y, (double) z, (double) (x + 1.0D), (double) (y + 1.0D), (double) (z + 1.0D));
        }
    }

    @Override
    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
    {
        entity.attackEntityFrom(DamageSource.generic, 8.0F);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int metadata)
    {
        return new TileSecurityFenceMediumGrid();
    }
}
