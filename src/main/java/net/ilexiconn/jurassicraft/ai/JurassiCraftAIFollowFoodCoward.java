package net.ilexiconn.jurassicraft.ai;

import net.ilexiconn.jurassicraft.entity.EntityJurassiCraftTameable;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class JurassiCraftAIFollowFoodCoward extends EntityAIBase
{
    private EntityJurassiCraftTameable temptedEntity;
    private double speed;
    private double targetX;
    private double targetY;
    private double targetZ;
    private double rotationPitchOfThePlayer;
    private double rotationYawOfThePlayer;
    private EntityPlayer temptingPlayer;
    private boolean isRunning;
    private boolean avoidWater;

    public JurassiCraftAIFollowFoodCoward(EntityJurassiCraftTameable creature, double velocity)
    {
        this.temptedEntity = creature;
        this.speed = velocity;
        this.setMutexBits(1);
        this.setMutexBits(3);
    }

    @Override
    public boolean shouldExecute()
    {
        if (this.temptedEntity.isSitting() || this.temptedEntity.riddenByEntity != null)
        {
            return false;
        }
        else
        {
            this.temptingPlayer = this.temptedEntity.worldObj.getClosestPlayerToEntity(this.temptedEntity, 10.0D);

            if (this.temptingPlayer == null)
            {
                return false;
            }
            else
            {
                ItemStack itemstack = this.temptingPlayer.getCurrentEquippedItem();
                return itemstack == null ? false : (this.temptedEntity.getCreature().isFavoriteFood(itemstack.getItem())) && this.temptedEntity.getAttackTarget() == null;
            }
        }
    }

    @Override
    public void startExecuting()
    {
        this.targetX = this.temptingPlayer.posX;
        this.targetY = this.temptingPlayer.posY;
        this.targetZ = this.temptingPlayer.posZ;
        this.isRunning = true;
        this.avoidWater = this.temptedEntity.getNavigator().getAvoidsWater();
        this.temptedEntity.getNavigator().setAvoidsWater(false);
    }

    @Override
    public void updateTask()
    {
        this.temptedEntity.getLookHelper().setLookPositionWithEntity(this.temptingPlayer, 30.0F, (float) this.temptedEntity.getVerticalFaceSpeed());
        if (this.temptedEntity.getDistanceSqToEntity(this.temptingPlayer) < 6.25D)
        {
            this.temptedEntity.getNavigator().clearPathEntity();
        }
        else
        {
            this.temptedEntity.getNavigator().tryMoveToEntityLiving(this.temptingPlayer, this.speed);
        }
    }

    @Override
    public boolean continueExecuting()
    {
        if (this.temptedEntity.getDistanceSqToEntity(this.temptingPlayer) < 24.0D)
        {
            if (this.temptingPlayer.getDistanceSq(this.targetX, this.targetY, this.targetZ) > 0.010000000000000002D)
            {
                return false;
            }
            if (Math.abs((double) this.temptingPlayer.rotationPitch - this.rotationPitchOfThePlayer) > 5.0D || Math.abs((double) this.temptingPlayer.rotationYaw - this.rotationYawOfThePlayer) > 5.0D)
            {
                return false;
            }
        }
        else
        {
            this.targetX = this.temptingPlayer.posX;
            this.targetY = this.temptingPlayer.posY;
            this.targetZ = this.temptingPlayer.posZ;
        }
        this.rotationPitchOfThePlayer = (double) this.temptingPlayer.rotationPitch;
        this.rotationYawOfThePlayer = (double) this.temptingPlayer.rotationYaw;
        return this.temptedEntity.isEntityAlive() && this.temptingPlayer.isEntityAlive() && !this.temptedEntity.isSitting() && this.temptedEntity.riddenByEntity == null;
    }

    @Override
    public void resetTask()
    {
        this.temptingPlayer = null;
        this.temptedEntity.getNavigator().clearPathEntity();
        this.isRunning = false;
        this.temptedEntity.getNavigator().setAvoidsWater(this.avoidWater);
    }

    public boolean isRunning()
    {
        return this.isRunning;
    }
}