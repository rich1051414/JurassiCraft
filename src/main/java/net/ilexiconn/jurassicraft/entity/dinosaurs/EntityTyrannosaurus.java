package net.ilexiconn.jurassicraft.entity.dinosaurs;

import net.ilexiconn.jurassicraft.ai.JurassiCraftEntityAIEatDroppedFood;
import net.ilexiconn.jurassicraft.ai.JurassiCraftEntityAIFollowFood;
import net.ilexiconn.jurassicraft.ai.JurassiCraftEntityAITargetIfHasAgeAndNonTamed;
import net.ilexiconn.jurassicraft.ai.JurassiCraftEntityAIWander;
import net.ilexiconn.jurassicraft.client.animation.AITyrannosaurusRoar;
import net.ilexiconn.jurassicraft.entity.CreatureManager;
import net.ilexiconn.jurassicraft.entity.EntityJurassiCraftLandAggressive;
import net.ilexiconn.jurassicraft.entity.IDinosaur;
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
import net.minecraft.world.World;
import thehippomaster.AnimationAPI.AnimationAPI;

public class EntityTyrannosaurus extends EntityJurassiCraftLandAggressive implements IDinosaur
{

    private int stepCount = 0;
    private float shakeCount = 0;
    public ControlledParam roarCount = new ControlledParam(0F, 0F, 0.5F, 0F);
    public ControlledParam roarTiltDegree = new ControlledParam(0F, 0F, 1F, 0F);

    public EntityTyrannosaurus(World world)
    {
        super(world, CreatureManager.classToCreature(EntityTyrannosaurus.class));
        this.getNavigator().setAvoidsWater(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new JurassiCraftEntityAIWander(this, this.getCreatureSpeed()));
        this.tasks.addTask(4, this.aiSit);
        this.tasks.addTask(2, new AITyrannosaurusRoar(this));
        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, this.getCreatureSpeed()));
        this.tasks.addTask(6, new JurassiCraftEntityAIFollowFood(this, 1.2D * this.getCreatureSpeed()));
        this.tasks.addTask(6, new JurassiCraftEntityAIEatDroppedFood(this, 16.0D));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(7, new EntityAILookIdle(this));
        targetTasks.addTask(3, new JurassiCraftEntityAITargetIfHasAgeAndNonTamed(this, EntityStegosaur.class, 0, 0.5F));
        targetTasks.addTask(3, new JurassiCraftEntityAITargetIfHasAgeAndNonTamed(this, EntityTriceratops.class, 0, 0.6F));
        targetTasks.addTask(3, new JurassiCraftEntityAITargetIfHasAgeAndNonTamed(this, EntityGallimimus.class, 0, 0.3F));
        targetTasks.addTask(3, new JurassiCraftEntityAITargetIfHasAgeAndNonTamed(this, EntityOviraptor.class, 0, 0.2F));
        targetTasks.addTask(3, new JurassiCraftEntityAITargetIfHasAgeAndNonTamed(this, EntityBrachiosaur.class, 0, 0.6F));
        this.targetTasks.addTask(3, new JurassiCraftEntityAITargetIfHasAgeAndNonTamed(this, EntityChicken.class, 0, 0.9F));
        this.targetTasks.addTask(3, new JurassiCraftEntityAITargetIfHasAgeAndNonTamed(this, EntityCow.class, 0, 0.9F));
        this.targetTasks.addTask(3, new JurassiCraftEntityAITargetIfHasAgeAndNonTamed(this, EntityPig.class, 0, 0.9F));
        this.targetTasks.addTask(3, new JurassiCraftEntityAITargetIfHasAgeAndNonTamed(this, EntitySheep.class, 0, 0.9F));

        this.setCreatureExperiencePoints(6000);
    }

    public String getLivingSound()
    {
        // if(isRoaring == false){
        // isRoaring = true;
        int I = rand.nextInt(4) + 1;
        if (I == 1 && this.getCreatureAgeInDays() >= 25)
        {
            this.playSound("jurassicraft:trex1", 5.0F, this.getSoundPitch());
            if (animID == 0 && this.getAttackTarget() == null)
            {
                AnimationAPI.sendAnimationPacket(this, 1);
            }
            /*
             * else if(this.getAttackTarget() != null) {
			 * roarCount.thereAndBack(0F, 0.1F, 1, 40);
			 * System.out.println(roarCount.change); }
			 */
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
        // }
        // return null;
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
        roarCount.update();
        roarTiltDegree.update();
        if (this.moveForward > 0 && this.stepCount <= 0 && this.getCreatureAgeInDays() >= 25)
        {
            this.playSound("jurassicraft:footstep", 5.0F, this.getSoundPitch());
            stepCount = 60;
        }
        if (animID == 1 && animTick == 22) this.roarTiltDegree.thereAndBack(0F, 0.1F, 1F, 20);
        stepCount -= this.moveForward * 10;
    }
}
