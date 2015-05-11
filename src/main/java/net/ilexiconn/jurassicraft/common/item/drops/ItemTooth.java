package net.ilexiconn.jurassicraft.common.item.drops;

import net.ilexiconn.jurassicraft.common.creativetab.ModCreativeTabs;
import net.ilexiconn.jurassicraft.common.item.ItemDNA;

public class ItemTooth extends ItemGenericDNASource
{
    public ItemTooth(String name)
    {
        super(name, "Tooth");
        this.setCreativeTab(ModCreativeTabs.items);
    }

    public ItemDNA getCorrespondingDNA()
    {
        return this.getCorrespondingDNA("Tooth");
    }
}
