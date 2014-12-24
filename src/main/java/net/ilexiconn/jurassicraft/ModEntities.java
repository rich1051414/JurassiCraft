package net.ilexiconn.jurassicraft;

import cpw.mods.fml.common.registry.EntityRegistry;
import net.ilexiconn.jurassicraft.content.IContentHandler;
import net.ilexiconn.jurassicraft.entity.egg.EntityDinoEgg;

public class ModEntities implements IContentHandler
{
    public void init()
    {
        int findGlobalUniqueEntityId = EntityRegistry.findGlobalUniqueEntityId();
		EntityRegistry.registerModEntity(EntityDinoEgg.class, "dino_egg", findGlobalUniqueEntityId, JurassiCraft.instance, 64, 1, true);
		EntityRegistry.registerGlobalEntityID(EntityDinoEgg.class, "dino_egg", findGlobalUniqueEntityId);
    }
}
