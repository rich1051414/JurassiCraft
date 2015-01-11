package net.ilexiconn.jurassicraft.entity.dinosaurs;

import net.ilexiconn.jurassicraft.ModItems;
import net.ilexiconn.jurassicraft.ai.JurassiCraftEntityAIAvoidEntityIfNotTamed;
import net.ilexiconn.jurassicraft.ai.JurassiCraftEntityAIEatDroppedFood;
import net.ilexiconn.jurassicraft.ai.JurassiCraftEntityAIFollowFoodCoward;
import net.ilexiconn.jurassicraft.ai.JurassiCraftEntityAIWander;
import net.ilexiconn.jurassicraft.client.animation.AIHypsilophodonScratchHead;
import net.ilexiconn.jurassicraft.entity.CreatureManager;
import net.ilexiconn.jurassicraft.entity.EntityJurassiCraftLandCoward;
import net.ilexiconn.jurassicraft.interfaces.IDinosaur;
import net.ilexiconn.jurassicraft.interfaces.IHerbivore;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityHypsilophodon extends EntityJurassiCraftLandCoward implements IDinosaur, IHerbivore
{
    public EntityHypsilophodon(World world)
    {
        super(world, CreatureManager.classToCreature(EntityHypsilophodon.class));
        this.getNavigator().setAvoidsWater(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(2, this.aiSit);
        this.tasks.addTask(2, new AIHypsilophodonScratchHead(this));
        this.tasks.addTask(3, new JurassiCraftEntityAIAvoidEntityIfNotTamed(this, EntityPlayer.class, 10.0F, 0.9D * this.getCreatureSpeed(), 1.2D * this.getCreatureSpeed()));
        this.tasks.addTask(3, new EntityAIAvoidEntity(this, EntityHerrerasaur.class, 16.0F, 1.0D * this.getCreatureSpeed(), 1.2D * this.getCreatureSpeed()));
        this.tasks.addTask(4, new JurassiCraftEntityAIFollowFoodCoward(this, 1.1D * this.getCreatureSpeed()));
        this.tasks.addTask(4, new JurassiCraftEntityAIEatDroppedFood(this, 16.0D));
        this.tasks.addTask(5, new JurassiCraftEntityAIWander(this, 0.8D * this.getCreatureSpeed()));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(6, new EntityAILookIdle(this));

        this.setCreatureExperiencePoints(800);
    }

    @Override
    public int getTalkInterval()
    {
        return 350;
    }

    @Override
    protected void dropFewItems(boolean recentlyBeenHit, int enchantBonus)
    {
    	float developmentFraction = this.getGrowthStage() / 120.0F;
        int count = Math.round(1 + (1.5F * developmentFraction) + this.rand.nextInt(1 + (int) (2.0F * developmentFraction)) + this.rand.nextInt(1 + enchantBonus));
    	if (!this.isBurning())
        {
            this.dropItemStackWithGenetics(new ItemStack(this.getCreature().getMeat(), count));
        }
        else
        {
            this.dropItem(this.getCreature().getSteak(), count);
        }
    	if (this.isMale() && this.worldObj.rand.nextFloat() < 0.25F) {
            this.dropItem(this.getCreature().getSkin(), 1);
    	}
    }
}
