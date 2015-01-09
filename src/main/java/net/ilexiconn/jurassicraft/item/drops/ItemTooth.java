package net.ilexiconn.jurassicraft.item.drops;

import net.ilexiconn.jurassicraft.ModCreativeTabs;
import net.ilexiconn.jurassicraft.interfaces.IDNASource;
import net.ilexiconn.jurassicraft.item.ItemDNA;

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
