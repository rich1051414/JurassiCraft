package net.ilexiconn.jurassicraft.ai;

import net.ilexiconn.jurassicraft.entity.EntityJurassiCraftCreature;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.util.Vec3;

public class JurassiCraftEntityAIWander extends EntityAIBase
{
    private EntityJurassiCraftCreature entity;
    private int leftWalk;
    private double xPosition;
    private double xDirection;
    private double yPosition;
    private double zPosition;
    private double zDirection;
    private double speed;
    private double maxDistance;
    private double maxHeight;

    public JurassiCraftEntityAIWander(EntityJurassiCraftCreature creature, double distance, double height, double velocity)
    {
        this.entity = creature;
        this.speed = velocity;
        this.maxDistance = distance;
        this.maxHeight = height;
        this.setMutexBits(1);
    }

    public JurassiCraftEntityAIWander(EntityJurassiCraftCreature creature, double velocity)
    {
        this.entity = creature;
        this.speed = velocity;
        this.maxDistance = 16;
        this.maxHeight = 6;
        this.setMutexBits(1);
    }

    public boolean shouldExecute()
    {

        if (leftWalk > 0)
        {
            this.leftWalk--;
            Vec3 toward = Vec3.createVectorHelper(this.xPosition + this.xDirection, 0, this.zPosition + this.zDirection);
            Vec3 vec3 = RandomPositionGenerator.findRandomTargetBlockTowards(this.entity, (int) (this.maxDistance), (int) this.maxHeight, toward);
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
            if (this.entity.getRNG().nextInt(120) == 0)
            {
                this.leftWalk = (int) Math.sqrt(this.entity.getGrowthStage());
                this.xDirection = this.entity.getRNG().nextInt((int) (this.maxDistance * 2) + 1) - this.maxDistance;
                this.zDirection = this.entity.getRNG().nextInt((int) (this.maxDistance * 2) + 1) - this.maxDistance;
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
        this.entity.getNavigator().tryMoveToXYZ(this.xPosition, this.yPosition, this.zPosition, this.speed);
    }

    public boolean continueExecuting()
    {
        return !this.entity.getNavigator().noPath();
    }

}
