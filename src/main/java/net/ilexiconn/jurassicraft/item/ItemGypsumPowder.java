package net.ilexiconn.jurassicraft.item;

import net.minecraft.item.Item;
import net.ilexiconn.jurassicraft.ModCreativeTabs;
import net.ilexiconn.jurassicraft.Util;

public class ItemGypsumPowder extends Item {
	
	public ItemGypsumPowder() {
        super();
        setUnlocalizedName("gypsumPowder");
        setTextureName(Util.getModId() + "gypsum_Powder");
        setCreativeTab(ModCreativeTabs.items);
	}
}
