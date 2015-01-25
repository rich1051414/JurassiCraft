package net.ilexiconn.jurassicraft.ai;

import java.util.ArrayList;

import net.ilexiconn.jurassicraft.AnimationHandler;
import net.ilexiconn.jurassicraft.client.animation.JurassiCraftAnimationIDs;
import net.ilexiconn.jurassicraft.entity.EntityJurassiCraftCoward;
import net.ilexiconn.jurassicraft.entity.EntityJurassiCraftSmart;
import net.minecraft.entity.ai.EntityAIBase;

public class JurassiCraftAIPlayfulBaby extends EntityAIBase
{

	private EntityJurassiCraftSmart creature;
	private EntityJurassiCraftSmart otherCreature;
	private int chance;
	private float maxAge;

	public JurassiCraftAIPlayfulBaby(EntityJurassiCraftSmart creature, int chance, float maxAge)
	{
		this.creature = creature;
		this.chance = chance;
		this.maxAge = maxAge;
		this.otherCreature = null;
	}

	@Override
	public boolean shouldExecute() {
		if (this.creature.getRNG().nextInt(this.chance) > 0 || this.creature.isCreatureOlderThan(this.maxAge) || this.creature.isPlaying() || this.creature.isSocializing() || this.creature.isSitting() || this.creature.isSleeping() || this.creature.isFleeing() || this.creature.isEating() || this.creature.isDrinking() || this.creature.isAttacking() || this.creature.isDefending()) {
			return false;
		} else {
			ArrayList<EntityJurassiCraftCoward> closeCowardList = this.creature.getClosestEntityCowardList(this.creature, 8.0D, 3.0D, 8.0D);
			if (!closeCowardList.isEmpty()) {
				for (EntityJurassiCraftCoward entity : closeCowardList) {
					if (entity != null && entity.getClass() == this.creature.getClass()) {
						this.otherCreature = (EntityJurassiCraftSmart) entity;
						return !this.otherCreature.isCreatureOlderThan(this.maxAge) && !this.otherCreature.isPlaying() && this.otherCreature.getAnimationId() == 0 && this.otherCreature.getAnimationId() == 0 && !this.otherCreature.isSocializing() && !this.otherCreature.isSitting() && !this.otherCreature.isSleeping() && !this.otherCreature.isFleeing() && !this.otherCreature.isEating() && !this.otherCreature.isDrinking() && !this.otherCreature.isAttacking() && !this.otherCreature.isDefending();
					}
				}
			}
		}
		return false;
	}

	@Override
	public void startExecuting() {
		if (this.creature.isTakingOff())
			this.creature.setTakingOff(false);
		if (this.creature.isFlying())
			this.creature.setFlying(false);
		if (this.creature.isDefending())
			this.creature.setDefending(false);
		if (this.creature.isAttacking())
			this.creature.setAttacking(false);
		if (this.creature.isFleeing())
			this.creature.setFleeing(false);
		if (this.creature.isEating())
			this.creature.setEating(false);
		if (this.creature.isDrinking())
			this.creature.setDrinking(false);
		if (this.creature.isSleeping())
			this.creature.setSleeping(false);
		if (this.creature.isSitting())
			this.creature.setSitting(false, null);
		if (this.creature.isBreeding())
			this.creature.setBreeding(false);

		if (this.otherCreature.isTakingOff())
			this.otherCreature.setTakingOff(false);
		if (this.otherCreature.isFlying())
			this.otherCreature.setFlying(false);
		if (this.otherCreature.isDefending())
			this.otherCreature.setDefending(false);
		if (this.otherCreature.isAttacking())
			this.otherCreature.setAttacking(false);
		if (this.otherCreature.isFleeing())
			this.otherCreature.setFleeing(false);
		if (this.otherCreature.isEating())
			this.otherCreature.setEating(false);
		if (this.otherCreature.isDrinking())
			this.otherCreature.setDrinking(false);
		if (this.otherCreature.isSleeping())
			this.otherCreature.setSleeping(false);
		if (this.otherCreature.isSitting())
			this.otherCreature.setSitting(false, null);
		if (this.otherCreature.isBreeding())
			this.otherCreature.setBreeding(false);

		this.creature.setSocializing(true);
		this.creature.setPlaying(true);

		this.otherCreature.setSocializing(true);
		this.otherCreature.setPlaying(true);
		
    	this.creature.getNavigator().tryMoveToEntityLiving(this.otherCreature, this.creature.getCreatureSpeed());
	}

	@Override
	public void updateTask() {
		if (!this.creature.hasPath())
			this.creature.getNavigator().tryMoveToEntityLiving(this.otherCreature, this.creature.getCreatureSpeed());
	}

	@Override
    public boolean continueExecuting() {
    	return this.creature.getDistanceSqToEntity(this.otherCreature) > 20.0D;
    }

	@Override
	public void resetTask() {
		if (this.creature.getAnimationId() == 0)
			AnimationHandler.sendAnimationPacket(this.creature, JurassiCraftAnimationIDs.PLAYING.animID());

		if (this.otherCreature.getAnimationId() == 0)
			AnimationHandler.sendAnimationPacket(this.otherCreature, JurassiCraftAnimationIDs.PLAYING.animID());
	
		this.creature.setSocializing(false);
		this.creature.setPlaying(false);
		this.otherCreature.setSocializing(false);
		this.otherCreature.setPlaying(false);
		this.otherCreature = null;
	}
}
