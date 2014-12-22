package net.ilexiconn.jurassicraft.item;

import net.minecraft.item.Item;
import net.ilexiconn.jurassicraft.ModCreativeTabs;
import net.ilexiconn.jurassicraft.Util;

public class ItemFossil extends Item implements IDNASource
{
    public ItemFossil()
    {
        super();
        setUnlocalizedName("fossil");
        setTextureName(Util.getModId() + "fossil");
        setCreativeTab(ModCreativeTabs.items);
    }
}
