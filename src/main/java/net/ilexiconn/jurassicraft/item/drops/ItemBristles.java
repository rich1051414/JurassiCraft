package net.ilexiconn.jurassicraft.item.drops;

import net.ilexiconn.jurassicraft.ModCreativeTabs;
import net.ilexiconn.jurassicraft.item.ItemDNA;

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
