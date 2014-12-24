package net.ilexiconn.jurassicraft.TESTING;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.ilexiconn.jurassicraft.JurassiCraft;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;

public class EntityJoinEventHandler
{
    @SubscribeEvent
    public void onWorldJoin(EntityEvent.EntityConstructing event)
    {
        if (event.entity instanceof EntityJurassicCreature)
        {
            event.entity.registerExtendedProperties(CreatureData.getID(), new CreatureData());
        }
    }

    @SubscribeEvent
    public void worldJoin(EntityJoinWorldEvent event)
    {
        if (event.entity instanceof EntityJurassicCreature && !event.entity.worldObj.isRemote)
        {
            JurassiCraft.network.sendToAll(new MessageUpdateCreatureData());
        }
    }
}
