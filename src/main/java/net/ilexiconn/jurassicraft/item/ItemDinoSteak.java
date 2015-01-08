package net.ilexiconn.jurassicraft.item;

import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.ModCreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

import java.util.List;

public class ItemDinoSteak extends ItemFood
{
    public ItemDinoSteak(String name)
    {
        super(8, 0.2f, true);
        setUnlocalizedName(name + "_steak");
        setTextureName(JurassiCraft.getModId() + name + "_steak");
        setCreativeTab(ModCreativeTabs.items);
    }

    public void addInformation(ItemStack meat, EntityPlayer player, List list, boolean flag)
    {
        list.add(StatCollector.translateToLocal("item.meat.info.dna.none"));
    }
}
