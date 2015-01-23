package net.ilexiconn.jurassicraft.client.animation;

import net.ilexiconn.jurassicraft.entity.dinosaurs.EntityVelociraptor;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;
import net.ilexiconn.jurassicraft.ai.AIAnimation;

public class AIVelociraptorLeap extends AIAnimation
{
    private EntityVelociraptor entityRaptor;
    private EntityLivingBase attackTarget;
    private double destX;
    private double destZ;
    private double targetSpeedX;
    private double targetSpeedZ;
    private double targetPrevPosX;
    private double targetPrevPosZ;

    public AIVelociraptorLeap(EntityVelociraptor raptor)
    {
        super(raptor);
        entityRaptor = raptor;
    }

    public int getAnimationId()
    {
        return 3;
    }

    public boolean isAutomatic()
    {
        return true;
    }

    public int getDuration()
    {
        return 20;
    }

    public void startExecuting()
    {
        super.startExecuting();
        attackTarget = entityRaptor.getAttackTarget();
    }
    
    public void resetTask()
    {
    	super.resetTask();
    }

    public void updateTask()
    {
        if (entityRaptor.getAnimationTick() < 10)
        {
            if (attackTarget != null)
            {
                entityRaptor.getLookHelper().setLookPositionWithEntity(attackTarget, 30F, 30F);
            }
        }
        
        if (entityRaptor.getAnimationTick() == 9) {
        	targetPrevPosX = attackTarget.posX;
        	targetPrevPosZ = attackTarget.posZ;
        }

        if (entityRaptor.getAnimationTick() == 10)
        {
        	if (attackTarget != null)
            {
        		targetSpeedX = attackTarget.posX - targetPrevPosX;
        		targetSpeedZ = attackTarget.posZ - targetPrevPosZ;
        		double leapDuration = 6;
        		destX = attackTarget.posX + targetSpeedX*leapDuration*2;
        		destZ = attackTarget.posZ + targetSpeedZ*leapDuration*2;
                double d = Math.sqrt((destX - entityRaptor.posX) * (destX - entityRaptor.posX) + (destZ - entityRaptor.posZ) * (destZ - entityRaptor.posZ));
                double a = Math.atan2((destZ - entityRaptor.posZ), (destX - entityRaptor.posX));

                entityRaptor.motionX = (d/leapDuration)*Math.cos(a);
                entityRaptor.motionZ = (d/leapDuration)*Math.sin(a);
                entityRaptor.motionY = 0.6D;
                entityRaptor.timeSinceLeap = 150;

                double I = Math.random();

                if (I >= 0.5D)
                {
                    entityRaptor.playSound("jurassicraft:RapCall01", 1.0F, 1.0F);
                }
                else
                {
                    entityRaptor.playSound("jurassicraft:RapCall02", 1.0F, 1.0F);
                }
            }
        }
    }
}