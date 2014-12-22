package net.ilexiconn.jurassicraft.entity.cephalopods;

import net.minecraft.world.World;
import net.ilexiconn.jurassicraft.Util;
import net.ilexiconn.jurassicraft.entity.NewEntitySwimming;

public class EntityAmmonite extends NewEntitySwimming
{
    Class class1 = this.getClass();

    public EntityAmmonite(World world)
    {
        super(world, (byte) Util.classToId(EntityAmmonite.class));
        this.swimRadius = 16.0F;
        this.swimRadiusHeight = 10.0F;
        this.swimSpeed = 0.6F;
        this.jumpOnLand = false;
        this.attackInterval = 1;
        this.isAgressive = true;
        this.setCreatureExperiencePoints(5000);
    }
}
