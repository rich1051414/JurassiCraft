package net.ilexiconn.jurassicraft.client.animation;

import net.ilexiconn.jurassicraft.AnimationHandler;
import net.ilexiconn.jurassicraft.ai.AIAnimation;
import net.ilexiconn.jurassicraft.entity.EntityJurassiCraftAggressive;
import net.ilexiconn.jurassicraft.entity.dinosaurs.EntityGallimimus;
import net.ilexiconn.jurassicraft.entity.dinosaurs.EntityTyrannosaurus;
import net.ilexiconn.jurassicraft.interfaces.IAnimatedEntity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;

public class AIBite extends AIAnimation {

	private EntityJurassiCraftAggressive entityDino;
	private EntityLivingBase attackTarget;
	private boolean trex = false;
	private boolean galli = false;
	private float damage;

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
		if (entityDino instanceof EntityTyrannosaurus) trex = true;
		if (attackTarget instanceof EntityGallimimus) galli = true;
		damage = (float) entityDino.getCreatureAttack();
	}

	public void updateTask()
	{
		if (entityDino.getAnimationTick() < 10)
			entityDino.getLookHelper().setLookPositionWithEntity(attackTarget, 30F, 30F);
		if (entityDino.getAnimationTick() == 10 && attackTarget != null) {
			if (trex && galli && (attackTarget.getHealth() - damage) <= 0.0F) {
				attackTarget.mountEntity(entityDino);
				entityDino.setAttackTarget((EntityLivingBase) null);
				((EntityLiving) attackTarget).setAttackTarget((EntityLivingBase) null);
				AnimationHandler.sendAnimationPacket(entityDino, 3);
				AnimationHandler.sendAnimationPacket((IAnimatedEntity) attackTarget, 1);
			} else {
				attackTarget.attackEntityFrom(DamageSource.causeMobDamage(entityDino), damage);
			}
		}
	}
}
