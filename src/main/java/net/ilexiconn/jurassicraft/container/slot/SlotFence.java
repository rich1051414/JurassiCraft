package net.ilexiconn.jurassicraft.container.slot;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemRedstone;
import net.minecraft.item.ItemStack;

public class SlotFence extends Slot
{

    public SlotFence(IInventory inventory, int number, int x, int y)
    {
        super(inventory, number, x, y);
    }

    @Override
    public int getSlotStackLimit()
    {
        return 64;
    }

    @Override
    public boolean isItemValid(ItemStack itemstack)
    {
        return itemstack.getItem() instanceof ItemRedstone || itemstack.getItem().getUnlocalizedName().equals("item.ingotIron");
    }
}