package net.ilexiconn.jurassicraft.item;

import net.minecraft.item.Item;
import net.ilexiconn.jurassicraft.ModCreativeTabs;
import net.ilexiconn.jurassicraft.Util;

public class ItemOnAStick extends Item
{
    public ItemOnAStick(String foodOnAStick)
    {
        super();
        setUnlocalizedName(foodOnAStick + "OnAStick");
        setTextureName(Util.getModId() + foodOnAStick + "OnAStick");
        setCreativeTab(ModCreativeTabs.items);
    }
}
