package net.ilexiconn.jurassicraft.block.fence;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.ilexiconn.jurassicraft.tile.TileSecurityFenceLowBase;


public class BlockSecurityFenceLowBase extends BlockSecurityFence implements IFenceBase
{
	public BlockSecurityFenceLowBase() 
	{
		this.setHardness(10.0F);
		this.setResistance(150.0F);
		this.setHarvestLevel("pickaxe", 2);
		this.setBlockName("block_Low_Security_Fence_Base");
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int metadata) 
	{
		return new TileSecurityFenceLowBase();
	}
}
