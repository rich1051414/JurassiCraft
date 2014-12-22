package net.ilexiconn.jurassicraft.packet;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.ilexiconn.jurassicraft.tile.TileSecurityFence;

public class MessageFenceCrafting implements IMessage 
{
	private int craftingID;
	private int xCoord;
	private int yCoord;
	private int zCoord;
	private int amount;

	public MessageFenceCrafting() 
	{

	}

	public MessageFenceCrafting(int id, int x, int y, int z, int materials) 
	{
		this.craftingID = id;
		this.xCoord = x;
		this.yCoord = y;
		this.zCoord = z;
		this.amount = materials;
	}

	@Override
	public void fromBytes(ByteBuf buf) 
	{
		this.craftingID = ByteBufUtils.readVarInt(buf, 5);
		this.xCoord = ByteBufUtils.readVarInt(buf, 5);
		this.yCoord = ByteBufUtils.readVarInt(buf, 5);
		this.zCoord = ByteBufUtils.readVarInt(buf, 5);
		this.amount = ByteBufUtils.readVarInt(buf, 5);
	}

	@Override
	public void toBytes(ByteBuf buf) 
	{
		ByteBufUtils.writeVarInt(buf, this.craftingID, 5);
		ByteBufUtils.writeVarInt(buf, this.xCoord, 5);
		ByteBufUtils.writeVarInt(buf, this.yCoord, 5);
		ByteBufUtils.writeVarInt(buf, this.zCoord, 5);
		ByteBufUtils.writeVarInt(buf, this.amount, 5);
	}

	public static class Handler implements IMessageHandler<MessageFenceCrafting, IMessage> 
	{
		@Override
		public IMessage onMessage(MessageFenceCrafting message, MessageContext ctx) 
		{
			if (ctx.getServerHandler().playerEntity != (EntityPlayer) null) 
			{
				if (!ctx.getServerHandler().playerEntity.worldObj.isRemote) 
				{
					TileEntity tileEntity = ctx.getServerHandler().playerEntity.worldObj.getTileEntity(message.xCoord, message.yCoord, message.zCoord);
					if (tileEntity instanceof TileSecurityFence) 
					{
						switch (message.craftingID) {
							case 0:
								((TileSecurityFence) tileEntity).tryToIncreaseFenceBases(message.amount);
								break;
							case 1:
								((TileSecurityFence) tileEntity).tryToIncreaseFenceGrids(message.amount);
								break;
							case 2:
								((TileSecurityFence) tileEntity).tryToIncreaseFencePoles(message.amount);
								break;
							case 3:
								((TileSecurityFence) tileEntity).tryToIncreaseFenceBases(message.amount);
								break;
							case 4:
								((TileSecurityFence) tileEntity).tryToIncreaseFenceGrids(message.amount);
								break;
							case 5:
								((TileSecurityFence) tileEntity).tryToIncreaseFencePoles(message.amount);
								break;
						}
					}
				}
			}
			return null;
		}
	}
}
