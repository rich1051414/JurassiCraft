package net.ilexiconn.jurassicraft.entity.dinosaurs;

import net.ilexiconn.jurassicraft.ModItems;
import net.ilexiconn.jurassicraft.ai.JurassiCraftAIEatDroppedFood;
import net.ilexiconn.jurassicraft.ai.JurassiCraftAIFollowFood;
import net.ilexiconn.jurassicraft.ai.JurassiCraftAIWander;
import net.ilexiconn.jurassicraft.entity.CreatureManager;
import net.ilexiconn.jurassicraft.entity.EntityJurassiCraftLandProtective;
import net.ilexiconn.jurassicraft.interfaces.IDinosaur;
import net.ilexiconn.jurassicraft.interfaces.IHerbivore;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityAnkylosaurus extends EntityJurassiCraftLandProtective implements IDinosaur, IHerbivore
{
    public EntityAnkylosaurus(World world)
    {
        super(world, CreatureManager.classToCreature(EntityAnkylosaurus.class), 1);
        this.getNavigator().setAvoidsWater(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(2, this.aiSit);
        this.tasks.addTask(4, new JurassiCraftAIFollowFood(this, 1.1D * this.getCreatureSpeed()));
        this.tasks.addTask(4, new JurassiCraftAIEatDroppedFood(this, 16.0D));
        this.tasks.addTask(5, new JurassiCraftAIWander(this, 0.7D * this.getCreatureSpeed()));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(6, new EntityAILookIdle(this));
        this.setCreatureExperiencePoints(5000);
    }

    @Override
    public double getMountedYOffset()
    {
        return 1.05D * (double) this.getYBouningBox();
    }

    @Override
    public int getTalkInterval()
    {
        return 350;
    }

	@Override
	public String getLivingSound()
	{
		switch (this.rand.nextInt(9))
		{
			case 0:
				this.playSound("jurassicraft:AnkylosaurusRoar1", this.getSoundVolume(), this.getSoundPitch());
				break;
			case 1:
				this.playSound("jurassicraft:AnkylosaurusRoar2", this.getSoundVolume(), this.getSoundPitch());
				break;
			case 2:
				this.playSound("jurassicraft:AnkylosaurusSay1", this.getSoundVolume(), this.getSoundPitch());
				break;
			case 3:
				this.playSound("jurassicraft:AnkylosaurusSay2", this.getSoundVolume(), this.getSoundPitch());
				break;
			case 4:
				this.playSound("jurassicraft:AnkylosaurusCall1", this.getSoundVolume(), this.getSoundPitch());
				break;
			case 5:
				this.playSound("jurassicraft:AnkylosaurusCall2", this.getSoundVolume(), this.getSoundPitch());
		}
		return null;
	}

	@Override
	public String getHurtSound()
	{
		switch (this.rand.nextInt(4))
		{
			case 0:
				this.playSound("jurassicraft:AnkylosaurusCall1", this.getSoundVolume(), this.getSoundPitch());
				break;
			case 1:
				this.playSound("jurassicraft:AnkylosaurusCall2", this.getSoundVolume(), this.getSoundPitch());
				break;
			case 2:
				this.playSound("jurassicraft:AnkylosaurusSay1", this.getSoundVolume(), this.getSoundPitch());
		}
		return null;
	}

	@Override
	public String getDeathSound()
	{
		this.playSound("jurassicraft:AnkylosaurusCall2", this.getSoundVolume(), this.getSoundPitch());
		return null;
	}

    @Override
    protected void dropFewItems(boolean recentlyBeenHit, int enchantBonus)
    {
    	float developmentFraction = this.getGrowthStage() / 120.0F;
        int count = Math.round(1 + (3.0F * developmentFraction) + this.rand.nextInt(1 + (int) (3.0F * developmentFraction)) + this.rand.nextInt(1 + enchantBonus));
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
