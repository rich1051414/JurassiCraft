package net.ilexiconn.jurassicraft;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import net.ilexiconn.jurassicraft.client.render.item.ItemCultivateRenderer;
import net.ilexiconn.jurassicraft.client.render.item.ItemDNACombinatorRenderer;
import net.ilexiconn.jurassicraft.client.render.item.ItemDNAExtractorRenderer;
import net.ilexiconn.jurassicraft.client.render.item.ItemDinoPadRenderer;
import net.ilexiconn.jurassicraft.client.render.tile.*;
import net.ilexiconn.jurassicraft.content.IContentHandler;
import net.ilexiconn.jurassicraft.entity.EntityDinoEgg;
import net.ilexiconn.jurassicraft.entity.render.RenderDinoEgg;
import net.ilexiconn.jurassicraft.tile.*;

@SideOnly(Side.CLIENT)
public class ModRenderers implements IContentHandler
{
	public void init()
    {
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.cultivateBottomOff), new ItemCultivateRenderer());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.dnaExtractor), new ItemDNAExtractorRenderer());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.dnaCombinator), new ItemDNACombinatorRenderer());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.dinoPad), new ItemDinoPadRenderer());
		MinecraftForgeClient.registerItemRenderer(ModItems.dinoPad, new ItemDinoPadRenderer());

		ClientRegistry.bindTileEntitySpecialRenderer(TileDNACombinator.class, new TileDNACombinatorRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileCultivate.class, new TileCultivateRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileDNAExtractor.class, new TileDNAExtractorRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileDinoPad.class, new TileDinoPadRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileSecurityFenceLowBase.class, new TileSecurityFenceLowBaseRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileSecurityFenceLowGrid.class, new TileSecurityFenceLowGridRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileSecurityFenceLowPole.class, new TileSecurityFenceLowPoleRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileSecurityFenceMediumBase.class, new TileSecurityFenceMediumBaseRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileSecurityFenceMediumGrid.class, new TileSecurityFenceMediumGridRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileSecurityFenceMediumPole.class, new TileSecurityFenceMediumPoleRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileSecurityFenceHighBase.class, new TileSecurityFenceHighBaseRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileSecurityFenceHighGrid.class, new TileSecurityFenceHighGridRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileSecurityFenceHighPole.class, new TileSecurityFenceHighPoleRenderer());
		
		RenderingRegistry.registerEntityRenderingHandler(EntityDinoEgg.class, new RenderDinoEgg());
	}
}
