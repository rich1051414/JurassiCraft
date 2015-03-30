package net.ilexiconn.jurassicraft.item;

import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.ModCreativeTabs;
import net.ilexiconn.jurassicraft.interfaces.IDNASource;
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
