package net.ilexiconn.jurassicraft.client.animation;

import net.ilexiconn.jurassicraft.entity.dinosaurs.EntityAnkylosaur;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.DamageSource;
import thehippomaster.AnimationAPI.AIAnimation;

public class AIAnkylosaurTailWhip extends AIAnimation
{

    private EntityAnkylosaur entityAnkylosaur;
    private EntityLiving attackTarget;

    public AIAnkylosaurTailWhip(EntityAnkylosaur ankylosaur)
    {
        super(ankylosaur);
        entityAnkylosaur = ankylosaur;
        attackTarget = null;
    }

    public int getAnimID()
    {
        return 1;
    }

    public boolean isAutomatic()
    {
        return true;
    }

    public int getDuration()
    {
        return 30;
    }

    public void startExecuting()
    {
        super.startExecuting();
        attackTarget = (EntityLiving) entityAnkylosaur.getAttackTarget();
    }

    public void updateTask()
    {
        if (entityAnkylosaur.getAnimTick() < 14)
            entityAnkylosaur.getLookHelper().setLookPositionWithEntity(attackTarget, 30F, 30F);
        if (entityAnkylosaur.getAnimTick() == 14 && attackTarget != null)
            attackTarget.attackEntityFrom(DamageSource.causeMobDamage(entityAnkylosaur), 1);
    }
}
