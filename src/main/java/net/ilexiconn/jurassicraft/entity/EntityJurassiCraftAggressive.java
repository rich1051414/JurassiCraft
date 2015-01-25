package net.ilexiconn.jurassicraft.entity;

import net.ilexiconn.jurassicraft.AnimationHandler;
import net.ilexiconn.jurassicraft.client.animation.AIBite;
import net.ilexiconn.jurassicraft.client.animation.JurassiCraftAnimationIDs;
import net.ilexiconn.jurassicraft.entity.birds.EntityTitanis;
import net.ilexiconn.jurassicraft.entity.dinosaurs.EntityCarnotaurus;
import net.ilexiconn.jurassicraft.entity.dinosaurs.EntityHerrerasaurus;
import net.ilexiconn.jurassicraft.entity.dinosaurs.EntityTyrannosaurus;
import net.ilexiconn.jurassicraft.entity.dinosaurs.EntityVelociraptor;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityJurassiCraftAggressive extends EntityJurassiCraftRidable {

	public EntityJurassiCraftAggressive(World world, Creature creature) {
		super(world, creature);
        this.tasks.addTask(2, new AIBite(this, this.getBiteAnimationDuration()));
    }

	@Override
    public boolean attackEntityFrom(DamageSource damageSource, float damage)
    {
        if (this.isEntityInvulnerable())
        {
            return false;
        }
        else
        {
            Entity entity = damageSource.getEntity();
            if (entity != (Entity) null && entity instanceof EntityLivingBase)
            {
            	EntityLivingBase attacker = (EntityLivingBase) entity;
            	if (this.checkTargetBeforeAttacking(attacker))
                {
                    this.setCreatureAngry(this, attacker);
                }
            }
            return super.attackEntityFrom(damageSource, damage);
        }
    }

    protected int getBiteAnimationDuration() {
		if (this instanceof EntityTyrannosaurus) return 20;
		else if (this instanceof EntityCarnotaurus) return 20;
		else if (this instanceof EntityVelociraptor) return 10;
		else if (this instanceof EntityHerrerasaurus) return 10;
		else if (this instanceof EntityTitanis) return 10;
		else return 10;
	}

    @Override
    public boolean attackEntityAsMob(Entity entity)
    {
/*    	float attackDamage = (float) this.getCreatureAttack();
        int i = 0;
        if (entity instanceof EntityLivingBase)
        {
            attackDamage += EnchantmentHelper.getEnchantmentModifierLiving(this, (EntityLivingBase) entity);
            i += EnchantmentHelper.getKnockbackModifier(this, (EntityLivingBase) entity);
        }
        boolean flag = entity.attackEntityFrom(DamageSource.causeMobDamage(this), attackDamage);
        if (flag)
        {
            if (i > 0)
            {
                entity.addVelocity((double) (-MathHelper.sin(this.rotationYaw * (float) Math.PI / 180.0F) * (float) i * 0.5F), 0.1D, (double) (MathHelper.cos(this.rotationYaw * (float) Math.PI / 180.0F) * (float) i * 0.5F));
                this.motionX *= 0.6D;
                this.motionZ *= 0.6D;
            }
            int j = EnchantmentHelper.getFireAspectModifier(this);
            if (j > 0)
            {
                entity.setFire(j * 4);
            }
            if (entity instanceof EntityLivingBase)
            {
                EnchantmentHelper.func_151384_a((EntityLivingBase) entity, this);
            }
            EnchantmentHelper.func_151385_b(this, entity);
        }*/
    	if(/*flag && */animID == 0)
    		AnimationHandler.sendAnimationPacket(this, JurassiCraftAnimationIDs.BITE.animID());
        return true;//flag;
    }

	@Override
    protected void attackEntity(Entity entity, float par2)
    {
        if (this.attackTime <= 0 && par2 < 2.0F && entity.boundingBox.maxY > this.boundingBox.minY && entity.boundingBox.minY < this.boundingBox.maxY)
        {
            this.attackTime = 20;
            this.attackEntityAsMob(entity);
        }
    }
}
