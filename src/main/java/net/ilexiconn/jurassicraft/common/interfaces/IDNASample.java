package net.ilexiconn.jurassicraft.common.interfaces;

import net.minecraft.item.ItemStack;

public interface IDNASample
{
    String getDNASequence(ItemStack dnaSample);

    int getQuality(ItemStack dnaSample);
}
