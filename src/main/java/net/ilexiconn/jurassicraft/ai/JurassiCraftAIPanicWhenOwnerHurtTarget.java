package net.ilexiconn.jurassicraft.ai;

import net.ilexiconn.jurassicraft.entity.EntityJurassiCraftLandCoward;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAITarget;

public class JurassiCraftAIPanicWhenOwnerHurtTarget extends EntityAITarget
{
    EntityJurassiCraftLandCoward cowardTameable;
    EntityLivingBase attacker;

    public JurassiCraftAIPanicWhenOwnerHurtTarget(EntityJurassiCraftLandCoward entityTameable)
    {
        super(entityTameable, false);
        this.cowardTameable = entityTameable;
        this.setMutexBits(1);
    }

    @Override
    public boolean shouldExecute()
    {
        if (!this.cowardTameable.isTamed())
        {
            return false;
        }
        else
        {
            EntityLivingBase owner = this.cowardTameable.getOwner();
            if (owner == null)
            {
                return false;
            }
            else
            {
                this.attacker = owner.getLastAttacker();
                return attacker != null && owner.getDistanceToEntity(cowardTameable) < 16.0F;
            }
        }
    }

    @Override
    public void startExecuting()
    {
    	if (this.cowardTameable.isSitting())
    	{
    		this.cowardTameable.getAiSit().setSitting(false);
    		this.cowardTameable.setSitting(false);
    	}
        if (!this.cowardTameable.isPanicking())
            this.cowardTameable.setFleeingTick(75 + this.cowardTameable.worldObj.rand.nextInt(100));
        super.startExecuting();
    }
}