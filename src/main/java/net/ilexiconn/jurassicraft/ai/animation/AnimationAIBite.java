package net.ilexiconn.jurassicraft.ai.animation;

import net.ilexiconn.jurassicraft.AnimationHandler;
import net.ilexiconn.jurassicraft.ai.AIAnimation;
import net.ilexiconn.jurassicraft.entity.EntityJurassiCraftCreature;
import net.ilexiconn.jurassicraft.entity.dinosaurs.EntityGallimimus;
import net.ilexiconn.jurassicraft.entity.dinosaurs.EntityTyrannosaurus;
import net.ilexiconn.jurassicraft.enums.JurassiCraftAnimationIDs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;

public class AnimationAIBite extends AIAnimation
{
    private EntityJurassiCraftCreature entityBiting;
    private EntityLivingBase entityTarget;
    private int duration;
    private boolean eat;

    public AnimationAIBite(EntityJurassiCraftCreature dino, int duration)
    {
        super(dino);
        this.entityBiting = dino;
        this.entityTarget = null;
        this.duration = duration;
        eat = false;
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
                    eat = true;
                }
                else
                {
                    eat = false;
                    this.entityTarget.attackEntityFrom(DamageSource.causeMobDamage(this.entityBiting), damage);
                }
            }
        }
    }

    @Override
    public void resetTask()
    {
        /** Eating animations, should not use super.resetTask, or the eating animation ID will be replaced */
        if (eat && this.entityTarget instanceof EntityGallimimus)
        {
            super.resetTask();
            this.entityTarget.mountEntity(this.entityBiting);
            this.entityBiting.setAttackTarget(null);
            this.entityBiting.getNavigator().clearPathEntity();
            entityBiting.setAnimationTick(0);
            AnimationHandler.sendAnimationPacket(this.entityBiting, JurassiCraftAnimationIDs.EATING.animID());
            EntityGallimimus gallimimus = (EntityGallimimus) this.entityTarget;
            gallimimus.setAttackTarget(null);
            gallimimus.getNavigator().clearPathEntity();
            AnimationHandler.sendAnimationPacket(gallimimus, JurassiCraftAnimationIDs.BEING_EATEN.animID());
            this.entityTarget = null;
            return;
        }
        this.entityTarget = null;
        super.resetTask();
    }
}
