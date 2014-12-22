package to.uk.ilexiconn.jurassicraft.entity.reptiles;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import to.uk.ilexiconn.jurassicraft.ModItems;
import to.uk.ilexiconn.jurassicraft.Util;
import to.uk.ilexiconn.jurassicraft.ai.EntityAICearadactylus;
import to.uk.ilexiconn.jurassicraft.ai.JurassiCraftEntityAIEatDroppedFood;
import to.uk.ilexiconn.jurassicraft.ai.JurassiCraftEntityAIFollowFood;
import to.uk.ilexiconn.jurassicraft.ai.JurassiCraftEntityAIWander;
import to.uk.ilexiconn.jurassicraft.entity.EntityJurassiCraftLandAggressive;
import to.uk.ilexiconn.jurassicraft.entity.IDinosaur;

public class EntityCearadactylus extends EntityJurassiCraftLandAggressive implements IDinosaur {

    private double flightTargetX;
    private double flightTargetY;
    private double flightTargetZ;
    private Entity targetEntity;

    private int wingSoundTick = 0;

    private EntityAICearadactylus flyingAi = new EntityAICearadactylus(this);

    public EntityCearadactylus(World world) {
        super(world, (byte) Util.classToId(EntityCearadactylus.class));
        this.getNavigator().setAvoidsWater(true);
        this.tasks.addTask(0, this.flyingAi);
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(1, new JurassiCraftEntityAIWander(this, this.getCreatureSpeed()));
        this.tasks.addTask(2, this.aiSit);
        this.tasks.addTask(4, new EntityAIMoveTowardsRestriction(this, this.getCreatureSpeed()));
        this.tasks.addTask(5, new JurassiCraftEntityAIFollowFood(this, 1.2D * this.getCreatureSpeed()));
        this.tasks.addTask(5, new JurassiCraftEntityAIEatDroppedFood(this, 16.0D));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(6, new EntityAILookIdle(this));

        this.setCreatureExperiencePoints(5000);
    }

    // Click Me's code:

    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(17, new Byte((byte) 0));
    }

    @Override
    public void onUpdate() {
        super.onUpdate();

        if (this.isFlying()) {
            this.motionY *= 0.6000000238418579D;

            if (++this.wingSoundTick >= 15 && !this.worldObj.isRemote) {
                this.playSound("mob.enderdragon.wings", 0.1F, 1.2F + this.rand.nextFloat() * 0.3F);
                this.wingSoundTick = this.rand.nextInt(5);
            }
        }
    }

    @Override
    protected void updateAITasks() {
        super.updateAITasks();

        if (this.isFlying()) {
            if (this.targetEntity != null) {
                this.flightTargetX = this.targetEntity.posX;
                this.flightTargetY = this.targetEntity.posY + 2.0D;
                this.flightTargetZ = this.targetEntity.posZ;
            }
            double xd = this.flightTargetX - this.posX;
            double yd = this.flightTargetY - this.posY;
            double zd = this.flightTargetZ - this.posZ;
            double d = (double) MathHelper.sqrt_double(xd * xd + yd * yd + zd * zd);

            if (d < 1.0D || d > 100.0D || this.rand.nextInt(50) == 0) {
                this.flightTargetX = this.posX + (double) ((this.rand.nextFloat() * 2.0F - 1.0F) * 32.0F);
                this.flightTargetY = this.posY + (double) ((this.rand.nextFloat() * 2.0F - 1.0F) * 8.0F);
                this.flightTargetZ = this.posZ + (double) ((this.rand.nextFloat() * 2.0F - 1.0F) * 32.0F);

                if (d < 1.0D && this.targetEntity != null) {
                    this.targetEntity.attackEntityFrom(DamageSource.causeMobDamage(this), 4.0F);
                    this.targetEntity = null;
                }
            }

            this.motionX += xd / d * 0.05D;
            this.motionY += yd / d * 0.2D;
            this.motionZ += zd / d * 0.05D;

            float f = (float) (Math.atan2(this.motionZ, this.motionX) * 180.0D / Math.PI) - 90.0F;
            float f1 = MathHelper.wrapAngleTo180_float(f - this.rotationYaw);
            this.rotationYaw += f1;

            if (!this.isTamed() && this.rand.nextInt(50) == 0)
                this.targetEntity = this.findPlayerToAttack();

            if (this.flightTargetY < this.posY
                    && this.worldObj.getBlock(MathHelper.floor_double(this.posX),
                            MathHelper.floor_double(this.posY - 0.5D), MathHelper.floor_double(this.posZ))
                            .getMaterial() != Material.air) {
                this.flyingAi.setFlying(false);
            }
        } else {
            if (this.rand.nextInt(50) == 0)
                this.takeOff();
        }
    }

    // For animations for Josh
    public void takeOff() {
        this.flyingAi.setFlying(true);

        //
        this.flightTargetX = this.posX + (double) ((this.rand.nextFloat() * 2.0F - 1.0F) * 32.0F);
        this.flightTargetY = this.posY + (double) (this.rand.nextFloat() * 8.0F);
        this.flightTargetZ = this.posZ + (double) ((this.rand.nextFloat() * 2.0F - 1.0F) * 32.0F);
    }

    @Override
    protected Entity findPlayerToAttack() {
        return this.worldObj.getClosestPlayerToEntity(this, 20.0D);
    }

    public boolean isFlying() {
        return this.dataWatcher.getWatchableObjectByte(17) != 0;
    }

    public void setFlying(boolean flying) {
        this.dataWatcher.updateObject(17, new Byte((byte) (flying ? 1 : 0)));
    }

    @Override
    protected void fall(float p_70069_1_) {
    }

    @Override
    protected void updateFallState(double p_70064_1_, boolean p_70064_3_) {
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nbttag) {
        super.readEntityFromNBT(nbttag);
        this.dataWatcher.updateObject(17, Byte.valueOf(nbttag.getByte("Flying")));
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nbttag) {
        super.writeEntityToNBT(nbttag);
        nbttag.setByte("Flying", this.dataWatcher.getWatchableObjectByte(17));
    }

    // Other's code:

    @Override
    public double getMountedYOffset() {
        return (double) this.getYBouningBox() * 0.6D;
    }

    public String getLivingSound() {
        if (this.rand.nextInt(2) == 0) {
            return Util.getCreatureFromId(this.getCreatureID()).livingSound1;
        } else {
            return Util.getCreatureFromId(this.getCreatureID()).livingSound2;
        }
    }

    public String getHurtSound() {
        return Util.getCreatureFromId(this.getCreatureID()).hurtSound;
    }

    public String getDeathSound() {
        return Util.getCreatureFromId(this.getCreatureID()).deathSound;
    }

    @Override
    public Item getDropItem() {
        return Util.getMeat(Util.getCreatureFromId(this.getCreatureID()));
    }

    @Override
    protected void dropFewItems(boolean recentlyBeenHit, int enchantBonus) {
        float developmentFraction = this.getGrowthStage() / 120.0F;
        int count = Math.round(1 + (2.0F * developmentFraction)
                + this.rand.nextInt(1 + (int) (2.0F * developmentFraction)) + this.rand.nextInt(1 + enchantBonus));
        if (this.isBurning()) {
            this.dropItem(ModItems.dinoSteak, count);
        } else {
            this.dropItem(Util.getMeat(Util.getCreatureFromId(this.getCreatureID())), count);
        }
    }

}
