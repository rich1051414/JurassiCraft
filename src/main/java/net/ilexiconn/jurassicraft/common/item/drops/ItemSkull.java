package net.ilexiconn.jurassicraft.common.item.drops;

import net.ilexiconn.jurassicraft.common.creativetab.ModCreativeTabs;
import net.ilexiconn.jurassicraft.common.item.ItemDNA;

public class ItemSkull extends ItemGenericDNASource
{
    public ItemSkull(String name)
    {
        super(name, "Skull");
        this.setCreativeTab(ModCreativeTabs.items);
    }

    public ItemDNA getCorrespondingDNA()
    {
        return this.getCorrespondingDNA("Skull");
    }
}
