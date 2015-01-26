package net.ilexiconn.jurassicraft.tile;

import net.ilexiconn.jurassicraft.entity.Creature;
import net.ilexiconn.jurassicraft.entity.CreatureManager;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import java.lang.reflect.InvocationTargetException;

public class TileEgg extends TileEntity
{
    private int dinoID;
    private int hatchTime;
    private int totalHatchTime;

    private Creature creature;

    public TileEgg(int dinoID)
    {
        setDinoID(dinoID);
        setHatchTime(0);
        totalHatchTime = 1024;
    }

    public void setDinoID(int dinoID)
    {
        if (this.dinoID != dinoID)
        {
            creature = CreatureManager.getCreatureFromId(dinoID);
        }
        this.dinoID = dinoID;
    }

    public int getDinoID()
    {
        return dinoID;
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
        tag.setInteger("id", dinoID);
        tag.setInteger("hatchTime", hatchTime);
    }

    public void readFromNBT(NBTTagCompound tag)
    {
        super.readFromNBT(tag);
        setDinoID(tag.getInteger("id"));
        hatchTime = tag.getInteger("hatchTime");
    }

    public void updateEntity()
    {
        hatchTime++;

        if (!worldObj.isRemote)
        {
            if (hatchTime >= totalHatchTime)
            {
                Class dinoToSpawnClass = creature.getCreatureClass();
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

    public Creature getCreature()
    {
        return creature;
    }
}