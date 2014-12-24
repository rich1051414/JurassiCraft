package net.ilexiconn.jurassicraft.item;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

/** Not working */
public class JurassiCraftCraftingHandler 
{
	@SubscribeEvent
	public void onCrafting(ItemCraftedEvent event) 
	{
		final IInventory craftMatrix = null;
		for (int i = 0; i < event.craftMatrix.getSizeInventory(); i++) 
		{
			if (event.craftMatrix.getStackInSlot(i) != null) 
			{
				ItemStack item0 = event.craftMatrix.getStackInSlot(i);
				if (item0 != (ItemStack) null && item0.getItem() == Items.iron_pickaxe) 
				{
					ItemStack pickaxe = new ItemStack(Items.iron_pickaxe, 1, (item0.getItemDamage() + 1));
					if (pickaxe.getItemDamage() >= pickaxe.getMaxDamage()) 
					{
						pickaxe.stackSize--;
						if (pickaxe.stackSize <= 0) 
						{
							pickaxe = (ItemStack) null;
						}
					}
					event.craftMatrix.setInventorySlotContents(i, pickaxe);
				}
			}
		}
	}
}
