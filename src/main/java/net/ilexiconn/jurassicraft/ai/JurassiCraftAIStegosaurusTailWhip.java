package net.ilexiconn.jurassicraft.ai;

import net.ilexiconn.jurassicraft.AnimationHandler;
import net.ilexiconn.jurassicraft.client.animation.JurassiCraftAnimationIDs;
import net.ilexiconn.jurassicraft.entity.dinosaurs.EntityStegosaurus;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;

public class JurassiCraftAIStegosaurusTailWhip extends EntityAIBase
{
	private EntityStegosaurus stegosaurus;
	private EntityLivingBase attacker;
	private double distanceSqFromAttacker;
	private Class targetClass;

	/**
	 * @author RafaMv
	 */
	public JurassiCraftAIStegosaurusTailWhip(EntityStegosaurus stegosaurus)
	{
		this.stegosaurus = stegosaurus;
		this.distanceSqFromAttacker = 0;
		this.attacker = null;
	}

	@Override
	public boolean shouldExecute()
	{
		if (this.stegosaurus.isDefending() && !this.stegosaurus.isSitting() && !this.stegosaurus.isSleeping() && !this.stegosaurus.isTakingOff() && !this.stegosaurus.isFlying() && !this.stegosaurus.isFleeing())
		{
			return this.stegosaurus.getCreatureToAttack() != null;
		}
		return false;
	}

	@Override
	public void startExecuting()
	{
		this.stegosaurus.getNavigator().clearPathEntity();

		if (this.stegosaurus.isTakingOff())
			this.stegosaurus.setTakingOff(false);

		if (this.stegosaurus.isFlying())
			this.stegosaurus.setFlying(false);

		if (this.stegosaurus.isDefending())
			this.stegosaurus.setDefending(false);

		if (this.stegosaurus.isAttacking())
			this.stegosaurus.setAttacking(false);

		if (this.stegosaurus.isFleeing())
			this.stegosaurus.setFleeing(false);

		if (this.stegosaurus.isEating())
			this.stegosaurus.setEating(false);

		if (this.stegosaurus.isDrinking())
			this.stegosaurus.setDrinking(false);

		if (this.stegosaurus.isSleeping())
			this.stegosaurus.setSleeping(false);

		if (this.stegosaurus.isSitting())
			this.stegosaurus.setSitting(false, null);

		if (this.stegosaurus.isBreeding())
			this.stegosaurus.setBreeding(false);

		if (this.stegosaurus.isInLove())
			this.stegosaurus.setInLove(false);

		if (this.stegosaurus.isStalking())
			this.stegosaurus.setStalking(false);

		this.attacker = this.stegosaurus.getCreatureToAttack();
		this.distanceSqFromAttacker = this.stegosaurus.getDistanceSqToEntity(this.attacker);
	}

	public void updateTask()
	{
		if (this.stegosaurus.getRNG().nextInt(5) == 0)
			this.distanceSqFromAttacker = this.stegosaurus.getDistanceSqToEntity(this.attacker);
		
		if (this.distanceSqFromAttacker < 40.0D && this.stegosaurus.getAnimationId() == 0)
            AnimationHandler.sendAnimationPacket(this.stegosaurus, JurassiCraftAnimationIDs.TAIL_WHIP.animID());
	}

	public boolean continueExecuting()
	{
		return this.attacker.isEntityAlive() && this.stegosaurus.isDefending() && this.distanceSqFromAttacker < 864 && !this.stegosaurus.isSitting() && this.stegosaurus.riddenByEntity == null;
	}

	@Override
	public void resetTask()
	{
		this.stegosaurus.setCreatureToAttack(null);
		this.stegosaurus.setDefending(false);
		this.distanceSqFromAttacker = 0;
		this.attacker = null;
	}
}
