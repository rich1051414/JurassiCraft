package net.ilexiconn.jurassicraft.ai;

import net.ilexiconn.jurassicraft.entity.EntityJurassiCraftLandCoward;
import net.minecraft.entity.ai.EntityAIAvoidEntity;

public class JurassiCraftAIAvoidEntityIfNotTamed extends EntityAIAvoidEntity
{

    private EntityJurassiCraftLandCoward cowardCreature;

    public JurassiCraftAIAvoidEntityIfNotTamed(EntityJurassiCraftLandCoward coward, Class avoidClass, float distanceFromEntity, double farSpeed, double p_i1616_6_)
    {
        super(coward, avoidClass, distanceFromEntity, farSpeed, p_i1616_6_);
        this.cowardCreature = coward;
        this.setMutexBits(1);
    }

    @Override
    public boolean shouldExecute()
    {
        return !this.cowardCreature.isTamed() && super.shouldExecute();
    }
}