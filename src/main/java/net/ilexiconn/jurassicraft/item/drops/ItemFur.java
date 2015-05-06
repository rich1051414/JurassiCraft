package net.ilexiconn.jurassicraft.item.drops;

import net.ilexiconn.jurassicraft.ModCreativeTabs;
import net.ilexiconn.jurassicraft.item.ItemDNA;

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
