package net.ilexiconn.jurassicraft.TESTING;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.ilexiconn.jurassicraft.entity.Creature;
import net.ilexiconn.jurassicraft.entity.CreatureManager;

public class MessageUpdateCreatureData implements IMessage
{
    public Creature creature;
    public int ticksExisted;
    public float geneticQuality;
    public float bBoxXZ;
    public float bBoxY;
    public boolean gender;
    public byte texture;

    public void fromBytes(ByteBuf buf)
    {
        creature = CreatureManager.getCreatureFromId(buf.readByte());
        ticksExisted = buf.readInt();
        geneticQuality = buf.readFloat();
        bBoxXZ = buf.readFloat();
        bBoxY = buf.readFloat();
        gender = buf.readBoolean();
        texture = buf.readByte();
    }

    public void toBytes(ByteBuf buf)
    {
        buf.writeByte(creature.getCreatureID());
        buf.writeInt(ticksExisted);
        buf.writeFloat(geneticQuality);
        buf.writeFloat(bBoxXZ);
        buf.writeFloat(bBoxY);
        buf.writeBoolean(gender);
        buf.writeByte(texture);
    }

    public static class Handler implements IMessageHandler<MessageUpdateCreatureData, IMessage>
    {
        public IMessage onMessage(MessageUpdateCreatureData message, MessageContext ctx)
        {
            return null; //TODO
        }
    }
}
