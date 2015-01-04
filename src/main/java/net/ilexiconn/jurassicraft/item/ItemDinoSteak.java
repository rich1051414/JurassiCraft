package net.ilexiconn.jurassicraft.item;

import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.ModCreativeTabs;
import net.minecraft.item.ItemFood;

public class ItemDinoSteak extends ItemFood
{
    public ItemDinoSteak()
    {
        super(8, 0.2f, true);
        this.setUnlocalizedName("dinoSteak");
        this.setTextureName(JurassiCraft.getModId() + "dinoSteak");
        this.setCreativeTab(ModCreativeTabs.items);
    }
}
