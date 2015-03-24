package net.ilexiconn.jurassicraft.utility.helper;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;

/**
 * @author ProPercivalalb
 */
public class SideHelper
{
    /**
     * @return True if is Server.
     */
    public static boolean isServer()
    {
        return getSide().isServer();
    }
    
    /**
     * @return True if is Client.
     */
    public static boolean isClient()
    {
        return getSide().isClient();
    }
    
    /**
     * @return The effective #Side
     */
    public static Side getSide()
    {
        return FMLCommonHandler.instance().getEffectiveSide();
    }
}
