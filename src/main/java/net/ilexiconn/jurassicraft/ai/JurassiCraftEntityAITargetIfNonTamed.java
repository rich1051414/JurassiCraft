package net.ilexiconn.jurassicraft.ai;

import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.ilexiconn.jurassicraft.entity.EntityJurassiCraftTameable;

public class JurassiCraftEntityAITargetIfNonTamed extends EntityAINearestAttackableTarget
{

    private EntityJurassiCraftTameable creature;

    public JurassiCraftEntityAITargetIfNonTamed(EntityJurassiCraftTameable entityTameable, Class targetClass, int chance)
    {
        super(entityTameable, targetClass, chance, false);
        this.creature = entityTameable;
    }

    @Override
    public boolean shouldExecute()
    {
        return this.creature.isCreatureAdult() && !this.creature.isTamed() && super.shouldExecute();
    }
}