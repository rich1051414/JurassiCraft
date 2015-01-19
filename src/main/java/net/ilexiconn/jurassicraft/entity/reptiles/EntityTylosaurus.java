package net.ilexiconn.jurassicraft.entity.reptiles;

import net.ilexiconn.jurassicraft.client.model.modelbase.ChainBuffer;
import net.ilexiconn.jurassicraft.entity.CreatureManager;
import net.ilexiconn.jurassicraft.entity.EntitySwimmingBase;
import net.ilexiconn.jurassicraft.interfaces.ICarnivore;
import net.ilexiconn.jurassicraft.interfaces.IPiscivore;
import net.ilexiconn.jurassicraft.interfaces.IReptile;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class EntityTylosaurus extends EntitySwimmingBase implements IReptile, ICarnivore, IPiscivore
{
	public ChainBuffer tailBuffer = new ChainBuffer(12);
	
    public EntityTylosaurus(World world)
    {
        super(world, CreatureManager.classToCreature(EntityTylosaurus.class));

        this.swimSpeed = 2.2F;
        this.setCreatureExperiencePoints(5000);
    	huntingInterval = 600;
    	this.setHungry(huntingInterval);
    }


    @Override
    public void onUpdate()
    {
        super.onUpdate();
        this.tailBuffer.calculateChainSwingBuffer(120.0F, 5, 8.0F, this);
    }
    
    public EntityLivingBase getTargetPriority(EntityLivingBase Target, EntityLivingBase entity1)
	{
		if(Target != null)
		{
			if(Target instanceof EntityPlayer)
				return Target;
			else if(Target instanceof EntityTylosaurus) //Won't go for other Tylosaurus unless nothing else around
				return entity1;
			else
				return Target;
		}
		else
			return entity1;
	}
    
    @Override
    protected void dropFewItems(boolean recentlyBeenHit, int enchantBonus)
    {
    	float developmentFraction = this.getGrowthStage() / 120.0F;
        int count = Math.round(1 + (5.0F * developmentFraction) + this.rand.nextInt(1 + (int) (5.5F * developmentFraction)) + this.rand.nextInt(1 + enchantBonus));
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
