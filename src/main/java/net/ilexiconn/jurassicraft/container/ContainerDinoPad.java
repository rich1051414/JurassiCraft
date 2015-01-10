package net.ilexiconn.jurassicraft.container;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

public class ContainerDinoPad extends Container
{
	public Entity creatureToAnalyze;

    public ContainerDinoPad(Entity creatureToAnalyze)
    {
        this.creatureToAnalyze = creatureToAnalyze;
    }

    public boolean canInteractWith(EntityPlayer player)
    {
        return true;
    }
}
