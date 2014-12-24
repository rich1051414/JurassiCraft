package net.ilexiconn.jurassicraft.entity.mammals;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.ilexiconn.jurassicraft.Util;
import net.ilexiconn.jurassicraft.entity.CreatureManager;
import net.ilexiconn.jurassicraft.entity.EntityJurassiCraftCreature;
import net.ilexiconn.jurassicraft.entity.EntityJurassiCraftTameable;

import java.lang.reflect.InvocationTargetException;

public class JurassiCraftLivingEvent
{

	@SubscribeEvent
	public void onEntityConstructing(EntityConstructing event) 
	{
		if (event.entity instanceof EntityCow && EntityPregnantCow.get((EntityCow) event.entity) == null) 
		{
			EntityPregnantCow.register((EntityCow) event.entity);
		} else if (event.entity instanceof EntityPig && EntityPregnantPig.get((EntityPig) event.entity) == null) 
		{
			EntityPregnantPig.register((EntityPig) event.entity);
		} else if (event.entity instanceof EntityHorse && EntityPregnantHorse.get((EntityHorse) event.entity) == null) 
		{
			EntityPregnantHorse.register((EntityHorse) event.entity);
		} else if (event.entity instanceof EntitySheep && EntityPregnantSheep.get((EntitySheep) event.entity) == null) 
		{
			EntityPregnantSheep.register((EntitySheep) event.entity);
		}
	}

	@SubscribeEvent
	public void onEntityLiving(LivingUpdateEvent event) 
	{
		if (event.entityLiving instanceof EntityCow) 
		{
			EntityPregnantCow cow = EntityPregnantCow.get((EntityCow) event.entityLiving);
			if (cow != null && !cow.getMammalName().equals(StatCollector.translateToLocal("container.pad.pregnancy.noEmbryo"))) 
			{
		    	if (cow.getPregnancyProgress() < cow.getPregnancySpeed())
				{
					cow.increasePregnancyProgress();
					event.entityLiving.onLivingUpdate();
				} 
				else 
				{
					spawnMammalBaby(cow.getMammalName(), cow.getDnaQuality(), cow.getDnaSequence(), event);
					cow.setMammalName(StatCollector.translateToLocal("container.pad.pregnancy.noEmbryo"));
					cow.setDnaQuality(0);
					cow.setDnaSequence("");
					cow.setPregnancyProgress(0);
					cow.setPregnancySpeed(0);
				}
			}
		} 
		else if (event.entityLiving instanceof EntityPig) 
		{
			EntityPregnantPig pig = EntityPregnantPig.get((EntityPig) event.entityLiving);
			if (pig != null && !pig.getMammalName().equals(StatCollector.translateToLocal("container.pad.pregnancy.noEmbryo"))) 
			{
				if (pig.getPregnancyProgress() < pig.getPregnancySpeed())
				{
					pig.increasePregnancyProgress();
					event.entityLiving.onLivingUpdate();
				} 
				else 
				{
					spawnMammalBaby(pig.getMammalName(), pig.getDnaQuality(), pig.getDnaSequence(), event);
					pig.setMammalName(StatCollector.translateToLocal("container.pad.pregnancy.noEmbryo"));
					pig.setDnaQuality(0);
					pig.setDnaSequence("");
					pig.setPregnancyProgress(0);
					pig.setPregnancySpeed(0);
				}
			}
		} 
		else if (event.entityLiving instanceof EntityHorse) 
		{
			EntityPregnantHorse horse = EntityPregnantHorse.get((EntityHorse) event.entityLiving);
			if (horse != null && !horse.getMammalName().equals(StatCollector.translateToLocal("container.pad.pregnancy.noEmbryo"))) 
			{
				if (horse.getPregnancyProgress() < horse.getPregnancySpeed())
				{
					horse.increasePregnancyProgress();
					event.entityLiving.onLivingUpdate();
				} 
				else 
				{
					spawnMammalBaby(horse.getMammalName(), horse.getDnaQuality(), horse.getDnaSequence(), event);
					horse.setMammalName(StatCollector.translateToLocal("container.pad.pregnancy.noEmbryo"));
					horse.setDnaQuality(0);
					horse.setDnaSequence("");
					horse.setPregnancyProgress(0);
					horse.setPregnancySpeed(0);
				}
			}
		} 
		else if (event.entityLiving instanceof EntitySheep) 
		{
			EntityPregnantSheep sheep = EntityPregnantSheep.get((EntitySheep) event.entityLiving);
			if (sheep != null && !sheep.getMammalName().equals(StatCollector.translateToLocal("container.pad.pregnancy.noEmbryo"))) 
			{
				if (sheep.getPregnancyProgress() < sheep.getPregnancySpeed())
				{
					sheep.increasePregnancyProgress();
					event.entityLiving.onLivingUpdate();
				} 
				else 
				{
					spawnMammalBaby(sheep.getMammalName(), sheep.getDnaQuality(), sheep.getDnaSequence(), event);
					sheep.setMammalName(StatCollector.translateToLocal("container.pad.pregnancy.noEmbryo"));
					sheep.setDnaQuality(0);
					sheep.setDnaSequence("");
					sheep.setPregnancyProgress(0);
					sheep.setPregnancySpeed(0);
				}
			}
		}
	}

	public void spawnMammalBaby(String mammalName, int quality, String dnaSequence, LivingUpdateEvent event) 
	{
		Class mammalToSpawnClass = CreatureManager.getCreatureClass(mammalName);
		try 
		{
			Entity mammalToSpawn = (Entity) mammalToSpawnClass.getConstructor(World.class).newInstance(event.entityLiving.worldObj);
			if (mammalToSpawn instanceof EntityJurassiCraftCreature) 
			{
				EntityJurassiCraftCreature baby = (EntityJurassiCraftCreature) mammalToSpawn;
				baby.setGenetics(quality, dnaSequence);
				if (mammalToSpawn instanceof EntityJurassiCraftTameable && ((EntityJurassiCraftTameable) baby).canBeTamedUponSpawning()) 
				{
					EntityPlayer owner = event.entityLiving.worldObj.getClosestPlayerToEntity(event.entityLiving, 6.0F);
					if (owner != null) 
					{
						((EntityJurassiCraftTameable) baby).setTamed(true);
						((EntityJurassiCraftTameable) baby).setOwner(owner.getCommandSenderName());
						event.entityLiving.worldObj.setEntityState((EntityJurassiCraftTameable) baby, (byte) 7);
					}
				}
				baby.setPosition(event.entityLiving.posX, event.entityLiving.posY, event.entityLiving.posZ);
				if (!event.entityLiving.worldObj.isRemote) 
				{
					event.entityLiving.worldObj.spawnEntityInWorld(baby);
				}
			}
		} 
		catch (InstantiationException e) 
		{
			e.printStackTrace();
		} 
		catch (IllegalAccessException e) 
		{
			e.printStackTrace();
		} 
		catch (IllegalArgumentException e) 
		{
			e.printStackTrace();
		} 
		catch (InvocationTargetException e) 
		{
			e.printStackTrace();
		} 
		catch (NoSuchMethodException e) 
		{
			e.printStackTrace();
		} 
		catch (SecurityException e) 
		{
			e.printStackTrace();
		}
	}

}