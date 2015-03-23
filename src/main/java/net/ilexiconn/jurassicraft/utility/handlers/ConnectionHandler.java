package net.ilexiconn.jurassicraft.utility.handlers;

import net.ilexiconn.jurassicraft.utility.teleporters.TeleportServer;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

import java.util.HashMap;

/**
 * @author ProPercivalalb
 **/
public class ConnectionHandler
{
    public HashMap<String, TeleportServer> serverPlayers = new HashMap<String, TeleportServer>();
    
    public void onTick(EntityPlayer player)
    {
        TeleportServer teleporter = getPlayer(player.getCommandSenderName());
        
        if (teleporter != null)
        {
            teleporter.onTick();
        }
    }
    
    public TeleportServer getPlayer(String username)
    {
        return serverPlayers.get(username);
    }
    
    public void addPlayer(TeleportServer player)
    {
        serverPlayers.put(player.getPlayer().getCommandSenderName(), player);
    }
    
    @SubscribeEvent
    public void login(PlayerLoggedInEvent event)
    {
        if (event.player instanceof EntityPlayerMP)
            addPlayer(new TeleportServer((EntityPlayerMP) event.player));
    }
    
}
