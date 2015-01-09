package net.ilexiconn.jurassicraft.item;

import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.ModCreativeTabs;
import net.minecraft.item.Item;

public class ItemOnAStick extends Item
{
    public ItemOnAStick(String foodOnAStick)
    {
        super();
        setUnlocalizedName(foodOnAStick + "OnAStick");
        setTextureName(JurassiCraft.getModId() + "ridingItems/" + foodOnAStick + "OnAStick");
        setCreativeTab(ModCreativeTabs.items);
    }
}
