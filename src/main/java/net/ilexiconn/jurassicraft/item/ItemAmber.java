package net.ilexiconn.jurassicraft.item;

import net.minecraft.item.Item;
import net.ilexiconn.jurassicraft.ModCreativeTabs;
import net.ilexiconn.jurassicraft.Util;

public class ItemAmber extends Item implements IDNASource
{
    public ItemAmber()
    {
        super();
        setUnlocalizedName("amber");
        setTextureName(Util.getModId() + "amber");
        setCreativeTab(ModCreativeTabs.items);
    }
}
