package to.uk.ilexiconn.jurassicraft;

import cpw.mods.fml.common.registry.EntityRegistry;
import to.uk.ilexiconn.jurassicraft.content.IContentHandler;
import to.uk.ilexiconn.jurassicraft.entity.EntityDinoEgg;

public class ModEntities implements IContentHandler
{
    public void init()
    {
        EntityRegistry.registerModEntity(EntityDinoEgg.class, "dino_egg", EntityRegistry.findGlobalUniqueEntityId(), JurassiCraft.instance, 64, 1, true);
    }
}
