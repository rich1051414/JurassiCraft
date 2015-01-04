package thehippomaster.AnimationAPI;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.entity.Entity;
import thehippomaster.AnimationAPI.packet.PacketAnim;
import thehippomaster.AnimationAPI.packet.PacketPipeline;

@Mod(modid = "animationapi", name = "AnimationAPI", version = "1.0.0")
public class AnimationAPI {
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent e) {
	}
	
	@Mod.EventHandler
	public void init(FMLInitializationEvent e) {
		packetPipeline.initialize();
		packetPipeline.registerPacket(PacketAnim.class);
	}
	
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent e) {
		proxy.initTimer();
		packetPipeline.postInitialize();
	}
	
	public static boolean isClient() {
		return FMLCommonHandler.instance().getSide().isClient();
	}
	
	public static boolean isEffectiveClient() {
		return FMLCommonHandler.instance().getEffectiveSide().isClient();
	}
	
	public static void sendAnimPacket(IAnimatedEntity entity, int animID) {
		if(isEffectiveClient()) return;
		entity.setAnimID(animID);
		Entity e = (Entity)entity;
		packetPipeline.sendToAll(new PacketAnim((byte)animID, e.getEntityId()));
	}
	
	@Mod.Instance("AnimationAPI")
	public static AnimationAPI instance;
	@SidedProxy(clientSide="thehippomaster.AnimationAPI.client.ClientProxy", serverSide="thehippomaster.AnimationAPI.CommonProxy")
	public static CommonProxy proxy;
	public static final PacketPipeline packetPipeline = new PacketPipeline();
	
	public static final String[] fTimer;
	
	static {
		fTimer = new String[] {"field_71428_T", "S", "timer"};
	}
}
