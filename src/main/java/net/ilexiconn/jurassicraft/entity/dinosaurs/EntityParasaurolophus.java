package net.ilexiconn.jurassicraft.entity.dinosaurs;

import net.ilexiconn.jurassicraft.ai.JurassiCraftEntityAIEatDroppedFood;
import net.ilexiconn.jurassicraft.ai.JurassiCraftEntityAIFollowFood;
import net.ilexiconn.jurassicraft.ai.JurassiCraftEntityAIHerdBehavior;
import net.ilexiconn.jurassicraft.ai.JurassiCraftEntityAIWander;
import net.ilexiconn.jurassicraft.client.animation.AIParasaurolophusTrumpet;
import net.ilexiconn.jurassicraft.entity.CreatureManager;
import net.ilexiconn.jurassicraft.entity.EntityJurassiCraftLandProtective;
import net.ilexiconn.jurassicraft.entity.IDinosaur;
import net.ilexiconn.jurassicraft.utility.ControlledParam;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import thehippomaster.AnimationAPI.AnimationAPI;

public class EntityParasaurolophus extends EntityJurassiCraftLandProtective implements IDinosaur
{
    public ControlledParam walkLean = new ControlledParam(0, 0, (float) Math.PI / 2, 0);

    public EntityParasaurolophus(World world)
    {
        super(world, CreatureManager.classToCreature(EntityParasaurolophus.class), 1);
        this.getNavigator().setAvoidsWater(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(2, new AIParasaurolophusTrumpet(this));
        this.tasks.addTask(3, this.aiSit);
        this.tasks.addTask(4, new JurassiCraftEntityAIFollowFood(this, 1.1D * this.getCreatureSpeed()));
        this.tasks.addTask(4, new JurassiCraftEntityAIEatDroppedFood(this, 16.0D));
        this.tasks.addTask(5, new JurassiCraftEntityAIWander(this, 0.7D * this.getCreatureSpeed()));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(6, new EntityAILookIdle(this));
        this.tasks.addTask(7, new JurassiCraftEntityAIHerdBehavior(this, 96, 2000, 20, 0.7D * this.getCreatureSpeed()));
        this.setCreatureExperiencePoints(1000);
    }

    @Override
    public double getMountedYOffset()
    {
        return (double) this.getYBouningBox() * 1.1D;
    }

    @Override
    public int getTalkInterval()
    {
        return 350;
    }

    @Override
    public String getLivingSound()
    {
        int I = this.rand.nextInt(3);

        if (I <= 1)
        {
            return this.getCreature().getLivingSound(I);
        }
        else
        {
            AnimationAPI.sendAnimationPacket(this, 1);
            return null;
        }
    }

    public void onUpdate()
    {
        super.onUpdate();
        if (this.moveForward != 0) walkLean.change = 0.1F;
        if (this.moveForward == 0) walkLean.change = -0.1F;
        walkLean.update();
    }
}