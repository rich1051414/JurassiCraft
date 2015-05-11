package net.ilexiconn.jurassicraft.common.tileentity;

import net.ilexiconn.jurassicraft.common.item.JurassiCraftDNAHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileDNACombinator extends TileEntity implements ISidedInventory
{

    private static final short combinationSpeed = 100;
    private ItemStack[] slots = new ItemStack[3];
    private short combinationTime;

    public TileDNACombinator()
    {
        this.combinationTime = 0;
    }

    public short getCombinationTime()
    {
        return combinationTime;
    }

    public void setCombinationTime(short time)
    {
        this.combinationTime = time;
    }

    public short getCombinationSpeed()
    {
        return combinationSpeed;
    }

    public int getCombinationProgressScaled(int i)
    {
        return (this.getCombinationTime() * i) / this.getCombinationSpeed();
    }

    public boolean isCombining()
    {
        return (this.getCombinationTime() > 0);
    }

    private boolean canCombine()
    {
        if (this.slots[0] == null || this.slots[1] == null)
        {
            return false;
        }
        else if (this.slots[0].getItem() != this.slots[1].getItem())
        {
            return false;
        }
        else if (!slots[0].hasTagCompound() || !slots[1].hasTagCompound())
        {
            return false;
        }
        else if (!slots[0].getTagCompound().hasKey("Quality") || !slots[1].getTagCompound().hasKey("Quality") || !slots[0].getTagCompound().hasKey("DNA") || !slots[1].getTagCompound().hasKey("DNA"))
        {
            return false;
        }
        else if (slots[0].getTagCompound().getInteger("Quality") + slots[1].getTagCompound().getInteger("Quality") > 100)
        {
            return false;
        }
        return (this.slots[2] == null || (this.slots[0].getItem() == this.slots[2].getItem() && (slots[0].getTagCompound().getInteger("Quality") + slots[1].getTagCompound().getInteger("Quality") == slots[2].getTagCompound().getInteger("Quality")))) ? true : false;
    }

    private void combineDNA()
    {
        ItemStack combinedDNA = new ItemStack(slots[0].getItem());
        NBTTagCompound compound = new NBTTagCompound();
        compound.setInteger("Quality", slots[0].getTagCompound().getInteger("Quality") + slots[1].getTagCompound().getInteger("Quality"));
        compound.setString("DNA", JurassiCraftDNAHandler.mixTwoDNAs(slots[0].getTagCompound().getString("DNA"), slots[1].getTagCompound().getString("DNA")));
        combinedDNA.setTagCompound(compound);

        slots[0].stackSize--;
        if (slots[0].stackSize <= 0)
        {
            slots[0] = null;
        }

        slots[1].stackSize--;
        if (slots[1].stackSize <= 0)
        {
            slots[1] = null;
        }

        if (slots[2] != null)
        {
            slots[2].stackSize++;
        }
        else
        {
            slots[2] = combinedDNA;
        }
    }

    public void updateEntity()
    {
        if (!this.worldObj.isRemote)
        {
            if (this.canCombine())
            {
                this.combinationTime++;
                if (this.getCombinationTime() >= this.getCombinationSpeed())
                {
                    this.setCombinationTime((short) 0);
                    this.combineDNA();
                }
            }
            else
            {
                this.setCombinationTime((short) 0);
            }
        }
    }

    public boolean hasItems()
    {
        return (this.slots[0] != null || this.slots[1] != null || this.slots[2] != null) ? true : false;
    }

    public int getSizeInventory()
    {
        return slots.length;
    }

    public ItemStack getStackInSlot(int i)
    {
        return slots[i];
    }

    public ItemStack decrStackSize(int i, int stackSize)
    {
        if (this.slots[i] != null)
        {
            ItemStack splitedStack;
            if (this.slots[i].stackSize <= stackSize)
            {
                splitedStack = this.slots[i];
                this.slots[i] = null;
                return splitedStack;
            }
            else
            {
                splitedStack = this.slots[i].splitStack(stackSize);
                if (this.slots[i].stackSize == 0)
                {
                    this.slots[i] = null;
                }
                return splitedStack;
            }
        }
        else
        {
            return null;
        }
    }

    public ItemStack getStackInSlotOnClosing(int i)
    {
        if (this.slots[i] != null)
        {
            ItemStack itemStack = this.slots[i];
            this.slots[i] = null;
            return itemStack;
        }
        else
        {
            return null;
        }
    }

    public void setInventorySlotContents(int i, ItemStack itemStack)
    {
        this.slots[i] = itemStack;
        if (itemStack != null && itemStack.stackSize > this.getInventoryStackLimit())
        {
            itemStack.stackSize = this.getInventoryStackLimit();
        }
    }

    public String getInventoryName()
    {
        return "DNA Combiner";
    }

    public boolean hasCustomInventoryName()
    {
        return true;
    }

    public int getInventoryStackLimit()
    {
        return 64;
    }

    public boolean isUseableByPlayer(EntityPlayer player)
    {
        return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : player.getDistanceSq((double) this.xCoord + 0.5D, (double) this.yCoord + 0.5D, (double) this.zCoord + 0.5D) <= 64.0D;
    }

    public void openInventory()
    {

    }

    public void closeInventory()
    {

    }

    public boolean isItemValidForSlot(int i, ItemStack itemStack)
    {
        return false;
    }

    public int[] getAccessibleSlotsFromSide(int i)
    {
        return new int[]{0};
    }

    public boolean canInsertItem(int i, ItemStack itemStack, int j)
    {
        return false;
    }

    public boolean canExtractItem(int i, ItemStack itemStack, int j)
    {
        return false;
    }

    public void readFromNBT(NBTTagCompound nbt)
    {
        super.readFromNBT(nbt);
        NBTTagList list = nbt.getTagList("Items", 10);
        this.slots = new ItemStack[this.getSizeInventory()];
        for (int i = 0; i < list.tagCount(); i++)
        {
            NBTTagCompound compound = list.getCompoundTagAt(i);
            byte k = compound.getByte("Slot");

            if (k >= 0 && k < this.slots.length)
            {
                this.slots[k] = ItemStack.loadItemStackFromNBT(compound);
            }
        }
        this.setCombinationTime(nbt.getShort("CombinationTime"));
    }

    public void writeToNBT(NBTTagCompound nbt)
    {
        super.writeToNBT(nbt);
        nbt.setShort("CombinationTime", this.getCombinationTime());
        NBTTagList list = new NBTTagList();
        for (int i = 0; i < this.slots.length; i++)
        {
            if (this.slots[i] != null)
            {
                NBTTagCompound compound = new NBTTagCompound();
                compound.setByte("Slot", (byte) i);
                this.slots[i].writeToNBT(compound);
                list.appendTag(compound);
            }
        }
        nbt.setTag("Items", list);
    }
}