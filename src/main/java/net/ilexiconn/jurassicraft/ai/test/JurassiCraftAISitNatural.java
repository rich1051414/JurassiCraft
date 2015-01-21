package net.ilexiconn.jurassicraft.ai.test;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;

public class JurassiCraftAISitNatural extends EntityAIBase {

	private EntityJurassiCraftSmart creature;
	private int nonTamedStartingTime;
	private int nonTamedTimer;
	private int nonTamedChance;
	private int nonTamedMinDuration;
	private int nonTamedDurationVariation;

	/**
	 * This AI handles the sitting state of the creature. It can be set to sit by its owner, or can
	 * naturally sit if it does not have a owner.
	 * 
	 * @param creature is the entity that will sit;
	 * @param nonTamedStartingTime is a minimum amount of time required to sit. Must be greater than or equal to 500;
	 * @param nonTamedChange is the chance that the creature will sit is not tamed. Must be greater then 0;
	 * @param nonTamedMinDuration is the minimum time that a non tamed creature will be sitting. 
	 * It should be greater than or equal to 300, and can vary between the minimum value and 1.5 of this value.
	 * 
	 * @author RafaMv
	 */
	public JurassiCraftAISitNatural(EntityJurassiCraftSmart creature, int nonTamedStartingTime, int nonTamedChance, int nonTamedMinDuration) {
		this.creature = creature;
		this.setMutexBits(5);
		this.nonTamedTimer = 0;
		if (nonTamedStartingTime > 499) {
			this.nonTamedStartingTime = nonTamedStartingTime;
		} else {
			this.nonTamedStartingTime = 500;
		}
		if (nonTamedChance > 0) {
			this.nonTamedChance = nonTamedChance;
		} else {
			this.nonTamedChance = 1;
		}
		if (nonTamedMinDuration > 299) {
			this.nonTamedDurationVariation = (int) (nonTamedMinDuration * 0.5F * this.creature.getRNG().nextFloat());
			this.nonTamedMinDuration = nonTamedMinDuration + this.nonTamedDurationVariation;
		} else {
			this.nonTamedDurationVariation = (int) (300 + 150 * this.creature.getRNG().nextFloat());
			this.nonTamedMinDuration = 300 + this.nonTamedDurationVariation;
		}
	}

	@Override
	public boolean shouldExecute() {
		if (this.creature.isInWater() || !this.creature.onGround || this.creature.isSwimming() || this.creature.isFlying() || this.creature.riddenByEntity != null || this.creature.isEating() || this.creature.isDrinking() || this.creature.isPlaying() || this.creature.isDefending()  || this.creature.isBreeding())
			return false;
		
		if (!this.creature.isTamed()) {
			this.nonTamedTimer++;
			if (this.nonTamedTimer > this.nonTamedStartingTime) {
				return this.creature.getRNG().nextInt(this.nonTamedChance) == 0 && !this.creature.isDefending();
			} else {
				return false;
			}
		} else {
			EntityLivingBase entitylivingbase = this.creature.getOwner();
			return this.creature.isSitting() ? (entitylivingbase == null ? false : (this.creature.getDistanceSqToEntity(entitylivingbase) < 144.0D && entitylivingbase.getAITarget() == null)) : false;
		}
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
		if (this.creature.isTamed()) {
			this.creature.setSitting(true, (EntityPlayer) this.creature.getOwner());
		} else {
			this.creature.setSitting(true, null);
		}
		this.nonTamedTimer = 0;
	}

	@Override
	public void updateTask() {
		if (!this.creature.isTamed())
			this.nonTamedTimer++;
	}

	@Override
	public boolean continueExecuting() {
		return this.nonTamedTimer < this.nonTamedMinDuration && this.creature.isSitting();
	}

	@Override
	public void resetTask() {
		this.nonTamedDurationVariation = (int) (this.nonTamedMinDuration * 0.5F * this.creature.getRNG().nextFloat());
		this.nonTamedTimer = 0;
		if (this.creature.isTamed()) {
			this.creature.setSitting(false, (EntityPlayer) this.creature.getOwner());
		} else {
			this.creature.setSitting(false, null);
		}
	}
}
