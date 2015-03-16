package net.ilexiconn.jurassicraft;

import cpw.mods.fml.common.registry.EntityRegistry;
import net.ilexiconn.jurassicraft.content.IContentHandler;
import net.ilexiconn.jurassicraft.entity.EntitySpit;
import net.ilexiconn.jurassicraft.entity.egg.EntityDinoEgg;

public class ModEntities implements IContentHandler
{
    public void init()
    {
        int EggID = EntityRegistry.findGlobalUniqueEntityId();
        EntityRegistry.registerGlobalEntityID(EntityDinoEgg.class, "dino_egg", EggID);
        EntityRegistry.registerModEntity(EntityDinoEgg.class, "dino_egg", EggID, JurassiCraft.instance, 64, 1, true);

        int SpitID = EntityRegistry.findGlobalUniqueEntityId();
        EntityRegistry.registerGlobalEntityID(EntitySpit.class, "dilo_spit", SpitID);
        EntityRegistry.registerModEntity(EntitySpit.class, "dilo_spit", SpitID, JurassiCraft.instance, 64, 1, true);
    }
}
