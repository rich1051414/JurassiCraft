package net.ilexiconn.jurassicraft.entity;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;

public class EntityJurassiCraftGroupAggressive extends EntityJurassiCraftAggressive {

	public EntityJurassiCraftGroupAggressive(World world, Creature creature) {
		super(world, creature);
    }
	
	@Override
    protected void setCreatureAngry(EntityJurassiCraftAggressive creature, Entity entity) {
		if (entity instanceof EntityLivingBase)
		{
			EntityLivingBase attacker = (EntityLivingBase) entity;
			List list = creature.worldObj.getEntitiesWithinAABBExcludingEntity(creature, creature.boundingBox.expand(16.0D, 8.0D, 16.0D));
	        for (int i = 0; i < list.size(); ++i)
	        {
	            Entity entityNeighbor = (Entity) list.get(i);
	            if (entityNeighbor.getClass() == this.getClass())
	            {
	            	EntityJurassiCraftAggressive entityNeighborAngry = (EntityJurassiCraftAggressive) entityNeighbor;
	                if (entityNeighborAngry.checkTargetBeforeAttacking(attacker))
	                {
	                	entityNeighborAngry.becomeAngry(attacker, 0.0F);
	                }
	            }
	        }
		}
        super.setCreatureAngry(creature, entity);
	}
}
