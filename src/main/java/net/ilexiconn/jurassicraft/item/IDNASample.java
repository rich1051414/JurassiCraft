package net.ilexiconn.jurassicraft.item;

import net.minecraft.item.ItemStack;

public interface IDNASample
{
    String getDNASequence(ItemStack dnaSample);

    int getQuality(ItemStack dnaSample);
}
