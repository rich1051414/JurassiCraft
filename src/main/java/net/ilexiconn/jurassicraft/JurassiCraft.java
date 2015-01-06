package net.ilexiconn.jurassicraft;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import net.ilexiconn.jurassicraft.client.gui.GuiHandler;
import net.ilexiconn.jurassicraft.content.ContentLoader;
import net.ilexiconn.jurassicraft.entity.JsonEntityParser;
import net.ilexiconn.jurassicraft.entity.dinosaurs.EntitySanta;
import net.ilexiconn.jurassicraft.entity.fish.EntityCoelacanth;
import net.ilexiconn.jurassicraft.entity.mammals.JurassiCraftInteractEvent;
import net.ilexiconn.jurassicraft.entity.mammals.JurassiCraftLivingEvent;
import net.ilexiconn.jurassicraft.gen.WorldGenAmberOre;
import net.ilexiconn.jurassicraft.gen.WorldGenFossilOre;
import net.ilexiconn.jurassicraft.gen.WorldGenGypsum;
import net.ilexiconn.jurassicraft.packet.MessageFenceBuilding;
import net.ilexiconn.jurassicraft.packet.MessageFenceCrafting;
import net.ilexiconn.jurassicraft.packet.MessageFenceFixing;
import net.ilexiconn.jurassicraft.proxy.ServerProxy;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.MinecraftForge;

import java.util.Calendar;

@Mod(modid = "jurassicraft", name = "JurassiCraft", version = "${version}")
public class JurassiCraft
{
    @SidedProxy(clientSide = "net.ilexiconn.jurassicraft.proxy.ClientProxy", serverSide = "net.ilexiconn.jurassicraft.proxy.ServerProxy")
    public static ServerProxy proxy;
    @Mod.Instance("jurassicraft")
    public static JurassiCraft instance;

    public static boolean isChristmas;

    public static JsonEntityParser entityParser;
    public static ContentLoader contentLoader;
    public static SimpleNetworkWrapper network;

    @Mod.EventHandler
    public void init(FMLPreInitializationEvent event)
    {
        entityParser = new JsonEntityParser();
        contentLoader = new ContentLoader();

        contentLoader.addContentHandler(new ModCreativeTabs());
        contentLoader.addContentHandler(new ModBlocks());
        contentLoader.addContentHandler(new ModEntities());
        contentLoader.addContentHandler(new ModItems());
        contentLoader.addContentHandler(new ModRecipes());
        if (FMLCommonHandler.instance().getSide() == Side.CLIENT) contentLoader.addContentHandler(new ModRenderers());
        contentLoader.addContentHandler(new ModTileEntities());

        contentLoader.init();

        entityParser.parseServerEntities();

        NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());

        network = NetworkRegistry.INSTANCE.newSimpleChannel("jcWrapper");
        network.registerMessage(MessageFenceCrafting.Handler.class, MessageFenceCrafting.class, 0, Side.SERVER);
        network.registerMessage(MessageFenceBuilding.Handler.class, MessageFenceBuilding.class, 1, Side.SERVER);
        network.registerMessage(MessageFenceFixing.Handler.class, MessageFenceFixing.class, 2, Side.SERVER);

        GameRegistry.registerWorldGenerator(new WorldGenAmberOre(), 1);
        GameRegistry.registerWorldGenerator(new WorldGenFossilOre(), 1);
        GameRegistry.registerWorldGenerator(new WorldGenGypsum(), 1);

        EntityRegistry.addSpawn(EntityCoelacanth.class, 1, 1, 3, EnumCreatureType.waterCreature, BiomeGenBase.deepOcean, BiomeGenBase.ocean);

        Calendar calendar = Calendar.getInstance();

        isChristmas = (calendar.get(2) + 1 == 12 && calendar.get(5) >= 23 && calendar.get(5) <= 27);

        if (isChristmas)
            EntityRegistry.addSpawn(EntitySanta.class, 5, 1, 1, EnumCreatureType.creature, BiomeGenBase.beach, BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.frozenRiver, BiomeGenBase.jungle, BiomeGenBase.plains, BiomeGenBase.river, BiomeGenBase.swampland, BiomeGenBase.taiga, BiomeGenBase.extremeHills, BiomeGenBase.iceMountains, BiomeGenBase.icePlains, BiomeGenBase.mesa, BiomeGenBase.birchForest, BiomeGenBase.coldBeach, BiomeGenBase.savanna, BiomeGenBase.desert);

        MinecraftForge.EVENT_BUS.register(new JurassiCraftLivingEvent());
        MinecraftForge.EVENT_BUS.register(new JurassiCraftInteractEvent());

        proxy.init();
    }

    public static String getModId()
    {
        return "jurassicraft:";
    }
}
