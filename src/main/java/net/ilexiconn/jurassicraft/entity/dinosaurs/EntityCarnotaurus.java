package net.ilexiconn.jurassicraft.entity.dinosaurs;

import net.ilexiconn.jurassicraft.ai.JurassiCraftEntityAIEatDroppedFood;
import net.ilexiconn.jurassicraft.ai.JurassiCraftEntityAIFollowFood;
import net.ilexiconn.jurassicraft.ai.JurassiCraftEntityAITargetIfHasAgeAndNonTamed;
import net.ilexiconn.jurassicraft.ai.JurassiCraftEntityAIWander;
import net.ilexiconn.jurassicraft.client.model.modelbase.ChainBuffer;
import net.ilexiconn.jurassicraft.entity.CreatureManager;
import net.ilexiconn.jurassicraft.entity.EntityJurassiCraftLandAggressive;
import net.ilexiconn.jurassicraft.interfaces.ICarnivore;
import net.ilexiconn.jurassicraft.interfaces.IDinosaur;
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

public class EntityCarnotaurus extends EntityJurassiCraftLandAggressive implements IDinosaur, ICarnivore
{
	public ChainBuffer tailBuffer = new ChainBuffer();

    public EntityCarnotaurus(World world)
    {
        super(world, CreatureManager.classToCreature(EntityCarnotaurus.class));
        this.getNavigator().setAvoidsWater(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(3, new JurassiCraftEntityAIWander(this, this.getCreatureSpeed()));
        this.tasks.addTask(4, this.aiSit);
        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, this.getCreatureSpeed()));
        this.tasks.addTask(6, new JurassiCraftEntityAIFollowFood(this, 1.2D * this.getCreatureSpeed()));
        this.tasks.addTask(6, new JurassiCraftEntityAIEatDroppedFood(this, 16.0D));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(7, new EntityAILookIdle(this));
        targetTasks.addTask(3, new JurassiCraftEntityAITargetIfHasAgeAndNonTamed(this, EntityGallimimus.class, 0, 0.5F));
        targetTasks.addTask(3, new JurassiCraftEntityAITargetIfHasAgeAndNonTamed(this, EntityOviraptor.class, 0, 0.6F));
        this.targetTasks.addTask(3, new JurassiCraftEntityAITargetIfHasAgeAndNonTamed(this, EntityChicken.class, 0, 0.3F));
        this.targetTasks.addTask(3, new JurassiCraftEntityAITargetIfHasAgeAndNonTamed(this, EntityCow.class, 0, 0.5F));
        this.targetTasks.addTask(3, new JurassiCraftEntityAITargetIfHasAgeAndNonTamed(this, EntityPig.class, 0, 0.45F));
        this.targetTasks.addTask(3, new JurassiCraftEntityAITargetIfHasAgeAndNonTamed(this, EntitySheep.class, 0, 0.4F));

        this.setCreatureExperiencePoints(3000);
    }

    @Override
    public double getMountedYOffset()
    {
        return 0.95D * (double) this.getYBouningBox();
    }

    @Override
    protected void dropFewItems(boolean recentlyBeenHit, int enchantBonus)
    {
    	float developmentFraction = this.getGrowthStage() / 120.0F;
        int countMeat = Math.round(1 + (3.5F * developmentFraction) + this.rand.nextInt(1 + (int) (3.5F * developmentFraction)) + this.rand.nextInt(1 + enchantBonus));
    	if (!this.isBurning())
        {
            this.dropItemStackWithGenetics(new ItemStack(this.getCreature().getMeat(), countMeat));
        }
        else
        {
            this.dropItem(this.getCreature().getSteak(), countMeat);
        }
    	if (this.worldObj.rand.nextFloat() < 0.1F) {
            this.dropItemStackWithGenetics(new ItemStack(this.getCreature().getSkull()));
    	}
    }
}
