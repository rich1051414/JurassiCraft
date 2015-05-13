package net.ilexiconn.jurassicraft;

import com.google.gson.Gson;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import net.ilexiconn.jurassicraft.client.gui.GuiHandler;
import net.ilexiconn.jurassicraft.client.render.ModRenderers;
import net.ilexiconn.jurassicraft.common.CommonProxy;
import net.ilexiconn.jurassicraft.common.block.ModBlocks;
import net.ilexiconn.jurassicraft.common.cape.CapeContainer;
import net.ilexiconn.jurassicraft.common.command.CommandSpawnDino;
import net.ilexiconn.jurassicraft.common.config.ConfigHandler;
import net.ilexiconn.jurassicraft.common.content.ContentLoader;
import net.ilexiconn.jurassicraft.common.crafting.ModRecipes;
import net.ilexiconn.jurassicraft.common.creativetab.ModCreativeTabs;
import net.ilexiconn.jurassicraft.common.entity.JsonEntityParser;
import net.ilexiconn.jurassicraft.common.entity.ModEntities;
import net.ilexiconn.jurassicraft.common.entity.fish.EntityCoelacanth;
import net.ilexiconn.jurassicraft.common.events.JurassiCraftInteractEvent;
import net.ilexiconn.jurassicraft.common.events.JurassiCraftLivingEvent;
import net.ilexiconn.jurassicraft.common.gen.WorldGenAmberOre;
import net.ilexiconn.jurassicraft.common.gen.WorldGenFossilOre;
import net.ilexiconn.jurassicraft.common.gen.WorldGenGypsum;
import net.ilexiconn.jurassicraft.common.item.ModItems;
import net.ilexiconn.jurassicraft.common.packet.MessageAnimation;
import net.ilexiconn.jurassicraft.common.packet.MessageFence;
import net.ilexiconn.jurassicraft.common.tileentity.ModTileEntities;
import net.ilexiconn.llibrary.common.web.WebHelper;
import net.minecraft.command.ICommandManager;
import net.minecraft.command.ServerCommandManager;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.MinecraftForge;
import org.apache.logging.log4j.Logger;

@Mod(modid = "jurassicraft", name = "JurassiCraft", version = "${version}")
public class JurassiCraft
{
    @SidedProxy(clientSide = "net.ilexiconn.jurassicraft.client.ClientProxy", serverSide = "net.ilexiconn.jurassicraft.common.CommonProxy")
    public static CommonProxy proxy;
    @Mod.Instance("jurassicraft")
    public static JurassiCraft instance;
    public static boolean enableDebugging;
    public static JsonEntityParser entityParser;
    public static ContentLoader contentLoader;
    public static SimpleNetworkWrapper network;
    public static int entityIndex = 0;
    public Logger logger;

    public static CapeContainer capeContainer;

    public static String getModId()
    {
        return "jurassicraft:";
    }

    @Mod.EventHandler
    public void init(FMLPreInitializationEvent event) throws Exception
    {
        logger = event.getModLog();

        entityParser = new JsonEntityParser();

        entityParser.parseServerEntities();

        contentLoader = new ContentLoader();

        contentLoader.addContentHandler(new ModCreativeTabs());
        contentLoader.addContentHandler(new ModEntities());
        contentLoader.addContentHandler(new ModBlocks());
        contentLoader.addContentHandler(new ModItems());
        contentLoader.addContentHandler(new ModRecipes());

        if (FMLCommonHandler.instance().getSide() == Side.CLIENT)
        {
            contentLoader.addContentHandler(new ModRenderers());
        }

        contentLoader.addContentHandler(new ModTileEntities());

        contentLoader.init();
        ConfigHandler.init(event.getSuggestedConfigurationFile());

        NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());

        network = NetworkRegistry.INSTANCE.newSimpleChannel("jcWrapper");
        network.registerMessage(MessageAnimation.Handler.class, MessageAnimation.class, 0, Side.CLIENT);
        network.registerMessage(MessageFence.Handler.class, MessageFence.class, 1, Side.SERVER);

        GameRegistry.registerWorldGenerator(new WorldGenAmberOre(), 1);
        GameRegistry.registerWorldGenerator(new WorldGenFossilOre(), 1);
        GameRegistry.registerWorldGenerator(new WorldGenGypsum(), 1);

        EntityRegistry.addSpawn(EntityCoelacanth.class, 1, 1, 3, EnumCreatureType.waterCreature, BiomeGenBase.deepOcean, BiomeGenBase.ocean);

        proxy.init();
        MinecraftForge.EVENT_BUS.register(new JurassiCraftLivingEvent());
        MinecraftForge.EVENT_BUS.register(new JurassiCraftInteractEvent());

        capeContainer = new Gson().fromJson(WebHelper.readPastebin("PQgLKE5F"), CapeContainer.class);
    }

    @Mod.EventHandler
    public void serverStart(FMLServerStartingEvent event)
    {
        MinecraftServer server = MinecraftServer.getServer();

        ICommandManager command = server.getCommandManager();

        ServerCommandManager manager = (ServerCommandManager) command;

        manager.registerCommand(new CommandSpawnDino());
    }
}
