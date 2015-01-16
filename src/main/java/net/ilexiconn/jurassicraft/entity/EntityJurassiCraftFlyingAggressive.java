package net.ilexiconn.jurassicraft.entity;

import java.util.List;

import net.ilexiconn.jurassicraft.ai.JurassiCraftEntityAIOwnerHurtByTarget;
import net.ilexiconn.jurassicraft.ai.JurassiCraftEntityAIOwnerHurtTarget;
import net.ilexiconn.jurassicraft.ai.JurassiCraftEntityAITargetIfNonTamed;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityJurassiCraftFlyingAggressive extends EntityJurassiCraftFlyingCreature
{
    public EntityJurassiCraftFlyingAggressive(World world, Creature creature, String landingMaterial)
    {
        super(world, creature, landingMaterial);
        this.tasks.addTask(3, new EntityAIAttackOnCollide(this, 1.25F * this.getCreatureSpeed(), false));
        this.targetTasks.addTask(1, new JurassiCraftEntityAIOwnerHurtByTarget(this));
        this.targetTasks.addTask(2, new JurassiCraftEntityAIOwnerHurtTarget(this));
        this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(4, new JurassiCraftEntityAITargetIfNonTamed(this, EntityPlayer.class, 0));
    }

    @Override
    public boolean canBreatheUnderwater()
    {
        return false;
    }

    @Override
    protected boolean canDespawn()
    {
        return false;
    }

    /**
     * Sets the attack target if it is adult. If it is also tamed, this will check if the target is tamed by the player.
     */
    private void becomeAngryAt(EntityJurassiCraftFlyingAggressive creature, Entity target)
    {
        if (creature.isCreatureAdult())
        {
            if (creature.isTamed())
            {
                if (this.checkTarget(target))
                {
                    creature.setAttackTarget((EntityLivingBase) target);
                }
            }
            else
            {
                creature.setAttackTarget((EntityLivingBase) target);
            }
        }
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
            Entity attacker = damageSource.getEntity();
            if (attacker != (Entity) null && this.checkTarget(attacker))
            {
                this.becomeAngryAt(this, attacker);
                List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(16.0D, 8.0D, 16.0D));
                for (int i = 0; i < list.size(); ++i)
                {
                    Entity entityNeighbor = (Entity) list.get(i);
                    if (entityNeighbor.getClass() == this.getClass())
                    {
                        EntityJurassiCraftFlyingAggressive entityNeighborAngry = (EntityJurassiCraftFlyingAggressive) entityNeighbor;
                        if (entityNeighborAngry.checkTarget(attacker))
                        {
                            becomeAngryAt(entityNeighborAngry, attacker);
                        }
                    }
                }
                return super.attackEntityFrom(damageSource, damage);
            }
            else
            {
                return super.attackEntityFrom(damageSource, damage);
            }
        }
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

    @Override
    public boolean attackEntityAsMob(Entity entity)
    {
        float attackDamage = (float) this.getCreatureAttack();
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
        }
        return flag;
    }
}
