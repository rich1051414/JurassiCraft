package net.ilexiconn.jurassicraft.entity.dinosaurs;

import net.ilexiconn.jurassicraft.ai.JurassiCraftEntityAIEatDroppedFood;
import net.ilexiconn.jurassicraft.ai.JurassiCraftEntityAIFollowFood;
import net.ilexiconn.jurassicraft.ai.JurassiCraftEntityAIWander;
import net.ilexiconn.jurassicraft.entity.CreatureManager;
import net.ilexiconn.jurassicraft.entity.EntityJurassiCraftLandProtective;
import net.ilexiconn.jurassicraft.entity.IDinosaur;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntityAnkylosaur extends EntityJurassiCraftLandProtective implements IDinosaur 
{
	public EntityAnkylosaur(World world) 
	{
		super(world, CreatureManager.classToCreature(EntityAnkylosaur.class), 1);
		this.getNavigator().setAvoidsWater(true);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(2, this.aiSit);
		this.tasks.addTask(4, new JurassiCraftEntityAIFollowFood(this,
				1.1D * this.getCreatureSpeed()));
		this.tasks.addTask(4, new JurassiCraftEntityAIEatDroppedFood(this,
				16.0D));
		this.tasks.addTask(5, new JurassiCraftEntityAIWander(this, 0.7D * this.getCreatureSpeed()));
		this.tasks.addTask(6, new EntityAIWatchClosest(this,
				EntityPlayer.class, 6.0F));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.setCreatureExperiencePoints(5000);
	}
	
	@Override
	public double getMountedYOffset()
	{
		return (double) this.getYBouningBox() * 1.05D;
	}

	@Override
	public int getTalkInterval()
	{
		return 350;
	}
}