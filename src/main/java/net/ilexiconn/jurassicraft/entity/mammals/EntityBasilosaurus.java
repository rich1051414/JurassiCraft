package net.ilexiconn.jurassicraft.entity.mammals;

import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import net.ilexiconn.jurassicraft.Util;
import net.ilexiconn.jurassicraft.entity.NewEntitySwimming;

public class EntityBasilosaurus extends NewEntitySwimming {

    public EntityBasilosaurus(World world)
    {
        super(world, (byte) Util.classToId(EntityBasilosaurus.class));
        this.swimRadius = 16.0F;
        this.swimRadiusHeight = 10.0F;
        this.swimSpeed = (float) this.getCreatureSpeed();
        this.jumpOnLand = false;
        this.attackInterval = 1;
        this.isAgressive = true;
        this.setCreatureExperiencePoints(5000);
    }

    @Override
    protected Entity findEntityToAttack()
    {
        AxisAlignedBB area = this.boundingBox.expand(16.0D, 16.0D, 16.0D);

        EntityPlayer player = (EntityPlayer) super.findEntityToAttack();
        if (player != null)
            return player;

        return this.worldObj.findNearestEntityWithinAABB(EntityAnimal.class, area, this);
    }
}
