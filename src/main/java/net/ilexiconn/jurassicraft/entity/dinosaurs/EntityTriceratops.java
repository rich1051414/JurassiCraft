package net.ilexiconn.jurassicraft.entity.dinosaurs;

import net.ilexiconn.jurassicraft.AnimationHandler;
import net.ilexiconn.jurassicraft.ai.JurassiCraftAIAngry;
import net.ilexiconn.jurassicraft.ai.JurassiCraftAIDefensiveReaction;
import net.ilexiconn.jurassicraft.ai.JurassiCraftAIEatDroppedFood;
import net.ilexiconn.jurassicraft.ai.JurassiCraftAIEating;
import net.ilexiconn.jurassicraft.ai.JurassiCraftAIFlee;
import net.ilexiconn.jurassicraft.ai.JurassiCraftAIFollowFood;
import net.ilexiconn.jurassicraft.ai.JurassiCraftAIHerdBehavior;
import net.ilexiconn.jurassicraft.ai.JurassiCraftAIOwnerHurtsTarget;
import net.ilexiconn.jurassicraft.ai.JurassiCraftAIOwnerIsHurtByTarget;
import net.ilexiconn.jurassicraft.ai.JurassiCraftAISit;
import net.ilexiconn.jurassicraft.ai.JurassiCraftAIWander;
import net.ilexiconn.jurassicraft.ai.animation.AnimationAITriceratopsCharge;
import net.ilexiconn.jurassicraft.client.model.modelbase.ChainBuffer;
import net.ilexiconn.jurassicraft.client.model.modelbase.ControlledAnimation;
import net.ilexiconn.jurassicraft.entity.CreatureManager;
import net.ilexiconn.jurassicraft.entity.EntityJurassiCraftAggressive;
import net.ilexiconn.jurassicraft.entity.EntityJurassiCraftProtective;
import net.ilexiconn.jurassicraft.enums.JurassiCraftAnimationIDs;
import net.ilexiconn.jurassicraft.interfaces.IDinosaur;
import net.ilexiconn.jurassicraft.interfaces.IHerbivore;
import net.ilexiconn.jurassicraft.utility.ControlledParam;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityTriceratops extends EntityJurassiCraftProtective implements IDinosaur, IHerbivore
{
    public ControlledParam flailDegree = new ControlledParam(0.0F, 0.0F, 1.0F, 0.0F);
	public ControlledAnimation defendingPosition = new ControlledAnimation(40);
	public ChainBuffer tailBuffer = new ChainBuffer(5);
    public boolean charging = false;
    public float distanceFromTarget;
    public int timeSinceCharge = 0;
    public int stepCount = 0;

    public EntityTriceratops(World world)
    {
        super(world, CreatureManager.classToCreature(EntityTriceratops.class));
        this.getNavigator().setAvoidsWater(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new JurassiCraftAIAngry(this, 200));
        this.tasks.addTask(1, new JurassiCraftAIFlee(this, 60, 1.1D * this.getCreatureSpeed()));
        this.tasks.addTask(1, new JurassiCraftAIWander(this, 45, 0.8D * this.getCreatureSpeed()));
        this.tasks.addTask(2, new JurassiCraftAISit(this));
        this.tasks.addTask(2, new AnimationAITriceratopsCharge(this));
        this.tasks.addTask(3, new EntityAIAttackOnCollide(this, 1.1F * this.getCreatureSpeed(), false));
        this.tasks.addTask(4, new JurassiCraftAIDefensiveReaction(this, 300.0D, 870.0D, true, JurassiCraftAnimationIDs.CHARGE.animID(), true));
        this.tasks.addTask(5, new JurassiCraftAIEating(this, 20));
        this.tasks.addTask(6, new JurassiCraftAIFollowFood(this, 50, 1.1D * this.getCreatureSpeed()));
        this.tasks.addTask(6, new JurassiCraftAIEatDroppedFood(this, 16.0D));
        this.tasks.addTask(7, new EntityAIAvoidEntity(this, EntityTyrannosaurus.class, 12.0F, this.getCreatureSpeed(), 1.2D * this.getCreatureSpeed()));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(9, new EntityAILookIdle(this));
        this.tasks.addTask(10, new JurassiCraftAIHerdBehavior(this, 96, 2000, 20, 0.7D * this.getCreatureSpeed()));
        this.targetTasks.addTask(1, new JurassiCraftAIOwnerIsHurtByTarget(this));
        this.targetTasks.addTask(2, new JurassiCraftAIOwnerHurtsTarget(this));
        this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
        this.setCreatureExperiencePoints(3500);
    }

    @Override
    public double getMountedYOffset()
    {
    	if (this.getAnimationId() == 1)
    	{
    		if (this.getAnimationTick() < 5)
        	{
        		float animationProgress = (float) this.getAnimationTick() / 5.0F;
        		return 0.91D * (double) this.getYBouningBox() - (0.3F * MathHelper.sin(animationProgress));
        	}
    		else if (this.getAnimationTick() < 18)
        	{
        		float animationProgress = (float) (this.getAnimationTick() - 5) / 13.0F;
        		return 0.91D * (double) this.getYBouningBox() + (0.6F * MathHelper.sin(animationProgress));
        	}
        	else if (this.getAnimationTick() < 39)
        	{
        		float animationProgress = (float) (this.getAnimationTick() - 18) / 21.0F;
        		return 0.91D * (double) this.getYBouningBox() - (0.5F * MathHelper.sin(animationProgress));
        	}
    	}
        return 0.91D * (double) this.getYBouningBox();
    }

	@Override
	public int getNumberOfAllies()
	{
		return 1;
	}

    @Override
    public int getTalkInterval()
    {
        return 350;
    }

    @Override
    public void onLivingUpdate()
    {
        super.onLivingUpdate();
        
        if (getAttackTarget() != null)
        {
            this.distanceFromTarget = (float) Math.sqrt(Math.pow((posX - getAttackTarget().posX), 2.0D) + Math.pow((posZ - getAttackTarget().posZ), 2.0D));
        }
        else
        {
        	this.distanceFromTarget = -1.0F;
        }
        if (timeSinceCharge != 0) timeSinceCharge--;
    }

    @Override
    public void onUpdate()
    {
        super.onUpdate();
        this.flailDegree.update();
        if (this.animID == JurassiCraftAnimationIDs.CHARGE.animID() && this.animTick == 1) this.flailDegree.thereAndBack(0F, 0.1F, 1F, 5);
        if (this.stepCount <= 0 && this.charging)
        {
            this.playSound("jurassicraft:gallop", 3.0F, this.getSoundPitch() - 0.5F);
            this.stepCount = 10;
        }
        this.stepCount -= 1;
        
        if (this.isDefending())
        {
        	this.defendingPosition.increaseTimer();
        }
        else
        {
        	this.defendingPosition.decreaseTimer(2);
        	if (this.rand.nextInt(40) == 0 && this.isCreatureOlderThan(0.6F))
            {
            	this.creatureToAttack = this.getClosestEntityAggressive(this, 20, 8, 20);
            	if (this.creatureToAttack != null)
            		this.setDefending(((EntityJurassiCraftAggressive) this.creatureToAttack).isCreatureOlderThan(0.5F));
            }
        }
        
        this.tailBuffer.calculateChainSwingBuffer(40.0F, 5, 3.0F, this);
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
    
    @Override
    public void ridingPlayerRightClick() {
    	if (this.onGround && this.timeSinceCharge < 75 && this.getCreatureAgeInDays() >= 17 && ((EntityPlayer) this.riddenByEntity).getHeldItem() != (ItemStack) null && this.getCreature().isRidingItem(((EntityPlayer) this.riddenByEntity).getHeldItem().getItem())) {
            this.decreaseHeldItemDurability(40);
    		AnimationHandler.sendAnimationPacket(this, JurassiCraftAnimationIDs.CHARGE.animID());
    	}
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
            this.dropItemStackWithGenetics(new ItemStack(this.getCreature().getSkull()));
    	}
    	if (this.isMale() && this.worldObj.rand.nextFloat() < 0.25F) {
            this.dropItemStackWithGenetics(new ItemStack(this.getCreature().getSkin()));
    	}
    }
}
