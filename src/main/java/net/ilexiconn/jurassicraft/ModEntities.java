package net.ilexiconn.jurassicraft;

import cpw.mods.fml.common.registry.EntityRegistry;
import net.ilexiconn.jurassicraft.content.IContentHandler;
import net.ilexiconn.jurassicraft.entity.EntitySpit;
import net.ilexiconn.jurassicraft.entity.egg.EntityDinoEgg;
import net.minecraft.entity.Entity;

public class ModEntities implements IContentHandler
{
    public void init()
    {
        registerEntity(EntityDinoEgg.class, "dino_egg", 64, 1, true);
        registerEntity(EntitySpit.class, "dilo_spit", 64, 1, true);
    }
    
    private void registerEntity(Class<? extends Entity> entityClass, String name, int trackingRange, int updateFrequency, boolean sendsVelocityUpdates)
    {
        int entityId = EntityRegistry.findGlobalUniqueEntityId();
        
        EntityRegistry.registerGlobalEntityID(entityClass, name, entityId);
        EntityRegistry.registerModEntity(entityClass, name, entityId, JurassiCraft.instance, trackingRange, updateFrequency, sendsVelocityUpdates);
    }
}
