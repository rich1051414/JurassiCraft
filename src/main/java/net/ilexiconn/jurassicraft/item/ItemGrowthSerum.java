package net.ilexiconn.jurassicraft.item;

import net.minecraft.item.Item;
import net.ilexiconn.jurassicraft.ModCreativeTabs;
import net.ilexiconn.jurassicraft.Util;

public class ItemGrowthSerum extends Item
{
    public ItemGrowthSerum()
    {
        super();
        setUnlocalizedName("growthSerum");
        setTextureName(Util.getModId() + "growth_Serum");
        setCreativeTab(ModCreativeTabs.items);
    }
}
