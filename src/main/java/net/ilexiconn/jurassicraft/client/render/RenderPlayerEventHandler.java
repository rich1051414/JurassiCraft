package net.ilexiconn.jurassicraft.client.render;

import com.mojang.authlib.minecraft.MinecraftProfileTexture;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.ilexiconn.jurassicraft.JurassiCraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderPlayerEvent;

import java.util.UUID;

@SideOnly(Side.CLIENT)
public class RenderPlayerEventHandler
{
    public ResourceLocation capeDeveloper = new ResourceLocation("jurassicraft", "textures/cape/developer_cape.png");
    public ResourceLocation capePatron = new ResourceLocation("jurassicraft", "textures/cape/patron_cape.png");

    @SubscribeEvent
    public void playerRender(RenderPlayerEvent.Pre event)
    {
        if (event.entityPlayer instanceof AbstractClientPlayer && isDeveloper(event.entityPlayer.getUniqueID()))
        {
            ((AbstractClientPlayer) event.entityPlayer).func_152121_a(MinecraftProfileTexture.Type.CAPE, capeDeveloper);
        }
        else if (event.entityPlayer instanceof AbstractClientPlayer && isPatron(event.entityPlayer.getUniqueID()))
        {
            ((AbstractClientPlayer) event.entityPlayer).func_152121_a(MinecraftProfileTexture.Type.CAPE, capePatron);
        }
    }

    public boolean isDeveloper(UUID uuid)
    {
        return JurassiCraft.capeContainer.getDevelopers().contains(uuid.toString());
    }

    public boolean isPatron(UUID uuid)
    {
        return JurassiCraft.capeContainer.getPatrons().contains(uuid.toString());
    }
}
