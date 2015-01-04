package net.ilexiconn.jurassicraft.item;

import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.ModCreativeTabs;
import net.minecraft.item.Item;

public class ItemGrowthSerum extends Item
{
    public ItemGrowthSerum()
    {
        super();
        setUnlocalizedName("growthSerum");
        setTextureName(JurassiCraft.getModId() + "growth_Serum");
        setCreativeTab(ModCreativeTabs.items);
    }
}
