package net.ilexiconn.jurassicraft.ai.animation;

import net.ilexiconn.jurassicraft.ai.AIAnimation;
import net.ilexiconn.jurassicraft.entity.dinosaurs.EntityHypsilophodon;
import net.ilexiconn.jurassicraft.enums.JurassiCraftAnimationIDs;

public class AnimationAIHypsilophodonSocializing extends AIAnimation
{
    private EntityHypsilophodon hypsilophodon;

    public AnimationAIHypsilophodonSocializing(EntityHypsilophodon hypsilophodon)
    {
        super(hypsilophodon);
        this.hypsilophodon = hypsilophodon;
    }

    @Override
    public int getAnimationId()
    {
        return JurassiCraftAnimationIDs.SOCIALIZING.animID();
    }

    @Override
    public boolean isAutomatic()
    {
        return true;
    }

    @Override
    public int getDuration()
    {
        return 70;
    }

    @Override
    public void startExecuting()
    {
        super.startExecuting();
        this.hypsilophodon.setSitting(false, null);
    }

    @Override
    public void updateTask()
    {
        if (this.hypsilophodon.getCreatureToAttack() != null && this.hypsilophodon.getCreatureToAttack() instanceof EntityHypsilophodon)
        {
            EntityHypsilophodon friend = (EntityHypsilophodon) this.hypsilophodon.getCreatureToAttack();
            if (this.hypsilophodon.getAnimationTick() < 5)
            {
                this.hypsilophodon.getLookHelper().setLookPositionWithEntity(friend, 30F, 30F);
            }
            //Do stuff
        }
    }

    @Override
    public void resetTask()
    {
        super.resetTask();
        this.hypsilophodon.setCreatureToAttack(null);
    }
}
