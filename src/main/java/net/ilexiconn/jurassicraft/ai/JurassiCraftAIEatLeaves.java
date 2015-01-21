package net.ilexiconn.jurassicraft.ai;

import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.entity.EntityJurassiCraftCreature;
import net.ilexiconn.jurassicraft.interfaces.IHerbivore;
import net.minecraft.entity.ai.EntityAIBase;

public class JurassiCraftAIEatLeaves extends EntityAIBase
{

    public JurassiCraftAIEatLeaves(EntityJurassiCraftCreature creature)
    {
        if(creature instanceof IHerbivore)
        {
            ;
        }
        else
            JurassiCraft.instance.logger.error("You tried to make a non-herbivore creature to eat leaves. It won't like it, do not try it, plz.");
    }
    
    @Override
    public boolean shouldExecute()
    {
        // TODO Auto-generated method stub
        return false;
    }

}
