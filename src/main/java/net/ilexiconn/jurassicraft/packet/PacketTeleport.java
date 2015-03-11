package net.ilexiconn.jurassicraft.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.ilexiconn.jurassicraft.utility.teleporters.TeleportClient;
import net.ilexiconn.jurassicraft.network.IPacket;

/**
 * @author ProPercivalalb
 **/
public class PacketTeleport extends IPacket {

	@Override
	public void read(DataInputStream data) throws IOException {
		
	}

	@Override
	public void write(DataOutputStream data) throws IOException {
		
	}

	@Override
	public void execute(EntityPlayer player) {
		TeleportClient.timeInPortal = 0;
		TeleportClient.prevTimeInPortal = 0;
		TeleportClient.inPortal = false;
		TeleportClient.timeUntilPortal = 20;
	}

}
