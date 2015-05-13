package net.ilexiconn.jurassicraft.common.item;

import net.ilexiconn.jurassicraft.common.creativetab.JCCreativeTabRegistry;

public class ItemSkull extends ItemGenericDNASource
{
    public ItemSkull(String name)
    {
        super(name, "Skull");
        this.setCreativeTab(JCCreativeTabRegistry.items);
    }

    public ItemDNA getCorrespondingDNA()
    {
        return this.getCorrespondingDNA("Skull");
    }
}
