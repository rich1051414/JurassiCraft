package net.ilexiconn.jurassicraft.ai.herds;

import net.ilexiconn.jurassicraft.entity.EntityJurassiCraftCreature;
import net.ilexiconn.jurassicraft.entity.dinosaurs.EntityVelociraptor;
import net.minecraft.entity.EntityLivingBase;

public class VelociraptorHerd extends CreatureHerd
{

    private EntityLivingBase target;

    public VelociraptorHerd()
    {
        super(true);
    }

    public boolean isAcceptable(EntityJurassiCraftCreature creature)
    {
        return creature instanceof EntityVelociraptor && super.isAcceptable(creature);
    }

    public void attack(EntityLivingBase target)
    {
        this.target = target;
    }

    public boolean isSneakingUp()
    {
        if (target != null && target.isDead)
        {
            target = null;
            return false;
        }
        return target != null;
    }

    public EntityLivingBase getCurrentTarget()
    {
        return target;
    }

}
