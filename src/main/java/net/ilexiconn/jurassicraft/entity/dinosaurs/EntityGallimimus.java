package net.ilexiconn.jurassicraft.entity.dinosaurs;

import net.ilexiconn.jurassicraft.ai.JurassiCraftEntityAIEatDroppedFood;
import net.ilexiconn.jurassicraft.ai.JurassiCraftEntityAIFollowFood;
import net.ilexiconn.jurassicraft.ai.JurassiCraftEntityAIHerdBehavior;
import net.ilexiconn.jurassicraft.ai.JurassiCraftEntityAIWander;
import net.ilexiconn.jurassicraft.entity.CreatureManager;
import net.ilexiconn.jurassicraft.entity.EntityJurassiCraftLandProtective;
import net.ilexiconn.jurassicraft.entity.IDinosaur;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntityGallimimus extends EntityJurassiCraftLandProtective implements IDinosaur
{
    public EntityGallimimus(World world)
    {
        super(world, CreatureManager.classToCreature(EntityGallimimus.class), 2);
        this.getNavigator().setAvoidsWater(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(2, this.aiSit);
        this.tasks.addTask(4, new JurassiCraftEntityAIFollowFood(this, 1.1D * this.getCreatureSpeed()));
        this.tasks.addTask(4, new JurassiCraftEntityAIEatDroppedFood(this, 16.0D));
        this.tasks.addTask(5, new EntityAIAvoidEntity(this, EntityTyrannosaurus.class, 12.0F, this.getCreatureSpeed(), 1.2D * this.getCreatureSpeed()));
        this.tasks.addTask(6, new JurassiCraftEntityAIWander(this, 0.6D * this.getCreatureSpeed()));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 10.0F));
        this.tasks.addTask(7, new EntityAILookIdle(this));
        this.tasks.addTask(8, new JurassiCraftEntityAIHerdBehavior(this, 96, 1500, 16, 0.6D * this.getCreatureSpeed()));
        this.setCreatureExperiencePoints(1000);
    }

    @Override
    public double getMountedYOffset()
    {
        return (double) this.getYBouningBox() * 0.7D;
    }

    @Override
    public int getTalkInterval()
    {
        return 350;
    }
}