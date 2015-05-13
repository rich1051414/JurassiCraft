package net.ilexiconn.jurassicraft.common.item;

import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.common.creativetab.ModCreativeTabs;
import net.minecraft.item.Item;

public class ItemDinoBone extends Item
{
    public ItemDinoBone()
    {
        super();
        setUnlocalizedName("dinoBone");
        setTextureName(JurassiCraft.getModId() + "dinoBone");
        setCreativeTab(ModCreativeTabs.items);
    }
}
