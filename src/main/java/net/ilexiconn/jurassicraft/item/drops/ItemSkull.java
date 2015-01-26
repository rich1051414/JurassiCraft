package net.ilexiconn.jurassicraft.item.drops;

import net.ilexiconn.jurassicraft.ModCreativeTabs;
import net.ilexiconn.jurassicraft.item.ItemDNA;

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
