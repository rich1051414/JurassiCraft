package net.ilexiconn.jurassicraft.entity.dinosaurs;

import net.ilexiconn.jurassicraft.AnimationHandler;
import net.ilexiconn.jurassicraft.ai.JurassiCraftAIEatDroppedFood;
import net.ilexiconn.jurassicraft.ai.JurassiCraftAIEating;
import net.ilexiconn.jurassicraft.ai.JurassiCraftAIFollowFood;
import net.ilexiconn.jurassicraft.ai.JurassiCraftAIOwnerHurtsTarget;
import net.ilexiconn.jurassicraft.ai.JurassiCraftAIOwnerIsHurtByTarget;
import net.ilexiconn.jurassicraft.ai.JurassiCraftAISitNatural;
import net.ilexiconn.jurassicraft.ai.JurassiCraftAITargetIfHasAgeAndNonTamed;
import net.ilexiconn.jurassicraft.ai.JurassiCraftAIWander;
import net.ilexiconn.jurassicraft.client.animation.AITyrannosaurusEatingGallimimus;
import net.ilexiconn.jurassicraft.client.animation.AITyrannosaurusRoar;
import net.ilexiconn.jurassicraft.client.animation.AITyrannosaurusWalkRoar;
import net.ilexiconn.jurassicraft.client.model.modelbase.ChainBuffer;
import net.ilexiconn.jurassicraft.client.model.modelbase.ControlledAnimation;
import net.ilexiconn.jurassicraft.entity.CreatureManager;
import net.ilexiconn.jurassicraft.entity.EntityJurassiCraftAggressive;
import net.ilexiconn.jurassicraft.entity.mammals.EntityLeptictidium;
import net.ilexiconn.jurassicraft.entity.mammals.EntityMoeritherium;
import net.ilexiconn.jurassicraft.interfaces.ICarnivore;
import net.ilexiconn.jurassicraft.interfaces.IDinosaur;
import net.ilexiconn.jurassicraft.utility.ControlledParam;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityTyrannosaurus extends EntityJurassiCraftAggressive implements IDinosaur, ICarnivore
{
    private int stepCount = 0;
    private float shakeCount = 0;
    public ControlledParam roarCount = new ControlledParam(0F, 0F, 0.5F, 0F);
    public ControlledParam roarTiltDegree = new ControlledParam(0F, 0F, 1F, 0F);
	public ControlledAnimation sittingProgress = new ControlledAnimation(50);
	public ControlledAnimation restHeadProgress = new ControlledAnimation(30);
	public ChainBuffer tailBuffer = new ChainBuffer(5);
	private boolean restingHead = false;
	private int restHeadSwitchTimer = 300;
	private double entityRiderYawDelta;
	private double entityRiderPitchDelta;

    public EntityTyrannosaurus(World world)
    {
        super(world, CreatureManager.classToCreature(EntityTyrannosaurus.class));
        this.getNavigator().setAvoidsWater(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, 1.0F * this.getCreatureSpeed(), false));
        this.tasks.addTask(3, new JurassiCraftAIWander(this, 40, this.getCreatureSpeed()));
        this.tasks.addTask(3, new AITyrannosaurusWalkRoar(this));
        this.tasks.addTask(4, new JurassiCraftAISitNatural(this, 10, 125, 300));
        this.tasks.addTask(2, new AITyrannosaurusRoar(this));
        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, this.getCreatureSpeed()));
        this.tasks.addTask(6, new JurassiCraftAIFollowFood(this, 100, 1.2D * this.getCreatureSpeed()));
        this.tasks.addTask(6, new JurassiCraftAIEatDroppedFood(this, 16.0D));
        this.tasks.addTask(6, new JurassiCraftAIEating(this, 20));
        this.tasks.addTask(6, new AITyrannosaurusEatingGallimimus(this));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(7, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new JurassiCraftAIOwnerIsHurtByTarget(this));
        this.targetTasks.addTask(2, new JurassiCraftAIOwnerHurtsTarget(this));
        this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntityBrachiosaurus.class, 120, 0.7F));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntityStegosaurus.class, 80, 0.6F));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntityTriceratops.class, 70, 0.6F));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntityGallimimus.class, 40, 0.4F));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntityMoeritherium.class, 40, 0.4F));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntityOviraptor.class, 40, 0.3F));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntityLeptictidium.class, 40, 0.3F));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntityHorse.class, 50, 0.25F));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntityCow.class, 30, 0.2F));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntityPig.class, 30, 0.15F));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntitySheep.class, 30, 0.2F));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntityChicken.class, 10, 0.1F));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntityPlayer.class, 40, 0.3F));
        this.setCreatureExperiencePoints(5500);
    }

    @Override
    public void updateRiderPosition()
    {
        if (this.riddenByEntity != null)
        {
        	if (this.riddenByEntity instanceof EntityGallimimus)
        	{
				this.riddenByEntity.rotationYaw = this.rotationYaw - 150.0F;
				((EntityGallimimus) this.riddenByEntity).rotationYawHead = this.riddenByEntity.rotationYaw;
				double extraX = (double) (0.4F * this.getCreatureLength() * MathHelper.sin(3.14159265359F + 0.01745329251F * this.rotationYaw));
				double extraZ = (double) (0.4F * this.getCreatureLength() * MathHelper.cos(0.01745329251F * this.rotationYaw));
				double extraY = 0.0D;
				
				if (this.animTick > 13 && this.animTick <= 18)
				{
					extraY += (double) (this.height * 0.4F * (this.animTick - 14) / 5.0D);
				}
				else if (this.animTick > 18 && this.animTick < 50)
				{
					//MISSING XZ MOTION
					extraY += (double) (this.height * 0.4F);
				}
        		this.riddenByEntity.setPosition(this.posX + extraX, this.posY + extraY, this.posZ + extraZ);
        	}
        	else
        	{
                this.riddenByEntity.setPosition(this.posX, this.posY + this.getMountedYOffset() + this.riddenByEntity.getYOffset(), this.posZ);
        	}
        }
    }

    public void onUpdate()
    {
        super.onUpdate();
        this.roarCount.update();
        this.roarTiltDegree.update();
        //Step Sound
        if (this.moveForward > 0 && this.stepCount <= 0 && this.getCreatureAgeInDays() >= 25)
        {
            this.playSound("jurassicraft:footstep", 5.0F, this.getSoundPitch());
            stepCount = 60;
        }
        if (animID == 1 && animTick == 22) this.roarTiltDegree.thereAndBack(0F, 0.1F, 1F, 20);
        if (animID == 2 && animTick == 22) this.roarTiltDegree.thereAndBack(0F, 0.1F, 1F, 20);
        this.stepCount -= this.moveForward * 9.5;
        
        //Breathing Sound MISSING SOUND
        //if (this.frame % 62 == 28) this.playSound("jurassicraft:trexbreath", 1.0F, this.getSoundPitch());


        //Sitting Animation
		if (this.isSitting()) 
		{
			this.sittingProgress.increaseTimer();
			if (!restingHead && getRNG().nextInt(100) == 0 && restHeadSwitchTimer == 0) {restingHead = true; restHeadSwitchTimer = 300;}
			if (restingHead && getRNG().nextInt(100) == 0 && restHeadSwitchTimer == 0) {restingHead = false; restHeadSwitchTimer = 300;}
			if(restHeadSwitchTimer > 0) restHeadSwitchTimer--;
		}
		else
		{
			this.sittingProgress.decreaseTimer();
			restingHead = false;
			restHeadSwitchTimer = 300;
		}
		if (restingHead) restHeadProgress.increaseTimer();
		if (!restingHead) restHeadProgress.decreaseTimer();
		
        this.tailBuffer.calculateChainSwingBuffer(55.0F, 5, 3.0F, this);
    }

    @Override
    public boolean attackEntityAsMob(Entity entity)
    {
		if (this.riddenByEntity instanceof EntityGallimimus)
    	{
			if (this.getAttackTarget() == this.riddenByEntity)
				this.setAttackTarget((EntityLivingBase) null);
			return false;
    	}
		else
		{
			return super.attackEntityAsMob(entity);
		}
    }

    @Override
    protected void dropFewItems(boolean recentlyBeenHit, int enchantBonus)
    {
    	float developmentFraction = this.getGrowthStage() / 120.0F;
        int countMeat = Math.round(1 + (5.0F * developmentFraction) + this.rand.nextInt(1 + (int) (3.0F * developmentFraction)) + this.rand.nextInt(1 + enchantBonus));
        int countTeeth = Math.round(1.5F * developmentFraction + this.rand.nextInt(1 + (int) (2.0F * developmentFraction)));
    	if (!this.isBurning())
        {
            this.dropItemStackWithGenetics(new ItemStack(this.getCreature().getMeat(), countMeat));
            this.dropItemStackWithGenetics(new ItemStack(this.getCreature().getTooth(), countTeeth));
        }
        else
        {
            this.dropItem(this.getCreature().getSteak(), countMeat);
            this.dropItemStackWithGenetics(new ItemStack(this.getCreature().getTooth(), countTeeth));
        }
    	if (this.worldObj.rand.nextFloat() < 0.1F) {
            this.dropItemStackWithGenetics(new ItemStack(this.getCreature().getSkull()));
    	}
    	if (this.isMale() && this.worldObj.rand.nextFloat() < 0.25F) {
            this.dropItemStackWithGenetics(new ItemStack(this.getCreature().getSkin()));
    	}
    }
}
