package net.ilexiconn.jurassicraft.item;

import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.ModCreativeTabs;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.Potion;

public class ItemMeat extends ItemFood
{
    public ItemMeat(String name)
    {
        super(4, 0.1f, true);
        setPotionEffect(Potion.hunger.id, 30, 0, 0.8f);
        setUnlocalizedName(name + "_Meat");
        setTextureName(JurassiCraft.getModId() + name + "_Meat");
        setCreativeTab(ModCreativeTabs.items);
    }
}
