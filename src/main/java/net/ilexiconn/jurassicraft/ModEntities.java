package net.ilexiconn.jurassicraft;

import cpw.mods.fml.common.registry.EntityRegistry;
import net.ilexiconn.jurassicraft.content.IContentHandler;
import net.ilexiconn.jurassicraft.entity.egg.EntityDinoEgg;

public class ModEntities implements IContentHandler
{
    public void init()
    {
        EntityRegistry.registerModEntity(EntityDinoEgg.class, "dino_egg", EntityRegistry.findGlobalUniqueEntityId(), JurassiCraft.instance, 64, 1, true);
    }
}
