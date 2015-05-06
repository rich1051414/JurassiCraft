package net.ilexiconn.jurassicraft.container.slot;

import net.ilexiconn.jurassicraft.interfaces.IDNASample;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotDNASample extends Slot
{

    public SlotDNASample(IInventory inventory, int number, int x, int y)
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
        return (itemstack.getItem() instanceof IDNASample);
    }
}