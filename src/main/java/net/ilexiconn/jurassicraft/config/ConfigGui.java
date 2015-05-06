package net.ilexiconn.jurassicraft.config;

import cpw.mods.fml.client.config.GuiConfig;
import cpw.mods.fml.client.config.IConfigElement;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;

import java.util.ArrayList;
import java.util.List;

public class ConfigGui extends GuiConfig
{
    public ConfigGui(GuiScreen parentScreen)
    {
        super(parentScreen, getElements(), "jurassicraft", false, false, "JurassiCraft Config");
    }
    
    private static List<IConfigElement> getElements()
    {
        List<IConfigElement> list = new ArrayList<IConfigElement>();
        {
            list.addAll(new ConfigElement(ConfigHandler.config.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements());
        }
        return list;
    }
}
