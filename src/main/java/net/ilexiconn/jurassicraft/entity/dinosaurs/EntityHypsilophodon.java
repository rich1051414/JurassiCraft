package net.ilexiconn.jurassicraft.entity.dinosaurs;

import net.ilexiconn.jurassicraft.ai.*;
import net.ilexiconn.jurassicraft.ai.animation.AnimationAIHypsilophodonScratchHead;
import net.ilexiconn.jurassicraft.ai.animation.AnimationAIPlayfulBaby;
import net.ilexiconn.jurassicraft.client.model.modelbase.ChainBuffer;
import net.ilexiconn.jurassicraft.client.model.modelbase.ControlledAnimation;
import net.ilexiconn.jurassicraft.entity.CreatureManager;
import net.ilexiconn.jurassicraft.entity.EntityJurassiCraftCoward;
import net.ilexiconn.jurassicraft.interfaces.IDinosaur;
import net.ilexiconn.jurassicraft.interfaces.IHerbivore;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class EntityHypsilophodon extends EntityJurassiCraftCoward implements IDinosaur, IHerbivore
{
    public ControlledAnimation sittingProgress = new ControlledAnimation(30);
	public ChainBuffer tailBuffer = new ChainBuffer(3);

	public EntityHypsilophodon(World world)
	{
		super(world);
		this.getNavigator().setAvoidsWater(true);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new JurassiCraftAIFlee(this, 60, 1.25D * this.getCreatureSpeed()));
		this.tasks.addTask(2, new JurassiCraftAISit(this));
		this.tasks.addTask(2, new AnimationAIHypsilophodonScratchHead(this));
		this.tasks.addTask(2, new JurassiCraftAIPlayfulBaby(this, 300, 0.3F));
		this.tasks.addTask(3, new JurassiCraftAIAvoidEntityIfNotTamed(this, EntityPlayer.class, 6.5F, 0.9D * this.getCreatureSpeed(), 1.2D * this.getCreatureSpeed()));
		this.tasks.addTask(3, new EntityAIAvoidEntity(this, EntityHerrerasaurus.class, 12.0F, 1.0D * this.getCreatureSpeed(), 1.2D * this.getCreatureSpeed()));
		this.tasks.addTask(4, new JurassiCraftAIFollowFood(this, 40, 1.1D * this.getCreatureSpeed()));
		this.tasks.addTask(4, new JurassiCraftAIEatDroppedFood(this, 16.0D));
		this.tasks.addTask(4, new JurassiCraftAIEating(this, 20));
		this.tasks.addTask(5, new JurassiCraftAIWander(this, 30, 0.8D * this.getCreatureSpeed()));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 7.0F));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new JurassiCraftAIFleeOwnerIsHurtByTarget(this));
		this.targetTasks.addTask(2, new JurassiCraftAIFleeOwnerHurtsTarget(this));
		this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
		this.setCreatureExperiencePoints(800);
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

        /** Sitting Animation */
        if (this.isSitting())
        {
            this.sittingProgress.increaseTimer();
        }
        else
        {
            this.sittingProgress.decreaseTimer();
        }

        
		this.tailBuffer.calculateChainSwingBuffer(60.0F, 5, 3.8F, this);
	}

	public List<EntityHypsilophodon> getHypsilophodonsNearby(double distanceX, double distanceY, double distanceZ)
	{
		List<Entity> list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(distanceX, distanceY, distanceZ));
		ArrayList<EntityHypsilophodon> listHypsilophodons = new ArrayList<EntityHypsilophodon>();

		for (Entity entityNeighbor : list)
		{
			if (entityNeighbor instanceof EntityHypsilophodon && entityNeighbor != this)
			{
				listHypsilophodons.add((EntityHypsilophodon) entityNeighbor);
			}
		}

		return listHypsilophodons;
	}

	@Override
	protected void dropFewItems(boolean recentlyBeenHit, int enchantBonus)
	{
		float developmentFraction = this.getGrowthStage() / 120.0F;
		int count = Math.round(1 + (1.5F * developmentFraction) + this.rand.nextInt(1 + (int) (2.0F * developmentFraction)) + this.rand.nextInt(1 + enchantBonus));

		if (!this.isBurning())
		{
			this.dropItemStackWithGenetics(new ItemStack(this.getCreature().getMeat(), count));
		}
		else
		{
			this.dropItem(this.getCreature().getSteak(), count);
		}

		if (this.isMale() && this.worldObj.rand.nextFloat() < 0.25F)
		{
			this.dropItemStackWithGenetics(new ItemStack(this.getCreature().getSkin()));
		}
	}
}
