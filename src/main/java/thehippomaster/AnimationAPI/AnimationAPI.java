package thehippomaster.AnimationAPI;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.entity.Entity;
import thehippomaster.AnimationAPI.packet.PacketAnimation;

@Mod(modid = "jcanimationapi", name = "AnimationAPI", version = "1.2.4-jdediton")
public class AnimationAPI
{
	@Instance("AnimationAPI")
	public static AnimationAPI instance;
	@SidedProxy(clientSide = "thehippomaster.AnimationAPI.client.ClientProxy", serverSide = "thehippomaster.AnimationAPI.CommonProxy")
	public static CommonProxy proxy;
	public static SimpleNetworkWrapper wrapper;

	public static final String[] fTimer = new String[] {"field_71428_T", "S", "timer"};

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		wrapper = NetworkRegistry.INSTANCE.newSimpleChannel("animationApi");
		wrapper.registerMessage(PacketAnimation.Handler.class, PacketAnimation.class, 0, Side.CLIENT);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent e)
	{
		proxy.initTimer();
	}
	
	public static boolean isClient()
	{
		return FMLCommonHandler.instance().getSide().isClient();
	}
	
	public static boolean isEffectiveClient()
	{
		return FMLCommonHandler.instance().getEffectiveSide().isClient();
	}
	
	public static void sendAnimationPacket(IAnimatedEntity entity, int animationId)
	{
		if(isEffectiveClient()) return;
		entity.setAnimationId(animationId);
		wrapper.sendToAll(new PacketAnimation((byte)animationId, ((Entity)entity).getEntityId()));
	}
}
