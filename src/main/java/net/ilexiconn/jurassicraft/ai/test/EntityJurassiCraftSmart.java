package net.ilexiconn.jurassicraft.ai.test;

import net.ilexiconn.jurassicraft.entity.Creature;
import net.ilexiconn.jurassicraft.entity.EntityJurassiCraftCreature;
import net.ilexiconn.jurassicraft.entity.EntityJurassiCraftTameable;
import net.ilexiconn.jurassicraft.item.ItemDinoPad;
import net.ilexiconn.jurassicraft.item.ItemGrowthSerum;
import net.ilexiconn.jurassicraft.item.ItemOnAStick;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityOwnable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.scoreboard.Team;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * This class holds many status of the creature, such as sitting, taming, sleeping, and other
 * behaviors. Every status is set by using bit flags.
 * 
 * NOTE: IT WILL REPLACE THE EntityJurassiCraftTameable!!!
 * 
 * @author RafaMv
 */
public class EntityJurassiCraftSmart extends EntityJurassiCraftCreature implements IEntityOwnable {

	public EntityJurassiCraftSmart(World world, Creature creature) {
	super(world, creature);
	}

	@Override
	protected void entityInit() {
		super.entityInit();
		this.dataWatcher.addObject(15, Integer.valueOf((int) 0));
        this.dataWatcher.addObject(16, "");
	}

	@Override
	public void onUpdate() {
		super.onUpdate();
		if (this.rand.nextInt(100) == 0)
			this.updateStatus();
	}

	@Override
	/** Adds the updateStatus() every time that the creature grows */
	protected void updateCreatureData(int ticks) {
		super.updateCreatureData(ticks);
		this.updateStatus();
	}

	@Override
	public boolean interact(EntityPlayer player) {
		ItemStack heldItemStack = player.getHeldItem();
		if (heldItemStack != null) {
			if (!(heldItemStack.getItem() instanceof ItemGrowthSerum) && !(heldItemStack.getItem() instanceof ItemDinoPad) && !(heldItemStack.getItem() instanceof ItemOnAStick)) {
				if (this.getCreature().isFavoriteFood(heldItemStack.getItem())) {
					boolean shouldDecreaceItemStack = false;
					if ((double) (this.getHealth() + 3.0F) <= this.getCreatureHealth()) {
						shouldDecreaceItemStack = true;
						this.heal(3.0F);
					}
					if (!this.isTamed() && !this.worldObj.isRemote) {
						shouldDecreaceItemStack = true;
						if (this.rand.nextInt(4) == 0) {
							this.setTamed(true, player);
						} else {
							this.worldObj.setEntityState(this, (byte) 6);
						}
					}
					if (shouldDecreaceItemStack) {
						if (!player.capabilities.isCreativeMode) {
							heldItemStack.stackSize--;
							if (heldItemStack.stackSize <= 0)
								player.inventory.setInventorySlotContents(player.inventory.currentItem, (ItemStack) null);
						}
					}
				} else if (this.isTamed() && this.isOwner(player) && !this.worldObj.isRemote) {
					this.setSitting(!this.isSitting(), player);
				}
			}
		} else {
			if (this.isTamed() && this.isOwner(player) && !this.worldObj.isRemote) {
				this.setSitting(!this.isSitting(), player);
			}
		}
		return super.interact(player);
	}

	/**
	 * Sets the status of the creature. It uses bitwise language.
	 * 
	 * @param status is an integer representing one or more status that are true.
	 */
	public void setStatus(int status) {
		this.dataWatcher.updateObject(15, Integer.valueOf((int) status));
	}

	/** Returns the status of the creature. It uses bitwise language. */
	public int getStatus() {
		return (int) this.dataWatcher.getWatchableObjectInt(15);
	}

	/** Returns true if the creature is hungry. */
	public boolean isHungry() {
		return (this.getStatus() & Status.HUNGRY) == Status.HUNGRY;
	}

	/** Sets if the creature is hungry. */
	public void setHunger(boolean flag) {
		if (flag) {
			this.setStatus(this.getStatus() | Status.HUNGRY);
		} else {
			this.setStatus(this.getStatus() & ~Status.HUNGRY);
		}
	}

	/** Returns true if the creature is thirsty. */
	public boolean isThirsty() {
		return (this.getStatus() & Status.THIRSTY) == Status.THIRSTY;
	}

	/** Sets if the creature is thirsty. */
	public void setThirsty(boolean flag) {
		if (flag) {
			this.setStatus(this.getStatus() | Status.THIRSTY);
		} else {
			this.setStatus(this.getStatus() & ~Status.THIRSTY);
		}
	}

	/** Returns true if the creature is injured. */
	public boolean isInjured() {
		return (this.getStatus() & Status.INJURED) == Status.INJURED;
	}

	/** Sets if the creature is injured. */
	public void setInjured(boolean flag) {
		if (flag) {
			this.setStatus(this.getStatus() | Status.INJURED);
		} else {
			this.setStatus(this.getStatus() & ~Status.INJURED);
		}
	}

	/** Returns true if the creature is sitting. */
	public boolean isSitting() {
		return (this.getStatus() & Status.SITTING) == Status.SITTING;
	}

	/** Sets if the creature is sitting. */
	public void setSitting(boolean flag, EntityPlayer player) {
		if (flag && !this.isStressed() && !this.isDefending()) {
			this.setStatus(this.getStatus() | Status.SITTING);
			this.isJumping = false;
			this.setPathToEntity((PathEntity) null);
			this.setTarget((Entity) null);
			this.setAttackTarget((EntityLivingBase) null);
			this.handleSittingText(player);
		} else {
			this.setStatus(this.getStatus() & ~Status.SITTING);
			this.handleSittingText(player);
		}
	}

	/** Sets true for the sitting status and false for the stressed and defending behavior. */
	public void forceSitting(EntityPlayer player) {
		this.setStatus(this.getStatus() & ~Status.DEFENDING);
		this.setStatus(this.getStatus() & ~Status.STRESSED);
		this.setStatus(this.getStatus() | Status.SITTING);
            this.isJumping = false;
            this.setPathToEntity((PathEntity) null);
            this.setTarget((Entity) null);
            this.setAttackTarget((EntityLivingBase) null);
            this.handleSittingText(player);
	}

	/** Shows a text about the sitting status of the creature. */
	public void handleSittingText(EntityPlayer player) {
		if (player != null) {
			if (this.isSitting()) {
				if (this.hasCustomNameTag()) {
					player.addChatMessage(new ChatComponentText(this.getCustomNameTag() + " (" + StatCollector.translateToLocal("entity." + this.getCreature().getCreatureName() + ".name") + ") " + StatCollector.translateToLocal("entity.interaction.isSitting")));
				} else {
					player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("entity." + this.getCreature().getCreatureName() + ".name") + " " + StatCollector.translateToLocal("entity.interaction.isSitting")));
				}
			} else {
				if (this.hasCustomNameTag()) 
            	{
                    player.addChatMessage(new ChatComponentText(this.getCustomNameTag() + " (" + StatCollector.translateToLocal("entity." + this.getCreature().getCreatureName() + ".name") + ") " + StatCollector.translateToLocal("entity.interaction.isNotSitting")));
            	}
            	else
            	{
                    player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("entity." + this.getCreature().getCreatureName() + ".name") + " " + StatCollector.translateToLocal("entity.interaction.isNotSitting")));
            	}
			}
		}
	}

	/** Returns true if the creature is sleeping. */
	public boolean isSleeping() {
		return (this.getStatus() & Status.SLEEPING) == Status.SLEEPING;
	}

	/** Sets if the creature is sleeping. */
	public void setSleeping(boolean flag) {
		if (flag && this.isSitting() && !this.isDefending() && !this.isStressed()) {
			this.setStatus(this.getStatus() | Status.SLEEPING);
		} else {
			this.setStatus(this.getStatus() & ~Status.SLEEPING);
		}
	}

	/** Returns true if the creature is socializing. */
	public boolean isSocializing() {
		return (this.getStatus() & Status.SOCIALIZING) == Status.SOCIALIZING;
	}

	/** Sets if the creature is socializing. */
	public void setSocializing(boolean flag) {
		if (flag && !this.isSleeping() && !this.isDefending() && !this.isStressed()) {
			this.setStatus(this.getStatus() | Status.SOCIALIZING);
		} else {
			this.setStatus(this.getStatus() & ~Status.SOCIALIZING);
		}
	}

	/** Returns true if the creature is stressed. */
	public boolean isStressed() {
		return (this.getStatus() & Status.STRESSED) == Status.STRESSED;
	}

	/** Sets if the creature is stressed. */
	public void setStressed(boolean flag) {
		if (flag && !this.isSleeping()) {
			this.setStatus(this.getStatus() | Status.STRESSED);
		} else {
			this.setStatus(this.getStatus() & ~Status.STRESSED);
		}
	}

	/** Returns true if the creature is defending itself from some threat. */
	public boolean isDefending() {
		return (this.getStatus() & Status.DEFENDING) == Status.DEFENDING;
	}

	/** Sets if the creature is defending itself from some threat. */
	public void setDefending(boolean flag) {
		if (flag && !this.isSleeping()) {
			this.setStatus(this.getStatus() | Status.DEFENDING);
		} else {
			this.setStatus(this.getStatus() & ~Status.DEFENDING);
		}
	}

	/** Returns true if the creature is tamed. */
	public boolean isTamed() {
		return (this.getStatus() & Status.TAMED) == Status.TAMED;
	}

	/** Sets if the creature is wandering. */
	public void setTamed(boolean flag, EntityPlayer player) {
		if (flag) {
			this.setStatus(this.getStatus() | Status.TAMED);
            this.setAttackTarget((EntityLivingBase) null);
            this.setPathToEntity((PathEntity) null);
            this.forceSitting(player);
            this.setOwner(player.getCommandSenderName());
            this.worldObj.setEntityState(this, (byte) 7);
        	if (this.hasCustomNameTag()) 
        	{
        	    player.addChatMessage(new ChatComponentText(this.getCustomNameTag() + " (" + StatCollector.translateToLocal("entity." + this.getCreature().getCreatureName() + ".name") + ") " + StatCollector.translateToLocal("entity.interaction.tamed")));
        	}
        	else
        	{
        	    player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("entity." + this.getCreature().getCreatureName() + ".name") + " " + StatCollector.translateToLocal("entity.interaction.tamed")));
        	}
		} else {
			this.setStatus(this.getStatus() & ~Status.TAMED);
		}
	}

	/**
	 * Returns true if the creature can be tamed when spawning from an egg. You must call this
	 * method to set the nearest player as the owner. This value is set in the json file.
	 */
    public boolean canBeTamedUponSpawning()
    {
        return this.getCreature().canBeTamedUponSpawning();
    }

	/** Update all status trying to remove incompatibilities, such as sleeping and defending at the same time. */
	public void updateStatus() {
		if (this.isStressed() || this.isDefending()) {
			this.setSleeping(false);
			this.setSitting(false, null);
			this.setSocializing(false);
		}
		if (this.isSleeping()) {
			this.setSocializing(false);
			this.setStressed(false);
			this.setDefending(false);
		}
		if (this.isSitting()) {
			this.setStressed(false);
			this.setDefending(false);
		}
	}

	/** Clear all status from this creature, except for the injury and tamed status. */
	public void clearStatus() {
		this.setSleeping(false);
		this.setSitting(false, null);
		this.setSocializing(false);
		this.setStressed(false);
		this.setDefending(false);
		this.setHunger(false);
		this.setThirsty(false);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void handleHealthUpdate(byte flag) {
		if (flag == 7) {
			this.playTameEffect(true);
		} else if (flag == 6) {
			this.playTameEffect(false);
		} else {
			super.handleHealthUpdate(flag);
		}
	}

	/**
	 * Spawns particles depending on the flag. It is used in vanilla creatures when they are being tamed.
	 * 
	 * @param flag true spawns heart particles, whereas false spawns smoke particles.
	 */
	protected void playTameEffect(boolean flag) {
		for (int i = 0; i < 7; i++) {
			double d0 = this.rand.nextGaussian() * 0.02D;
			double d1 = this.rand.nextGaussian() * 0.02D;
			double d2 = this.rand.nextGaussian() * 0.02D;
			this.worldObj.spawnParticle(flag ? "heart" : "smoke", this.posX + (double) (this.rand.nextFloat() * this.width * 2.0F) - (double) this.width, this.posY + 0.5D + (double) (this.rand.nextFloat() * this.height), this.posZ + (double) (this.rand.nextFloat() * this.width * 2.0F) - (double) this.width, d0, d1, d2);
		}
	}

	public String getOwnerName() {
		return this.dataWatcher.getWatchableObjectString(16);
	}

	public void setOwner(String owner) {
		this.dataWatcher.updateObject(16, owner);
	}

	/**
	 * Returns true if the entity is the creature owner.
	 */
	public boolean isOwner(Entity possibleOwner) {
		return possibleOwner == this.getOwner();
	}

	@Override
	public boolean allowLeashing() {
		return !this.getLeashed() && this.isTamed();
	}

	@Override
	public EntityLivingBase getOwner() {
		return this.worldObj.getPlayerEntityByName(this.getOwnerName());
	}

	@Override
	public Team getTeam() {
		if (this.isTamed()) {
			EntityLivingBase owner = this.getOwner();
			if (owner != null)
				return owner.getTeam();
		}
		return super.getTeam();
	}

	@Override
	public boolean isOnSameTeam(EntityLivingBase creature) {
		if (this.isTamed()) {
			EntityLivingBase owner = this.getOwner();
			if (creature == owner)
				return true;
			if (owner != null)
				return owner.isOnSameTeam(creature);
		}
		return super.isOnSameTeam(creature);
	}

	@Override
	public String func_152113_b() {
		return null;
	}

    /**
	 * Returns true if the target of this creature is not the owner or other creature from the same
	 * owner or same species.
	 */
	public boolean checkTargetBeforeAttacking(Entity target) {
		if (target == (Entity) null || target == this || target == this.getOwner()) {
			if (target instanceof EntityJurassiCraftTameable) {
				return !this.isOwner(((EntityJurassiCraftTameable) target).getOwner());
			} else {
				return true;
			}
		}
		return false;
	}

	/** This can be used to check if the flags are working properly. */
	public void testFlags() {
		System.out.println("");
		System.out.println("TESTING FLAG OPERATIONS");
		System.out.println("");
		System.out.println("Before adding anything: " + Integer.toBinaryString(this.getStatus()) + " = " + this.getStatus());
		System.out.println("Status: Stressed = " + this.isStressed());
		System.out.println("Adding Operations");

		System.out.println("");
		System.out.println("After addition: " + Integer.toBinaryString(this.getStatus()) + " = " + this.getStatus());
		System.out.println("Status: Stressed = " + this.isStressed());
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound compound) {
		super.writeEntityToNBT(compound);
		compound.setInteger("Status", this.getStatus());
		if (this.getOwnerName() != null) {
			compound.setString("Owner", this.getOwnerName());
		} else {
			compound.setString("Owner", "");
		}
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound compound) {
		super.readEntityFromNBT(compound);
		if (compound.hasKey("Status"))
			this.setStatus(compound.getInteger("Status"));
		if (compound.hasKey("Owner")) {
			String ownerName = compound.getString("Owner");
			if (ownerName != null && ownerName.length() > 0) {
				this.setOwner(ownerName);
			}
		} else {
			this.setOwner("");
		}
	}
}
