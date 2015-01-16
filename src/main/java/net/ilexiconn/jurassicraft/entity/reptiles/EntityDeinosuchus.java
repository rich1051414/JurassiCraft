package net.ilexiconn.jurassicraft.entity.reptiles;

import net.ilexiconn.jurassicraft.ai.JurassiCraftEntityAIEatDroppedFood;
import net.ilexiconn.jurassicraft.ai.JurassiCraftEntityAIFollowFood;
import net.ilexiconn.jurassicraft.ai.JurassiCraftEntityAITargetIfHasAgeAndNonTamed;
import net.ilexiconn.jurassicraft.ai.JurassiCraftEntityAIWander;
import net.ilexiconn.jurassicraft.client.model.modelbase.ChainBuffer;
import net.ilexiconn.jurassicraft.entity.CreatureManager;
import net.ilexiconn.jurassicraft.entity.EntityJurassiCraftLandAggressive;
import net.ilexiconn.jurassicraft.interfaces.ICarnivore;
import net.ilexiconn.jurassicraft.interfaces.IPiscivore;
import net.ilexiconn.jurassicraft.interfaces.IReptile;
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
import net.minecraft.world.World;

public class EntityDeinosuchus extends EntityJurassiCraftLandAggressive implements IReptile, ICarnivore, IPiscivore
{
	public ChainBuffer tailBuffer = new ChainBuffer(5);
	
    public EntityDeinosuchus(World world)
    {
        super(world, CreatureManager.classToCreature(EntityDeinosuchus.class));
        this.getNavigator().setAvoidsWater(false);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new JurassiCraftEntityAIWander(this, 0.7D * this.getCreatureSpeed()));
        this.tasks.addTask(2, this.aiSit);
        this.tasks.addTask(4, new EntityAIMoveTowardsRestriction(this, this.getCreatureSpeed()));
        this.tasks.addTask(5, new JurassiCraftEntityAIFollowFood(this, 1.1D * this.getCreatureSpeed()));
        this.tasks.addTask(5, new JurassiCraftEntityAIEatDroppedFood(this, 16.0D));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(6, new EntityAILookIdle(this));
        this.targetTasks.addTask(3, new JurassiCraftEntityAITargetIfHasAgeAndNonTamed(this, EntityHorse.class, 0, 0.4F));
        this.targetTasks.addTask(3, new JurassiCraftEntityAITargetIfHasAgeAndNonTamed(this, EntityChicken.class, 0, 0.4F));
        this.targetTasks.addTask(3, new JurassiCraftEntityAITargetIfHasAgeAndNonTamed(this, EntityCow.class, 0, 0.4F));
        this.targetTasks.addTask(3, new JurassiCraftEntityAITargetIfHasAgeAndNonTamed(this, EntityPig.class, 0, 0.4F));
        this.targetTasks.addTask(3, new JurassiCraftEntityAITargetIfHasAgeAndNonTamed(this, EntitySheep.class, 0, 0.4F));

        this.setCreatureExperiencePoints(2500);
    }

    @Override
    public int getTalkInterval()
    {
        return 350;
    }

    @Override
    public void onUpdate()
    {
        super.onUpdate();
        this.tailBuffer.calculateChainSwingBuffer(45.0F, 5, 2.5F, this);
    }
    
    @Override
    protected void dropFewItems(boolean recentlyBeenHit, int enchantBonus)
    {
    	float developmentFraction = this.getGrowthStage() / 120.0F;
        int count = Math.round(1 + (3.5F * developmentFraction) + this.rand.nextInt(1 + (int) (3.5F * developmentFraction)) + this.rand.nextInt(1 + enchantBonus));
    	if (!this.isBurning())
        {
            this.dropItemStackWithGenetics(new ItemStack(this.getCreature().getMeat(), count));
        }
        else
        {
            this.dropItem(this.getCreature().getSteak(), count);
        }
    }
}
