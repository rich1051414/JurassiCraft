package net.ilexiconn.jurassicraft.ai;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAITarget;
import net.ilexiconn.jurassicraft.entity.EntityJurassiCraftTameable;

public class JurassiCraftEntityAIOwnerHurtByTarget extends EntityAITarget
{
    EntityJurassiCraftTameable defendingTameable;
    EntityLivingBase whoTheOwnerIsAttacking;
    private int revengeTime;

    public JurassiCraftEntityAIOwnerHurtByTarget(EntityJurassiCraftTameable entityTameable)
    {
        super(entityTameable, false);
        this.defendingTameable = entityTameable;
        this.setMutexBits(1);
    }

    @Override
    public boolean shouldExecute()
    {
        if (!this.defendingTameable.isTamed())
        {
            return false;
        }
        else
        {
            EntityLivingBase entitylivingbase = this.defendingTameable.getOwner();
            if (entitylivingbase == null)
            {
                return false;
            }
            else
            {
                this.whoTheOwnerIsAttacking = entitylivingbase.getAITarget();
                int i = entitylivingbase.func_142015_aE();
                if (this.whoTheOwnerIsAttacking instanceof EntityJurassiCraftTameable)
                {
                    return i != this.revengeTime && this.isSuitableTarget(this.whoTheOwnerIsAttacking, false) && (this.whoTheOwnerIsAttacking.getClass() != this.defendingTameable.getClass() || ((EntityJurassiCraftTameable) this.whoTheOwnerIsAttacking).getOwner() != this.defendingTameable.getOwner());
                }
                else
                {
                    return i != this.revengeTime && this.isSuitableTarget(this.whoTheOwnerIsAttacking, false);
                }
            }
        }
    }

    @Override
    public void startExecuting()
    {
        this.taskOwner.setAttackTarget(this.whoTheOwnerIsAttacking);
        EntityLivingBase defenderCreature = this.defendingTameable.getOwner();
        if (defenderCreature != null)
        {
            this.revengeTime = defenderCreature.func_142015_aE();
        }
        super.startExecuting();
    }
}