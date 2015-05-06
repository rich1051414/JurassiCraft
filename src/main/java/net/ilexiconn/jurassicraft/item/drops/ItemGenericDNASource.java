package net.ilexiconn.jurassicraft.item.drops;

import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.entity.Creature;
import net.ilexiconn.jurassicraft.entity.CreatureManager;
import net.ilexiconn.jurassicraft.interfaces.IDNASource;
import net.ilexiconn.jurassicraft.item.ItemDNA;
import net.ilexiconn.jurassicraft.item.JurassiCraftDNAHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import java.util.List;

public class ItemGenericDNASource extends Item implements IDNASource
{
    public ItemGenericDNASource(String name, String type)
    {
        super();
        this.setUnlocalizedName(name + "_" + type);
        name = name.toLowerCase();
        String cat = CreatureManager.getCategoryFromCreatureName(name);
        this.setTextureName(JurassiCraft.getModId() + "creatures/" + cat.toLowerCase() + "/" + name.toLowerCase() + "/" + name.toLowerCase() + "_" + type);
    }

    public ItemDNA getCorrespondingDNA(String type)
    {
        Creature creature = CreatureManager.getCreatureFromName(this.getUnlocalizedName().substring(5, this.getUnlocalizedName().length() - (1 + type.length())));
        if (creature != null)
        {
            return creature.getDNA();
        }
        else
        {
            return null;
        }
    }

    public String getDNASequence(ItemStack drop)
    {
        if (drop.hasTagCompound())
        {
            if (drop.getTagCompound().hasKey("DNA"))
            {
                return drop.getTagCompound().getString("DNA");
            }
        }
        return StatCollector.translateToLocal("item.drop.info.errorCode");
    }

    public int getQuality(ItemStack drop)
    {
        if (drop.hasTagCompound())
        {
            if (drop.getTagCompound().hasKey("Quality"))
            {
                return drop.getTagCompound().getInteger("Quality");
            }
        }
        return 0;
    }

    @Override
    public void addInformation(ItemStack drop, EntityPlayer player, List list, boolean flag)
    {
        if (drop.hasTagCompound())
        {
            if (drop.getTagCompound().hasKey("DNA"))
            {
                list.add(EnumChatFormatting.GREEN + StatCollector.translateToLocal("item.drop.info.dna") + ": " + drop.getTagCompound().getString("DNA"));
            }
            else
            {
                list.add(StatCollector.translateToLocal("item.drop.info.dna.none"));
            }
            if (drop.getTagCompound().hasKey("Quality"))
            {
                list.add(EnumChatFormatting.GREEN + StatCollector.translateToLocal("item.drop.info.quality") + ": " + drop.getTagCompound().getInteger("Quality") + "%");
            }
        }
        else
        {
            list.add(StatCollector.translateToLocal("item.drop.info.dna.none"));
        }
    }

    @Override
    public ItemStack onItemRightClick(ItemStack drop, World world, EntityPlayer player)
    {
        if (player.capabilities.isCreativeMode && player.isSneaking())
        {
            NBTTagCompound compound = new NBTTagCompound();
            if (drop.hasTagCompound())
            {
                if (drop.getTagCompound().hasKey("Quality"))
                {
                    int oldQuality = drop.getTagCompound().getInteger("Quality");
                    drop.getTagCompound().removeTag("Quality");
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
                if (drop.getTagCompound().hasKey("DNA"))
                {
                    drop.getTagCompound().removeTag("DNA");
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
            drop.setTagCompound(compound);
            if (world.isRemote)
            {
                player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("item.drop.info.qualityChanged") + " " + drop.getTagCompound().getInteger("Quality") + "%"));
                player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("item.drop.info.geneticCodeIs") + ": " + drop.getTagCompound().getString("DNA")));
            }
        }
        return drop;
    }
}
