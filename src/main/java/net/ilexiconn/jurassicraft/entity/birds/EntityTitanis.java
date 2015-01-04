package net.ilexiconn.jurassicraft.entity.birds;

import net.ilexiconn.jurassicraft.ai.JurassiCraftEntityAIEatDroppedFood;
import net.ilexiconn.jurassicraft.ai.JurassiCraftEntityAIFollowFood;
import net.ilexiconn.jurassicraft.ai.JurassiCraftEntityAIWander;
import net.ilexiconn.jurassicraft.entity.CreatureManager;
import net.ilexiconn.jurassicraft.entity.EntityJurassiCraftLandAggressive;
import net.ilexiconn.jurassicraft.entity.IDinosaur;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntityTitanis extends EntityJurassiCraftLandAggressive implements IDinosaur
{

    public EntityTitanis(World par1World)
    {
        super(par1World, CreatureManager.classToCreature(EntityTitanis.class));
        this.getNavigator().setAvoidsWater(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new JurassiCraftEntityAIWander(this, 0.7D * this.getCreatureSpeed()));
        this.tasks.addTask(2, this.aiSit);
        this.tasks.addTask(4, new EntityAIMoveTowardsRestriction(this, this.getCreatureSpeed()));
        this.tasks.addTask(5, new JurassiCraftEntityAIFollowFood(this, 1.1D * this.getCreatureSpeed()));
        this.tasks.addTask(5, new JurassiCraftEntityAIEatDroppedFood(this, 16.0D));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(6, new EntityAILookIdle(this));

        this.setCreatureExperiencePoints(2500);
    }

    @Override
    public int getTalkInterval()
    {
        return 350;
    }

    @Override
    public String getLivingSound()
    {
        return this.getCreature().pickLivingSound();
    }

    @Override
    public String getHurtSound()
    {
        return this.getCreature().getHurtSound();
    }

    @Override
    public String getDeathSound()
    {
        return this.getCreature().getDeathSound();
    }
}
