package net.ilexiconn.jurassicraft.entity;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import thehippomaster.AnimationAPI.IAnimatedEntity;
import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.ModItems;
import net.ilexiconn.jurassicraft.Util;
import net.ilexiconn.jurassicraft.client.gui.GuiDinoPad;
import net.ilexiconn.jurassicraft.item.ItemDinoPad;
import net.ilexiconn.jurassicraft.item.JurassiCraftDNAHandler;

import java.util.HashSet;

public class EntityJurassiCraftCreature extends EntityCreature implements IAnimatedEntity, IEntityAdditionalSpawnData
{
    public byte creatureID;
    public String dnaSequence;
    public float geneticQuality;
    public boolean gender;
    public byte texture;
    public float height;
    public float length;
    public float bBoxXZ;
    public float bBoxY;
    protected final HashSet<Integer> growthStageList = new HashSet<Integer>();

    protected int animID;
    protected int animTick;
    public int frame;
    
    public int expParameter = 100;

    public EntityJurassiCraftCreature(World world, byte id)
    {
        super(world);
        if (id >= 0 && id < Util.getCreatures().size())
        {
            this.creatureID = id;
        }
        else
        {
            this.creatureID = -1;
        }
        if (this.getGeneticQuality() < 0.6F || this.getGeneticQuality() >= 1.4F)
        {
            this.setRandomGenetics();
        }
        this.resetGrowthStageList();
        this.setCreatureGender(JurassiCraftDNAHandler.getDefaultGenderDNAQuality(this.getDNASequence()) == 0.5F ? this.rand.nextBoolean() : (JurassiCraftDNAHandler.getDefaultGenderDNAQuality(this.getDNASequence()) > 0.5F));
        this.setNewCreatureTexture(JurassiCraftDNAHandler.getDefaultTextureDNAQuality(this.getDNASequence()));
        if (this.worldObj.isRemote)
        {
            this.setCreatureSize();
            this.setCreatureScale();
        }
        else
        {
            this.setHalfOfTheCreatureSize();
        }
        this.animID = 0;
        this.animTick = 0;
    }
    
    @Override
    public boolean isAIEnabled()
    {
        return true;
    }

    /**
     * Sets the creature genetic quality. Genetic quality is how much the
     * creature varies in status. 1.0F is the base value.
     */
    private void setGeneticQuality(float quality)
    {
        this.geneticQuality = quality;
    }

    /**
     * Returns the creature genetic quality.
     */
    public float getGeneticQuality()
    {
        return this.geneticQuality;
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage);
    }

    @Override
    protected void entityInit()
    {
        super.entityInit();
        this.dataWatcher.addObject(12, Float.valueOf((float) ((((this.length / Util.getCreatureFromId(this.creatureID).maxLength) * (this.height / Util.getCreatureFromId(this.creatureID).maxHeight)) / 2))));
        this.dataWatcher.addObject(13, Byte.valueOf((byte) (0)));
    }

    /**
     * Updates the creature status.
     */
    private void updateCreatureData(int ticks)
    {
		double oldHealth = this.getCreatureHealth();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue((int) (this.getGeneticQuality() * (ticks * (Util.getCreatureFromId(this.creatureID).maxHealth - Util.getCreatureFromId(this.creatureID).minHealth) / Util.getCreatureFromId(this.creatureID).ticksToAdulthood + Util.getCreatureFromId(this.creatureID).minHealth)));
		double newHealth = this.getCreatureHealth();
		this.heal((float) (newHealth - oldHealth));
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue((float) (this.getGeneticQuality() * (ticks * (Util.getCreatureFromId(this.creatureID).maxStrength - Util.getCreatureFromId(this.creatureID).minStrength) / Util.getCreatureFromId(this.creatureID).ticksToAdulthood + Util.getCreatureFromId(this.creatureID).minStrength)));
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue((float) (ticks * (Util.getCreatureFromId(this.creatureID).maxSpeed - Util.getCreatureFromId(this.creatureID).minSpeed) / Util.getCreatureFromId(this.creatureID).ticksToAdulthood + Util.getCreatureFromId(this.creatureID).minSpeed));
		this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue((float) (this.getGeneticQuality() * (ticks * (Util.getCreatureFromId(this.creatureID).maxKnockback - Util.getCreatureFromId(this.creatureID).minKnockback) / Util.getCreatureFromId(this.creatureID).ticksToAdulthood + Util.getCreatureFromId(this.creatureID).minKnockback)));
		this.setCreatureLength();
		this.setCreatureHeight();
		this.setHalfOfTheCreatureSize();
		this.setCreatureScale();
    }

    /**
     * Resets the growthStageList. This is a list of values (number of ticks)
     * that represent when the creature will update its status.
     */
    private void resetGrowthStageList()
    {
        int ticks = Util.getCreatureFromId(this.creatureID).ticksToAdulthood;
        this.growthStageList.add(1);
        for (byte i = 1; i < (byte) 120; i++)
        {
            this.growthStageList.add((int) ((ticks * i) / (byte) 120));
        }
        this.growthStageList.add(ticks);
    }

    /**
     * Returns the current growth stage of the creature. In order words, how
     * many times this creature has updated.
     */
    public byte getGrowthStage()
    {
        return (byte) this.dataWatcher.getWatchableObjectByte(13);
    }

    /**
     * Sets what is the growth stage of the creature.
     */
    private void setGrowthStage(byte stage)
    {
        this.dataWatcher.updateObject(13, Byte.valueOf((byte) (stage)));
    }

    /**
     * Sets the creature xz and y hit box using genetic quality and growth
     * stage.
     */
    public void setBouningBox()
    {
        this.bBoxXZ = this.getGeneticQuality() * (Util.getCreatureFromId(this.creatureID).xzBoxMin + Util.getCreatureFromId(this.creatureID).xzBoxDelta * (((float) this.getGrowthStage()) / 120));
        this.bBoxY = this.getGeneticQuality() * (Util.getCreatureFromId(this.creatureID).yBoxMin + Util.getCreatureFromId(this.creatureID).yBoxDelta * (((float) this.getGrowthStage()) / 120));
    }

    /**
     * Sets a new bounding box for the creature depending on its status.
     */
    protected final void setCreatureSize()
    {
        this.setBouningBox();
        super.setSize(this.getXZBouningBox(), this.getYBouningBox());
    }

    /**
     * Sets a new bounding box for the creature depending on its status. This is
     * the half of the original BB, to better fit in combat
     */
    protected final void setHalfOfTheCreatureSize()
    {
        this.setBouningBox();
        super.setSize(this.getXZBouningBox() / 2.0F, this.getYBouningBox() / 2.0F);
    }

    /**
     * Returns the scale of the creature.
     */
    public float getCreatureScale()
    {
        return (float) this.dataWatcher.getWatchableObjectFloat(12) * Util.getCreatureFromId(this.creatureID).scaleAdjustment;
    }

    /**
     * Sets the scale of the creature depending on the age and genetic quality.
     */
    private void setCreatureScale()
    {
        if (this.getTotalTicksLived() < Util.getCreatureFromId(this.creatureID).ticksToAdulthood)
        {
            this.dataWatcher.updateObject(12,
                    Float.valueOf((float) (this.getGeneticQuality() * (((Util.getCreatureFromId(this.creatureID).minHeight + Util.getCreatureFromId(this.creatureID).minLength) / 2) + (((Util.getCreatureFromId(this.creatureID).maxHeight + Util.getCreatureFromId(this.creatureID).maxLength) / 2) - ((Util.getCreatureFromId(this.creatureID).minHeight + Util.getCreatureFromId(this.creatureID).minLength) / 2)) * (((float) this.getTotalTicksLived()) / ((float) Util.getCreatureFromId(this.creatureID).ticksToAdulthood))) / ((Util.getCreatureFromId(this.creatureID).maxHeight + Util.getCreatureFromId(this.creatureID).maxLength) / 2))));
        }
        else
        {
            this.dataWatcher.updateObject(12, Float.valueOf((float) (this.getGeneticQuality())));
        }
    }

    /**
     * Returns how many ticks this entity has lived.
     */
    public int getTotalTicksLived()
    {
        return this.ticksExisted;
    }

    /**
     * Resets the ticks that this entity has lived (Client only).
     */
    private void setTicksExisted(int ticks)
    {
        this.ticksExisted = ticks;
    }

    @Override
    public void onLivingUpdate()
    {
        if (this.getTotalTicksLived() < (Util.getCreatureFromId(this.creatureID).ticksToAdulthood + 1) && this.growthStageList.contains((int) this.getTotalTicksLived()))
        {
            if (this.getGrowthStage() < 120)
            {
                this.setGrowthStage((byte) (this.getGrowthStage() + 1));
            }
            this.setBouningBox();
            if (!this.worldObj.isRemote)
            {
                this.updateCreatureData(this.getTotalTicksLived());
            }
            else
            {
                this.setCreatureSize();
            }
        }
        super.onLivingUpdate();
    }

    /**
     * Force the creature to grow a specific value if it is possible.
     */
    public void forceCreatureGrowth(EntityPlayer player, ItemStack itemStack, byte growthIncrease)
    {
        if (this.getGrowthStage() + growthIncrease <= 120)
        {
            if (!player.capabilities.isCreativeMode)
            {
                itemStack.stackSize--;
                if (itemStack.stackSize <= 0)
                {
                    itemStack = (ItemStack) null;
                }
            }
            this.setGrowthStage((byte) (this.getGrowthStage() + growthIncrease));
            this.setTicksExisted(Util.getCreatureFromId(this.creatureID).ticksToAdulthood * this.getGrowthStage() / 120);
            if (!this.worldObj.isRemote)
            {
                this.updateCreatureData(this.getTotalTicksLived());
            }
            else
            {
                this.setCreatureSize();
            }
        }
        else
        {
            if (!this.worldObj.isRemote)
            {
                player.addChatMessage(new ChatComponentText("This creature cannot grow anymore."));
            }
        }
    }

    /**
     * Force the creature to grow to its maximum size.
     */
    public void setFullGrowth()
    {
        if (!this.isCreatureAdult())
        {
            this.setGrowthStage((byte) (120));
            this.setTicksExisted(Util.getCreatureFromId(this.creatureID).ticksToAdulthood * this.getGrowthStage() / 120);
            if (!this.worldObj.isRemote)
            {
                this.updateCreatureData(this.getTotalTicksLived());
            }
            else
            {
                this.setCreatureSize();
            }
        }
    }

    @Override
    public boolean interact(EntityPlayer player)
    {
    	/**
		System.out.println("=============== UPDATE DATA ===============");
		if (this.worldObj.isRemote) 
		{
			System.out.println("=============== Client ===============");
	        if (player.getHeldItem() != (ItemStack) null)
	        	System.out.println("Held item = " + player.getHeldItem().getUnlocalizedName());
			if (this instanceof EntityJurassiCraftTameable)
				System.out.println("Owner: " + ((EntityJurassiCraftTameable) this).getOwnerName() + ", isTamed: " + ((EntityJurassiCraftTameable) this).isTamed());
			System.out.println("Health: " + this.getCreatureHealth());
			System.out.println("Attack: " + this.getCreatureAttack());
			System.out.println("Speed: " + this.getCreatureSpeed());
			System.out.println("Knockback: " + this.getCreatureKnockback());
			System.out.println("Length: " + this.getCreatureLength());
			System.out.println("Height: " + this.getCreatureHeight());
			System.out.println("Scale: " + this.getCreatureScale());
			System.out.println("Genetic Quality: " + this.getGeneticQuality() + ", DNASequence: " + this.getDNASequence() + ". Revised DNA for 50% " + JurassiCraftDNAHandler.reviseDNA(this.getDNASequence(), 50));
			System.out.println("Gender: " + this.getCreatureGenderString() + ". Genetic for gender: " + JurassiCraftDNAHandler.getDefaultGenderDNAQuality(this.getDNASequence()));
			System.out.println("Texture number: " + this.getCreatureTexture() + ". Genetic for texture: " + JurassiCraftDNAHandler.getDefaultTextureDNAQuality(this.getDNASequence()));
			System.out.println("Adult: " + this.isCreatureAdult());
			System.out.println("======================================");
		} 
		else 
		{
			System.out.println("=============== Server ===============");
	        if (player.getHeldItem() != (ItemStack) null)
	        	System.out.println("Held item = " + player.getHeldItem().getUnlocalizedName());
			if (this instanceof EntityJurassiCraftTameable)
				System.out.println("Owner: " + ((EntityJurassiCraftTameable) this).getOwnerName() + ", isTamed: " + ((EntityJurassiCraftTameable) this).isTamed());
			System.out.println("Health: " + this.getCreatureHealth());
			System.out.println("Attack: " + this.getCreatureAttack());
			System.out.println("Speed: " + this.getCreatureSpeed());
			System.out.println("Knockback: " + this.getCreatureKnockback());
			System.out.println("Length: " + this.getCreatureLength());
			System.out.println("Height: " + this.getCreatureHeight());
			System.out.println("Scale: " + this.getCreatureScale());
			System.out.println("Genetic Quality: " + this.getGeneticQuality() + ", DNASequence: " + this.getDNASequence() + ". Revised DNA for 50% " + JurassiCraftDNAHandler.reviseDNA(this.getDNASequence(), 50));
			System.out.println("Gender: " + this.getCreatureGenderString() + ". Genetic for gender: " + JurassiCraftDNAHandler.getDefaultGenderDNAQuality(this.getDNASequence()));
			System.out.println("Texture number: " + this.getCreatureTexture() + ". Genetic for texture: " + JurassiCraftDNAHandler.getDefaultTextureDNAQuality(this.getDNASequence()));
			System.out.println("Adult: " + this.isCreatureAdult());
			System.out.println("======================================");
		}*/
    	
        if (player.getHeldItem() != (ItemStack) null)
        {
            if (player.getHeldItem().getItem() instanceof ItemDinoPad)
            {
                this.showStatus();
            }
            else if (player.getHeldItem().getItem().equals(ModItems.growthSerum))
            {
                this.forceCreatureGrowth(player, player.getHeldItem(), (byte) 10);
            }
        }
        return super.interact(player);
    }

    /**
     * Sets the creature into the analyzer and show its status.
     */
    @SideOnly(Side.CLIENT)
    private void showStatus()
    {
    	GuiDinoPad.creatureToAnalyze = this;
        FMLClientHandler.instance().getClient().thePlayer.openGui(JurassiCraft.instance, 69, this.worldObj, 0, 0, 0);
    }

    /**
     * Returns the creature ID.
     */
    public byte getCreatureID()
    {
        return this.creatureID;
    }

    /**
     * Returns the creature Name.
     */
    public String getCreatureName()
    {
        return Util.getCreatureFromId(this.creatureID).creatureName;
    }

	/** Checks if the creature has a genetic code. */
	public boolean hasDNASequence() {
		return !(this.getDNASequence() == null || this.getDNASequence() == "");
	}

    /**
     * Sets the creature DNA sequence.
     */
    public void setDNASequence(String dna)
    {
        this.dnaSequence = dna;
    }

    /**
     * Returns the creature DNA sequence.
     */
    public String getDNASequence()
    {
        return this.dnaSequence;
    }

    /**
     * Sets the creature genetic data depending on the dna quality and code.
     */
    public void setGenetics(int dnaQuality, String dna)
    {
    	System.out.println("Quality: " + dnaQuality + "% Code: " + dna + ", after being revised: " + JurassiCraftDNAHandler.reviseDNA(dna, dnaQuality));
        this.setDNASequence(JurassiCraftDNAHandler.reviseDNA(dna, dnaQuality));
        this.setGeneticQuality(JurassiCraftDNAHandler.getDefaultGeneticDNAQuality(dna));
    }

    /** Sets the creature genetic data randomly. */
    public void setRandomGenetics()
    {
    	String randomDNA = JurassiCraftDNAHandler.createDefaultDNA();
    	switch (this.rand.nextInt(3)) {
    		case 0:
    	        this.setDNASequence(JurassiCraftDNAHandler.reviseDNA(randomDNA, 50));
    			break;
    		case 1:
    	        this.setDNASequence(JurassiCraftDNAHandler.reviseDNA(randomDNA, 75));
    			break;
    		case 2:
    	        this.setDNASequence(JurassiCraftDNAHandler.reviseDNA(randomDNA, 100));
    			break;
    		default:
    	        this.setDNASequence(JurassiCraftDNAHandler.reviseDNA(randomDNA, 75));
    	}
        this.setGeneticQuality(JurassiCraftDNAHandler.getDefaultGeneticDNAQuality(randomDNA));
    }

    /**
     * Returns how many ticks this creature requires to reach adulthood.
     */
    public float getAdultAge()
    {
        return Util.getCreatureFromId(this.creatureID).ticksToAdulthood;
    }

    /**
     * Returns true if the creature is considered an adult.
     */
    public boolean isCreatureAdult()
    {
        return this.getTotalTicksLived() >= Util.getCreatureFromId(this.creatureID).adultAge * this.getAdultAge();
    }

    /**
     * Returns true if the creature is older than a certain percentage of the
     * ticks for adulthood.
     */
    public boolean isCreatureOlderThan(float percentage)
    {
        return this.getTotalTicksLived() >= percentage * Util.getCreatureFromId(this.creatureID).ticksToAdulthood;
    }

    /**
     * Returns the creature hit box.
     */
    public float getXZBouningBox()
    {
        return (float) this.bBoxXZ;
    }

    /**
     * Returns the creature hit box.
     */
    public float getYBouningBox()
    {
        return (float) this.bBoxY;
    }
    
    /**
     * Returns the current health of the creature. This is just a information
     * for the user.
     */
    public double getCreatureCurrentHealth()
    {
        return (double) ((int) (100 * this.getHealth())) / 100;
    }

    /**
     * Returns the health of the creature. This is just a information for the
     * user.
     */
    public double getCreatureHealth()
    {
        return (double) ((int) (100 * this.getEntityAttribute(SharedMonsterAttributes.maxHealth).getAttributeValue())) / 100;
    }

    public int getCreatureHealthScaled(int i)
    {
        return (int) ((this.getCreatureHealth() * i) / (1.2F * Util.getCreatureFromId(this.creatureID).maxHealth));
    }

    /**
     * Returns the speed of the creature. This is just a information for the
     * user.
     */
    public double getCreatureAttack()
    {
        return (double) ((int) (100 * this.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue())) / 100;
    }

    public int getCreatureAttackScaled(int i)
    {
        return (int) ((this.getCreatureAttack() * i) / (1.2F * Util.getCreatureFromId(this.creatureID).maxStrength));
    }

    /**
     * Returns the speed of the creature. This is just a information for the
     * user.
     */
    public double getCreatureSpeed()
    {
        return (double) ((int) (100 * this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).getAttributeValue())) / 100;
    }

    public int getCreatureSpeedScaled(int i)
    {
        return (int) ((this.getCreatureSpeed() * i) / (1.2F * Util.getCreatureFromId(this.creatureID).maxSpeed));
    }

    /**
     * Returns the speed of the creature. This is just a information for the
     * user.
     */
    public double getCreatureKnockback()
    {
        return (double) ((int) (100 * this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).getAttributeValue())) / 100;
    }

    /**
     * Returns the knock back of the creature. This is just a information for
     * the user.
     */
    public int getCreatureKnockbackScaled(int i)
    {
        return (int) ((this.getCreatureKnockback() * i) / (1.2F * Util.getCreatureFromId(this.creatureID).maxKnockback));
    }

    /**
     * Returns the length of the creature. This is just a information for the
     * user.
     */
    public float getCreatureLength()
    {
        return (float) ((int) (100 * this.length)) / 100;
    }

    public int getCreatureLengthScaled(int i)
    {
        return (int) ((this.getCreatureLength() * i) / (1.2F * Util.getCreatureFromId(this.creatureID).maxLength));
    }

    /**
     * Returns the height of the creature. This is just a information for the
     * user.
     */
    public float getCreatureHeight()
    {
        return (float) ((int) (100 * this.height)) / 100;
    }

    public int getCreatureHeightScaled(int i)
    {
        return (int) ((this.getCreatureHeight() * i) / (1.2F * Util.getCreatureFromId(this.creatureID).maxHeight));
    }

    /** Returns true if the creature is a male. */
    public boolean isMale()
    {
        if (this.getCreatureGender())
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /** Returns the creature gender as String. */
    public String getCreatureGenderString()
    {
        if (this.getCreatureGender())
        {
            return "Male";
        }
        else
        {
            return "Female";
        }
    }

    /** Returns the creature gender. False is female and true is male. */
    public boolean getCreatureGender()
    {
        return this.gender;
    }

    /** Sets the creature gender. 0 is female and 1 is male. */
    public void setCreatureGender(boolean sex)
    {
        this.gender = sex;
    }

    /**
     * Sets the creature texture based on the genetics.
     */
    private void setNewCreatureTexture(float textureFromGenetics)
    {
    	float texturesInterval = (float) (1.0F/Util.getCreatureFromId(this.creatureID).numberOfTextures);
    	for (int i = 1; i <= Util.getCreatureFromId(this.creatureID).numberOfTextures; i++) {
    		if (textureFromGenetics <= texturesInterval * i) {
    	        this.texture = (byte) (i - 1);
    	        return;
    		}
    	}
        this.texture = (byte) 0;
    }
    
    /** Sets the creature texture. */
    private void setCreatureTexture(byte texture)
    {
        this.texture = texture;
    }

    /**
     * Sets the creature texture.
     */
    public byte getCreatureTexture()
    {
        return this.texture;
    }

    /**
     * Sets the length of the creature. This is just a information for the user.
     */
    public void setCreatureLength()
    {
        if (this.getTotalTicksLived() <= Util.getCreatureFromId(this.creatureID).ticksToAdulthood)
        {
            this.length = (float) (this.getGeneticQuality() * (Util.getCreatureFromId(this.creatureID).minLength + (this.getTotalTicksLived() * (Util.getCreatureFromId(this.creatureID).maxLength - Util.getCreatureFromId(this.creatureID).minLength) / Util.getCreatureFromId(this.creatureID).ticksToAdulthood)));
        }
        else
        {
            this.length = (float) (this.getGeneticQuality() * (Util.getCreatureFromId(this.creatureID).maxLength));
        }
    }

    /**
     * Sets the height of the creature. This is just a information for the user.
     */
    public void setCreatureHeight()
    {
        if (this.getTotalTicksLived() <= Util.getCreatureFromId(this.creatureID).ticksToAdulthood)
        {
            this.height = (float) (this.getGeneticQuality() * (Util.getCreatureFromId(this.creatureID).minHeight + (this.getTotalTicksLived() * (Util.getCreatureFromId(this.creatureID).maxHeight - Util.getCreatureFromId(this.creatureID).minHeight) / Util.getCreatureFromId(this.creatureID).ticksToAdulthood)));
        }
        else
        {
            this.height = (float) (this.getGeneticQuality() * (Util.getCreatureFromId(this.creatureID).maxHeight));
        }
    }

    /**
     * Returns how many days this entity has lived.
     */
    public int getCreatureAgeInDays()
    {
        return this.getTotalTicksLived() / 24000;
    }

    /**
     * Returns how many months this entity has lived.
     */
    public int getCreatureAgeInMonths()
    {
        return this.getTotalTicksLived() / (720000);
    }

    /**
     * Returns how many years this entity has lived.
     */
    public int getCreatureAgeInYears()
    {
        return this.getTotalTicksLived() / (8640000);
    }

    /**
     * Returns how many days, and/or months, and/or years this entity has lived.
     * Note: returns string value.
     */
    public String getCreatureAgeString()
    {
        byte years = (byte) getCreatureAgeInYears();
        byte months = (byte) (getCreatureAgeInMonths() - 12 * this.getCreatureAgeInYears());
        byte days = (byte) (getCreatureAgeInDays() - 30 * this.getCreatureAgeInMonths());
        String yearString = StatCollector.translateToLocal("container.pad.years");
        String monthString = StatCollector.translateToLocal("container.pad.months");
        String dayString = StatCollector.translateToLocal("container.pad.days");
        if (years <= 1)
        {
            yearString = StatCollector.translateToLocal("container.pad.year");
        }
        if (months <= 1)
        {
            monthString = StatCollector.translateToLocal("container.pad.month");
        }
        if (days <= 1)
        {
            dayString = StatCollector.translateToLocal("container.pad.day");
        }
        if (years <= 0)
        {
            if (months <= 0)
            {
                return (String.valueOf(days) + " " + dayString);
            }
            else
            {
                return (String.valueOf(months) + " " + monthString + String.valueOf(days) + " " + dayString);
            }
        }
        else
        {
            if (months <= 0)
            {
                return (String.valueOf(years) + " " + yearString + String.valueOf(days) + " " + dayString);
            }
            else
            {
                return (String.valueOf(years) + " " + yearString + String.valueOf(months) + " " + monthString + String.valueOf(days) + " " + dayString);
            }
        }
    }

    @Override
    protected boolean canDespawn()
    {
        return false;
    }

    @Override
    public float getEyeHeight()
    {
        return this.getCreatureHeight() * 0.85F;
    }

    @Override
    public int getTalkInterval()
    {
        return 200;
    }

    @Override
    protected float getSoundPitch()
    {
        return Float.valueOf(1.0F + 0.8F * (120 - this.getGrowthStage()) / 120);
    }

    @Override
    protected float getSoundVolume()
    {
        return Float.valueOf(0.7F + 0.3F * this.getGrowthStage() / 120);
    }

    public void setCreatureExperiencePoints(int points)
    {
        this.expParameter = points;
    }

    public int getCreatureExperiencePoints()
    {
        return this.expParameter;
    }

    @Override
    protected int getExperiencePoints(EntityPlayer player)
    {
        return (int) (this.getCreatureExperiencePoints() * this.getGeneticQuality() * this.getGrowthStage() / 120);
    }

    public boolean isWaterCreature()
    {
        return Util.getCreatureFromId(this.getCreatureID()).waterCreature;
    }
    
    @Override
    public void setAnimID(int id)
    {
        animID = id;
    }

    @Override
    public void setAnimTick(int tick)
    {
        animTick = tick;
    }

    @Override
    public int getAnimID()
    {
        return animID;
    }

    @Override
    public int getAnimTick()
    {
        return animTick;
    }

    @Override
    public void onUpdate()
    {
        super.onUpdate();
        if (animID != 0)
            animTick++;
        frame++;
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound compound)
    {
        super.writeEntityToNBT(compound);
        compound.setInteger("TicksExisted", this.getTotalTicksLived());
        compound.setString("DNASequence", this.getDNASequence());
        compound.setFloat("GeneticQuality", this.getGeneticQuality());
        compound.setBoolean("Gender", this.getCreatureGender());
        compound.setByte("Texture", this.getCreatureTexture());
        compound.setByte("Stage", this.getGrowthStage());
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound compound)
    {
        super.readEntityFromNBT(compound);
        this.setTicksExisted(compound.getInteger("TicksExisted"));
        this.setDNASequence(compound.getString("DNASequence"));
        this.setGeneticQuality(compound.getFloat("GeneticQuality"));
        this.setCreatureGender(compound.getBoolean("Gender"));
        this.setCreatureTexture(compound.getByte("Texture"));
        this.resetGrowthStageList();
        this.setGrowthStage(compound.getByte("Stage"));
        this.setCreatureLength();
        this.setCreatureHeight();
        this.setCreatureScale();
    }

    @Override
    public void writeSpawnData(ByteBuf buffer)
    {
        buffer.writeInt(this.ticksExisted);
        buffer.writeFloat(this.geneticQuality);
        buffer.writeFloat(this.bBoxXZ);
        buffer.writeFloat(this.bBoxY);
        buffer.writeBoolean(this.gender);
        buffer.writeByte(this.texture);
    }

    @Override
    public void readSpawnData(ByteBuf additionalData)
    {
        this.ticksExisted = additionalData.readInt();
        this.geneticQuality = additionalData.readFloat();
        this.bBoxXZ = additionalData.readFloat();
        this.bBoxY = additionalData.readFloat();
        this.gender = additionalData.readBoolean();
        this.texture = additionalData.readByte();
        this.setCreatureSize();
    }
}