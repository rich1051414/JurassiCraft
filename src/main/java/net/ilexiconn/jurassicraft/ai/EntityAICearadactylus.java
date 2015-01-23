package net.ilexiconn.jurassicraft.ai;

import net.ilexiconn.jurassicraft.entity.reptiles.EntityCearadactylusOld;
import net.minecraft.entity.ai.EntityAIBase;

public class EntityAICearadactylus extends EntityAIBase
{

    private EntityCearadactylusOld theCearadactylus;
    private boolean isFlying;

    public EntityAICearadactylus(EntityCearadactylusOld dactylus)
    {
        this.theCearadactylus = dactylus;
        this.setMutexBits(5);
    }

    public boolean shouldExecute()
    {
        return this.isFlying;
    }

    public void startExecuting()
    {
        this.theCearadactylus.getNavigator().clearPathEntity();
        this.theCearadactylus.setFlying(true);
    }

    public void resetTask()
    {
        this.theCearadactylus.setFlying(false);
    }

    public void setFlying(boolean flying)
    {
        this.isFlying = flying;
    }

}