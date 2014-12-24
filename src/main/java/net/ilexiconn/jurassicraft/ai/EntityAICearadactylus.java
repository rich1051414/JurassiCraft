package net.ilexiconn.jurassicraft.ai;

import net.minecraft.entity.ai.EntityAIBase;
import net.ilexiconn.jurassicraft.entity.reptiles.EntityCearadactylus;

public class EntityAICearadactylus extends EntityAIBase {

    private EntityCearadactylus theCearadactylus;
    private boolean isFlying;

    public EntityAICearadactylus(EntityCearadactylus dactylus) {
        this.theCearadactylus = dactylus;
        this.setMutexBits(5);
    }

    public boolean shouldExecute() {
        return this.isFlying;
    }

    public void startExecuting() {
        this.theCearadactylus.getNavigator().clearPathEntity();
        this.theCearadactylus.setFlying(true);
    }

    public void resetTask() {
        this.theCearadactylus.setFlying(false);
    }

    public void setFlying(boolean flying) {
        this.isFlying = flying;
    }

}