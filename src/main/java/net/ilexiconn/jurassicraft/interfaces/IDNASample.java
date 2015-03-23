package net.ilexiconn.jurassicraft.interfaces;

import net.minecraft.item.ItemStack;

public interface IDNASample
{
    String getDNASequence(ItemStack dnaSample);
    
    int getQuality(ItemStack dnaSample);
}
