package net.ilexiconn.jurassicraft.ai;

import net.ilexiconn.jurassicraft.entity.EntityJurassiCraftTameable;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;

public class JurassiCraftAITargetIfHasAgeAndNonTamed extends EntityAINearestAttackableTarget
{

    private EntityJurassiCraftTameable creature;
    private float age;

    public JurassiCraftAITargetIfHasAgeAndNonTamed(EntityJurassiCraftTameable entityTameable, Class targetClass, int chance, float ageToAttack)
    {
        super(entityTameable, targetClass, chance, false);
        this.creature = entityTameable;
        this.age = ageToAttack;
    }

    @Override
    public boolean shouldExecute()
    {
        return this.creature.isCreatureOlderThan(this.age) && !this.creature.isTamed() && super.shouldExecute();
    }
}