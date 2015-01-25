package net.ilexiconn.jurassicraft.ai.animation;

import net.ilexiconn.jurassicraft.ai.AIAnimation;
import net.ilexiconn.jurassicraft.entity.dinosaurs.EntityTriceratops;
import net.ilexiconn.jurassicraft.enums.JurassiCraftAnimationIDs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;

public class AnimationAITriceratopsCharge extends AIAnimation
{
    private EntityTriceratops entityTric;
    private EntityLivingBase attackTarget = null;
    private float chargeAcceleration = 0.2F;
    private float chargeSpeed = 1;
    private float angleYaw = 0.0F;
    private float startX;
    private float startZ;
    private float distanceTravelled;
    private float distanceOfTargetFromStart;

    public AnimationAITriceratopsCharge(EntityTriceratops tric)
    {
        super(tric);
        this.entityTric = tric;
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
        this.attackTarget = this.entityTric.getAttackTarget();
        startX = (float) entityTric.posX;
        startZ = (float) entityTric.posZ;
    	if (attackTarget != null) distanceOfTargetFromStart = (float) Math.sqrt((startX - attackTarget.posX) * (startX - attackTarget.posX) + (startZ - attackTarget.posZ) * (startZ - attackTarget.posZ));
    }

    public void resetTask()
    {
        super.resetTask();
        this.entityTric.timeSinceCharge = 150;
        this.entityTric.charging = false;
        this.entityTric.setAttackTarget(null);
    }

    public void updateTask()
    {
    	distanceTravelled = (float) Math.sqrt((startX - entityTric.posX) * (startX - entityTric.posX) + (startZ - entityTric.posZ) * (startZ - entityTric.posZ));    	
        if (this.entityTric.getAnimationTick() == 1) entityTric.playSound("jurassicraft:TriceratopsCharge", 1.0F, 1.0F);

        if (this.entityTric.getAnimationTick() < 40 && this.attackTarget != null) this.entityTric.getLookHelper().setLookPositionWithEntity(this.attackTarget, 30F, 30F);

        if (this.entityTric.getAnimationTick() >= 35 && this.entityTric.getAnimationTick() <= 40 && this.attackTarget != null)
        {
                double deltaX = this.attackTarget.posX - this.entityTric.posX;
                double deltaZ = this.attackTarget.posZ - this.entityTric.posZ;
                this.angleYaw = (float) Math.atan2(deltaZ, deltaX);
        }
        
        if (this.entityTric.getAnimationTick() > 40)
        {
            if (this.attackTarget != null || this.entityTric.riddenByEntity != null)
            {
            	if (this.entityTric.riddenByEntity != null && this.entityTric.riddenByEntity instanceof EntityPlayer) {
            		this.angleYaw = (float) (entityTric.riddenByEntity.rotationYaw * Math.PI/180 + Math.PI/2);
            		entityTric.rotationYaw = entityTric.riddenByEntity.rotationYaw;
            		this.chargeAcceleration = 0.3F;
            	}
            	this.entityTric.charging = true;
            	if (attackTarget != null && distanceOfTargetFromStart > distanceTravelled) {
            		double deltaX = this.attackTarget.posX - this.entityTric.posX;
                    double deltaZ = this.attackTarget.posZ - this.entityTric.posZ;
            		angleYaw = (float) Math.atan2(deltaZ, deltaX);
            	}
                if (Math.sqrt(this.entityTric.motionX * this.entityTric.motionX + this.entityTric.motionZ * this.entityTric.motionZ) < this.chargeSpeed - 0.2)
                {
                	this.entityTric.motionX += this.chargeAcceleration * Math.cos(angleYaw);
                    this.entityTric.motionZ += this.chargeAcceleration * Math.sin(angleYaw);
                }
                else
                {
                	this.entityTric.motionX = this.chargeSpeed * Math.cos(angleYaw);
                	this.entityTric.motionZ = this.chargeSpeed * Math.sin(angleYaw);
                }
            }
        }
    }
}
