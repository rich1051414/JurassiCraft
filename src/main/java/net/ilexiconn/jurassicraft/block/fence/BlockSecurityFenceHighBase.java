package net.ilexiconn.jurassicraft.block.fence;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.ilexiconn.jurassicraft.tile.TileSecurityFenceHighBase;

public class BlockSecurityFenceHighBase extends BlockSecurityFence implements IFenceBase
{
	public BlockSecurityFenceHighBase() 
	{
		this.setHardness(30.0F);
		this.setResistance(450.0F);
		this.setHarvestLevel("pickaxe", 2);
		this.setBlockName("block_High_Security_Fence_Base");
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int metadata) 
	{
		return new TileSecurityFenceHighBase();
	}
}
