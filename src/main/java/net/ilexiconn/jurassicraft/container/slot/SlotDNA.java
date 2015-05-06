package net.ilexiconn.jurassicraft.container.slot;

import net.ilexiconn.jurassicraft.item.ItemDNA;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotDNA extends Slot
{
    public SlotDNA(IInventory inventory, int x, int y, int z)
    {
        super(inventory, x, y, z);
    }
    
    public boolean isItemValid(ItemStack itemStack)
    {
        return itemStack.getItem() instanceof ItemDNA;
    }
}
