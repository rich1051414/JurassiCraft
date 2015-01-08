package net.ilexiconn.jurassicraft.item.drops;

import net.ilexiconn.jurassicraft.ModCreativeTabs;
import net.ilexiconn.jurassicraft.item.IDNASource;
import net.ilexiconn.jurassicraft.item.ItemDNA;

public class ItemSkin extends ItemGenericDNASource
{
    public ItemSkin(String name)
    {
        super(name, "Skin");
        this.setCreativeTab(ModCreativeTabs.items);
    }

    public ItemDNA getCorrespondingDNA()
    {
        return this.getCorrespondingDNA("Skin");
    }
}
