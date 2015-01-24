package net.ilexiconn.jurassicraft.entity;

import java.util.ArrayList;

import net.ilexiconn.jurassicraft.dinoconfig.JsonCreatureDefinition;
import net.ilexiconn.jurassicraft.item.ItemDNA;
import net.ilexiconn.jurassicraft.item.ItemEgg;
import net.ilexiconn.jurassicraft.item.ItemMammalSyringe;
import net.ilexiconn.jurassicraft.item.ItemMeat;
import net.ilexiconn.jurassicraft.item.ItemSteak;
import net.ilexiconn.jurassicraft.item.drops.ItemBristles;
import net.ilexiconn.jurassicraft.item.drops.ItemFeather;
import net.ilexiconn.jurassicraft.item.drops.ItemFur;
import net.ilexiconn.jurassicraft.item.drops.ItemScale;
import net.ilexiconn.jurassicraft.item.drops.ItemSkin;
import net.ilexiconn.jurassicraft.item.drops.ItemSkull;
import net.ilexiconn.jurassicraft.item.drops.ItemTooth;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class Creature
{
    private String creatureCategory;
    
    private byte creatureID;
    private byte addItemTypes;

    private String creatureName;

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
    private boolean flyingCreature;

    private ItemDNA dna;
    private ItemEgg egg;
    private ItemMammalSyringe syringe;
    private ItemMeat meat;
    private ItemSteak steak;
    private ItemFur fur;
    private ItemSkin skin;
    private ItemScale scale;
    private ItemFeather feather;
    private ItemBristles bristles;
    private ItemSkull skull;
    private ItemTooth tooth;

    public Creature(String creatureCategory, JsonCreatureDefinition def)
    {
        this.creatureCategory = creatureCategory;

        this.adultAge = def.adultAge;
        this.canBeTamedUponSpawning = def.canBeTamedUponSpawning;
        this.creatureID = def.creatureID;
        this.creatureName = def.creatureName;
        this.cultivateSpeed = def.cultivateSpeed;
        this.favoriteFoodList = def.favoriteFoodList;
        this.isRidable = def.isRidable;
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
        this.flyingCreature = def.flyingCreature;
        this.xzBoxDelta = def.xzBoxDelta;
        this.xzBoxMin = def.xzBoxMin;
        this.yBoxDelta = def.yBoxDelta;
        this.yBoxMin = def.yBoxMin;
        this.addItemTypes = def.addItemTypes;
        
//        switch (def.addItemTypes) 
//		{
//			case 0:
//				/** Creature not implemented yet  */
//				break;
//			case 1:
//				/** DNA + Egg */
//				this.addDNA();
//				this.addEgg();
//				break;
//			case 2:
//				/** DNA + Syringe */
//				this.addDNA();
//				this.addSyringe();
//				break;
//			case 3:
//				/** DNA + Egg + Meat */
//				this.addDNA();
//				this.addEgg();
//				this.addMeat();
//				break;
//			case 4:
//				/** DNA + Syringe + Meat */
//				this.addDNA();
//				this.addSyringe();
//				this.addMeat();
//				break;
//			case 5:
//				/** DNA + Egg + Meat + Skull */
//				this.addDNA();
//				this.addEgg();
//				this.addMeat();
//				this.addSkull();
//				break;
//			case 6:
//				/** DNA + Syringe + Meat + Skull */
//				this.addDNA();
//				this.addSyringe();
//				this.addMeat();
//				this.addSkull();
//				break;
//			case 7:
//				/** DNA + Egg + Meat + Skin */
//				this.addDNA();
//				this.addEgg();
//				this.addMeat();
//				this.addSkin();
//				break;
//			case 8:
//				/** DNA + Syringe + Meat + Fur */
//				this.addDNA();
//				this.addSyringe();
//				this.addMeat();
//				this.addFur();
//				break;
//			case 9:
//				/** DNA + Egg + Meat + Skull + Skin */
//				this.addDNA();
//				this.addEgg();
//				this.addMeat();
//				this.addSkull();
//				this.addSkin();
//				break;
//			case 10:
//				/** DNA + Syringe + Meat + Skin */
//				this.addDNA();
//				this.addSyringe();
//				this.addMeat();
//				this.addSkin();
//				break;
//        }
    }
    
    public void addDNA()
    {
    	this.dna = new ItemDNA(this.creatureName);
    	GameRegistry.registerItem(this.dna, this.dna.getUnlocalizedName());
    }
    

    public void addEgg()
    {
    	this.egg = new ItemEgg(this.creatureName);
    	GameRegistry.registerItem(this.egg, this.egg.getUnlocalizedName());
    }

    public void addSyringe()
    {
    	this.syringe = new ItemMammalSyringe(this.creatureName);
    	GameRegistry.registerItem(this.syringe, this.syringe.getUnlocalizedName());
    }
    
    public void addMeat()
    {
		this.meat = new ItemMeat(this.creatureName);
		this.steak = new ItemSteak(this.creatureName);
		GameRegistry.registerItem(this.meat, this.meat.getUnlocalizedName());
		GameRegistry.registerItem(this.steak, this.steak.getUnlocalizedName());
		GameRegistry.addSmelting(new ItemStack(this.meat), new ItemStack(this.steak), 0.0F);
    }

    public void addFur()
    {
    	this.fur = new ItemFur(this.creatureName);
    	GameRegistry.registerItem(this.fur, this.fur.getUnlocalizedName());
    	if (this.creatureName.equals("Leptictidium")) {
	        GameRegistry.addShapedRecipe(new ItemStack(Items.leather_helmet, 1), "FFF", "F F", 'F', new ItemStack(this.fur));
	        GameRegistry.addShapedRecipe(new ItemStack(Items.leather_chestplate, 1), "F F", "FFF", "FFF", 'F', new ItemStack(this.fur));
	        GameRegistry.addShapedRecipe(new ItemStack(Items.leather_leggings, 1), "FFF", "F F", "F F", 'F', new ItemStack(this.fur));
	        GameRegistry.addShapedRecipe(new ItemStack(Items.leather_boots, 1), "F F", "F F", 'F', new ItemStack(this.fur));
		}
    }
    
    public void addSkin()
    {
    	this.skin = new ItemSkin(this.creatureName);
    	GameRegistry.registerItem(this.skin, this.skin.getUnlocalizedName());
    }
    
    public void addScale()
    {
    	this.scale = new ItemScale(this.creatureName);
    	GameRegistry.registerItem(this.scale, this.scale.getUnlocalizedName());
    }
    
    public void addFeather()
    {
    	this.feather = new ItemFeather(this.creatureName);
    	GameRegistry.registerItem(this.feather, this.feather.getUnlocalizedName());
    }
    
    public void addBristles()
    {
    	this.bristles = new ItemBristles(this.creatureName);
    	GameRegistry.registerItem(this.bristles, this.bristles.getUnlocalizedName());
    }
    
    public void addSkull()
    {
    	this.skull = new ItemSkull(this.creatureName);
    	GameRegistry.registerItem(this.skull, this.skull.getUnlocalizedName());
    }
    
    public void addTooth()
    {
    	this.tooth = new ItemTooth(this.creatureName);
    	GameRegistry.registerItem(this.tooth, this.tooth.getUnlocalizedName());
    }

    public String getCreatureName()
    {
        return this.creatureName;
    }

    public String getCreatureCategory()
    {
        return this.creatureCategory;
    }

    public byte getCreatureID()
    {
        return this.creatureID;
    }

    public boolean isWaterCreature()
    {
        return this.waterCreature;
    }

    public boolean isFlyingCreature()
    {
        return this.flyingCreature;
    }

    public ItemDNA getDNA()
    {
        return this.dna;
    }

    public ItemMeat getMeat()
    {
        return this.meat;
    }

    public ItemSteak getSteak()
    {
        return this.steak;
    }

    public ItemFur getFur()
    {
        return this.fur;
    }

    public ItemSkin getSkin()
    {
        return this.skin;
    }

    public ItemScale getScale()
    {
        return this.scale;
    }

    public ItemFeather getFeather()
    {
        return this.feather;
    }

    public ItemBristles getBristles()
    {
        return this.bristles;
    }

    public ItemSkull getSkull()
    {
        return this.skull;
    }

    public ItemTooth getTooth()
    {
        return this.tooth;
    }

    public boolean isRidingItem(Item item)
    {
        if (this.ridingItemList != null && item != null)
        {
            return this.ridingItemList.contains(item.getUnlocalizedName());
        }
        return false;
    }

    public boolean isRidable()
    {
        return this.isRidable;
    }

    public int getRidingStyle()
    {
        return this.ridingStyle;
    }

    public double getRidingSpeed()
    {
        return this.ridingSpeed;
    }

    public boolean isFavoriteFood(Item item)
    {
        if (this.favoriteFoodList != null && item != null)
        {
            return this.favoriteFoodList.contains(item.getUnlocalizedName());
        }
        return false;
    }

    public boolean canBeTamedUponSpawning()
    {
        return this.canBeTamedUponSpawning;
    }

    public int getInfoPageCount()
    {
        return this.numberOfInfoPages;
    }

    public float getMaxLength()
    {
        return this.maxLength;
    }

    public float getMaxHeight()
    {
        return this.maxHeight;
    }

    public double getMaxHealth()
    {
        return this.maxHealth;
    }

    public double getMinHealth()
    {
        return this.minHealth;
    }

    public double getTicksToAdulthood()
    {
        return this.ticksToAdulthood;
    }

    public double getMaxStrength()
    {
        return this.maxStrength;
    }

    public double getMinStrength()
    {
        return this.minStrength;
    }

    public double getMaxSpeed()
    {
        return this.maxSpeed;
    }

    public double getMinSpeed()
    {
        return this.minSpeed;
    }

    public double getMaxKnockback()
    {
        return this.maxKnockback;
    }

    public double getMinKnockback()
    {
        return this.minKnockback;
    }

    public double getYBoxMin()
    {
        return this.yBoxMin;
    }

    public double getYBoxDelta()
    {
        return this.yBoxDelta;
    }

    public double getXzBoxMin()
    {
        return this.xzBoxMin;
    }

    public double getXzBoxDelta()
    {
        return this.xzBoxDelta;
    }

    public float getScaleAdjustment()
    {
        return this.scaleAdjustment;
    }

    public float getMinHeight()
    {
        return this.minHeight;
    }

    public float getMinLength()
    {
        return this.minLength;
    }

    public float getAdultAge()
    {
        return this.adultAge;
    }

    public int getTextureCount()
    {
        return this.textureCount;
    }

    public ItemEgg getEgg()
    {
        return this.egg;
    }

    public ItemMammalSyringe getMammalSyringe()
    {
        return this.syringe;
    }

    public double getMinProximate()
    {
        return this.minProximate;
    }

    public double getMinVitamins()
    {
        return this.minVitamins;
    }

    public double getMinLipids()
    {
        return this.minLipids;
    }

    public double getMinMinerals()
    {
        return this.minMinerals;
    }

    public int getCultivateSpeed()
    {
        return this.cultivateSpeed;
    }

    public byte getAddedItemTypes()
    {
        return this.addItemTypes;
    }
}
