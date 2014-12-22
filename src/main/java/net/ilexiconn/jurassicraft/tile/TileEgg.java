package net.ilexiconn.jurassicraft.tile;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.ilexiconn.jurassicraft.Util;

import java.lang.reflect.InvocationTargetException;

public class TileEgg extends TileEntity
{
    private String dinoName;
    private int hatchTime;
    private int totalHatchTime;

    public TileEgg(String dinoName)
    {
        setDinoName(dinoName);
        setHatchTime(0);
        totalHatchTime = 1024;
    }

    public void setDinoName(String dinoName)
    {
        this.dinoName = dinoName;
    }

    public String getDinoName()
    {
        return dinoName;
    }

    public void setHatchTime(int hatchTime)
    {
        this.hatchTime = hatchTime;
    }

    public int getHatchTime()
    {
        return hatchTime;
    }

    public Packet getDescriptionPacket()
    {
        NBTTagCompound tag = new NBTTagCompound();
        writeToNBT(tag);
        return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 1, tag);
    }

    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet)
    {
        readFromNBT(packet.func_148857_g());
    }

    public void writeToNBT(NBTTagCompound tag)
    {
        super.writeToNBT(tag);
        tag.setString("name", dinoName);
        tag.setInteger("hatchTime", hatchTime);
    }

    public void readFromNBT(NBTTagCompound tag)
    {
        super.readFromNBT(tag);
        dinoName = tag.getString("name");
        hatchTime = tag.getInteger("hatchTime");
    }

    public void updateEntity()
    {
        hatchTime++;

        if (!worldObj.isRemote)
        {
            if (hatchTime >= totalHatchTime)
            {
                Class dinoToSpawnClass = Util.getCreatureClass(dinoName);
                try
                {
                    Entity dinoToSpawn = (Entity) dinoToSpawnClass.getConstructor(World.class).newInstance(worldObj);
                    dinoToSpawn.setPosition(xCoord, yCoord, zCoord);
                    worldObj.spawnEntityInWorld(dinoToSpawn);
                    worldObj.setBlockToAir(xCoord, yCoord, zCoord);
                }
                catch (InstantiationException e)
                {
                    e.printStackTrace();
                }
                catch (IllegalAccessException e)
                {
                    e.printStackTrace();
                }
                catch (IllegalArgumentException e)
                {
                    e.printStackTrace();
                }
                catch (InvocationTargetException e)
                {
                    e.printStackTrace();
                }
                catch (NoSuchMethodException e)
                {
                    e.printStackTrace();
                }
                catch (SecurityException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
}