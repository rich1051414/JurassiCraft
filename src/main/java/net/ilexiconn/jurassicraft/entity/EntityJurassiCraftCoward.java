package net.ilexiconn.jurassicraft.entity;

import net.minecraft.entity.Entity;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class EntityJurassiCraftCoward extends EntityJurassiCraftRidable
{

    public EntityJurassiCraftCoward(World world, Creature creature)
    {
        super(world, creature);
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
            List<Entity> list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(18.0D, 8.0D, 18.0D));
            ArrayList<EntityJurassiCraftCoward> listOfCowards = new ArrayList<EntityJurassiCraftCoward>();
            listOfCowards.add(this);
            for (int i = 0; i < list.size(); ++i)
            {
                Entity entityNeighbor = (Entity) list.get(i);
                if (entityNeighbor.getClass() == this.getClass() && entityNeighbor != this)
                {
                    listOfCowards.add((EntityJurassiCraftCoward) entityNeighbor);
                }
            }
            if (!listOfCowards.isEmpty())
            {
                for (EntityJurassiCraftCoward creatures : listOfCowards)
                {
                    creatures.startFleeing();
                }
            }
            return super.attackEntityFrom(damageSource, damage);
        }
    }
}
