package net.ilexiconn.jurassicraft.item;

import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.ModCreativeTabs;
import net.minecraft.item.Item;

public class ItemGypsumPowder extends Item
{

    public ItemGypsumPowder()
    {
        super();
        setUnlocalizedName("gypsumPowder");
        setTextureName(JurassiCraft.getModId() + "gypsum_Powder");
        setCreativeTab(ModCreativeTabs.items);
    }
}
