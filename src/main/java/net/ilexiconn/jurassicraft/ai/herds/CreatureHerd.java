package net.ilexiconn.jurassicraft.ai.herds;

import com.google.common.collect.Lists;

import net.ilexiconn.jurassicraft.entity.EntityJurassiCraftCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityOwnable;
import net.minecraft.util.Vec3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class CreatureHerd implements Collection<EntityJurassiCraftCreature>
{

    private ArrayList<EntityJurassiCraftCreature> creatures;
    private Class<? extends EntityJurassiCraftCreature> herdType;
    private boolean groupAttack;

    private static List<CreatureHerd> herds = Lists.newArrayList();

    public static List<CreatureHerd> getHerds()
    {
        return herds;
    }

    public static void registerHerd(CreatureHerd herd)
    {
        herds.add(herd);
    }

    public static void removeHerd(CreatureHerd herd)
    {
        herds.remove(herd);
    }

    public CreatureHerd(boolean attack)
    {
        creatures = Lists.newArrayList();
        this.groupAttack = attack;
    }

    /**
     * Adds the entity only if the herd "accepts" it<br/>
     * Acceptance is based on the creatures' types (T-rex herds will only accept T-rexs' friend dinosaurs)
     *
     * @param e The entity to add to the herd
     * @return <code>true</code> if the creature was accepted and added to this herd. <code>false</code> is returned otherwise
     */
    @Override
    public boolean add(EntityJurassiCraftCreature e)
    {
        if (isAcceptable(e))
        {
            creatures.add(e);
            return true;
        }
        return false;
    }

    public boolean isAcceptable(EntityJurassiCraftCreature e)
    {
        if (herdType == null)
        {
            herdType = e.getClass();
            return true;
        }
        if (herdType == e.getClass()) // FIXME: We will need something else than per-class herds
        {
            return creatures.size() < 7 && !contains(e);
        }
        return false;
    }

    /**
     * Adds a collection of entities into this herd if possible
     *
     * @param c The collection of creatures to add to this herd
     * @return <code>true</code> if all creatures were added to this herd
     */
    @Override
    public boolean addAll(Collection<? extends EntityJurassiCraftCreature> c)
    {
        boolean flag = true;
        for (EntityJurassiCraftCreature creature : c)
        {
            flag = flag && add(creature);
        }
        return flag;
    }

    @Override
    public void clear()
    {
        creatures.clear();
    }

    @Override
    public boolean contains(Object o)
    {
        return creatures.contains(o);
    }

    @Override
    public boolean containsAll(Collection<?> c)
    {
        return creatures.containsAll(c);
    }

    @Override
    public boolean isEmpty()
    {
        return creatures.isEmpty();
    }

    @Override
    public Iterator<EntityJurassiCraftCreature> iterator()
    {
        return creatures.iterator();
    }

    @Override
    public boolean remove(Object o)
    {
        // TODO Notify herd maybe?
        if (creatures.size() - 1 == 0)
        {
            herds.remove(this);
        }
        return creatures.remove(o);
    }

    @Override
    public boolean removeAll(Collection<?> c)
    {
        // TODO Notify herd ?
        if (creatures.size() - c.size() <= 0)
        {
            herds.remove(this);
        }
        return creatures.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c)
    {
        // TODO Notify herd
        return creatures.retainAll(c);
    }

    @Override
    public int size()
    {
        return creatures.size();
    }

    @Override
    public Object[] toArray()
    {
        return creatures.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a)
    {
        return creatures.toArray(a);
    }

    public Vec3 computeCenter()
    {
        double x = 0f;
        double y = 0f;
        double z = 0f;
        for (EntityJurassiCraftCreature creature : creatures)
        {
            x += creature.posX;
            y += creature.posY;
            z += creature.posZ;
        }

        x /= creatures.size();
        y /= creatures.size();
        z /= creatures.size();
        return Vec3.createVectorHelper(x, y, z);
    }

    public Vec3 getPosition(EntityJurassiCraftCreature creature, float p_70666_1_)
    {
        if (p_70666_1_ == 1.0F)
        {
            return Vec3.createVectorHelper(creature.posX, creature.posY, creature.posZ);
        }
        else
        {
            double d0 = creature.prevPosX + (creature.posX - creature.prevPosX) * (double)p_70666_1_;
            double d1 = creature.prevPosY + (creature.posY - creature.prevPosY) * (double)p_70666_1_;
            double d2 = creature.prevPosZ + (creature.posZ - creature.prevPosZ) * (double)p_70666_1_;
            return Vec3.createVectorHelper(d0, d1, d2);
        }
    }

    public double getDistanceFrom(EntityJurassiCraftCreature creature)
    {
        Vec3 center = computeCenter();
        return getPosition(creature, 1f).distanceTo(center);
    }

    public boolean groupAttack()
    {
        return groupAttack;
    }

    public CreatureHerd groupAttack(boolean attack)
    {
        groupAttack = attack;
        return this;
    }

    public void attack(EntityLivingBase target)
    {
        if (!groupAttack) return;
        for (EntityJurassiCraftCreature creature : creatures) // Check if an owner is target
        {
            if(creature instanceof IEntityOwnable)
            {
                IEntityOwnable ownable = (IEntityOwnable)creature;
                if(ownable.getOwner() == target)
                {
                    return; // We're attacking the owner, abord!
                }
            }
        }
        for (EntityJurassiCraftCreature creature : creatures)
        {
            creature.setAttackTarget(target);
        }
    }

    public int indexOf(EntityJurassiCraftCreature creature)
    {
        return creatures.indexOf(creature);
    }

}
