package net.ilexiconn.jurassicraft.packet;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.ilexiconn.jurassicraft.tile.TileSecurityFence;

public class MessageFenceFixing implements IMessage 
{

	private int xCoord;
	private int yCoord;
	private int zCoord;
	private int securityLevel;
	private int direction;
	private int distance;
	private int height;
	private int bases;
	private int grids;
	private int poles;
	

	public MessageFenceFixing() 
	{

	}

	public MessageFenceFixing(int xCoord, int yCoord, int zCoord, int securityLevel, int direction, int distance, int height, int bases, int grids, int poles) 
	{
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.zCoord = zCoord;
		this.securityLevel = securityLevel;
		this.direction = direction;
		this.distance = distance;
		this.height = height;
		this.bases = bases;
		this.grids = grids;
		this.poles = poles;
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
		bases = ByteBufUtils.readVarInt(buf, 5);
		grids = ByteBufUtils.readVarInt(buf, 5);
		poles = ByteBufUtils.readVarInt(buf, 5);
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
		ByteBufUtils.writeVarInt(buf, bases, 5);
		ByteBufUtils.writeVarInt(buf, grids, 5);
		ByteBufUtils.writeVarInt(buf, poles, 5);
	}

	public static class Handler implements IMessageHandler<MessageFenceFixing, IMessage> 
	{
		@Override
		public IMessage onMessage(MessageFenceFixing message, MessageContext ctx) 
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
							fence.tryToFixFence(message.securityLevel, message.direction, message.distance, message.height, message.bases, message.grids, message.poles);
						}
					}
				}
			}
			return null;
		}
	}
}
