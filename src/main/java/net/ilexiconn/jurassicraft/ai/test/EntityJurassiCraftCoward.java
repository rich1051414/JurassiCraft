package net.ilexiconn.jurassicraft.ai.test;

import java.util.ArrayList;
import java.util.List;

import net.ilexiconn.jurassicraft.entity.Creature;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityJurassiCraftCoward extends EntityJurassiCraftSmart {

	public EntityJurassiCraftCoward(World world, Creature creature) {
		super(world, creature);
	}

	/** Sets the creature to flee. */
	private void startFleeing() {
		if (this.isSitting())
			this.setSitting(false, null);
		this.setAttackTarget((EntityLivingBase) null);
		this.setFleeing(true);
	}

	@Override
	public boolean attackEntityFrom(DamageSource damageSource, float damage) {
		if (this.isEntityInvulnerable()) {
			return false;
		} else {
			List<Entity> list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(18.0D, 8.0D, 18.0D));
			ArrayList<EntityJurassiCraftCoward> listOfCowards = new ArrayList<EntityJurassiCraftCoward>();
			listOfCowards.add(this);
			for (int i = 0; i < list.size(); ++i) {
				Entity entityNeighbor = (Entity) list.get(i);
				if (entityNeighbor.getClass() == this.getClass() && entityNeighbor != this) {
					listOfCowards.add((EntityJurassiCraftCoward) entityNeighbor);
				}
			}
			if (!listOfCowards.isEmpty()) {
				for (EntityJurassiCraftCoward creatures : listOfCowards) {
					creatures.startFleeing();
				}
			}
			return super.attackEntityFrom(damageSource, damage);
		}
	}
}
