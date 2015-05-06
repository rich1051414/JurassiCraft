package net.ilexiconn.jurassicraft.container;

import net.ilexiconn.jurassicraft.container.slot.SlotFence;
import net.ilexiconn.jurassicraft.tile.fence.TileSecurityFenceLowCorner;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemRedstone;
import net.minecraft.item.ItemStack;

public class ContainerSecurityFenceLow extends Container
{
    private TileSecurityFenceLowCorner fence;
    
    public ContainerSecurityFenceLow(InventoryPlayer playerInventory, TileSecurityFenceLowCorner tileEntity)
    {
        this.fence = tileEntity;
        
        this.addSlotToContainer(new SlotFence(this.fence, 0, 128, 43));
        this.addSlotToContainer(new SlotFence(this.fence, 1, 146, 43));
        this.addSlotToContainer(new SlotFence(this.fence, 2, 164, 43));
        this.addSlotToContainer(new SlotFence(this.fence, 3, 182, 43));
        this.addSlotToContainer(new SlotFence(this.fence, 4, 200, 43));
        this.addSlotToContainer(new SlotFence(this.fence, 5, 218, 43));
        
        for (int i = 0; i < 3; i++)
        {
            for (int k = 0; k < 9; k++)
            {
                this.addSlotToContainer(new Slot(playerInventory, k + i * 9 + 9, 48 + k * 18, 174 + i * 18));
            }
        }
        
        for (int i = 0; i < 9; i++)
        {
            this.addSlotToContainer(new Slot(playerInventory, i, 48 + i * 18, 232));
        }
    }
    
    @Override
    public void onContainerClosed(EntityPlayer player)
    {
        super.onContainerClosed(player);
        if (!player.worldObj.isRemote)
        {
            this.fence.closeInventory();
        }
    }
    
    @Override
    public boolean canInteractWith(EntityPlayer player)
    {
        return this.fence.isUseableByPlayer(player);
    }
    
    @Override
    public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int i)
    {
        if (!entityPlayer.worldObj.isRemote)
        {
            Slot slot = (Slot) inventorySlots.get(i);
            ItemStack stackFinal = null;
            if (slot != null && slot.getHasStack())
            {
                ItemStack stackInSlot = slot.getStack();
                stackFinal = stackInSlot.copy();
                if (i < 6)
                {
                    if (!mergeItemStack(stackInSlot, 9, inventorySlots.size(), true))
                    {
                        return null;
                    }
                    slot.onSlotChange(stackInSlot, stackFinal);
                }
                else if (i >= 6)
                {
                    if (stackInSlot.getItem().getUnlocalizedName().equals("item.ingotIron") || stackInSlot.getItem() instanceof ItemRedstone)
                    {
                        if (!mergeItemStack(stackInSlot, 0, 6, false))
                        {
                            return null;
                        }
                    }
                    else
                    {
                        return null;
                    }
                }
                else
                {
                    return null;
                }
                if (stackInSlot.stackSize == 0)
                {
                    slot.putStack((ItemStack) null);
                }
                else
                {
                    slot.onSlotChanged();
                }
                return stackFinal;
            }
            return null;
        }
        return null;
    }
}