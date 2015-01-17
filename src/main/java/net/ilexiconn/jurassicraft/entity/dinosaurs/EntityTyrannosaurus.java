package net.ilexiconn.jurassicraft.entity.dinosaurs;

import net.ilexiconn.jurassicraft.AnimationHandler;
import net.ilexiconn.jurassicraft.ai.JurassiCraftAIEatDroppedFood;
import net.ilexiconn.jurassicraft.ai.JurassiCraftAIFollowFood;
import net.ilexiconn.jurassicraft.ai.JurassiCraftAITargetIfHasAgeAndNonTamed;
import net.ilexiconn.jurassicraft.ai.JurassiCraftAIWander;
import net.ilexiconn.jurassicraft.client.animation.AITyrannosaurusRoar;
import net.ilexiconn.jurassicraft.client.animation.AITyrannosaurusWalkRoar;
import net.ilexiconn.jurassicraft.client.model.modelbase.ChainBuffer;
import net.ilexiconn.jurassicraft.client.model.modelbase.ControlledAnimation;
import net.ilexiconn.jurassicraft.entity.CreatureManager;
import net.ilexiconn.jurassicraft.entity.EntityJurassiCraftLandAggressive;
import net.ilexiconn.jurassicraft.interfaces.ICarnivore;
import net.ilexiconn.jurassicraft.interfaces.IDinosaur;
import net.ilexiconn.jurassicraft.utility.ControlledParam;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityTyrannosaurus extends EntityJurassiCraftLandAggressive implements IDinosaur, ICarnivore
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

    public EntityTyrannosaurus(World world)
    {
        super(world, CreatureManager.classToCreature(EntityTyrannosaurus.class));
        this.getNavigator().setAvoidsWater(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(3, new JurassiCraftAIWander(this, this.getCreatureSpeed()));
        this.tasks.addTask(4, this.aiSit);
        this.tasks.addTask(2, new AITyrannosaurusRoar(this));
        this.tasks.addTask(6, new AITyrannosaurusWalkRoar(this));
        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, this.getCreatureSpeed()));
        this.tasks.addTask(6, new JurassiCraftAIFollowFood(this, 1.2D * this.getCreatureSpeed()));
        this.tasks.addTask(6, new JurassiCraftAIEatDroppedFood(this, 16.0D));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(7, new EntityAILookIdle(this));
        targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntityStegosaur.class, 0, 0.5F));
        targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntityTriceratops.class, 0, 0.6F));
        targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntityGallimimus.class, 0, 0.3F));
        targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntityOviraptor.class, 0, 0.2F));
        targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntityBrachiosaur.class, 0, 0.6F));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntityChicken.class, 0, 0.9F));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntityCow.class, 0, 0.9F));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntityPig.class, 0, 0.9F));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntitySheep.class, 0, 0.9F));

        this.setCreatureExperiencePoints(6000);
    }

    public String getLivingSound()
    {
        int I = rand.nextInt(4) + 1;
        if (I == 1 && this.getCreatureAgeInDays() >= 25)
        {
            this.playSound("jurassicraft:trex1", 5.0F, this.getSoundPitch());
            if (animID == 0)
            {
            	if (this.moveForward == 0) {
                    if (!this.isSitting()) AnimationHandler.sendAnimationPacket(this, 1);}
            	else {
                    AnimationHandler.sendAnimationPacket(this, 2);}
            }
            return null;
        }
        else if (I == 2)
        {
            this.playSound("jurassicraft:trex2", 5.0F, this.getSoundPitch());
            return null;
        }
        else
        {
            return null;
        }
    }

    public String getHurtSound()
    {
        this.playSound("jurassicraft:trex3", 5.0F, this.getSoundPitch());
        return null;
    }

    public String getDeathSound()
    {
        this.playSound("jurassicraft:trex3", 5.0F, this.getSoundPitch());
        return null;
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
        
        //Breathing Sound
        if (this.frame % 62 == 28) this.playSound("jurassicraft:trexbreath", 1.0F, this.getSoundPitch());


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
