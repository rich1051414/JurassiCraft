package net.ilexiconn.jurassicraft.ai.herds;

import net.ilexiconn.jurassicraft.entity.EntityJurassiCraftCreature;

public class HerdAIGroupAttack extends EntityAIHerd
{

    public HerdAIGroupAttack(EntityJurassiCraftCreature creature)
    {
        super(creature);
    }
    
    public void startExecuting()
    {
        super.startExecuting();
        if(getHerd() != null)
            getHerd().attack(getCreature().getAttackTarget());
    }

    @Override
    public boolean shouldExecute()
    {
        return getCreature().getAttackTarget() != null;
    }
    
    @Override
    public boolean continueExecuting()
    {
        return getCreature().getAttackTarget() != null && getCreature().getAttackTarget().isEntityAlive();
    }

}
