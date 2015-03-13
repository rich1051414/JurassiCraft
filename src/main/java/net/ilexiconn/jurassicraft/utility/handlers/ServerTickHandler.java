package net.ilexiconn.jurassicraft.utility.handlers;

import net.ilexiconn.jurassicraft.JurassiCraft;
import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Phase;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;
import cpw.mods.fml.relauncher.Side;

/**
 * @author ProPercivalalb
 */
public class ServerTickHandler
{
	@SubscribeEvent
	public void playerTick(PlayerTickEvent event)
	{
		if(event.phase != Phase.END || event.side != Side.SERVER)
			return;

		EntityPlayer player = event.player;

		JurassiCraft.instance.serverTeleport.onTick(player);
	}
}