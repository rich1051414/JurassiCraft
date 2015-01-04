package thehippomaster.AnimationAPI.packet;

import io.netty.buffer.ByteBuf;
import net.minecraft.world.World;
import thehippomaster.AnimationAPI.AnimationAPI;
import thehippomaster.AnimationAPI.IAnimatedEntity;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class PacketAnimation implements IMessage
{
	private byte animationId;
	private int entityId;
	
	public PacketAnimation()
	{
		this((byte) 0, 0);
	}
	
	public PacketAnimation(byte animation, int entity)
	{
		animationId = animation;
		entityId = entity;
	}
	
	public void toBytes(ByteBuf buffer)
	{
		buffer.writeByte(animationId);
		buffer.writeInt(entityId);
	}

	public void fromBytes(ByteBuf buffer)
	{
		animationId = buffer.readByte();
		entityId = buffer.readInt();
	}

	public static class Handler implements IMessageHandler<PacketAnimation, IMessage>
	{
		public IMessage onMessage(PacketAnimation packet, MessageContext ctx)
		{
			World world = AnimationAPI.proxy.getWorldClient();
			IAnimatedEntity entity = (IAnimatedEntity)world.getEntityByID(packet.entityId);
			if(entity != null && packet.animationId != -1)
			{
				entity.setAnimationId(packet.animationId);
				if(packet.animationId == 0) entity.setAnimationTick(0);
			}
			return null;
		}
	}
}
