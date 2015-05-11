package net.ilexiconn.jurassicraft.common.item;

import net.ilexiconn.jurassicraft.common.JurassiCraft;
import net.ilexiconn.jurassicraft.common.creativetab.ModCreativeTabs;
import net.ilexiconn.jurassicraft.common.interfaces.IDNASource;
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
