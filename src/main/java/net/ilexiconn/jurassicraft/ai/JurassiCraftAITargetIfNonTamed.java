package net.ilexiconn.jurassicraft.ai;

import net.ilexiconn.jurassicraft.entity.EntityJurassiCraftTameable;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;

public class JurassiCraftAITargetIfNonTamed extends EntityAINearestAttackableTarget
{

    private EntityJurassiCraftTameable creature;

    public JurassiCraftAITargetIfNonTamed(EntityJurassiCraftTameable entityTameable, Class targetClass, int chance)
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