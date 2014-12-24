package net.ilexiconn.jurassicraft.entity.fish;

import net.ilexiconn.jurassicraft.entity.CreatureManager;
import net.ilexiconn.jurassicraft.entity.EntitySwimming;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntityCoelacanth extends EntitySwimming
{
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
	public String getLivingSound()
	{
		return null;
	}

	@Override
	public String getHurtSound()
	{
		return null;
	}

	@Override
	public String getDeathSound()
	{
		return null;
	}

	@Override
	public Item getDropItem()
	{
		return this.getCreature().getMeat();
	}

	@Override
	protected void dropFewItems(boolean recentlyBeenHit, int enchantBonus) 
	{
		this.dropItem(this.getCreature().getMeat(), 1);
	}
}
