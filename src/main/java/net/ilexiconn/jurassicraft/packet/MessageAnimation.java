package net.ilexiconn.jurassicraft.packet;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.interfaces.IAnimatedEntity;
import net.minecraft.world.World;

public class MessageAnimation implements IMessage
{
    private byte animationId;
    private int entityId;

    public MessageAnimation()
    {
        this((byte) 0, 0);
    }

    public MessageAnimation(byte animation, int entity)
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

    public static class Handler implements IMessageHandler<MessageAnimation, IMessage>
    {
        public IMessage onMessage(MessageAnimation packet, MessageContext ctx)
        {
            World world = JurassiCraft.proxy.getWorldClient();
            IAnimatedEntity entity = (IAnimatedEntity) world.getEntityByID(packet.entityId);
            if (entity != null && packet.animationId != -1)
            {
                entity.setAnimationId(packet.animationId);
                if (packet.animationId == 0)
                    entity.setAnimationTick(0);
            }
            return null;
        }
    }
}
