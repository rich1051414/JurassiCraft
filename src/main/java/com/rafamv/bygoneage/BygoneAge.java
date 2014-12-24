package com.rafamv.bygoneage;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import com.rafamv.bygoneage.entity.EntityBygoneAgeCreature;
import com.rafamv.bygoneage.handler.BygoneAgeGuiHandler;
import com.rafamv.bygoneage.proxy.CommonProxy;
import com.rafamv.bygoneage.registry.BygoneAgeBlocks;
import com.rafamv.bygoneage.registry.BygoneAgeEntities;
import com.rafamv.bygoneage.registry.BygoneAgeItems;
import com.rafamv.bygoneage.registry.BygoneAgeRecipe;
import com.rafamv.bygoneage.world.BygoneAgeWorldGen;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Mod(modid = BygoneAge.MODID, name = BygoneAge.MODNAME)
public class BygoneAge {

	public static final String MODID = "bygoneage";
	public static final String MODNAME = "Bygone Age";
	public static EntityBygoneAgeCreature creatureToAnalyze;
	public static CreativeTabs bygoneAgeTab = new CreativeTabs("BygoneAgeTab") {
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem() {
			return Item.getItemFromBlock(BygoneAgeBlocks.hatchery);
		}
	};

	@Instance(MODID)
	public static BygoneAge instance;

	@SidedProxy(clientSide = "com.rafamv.bygoneage.proxy.ClientProxy", serverSide = "com.rafamv.bygoneage.proxy.CommonProxy")
	public static CommonProxy bygoneAgeProxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent preEvent) {
		BygoneAgeBlocks.registryAll();
		BygoneAgeItems.registryAll();
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		GameRegistry.registerWorldGenerator(new BygoneAgeWorldGen(), 1);
		bygoneAgeProxy.registerRender();
		bygoneAgeProxy.registerTileEntitySpecialRender();
		bygoneAgeProxy.tileEntityRegistry();
		BygoneAgeEntities.registryAll();
		BygoneAgeRecipe.registryAll();
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new BygoneAgeGuiHandler());
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent postEvent) {

	}
}
