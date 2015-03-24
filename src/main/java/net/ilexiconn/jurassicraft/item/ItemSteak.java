package net.ilexiconn.jurassicraft.item;

import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.ModCreativeTabs;
import net.ilexiconn.jurassicraft.entity.CreatureManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

import java.util.List;

public class ItemSteak extends ItemFood
{
    public ItemSteak(String name)
    {
        super(8, 0.2f, true);
        setUnlocalizedName(name + "_Steak");
        name = name.toLowerCase();
        String cat = CreatureManager.getCategoryFromCreatureName(name);
        setTextureName(JurassiCraft.getModId() + "creatures/" + cat + "/" + name + "/" + name + "_Steak");
        setCreativeTab(ModCreativeTabs.jcItemsFood);
    }
    
    public void addInformation(ItemStack meat, EntityPlayer player, List list, boolean flag)
    {
        list.add(StatCollector.translateToLocal("item.meat.info.dna.none"));
    }
}
