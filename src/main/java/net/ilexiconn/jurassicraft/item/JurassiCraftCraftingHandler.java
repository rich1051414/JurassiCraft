package net.ilexiconn.jurassicraft.item;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

/**
 * Not working
 */
public class JurassiCraftCraftingHandler
{
    @SubscribeEvent
    public void onCrafting(ItemCraftedEvent event)
    {
        final IInventory craftMatrix = null;
        
        IInventory matrix = event.craftMatrix;
      
        for (int slot = 0; slot < matrix.getSizeInventory(); slot++)
        {
            if (matrix.getStackInSlot(slot) != null)
            {
                ItemStack stack = matrix.getStackInSlot(slot);
              
                if (stack != (ItemStack) null && stack.getItem() == Items.iron_pickaxe)
                {
                    ItemStack pickaxe = new ItemStack(Items.iron_pickaxe, 1, (stack.getItemDamage() + 1));
                  
                    if (pickaxe.getItemDamage() >= pickaxe.getMaxDamage())
                    {
                        pickaxe.stackSize--;
                     
                        if (pickaxe.stackSize <= 0)
                        {
                            pickaxe = (ItemStack) null;
                        }
                    }
                    
                    matrix.setInventorySlotContents(slot, pickaxe);
                }
            }
        }
    }
}
