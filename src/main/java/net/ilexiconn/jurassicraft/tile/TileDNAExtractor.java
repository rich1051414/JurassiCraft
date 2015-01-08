package net.ilexiconn.jurassicraft.tile;

import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.Random;

import net.ilexiconn.jurassicraft.entity.Creature;
import net.ilexiconn.jurassicraft.entity.CreatureManager;
import net.ilexiconn.jurassicraft.item.IDNASource;
import net.ilexiconn.jurassicraft.item.ItemAmber;
import net.ilexiconn.jurassicraft.item.ItemDNA;
import net.ilexiconn.jurassicraft.item.ItemFossil;
import net.ilexiconn.jurassicraft.item.ItemDinoMeat;
import net.ilexiconn.jurassicraft.item.JurassiCraftDNAHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileDNAExtractor extends TileEntity implements ISidedInventory
{
    private ItemStack[] slots = new ItemStack[8];
    private static final short extractionSpeed = 100;
    private short extractionTime;
    private ArrayList<ItemDNA> dnas = new ArrayList<ItemDNA>();

    public TileDNAExtractor()
    {
        this.extractionTime = 0;

        for (Entry<Class<?>, Creature> creature : CreatureManager.getCreatures().entrySet())
        {
            ItemDNA dna = creature.getValue().getDNA();
            if (dna != null)
            {
                dnas.add(dna);
            }
        }
    }

    public short getExtractionTime()
    {
        return extractionTime;
    }

    public void setExtractionTime(short time)
    {
        this.extractionTime = time;
    }

    public short getExtractionSpeed()
    {
        return this.extractionSpeed;
    }

    public int getExtractionProgressScaled(int i)
    {
        return (this.getExtractionTime() * i) / this.getExtractionSpeed();
    }

    public boolean isExtracting()
    {
        return (this.getExtractionTime() > 0);
    }

    private boolean canExtract()
    {
        if (this.slots[0] == (ItemStack) null && this.slots[1] == (ItemStack) null && this.slots[2] == (ItemStack) null && this.slots[3] == (ItemStack) null)
        {
            return false;
        }
        else if (this.slots[4] != (ItemStack) null && this.slots[5] != (ItemStack) null && this.slots[6] != (ItemStack) null && this.slots[7] != (ItemStack) null)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    private void extractItem()
    {
        for (int i = 0; i < 4; i++)
        {
            if (slots[i] != (ItemStack) null && slots[i].getItem() instanceof IDNASource)
            {
                ItemStack newItem = (ItemStack) null;
                
            	if (slots[i].getItem() instanceof ItemFossil) 
            	{
            		newItem = this.getDNASampleFromFossil();
            	} 
            	else if (slots[i].getItem() instanceof ItemDinoMeat)
            	{
            		newItem = this.getDNASampleFromMeat(slots[i]);
            	} 
            	else if (slots[i].getItem() instanceof ItemAmber) 
            	{
            		newItem = this.getDNASampleFromAmber();
            	} 
            	else 
            	{
                    int output = this.worldObj.rand.nextInt(3);
                    if (output == 0) 
                    {
                    	newItem = new ItemStack(Blocks.sand, 1 + this.worldObj.rand.nextInt(2));
                    } 
                    else if (output == 1) 
                    {
                    	newItem = new ItemStack(Blocks.cobblestone, 1 + this.worldObj.rand.nextInt(2));
                    }
                    else if (output == 2) 
                    {
                    	newItem = new ItemStack(Items.bone, 1 + this.worldObj.rand.nextInt(3));
                    }
            	}
            	
            	if (newItem != (ItemStack) null) {
            		for (int j = 4; j < 8; j++)
                    {
                        if (this.slots[j] != (ItemStack) null && this.slots[j].getItem() == newItem.getItem())
                        {
                            this.slots[i].stackSize--;
                            if (this.slots[i].stackSize <= 0)
                            {
                                this.slots[i] = (ItemStack) null;
                            }
                            this.slots[j].stackSize++;
                            this.worldObj.markBlockForUpdate(this.xCoord, this.yCoord, this.zCoord);
                            return;
                        }
                    }
                    for (int j = 4; j < 8; j++)
                    {
                        if (this.slots[j] == (ItemStack) null)
                        {
                            this.slots[i].stackSize--;
                            if (this.slots[i].stackSize <= 0)
                            {
                                this.slots[i] = (ItemStack) null;
                            }
                            this.slots[j] = newItem;
                            this.worldObj.markBlockForUpdate(this.xCoord, this.yCoord, this.zCoord);
                            return;
                        }
                    }
            	}
            }
        }
    }

	private ItemStack getDNASampleFromFossil() {
		if (this.worldObj.rand.nextFloat() >= 0.70F)
        {
            ItemStack dna = new ItemStack(this.getRandomDNA(new Random()));
            if (!dna.hasTagCompound())
            {
                NBTTagCompound compound = new NBTTagCompound();
                float probability = this.worldObj.rand.nextFloat();
                if (probability <= 0.10F)
                {
                    compound.setInteger("Quality", 100);
                }
                else if (probability <= 0.35F)
                {
                    compound.setInteger("Quality", 75);
                }
                else if (probability <= 0.75F)
                {
                    compound.setInteger("Quality", 50);
                }
                else
                {
                    compound.setInteger("Quality", 25);
                }
                compound.setString("DNA", JurassiCraftDNAHandler.createDefaultDNA());
                dna.setTagCompound(compound);
                return dna;
            }
            else
            {
                if (!dna.getTagCompound().hasKey("Quality"))
                {
                    float probability = this.worldObj.rand.nextFloat();
                    if (probability <= 0.10F)
                    {
                    	dna.getTagCompound().setInteger("Quality", 100);
                    }
                    else if (probability <= 0.35F)
                    {
                    	dna.getTagCompound().setInteger("Quality", 75);
                    }
                    else if (probability <= 0.75F)
                    {
                    	dna.getTagCompound().setInteger("Quality", 50);
                    }
                    else
                    {
                    	dna.getTagCompound().setInteger("Quality", 25);
                    }
                }
                if (!dna.getTagCompound().hasKey("DNA"))
                {
                	dna.getTagCompound().setString("DNA", JurassiCraftDNAHandler.createDefaultDNA());
                }
            }
        } 
		else 
		{
            int output = this.worldObj.rand.nextInt(3);
            if (output == 0) 
            {
            	return new ItemStack(Blocks.sand, 1 + this.worldObj.rand.nextInt(2));
            } 
            else if (output == 1) 
            {
            	return new ItemStack(Blocks.cobblestone, 1 + this.worldObj.rand.nextInt(2));
            }
            else if (output == 2) 
            {
            	return new ItemStack(Items.bone, 1 + this.worldObj.rand.nextInt(3));
            }
        }
		return null;
	}

	private ItemStack getDNASampleFromAmber() {
        ItemStack dna = new ItemStack(this.getRandomDNA(new Random()));
        if (!dna.hasTagCompound())
        {
            NBTTagCompound compound = new NBTTagCompound();
            compound.setInteger("Quality", 100);
            compound.setString("DNA", JurassiCraftDNAHandler.createDefaultDNA());
            dna.setTagCompound(compound);
            return dna;
        }
        else
        {
            if (!dna.getTagCompound().hasKey("Quality"))
            {
            	dna.getTagCompound().setInteger("Quality", 100);
            }
            if (!dna.getTagCompound().hasKey("DNA"))
            {
            	dna.getTagCompound().setString("DNA", JurassiCraftDNAHandler.createDefaultDNA());
            }
            return dna;
        }
	}

    private ItemStack getDNASampleFromMeat(ItemStack meat) {
        ItemStack dna = new ItemStack(this.getDNAFromMeat((ItemDinoMeat) meat.getItem()));
    	if (meat.hasTagCompound()) {
    		dna.setTagCompound(meat.getTagCompound());
            if (!dna.getTagCompound().hasKey("Quality"))
            {
            	dna.getTagCompound().setInteger("Quality", 100);
            }
            if (!dna.getTagCompound().hasKey("DNA"))
            {
            	dna.getTagCompound().setString("DNA", JurassiCraftDNAHandler.createDefaultDNA());
            }
            return dna;
    	} else {
    		if (!dna.hasTagCompound())
            {
            	NBTTagCompound compound = new NBTTagCompound();
                compound.setInteger("Quality", 100);
                compound.setString("DNA", JurassiCraftDNAHandler.createDefaultDNA());
                dna.setTagCompound(compound);
                return dna;
            }
            else
            {
                if (!dna.getTagCompound().hasKey("Quality"))
                {
                	dna.getTagCompound().setInteger("Quality", 100);
                }
                if (!dna.getTagCompound().hasKey("DNA"))
                {
                	dna.getTagCompound().setString("DNA", JurassiCraftDNAHandler.createDefaultDNA());
                }
                return dna;
            }
    	}
	}

	private Item getDNAFromMeat(ItemDinoMeat meat)
    {
    	ItemDNA dna = meat.getCorrespondingDNA();
        return dna;
    }

    private Item getRandomDNA(Random rand)
    {
        return dnas.get(rand.nextInt(dnas.size()));
    }

    @Override
    public void updateEntity()
    {
        if (!this.worldObj.isRemote)
        {
            if (this.canExtract())
            {
                this.extractionTime++;
                if (this.getExtractionTime() >= this.getExtractionSpeed())
                {
                    this.setExtractionTime((short) 0);
                    this.extractItem();
                }
            }
            else
            {
                this.setExtractionTime((short) 0);
            }
        }
    }

    public boolean hasItems()
    {
        return (this.slots[0] != null || this.slots[1] != null || this.slots[2] != null || this.slots[3] != null || this.slots[4] != null || this.slots[5] != null || this.slots[6] != null || this.slots[7] != null) ? true : false;
    }

    @Override
    public int getSizeInventory()
    {
        return slots.length;
    }

    @Override
    public ItemStack getStackInSlot(int i)
    {
        return slots[i];
    }

    @Override
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

    @Override
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

    @Override
    public void setInventorySlotContents(int i, ItemStack itemStack)
    {
        this.slots[i] = itemStack;
        if (itemStack != null && itemStack.stackSize > this.getInventoryStackLimit())
        {
            itemStack.stackSize = this.getInventoryStackLimit();
        }
    }

    @Override
    public String getInventoryName()
    {
        return "DNA Extractor";
    }

    @Override
    public boolean hasCustomInventoryName()
    {
        return true;
    }

    @Override
    public int getInventoryStackLimit()
    {
        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer player)
    {
        return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : player.getDistanceSq((double) this.xCoord + 0.5D, (double) this.yCoord + 0.5D, (double) this.zCoord + 0.5D) <= 64.0D;
    }

    @Override
    public void openInventory()
    {

    }

    @Override
    public void closeInventory()
    {

    }

    @Override
    public boolean isItemValidForSlot(int i, ItemStack itemStack)
    {
        return false;
    }

    @Override
    public int[] getAccessibleSlotsFromSide(int i)
    {
        return new int[]{0};
    }

    @Override
    public boolean canInsertItem(int i, ItemStack itemStack, int j)
    {
        return false;
    }

    @Override
    public boolean canExtractItem(int i, ItemStack itemStack, int j)
    {
        return false;
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt)
    {
        super.readFromNBT(nbt);
        NBTTagList list = nbt.getTagList("Items", 10);
        this.slots = new ItemStack[this.getSizeInventory()];
        for (int i = 0; i < list.tagCount(); i++)
        {
            NBTTagCompound compound = (NBTTagCompound) list.getCompoundTagAt(i);
            byte k = compound.getByte("Slot");

            if (k >= 0 && k < this.slots.length)
            {
                this.slots[k] = ItemStack.loadItemStackFromNBT(compound);
            }
        }
        this.setExtractionTime(nbt.getShort("ExtractionTime"));
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt)
    {
        super.writeToNBT(nbt);
        nbt.setShort("ExtractionTime", this.getExtractionTime());
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

    @Override
    public Packet getDescriptionPacket()
    {
        NBTTagCompound compound = new NBTTagCompound();
        this.writeToNBT(compound);
        return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, this.blockMetadata, compound);
    }

    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet)
    {
        NBTTagCompound compound = packet.func_148857_g();
        this.readFromNBT(compound);
    }
}