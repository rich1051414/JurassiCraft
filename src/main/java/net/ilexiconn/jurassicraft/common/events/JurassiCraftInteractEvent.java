package net.ilexiconn.jurassicraft.common.events;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.ilexiconn.jurassicraft.common.JurassiCraft;
import net.ilexiconn.jurassicraft.common.entity.EntityJurassiCraftCreature;
import net.ilexiconn.jurassicraft.common.entity.egg.EntityDinoEgg;
import net.ilexiconn.jurassicraft.common.item.ItemDinoPad;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.EntityInteractEvent;

public class JurassiCraftInteractEvent
{
    @SubscribeEvent
    public void onEntityInteract(EntityInteractEvent event)
    {
        if (event.entity instanceof EntityPlayer)
        {
            if (event.target != null)
            {
                EntityPlayer player = (EntityPlayer) event.entity;
                ItemStack heldItem = player.getHeldItem();
                if (FMLCommonHandler.instance().getSide().isClient() && heldItem != null && heldItem.getItem() instanceof ItemDinoPad)
                {
                    this.showStatus(player, event);
                }
            }
        }
    }

    @SideOnly(Side.CLIENT)
    public void showStatus(EntityPlayer player, EntityInteractEvent event)
    {
        if (event.target instanceof EntityCow || event.target instanceof EntityPig || event.target instanceof EntityHorse || event.target instanceof EntitySheep)
        {
            player.openGui(JurassiCraft.instance, 13, event.target.worldObj, event.target.getEntityId(), 0, 0);
        }
        else if (event.target instanceof EntityDinoEgg)
        {
            player.openGui(JurassiCraft.instance, 51, event.target.worldObj, event.target.getEntityId(), 0, 0);
        }
        else if (event.target instanceof EntityJurassiCraftCreature)
        {
            player.openGui(JurassiCraft.instance, 69, event.target.worldObj, event.target.getEntityId(), 0, 0);
        }
    }
}