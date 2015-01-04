package net.ilexiconn.jurassicraft.client.animation;

import net.ilexiconn.jurassicraft.entity.dinosaurs.EntityTriceratops;
import net.minecraft.entity.EntityLivingBase;
import thehippomaster.AnimationAPI.AIAnimation;

public class AITriceratopsCharge extends AIAnimation
{
    private EntityTriceratops entityTric;
    private EntityLivingBase attackTarget = null;
    private float angleYaw;
    private float chargeSpeed = 1;
    private float chargeAcceleration = 0.2F;

    public AITriceratopsCharge(EntityTriceratops tric)
    {
        super(tric);
        entityTric = tric;
    }

    public int getAnimationId()
    {
        return 1;
    }

    public boolean isAutomatic()
    {
        return true;
    }

    public int getDuration()
    {
        return 100;
    }

    public void startExecuting()
    {
        super.startExecuting();
        attackTarget = entityTric.getAttackTarget();
    }

    public void resetTask()
    {
        super.resetTask();
        entityTric.timeSinceCharge = 150;
        entityTric.charging = false;
        entityTric.setAttackTarget(null);
    }

    public void updateTask()
    {
        if (entityTric.getAnimationTick() < 40)
        {
            if (attackTarget != null)
            {
                entityTric.getLookHelper().setLookPositionWithEntity(attackTarget, 30F, 30F);
            }
        }

        if (entityTric.getAnimationTick() >= 35 && entityTric.getAnimationTick() <= 40)
        {
            if (attackTarget != null)
            {
                double deltaX = attackTarget.posX - entityTric.posX;
                double deltaZ = attackTarget.posZ - entityTric.posZ;

                angleYaw = (float) Math.atan2(deltaZ, deltaX);
            }
        }
        if (entityTric.getAnimationTick() > 40)
        {
            entityTric.charging = true;
            if (attackTarget != null)
            {
                if (Math.sqrt(entityTric.motionX * entityTric.motionX + entityTric.motionZ * entityTric.motionZ) < chargeSpeed - 0.2)
                {
                    entityTric.motionX += chargeAcceleration * Math.cos(angleYaw);
                    entityTric.motionZ += chargeAcceleration * Math.sin(angleYaw);
                }
                else
                {
                    entityTric.motionX = chargeSpeed * Math.cos(angleYaw);
                    entityTric.motionZ = chargeSpeed * Math.sin(angleYaw);
                }
            }
        }
    }
}
