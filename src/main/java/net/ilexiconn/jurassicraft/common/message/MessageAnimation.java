package net.ilexiconn.jurassicraft.common.message;

import io.netty.buffer.ByteBuf;
import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.common.api.IAnimatedEntity;
import net.ilexiconn.llibrary.common.message.AbstractMessage;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class MessageAnimation extends AbstractMessage<MessageAnimation>
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

    public void handleClientMessage(MessageAnimation message, EntityPlayer entityPlayer)
    {
        World world = JurassiCraft.proxy.getWorldClient();
        IAnimatedEntity entity = (IAnimatedEntity) world.getEntityByID(message.entityId);
        if (entity != null && message.animationId != -1)
        {
            entity.setAnimationId(message.animationId);
            if (message.animationId == 0) entity.setAnimationTick(0);
        }
    }

    public void handleServerMessage(MessageAnimation message, EntityPlayer entityPlayer)
    {

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
}
