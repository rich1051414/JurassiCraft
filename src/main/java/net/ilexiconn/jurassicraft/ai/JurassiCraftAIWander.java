package net.ilexiconn.jurassicraft.ai;

import net.ilexiconn.jurassicraft.entity.EntityJurassiCraftTameable;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.util.Vec3;

public class JurassiCraftAIWander extends EntityAIBase
{
    private EntityJurassiCraftTameable creature;
    private int leftWalk;
    private double xPosition;
    private double xDirection;
    private double yPosition;
    private double zPosition;
    private double zDirection;
    private double speed;
    private double maxDistance;
    private double maxHeight;

    public JurassiCraftAIWander(EntityJurassiCraftTameable entity, double distance, double height, double velocity)
    {
        this.creature = entity;
        this.speed = velocity;
        this.maxDistance = distance;
        this.maxHeight = height;
        this.setMutexBits(1);
    }

    public JurassiCraftAIWander(EntityJurassiCraftTameable entity, double velocity)
    {
        this.creature = entity;
        this.speed = velocity;
        this.maxDistance = 16;
        this.maxHeight = 6;
        this.setMutexBits(1);
    }

    public boolean shouldExecute()
    {
    	if (this.creature.isSitting() || this.creature.riddenByEntity != null)
    	{
    		return false;
    	}
    	else if (this.leftWalk > 0)
        {
            this.leftWalk--;
            Vec3 toward = Vec3.createVectorHelper(this.xPosition + this.xDirection, 0, this.zPosition + this.zDirection);
            Vec3 vec3 = RandomPositionGenerator.findRandomTargetBlockTowards(this.creature, (int) (this.maxDistance), (int) this.maxHeight, toward);
            if (vec3 == null)
            {
                return false;
            }
            else
            {
                this.xPosition = vec3.xCoord;
                this.yPosition = vec3.yCoord;
                this.zPosition = vec3.zCoord;
                return true;
            }
        }
        else
        {
            if (this.creature.getRNG().nextInt(120) == 0)
            {
                this.leftWalk = (int) Math.sqrt(this.creature.getGrowthStage());
                this.xDirection = this.creature.getRNG().nextInt((int) (this.maxDistance * 2) + 1) - this.maxDistance;
                this.zDirection = this.creature.getRNG().nextInt((int) (this.maxDistance * 2) + 1) - this.maxDistance;
                return false;
            }
            else
            {
                return false;
            }
        }
    }

    public void startExecuting()
    {
        this.creature.getNavigator().tryMoveToXYZ(this.xPosition, this.yPosition, this.zPosition, this.speed);
    }

    public boolean continueExecuting()
    {
        return !this.creature.getNavigator().noPath() && !this.creature.isSitting() && this.creature.riddenByEntity != null;
    }

}
