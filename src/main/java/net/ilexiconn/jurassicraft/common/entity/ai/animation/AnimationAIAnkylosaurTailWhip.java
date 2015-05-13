package net.ilexiconn.jurassicraft.common.entity.ai.animation;

import net.ilexiconn.jurassicraft.common.entity.ai.AIAnimation;
import net.ilexiconn.jurassicraft.common.entity.dinosaurs.EntityAnkylosaurus;
import net.ilexiconn.jurassicraft.common.data.enums.JurassiCraftAnimationIDs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.DamageSource;

public class AnimationAIAnkylosaurTailWhip extends AIAnimation
{

    private EntityAnkylosaurus entityAnkylosaur;
    private EntityLiving attackTarget;

    public AnimationAIAnkylosaurTailWhip(EntityAnkylosaurus ankylosaur)
    {
        super(ankylosaur);
        entityAnkylosaur = ankylosaur;
        attackTarget = null;
    }

    public int getAnimationId()
    {
        return JurassiCraftAnimationIDs.TAIL_WHIP.animID();
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
        if (entityAnkylosaur.getAnimationTick() < 14)
            entityAnkylosaur.getLookHelper().setLookPositionWithEntity(attackTarget, 30F, 30F);
        if (entityAnkylosaur.getAnimationTick() == 14 && attackTarget != null)
            attackTarget.attackEntityFrom(DamageSource.causeMobDamage(entityAnkylosaur), 1);
    }
}
