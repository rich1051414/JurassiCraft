package net.ilexiconn.jurassicraft.entity.dinosaurs;

import net.ilexiconn.jurassicraft.ModItems;
import net.ilexiconn.jurassicraft.ai.JurassiCraftEntityAIEatDroppedFood;
import net.ilexiconn.jurassicraft.ai.JurassiCraftEntityAIFollowFood;
import net.ilexiconn.jurassicraft.ai.JurassiCraftEntityAIHerdBehavior;
import net.ilexiconn.jurassicraft.ai.JurassiCraftEntityAIWander;
import net.ilexiconn.jurassicraft.client.animation.AITriceratopsCharge;
import net.ilexiconn.jurassicraft.entity.CreatureManager;
import net.ilexiconn.jurassicraft.entity.EntityJurassiCraftLandProtective;
import net.ilexiconn.jurassicraft.entity.IDinosaur;
import net.ilexiconn.jurassicraft.utility.ControlledParam;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import thehippomaster.AnimationAPI.AnimationAPI;

public class EntityTriceratops extends EntityJurassiCraftLandProtective implements IDinosaur
{
    public int timeSinceCharge = 0;
    public boolean charging = false;
    public ControlledParam flailDegree = new ControlledParam(0F, 0F, 1F, 0F);
    int stepCount = 0;

    public EntityTriceratops(World world)
    {
        super(world, CreatureManager.classToCreature(EntityTriceratops.class), 1);
        this.getNavigator().setAvoidsWater(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(2, this.aiSit);
        this.tasks.addTask(2, new AITriceratopsCharge(this));
        this.tasks.addTask(4, new JurassiCraftEntityAIFollowFood(this, 1.1D * this.getCreatureSpeed()));
        this.tasks.addTask(4, new JurassiCraftEntityAIEatDroppedFood(this, 16.0D));
        this.tasks.addTask(5, new JurassiCraftEntityAIWander(this, 0.8D * this.getCreatureSpeed()));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 10.0F));
        this.tasks.addTask(6, new EntityAILookIdle(this));
        this.tasks.addTask(7, new JurassiCraftEntityAIHerdBehavior(this, 96, 2000, 20, 0.7D * this.getCreatureSpeed()));
        this.setCreatureExperiencePoints(3500);
    }

    @Override
    public double getMountedYOffset()
    {
        return (double) this.getYBouningBox() * 0.91D;
    }

    @Override
    public int getTalkInterval()
    {
        return 350;
    }

    public void onLivingUpdate()
    {
        super.onLivingUpdate();
        //Charge AI
        float distanceFromTarget;
        if (getAttackTarget() != null)
            distanceFromTarget = (float) Math.sqrt(Math.pow((posX - getAttackTarget().posX), 2) + Math.pow((posZ - getAttackTarget().posZ), 2));
        else distanceFromTarget = -1;
        if (this.getAttackTarget() != null && onGround && timeSinceCharge == 0 && !this.isPanicking() && this.getCreatureAgeInDays() >= 17)
            AnimationAPI.sendAnimationPacket(this, 1);
        if (timeSinceCharge != 0) timeSinceCharge--;
    }

    @Override
    public void collideWithEntity(Entity victim)
    {
        super.collideWithEntity(victim);
        if (this.charging && !(victim instanceof EntityTriceratops))
        {
            victim.attackEntityFrom(DamageSource.causeMobDamage(this), 20);
            double deltaX = victim.posX - victim.posX;
            double deltaZ = victim.posZ - victim.posZ;
            double angleYaw = (float) Math.atan2(deltaZ, deltaX);
            victim.motionX += Math.cos(angleYaw);
            victim.motionZ += Math.sin(angleYaw);
            victim.motionY += 0.3;
        }
    }

    public void onUpdate()
    {
        super.onUpdate();
        flailDegree.update();
        if (animID == 1 && animTick == 1) this.flailDegree.thereAndBack(0F, 0.1F, 1F, 5);
        if (this.stepCount <= 0 && this.charging)
        {
            this.playSound("jurassicraft:gallop", 3.0F, this.getSoundPitch() - 0.5F);
            stepCount = 10;
        }
        stepCount -= 1;
    }

    @Override
    protected void dropFewItems(boolean recentlyBeenHit, int enchantBonus)
    {
    	float developmentFraction = this.getGrowthStage() / 120.0F;
        int count = Math.round(1 + (4.0F * developmentFraction) + this.rand.nextInt(1 + (int) (4.0F * developmentFraction)) + this.rand.nextInt(1 + enchantBonus));
    	if (!this.isBurning())
        {
            this.dropItemStackWithGenetics(new ItemStack(this.getCreature().getMeat(), count));
        }
        else
        {
            this.dropItem(this.getCreature().getSteak(), count);
        }
    	if (this.worldObj.rand.nextFloat() < 0.1F) {
            this.dropItem(this.getCreature().getSkull(), 1);
    	}
    }
}