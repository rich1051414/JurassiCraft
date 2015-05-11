package net.ilexiconn.jurassicraft.common.item.drops;

import net.ilexiconn.jurassicraft.common.creativetab.ModCreativeTabs;
import net.ilexiconn.jurassicraft.common.item.ItemDNA;

public class ItemFur extends ItemGenericDNASource
{
    public ItemFur(String name)
    {
        super(name, "Fur");
        this.setCreativeTab(ModCreativeTabs.items);
    }

    public ItemDNA getCorrespondingDNA()
    {
        return this.getCorrespondingDNA("Fur");
    }
}
