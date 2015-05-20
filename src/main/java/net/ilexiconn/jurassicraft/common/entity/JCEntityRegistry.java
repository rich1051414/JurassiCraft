package net.ilexiconn.jurassicraft.common.entity;

import cpw.mods.fml.common.registry.EntityRegistry;
import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.common.entity.egg.EntityDinoEgg;
import net.ilexiconn.llibrary.common.content.IContentHandler;

public class JCEntityRegistry implements IContentHandler
{
    public void init()
    {
        EntityRegistry.registerModEntity(EntityDinoEgg.class, "dino_egg", JurassiCraft.entityIndex++, JurassiCraft.instance, 64, 1, true);

        EntityRegistry.registerModEntity(EntitySpit.class, "dilo_spit", JurassiCraft.entityIndex++, JurassiCraft.instance, 64, 1, true);
    }

    public void gameRegistry() throws Exception
    {

    }
}
