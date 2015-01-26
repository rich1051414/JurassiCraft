package net.ilexiconn.jurassicraft.ai.animation;

import net.ilexiconn.jurassicraft.ai.AIAnimation;
import net.ilexiconn.jurassicraft.entity.EntityJurassiCraftSmart;
import net.ilexiconn.jurassicraft.enums.JurassiCraftAnimationIDs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;

public class AnimationAITailWhip extends AIAnimation
{
    private EntityJurassiCraftSmart creature;
    private int duration;

    public AnimationAITailWhip(EntityJurassiCraftSmart creature, int duration)
    {
        super(creature);
        this.creature = creature;
        this.duration = duration;
    }

    @Override
    public int getAnimationId()
    {
        return JurassiCraftAnimationIDs.TAIL_WHIP.animID();
    }

    @Override
    public boolean isAutomatic()
    {
        return true;
    }

    @Override
    public int getDuration()
    {
        return this.duration;
    }

    @Override
    public void updateTask()
    {
        if (this.creature.getAttackTarget() != null)
        {
            if (this.creature.getAnimationTick() < (this.duration / 2 - 2))
            {
                EntityLivingBase target = this.creature.getAttackTarget();
                target.attackEntityFrom(DamageSource.causeMobDamage(this.getEntity()), (float) (1.6D * this.creature.getCreatureAttack()));
                double deltaX = target.posX - target.posX;
                double deltaZ = target.posZ - target.posZ;
                double angleYaw = (float) Math.atan2(deltaZ, deltaX);
                target.motionX += 1.05D * Math.cos(angleYaw);
                target.motionZ += 1.05D * Math.sin(angleYaw);
                target.motionY += 0.35D;
            }
        }
    }
}
