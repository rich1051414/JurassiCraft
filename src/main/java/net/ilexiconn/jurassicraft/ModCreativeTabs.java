package net.ilexiconn.jurassicraft;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.ilexiconn.jurassicraft.content.IContentHandler;

public class ModCreativeTabs implements IContentHandler
{
    public static CreativeTabs items;
    public static CreativeTabs blocks;

    public void init()
    {
        items = new CreativeTab("jurassicraft.items", Items.bone);
        blocks = new CreativeTab("jurassicraft.blocks", Item.getItemFromBlock(Blocks.stone));
    }

    private static class CreativeTab extends CreativeTabs
    {
        public Item item;

        public CreativeTab(String n, Item i)
        {
            super(n);
            item = i;
        }

        public Item getTabIconItem()
        {
            return item;
        }
    }
}
