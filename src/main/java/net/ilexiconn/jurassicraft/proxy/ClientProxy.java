package net.ilexiconn.jurassicraft.proxy;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.client.model.entity.player.RenderPlayerEventHandler;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy extends ServerProxy
{
    public void renderEntity(Class<? extends EntityLiving> entity, RenderLiving renderLiving)
    {
        RenderingRegistry.registerEntityRenderingHandler(entity, renderLiving);
    }

    public void renderTileEntity(Class<? extends TileEntity> tileEntity, TileEntitySpecialRenderer renderer)
    {
        ClientRegistry.bindTileEntitySpecialRenderer(tileEntity, renderer);
    }

    public void renderItem(Item item, IItemRenderer render)
    {
        MinecraftForgeClient.registerItemRenderer(item, render);
    }

    public void init()
    {
        MinecraftForge.EVENT_BUS.register(new RenderPlayerEventHandler());
        JurassiCraft.entityParser.parseClientEntities();
    }
}
