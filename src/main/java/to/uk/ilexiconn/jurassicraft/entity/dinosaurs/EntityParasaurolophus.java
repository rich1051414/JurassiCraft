package to.uk.ilexiconn.jurassicraft.entity.dinosaurs;

import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import thehippomaster.AnimationAPI.AnimationAPI;
import to.uk.ilexiconn.jurassicraft.ModItems;
import to.uk.ilexiconn.jurassicraft.Util;
import to.uk.ilexiconn.jurassicraft.ai.JurassiCraftEntityAIEatDroppedFood;
import to.uk.ilexiconn.jurassicraft.ai.JurassiCraftEntityAIFollowFood;
import to.uk.ilexiconn.jurassicraft.ai.JurassiCraftEntityAIHerdBehavior;
import to.uk.ilexiconn.jurassicraft.ai.JurassiCraftEntityAIWander;
import to.uk.ilexiconn.jurassicraft.client.animation.AIParasaurolophusTrumpet;
import to.uk.ilexiconn.jurassicraft.entity.EntityJurassiCraftLandProtective;
import to.uk.ilexiconn.jurassicraft.entity.IDinosaur;
import to.uk.ilexiconn.jurassicraft.utility.ControlledParam;

public class EntityParasaurolophus extends EntityJurassiCraftLandProtective implements IDinosaur
{

    public ControlledParam walkLean = new ControlledParam(0, 0, (float) Math.PI / 2, 0);

    public EntityParasaurolophus(World world)
    {
        super(world, (byte) Util.classToId(EntityParasaurolophus.class), 1);
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
        if (I == 0)
        {
            return Util.getCreatureFromId(this.getCreatureID()).livingSound1;
        }
        else if (I == 1)
        {
            return Util.getCreatureFromId(this.getCreatureID()).livingSound2;
        }
        else {
        	AnimationAPI.sendAnimPacket(this, 1);
        	return null;
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

    public void onUpdate()
    {
        super.onUpdate();
        if (this.moveForward != 0)
            walkLean.change = 0.1F;
        if (this.moveForward == 0)
            walkLean.change = -0.1F;
        walkLean.update();
    }

    @Override
    public Item getDropItem()
    {
        return Util.getMeat(Util.getCreatureFromId(this.getCreatureID()));
    }

	@Override
	protected void dropFewItems(boolean recentlyBeenHit, int enchantBonus) 
	{
		float developmentFraction = this.getGrowthStage() / 120.0F;
		int count = Math.round(1 + (3.0F * developmentFraction) + this.rand.nextInt(2 + (int) (3.0F * developmentFraction)) + this.rand.nextInt(1 + enchantBonus));
		if (this.isBurning()) 
		{
			this.dropItem(ModItems.dinoSteak, count);
		} 
		else 
		{
			this.dropItem(Util.getMeat(Util.getCreatureFromId(this.getCreatureID())), count);
		}
	}
}