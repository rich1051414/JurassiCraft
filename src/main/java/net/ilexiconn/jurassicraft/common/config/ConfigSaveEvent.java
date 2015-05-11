package net.ilexiconn.jurassicraft.common.config;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class ConfigSaveEvent
{
    @SubscribeEvent
    public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent eventArgs)
    {
        if (eventArgs.modID.equals("jurassicraft"))
            ConfigHandler.reloadConfig();
    }
}
