package net.ilexiconn.jurassicraft.item.drops;

import net.ilexiconn.jurassicraft.ModCreativeTabs;
import net.ilexiconn.jurassicraft.item.ItemDNA;

public class ItemScale extends ItemGenericDNASource
{
    public ItemScale(String name)
    {
        super(name, "Scale");
        this.setCreativeTab(ModCreativeTabs.items);
    }

    public ItemDNA getCorrespondingDNA()
    {
        return this.getCorrespondingDNA("Scale");
    }
}
