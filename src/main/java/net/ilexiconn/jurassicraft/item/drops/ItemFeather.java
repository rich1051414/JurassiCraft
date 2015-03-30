package net.ilexiconn.jurassicraft.item.drops;

import net.ilexiconn.jurassicraft.ModCreativeTabs;
import net.ilexiconn.jurassicraft.item.ItemDNA;

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
