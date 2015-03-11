package net.ilexiconn.jurassicraft.utility.handlers;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.ClientTickEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Phase;
import cpw.mods.fml.relauncher.Side;
import net.ilexiconn.jurassicraft.ModBlocks;
import net.ilexiconn.jurassicraft.block.carboniferous.BlockLeaves;
import net.ilexiconn.jurassicraft.utility.teleporters.TeleportClient;
import net.minecraft.client.Minecraft;

/**
 * @author ProPercivalalb
 **/
public class ClientTickHandler {
	
	public static Minecraft mc = Minecraft.getMinecraft();
	public static boolean checkedVersion = false;

	@SubscribeEvent
	public void clientTick(ClientTickEvent event) {
		if(event.phase != Phase.END || event.side != Side.CLIENT)
			return;

		TeleportClient.onTick(mc.thePlayer);
		
		if(this.mc.currentScreen != null) {
			int setting = 0;

			boolean fancyGraphics = (setting == 0 ? this.mc.gameSettings.fancyGraphics : (setting == 1 ? false : setting == 2));
			((BlockLeaves)ModBlocks.leaves_1).setGraphicsLevel(fancyGraphics);
		}
		else {
			if(!checkedVersion && this.mc.thePlayer != null) {
          		checkedVersion = true;
          	}	 
		}
	}
}