package net.ilexiconn.jurassicraft.entity.fish;

import net.ilexiconn.jurassicraft.client.model.modelbase.ChainBuffer;
import net.ilexiconn.jurassicraft.client.model.modelbase.ControlledAnimation;
import net.ilexiconn.jurassicraft.entity.CreatureManager;
import net.ilexiconn.jurassicraft.entity.EntitySwimming;
import net.ilexiconn.jurassicraft.interfaces.IFish;
import net.ilexiconn.jurassicraft.interfaces.IPiscivore;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityCoelacanth extends EntitySwimming implements IFish, IPiscivore
{
	public ChainBuffer tailBuffer = new ChainBuffer(4);
	public ControlledAnimation droppingTimer = new ControlledAnimation(35);
	
    public EntityCoelacanth(World world)
    {
        super(world, CreatureManager.classToCreature(EntityCoelacanth.class));
        this.swimRadius = 8.0F;
        this.swimRadiusHeight = 4.0F;
        this.swimSpeed = 0.4F;
        this.jumpOnLand = false;

        this.setCreatureExperiencePoints(50);
    }

    @Override
    protected Entity findEntityToAttack()
    {
        return null;
    }

    @Override
    public void onUpdate()
    {
        super.onUpdate();
		if (this.isAirBorne || this.isInWater())
		{
			this.droppingTimer.decreaseTimer();
		}
		else
		{
			this.droppingTimer.increaseTimer();
		}
        this.tailBuffer.calculateChainSwingBuffer(55.0F, 3, 4.0F, this);
    }

    @Override
    protected void dropFewItems(boolean recentlyBeenHit, int enchantBonus)
    {
    	if (!this.isBurning())
        {
            this.dropItemStackWithGenetics(new ItemStack(this.getCreature().getMeat(), 1));
        }
        else
        {
            this.dropItem(this.getCreature().getSteak(), 1);
        }
    }

    @Override
    public boolean canDespawn()
    {
        return !this.isTamed();
    }
}
