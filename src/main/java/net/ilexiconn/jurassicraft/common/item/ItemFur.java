package net.ilexiconn.jurassicraft.common.item;

import net.ilexiconn.jurassicraft.common.creativetab.JCCreativeTabRegistry;

public class ItemFur extends ItemGenericDNASource
{
    public ItemFur(String name)
    {
        super(name, "Fur");
        this.setCreativeTab(JCCreativeTabRegistry.items);
    }

    public ItemDNA getCorrespondingDNA()
    {
        return this.getCorrespondingDNA("Fur");
    }
}
