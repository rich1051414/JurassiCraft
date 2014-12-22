package net.ilexiconn.jurassicraft;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.MinecraftForge;
import net.ilexiconn.jurassicraft.client.gui.GuiHandler;
import net.ilexiconn.jurassicraft.content.ContentLoader;
import net.ilexiconn.jurassicraft.entity.fish.EntityCoelacanth;
import net.ilexiconn.jurassicraft.entity.mammals.JurassiCraftInteractEvent;
import net.ilexiconn.jurassicraft.entity.mammals.JurassiCraftLivingEvent;
import net.ilexiconn.jurassicraft.gen.WorldGenAmberOre;
import net.ilexiconn.jurassicraft.gen.WorldGenFossilOre;
import net.ilexiconn.jurassicraft.gen.WorldGenGypsum;
import net.ilexiconn.jurassicraft.packet.MessageFenceBuilding;
import net.ilexiconn.jurassicraft.packet.MessageFenceCrafting;
import net.ilexiconn.jurassicraft.packet.MessageFenceFixing;
import to.uk.ilexiconn.llib.LLib;
import to.uk.ilexiconn.llib.config.ConfigSync;

@Mod(modid = "jurassicraft", name = "JurassiCraft", version = "1.3.0 Pre-4", dependencies = "required-after:llib@[0.1.1,)")
public class JurassiCraft extends Util
{
    @Mod.Instance("jurassicraft")
    public static JurassiCraft instance;
    public boolean isServerInitialized;

    public static ContentLoader contentLoader;
    public static SimpleNetworkWrapper network;
    
    public static boolean versionCheck;
    public static boolean easterEggs;

    @Mod.EventHandler
    public void init(FMLPreInitializationEvent event)
    {
        contentLoader = new ContentLoader();

        contentLoader.addContentHandler(new ModCreativeTabs());
        contentLoader.addContentHandler(new ModBlocks());
        contentLoader.addContentHandler(new ModEntities());
        contentLoader.addContentHandler(new ModItems());
        contentLoader.addContentHandler(new ModRecipes());
        contentLoader.addContentHandler(new ModRenderers());
        contentLoader.addContentHandler(new ModTileEntities());

        contentLoader.init();

        getEntityParser().parseServerEntities();

        isServerInitialized = true;
        
        NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
        
        network = NetworkRegistry.INSTANCE.newSimpleChannel("JurassiCraftChannel");
        network.registerMessage(MessageFenceCrafting.Handler.class, MessageFenceCrafting.class, 0, Side.SERVER);
        network.registerMessage(MessageFenceBuilding.Handler.class, MessageFenceBuilding.class, 1, Side.SERVER);
        network.registerMessage(MessageFenceFixing.Handler.class, MessageFenceFixing.class, 2, Side.SERVER);
        
		GameRegistry.registerWorldGenerator(new WorldGenAmberOre(), 1);
		GameRegistry.registerWorldGenerator(new WorldGenFossilOre(), 1);
		GameRegistry.registerWorldGenerator(new WorldGenGypsum(), 1);
    }

    @SideOnly(Side.CLIENT)
    @Mod.EventHandler
    public void initClient(FMLPreInitializationEvent event)
    {
        while (!isServerInitialized);

        getEntityParser().parseClientEntities();
    }

    @Mod.EventHandler
    public void load(FMLInitializationEvent event)
    {
        EntityRegistry.addSpawn(EntityCoelacanth.class, 3, 3, 5, EnumCreatureType.waterCreature, BiomeGenBase.deepOcean, BiomeGenBase.ocean, BiomeGenBase.river);
        
        /** Not working yet! */
        MinecraftForge.EVENT_BUS.register(new JurassiCraftLivingEvent());
        MinecraftForge.EVENT_BUS.register(new JurassiCraftInteractEvent());
    }

    @ConfigSync
    public void syncConfig()
    {
        versionCheck = LLib.config.getBoolean("Version Check", "jurassicraft", true, "Do an automatic version check on every start");
        easterEggs = LLib.config.getBoolean("Easter Eggs", "jurassicraft", false, "Enable all the easter eggs is the mod");
    }
}
