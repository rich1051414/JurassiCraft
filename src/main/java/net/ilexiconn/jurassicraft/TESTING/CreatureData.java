package net.ilexiconn.jurassicraft.TESTING;

import net.ilexiconn.jurassicraft.entity.Creature;
import net.ilexiconn.jurassicraft.entity.CreatureManager;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class CreatureData implements IExtendedEntityProperties
{
    public Creature creature;
    public int ticksExisted;
    public float geneticQuality;
    public float bBoxXZ;
    public float bBoxY;
    public boolean gender;
    public byte texture;

    public void saveNBTData(NBTTagCompound tag)
    {
        tag.setByte("creature", creature.getCreatureID());
        tag.setInteger("ticksExisted", ticksExisted);
        tag.setFloat("geneticQuality", geneticQuality);
        tag.setFloat("bBoxXZ", bBoxXZ);
        tag.setFloat("bBoxY", bBoxY);
        tag.setBoolean("gender", gender);
        tag.setByte("texture", texture);
    }

    public void loadNBTData(NBTTagCompound tag)
    {
        creature = CreatureManager.getCreatureFromId(tag.getByte("creature"));
        ticksExisted = tag.getInteger("ticksExisted");
        geneticQuality = tag.getFloat("geneticQuality");
        bBoxXZ = tag.getFloat("bBoxXZ");
        bBoxY = tag.getFloat("bBoxY");
        gender = tag.getBoolean("gender");
        texture = tag.getByte("texture");
    }

    public static String getID()
    {
        return "creatureData";
    }

    public void init(Entity entity, World world)
    {

    }
}
