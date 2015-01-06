package net.ilexiconn.jurassicraft;

import net.ilexiconn.jurassicraft.content.IContentHandler;
import net.ilexiconn.jurassicraft.entity.CreatureManager;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ModCreativeTabs implements IContentHandler
{
    public static CreativeTabs items;
    public static CreativeTabs blocks;
    public static CreativeTabs dnas;
    public static CreativeTabs syringesEggs;
    public static CreativeTabs spawnEggs;
    
    public void init()
    {
		items = new CreativeTabs("jurassicraft.items") {
			@SideOnly(Side.CLIENT)
			public Item getTabIconItem() {
				return ModItems.amber;
			}
		};

		blocks = new CreativeTabs("jurassicraft.blocks") {
			@SideOnly(Side.CLIENT)
			public Item getTabIconItem() {
				return Item.getItemFromBlock(ModBlocks.cultivateBottomOff);
			}
		};

		dnas = new CreativeTabs("jurassicraft.dnas") {
			@SideOnly(Side.CLIENT)
			public Item getTabIconItem() {
				return CreatureManager.getCreatureFromName("Tyrannosaurus").getDNA();
			}
		};

		syringesEggs = new CreativeTabs("jurassicraft.syringesEggs") {
			@SideOnly(Side.CLIENT)
			public Item getTabIconItem() {
				return CreatureManager.getCreatureFromName("Tyrannosaurus").getEgg();
			}
		};

		spawnEggs = new CreativeTabs("jurassicraft.spawnEggs") {
			@SideOnly(Side.CLIENT)
			public Item getTabIconItem() {
				return ModItems.spawnEgg;
			}
		};
    }
}
