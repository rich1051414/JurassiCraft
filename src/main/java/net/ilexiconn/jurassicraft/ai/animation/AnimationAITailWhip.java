package net.ilexiconn.jurassicraft.ai.animation;

import java.util.List;

import net.ilexiconn.jurassicraft.entity.EntityJurassiCraftSmart;
import net.ilexiconn.jurassicraft.enums.JurassiCraftAnimationIDs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;

public class AnimationAITailWhip extends AIAnimation
{
    private EntityJurassiCraftSmart creature;
    private double maximumDistance;
    private double searchDistance;
    private int duration;
    
    public AnimationAITailWhip(EntityJurassiCraftSmart creature, int duration, double searchDistance, double maximumDistance)
    {
        super(creature);
        this.creature = creature;
        this.duration = duration;
        this.searchDistance = searchDistance;
        this.maximumDistance = maximumDistance;
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
        if (this.creature.getAnimationTick() == (this.duration / 2 - 2))
        {
            List<Entity> entityList = this.creature.worldObj.getEntitiesWithinAABBExcludingEntity(this.creature, this.creature.boundingBox.expand(this.searchDistance, this.searchDistance / 2.0D, this.searchDistance));
            for (Entity entity : entityList)
            {
                if (entity instanceof EntityLivingBase)
                {
                    double distance = this.creature.getDistanceSqToEntity(entity);
                    double minimumDistance = (this.maximumDistance + (double) this.creature.getCreatureLength() * 0.8D) * (this.maximumDistance + (double) this.creature.getCreatureLength() * 0.8D);
                    if (distance < minimumDistance)
                    {
                        entity.attackEntityFrom(DamageSource.causeMobDamage(this.getEntity()), (float) (1.25D * this.creature.getCreatureAttack()));
                        double deltaX = entity.posX - entity.posX;
                        double deltaZ = entity.posZ - entity.posZ;
                        double angleYaw = (float) Math.atan2(deltaZ, deltaX);
                        entity.motionX += 1.05D * Math.cos(angleYaw);
                        entity.motionZ += 1.05D * Math.sin(angleYaw);
                        entity.motionY += 0.35D;
                    }
                }
            }
        }
    }
}
