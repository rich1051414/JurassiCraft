package net.ilexiconn.jurassicraft;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.ilexiconn.jurassicraft.content.IContentHandler;
import net.ilexiconn.jurassicraft.entity.CreatureManager;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ModCreativeTabs implements IContentHandler
{
    public static CreativeTabs jcItems;
    public static CreativeTabs jcBlocks;
    public static CreativeTabs jcDNAs;
    public static CreativeTabs jcSyringesEggs;
    public static CreativeTabs jcSpawnEggs;
    public static CreativeTabs jcItemsFood;
    public static CreativeTabs carboniferous;
    
    public void init()
    {
        this.jcItems = new CreativeTabs("jurassicraft.items")
        {
            @SideOnly(Side.CLIENT)
            public Item getTabIconItem()
            {
                return ModItems.amber;
            }
        };
        
        this.carboniferous = new CreativeTabs("jurassicraft.carboniferous")
        {
            @SideOnly(Side.CLIENT)
            public Item getTabIconItem()
            {
                return ModItems.rawAmphibian;
            }
        };
        
        this.jcBlocks = new CreativeTabs("jurassicraft.blocks")
        {
            @SideOnly(Side.CLIENT)
            public Item getTabIconItem()
            {
                return Item.getItemFromBlock(ModBlocks.cultivateBottomOff);
            }
        };
        
        this.jcDNAs = new CreativeTabs("jurassicraft.dnas")
        {
            @SideOnly(Side.CLIENT)
            public Item getTabIconItem()
            {
                return CreatureManager.getCreatureFromName("Tyrannosaurus").getDNA();
            }
        };
        
        this.jcSyringesEggs = new CreativeTabs("jurassicraft.syringesEggs")
        {
            @SideOnly(Side.CLIENT)
            public Item getTabIconItem()
            {
                return CreatureManager.getCreatureFromName("Tyrannosaurus").getEgg();
            }
        };
        
        this.jcSpawnEggs = new CreativeTabs("jurassicraft.spawnEggs")
        {
            @SideOnly(Side.CLIENT)
            public Item getTabIconItem()
            {
                return ModItems.spawnEgg;
            }
        };
        
        this.jcItemsFood = new CreativeTabs("jurassicraft.itemsFood")
        {
            @SideOnly(Side.CLIENT)
            public Item getTabIconItem()
            {
                return CreatureManager.getCreatureFromName("Tyrannosaurus").getMeat();
            }
        };
    }
}
