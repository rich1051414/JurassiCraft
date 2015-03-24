package net.ilexiconn.jurassicraft.item;

import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.ModCreativeTabs;
import net.ilexiconn.jurassicraft.entity.CreatureManager;
import net.ilexiconn.jurassicraft.entity.mammals.EntityPregnantCow;
import net.ilexiconn.jurassicraft.entity.mammals.EntityPregnantHorse;
import net.ilexiconn.jurassicraft.entity.mammals.EntityPregnantPig;
import net.ilexiconn.jurassicraft.entity.mammals.EntityPregnantSheep;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ItemMammalSyringe extends Item
{
    public String mammalName;
    public static final HashSet<String> creaturesFromCow = new HashSet<String>(Arrays.asList("Mammoth", "Arsinoitherium", "Basilosaurus", "Uintatherium", "Paraceratherium", "Deinotherium", "Leptictidium"));
    public static final HashSet<String> creaturesFromPig = new HashSet<String>(Arrays.asList("Mammoth", "Arsinoitherium", "Basilosaurus", "Uintatherium", "Paraceratherium", "Deinotherium", "Leptictidium"));
    public static final HashSet<String> creaturesFromHorse = new HashSet<String>(Arrays.asList("Mammoth", "Arsinoitherium", "Basilosaurus", "Uintatherium", "Paraceratherium", "Deinotherium", "Leptictidium"));
    public static final HashSet<String> creaturesFromSheep = new HashSet<String>(Arrays.asList("Mammoth", "Arsinoitherium", "Basilosaurus", "Uintatherium", "Paraceratherium", "Deinotherium", "Leptictidium"));
    
    public ItemMammalSyringe(String mammal)
    {
        super();
        this.setUnlocalizedName(mammal + "_Syringe");
        mammal = mammal.toLowerCase();
        String cat = CreatureManager.getCategoryFromCreatureName(mammal);
        this.setTextureName(JurassiCraft.getModId() + "creatures/" + cat + "/" + mammal + "/" + mammal + "_DNA");
        this.setCreativeTab(ModCreativeTabs.jcSyringesEggs);
        this.mammalName = mammal;
    }
    
    public String getSyringeDNASequence(ItemStack syringe)
    {
        if (syringe.hasTagCompound())
        {
            if (syringe.getTagCompound().hasKey("SyringeDNA"))
            {
                return syringe.getTagCompound().getString("SyringeDNA");
            }
        }
        return JurassiCraftDNAHandler.createDefaultDNA();
    }
    
    public int getSyringeQuality(ItemStack syringe)
    {
        if (syringe.hasTagCompound())
        {
            if (syringe.getTagCompound().hasKey("SyringeQuality"))
            {
                return syringe.getTagCompound().getInteger("SyringeQuality");
            }
        }
        return 75;
    }
    
    @Override
    public void addInformation(ItemStack syringe, EntityPlayer player, List list, boolean flag)
    {
        if (syringe.hasTagCompound())
        {
            if (syringe.getTagCompound().hasKey("SyringeDNA"))
            {
                list.add(EnumChatFormatting.GREEN + StatCollector.translateToLocal("item.syringe.info.dna") + ": " + syringe.getTagCompound().getString("SyringeDNA"));
            }
            if (syringe.getTagCompound().hasKey("SyringeQuality"))
            {
                list.add(EnumChatFormatting.GREEN + StatCollector.translateToLocal("item.syringe.info.quality") + ": " + syringe.getTagCompound().getInteger("SyringeQuality") + "%");
            }
        }
    }
    
    @Override
    public ItemStack onItemRightClick(ItemStack syringe, World world, EntityPlayer player)
    {
        if (player.capabilities.isCreativeMode && player.isSneaking())
        {
            NBTTagCompound compound = new NBTTagCompound();
            if (syringe.hasTagCompound())
            {
                if (syringe.getTagCompound().hasKey("SyringeQuality"))
                {
                    int oldQuality = syringe.getTagCompound().getInteger("SyringeQuality");
                    syringe.getTagCompound().removeTag("SyringeQuality");
                    switch (oldQuality)
                    {
                        case 25:
                            compound.setInteger("SyringeQuality", 50);
                            break;
                        case 50:
                            compound.setInteger("SyringeQuality", 75);
                            break;
                        case 75:
                            compound.setInteger("SyringeQuality", 100);
                            break;
                        case 100:
                            compound.setInteger("SyringeQuality", 25);
                            break;
                        default:
                            break;
                    }
                }
                else
                {
                    compound.setInteger("SyringeQuality", 25);
                }
                if (syringe.getTagCompound().hasKey("SyringeDNA"))
                {
                    syringe.getTagCompound().removeTag("SyringeDNA");
                    compound.setString("SyringeDNA", JurassiCraftDNAHandler.createDefaultDNA());
                }
                else
                {
                    compound.setString("SyringeDNA", JurassiCraftDNAHandler.createDefaultDNA());
                }
            }
            else
            {
                compound.setInteger("SyringeQuality", 25);
                compound.setString("SyringeDNA", JurassiCraftDNAHandler.createDefaultDNA());
            }
            syringe.setTagCompound(compound);
            if (!world.isRemote)
            {
                player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("item.syringe.info.qualityChanged") + " " + syringe.getTagCompound().getInteger("SyringeQuality") + "%"));
            }
        }
        return syringe;
    }
    
    @Override
    public boolean itemInteractionForEntity(ItemStack syringe, EntityPlayer player, EntityLivingBase creature)
    {
        
        if (!player.capabilities.isCreativeMode)
        {
            if (creature instanceof EntityAnimal && ((EntityAnimal) creature).getGrowingAge() == 0)
            {
                if (!this.setBaby(player.worldObj, player, creature, syringe))
                {
                    return false;
                }
                else
                {
                    syringe.stackSize--;
                    if (syringe.stackSize <= 0)
                    {
                        syringe = (ItemStack) null;
                    }
                    return true;
                }
            }
        }
        else if (player.capabilities.isCreativeMode && !player.isSneaking())
        {
            if (creature instanceof EntityAnimal && ((EntityAnimal) creature).getGrowingAge() == 0)
            {
                if (!this.setBaby(player.worldObj, player, creature, syringe))
                {
                    return false;
                }
                else
                {
                    syringe.stackSize--;
                    if (syringe.stackSize <= 0)
                    {
                        syringe = (ItemStack) null;
                    }
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean setBaby(World world, EntityPlayer player, EntityLivingBase creature, ItemStack syringe)
    {
        if (syringe.hasTagCompound() && syringe.getTagCompound().hasKey("SyringeQuality") && syringe.getTagCompound().getInteger("SyringeQuality") >= 50)
        {
            if (creature instanceof EntityCow)
            {
                if (!this.creaturesFromCow.contains(this.mammalName))
                {
                    return false;
                }
                else
                {
                    EntityPregnantCow cow = EntityPregnantCow.get(((EntityCow) creature));
                    if (cow != null && cow.getMammalName().equals("noEmbryo"))
                    {
                        cow.setMammalName(this.mammalName);
                        cow.setDNAQuality(this.getSyringeQuality(syringe));
                        cow.setDNASequence(this.getSyringeDNASequence(syringe));
                        cow.setPregnancySpeed(2048);
                        if (!world.isRemote)
                        {
                            player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("item.syringe.info.embryoInseminated")));
                        }
                        return true;
                    }
                }
            }
            else if (creature instanceof EntityPig)
            {
                if (!this.creaturesFromPig.contains(this.mammalName))
                {
                    return false;
                }
                else
                {
                    EntityPregnantPig pig = EntityPregnantPig.get(((EntityPig) creature));
                    if (pig != null && pig.getMammalName().equals("noEmbryo"))
                    {
                        pig.setMammalName(this.mammalName);
                        pig.setDNAQuality(this.getSyringeQuality(syringe));
                        pig.setDNASequence(this.getSyringeDNASequence(syringe));
                        pig.setPregnancySpeed(2048);
                        if (!world.isRemote)
                        {
                            player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("item.syringe.info.embryoInseminated")));
                        }
                        return true;
                    }
                }
            }
            else if (creature instanceof EntityHorse)
            {
                if (!this.creaturesFromHorse.contains(this.mammalName))
                {
                    return false;
                }
                else
                {
                    EntityPregnantHorse horse = EntityPregnantHorse.get(((EntityHorse) creature));
                    if (horse != null && horse.getMammalName().equals("noEmbryo"))
                    {
                        horse.setMammalName(this.mammalName);
                        horse.setDNAQuality(this.getSyringeQuality(syringe));
                        horse.setDNASequence(this.getSyringeDNASequence(syringe));
                        horse.setPregnancySpeed(2048);
                        if (!world.isRemote)
                        {
                            player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("item.syringe.info.embryoInseminated")));
                        }
                        return true;
                    }
                }
            }
            else if (creature instanceof EntitySheep)
            {
                if (!this.creaturesFromSheep.contains(this.mammalName))
                {
                    return false;
                }
                else
                {
                    EntityPregnantSheep sheep = EntityPregnantSheep.get(((EntitySheep) creature));
                    if (sheep != null && sheep.getMammalName().equals("noEmbryo"))
                    {
                        sheep.setMammalName(this.mammalName);
                        sheep.setDNAQuality(this.getSyringeQuality(syringe));
                        sheep.setDNASequence(this.getSyringeDNASequence(syringe));
                        sheep.setPregnancySpeed(2048);
                        if (!world.isRemote)
                        {
                            player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("item.syringe.info.embryoInseminated")));
                        }
                        return true;
                    }
                }
            }
        }
        else
        {
            if (!world.isRemote)
            {
                player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("item.syringe.info.errorQuality")));
            }
        }
        return false;
    }
}
