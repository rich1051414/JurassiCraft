package net.ilexiconn.jurassicraft.ai.animation;

import net.ilexiconn.jurassicraft.ai.AIAnimation;
import net.ilexiconn.jurassicraft.entity.dinosaurs.EntityTriceratops;
import net.ilexiconn.jurassicraft.enums.JurassiCraftAnimationIDs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;

public class AnimationAITriceratopsCharge extends AIAnimation
{
    private EntityTriceratops entityTriceratops;
    private EntityLivingBase attackTarget;
    private float chargeAcceleration;
    private float chargeSpeed;
    private float angleYaw;
    private float startX;
    private float startZ;
    private float distanceTravelled;
    private float distanceOfTargetFromStart;

    public AnimationAITriceratopsCharge(EntityTriceratops triceratops)
    {
        super(triceratops);
        this.entityTriceratops = triceratops;
        this.attackTarget = null;
        this.chargeAcceleration = 0.2F;
        this.chargeSpeed = 1;
        this.angleYaw = 0.0F;
        this.startX = 0.0F;
        this.startZ = 0.0F;
        this.distanceTravelled = 0.0F;
        this.distanceOfTargetFromStart = 0.0F;
    }

    public int getAnimationId()
    {
        return JurassiCraftAnimationIDs.CHARGE.animID();
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
        this.attackTarget = this.entityTriceratops.getAttackTarget();
        this.startX = (float) this.entityTriceratops.posX;
        this.startZ = (float) this.entityTriceratops.posZ;
        if (this.attackTarget != null)
            this.distanceOfTargetFromStart = (float) Math.sqrt((this.startX - this.attackTarget.posX) * (this.startX - this.attackTarget.posX) + (this.startZ - this.attackTarget.posZ) * (this.startZ - this.attackTarget.posZ));
    }

    public void resetTask()
    {
        super.resetTask();
        this.entityTriceratops.timeSinceCharge = 150;
        this.entityTriceratops.charging = false;
        this.entityTriceratops.setAttackTarget(null);
    }

    public void updateTask()
    {
        if (this.attackTarget != null)
            this.entityTriceratops.getLookHelper().setLookPositionWithEntity(this.attackTarget, 30F, 30F);
        
        this.distanceTravelled = (float) Math.sqrt((this.startX - this.entityTriceratops.posX) * (this.startX - this.entityTriceratops.posX) + (this.startZ - this.entityTriceratops.posZ) * (this.startZ - this.entityTriceratops.posZ));
        if (this.entityTriceratops.getAnimationTick() == 1)
            this.entityTriceratops.playSound("jurassicraft:TriceratopsCharge", 1.0F, 1.0F);

        if (this.entityTriceratops.getAnimationTick() >= 35 && this.entityTriceratops.getAnimationTick() <= 40 && this.attackTarget != null)
        {
            double deltaX = this.attackTarget.posX - this.entityTriceratops.posX;
            double deltaZ = this.attackTarget.posZ - this.entityTriceratops.posZ;
            this.angleYaw = (float) Math.atan2(deltaZ, deltaX);
        }

        if (this.entityTriceratops.getAnimationTick() > 40)
        {
            if (this.attackTarget != null || this.entityTriceratops.riddenByEntity != null)
            {
                if (this.entityTriceratops.riddenByEntity != null && this.entityTriceratops.riddenByEntity instanceof EntityPlayer)
                {
                    this.angleYaw = this.entityTriceratops.riddenByEntity.rotationYaw * 0.01745329251F + 1.57079632679F;
                    this.entityTriceratops.rotationYaw = this.entityTriceratops.riddenByEntity.rotationYaw;
                    this.chargeAcceleration = 0.3F;
                }
                this.entityTriceratops.charging = true;
                if (attackTarget != null && this.distanceOfTargetFromStart > distanceTravelled)
                {
                    double deltaX = this.attackTarget.posX - this.entityTriceratops.posX;
                    double deltaZ = this.attackTarget.posZ - this.entityTriceratops.posZ;
                    this.angleYaw = (float) Math.atan2(deltaZ, deltaX);
                }
                if (Math.sqrt(this.entityTriceratops.motionX * this.entityTriceratops.motionX + this.entityTriceratops.motionZ * this.entityTriceratops.motionZ) < this.chargeSpeed - 0.2)
                {
                    this.entityTriceratops.motionX += this.chargeAcceleration * Math.cos(this.angleYaw);
                    this.entityTriceratops.motionZ += this.chargeAcceleration * Math.sin(this.angleYaw);
                }
                else
                {
                    this.entityTriceratops.motionX = this.chargeSpeed * Math.cos(this.angleYaw);
                    this.entityTriceratops.motionZ = this.chargeSpeed * Math.sin(this.angleYaw);
                }
            }
        }
    }
}
