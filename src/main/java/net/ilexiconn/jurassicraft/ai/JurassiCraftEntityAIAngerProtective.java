package net.ilexiconn.jurassicraft.ai;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIBase;
import net.ilexiconn.jurassicraft.entity.EntityJurassiCraftLandProtective;

public class JurassiCraftEntityAIAngerProtective extends EntityAIBase
{

    private EntityJurassiCraftLandProtective entity;

    public JurassiCraftEntityAIAngerProtective(EntityLiving entityLiving)
    {
        this.entity = (EntityJurassiCraftLandProtective) entityLiving;
    }

    @Override
    public boolean shouldExecute()
    {
        return (entity.isAngry());
    }

    @Override
    public void updateTask()
    {
        this.entity.setAngerLevel((short) (entity.getAngerLevel() - 1));
        if (!entity.isAngry())
        {
            this.entity.setAngerLevel((short) 0);
            this.entity.setAttackTarget(null);
        }
    }
}