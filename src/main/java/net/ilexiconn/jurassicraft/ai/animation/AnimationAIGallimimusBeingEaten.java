package net.ilexiconn.jurassicraft.ai.animation;

import net.ilexiconn.jurassicraft.ai.AIAnimation;
import net.ilexiconn.jurassicraft.entity.dinosaurs.EntityGallimimus;
import net.ilexiconn.jurassicraft.entity.dinosaurs.EntityTyrannosaurus;
import net.ilexiconn.jurassicraft.enums.JurassiCraftAnimationIDs;

public class AnimationAIGallimimusBeingEaten extends AIAnimation
{
    private EntityTyrannosaurus tyrannosaurus;
    private EntityGallimimus gallimimus;

    public AnimationAIGallimimusBeingEaten(EntityGallimimus gallimimus)
    {
        super(gallimimus);
        this.gallimimus = gallimimus;
    }

    public int getAnimationId()
    {
        return JurassiCraftAnimationIDs.BEING_EATEN.animID();
    }

    public int getDuration()
    {
        return 45;
    }

    public boolean isAutomatic()
    {
        return true;
    }

    public void resetTask()
    {
        super.resetTask();
        gallimimus.setHealth(0);
        gallimimus.setDead();
    }
}
