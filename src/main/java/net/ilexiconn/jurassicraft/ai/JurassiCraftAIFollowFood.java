package net.ilexiconn.jurassicraft.ai;

import net.ilexiconn.jurassicraft.entity.EntityJurassiCraftCreature;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class JurassiCraftAIFollowFood extends EntityAIBase
{
    private EntityJurassiCraftCreature temptedEntity;
    private double speed;
    private double targetX;
    private double targetY;
    private double targetZ;
    private double rotationPitchOfThePlayer;
    private double rotationYawOfThePlayer;
    private EntityPlayer temptingPlayer;
    private int delayTemptCounter;
    private boolean isRunning;
    private boolean avoidWater;

    public JurassiCraftAIFollowFood(EntityJurassiCraftCreature creature, double velocity)
    {
        this.temptedEntity = creature;
        this.speed = velocity;
        this.setMutexBits(3);
    }

    @Override
    public boolean shouldExecute()
    {
        if (this.delayTemptCounter > 0)
        {
            this.delayTemptCounter--;
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
    public void resetTask()
    {
        this.temptingPlayer = null;
        this.temptedEntity.getNavigator().clearPathEntity();
        this.delayTemptCounter = 60;
        this.isRunning = false;
        this.temptedEntity.getNavigator().setAvoidsWater(this.avoidWater);
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

    public boolean isRunning()
    {
        return this.isRunning;
    }
}