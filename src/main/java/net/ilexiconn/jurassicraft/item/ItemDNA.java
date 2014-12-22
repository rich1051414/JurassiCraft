package net.ilexiconn.jurassicraft.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.ilexiconn.jurassicraft.ModCreativeTabs;
import net.ilexiconn.jurassicraft.Util;
import net.ilexiconn.jurassicraft.entity.Entities;

import java.util.List;

public class ItemDNA extends Item implements IDNASample
{

    public ItemDNA(String name)
    {
        super();
        setUnlocalizedName(name + "_DNA");
        setTextureName(Util.getModId() + name + "_DNA");
        setCreativeTab(ModCreativeTabs.items);
    }

    public Item getCorrespondingEggOrSyringe()
    {
        int id = Util.getCreatureIDFromDNA(this);
        Entities creatureFromId = Util.getCreatureFromId(id);
		if (creatureFromId.addEgg)
            return Util.getEggMap().get(creatureFromId);
        if (creatureFromId.addSyringe)
            return Util.getSyringeMap().get(creatureFromId);
        else return null;
    }

    @Override
    public String getDNASequence(ItemStack dnaSample)
    {
        if (dnaSample.hasTagCompound())
        {
            if (dnaSample.getTagCompound().hasKey("DNA"))
            {
                return dnaSample.getTagCompound().getString("DNA");
            }
        }
        return "DNA sequence was not determined yet!";
    }

    @Override
    public int getQuality(ItemStack dnaSample)
    {
        if (dnaSample.hasTagCompound())
        {
            if (dnaSample.getTagCompound().hasKey("Quality"))
            {
                return dnaSample.getTagCompound().getInteger("Quality");
            }
        }
        return 0;
    }

    @Override
    public void addInformation(ItemStack dnaSample, EntityPlayer player, List list, boolean flag)
    {
        if (dnaSample.hasTagCompound())
        {
            if (dnaSample.getTagCompound().hasKey("DNA"))
            {
                list.add(EnumChatFormatting.GREEN + "DNA: " + dnaSample.getTagCompound().getString("DNA"));
            }
            if (dnaSample.getTagCompound().hasKey("Quality"))
            {
                list.add(EnumChatFormatting.GREEN + "Quality: " + dnaSample.getTagCompound().getInteger("Quality") + "%");
            }
        }
    }

    @Override
    public ItemStack onItemRightClick(ItemStack dnaSample, World world, EntityPlayer player)
    {
        if (player.capabilities.isCreativeMode && player.isSneaking())
        {
            NBTTagCompound compound = new NBTTagCompound();
            if (dnaSample.hasTagCompound())
            {
            	if (dnaSample.getTagCompound().hasKey("Quality"))
                {
            		int oldQuality = dnaSample.getTagCompound().getInteger("Quality");
                    dnaSample.getTagCompound().removeTag("Quality");
                    switch (oldQuality)
                    {
                        case 25:
                            compound.setInteger("Quality", 50);
                            break;
                        case 50:
                            compound.setInteger("Quality", 75);
                            break;
                        case 75:
                            compound.setInteger("Quality", 100);
                            break;
                        case 100:
                            compound.setInteger("Quality", 25);
                            break;
                        default:
                            break;
                    }
                } else {
                    compound.setInteger("Quality", 25);
                }
            	if (dnaSample.getTagCompound().hasKey("DNA"))
                {
                    dnaSample.getTagCompound().removeTag("DNA");
                    compound.setString("DNA", JurassiCraftDNAHandler.createDefaultDNA());
                } else {
                    compound.setString("DNA", JurassiCraftDNAHandler.createDefaultDNA());
                }
            }
            else
            {
                compound.setInteger("Quality", 25);
                compound.setString("DNA", JurassiCraftDNAHandler.createDefaultDNA());
            }
            dnaSample.setTagCompound(compound);
            if (world.isRemote)
            {
                player.addChatMessage(new ChatComponentText("Cheater! New quality changed to " + dnaSample.getTagCompound().getInteger("Quality") + "%"));
                player.addChatMessage(new ChatComponentText("Genetic code is: " + dnaSample.getTagCompound().getString("DNA")));
            }
        }
        return dnaSample;
    }
}
