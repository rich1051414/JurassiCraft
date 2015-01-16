package net.ilexiconn.jurassicraft.ai.herds;

import net.ilexiconn.jurassicraft.entity.EntityJurassiCraftCreature;
import net.minecraft.entity.ai.EntityAIBase;

public abstract class EntityAIHerd extends EntityAIBase
{

    private CreatureHerd herd;
    private EntityJurassiCraftCreature creature;

    public EntityAIHerd(EntityJurassiCraftCreature creature)
    {
        this.creature = creature;
    }
    
    public EntityJurassiCraftCreature getCreature()
    {
        return creature;
    }
    
    public CreatureHerd getHerd()
    {
        return herd;
    }
    
    public void startExecuting()
    {
        for(CreatureHerd herd : CreatureHerd.getHerds())
        {
            if(herd.contains(creature))
            {
                this.herd = herd;
                break;
            }
            double distance = herd.getDistanceFrom(creature);
            if(distance < 35)
            {
                if(herd.isAcceptable(creature))
                {
                    this.herd = herd;
                    this.herd.add(creature);
                    break;
                }
            }
        }
        if(herd == null)
        {
            CreatureHerd herd = new CreatureHerd();
            herd.add(creature);
            CreatureHerd.registerHerd(herd);
        }
    }

}
