package net.ilexiconn.jurassicraft;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.ilexiconn.jurassicraft.content.IContentHandler;
import net.ilexiconn.jurassicraft.entity.CreatureManager;
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
    public static CreativeTabs Carboniferous;

    public void init()
    {
        this.items = new CreativeTabs("jurassicraft.items")
        {
            @SideOnly(Side.CLIENT)
            public Item getTabIconItem()
            {
                return ModItems.amber;
            }
        };

        this.blocks = new CreativeTabs("jurassicraft.blocks")
        {
            @SideOnly(Side.CLIENT)
            public Item getTabIconItem()
            {
                return Item.getItemFromBlock(ModBlocks.cultivateBottomOff);
            }
        };

        this.dnas = new CreativeTabs("jurassicraft.dnas")
        {
            @SideOnly(Side.CLIENT)
            public Item getTabIconItem()
            {
                return CreatureManager.getCreatureFromName("Tyrannosaurus").getDNA();
            }
        };

        this.syringesEggs = new CreativeTabs("jurassicraft.syringesEggs")
        {
            @SideOnly(Side.CLIENT)
            public Item getTabIconItem()
            {
                return CreatureManager.getCreatureFromName("Tyrannosaurus").getEgg();
            }
        };

        this.spawnEggs = new CreativeTabs("jurassicraft.spawnEggs")
        {
            @SideOnly(Side.CLIENT)
            public Item getTabIconItem()
            {
                return ModItems.spawnEgg;
            }
        };

        this.itemsFood = new CreativeTabs("jurassicraft.itemsFood")
        {
            @SideOnly(Side.CLIENT)
            public Item getTabIconItem()
            {
                return CreatureManager.getCreatureFromName("Tyrannosaurus").getMeat();
            }
        };
    }
}
