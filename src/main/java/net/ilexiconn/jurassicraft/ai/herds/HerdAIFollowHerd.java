package net.ilexiconn.jurassicraft.ai.herds;

import net.ilexiconn.jurassicraft.entity.EntityJurassiCraftCreature;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.util.Vec3;

public class HerdAIFollowHerd extends EntityAIHerd
{

    private double speed;

    public HerdAIFollowHerd(EntityJurassiCraftCreature creature, double speed)
    {
        super(creature);
        this.speed = speed;
    }

    public void startExecuting()
    {
        super.startExecuting();
    }

    public void updateTask()
    {
        if (getHerd() != null)
        {
            Vec3 center = getHerd().computeCenter();
            PathEntity path = getCreature().getNavigator().getPathToXYZ(center.xCoord, center.yCoord, center.zCoord);
            if (path != null)
            {
                getCreature().getNavigator().setPath(path, speed);
            }
        }
    }

    public boolean continueExecuting()
    {
        return getHerd() != null && getHerd().getDistanceFrom(getCreature()) >= 10 && getCreature().getAttackTarget() == null;
    }

    @Override
    public boolean shouldExecute()
    {
        boolean herdIsFar = true;
        if (getHerd() != null)
        {
            herdIsFar = getHerd().getDistanceFrom(getCreature()) > 15;
        }
        return Math.random() < 0.25 && herdIsFar && getCreature().getAttackTarget() == null;
    }

}
