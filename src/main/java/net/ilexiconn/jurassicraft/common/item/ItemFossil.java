package net.ilexiconn.jurassicraft.common.item;

import net.ilexiconn.jurassicraft.common.JurassiCraft;
import net.ilexiconn.jurassicraft.common.creativetab.ModCreativeTabs;
import net.ilexiconn.jurassicraft.common.interfaces.IDNASource;
import net.minecraft.item.Item;

public class ItemFossil extends Item implements IDNASource
{
    public ItemFossil()
    {
        super();
        setUnlocalizedName("fossil");
        setTextureName(JurassiCraft.getModId() + "fossil");
        setCreativeTab(ModCreativeTabs.items);
    }
}
