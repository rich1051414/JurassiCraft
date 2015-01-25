package net.ilexiconn.jurassicraft.client.animation;

import net.ilexiconn.jurassicraft.ai.AIAnimation;
import net.ilexiconn.jurassicraft.entity.dinosaurs.EntityTyrannosaurus;

public class AITyrannosaurusEatingGallimimus extends AIAnimation
{
    private EntityTyrannosaurus tyrannosaurus;

    public AITyrannosaurusEatingGallimimus(EntityTyrannosaurus tyrannosaurus)
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
}
