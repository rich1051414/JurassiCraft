package net.ilexiconn.jurassicraft.item;

import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.ModCreativeTabs;
import net.ilexiconn.jurassicraft.entity.CreatureManager;
import net.ilexiconn.jurassicraft.entity.egg.EntityDinoEgg;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import java.util.List;

public class ItemEgg extends Item
{
    public String dinoName;

    public ItemEgg(String dinoName)
    {
        super();
        this.setUnlocalizedName(dinoName + "_Egg");
        this.setTextureName(JurassiCraft.getModId() + "creature/" + dinoName + "_Egg");
        this.setCreativeTab(ModCreativeTabs.syringesEggs);
        this.dinoName = dinoName;
    }

    public String getEggDNASequence(ItemStack egg)
    {
        if (egg.hasTagCompound())
        {
            if (egg.getTagCompound().hasKey("EggDNA"))
            {
                return egg.getTagCompound().getString("EggDNA");
            }
        }
        return JurassiCraftDNAHandler.createDefaultDNA();
    }

    public int getEggQuality(ItemStack egg)
    {
        if (egg.hasTagCompound())
        {
            if (egg.getTagCompound().hasKey("EggQuality"))
            {
                return egg.getTagCompound().getInteger("EggQuality");
            }
        }
        return 75;
    }

    @Override
    public void addInformation(ItemStack egg, EntityPlayer player, List list, boolean flag)
    {
        if (egg.hasTagCompound())
        {
            if (egg.getTagCompound().hasKey("EggDNA"))
            {
                list.add(EnumChatFormatting.GREEN + StatCollector.translateToLocal("item.dinoEgg.info.dna") + ": " + egg.getTagCompound().getString("EggDNA"));
            }
            if (egg.getTagCompound().hasKey("EggQuality"))
            {
                list.add(EnumChatFormatting.GREEN + StatCollector.translateToLocal("item.dinoEgg.info.quality") + ": " + egg.getTagCompound().getInteger("EggQuality") + "%");
            }
        }
    }

    @Override
    public ItemStack onItemRightClick(ItemStack egg, World world, EntityPlayer player)
    {
        if (player.capabilities.isCreativeMode && player.isSneaking())
        {
            NBTTagCompound compound = new NBTTagCompound();
            if (egg.hasTagCompound())
            {
                if (egg.getTagCompound().hasKey("EggQuality"))
                {
                    int oldQuality = egg.getTagCompound().getInteger("EggQuality");
                    egg.getTagCompound().removeTag("EggQuality");
                    switch (oldQuality)
                    {
                        case 25:
                            compound.setInteger("EggQuality", 50);
                            break;
                        case 50:
                            compound.setInteger("EggQuality", 75);
                            break;
                        case 75:
                            compound.setInteger("EggQuality", 100);
                            break;
                        case 100:
                            compound.setInteger("EggQuality", 25);
                            break;
                        default:
                            break;
                    }
                }
                else
                {
                    compound.setInteger("EggQuality", 25);
                }
                if (egg.getTagCompound().hasKey("EggDNA"))
                {
                    egg.getTagCompound().removeTag("EggDNA");
                    compound.setString("EggDNA", JurassiCraftDNAHandler.createDefaultDNA());
                }
                else
                {
                    compound.setString("EggDNA", JurassiCraftDNAHandler.createDefaultDNA());
                }
            }
            else
            {
                compound.setInteger("EggQuality", 25);
                compound.setString("EggDNA", JurassiCraftDNAHandler.createDefaultDNA());
            }
            egg.setTagCompound(compound);
            if (!world.isRemote)
            {
                player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("item.dinoEgg.info.qualityChanged") + " " + egg.getTagCompound().getInteger("EggQuality") + "%"));
            }
        }
        return egg;
    }

    @Override
    public boolean onItemUse(ItemStack egg, EntityPlayer player, World world, int x, int y, int z, int side, float clickX, float clickY, float clickZ)
    {
        if (egg.hasTagCompound() && egg.getTagCompound().hasKey("EggQuality") && egg.getTagCompound().getInteger("EggQuality") >= 50)
        {
            if (!world.isRemote && !player.capabilities.isCreativeMode)
            {
                world.spawnEntityInWorld(new EntityDinoEgg(world, CreatureManager.getCreatureFromName(dinoName), this.getEggQuality(egg), this.getEggDNASequence(egg), 2048, x, y + 1, z));
            }
            else if (!world.isRemote && !player.isSneaking())
            {
                world.spawnEntityInWorld(new EntityDinoEgg(world, CreatureManager.getCreatureFromName(dinoName), this.getEggQuality(egg), this.getEggDNASequence(egg), 2048, x, y + 1, z));
            }
            else
            {
                this.onItemRightClick(egg, world, player);
            }
            egg.stackSize--;
            if (egg.stackSize <= 0) egg = (ItemStack) null;
            return true;
        }
        else
        {
            if (world.isRemote)
            {
                player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("item.dinoEgg.info.errorQuality")));
            }
        }
        return false;
    }
}
