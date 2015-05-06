package net.ilexiconn.jurassicraft.entity.cephalopods;

import net.ilexiconn.jurassicraft.entity.CreatureManager;
import net.ilexiconn.jurassicraft.entity.NewEntitySwimming;
import net.minecraft.world.World;

public class EntityAmmonite extends NewEntitySwimming
{
    public EntityAmmonite(World world)
    {
        super(world);
        this.swimRadius = 16.0F;
        this.swimRadiusHeight = 10.0F;
        this.swimSpeed = 0.6F;
        this.jumpOnLand = false;
        this.attackInterval = 1;
        this.isAgressive = true;
        this.setCreatureExperiencePoints(5000);
    }
}
