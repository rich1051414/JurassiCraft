package net.ilexiconn.jurassicraft.entity.mammals;

import net.ilexiconn.jurassicraft.ModItems;
import net.ilexiconn.jurassicraft.ai.JurassiCraftAIAvoidEntityIfNotTamed;
import net.ilexiconn.jurassicraft.ai.JurassiCraftAIEatDroppedFood;
import net.ilexiconn.jurassicraft.ai.JurassiCraftAIFollowFoodCoward;
import net.ilexiconn.jurassicraft.ai.JurassiCraftAIWander;
import net.ilexiconn.jurassicraft.client.model.modelbase.ChainBuffer;
import net.ilexiconn.jurassicraft.entity.CreatureManager;
import net.ilexiconn.jurassicraft.entity.EntityJurassiCraftLandCoward;
import net.ilexiconn.jurassicraft.interfaces.IHerbivore;
import net.ilexiconn.jurassicraft.interfaces.IMammal;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityLeptictidium extends EntityJurassiCraftLandCoward implements IMammal, IHerbivore
{
	public ChainBuffer tailBuffer = new ChainBuffer(5);
	
    public EntityLeptictidium(World world)
    {
        super(world, CreatureManager.classToCreature(EntityLeptictidium.class));
        this.getNavigator().setAvoidsWater(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(2, this.aiSit);
        this.tasks.addTask(3, new JurassiCraftAIAvoidEntityIfNotTamed(this, EntityPlayer.class, 4.0F, 0.9D * this.getCreatureSpeed(), 1.2D * this.getCreatureSpeed()));
        this.tasks.addTask(4, new JurassiCraftAIFollowFoodCoward(this, 1.1D * this.getCreatureSpeed()));
        this.tasks.addTask(4, new JurassiCraftAIEatDroppedFood(this, 16.0D));
        this.tasks.addTask(5, new JurassiCraftAIWander(this, 0.8D * this.getCreatureSpeed()));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(6, new EntityAILookIdle(this));

        this.setCreatureExperiencePoints(1000);
    }

    @Override
    public double getMountedYOffset()
    {
        return (double) this.getYBouningBox() * 1.0D;
    }

    @Override
    public int getTalkInterval()
    {
        return 400;
    }

    @Override
    public void onUpdate()
    {
        super.onUpdate();
        this.tailBuffer.calculateChainSwingBuffer(60.0F, 3, 4.0F, this);
    }
    
    @Override
    protected void dropFewItems(boolean recentlyBeenHit, int enchantBonus)
    {
    	float developmentFraction = this.getGrowthStage() / 120.0F;
        int countMeath = Math.round(1 + (2.0F * developmentFraction) + this.rand.nextInt(1 + (int) (2.5F * developmentFraction)) + this.rand.nextInt(1 + enchantBonus));
        int countFur = Math.round(1.6F * developmentFraction + this.rand.nextInt(1 + (int) (1.6F * developmentFraction)));
        if (!this.isBurning())
        {
            this.dropItemStackWithGenetics(new ItemStack(this.getCreature().getMeat(), countMeath));
        }
        else
        {
            this.dropItem(this.getCreature().getSteak(), countMeath);
        }
        this.dropItemStackWithGenetics(new ItemStack(this.getCreature().getFur(), countFur));
    }
}