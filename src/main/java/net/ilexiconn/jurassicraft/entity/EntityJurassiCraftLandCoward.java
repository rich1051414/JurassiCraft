package net.ilexiconn.jurassicraft.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.ilexiconn.jurassicraft.ai.JurassiCraftEntityAIOwnerHurtTarget;
import net.ilexiconn.jurassicraft.ai.JurassiCraftEntityAIPanicWhenOwnerHurtByTarget;
import net.ilexiconn.jurassicraft.ai.JurassiCraftLandEntityAIPanicCoward;

import java.util.ArrayList;
import java.util.List;

public class EntityJurassiCraftLandCoward extends EntityJurassiCraftRidable
{
    private short angerLevel;
    private int numberOfAllies;

    public EntityJurassiCraftLandCoward(World world, Creature creature)
    {
        super(world, creature);
        this.tasks.addTask(1, new JurassiCraftLandEntityAIPanicCoward(this, 1.25D * this.getCreatureSpeed()));
        this.targetTasks.addTask(1, new JurassiCraftEntityAIPanicWhenOwnerHurtByTarget(this));
        this.targetTasks.addTask(2, new JurassiCraftEntityAIOwnerHurtTarget(this));
        this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
    }
    
    /** Sets the fleeing tick value of the creature. When it is positive, it is reduced each tick until zero (done in the JurassiCraftLandEntityAIPanicIfNotAnger AI class). */
    public void setFleeingTick(int value)
    {
        this.fleeingTick = value;
    }

    @Override
    protected boolean canDespawn()
    {
        return false;
    }
    
    /** Returns the fleeing ticks of the creature. Higher than zero means that the creature was attacked. */
    public int getFleeingTick()
    {
        return fleeingTick;
    }

    /** Increases the fleeing ticks by 75 ticks plus a random number of ticks between 0 and 70. */
    private void becomePanic(EntityJurassiCraftLandCoward fleeingCreature)
    {
    	if (fleeingCreature.isSitting()) {
            this.aiSit.setSitting(false);
            this.setSitting(false);
    	}
        fleeingCreature.setFleeingTick(75 + rand.nextInt(100));
        fleeingCreature.setAttackTarget((EntityLivingBase) null);
    }

    /** Returns true if the creature is fleeing, fleeing ticks higher than zero. */
    public boolean isPanicking()
    {
        return getFleeingTick() > 0;
    }

	@Override
	public boolean attackEntityFrom(DamageSource damageSource, float damage) 
	{
		if (this.isEntityInvulnerable()) 
		{
			return false;
		} 
		else 
		{
			Entity attacker = damageSource.getEntity();
			int count = 0;
			List<Entity> list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(18.0D, 8.0D, 18.0D));
			ArrayList<EntityJurassiCraftLandCoward> listOfCowards = new ArrayList<EntityJurassiCraftLandCoward>();
			listOfCowards.add(this);
			for (int i = 0; i < list.size(); ++i) 
			{
				Entity entityNeighbor = (Entity) list.get(i);
				if (entityNeighbor.getClass() == this.getClass()) 
				{
					EntityJurassiCraftLandCoward validEntityNeighbor = (EntityJurassiCraftLandCoward) entityNeighbor;
					listOfCowards.add(validEntityNeighbor);
				}
			}
			if (!listOfCowards.isEmpty()) 
			{
				for (int i = 0; i < listOfCowards.size(); ++i) 
				{
					becomePanic(listOfCowards.get(i));
				}
			}
			return super.attackEntityFrom(damageSource, damage);
		}
	}
	
    @Override
    public void writeEntityToNBT(NBTTagCompound compound)
    {
        super.writeEntityToNBT(compound);
        compound.setShort("FleeingTick", (short) this.getFleeingTick());
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound compound)
    {
        super.readEntityFromNBT(compound);
        this.setFleeingTick(compound.getShort("FleeingTick"));
    }
}
