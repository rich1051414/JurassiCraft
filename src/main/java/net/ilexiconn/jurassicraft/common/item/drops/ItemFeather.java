package net.ilexiconn.jurassicraft.common.item.drops;

import net.ilexiconn.jurassicraft.common.creativetab.ModCreativeTabs;
import net.ilexiconn.jurassicraft.common.item.ItemDNA;

public class ItemFeather extends ItemGenericDNASource
{
    public ItemFeather(String name)
    {
        super(name, "Feather");
        this.setCreativeTab(ModCreativeTabs.items);
    }

    public ItemDNA getCorrespondingDNA()
    {
        return this.getCorrespondingDNA("Feather");
    }
}
