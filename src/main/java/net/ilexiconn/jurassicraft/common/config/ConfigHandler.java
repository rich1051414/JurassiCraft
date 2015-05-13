package net.ilexiconn.jurassicraft.common.config;

import cpw.mods.fml.common.FMLCommonHandler;
import net.ilexiconn.jurassicraft.JurassiCraft;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigHandler
{
    public static Configuration config;

    public static void init(File file)
    {
        config = new Configuration(file, "&{version}");
        FMLCommonHandler.instance().bus().register(new ConfigSaveEvent());

        reloadConfig();
    }

    public static void reloadConfig()
    {
        JurassiCraft.enableDebugging = config.getBoolean("Enable Debugging", Configuration.CATEGORY_GENERAL, false, "Enable Debugging");

        config.save();
    }
}
