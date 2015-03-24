package net.ilexiconn.jurassicraft.utility.handlers;

import net.ilexiconn.jurassicraft.block.carboniferous.BlockLeaves;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraft.item.ItemShears;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerEvent.BreakSpeed;

/**
 * @author ProPercivalalb
 **/
public class PlayerBreakSpeed
{
    @SubscribeEvent
    public void breakSpeed(BreakSpeed event)
    {
        Block block = event.block;
        
        if (block != null && block instanceof BlockLeaves)
        {
            ItemStack item = event.entityPlayer.getCurrentEquippedItem();
           
            if (item != null && item.getItem() instanceof ItemShears)
            {
                event.newSpeed = 15.0F;
            }
        }
    }
}
