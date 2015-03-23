package net.ilexiconn.jurassicraft.container;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

public class ContainerDinoPadPregnancy extends Container
{
    public Entity creatureToAnalyze;
    
    public ContainerDinoPadPregnancy(Entity creatureToAnalyze)
    {
        this.creatureToAnalyze = creatureToAnalyze;
    }
    
    public boolean canInteractWith(EntityPlayer player)
    {
        return true;
    }
}
