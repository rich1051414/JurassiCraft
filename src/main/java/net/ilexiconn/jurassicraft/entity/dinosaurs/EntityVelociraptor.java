package net.ilexiconn.jurassicraft.entity.dinosaurs;

import net.ilexiconn.jurassicraft.ai.JurassiCraftAIEatDroppedFood;
import net.ilexiconn.jurassicraft.ai.JurassiCraftAIFollowFood;
import net.ilexiconn.jurassicraft.ai.JurassiCraftAITargetIfHasAgeAndNonTamed;
import net.ilexiconn.jurassicraft.ai.JurassiCraftAIWander;
import net.ilexiconn.jurassicraft.client.animation.AIVelociraptorLeap;
import net.ilexiconn.jurassicraft.client.animation.AIVelociraptorRoar;
import net.ilexiconn.jurassicraft.client.animation.AIVelociraptorTwitchHead;
import net.ilexiconn.jurassicraft.client.model.modelbase.ChainBuffer;
import net.ilexiconn.jurassicraft.entity.CreatureManager;
import net.ilexiconn.jurassicraft.entity.EntityJurassiCraftLandAggressive;
import net.ilexiconn.jurassicraft.interfaces.ICarnivore;
import net.ilexiconn.jurassicraft.interfaces.IDinosaur;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.ilexiconn.jurassicraft.AnimationHandler;

public class EntityVelociraptor extends EntityJurassiCraftLandAggressive implements IDinosaur, ICarnivore
{
	public ChainBuffer tailBuffer = new ChainBuffer(6);
    public boolean leaping = false;
    public int timeSinceLeap;
    public int texid;

    public EntityVelociraptor(World world)
    {
        super(world, CreatureManager.classToCreature(EntityVelociraptor.class));
        this.getNavigator().setAvoidsWater(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIMoveTowardsRestriction(this, this.getCreatureSpeed()));
        this.tasks.addTask(4, this.aiSit);
        this.tasks.addTask(7, new AIVelociraptorTwitchHead(this));
        this.tasks.addTask(7, new AIVelociraptorRoar(this));
        this.tasks.addTask(2, new AIVelociraptorLeap(this));
        this.tasks.addTask(5, new JurassiCraftAIFollowFood(this, 1.1D * this.getCreatureSpeed()));
        this.tasks.addTask(5, new JurassiCraftAIEatDroppedFood(this, 16.0D));
        this.tasks.addTask(6, new JurassiCraftAIWander(this, 0.8D * this.getCreatureSpeed()));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(7, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntityStegosaur.class, 0, 0.7F));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntityTriceratops.class, 0, 0.8F));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntityGallimimus.class, 0, 0.25F));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntityOviraptor.class, 0, 0.33F));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntityBrachiosaur.class, 0, 0.9F));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntityChicken.class, 0, 0.9F));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntityCow.class, 0, 0.9F));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntityPig.class, 0, 0.9F));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntitySheep.class, 0, 0.9F));

        this.setCreatureExperiencePoints(4500);
    }

    @Override
    public void onLivingUpdate()
    {
        // Leap AI
        float distanceFromTarget;
        if (getAttackTarget() != null)
            distanceFromTarget = (float) Math.sqrt(Math.pow((posX - getAttackTarget().posX), 2) + Math.pow((posZ - getAttackTarget().posZ), 2));
        else distanceFromTarget = -1;
        if (distanceFromTarget >= 5 && distanceFromTarget <= 6 && onGround && timeSinceLeap == 0 && animID == 0)
            AnimationHandler.sendAnimationPacket(this, 3);
        if (onGround == true) setLeaping(false);
        if (timeSinceLeap != 0) timeSinceLeap--;

        // Misc
        super.onLivingUpdate();
    }

    @Override
    public void onUpdate()
    {
        super.onUpdate();
        this.tailBuffer.calculateChainSwingBuffer(68.0F, 5, 4.0F, this);
    }

    public void setLeaping(boolean l)
    {
        this.leaping = l;
    }

    public String getLivingSound()
    {
        if (animID == 0) AnimationHandler.sendAnimationPacket(this, 2);
        int I = rand.nextInt(4) + 1;
        if (I == 1) return "jurassicraft:RapHiss01";
        if (I == 2) return "jurassicraft:RapHiss02";
        if (I == 3) return "jurassicraft:RapHiss03";
        else return "jurassicraft:RapBark03";
    }

    public String getDeathSound()
    {
        if (animID == 0) AnimationHandler.sendAnimationPacket(this, 2);

        return super.getDeathSound();
    }

    @Override
    protected void dropFewItems(boolean recentlyBeenHit, int enchantBonus)
    {
    	float developmentFraction = this.getGrowthStage() / 120.0F;
        int count = Math.round(1 + (3.0F * developmentFraction) + this.rand.nextInt(1 + (int) (2.5F * developmentFraction)) + this.rand.nextInt(1 + enchantBonus));
    	if (!this.isBurning())
        {
            this.dropItemStackWithGenetics(new ItemStack(this.getCreature().getMeat(), count));
        }
        else
        {
            this.dropItem(this.getCreature().getSteak(), count);
        }
    	if (this.isMale() && this.worldObj.rand.nextFloat() < 0.25F) {
            this.dropItemStackWithGenetics(new ItemStack(this.getCreature().getSkin()));
    	}
    }
}
