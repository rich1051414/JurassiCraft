package net.ilexiconn.jurassicraft.entity.reptiles;

import net.ilexiconn.jurassicraft.ai.*;
import net.ilexiconn.jurassicraft.entity.CreatureManager;
import net.ilexiconn.jurassicraft.entity.EntityJurassiCraftFlyingCreature;
import net.ilexiconn.jurassicraft.interfaces.IPiscivore;
import net.ilexiconn.jurassicraft.interfaces.IReptile;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityCearadactylus extends EntityJurassiCraftFlyingCreature implements IReptile, IPiscivore
{

    public EntityCearadactylus(World world)
    {
        super(world, CreatureManager.classToCreature(EntityCearadactylus.class), "grassandleaves");
        this.getNavigator().setAvoidsWater(true);
        this.tasks.addTask(0, new JurassiCraftAIFlying(this));
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, new JurassiCraftAIWander(this, 40, this.getCreatureSpeed()));
        this.tasks.addTask(3, new JurassiCraftAISit(this));
        this.tasks.addTask(4, new EntityAIMoveTowardsRestriction(this, this.getCreatureSpeed()));
        this.tasks.addTask(5, new JurassiCraftAIFollowFood(this, 60, 1.2D * this.getCreatureSpeed()));
        this.tasks.addTask(5, new JurassiCraftAIEatDroppedFood(this, 16.0D));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(6, new EntityAILookIdle(this));
        this.setCreatureExperiencePoints(1500);
    }

    @Override
    protected void entityInit()
    {
        super.entityInit();
        this.dataWatcher.addObject(17, new Byte((byte) 0));
    }

    @Override
    public double getMountedYOffset()
    {
        return (double) this.getYBouningBox() * 0.6D;
    }

    @Override
    public int getTalkInterval()
    {
        return 350;
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nbttag)
    {
        super.readEntityFromNBT(nbttag);
        this.dataWatcher.updateObject(17, Byte.valueOf(nbttag.getByte("Flying")));
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nbttag)
    {
        super.writeEntityToNBT(nbttag);
    }

    @Override
    protected void dropFewItems(boolean recentlyBeenHit, int enchantBonus)
    {
        float developmentFraction = this.getGrowthStage() / 120.0F;
        int count = Math.round(1 + (3.0F * developmentFraction) + this.rand.nextInt(1 + (int) (2.5F * developmentFraction)) + this.rand.nextInt(1 + enchantBonus));
        if (!this.isBurning())
        {
            this.dropItemStackWithGenetics(new ItemStack(this.getCreature().getMeat(), count));
        }
        else
        {
            this.dropItem(this.getCreature().getSteak(), count);
        }
        if (this.worldObj.rand.nextFloat() < 0.1F)
        {
            this.dropItemStackWithGenetics(new ItemStack(this.getCreature().getSkull()));
        }
    }
}
