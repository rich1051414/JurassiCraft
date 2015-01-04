package net.ilexiconn.jurassicraft.container;

import net.ilexiconn.jurassicraft.tile.TileSecurityFence;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemRedstone;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class ContainerSecurityFence extends Container
{

    private TileSecurityFence fence;

    public ContainerSecurityFence(InventoryPlayer playerInventory, TileEntity tileEntity)
    {
        this.fence = (TileSecurityFence) tileEntity;
        this.addSlotToContainer(new Slot(this.fence, 0, 159, 47));
        this.addSlotToContainer(new Slot(this.fence, 1, 193, 47));

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
                if (i < 2)
                {
                    if (!mergeItemStack(stackInSlot, 9, inventorySlots.size(), true))
                    {
                        return null;
                    }
                    slot.onSlotChange(stackInSlot, stackFinal);
                }
                else if (i >= 2)
                {
                    if (stackInSlot.getItem().getUnlocalizedName().equals("item.ingotIron"))
                    {
                        if (!mergeItemStack(stackInSlot, 0, 1, false))
                        {
                            return null;
                        }
                    }
                    else if (stackInSlot.getItem() instanceof ItemRedstone)
                    {
                        if (!mergeItemStack(stackInSlot, 1, 2, false))
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