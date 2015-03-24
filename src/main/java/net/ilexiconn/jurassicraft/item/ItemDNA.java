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
        name = name.toLowerCase();
        String cat = CreatureManager.getCategoryFromCreatureName(name);
        setUnlocalizedName(name + "_DNA");
        setTextureName(JurassiCraft.getModId() + "creatures/" + cat + "/" + name + "/" + name + "_DNA");
        setCreativeTab(ModCreativeTabs.jcDNAs);
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
            NBTTagCompound tagCompound = dnaSample.getTagCompound();
            
            if (tagCompound.hasKey("DNA"))
            {
                list.add(EnumChatFormatting.GREEN + StatCollector.translateToLocal("item.dna.info.dna") + ": " + tagCompound.getString("DNA"));
            }
            
            if (tagCompound.hasKey("Quality"))
            {
                list.add(EnumChatFormatting.GREEN + StatCollector.translateToLocal("item.dna.info.quality") + ": " + tagCompound.getInteger("Quality") + "%");
            }
        }
    }
    
    @Override
    public ItemStack onItemRightClick(ItemStack dna, World world, EntityPlayer player)
    {
        if (player.capabilities.isCreativeMode && player.isSneaking())
        {
            NBTTagCompound compound = new NBTTagCompound();
          
            NBTTagCompound oldCompound = dna.getTagCompound();
            
            if (dna.hasTagCompound())
            {
                if (oldCompound.hasKey("Quality"))
                {
                    int oldQuality = oldCompound.getInteger("Quality");
                    oldCompound.removeTag("Quality");
                    
                    int newQuality = oldQuality + 25;
                    
                    if(newQuality >= 100)
                    {
                        newQuality = 0;
                    }
                    
                    compound.setInteger("Quality", newQuality);
                }
                else
                {
                    compound.setInteger("Quality", 25);
                }
                
                if (oldCompound.hasKey("DNA"))
                {
                    oldCompound.removeTag("DNA");
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
            
            dna.setTagCompound(compound);
            
            if (world.isRemote)
            {
                player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("item.dna.info.qualityChanged") + " " + oldCompound.getInteger("Quality") + "%"));
                player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("item.dna.info.geneticCodeIs") + ": " + oldCompound.getString("DNA")));
            }
        }
        
        return dna;
    }
}
