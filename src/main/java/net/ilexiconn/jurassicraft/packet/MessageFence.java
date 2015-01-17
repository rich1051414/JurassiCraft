package net.ilexiconn.jurassicraft.packet;

import io.netty.buffer.ByteBuf;
import net.ilexiconn.jurassicraft.tile.TileSecurityFenceLowMain;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MessageFence implements IMessage
{
    private int id;
    private int xCoord;
    private int yCoord;
    private int zCoord;
    private int side;

    public MessageFence()
    {
    	
    }

    public MessageFence(int id, int xCoord, int yCoord, int zCoord, int side)
    {
        this.id = id;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.zCoord = zCoord;
        this.side = side;
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
        id = ByteBufUtils.readVarInt(buf, 5);
        xCoord = ByteBufUtils.readVarInt(buf, 5);
        yCoord = ByteBufUtils.readVarInt(buf, 5);
        zCoord = ByteBufUtils.readVarInt(buf, 5);
        side = ByteBufUtils.readVarInt(buf, 5);
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        ByteBufUtils.writeVarInt(buf, id, 5);
        ByteBufUtils.writeVarInt(buf, xCoord, 5);
        ByteBufUtils.writeVarInt(buf, yCoord, 5);
        ByteBufUtils.writeVarInt(buf, zCoord, 5);
        ByteBufUtils.writeVarInt(buf, side, 5);
    }

    public static class Handler implements IMessageHandler<MessageFence, IMessage>
    {
        @Override
        public IMessage onMessage(MessageFence message, MessageContext ctx)
        {
            if (ctx.getServerHandler().playerEntity != (EntityPlayer) null)
            {
                if (!ctx.getServerHandler().playerEntity.worldObj.isRemote)
                {
                	if (message.id > -1 && message.id < 4)
                	{
                		TileEntity tileEntity = ctx.getServerHandler().playerEntity.worldObj.getTileEntity(message.xCoord, message.yCoord, message.zCoord);
                        switch (message.id)
                        {
                        	/** Build Low Security */
                        	case 0:
                        		if (tileEntity instanceof TileSecurityFenceLowMain)
                                {
                                    if (message.side > -1 && message.side < 4)
                                    	((TileSecurityFenceLowMain) tileEntity).tryToBuildFence(message.side);
                                }
                        		break;
                            /** Turn On of Off Low Security */
                        	case 1:
                        		if (tileEntity instanceof TileSecurityFenceLowMain)
                                {
                                    if (message.side > -1 && message.side < 4)
                                    	((TileSecurityFenceLowMain) tileEntity).tryToTurnOnTheFence(message.side);
                                }
                        		break;
                            /** Fix Low Security */
                        	case 2:
                        		if (tileEntity instanceof TileSecurityFenceLowMain)
                                {
                                    if (message.side > -1 && message.side < 4)
                                    	((TileSecurityFenceLowMain) tileEntity).tryToFixFence(message.side);
                                }
                        		break;
                        }
                	}
                }
            }
            return null;
        }
    }
}
