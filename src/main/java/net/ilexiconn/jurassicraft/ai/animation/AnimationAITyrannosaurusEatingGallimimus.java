package net.ilexiconn.jurassicraft.ai.animation;

import net.ilexiconn.jurassicraft.entity.dinosaurs.EntityTyrannosaurus;
import net.ilexiconn.jurassicraft.enums.JurassiCraftAnimationIDs;

public class AnimationAITyrannosaurusEatingGallimimus extends AIAnimation
{
    private EntityTyrannosaurus tyrannosaurus;
    
    public AnimationAITyrannosaurusEatingGallimimus(EntityTyrannosaurus tyrannosaurus)
    {
        super(tyrannosaurus);
        this.tyrannosaurus = tyrannosaurus;
    }
    
    public int getAnimationId()
    {
        return JurassiCraftAnimationIDs.EATING.animID();
    }
    
    public int getDuration()
    {
        return 50;
    }
    
    public boolean isAutomatic()
    {
        return true;
    }
    
    public void startExecuting()
    {
        super.startExecuting();
        this.tyrannosaurus.setDrinking(false);
    }
    
    public void updateTask()
    {
        
    }
}
