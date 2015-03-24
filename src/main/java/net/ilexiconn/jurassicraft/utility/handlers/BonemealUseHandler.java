package net.ilexiconn.jurassicraft.utility.handlers;

import net.ilexiconn.jurassicraft.ModBlocks;
import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.ilexiconn.jurassicraft.block.carboniferous.BlockSapling;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.BonemealEvent;

/**
 * @author ProPercivalalb
 */
public class BonemealUseHandler
{
    @SubscribeEvent
    public void action(BonemealEvent event)
    {
        if (event.block == ModBlocks.saplings_1)
        {
            World world = event.world;
            
            int x = event.x;
            int y = event.y;
            int z = event.z;
            
            if (applyBonemealSapling(world, x, y, z))
            {
                if (!world.isRemote)
                {
                    world.playAuxSFX(2005, x, y, z, 0);
                }
                
                event.setResult(Result.ALLOW);
            }
        }
    }
    
    public static boolean applyBonemealSapling(World world, int x, int y, int z)
    {
        if (!world.isRemote)
        {
            if ((double) world.rand.nextFloat() < 0.45D)
            {
                ((BlockSapling) ModBlocks.saplings_1).func_96477_c(world, x, y, z, world.rand);
            }
        }
        
        return true;
    }
}
