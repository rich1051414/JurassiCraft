package net.ilexiconn.jurassicraft.entity.dinosaurs;

import net.ilexiconn.jurassicraft.ai.*;
import net.ilexiconn.jurassicraft.client.model.modelbase.ChainBuffer;
import net.ilexiconn.jurassicraft.entity.CreatureManager;
import net.ilexiconn.jurassicraft.entity.EntityJurassiCraftProtective;
import net.ilexiconn.jurassicraft.interfaces.IDinosaur;
import net.ilexiconn.jurassicraft.interfaces.IHerbivore;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityBrachiosaurus extends EntityJurassiCraftProtective implements IDinosaur, IHerbivore
{
    public ChainBuffer tailBuffer = new ChainBuffer(5);

    public EntityBrachiosaurus(World world)
    {
        super(world, CreatureManager.classToCreature(EntityBrachiosaurus.class));
        this.getNavigator().setAvoidsWater(true);

        this.tasks.addTask(10, new JurassiCraftAIEatLeaves(this, getCreatureSpeed()));

        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new JurassiCraftAIAngry(this, 200));
        this.tasks.addTask(1, new JurassiCraftAIFlee(this, 60, 1.1D * this.getCreatureSpeed()));
        this.tasks.addTask(2, new JurassiCraftAISit(this));
        this.tasks.addTask(3, new EntityAIAttackOnCollide(this, 1.1F * this.getCreatureSpeed(), false));
        this.tasks.addTask(4, new JurassiCraftAIFollowFood(this, 50, 1.1D * this.getCreatureSpeed()));
        this.tasks.addTask(4, new JurassiCraftAIEatDroppedFood(this, 16.0D));
        this.tasks.addTask(4, new JurassiCraftAIEating(this, 20));
        this.tasks.addTask(5, new JurassiCraftAIWander(this, 45, 0.7D * this.getCreatureSpeed()));
        this.tasks.addTask(5, new EntityAIAvoidEntity(this, EntityTyrannosaurus.class, 12.0F, this.getCreatureSpeed(), 1.2D * this.getCreatureSpeed()));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 10.0F));
        this.tasks.addTask(6, new EntityAILookIdle(this));
        this.tasks.addTask(7, new JurassiCraftAIHerdBehavior(this, 128, 2500, 24, this.getCreatureSpeed()));
        this.targetTasks.addTask(1, new JurassiCraftAIOwnerIsHurtByTarget(this));
        this.targetTasks.addTask(2, new JurassiCraftAIOwnerHurtsTarget(this));
        this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
        this.setCreatureExperiencePoints(4000);
    }

    @Override
    public void updateRiderPosition()
    {
        if (this.riddenByEntity != null)
        {
            double halfLength = 0.55F * this.getCreatureLength();
            double xRotation = (double) MathHelper.sin(3.14159265359F + 0.01745329251F * this.renderYawOffset);
            double zRotation = (double) MathHelper.cos(0.01745329251F * this.renderYawOffset);

            double extraX = (1.0D + 0.075D * Math.sin(0.04D * (double) this.getTotalTicksLived() + 1.5D)) * halfLength * xRotation;
            double extraZ = (1.0D + 0.075D * Math.sin(0.04D * (double) this.getTotalTicksLived() + 1.5D)) * halfLength * zRotation;
            double extraY = 1.03D * this.getCreatureHeight() + 0.5D * Math.cos(0.05D * (double) this.getTotalTicksLived() - 0.5D);
            this.riddenByEntity.setPosition(this.posX + extraX, this.posY + extraY, this.posZ + extraZ);
        }
    }

    @Override
    public int getNumberOfAllies()
    {
        return 1;
    }

    @Override
    public int getTalkInterval()
    {
        return 350;
    }

    @Override
    public void onUpdate()
    {
        super.onUpdate();
        this.tailBuffer.calculateChainSwingBuffer(30.0F, 4, 1.5F, this);
    }

    @Override
    protected void dropFewItems(boolean recentlyBeenHit, int enchantBonus)
    {
        float developmentFraction = this.getGrowthStage() / 120.0F;
        int count = Math.round(1 + (5.0F * developmentFraction) + this.rand.nextInt(1 + (int) (6.5F * developmentFraction)) + this.rand.nextInt(1 + enchantBonus));
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
        if (this.isMale() && this.worldObj.rand.nextFloat() < 0.25F)
        {
            this.dropItemStackWithGenetics(new ItemStack(this.getCreature().getSkin()));
        }
    }
}
