package to.uk.ilexiconn.jurassicraft.entity.dinosaurs;

import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import thehippomaster.AnimationAPI.AnimationAPI;
import to.uk.ilexiconn.jurassicraft.ModItems;
import to.uk.ilexiconn.jurassicraft.Util;
import to.uk.ilexiconn.jurassicraft.ai.JurassiCraftEntityAIEatDroppedFood;
import to.uk.ilexiconn.jurassicraft.ai.JurassiCraftEntityAIFollowFood;
import to.uk.ilexiconn.jurassicraft.ai.JurassiCraftEntityAIHerdBehavior;
import to.uk.ilexiconn.jurassicraft.ai.JurassiCraftEntityAIWander;
import to.uk.ilexiconn.jurassicraft.client.animation.AITriceratopsCharge;
import to.uk.ilexiconn.jurassicraft.entity.EntityJurassiCraftLandProtective;
import to.uk.ilexiconn.jurassicraft.entity.IDinosaur;
import to.uk.ilexiconn.jurassicraft.utility.ControlledParam;

public class EntityTriceratops extends EntityJurassiCraftLandProtective implements IDinosaur
{
	public int timeSinceCharge = 0;
	public boolean charging = false;
    public ControlledParam flailDegree = new ControlledParam(0F, 0F, 1F, 0F);
	
    public EntityTriceratops(World world)
    {
        super(world, (byte) Util.classToId(EntityTriceratops.class), 1);
        this.getNavigator().setAvoidsWater(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(2, this.aiSit);
    	this.tasks.addTask(2, new AITriceratopsCharge(this));
        this.tasks.addTask(4, new JurassiCraftEntityAIFollowFood(this, 1.1D * this.getCreatureSpeed()));
        this.tasks.addTask(4, new JurassiCraftEntityAIEatDroppedFood(this, 16.0D));
        this.tasks.addTask(5, new JurassiCraftEntityAIWander(this, 0.8D * this.getCreatureSpeed()));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 10.0F));
        this.tasks.addTask(6, new EntityAILookIdle(this));
        this.tasks.addTask(7, new JurassiCraftEntityAIHerdBehavior(this, 96, 2000, 20, 0.7D * this.getCreatureSpeed()));
        this.setCreatureExperiencePoints(3500);
    }

    @Override
    public double getMountedYOffset()
    {
        return (double) this.getYBouningBox() * 0.91D;
    }

    @Override
    public int getTalkInterval()
    {
        return 350;
    }

    @Override
    public String getLivingSound()
    {
        if (this.rand.nextInt(2) == 0)
        {
            return Util.getCreatureFromId(this.getCreatureID()).livingSound1;
        }
        else
        {
            return Util.getCreatureFromId(this.getCreatureID()).livingSound2;
        }
    }

    @Override
    public String getHurtSound()
    {
        return Util.getCreatureFromId(this.getCreatureID()).hurtSound;
    }

    @Override
    public String getDeathSound()
    {
        return Util.getCreatureFromId(this.getCreatureID()).deathSound;
    }

    @Override
    public Item getDropItem()
    {
        return Util.getMeat(this.getCreatureID());
    }

	@Override
	protected void dropFewItems(boolean recentlyBeenHit, int enchantBonus) 
	{
		float developmentFraction = this.getGrowthStage() / 120.0F;
		int count = Math.round(1 + (3.5F * developmentFraction) + this.rand.nextInt(2 + (int) (3.5F * developmentFraction)) + this.rand.nextInt(1 + enchantBonus));
		if (this.isBurning()) 
		{
			this.dropItem(ModItems.dinoSteak, count);
		} 
		else 
		{
			this.dropItem(Util.getMeat(this.getCreatureID()), count);
		}
	}
	
	public void onLivingUpdate() {
		super.onLivingUpdate();
		//Charge AI
        float distanceFromTarget;
        if (getAttackTarget() != null)
            distanceFromTarget = (float) Math.sqrt(Math.pow((posX - getAttackTarget().posX), 2) + Math.pow((posZ - getAttackTarget().posZ), 2));
        else
            distanceFromTarget = -1;
        if (this.getAttackTarget() != null && onGround && timeSinceCharge == 0 && !this.isPanicking() && this.getCreatureAgeInDays() >= 17)
            AnimationAPI.sendAnimPacket(this, 1);
        if (timeSinceCharge != 0) 
        	timeSinceCharge--;
	}
	
	@Override
	public void collideWithEntity(Entity victim) {
		super.collideWithEntity(victim);
		if (this.charging && !(victim instanceof EntityTriceratops)) {
			victim.attackEntityFrom(DamageSource.causeMobDamage(this), 20);
			double deltaX = victim.posX - victim.posX;
			double deltaZ = victim.posZ - victim.posZ;
			double angleYaw = (float) Math.atan2(deltaZ, deltaX);
			victim.motionX += Math.cos(angleYaw);
			victim.motionZ += Math.sin(angleYaw);
			victim.motionY += 0.3;
		}
	}
	
	public void onUpdate() {
		super.onUpdate();
		flailDegree.update();
        if (animID == 1 && animTick == 1)
            this.flailDegree.thereAndBack(0F, 0.1F, 1F, 5);
	}
}