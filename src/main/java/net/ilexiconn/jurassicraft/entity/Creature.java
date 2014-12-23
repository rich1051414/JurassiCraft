package net.ilexiconn.jurassicraft.entity;

import java.util.ArrayList;
import java.util.Random;

import net.ilexiconn.jurassicraft.config.JsonCreatureDefinition;
import net.ilexiconn.jurassicraft.item.ItemDNA;
import net.ilexiconn.jurassicraft.item.ItemDinoEgg;
import net.ilexiconn.jurassicraft.item.ItemMammalSyringe;
import net.ilexiconn.jurassicraft.item.ItemMeat;
import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;

public class Creature
{
	private byte creatureID;

	private String creatureName;
	private ArrayList<String> livingSounds;
	private String hurtSound;
	private String deathSound;

	private double minHealth;
	private double minStrength;
	private double minSpeed;
	private double minKnockback;
	private double minProximate;
	private double minMinerals;
	private double minVitamins;
	private double minLipids;
	private double maxHealth;
	private double maxStrength;
	private double maxSpeed;
	private double maxKnockback;
	private double ridingSpeed;

	private float adultAge;
	private float minLength;
	private float minHeight;
	private float maxLength;
	private float maxHeight;
	private float xzBoxMin;
	private float yBoxMin;
	private float xzBoxDelta;
	private float yBoxDelta;
	private float scaleAdjustment;

	private int ticksToAdulthood;
	private int cultivateSpeed;
	private int textureCount;
	private int ridingStyle;
	private int numberOfInfoPages;

	private ArrayList favoriteFoodList;
	private ArrayList ridingItemList;

	private boolean isRidable;
	private boolean canBeTamedUponSpawning;
	private boolean waterCreature;

	private ItemDinoEgg egg;
	private ItemMammalSyringe syringe;
	private ItemMeat meat;
	private ItemDNA dna;

	private String creatureCategory;

	public Creature(String creatureCategory, JsonCreatureDefinition def)
	{
		this.creatureCategory = creatureCategory;

		this.adultAge = def.adultAge;
		this.canBeTamedUponSpawning = def.canBeTamedUponSpawning;
		this.creatureID = def.creatureID;
		this.creatureName = def.creatureName;
		this.cultivateSpeed = def.cultivateSpeed;
		this.deathSound = def.deathSound;
		this.favoriteFoodList = def.favoriteFoodList;
		this.hurtSound = def.hurtSound;
		this.isRidable = def.isRidable;
		this.livingSounds = def.livingSounds;
		this.maxHealth = def.maxHealth;
		this.maxHeight = def.maxHeight;
		this.maxKnockback = def.maxKnockback;
		this.maxLength = def.maxLength;
		this.maxSpeed = def.maxSpeed;
		this.maxStrength = def.maxStrength;
		this.minHealth = def.minHealth;
		this.minHeight = def.minHeight;
		this.minKnockback = def.minKnockback;
		this.minLength = def.minLength;
		this.minLipids = def.minLipids;
		this.minMinerals = def.minMinerals;
		this.minProximate = def.minProximate;
		this.minSpeed = def.minSpeed;
		this.minStrength = def.minStrength;
		this.minVitamins = def.minVitamins;
		this.numberOfInfoPages = def.numberOfInfoPages;
		this.textureCount = def.numberOfTextures;
		this.ridingItemList = def.ridingItemList;
		this.ridingSpeed = def.ridingSpeed;
		this.ridingStyle = def.ridingStyle;
		this.scaleAdjustment = def.scaleAdjustment;
		this.ticksToAdulthood = def.ticksToAdulthood;
		this.waterCreature = def.waterCreature;
		this.xzBoxDelta = def.xzBoxDelta;
		this.xzBoxMin = def.xzBoxMin;
		this.yBoxDelta = def.yBoxDelta;
		this.yBoxMin = def.yBoxMin;

		if(def.addDNA)
		{
			dna = new ItemDNA(creatureName);
			GameRegistry.registerItem(dna, dna.getUnlocalizedName());
		}

		if(def.addEgg)
		{
			egg = new ItemDinoEgg(creatureName);
			GameRegistry.registerItem(egg, egg.getUnlocalizedName());
		}

		if(def.addMeat)
		{
			meat = new ItemMeat(creatureName);
			GameRegistry.registerItem(meat, meat.getUnlocalizedName());
		}

		if(def.addSyringe)
		{
			syringe = new ItemMammalSyringe(creatureName);
			GameRegistry.registerItem(syringe, syringe.getUnlocalizedName());
		}
	}

	public String pickLivingSound()
	{
		Random rand = new Random();
		
		String randSound = livingSounds.get(rand.nextInt(livingSounds.size()));
		
		if(randSound == "")
		{
			return null;
		}
		
		return randSound;
	}
	
	public String getDeathSound()
	{
		return deathSound;
	}
	
	public String getHurtSound()
	{
		return hurtSound;
	}
	
	public String getCreatureName()
	{
		return creatureName;
	}
	
	public String getCreatureCategory()
	{
		return creatureCategory;
	}
	
	public byte getCreatureID()
	{
		return creatureID;
	}
	
	public boolean isWaterCreature()
	{
		return waterCreature;
	}
	
	public ItemDNA getDNA()
	{
		return dna;
	}
	
	public ItemMeat getMeat()
	{
		return meat;
	}

	public boolean isRidingItem(Item item)
	{
		return ridingItemList.contains(item);
	}

	public boolean isRidable()
	{
		return isRidable;
	}

	public int getRidingStyle()
	{
		return ridingStyle;
	}

	public boolean isFavoriteFood(Item item)
	{
		if(favoriteFoodList != null)
		{
			return favoriteFoodList.contains(item);
		}
		
		return false;
	}

	public boolean canBeTamedUponSpawning() 
	{
		return canBeTamedUponSpawning;
	}

	public int getInfoPageCount()
	{
		return numberOfInfoPages;
	}

	public String getLivingSound(int sound)
	{
		return livingSounds.get(sound);
	}

	public float getMaxLength()
	{
		return maxLength;
	}
	
	public float getMaxHeight()
	{
		return maxHeight;
	}

	public double getMaxHealth()
	{
		return maxHealth;
	}
	
	public double getMinHealth()
	{
		return minHealth;
	}

	public double getTicksToAdulthood() 
	{
		return ticksToAdulthood;
	}

	public double getMaxStrength() 
	{
		return maxStrength;
	}

	public double getMinStrength()
	{
		return minStrength;
	}

	public double getMaxSpeed()
	{
		return maxSpeed;
	}
	
	public double getMinSpeed()
	{
		return minSpeed;
	}

	public double getMaxKnockback()
	{
		return maxKnockback;
	}
	
	public double getMinKnockback()
	{
		return minKnockback;
	}

	public double getYBoxMin() 
	{
		return yBoxMin;
	}
	
	public double getYBoxDelta() 
	{
		return yBoxDelta;
	}
	
	public double getXzBoxMin() 
	{
		return xzBoxMin;
	}
	
	public double getXzBoxDelta() 
	{
		return xzBoxDelta;
	}

	public float getScaleAdjustment() 
	{
		return scaleAdjustment;
	}

	public float getMinHeight() 
	{
		return minHeight;
	}

	public float getMinLength() 
	{
		return minLength;
	}

	public float getAdultAge() 
	{
		return adultAge;
	}

	public int getTextureCount()
	{
		return textureCount;
	}

	public ItemDinoEgg getEgg()
	{
		return egg;
	}
	
	public ItemMammalSyringe getMammalSyringe()
	{
		return syringe;
	}

	public double getMinProximate() 
	{
		return minProximate;
	}
	
	public double getMinVitamins() 
	{
		return minVitamins;
	}
	
	public double getMinLipids() 
	{
		return minLipids;
	}

	public double getMinMinerals() 
	{
		return minMinerals;
	}

	public int getCultivateSpeed()
	{
		return cultivateSpeed;
	}
}
