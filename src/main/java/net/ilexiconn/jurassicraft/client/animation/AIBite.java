package net.ilexiconn.jurassicraft.client.animation;

import net.ilexiconn.jurassicraft.ai.AIAnimation;
import net.ilexiconn.jurassicraft.entity.EntityJurassiCraftAggressive;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.DamageSource;

public class AIBite extends AIAnimation {
		
		private EntityJurassiCraftAggressive entityDino;
		private EntityLiving attackTarget;
		
		public AIBite(EntityJurassiCraftAggressive dino) {
			super(dino);
			entityDino = dino;
			attackTarget = null;
		}
		
		public int getAnimationId() {
			return 5;
		}
		
		public boolean isAutomatic() {
			return true;
		}
		
		public int getDuration() {
			return 30;
		}
		public void startExecuting() {
			super.startExecuting();
			attackTarget = (EntityLiving) entityDino.getAttackTarget();
		}
		public void updateTask() {
			if(entityDino.getAnimationTick() < 20)
				entityDino.getLookHelper().setLookPositionWithEntity(attackTarget, 30F, 30F);
			if(entityDino.getAnimationTick() == 20 && attackTarget != null)
				attackTarget.attackEntityFrom(DamageSource.causeMobDamage(entityDino), (float) entityDino.getCreatureAttack());
		}
}
