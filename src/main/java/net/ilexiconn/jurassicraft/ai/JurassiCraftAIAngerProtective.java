package net.ilexiconn.jurassicraft.ai;

import net.ilexiconn.jurassicraft.entity.EntityJurassiCraftLandProtective;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIBase;

public class JurassiCraftAIAngerProtective extends EntityAIBase
{

    private EntityJurassiCraftLandProtective entity;

    public JurassiCraftAIAngerProtective(EntityLiving entityLiving)
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