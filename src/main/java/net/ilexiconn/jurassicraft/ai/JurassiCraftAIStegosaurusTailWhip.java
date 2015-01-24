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
		this.stegosaurus.setTakingOff(false);
		this.stegosaurus.setFlying(false);
		this.stegosaurus.setSitting(false, null);
		this.stegosaurus.setSleeping(false);
		this.stegosaurus.setAttacking(false);
		this.stegosaurus.setFleeing(false);
		this.stegosaurus.setStalking(false);
		this.stegosaurus.setEating(false);
		this.stegosaurus.setDrinking(false);
		this.stegosaurus.setPlaying(false);
		this.stegosaurus.setBreeding(false);
		this.stegosaurus.setInLove(false);
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
		this.stegosaurus.setDefending(false);
		this.distanceSqFromAttacker = 0;
		this.attacker = null;
	}
}
