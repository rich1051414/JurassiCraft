package net.ilexiconn.jurassicraft.entity.reptiles;

import net.ilexiconn.jurassicraft.ai.*;
import net.ilexiconn.jurassicraft.client.model.modelbase.ChainBuffer;
import net.ilexiconn.jurassicraft.entity.Creature;
import net.ilexiconn.jurassicraft.entity.EntitySwimmingBase;
import net.ilexiconn.jurassicraft.interfaces.ICarnivore;
import net.ilexiconn.jurassicraft.interfaces.IPiscivore;
import net.ilexiconn.jurassicraft.interfaces.IReptile;
import net.ilexiconn.jurassicraft.item.ItemMeat;
import net.ilexiconn.jurassicraft.item.ItemSteak;
import net.ilexiconn.jurassicraft.item.drops.ItemSkin;
import net.ilexiconn.jurassicraft.item.drops.ItemSkull;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityTylosaurus extends EntitySwimmingBase implements IReptile, ICarnivore, IPiscivore
{
    public ChainBuffer tailBuffer = new ChainBuffer(12);

    public EntityTylosaurus(World world)
    {
        super(world);

        this.swimSpeed = 2.2F;
        huntingInterval = 600;
        this.setHungry(huntingInterval);

        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, 1.0F * this.getCreatureSpeed(), false));
        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, this.getCreatureSpeed()));
        this.tasks.addTask(6, new JurassiCraftAIFollowFood(this, 100, 1.2D * this.getCreatureSpeed()));
        this.tasks.addTask(6, new JurassiCraftAIEatDroppedFood(this, 16.0D));
        this.tasks.addTask(6, new JurassiCraftAIEating(this, 20));
        this.targetTasks.addTask(1, new JurassiCraftAIOwnerIsHurtByTarget(this));
        this.targetTasks.addTask(2, new JurassiCraftAIOwnerHurtsTarget(this));
        this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntitySquid.class, 100, 0.15F, 1.0F));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntityPlayer.class, 100, 0.25F, 1.0F));
        this.setCreatureExperiencePoints(5000);
    }

    @Override
    public void onUpdate()
    {
        super.onUpdate();
        this.tailBuffer.calculateChainSwingBuffer(120.0F, 5, 8.0F, this);
    }

    public EntityLivingBase getTargetPriority(EntityLivingBase target, EntityLivingBase entity)
    {
        if (target != null)
        {
            if (target instanceof EntityPlayer)
                return target;
            else if (target instanceof EntityTylosaurus) //Won't go for other Tylosaurus unless nothing else around
                return entity;
            else
                return target;
        }
        else
            return entity;
    }

    @Override
    protected void dropFewItems(boolean recentlyBeenHit, int enchantBonus)
    {
        float developmentFraction = this.getGrowthStage() / 120.0F;
        int count = Math.round(1 + (5.0F * developmentFraction) + this.rand.nextInt(1 + (int) (5.5F * developmentFraction)) + this.rand.nextInt(1 + enchantBonus));

        Creature creature = this.getCreature();

        if (!this.isBurning())
        {
            ItemMeat meat = creature.getMeat();

            if (meat != null)
            {
                this.dropItemStackWithGenetics(new ItemStack(meat, count));
            }
            else
            {
                System.err.println("Meat was null for Tylosaurus!");
            }
        }
        else
        {
            ItemSteak steak = creature.getSteak();

            if (steak != null)
            {
                this.dropItem(steak, count);
            }
            else
            {
                System.err.println("Steak was null for Tylosaurus!");
            }
        }

        if (this.worldObj.rand.nextFloat() < 0.1F)
        {
            ItemSkull skull = creature.getSkull();

            if (skull != null)
            {
                this.dropItemStackWithGenetics(new ItemStack(skull));
            }
            else
            {
                System.err.println("Skull was null for Tylosaurus!");
            }
        }

        if (this.isMale() && this.worldObj.rand.nextFloat() < 0.25F)
        {
            ItemSkin skin = creature.getSkin();

            if (skin != null)
            {
                this.dropItemStackWithGenetics(new ItemStack(skin));
            }
            else
            {
                System.err.println("Skin was null for Tylosaurus!");
            }
        }
    }
}
