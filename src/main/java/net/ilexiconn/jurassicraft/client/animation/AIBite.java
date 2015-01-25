package net.ilexiconn.jurassicraft.client.animation;

import net.ilexiconn.jurassicraft.AnimationHandler;
import net.ilexiconn.jurassicraft.ai.AIAnimation;
import net.ilexiconn.jurassicraft.entity.EntityJurassiCraftAggressive;
import net.ilexiconn.jurassicraft.entity.dinosaurs.EntityGallimimus;
import net.ilexiconn.jurassicraft.entity.dinosaurs.EntityTyrannosaurus;
import net.ilexiconn.jurassicraft.interfaces.IAnimatedEntity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;

public class AIBite extends AIAnimation {

	private EntityJurassiCraftAggressive entityBiting;
	private EntityLivingBase entityTarget;
	private int duration;

	public AIBite(EntityJurassiCraftAggressive dino)
	{
		this(dino, 20);
	}
	
	public AIBite(EntityJurassiCraftAggressive dino, int duration)
	{
		super(dino);
		this.entityBiting = dino;
		this.entityTarget = null;
		this.duration = duration;
	}

	public int getAnimationId()
	{
		return JurassiCraftAnimationIDs.BITE.animID();
	}

	public boolean isAutomatic()
	{
		return true;
	}

	public int getDuration()
	{
		return this.duration;
	}

	public void startExecuting()
	{
		super.startExecuting();
		this.entityTarget = this.entityBiting.getAttackTarget();
	}

	public void updateTask()
	{
		if (this.entityTarget != null)
		{
			if (this.entityBiting.getAnimationTick() < 10)
				this.entityBiting.getLookHelper().setLookPositionWithEntity(this.entityTarget, 30F, 30F);

			if (this.entityBiting.getAnimationTick() == 10)
			{
				float damage = (float) this.entityBiting.getCreatureAttack();
				if ((this.entityTarget.getHealth() - damage <= 0.0F) && this.entityBiting instanceof EntityTyrannosaurus && this.entityTarget instanceof EntityGallimimus)
				{
					this.entityTarget.mountEntity(this.entityBiting);
					this.entityBiting.setAttackTarget((EntityLivingBase) null);
					this.entityBiting.setPathToEntity(null);
					AnimationHandler.sendAnimationPacket(this.entityBiting, JurassiCraftAnimationIDs.EATING.animID());
					EntityGallimimus gallimimus = (EntityGallimimus) this.entityTarget;
					gallimimus.setAttackTarget((EntityLivingBase) null);
					gallimimus.setPathToEntity(null);
					AnimationHandler.sendAnimationPacket((IAnimatedEntity) this.entityTarget, JurassiCraftAnimationIDs.BEING_EATEN.animID());
				}
				else
				{
					this.entityTarget.attackEntityFrom(DamageSource.causeMobDamage(this.entityBiting), damage);
				}
			}
		}
	}
	
	@Override
	public void resetTask()
	{
		if (this.entityTarget instanceof EntityGallimimus) {
			this.entityTarget = null;
			return;
		}
		super.resetTask();
		this.entityTarget = null;
	}
}
