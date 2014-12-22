package net.ilexiconn.jurassicraft.item;

import net.minecraft.item.ItemFood;
import net.ilexiconn.jurassicraft.ModCreativeTabs;
import net.ilexiconn.jurassicraft.Util;

public class ItemDinoSteak extends ItemFood
{
    public ItemDinoSteak()
    {
        super(8, 0.2f, true);
        this.setUnlocalizedName("dinoSteak");
        this.setTextureName(Util.getModId() + "dinoSteak");
        this.setCreativeTab(ModCreativeTabs.items);
    }
}
