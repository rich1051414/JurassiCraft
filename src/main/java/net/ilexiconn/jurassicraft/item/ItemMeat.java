package net.ilexiconn.jurassicraft.item;

import net.minecraft.item.ItemFood;
import net.minecraft.potion.Potion;
import net.ilexiconn.jurassicraft.ModCreativeTabs;
import net.ilexiconn.jurassicraft.Util;

public class ItemMeat extends ItemFood
{
    public ItemMeat(String name)
    {
        super(4, 0.1f, true);
        setPotionEffect(Potion.hunger.id, 30, 0, 0.8f);
        setUnlocalizedName(name + "_Meat");
        setTextureName(Util.getModId() + name + "_Meat");
        setCreativeTab(ModCreativeTabs.items);
    }
}
