package net.ilexiconn.jurassicraft.client.animation;

import net.ilexiconn.jurassicraft.ai.AIAnimation;
import net.ilexiconn.jurassicraft.entity.EntityJurassiCraftAggressive;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;

public class AIBite extends AIAnimation {

	private EntityJurassiCraftAggressive entityDino;
	private EntityLivingBase attackTarget;

	public AIBite(EntityJurassiCraftAggressive dino)
	{
		super(dino);
		entityDino = dino;
		attackTarget = null;
	}

	public int getAnimationId()
	{
		return 5;
	}

	public boolean isAutomatic()
	{
		return true;
	}

	public int getDuration()
	{
		return 20;
	}

	public void startExecuting()
	{
		super.startExecuting();
		attackTarget = entityDino.getAttackTarget();
	}

	public void updateTask()
	{
		if (entityDino.getAnimationTick() < 10)
			entityDino.getLookHelper().setLookPositionWithEntity(attackTarget, 30F, 30F);

		if (entityDino.getAnimationTick() == 10 && attackTarget != null)
			attackTarget.attackEntityFrom(DamageSource.causeMobDamage(entityDino), (float) entityDino.getCreatureAttack());
	}
}
