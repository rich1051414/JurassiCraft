package net.ilexiconn.jurassicraft.item;

import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.ModCreativeTabs;
import net.minecraft.item.Item;

public class ItemOnAStick extends Item
{
    public ItemOnAStick(String foodOnAStick)
    {
        super();
        this.setUnlocalizedName(foodOnAStick + "OnAStick");
        this.setTextureName(JurassiCraft.getModId() + "ridingItems/" + foodOnAStick + "OnAStick");
        this.setCreativeTab(ModCreativeTabs.items);
        this.maxStackSize = 1;
    }
}
