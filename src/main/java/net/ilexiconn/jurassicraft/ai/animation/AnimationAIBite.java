package net.ilexiconn.jurassicraft.ai.animation;

import net.ilexiconn.jurassicraft.AnimationHandler;
import net.ilexiconn.jurassicraft.ai.AIAnimation;
import net.ilexiconn.jurassicraft.entity.EntityJurassiCraftAggressive;
import net.ilexiconn.jurassicraft.entity.EntityJurassiCraftCreature;
import net.ilexiconn.jurassicraft.entity.dinosaurs.EntityGallimimus;
import net.ilexiconn.jurassicraft.entity.dinosaurs.EntityTyrannosaurus;
import net.ilexiconn.jurassicraft.enums.JurassiCraftAnimationIDs;
import net.ilexiconn.jurassicraft.interfaces.IAnimatedEntity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;

public class AnimationAIBite extends AIAnimation
{
    private EntityJurassiCraftCreature entityBiting;
    private EntityLivingBase entityTarget;
    private int duration;

    public AnimationAIBite(EntityJurassiCraftCreature dino, int duration)
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
            if (this.entityBiting.getAnimationTick() < ((this.duration / 2) - 2))
                this.entityBiting.getLookHelper().setLookPositionWithEntity(this.entityTarget, 30F, 30F);

            if (this.entityBiting.getAnimationTick() == ((this.duration / 2) - 2))
            {
                float damage = (float) this.entityBiting.getCreatureAttack();
                if ((this.entityTarget.getHealth() - damage <= 0.0F) && this.entityBiting instanceof EntityTyrannosaurus && this.entityTarget instanceof EntityGallimimus)
                {
                    this.entityTarget.mountEntity(this.entityBiting);
                    this.entityBiting.setAttackTarget((EntityLivingBase) null);
                    this.entityBiting.getNavigator().clearPathEntity();
                    AnimationHandler.sendAnimationPacket(this.entityBiting, JurassiCraftAnimationIDs.EATING.animID());
                    EntityGallimimus gallimimus = (EntityGallimimus) this.entityTarget;
                    gallimimus.setAttackTarget((EntityLivingBase) null);
                    gallimimus.getNavigator().clearPathEntity();
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
        /** Eating animations, should not use super.resetTask, or the eating animation ID will be replaced */
        if (this.entityBiting instanceof EntityTyrannosaurus && this.entityTarget instanceof EntityGallimimus)
        {
            this.entityTarget = null;
            return;
        }
        this.entityTarget = null;
        super.resetTask();
    }
}
