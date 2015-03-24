package net.ilexiconn.jurassicraft.utility.handlers;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.world.WorldEvent;

/**
 * @author ProPercivalalb
 **/
public class WorldEventHandler
{
    @SubscribeEvent
    public void worldLoad(WorldEvent.Load event)
    {
    }
    
    @SubscribeEvent
    public void worldSave(WorldEvent.Save event)
    {
    }
    
    @SubscribeEvent
    public void worldPotentialSpawns(WorldEvent.PotentialSpawns event)
    {
    }
    
    @SubscribeEvent
    public void worldUnload(WorldEvent.Unload event)
    {
    }
}
