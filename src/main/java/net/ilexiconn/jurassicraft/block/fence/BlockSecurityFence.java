package net.ilexiconn.jurassicraft.block.fence;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.ilexiconn.jurassicraft.Util;

import java.util.Random;

public class BlockSecurityFence extends Block implements ITileEntityProvider
{
	public BlockSecurityFence() 
	{
		super(Material.iron);
		this.setStepSound(soundTypeMetal);
		this.setBlockTextureName(Util.getModId() + "block_Security_Fence_Breaking_Particles");
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack itemStack) 
	{
		int direction = MathHelper.floor_double((double) (entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
		/** South */
		if (direction == 0) 
		{
			world.setBlockMetadataWithNotify(x, y, z, 0, 2);
		}
		/** West */
		else if (direction == 1) 
		{
			world.setBlockMetadataWithNotify(x, y, z, 1, 2);
		}
		/** North */
		else if (direction == 2) 
		{
			world.setBlockMetadataWithNotify(x, y, z, 2, 2);
		}
		/** East */
		else if (direction == 3) 
		{
			world.setBlockMetadataWithNotify(x, y, z, 3, 2);
		}
	}

	public int quantityDropped(Random rand) 
	{
		return 0;
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
	public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) 
	{
		return null;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int metadata) 
	{
		return null;
	}
}
