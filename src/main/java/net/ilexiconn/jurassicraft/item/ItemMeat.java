package net.ilexiconn.jurassicraft.item;

import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.ModCreativeTabs;
import net.ilexiconn.jurassicraft.entity.Creature;
import net.ilexiconn.jurassicraft.entity.CreatureManager;
import net.ilexiconn.jurassicraft.interfaces.IDNASource;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import java.util.List;

public class ItemMeat extends ItemFood implements IDNASource
{
    public ItemMeat(String name)
    {
        super(4, 0.1f, true);
        setPotionEffect(Potion.hunger.id, 30, 0, 0.8F);
        setUnlocalizedName(name + "_Meat");
        name = name.toLowerCase();
        String cat = CreatureManager.getCategoryFromCreatureName(name);
        setTextureName(JurassiCraft.getModId() + "creatures/" + cat + "/" + name + "/" + name + "_Meat");
        setCreativeTab(ModCreativeTabs.itemsFood);
    }
    
    public ItemDNA getCorrespondingDNA()
    {
        Creature creature = CreatureManager.getCreatureFromName(this.getUnlocalizedName().substring(5, this.getUnlocalizedName().length() - 5));
        if (creature != null)
        {
            return creature.getDNA();
        }
        else
        {
            return null;
        }
    }
    
    public String getDNASequence(ItemStack meat)
    {
        if (meat.hasTagCompound())
        {
            if (meat.getTagCompound().hasKey("DNA"))
            {
                return meat.getTagCompound().getString("DNA");
            }
        }
        return StatCollector.translateToLocal("item.meat.info.errorCode");
    }
    
    public int getQuality(ItemStack meat)
    {
        if (meat.hasTagCompound())
        {
            if (meat.getTagCompound().hasKey("Quality"))
            {
                return meat.getTagCompound().getInteger("Quality");
            }
        }
        return 0;
    }
    
    @Override
    public void addInformation(ItemStack meat, EntityPlayer player, List list, boolean flag)
    {
        if (meat.hasTagCompound())
        {
            if (meat.getTagCompound().hasKey("DNA"))
            {
                list.add(EnumChatFormatting.GREEN + StatCollector.translateToLocal("item.meat.info.dna") + ": " + meat.getTagCompound().getString("DNA"));
            }
            if (meat.getTagCompound().hasKey("Quality"))
            {
                list.add(EnumChatFormatting.GREEN + StatCollector.translateToLocal("item.meat.info.quality") + ": " + meat.getTagCompound().getInteger("Quality") + "%");
            }
        }
    }
    
    @Override
    public ItemStack onItemRightClick(ItemStack meat, World world, EntityPlayer player)
    {
        if (player.capabilities.isCreativeMode && player.isSneaking())
        {
            NBTTagCompound compound = new NBTTagCompound();
            if (meat.hasTagCompound())
            {
                if (meat.getTagCompound().hasKey("Quality"))
                {
                    int oldQuality = meat.getTagCompound().getInteger("Quality");
                    meat.getTagCompound().removeTag("Quality");
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
                if (meat.getTagCompound().hasKey("DNA"))
                {
                    meat.getTagCompound().removeTag("DNA");
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
            meat.setTagCompound(compound);
            if (world.isRemote)
            {
                player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("item.meat.info.qualityChanged") + " " + meat.getTagCompound().getInteger("Quality") + "%"));
                player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("item.meat.info.geneticCodeIs") + ": " + meat.getTagCompound().getString("DNA")));
            }
        }
        return meat;
    }
}
