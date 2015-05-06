package net.ilexiconn.jurassicraft.container;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

public class ContainerDinoPadEgg extends Container
{
    public Entity creatureToAnalyze;

    public ContainerDinoPadEgg(Entity eggToAnalyze)
    {
        this.creatureToAnalyze = eggToAnalyze;
    }

    public boolean canInteractWith(EntityPlayer player)
    {
        return true;
    }
}
