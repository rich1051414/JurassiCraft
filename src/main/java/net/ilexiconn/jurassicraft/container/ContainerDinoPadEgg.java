package net.ilexiconn.jurassicraft.container;

import net.ilexiconn.jurassicraft.entity.egg.EntityDinoEgg;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

public class ContainerDinoPadEgg extends Container
{
    public EntityDinoEgg eggToAnalyze;

    public ContainerDinoPadEgg(EntityDinoEgg e)
    {
        eggToAnalyze = e;
    }

    public boolean canInteractWith(EntityPlayer player)
    {
        return true;
    }
}
