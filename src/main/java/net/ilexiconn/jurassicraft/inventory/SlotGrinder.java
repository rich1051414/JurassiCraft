package net.ilexiconn.jurassicraft.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotGrinder extends Slot
{
    /** The player that is using the GUI where this slot resides. */
    private EntityPlayer thePlayer;
    
    public SlotGrinder(EntityPlayer player, IInventory inventory, int par3, int par4, int par5)
    {
        super(inventory, par3, par4, par5);
        this.thePlayer = player;
    }
    
    @Override
    public boolean isItemValid(ItemStack par1ItemStack)
    {
        return false;
    }
    
    @Override
    public ItemStack decrStackSize(int slot)
    {
        return super.decrStackSize(slot);
    }
    
    @Override
    public void onPickupFromSlot(EntityPlayer player, ItemStack stack)
    {
        this.onCrafting(stack);
        
        super.onPickupFromSlot(player, stack);
    }
}
