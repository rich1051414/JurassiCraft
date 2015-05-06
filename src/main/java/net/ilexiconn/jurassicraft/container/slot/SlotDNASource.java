package net.ilexiconn.jurassicraft.container.slot;

import net.ilexiconn.jurassicraft.interfaces.IDNASource;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotDNASource extends Slot
{

    public SlotDNASource(IInventory inventory, int number, int x, int y)
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
        return (itemstack.getItem() instanceof IDNASource);
    }
}