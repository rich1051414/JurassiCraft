package net.ilexiconn.jurassicraft.item;

import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.ModCreativeTabs;
import net.minecraft.item.Item;

public class ItemAmber extends Item implements IDNASource
{
    public ItemAmber()
    {
        super();
        setUnlocalizedName("amber");
        setTextureName(JurassiCraft.getModId() + "amber");
        setCreativeTab(ModCreativeTabs.items);
    }
}
