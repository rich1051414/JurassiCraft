package net.ilexiconn.jurassicraft.ai.test;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;

public class JurassiCraftAISit extends EntityAIBase {

	private EntityJurassiCraftSmart creature;

	/**
	 * This AI handles the sitting state of the creature. It can only be set by the creature owner.
	 * 
	 * @param creature is the entity that will sit;
	 * 
	 * @author RafaMv
	 */
	public JurassiCraftAISit(EntityJurassiCraftSmart creature) {
		this.creature = creature;
		this.setMutexBits(5);
	}

	@Override
	public boolean shouldExecute() {
		if (this.creature.isInWater() || !this.creature.onGround || !this.creature.isTamed() || this.creature.isSwimming() || this.creature.isFlying() || this.creature.riddenByEntity != null || this.creature.isEating() || this.creature.isDrinking() || this.creature.isPlaying() || this.creature.isDefending()  || this.creature.isBreeding())
			return false;
		
		EntityLivingBase entitylivingbase = this.creature.getOwner();
		return !this.creature.isSitting() ? false : (entitylivingbase == null ? false : (this.creature.getDistanceSqToEntity(entitylivingbase) < 144.0D && entitylivingbase.getAITarget() == null));
	}

	@Override
	public void startExecuting() {
		this.creature.getNavigator().clearPathEntity();
		this.creature.setSwimming(false);
		this.creature.setFlying(false);
		this.creature.setEating(false);
		this.creature.setDrinking(false);
		this.creature.setDefending(false);
		this.creature.setPlaying(false);
		this.creature.setBreeding(false);
		this.creature.setSitting(true, (EntityPlayer) this.creature.getOwner());
	}

	@Override
	public boolean continueExecuting() {
		return this.creature.isSitting() && !this.creature.hasBeenHurt();
	}

	@Override
	public void resetTask() {
		this.creature.setSitting(false, (EntityPlayer) this.creature.getOwner());
	}
}
