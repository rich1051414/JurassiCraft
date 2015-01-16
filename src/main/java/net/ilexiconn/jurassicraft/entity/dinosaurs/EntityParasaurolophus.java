package net.ilexiconn.jurassicraft.entity.dinosaurs;

import java.util.ArrayList;
import java.util.List;

import net.ilexiconn.jurassicraft.AnimationHandler;
import net.ilexiconn.jurassicraft.ai.JurassiCraftAIEatDroppedFood;
import net.ilexiconn.jurassicraft.ai.JurassiCraftAIFollowFood;
import net.ilexiconn.jurassicraft.ai.JurassiCraftAIHerdBehavior;
import net.ilexiconn.jurassicraft.ai.JurassiCraftAIWander;
import net.ilexiconn.jurassicraft.client.animation.AIParasaurolophusTrumpet;
import net.ilexiconn.jurassicraft.client.model.modelbase.ChainBuffer;
import net.ilexiconn.jurassicraft.entity.CreatureManager;
import net.ilexiconn.jurassicraft.entity.EntityJurassiCraftLandProtective;
import net.ilexiconn.jurassicraft.interfaces.IDinosaur;
import net.ilexiconn.jurassicraft.interfaces.IHerbivore;
import net.ilexiconn.jurassicraft.utility.ControlledParam;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityParasaurolophus extends EntityJurassiCraftLandProtective implements IDinosaur, IHerbivore
{
	public ChainBuffer tailBuffer = new ChainBuffer(6);
    public ControlledParam walkLean = new ControlledParam(0, 0, (float) Math.PI / 2, 0);

    public EntityParasaurolophus(World world)
    {
        super(world, CreatureManager.classToCreature(EntityParasaurolophus.class), 1);
        this.getNavigator().setAvoidsWater(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(2, new AIParasaurolophusTrumpet(this));
        this.tasks.addTask(3, this.aiSit);
        this.tasks.addTask(4, new JurassiCraftAIFollowFood(this, 1.1D * this.getCreatureSpeed()));
        this.tasks.addTask(4, new JurassiCraftAIEatDroppedFood(this, 16.0D));
        this.tasks.addTask(5, new JurassiCraftAIWander(this, 0.7D * this.getCreatureSpeed()));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(6, new EntityAILookIdle(this));
        this.tasks.addTask(7, new JurassiCraftAIHerdBehavior(this, 96, 2000, 20, 0.7D * this.getCreatureSpeed()));
        this.setCreatureExperiencePoints(1000);
    }

    @Override
    public double getMountedYOffset()
    {
        return 1.1D * (double) this.getYBouningBox();
    }

    @Override
    public int getTalkInterval()
    {
        return 350;
    }

    @Override
    public String getLivingSound()
    {
        int I = this.rand.nextInt(3);

        if (I <= 1)
        {
            return this.getCreature().getLivingSound(I);
        }
        else
        {
            AnimationHandler.sendAnimationPacket(this, 1);
            return null;
        }
    }

    @Override
    public void onUpdate()
    {
        super.onUpdate();
        if (this.moveForward != 0) this.walkLean.change = 0.1F;
        if (this.moveForward == 0) this.walkLean.change = -0.1F;
        this.walkLean.update();

        this.tailBuffer.calculateChainSwingBuffer(48.0F, 3, 5.0F, this);
    }
    
    public List<EntityParasaurolophus> getParasaurolophusNearby(int distanceX, int distanceY, int distanceZ)
    {
		List<Entity> list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(distanceX, distanceY, distanceZ));
		ArrayList<EntityParasaurolophus> listParasaurolophus = new ArrayList<EntityParasaurolophus>();
		for (int i = 0; i < list.size(); i++)
		{
			Entity entityNeighbor = (Entity) list.get(i);
			if (entityNeighbor instanceof EntityParasaurolophus && entityNeighbor!= this)
			{
				listParasaurolophus.add((EntityParasaurolophus) entityNeighbor);
			}
		}
		return listParasaurolophus;
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
