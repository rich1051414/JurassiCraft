package net.ilexiconn.jurassicraft.utility.handlers;

import net.ilexiconn.jurassicraft.ModBlocks;
import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraft.block.Block.SoundType;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.UseHoeEvent;

/**
 * @author ProPercivalalb
 */
public class HoeEventHandler
{
    @SubscribeEvent
    public void hoeUse(UseHoeEvent event)
    {
        World world = event.world;
        
        int x = event.x;
        int y = event.y;
        int z = event.z;
        
        if ((world.getBlock(x, y, z) == ModBlocks.dirt && world.getBlockMetadata(x, y, z) == 0) || (world.getBlock(x, y, z) == ModBlocks.grass && world.getBlockMetadata(x, y, z) == 0))
        {
            Block block = ModBlocks.tilledEarth;
            
            SoundType stepSound = block.stepSound;
           
            world.playSoundEffect((double) ((float) x + 0.5F), (double) ((float) y + 0.5F), (double) ((float) z + 0.5F), stepSound.getStepResourcePath(), (stepSound.getVolume() + 1.0F) / 2.0F, stepSound.getPitch() * 0.8F);
            
            if (!world.isRemote)
            {
                world.setBlock(x, y, z, block);
            }
           
            event.setResult(Result.ALLOW);
        }
    }
}
