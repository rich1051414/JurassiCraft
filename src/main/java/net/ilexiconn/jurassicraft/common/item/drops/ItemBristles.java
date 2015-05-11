package net.ilexiconn.jurassicraft.common.item.drops;

import net.ilexiconn.jurassicraft.common.creativetab.ModCreativeTabs;
import net.ilexiconn.jurassicraft.common.item.ItemDNA;

public class ItemBristles extends ItemGenericDNASource
{
    public ItemBristles(String name)
    {
        super(name, "Bristles");
        this.setCreativeTab(ModCreativeTabs.items);
    }

    public ItemDNA getCorrespondingDNA()
    {
        return this.getCorrespondingDNA("Bristles");
    }
}
