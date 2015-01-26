package net.ilexiconn.jurassicraft.item;

import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.ModCreativeTabs;
import net.ilexiconn.jurassicraft.entity.Creature;
import net.ilexiconn.jurassicraft.entity.CreatureManager;
import net.ilexiconn.jurassicraft.interfaces.IDNASample;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import java.util.List;

public class ItemDNA extends Item implements IDNASample
{

    public ItemDNA(String name)
    {
        super();
        setUnlocalizedName(name + "_DNA");
        setTextureName(JurassiCraft.getModId() + "creature/" + name + "_DNA");
        setCreativeTab(ModCreativeTabs.dnas);
    }

    public Item getCorrespondingEggOrSyringe()
    {
        Creature creature = CreatureManager.getCreatureFromDNA(this);
        if (creature.getEgg() != null)
        {
            return creature.getEgg();
        }
        else if (creature.getMammalSyringe() != null)
        {
            return creature.getMammalSyringe();
        }
        else
        {
            return null;
        }
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
        return StatCollector.translateToLocal("item.dna.info.errorCode");
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
                list.add(EnumChatFormatting.GREEN + StatCollector.translateToLocal("item.dna.info.dna") + ": " + dnaSample.getTagCompound().getString("DNA"));
            }
            if (dnaSample.getTagCompound().hasKey("Quality"))
            {
                list.add(EnumChatFormatting.GREEN + StatCollector.translateToLocal("item.dna.info.quality") + ": " + dnaSample.getTagCompound().getInteger("Quality") + "%");
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
                }
                else
                {
                    compound.setInteger("Quality", 25);
                }
                if (dnaSample.getTagCompound().hasKey("DNA"))
                {
                    dnaSample.getTagCompound().removeTag("DNA");
                    compound.setString("DNA", JurassiCraftDNAHandler.createDefaultDNA());
                }
                else
                {
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
                player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("item.dna.info.qualityChanged") + " " + dnaSample.getTagCompound().getInteger("Quality") + "%"));
                player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("item.dna.info.geneticCodeIs") + ": " + dnaSample.getTagCompound().getString("DNA")));
            }
        }
        return dnaSample;
    }
}
