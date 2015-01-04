package net.ilexiconn.jurassicraft.packet;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.ilexiconn.jurassicraft.tile.TileSecurityFence;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;

public class MessageFenceBuilding implements IMessage
{

    private int xCoord;
    private int yCoord;
    private int zCoord;
    private int securityLevel;
    private int direction;
    private int distance;
    private int height;


    public MessageFenceBuilding()
    {

    }

    public MessageFenceBuilding(int xCoord, int yCoord, int zCoord, int securityLevel, int direction, int distance, int height)
    {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.zCoord = zCoord;
        this.securityLevel = securityLevel;
        this.direction = direction;
        this.distance = distance;
        this.height = height;
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
        xCoord = ByteBufUtils.readVarInt(buf, 5);
        yCoord = ByteBufUtils.readVarInt(buf, 5);
        zCoord = ByteBufUtils.readVarInt(buf, 5);
        securityLevel = ByteBufUtils.readVarInt(buf, 5);
        direction = ByteBufUtils.readVarInt(buf, 5);
        distance = ByteBufUtils.readVarInt(buf, 5);
        height = ByteBufUtils.readVarInt(buf, 5);
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        ByteBufUtils.writeVarInt(buf, xCoord, 5);
        ByteBufUtils.writeVarInt(buf, yCoord, 5);
        ByteBufUtils.writeVarInt(buf, zCoord, 5);
        ByteBufUtils.writeVarInt(buf, securityLevel, 5);
        ByteBufUtils.writeVarInt(buf, direction, 5);
        ByteBufUtils.writeVarInt(buf, distance, 5);
        ByteBufUtils.writeVarInt(buf, height, 5);
    }

    public static class Handler implements IMessageHandler<MessageFenceBuilding, IMessage>
    {
        @Override
        public IMessage onMessage(MessageFenceBuilding message, MessageContext ctx)
        {
            if (ctx.getServerHandler().playerEntity != (EntityPlayer) null)
            {
                if (!ctx.getServerHandler().playerEntity.worldObj.isRemote)
                {
                    TileEntity tileEntity = ctx.getServerHandler().playerEntity.worldObj.getTileEntity(message.xCoord, message.yCoord, message.zCoord);
                    if (tileEntity instanceof TileSecurityFence)
                    {
                        TileSecurityFence fence = (TileSecurityFence) tileEntity;
                        if (message.securityLevel > -1 && message.securityLevel < 4)
                        {
                            fence.tryToBuildFence(message.securityLevel, message.direction, message.distance, message.height);
                        }
                    }
                }
            }
            return null;
        }
    }
}
