package net.ilexiconn.jurassicraft.entity;

import net.ilexiconn.jurassicraft.entity.dinosaurs.EntityDilophosaurus;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

/**
 * Created by jnad325 on 3/14/15.
 */
public class EntitySpit extends EntityThrowable
{
    public EntitySpit(World world)
    {
        super(world);
    }

    public EntitySpit(World world, EntityLivingBase entity)
    {
        super(world, entity);
    }

    public EntitySpit(World p_i1775_1_, double p_i1775_2_, double p_i1775_4_, double p_i1775_6_)
    {
        super(p_i1775_1_, p_i1775_2_, p_i1775_4_, p_i1775_6_);
    }

    protected void onImpact(MovingObjectPosition mop)
    {
        EntityLivingBase thrower = getThrower();

        if (thrower instanceof EntityDilophosaurus)
        {
            EntityDilophosaurus spitter = (EntityDilophosaurus) thrower;

            if (mop.entityHit != null && mop.entityHit instanceof EntityLivingBase && mop.entityHit != spitter && (mop.entityHit == spitter.getAttackTarget() || !(mop.entityHit instanceof EntityDilophosaurus)))
            {
                EntityLivingBase entityHit = (EntityLivingBase) mop.entityHit;

                entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 1.0f);
                entityHit.addPotionEffect(new PotionEffect(Potion.blindness.id, 300, 1, false));
                entityHit.addPotionEffect(new PotionEffect(Potion.poison.id, 300, 1, false));

            }
        }
        //        this.

        float size = 3F;
        for (int i = 0; i < 8; ++i)
        {
            this.worldObj.spawnParticle("reddust", this.posX + (size * Math.random() - size / 2), this.posY + (size * Math.random() - size / 2), this.posZ + (size * Math.random() - size / 2), 0.2D, 0.2D, 0.2D);
        }

        if (!this.worldObj.isRemote)
        {
            this.setDead();
        }
    }

    @Override
    public void onUpdate()
    {
        super.onUpdate();
        float size = 0.35F;
        for (int i = 0; i < 6; ++i)
        {
            this.worldObj.spawnParticle("reddust", this.posX + (size * Math.random() - size / 2), this.posY + (size * Math.random() - size / 2), this.posZ + (size * Math.random() - size / 2), 0.2D, 0.2D, 0.2D);
        }
    }
}
