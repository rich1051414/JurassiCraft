package net.ilexiconn.jurassicraft.ai;

import net.ilexiconn.jurassicraft.entity.EntityJurassiCraftSmart;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;

public class JurassiCraftAISit extends EntityAIBase
{

    private EntityJurassiCraftSmart creature;

    public JurassiCraftAISit(EntityJurassiCraftSmart creature)
    {
        this.creature = creature;
        this.setMutexBits(5);
    }

    @Override
    public boolean shouldExecute()
    {
        if (this.creature.isInWater() || !this.creature.onGround || !this.creature.isTamed() || this.creature.isTakingOff() || this.creature.isFlying() || this.creature.riddenByEntity != null || this.creature.isEating() || this.creature.isDrinking() || this.creature.isPlaying() || this.creature.isDefending() || this.creature.isBreeding())
            return false;

        EntityLivingBase entitylivingbase = this.creature.getOwner();
        return !this.creature.isSitting() ? false : (entitylivingbase == null ? false : (this.creature.getDistanceSqToEntity(entitylivingbase) < 144.0D && entitylivingbase.getAITarget() == null));
    }

    @Override
    public void startExecuting()
    {
        this.creature.getNavigator().clearPathEntity();
        if (this.creature.isTakingOff()) this.creature.setTakingOff(false);

        if (this.creature.isFlying()) this.creature.setFlying(false);

        if (this.creature.isEating()) this.creature.setEating(false);

        if (this.creature.isDrinking()) this.creature.setDrinking(false);

        if (this.creature.isFleeing()) this.creature.setFleeing(false);

        if (this.creature.isDefending()) this.creature.setDefending(false);

        if (this.creature.isAttacking()) this.creature.setAttacking(false);

        if (this.creature.isBreeding()) this.creature.setBreeding(false);

        this.creature.setSitting(true, (EntityPlayer) this.creature.getOwner());
    }

    @Override
    public boolean continueExecuting()
    {
        return this.creature.isSitting() && !this.creature.hasBeenHurt();
    }

    @Override
    public void resetTask()
    {
        this.creature.setSitting(false, (EntityPlayer) this.creature.getOwner());
    }
}
