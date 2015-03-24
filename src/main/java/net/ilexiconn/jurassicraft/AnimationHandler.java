package net.ilexiconn.jurassicraft;

import cpw.mods.fml.common.FMLCommonHandler;
import net.ilexiconn.jurassicraft.interfaces.IAnimatedEntity;
import net.ilexiconn.jurassicraft.packet.MessageAnimation;
import net.minecraft.entity.Entity;

public class AnimationHandler
{
    public static boolean isClient()
    {
        return FMLCommonHandler.instance().getSide().isClient();
    }
    
    public static boolean isEffectiveClient()
    {
        return FMLCommonHandler.instance().getEffectiveSide().isClient();
    }
    
    public static void sendAnimationPacket(IAnimatedEntity entity, int animationId)
    {
        if (isEffectiveClient())
        {
            return;
        }
        
        entity.setAnimationId(animationId);
       
        JurassiCraft.networkWrapper.sendToAll(new MessageAnimation((byte) animationId, ((Entity) entity).getEntityId()));
    }
}
