package net.ilexiconn.jurassicraft;

import akka.dispatch.sysmsg.Create;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.item.Item;
import net.ilexiconn.jurassicraft.config.JsonCreatureDefinition;
import net.ilexiconn.jurassicraft.entity.JsonEntityParser;
import net.ilexiconn.jurassicraft.item.ItemDNA;
import net.ilexiconn.jurassicraft.item.ItemDinoEgg;
import net.ilexiconn.jurassicraft.item.ItemMammalSyringe;
import net.ilexiconn.jurassicraft.item.ItemMeat;
import net.ilexiconn.jurassicraft.proxy.ServerProxy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @deprecated Start using LLib's Content Handler System instead
 */
@Deprecated
public class Util
{
    /**
     * Stuff
     */
    private static final JsonEntityParser entityParser = new JsonEntityParser();
    @SidedProxy(clientSide = "net.ilexiconn.jurassicraft.proxy.ClientProxy", serverSide = "net.ilexiconn.jurassicraft.proxy.ServerProxy")
    public static ServerProxy proxy;
    
    private static Item[] items = new Item[512];

    public static Item getItem(int id)
    {
        return items[id];
    }
    
    public static String getModId()
    {
        return "jurassicraft:";
    }

    public static JsonEntityParser getEntityParser()
    {
        return entityParser;
    }

    /**
     *  Adders
     */

    public void addItem(int id, Item item)
    {
        if (id != -1) items[id] = item;
        GameRegistry.registerItem(item, item.getUnlocalizedName());
    }
}
