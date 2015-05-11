package net.ilexiconn.jurassicraft.common.creativetab;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.ilexiconn.jurassicraft.common.block.ModBlocks;
import net.ilexiconn.jurassicraft.common.content.IContentHandler;
import net.ilexiconn.jurassicraft.common.entity.CreatureManager;
import net.ilexiconn.jurassicraft.common.item.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ModCreativeTabs implements IContentHandler
{
    public static CreativeTabs items;
    public static CreativeTabs blocks;
    public static CreativeTabs dnas;
    public static CreativeTabs syringesEggs;
    public static CreativeTabs spawnEggs;
    public static CreativeTabs itemsFood;

    public void init()
    {
        items = new CreativeTabs("jurassicraft.items")
        {
            @SideOnly(Side.CLIENT)
            public Item getTabIconItem()
            {
                return ModItems.amber;
            }
        };

        blocks = new CreativeTabs("jurassicraft.blocks")
        {
            @SideOnly(Side.CLIENT)
            public Item getTabIconItem()
            {
                return Item.getItemFromBlock(ModBlocks.cultivateBottomOff);
            }
        };

        dnas = new CreativeTabs("jurassicraft.dnas")
        {
            @SideOnly(Side.CLIENT)
            public Item getTabIconItem()
            {
                return CreatureManager.getCreatureFromName("Tyrannosaurus").getDNA();
            }
        };

        syringesEggs = new CreativeTabs("jurassicraft.syringesEggs")
        {
            @SideOnly(Side.CLIENT)
            public Item getTabIconItem()
            {
                return CreatureManager.getCreatureFromName("Tyrannosaurus").getEgg();
            }
        };

        spawnEggs = new CreativeTabs("jurassicraft.spawnEggs")
        {
            @SideOnly(Side.CLIENT)
            public Item getTabIconItem()
            {
                return ModItems.spawnEgg;
            }
        };

        itemsFood = new CreativeTabs("jurassicraft.itemsFood")
        {
            @SideOnly(Side.CLIENT)
            public Item getTabIconItem()
            {
                return CreatureManager.getCreatureFromName("Tyrannosaurus").getMeat();
            }
        };
    }
}
