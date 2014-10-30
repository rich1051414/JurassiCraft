package to.uk.ilexiconn.jurassicraft.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import to.uk.ilexiconn.jurassicraft.ModBlocks;
import to.uk.ilexiconn.jurassicraft.ModCreativeTabs;
import to.uk.ilexiconn.jurassicraft.Util;

public class ItemDinoPad extends Item
{
    public ItemDinoPad()
    {
        super();
        setUnlocalizedName("dinopad");
        setTextureName(Util.getModId() + "dinopad");
        setCreativeTab(ModCreativeTabs.ITEMS.getTab());
    }

	@Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float clickX, float clickY, float clickZ)
	{
		if (side == 0) 
		{
			--y;
		}

		if (side == 1) 
		{
			++y;
		}

		if (side == 2) 
		{
			--z;
		}

		if (side == 3) 
		{
			++z;
		}

		if (side == 4) 
		{
			--x;
		}

		if (side == 5) 
		{
			++x;
		}

		if (!player.canPlayerEdit(x, y, z, side, stack) || !player.isSneaking()) 
		{
			return false;
		} 
		else 
		{
			if (!world.isAirBlock(x, y - 1, z) && world.isAirBlock(x, y, z) && player.getHeldItem().getItem() instanceof ItemDinoPad) 
			{
				if (!player.capabilities.isCreativeMode) {
					player.getHeldItem().stackSize--;
					if (player.getHeldItem().stackSize <= 0) {
						player.inventory.setInventorySlotContents(player.inventory.currentItem, (ItemStack) null);
					}
				}
	        	world.setBlock(x, y, z, ModBlocks.dinoPad);
	        	world.playSoundEffect((double) x + 0.5D, (double) y + 0.5D, (double) z + 0.5D, "step.stone", 1.0F, itemRand.nextFloat() * 0.4F + 0.8F);
		        int metadata = MathHelper.floor_double((double) (player.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
		        if (metadata == 0)
		        {
		            world.setBlockMetadataWithNotify(x, y, z, 0, 2);
		        }
		        else if (metadata == 1)
		        {
		            world.setBlockMetadataWithNotify(x, y, z, 1, 2);
		        }
		        else if (metadata == 2)
		        {
		            world.setBlockMetadataWithNotify(x, y, z, 2, 2);
		        }
		        else if (metadata == 3)
		        {
		            world.setBlockMetadataWithNotify(x, y, z, 3, 2);
		        }
			}
			return true;
		}
	}
}
