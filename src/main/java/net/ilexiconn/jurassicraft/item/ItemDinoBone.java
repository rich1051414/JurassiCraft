package net.ilexiconn.jurassicraft.item;

import net.minecraft.item.Item;
import net.ilexiconn.jurassicraft.ModCreativeTabs;
import net.ilexiconn.jurassicraft.Util;

public class ItemDinoBone extends Item
{
    public ItemDinoBone()
    {
        super();
        setUnlocalizedName("dinoBone");
        setTextureName(Util.getModId() + "dinoBone");
        setCreativeTab(ModCreativeTabs.items);
    }
}
