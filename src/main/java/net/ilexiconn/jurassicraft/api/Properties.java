package net.ilexiconn.jurassicraft.api;

import net.ilexiconn.jurassicraft.JurassiCraft;

import java.lang.reflect.Field;

/**
 * @author ProPercivalalb
 **/
public class Properties
{
    
    //Texture Path
    public static final String PACKAGE = "net.ilexiconn.jurassicraft";
    public static final String TEX_PACkAGE = JurassiCraft.getModId();
    public static final String TEX_LOGO = "textures/logo.png";
    public static final String TEX_BLOCK = "textures/item/";
    public static final String TEX_BLOCK_GRINDER = TEX_BLOCK + "grinder.png";
    public static final String TEX_BLOCK_COMPRESSOR = TEX_BLOCK + "compressor.png";
    public static final String TEX_GUI = "textures/gui/";
    public static final String TEX_GUI_GRINDER = TEX_GUI + "grind.png";
    public static final String TEX_GUI_GRINDER_COG = TEX_GUI + "grindCog.png";
    public static final String TEX_GUI_COMPRESSOR = TEX_GUI + "compressor.png";
    
    public static final String SOUND_PATH_GRIND_1 = "machine/grind1.ogg";
    public static final String SOUND_PATH_GRIND_2 = "machine/grind2.ogg";
    
    //Packets
    public static final String PACKET_TELEPORT = "CM|TELEPORT";
    public static final String PACKET_TILE_UPDATE = "CM|TILEUPDATE";
    public static final String PACKET_WALL_SHELL = "CM|WALLSHELL";
    public static final String PACKET_GRIND_SOUND = "CM|GRINDSOUND";
    
    //Render ID
    public static int RENDER_WATER_PLANT;
    public static int RENDER_ANT_HILL;
    public static int RENDER_GRINDER;
    
    //GUI ID
    public static final int GUI_ID_GRINDER = 1;
    public static final int GUI_ID_QUIVER = 2;
    public static final int GUI_ID_COMPRESSER = 3;
    
    //Biome ID
    public static int BIOME_ID_CALAMITESSWAMP = 170;
    public static int BIOME_ID_HIGHLANDS = 171;
    public static int BIOME_ID_ISLAND = 172;
    public static int BIOME_ID_RAINFOREST = 173;
    public static int BIOME_ID_RIVER = 174;
    public static int BIOME_ID_OCEAN = 175;
    public static int BIOME_ID_COALSWAMP = 176;
    public static int BIOME_ID_BOG = 177;
    public static int BIOME_ID_PLAINS = 178;
    
    //ID'S
    public static int dimensionID = -30;
    
    //NBT Data
    public static final String NBT_OWNER_KEY = "teOwner";
    public static final String NBT_CUSTOM_NAME = "CustomName";
    public static final String NBT_ROTATION = "rotation";
    public static final String NBT_STATE = "state";
    
    public static String[] getPackets()
    {
        String[] packets = new String[0];
        try
        {
            Field[] fields = Properties.class.getFields();
            int count = 0;
            for (Field field : fields)
            {
                if (field.getName().startsWith("PACKET_"))
                {
                    count += 1;
                }
            }
            int newCount = 0;
            packets = new String[count];
            for (Field field : fields)
            {
                if (field.getName().startsWith("PACKET_"))
                {
                    packets[newCount] = (String) field.get((Object) null);
                    newCount += 1;
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return packets;
    }
    
    static
    {
        
    }
}