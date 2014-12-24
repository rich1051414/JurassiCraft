package net.ilexiconn.jurassicraft.block.fence;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.ModCreativeTabs;
import net.ilexiconn.jurassicraft.Util;
import net.ilexiconn.jurassicraft.tile.TileSecurityFence;

public class BlockSecurityFenceMain extends BlockContainer
{
	public BlockSecurityFenceMain() 
	{
		super(Material.iron);
		this.setHardness(5.0F);
		this.setResistance(10.0F);
		this.setBlockName("security_Fence_Main");
		this.setBlockTextureName(Util.getModId() + "security_Fence_Main");
        this.setCreativeTab(ModCreativeTabs.blocks);
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) 
	{
		if (world.isRemote) 
		{
			return true;
		} 
		else if (!player.isSneaking()) 
		{
			player.openGui(JurassiCraft.instance, 0, world, x, y, z);
			return true;
		}
		return false;
	}

	@Override
	public void breakBlock(World world, int x, int y, int z, Block block, int metadata) 
	{
		TileEntity tileEntity = world.getTileEntity(x, y, z);
		if (tileEntity instanceof TileSecurityFence) 
		{
			TileSecurityFence tileFence = (TileSecurityFence) tileEntity;
			if (tileFence.hasItems()) 
			{
				for (int i = 0; i < tileFence.getSizeInventory(); i++) 
				{
					ItemStack itemstack = tileFence.getStackInSlot(i);
					if (itemstack != null) 
					{
						float f = world.rand.nextFloat() * 0.8F + 0.1F;
						float f1 = world.rand.nextFloat() * 0.8F + 0.1F;
						float f2 = world.rand.nextFloat() * 0.8F + 0.1F;
						while (itemstack.stackSize > 0) 
						{
							int j = world.rand.nextInt(21) + 10;
							if (j > itemstack.stackSize) 
							{
								j = itemstack.stackSize;
							}
							itemstack.stackSize -= j;
							EntityItem item = new EntityItem(world, (double) ((float) x + f), (double) ((float) y + f1), (double) ((float) z + f2), new ItemStack(itemstack.getItem(), j, itemstack.getItemDamage()));
							if (itemstack.hasTagCompound()) 
							{
								item.getEntityItem().setTagCompound((NBTTagCompound) itemstack.getTagCompound().copy());
							}
							world.spawnEntityInWorld(item);
						}
					}
				}
				world.func_147453_f(x, y, z, block);
			}
			int maxSecurityLevel = 0;
			for (int direction = 0; direction < 4; direction++) 
			{
				if (maxSecurityLevel < tileFence.getSecurityLevel(direction)) 
				{
					maxSecurityLevel = tileFence.getSecurityLevel(direction);
				}
			}
			int fenceHeight = tileFence.getHeightPlanned(maxSecurityLevel) + 1;
			for (int height = 1; height < fenceHeight; height++) 
			{
				if (world.getBlock(x, y + height, z) instanceof IFencePole) 
				{
					if (world.getTileEntity(x, y + height, z) != (TileEntity) null)
						world.removeTileEntity(x, y + height, z);
					world.setBlockToAir(x, y + height, z);
				}
			}
			for (int direction = 0; direction < 4; direction++) 
			{
				if (tileFence.isFenceBuilt(direction)) {
					int fenceLength = tileFence.calculateDistanceToNextPole(direction);
					TileSecurityFence nextFence = tileFence.getNextFence(tileFence, direction, fenceLength);
					switch (direction) 
					{
						case 0:
							if (nextFence instanceof TileSecurityFence)
							nextFence.setSecurityLevel((byte) 0, 2);
							for (int distance = 0; distance < fenceLength; distance++) 
							{
								if (world.getBlock(x, y, z + distance) instanceof IFenceBase) 
								{
									if (world.getTileEntity(x, y, z + distance) != (TileEntity) null)
										world.removeTileEntity(x, y, z + distance);
									world.setBlockToAir(x, y, z + distance);
								}
							}
							break;
						case 1:
							if (nextFence instanceof TileSecurityFence)
							nextFence.setSecurityLevel((byte) 0, 3);
							for (int distance = 0; distance < fenceLength; distance++) 
							{
								if (world.getBlock(x - distance, y, z) instanceof IFenceBase) 
								{
									if (world.getTileEntity(x - distance, y, z) != (TileEntity) null)
										world.removeTileEntity(x - distance, y, z);
									world.setBlockToAir(x - distance, y, z);
								}
							}
							break;
						case 2:
							if (nextFence instanceof TileSecurityFence)
							nextFence.setSecurityLevel((byte) 0, 0);
							for (int distance = 0; distance < fenceLength; distance++) 
							{
								if (world.getBlock(x, y, z - distance) instanceof IFenceBase) 
								{
									if (world.getTileEntity(x, y, z - distance) != (TileEntity) null)
										world.removeTileEntity(x, y, z - distance);
									world.setBlockToAir(x, y, z - distance);
								}
							}
							break;
						case 3:
							if (nextFence instanceof TileSecurityFence)
							nextFence.setSecurityLevel((byte) 0, 1);
							for (int distance = 0; distance < fenceLength; distance++) 
							{
								if (world.getBlock(x + distance, y, z) instanceof IFenceBase) 
								{
									if (world.getTileEntity(x + distance, y, z) != (TileEntity) null)
										world.removeTileEntity(x + distance, y, z);
									world.setBlockToAir(x + distance, y, z);
								}
							}
							break;
					}
					world.markBlockForUpdate(nextFence.xCoord, nextFence.yCoord, nextFence.zCoord);
				}
			}
		}
		super.breakBlock(world, x, y, z, block, metadata);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int metadata) 
	{
		try 
		{
			return new TileSecurityFence();
		} 
		catch (Exception e) 
		{
			throw new RuntimeException(e);
		}
	}
}
