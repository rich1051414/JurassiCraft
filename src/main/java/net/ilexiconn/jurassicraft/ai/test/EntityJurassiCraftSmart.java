package net.ilexiconn.jurassicraft.ai.test;

import net.ilexiconn.jurassicraft.entity.Creature;
import net.ilexiconn.jurassicraft.entity.EntityJurassiCraftCreature;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityJurassiCraftSmart extends EntityJurassiCraftCreature {

	public EntityJurassiCraftSmart(World world, Creature creature) {
		super(world, creature);
	}

	@Override
	protected void entityInit() {
		super.entityInit();
		this.dataWatcher.addObject(15, Integer.valueOf((int) 0));
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

	/** Returns true if the creature is defending itself from some threat. */
	public boolean isDefending() {
		return (this.getStatus() & Status.DEFENDING) == Status.DEFENDING;
	}

	/** Sets if the creature is defending itself from some threat. */
	public void setDefending(boolean flag) {
		if (flag) {
			this.setStatus(this.getStatus() | Status.DEFENDING);
		} else {
			this.setStatus(this.getStatus() & ~Status.DEFENDING);
		}
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
	public void setSitting(boolean flag) {
		if (flag) {
			this.setStatus(this.getStatus() | Status.SITTING);
		} else {
			this.setStatus(this.getStatus() & ~Status.SITTING);
		}
	}

	/** Returns true if the creature is sleeping. */
	public boolean isSleeping() {
		return (this.getStatus() & Status.SLEEPING) == Status.SLEEPING;
	}

	/** Sets if the creature is sleeping. */
	public void setSleeping(boolean flag) {
		if (flag) {
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
		if (flag) {
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
		if (flag) {
			this.setStatus(this.getStatus() | Status.STRESSED);
		} else {
			this.setStatus(this.getStatus() & ~Status.STRESSED);
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

	/** Returns true if the creature is wandering. */
	public boolean isWandering() {
		return (this.getStatus() & Status.WANDERING) == Status.WANDERING;
	}

	/** Sets if the creature is wandering. */
	public void setWandering(boolean flag) {
		if (flag) {
			this.setStatus(this.getStatus() | Status.WANDERING);
		} else {
			this.setStatus(this.getStatus() & ~Status.WANDERING);
		}
	}

	@Override
	public boolean interact(EntityPlayer player) {
		/**
		System.out.println("");
		System.out.println("TESTING FLAG OPERATIONS");
		System.out.println("");
		System.out.println("Before adding anything: " + Integer.toBinaryString(this.getStatus()) + " = " + this.getStatus());
		System.out.println("Status: Stressed = " + this.isStressed() + ", Thirsty = " + this.isThirsty() + ", Wandering = " + this.isWandering());
		System.out.println("Adding Operations");
		
		
		
		System.out.println("");
		System.out.println("After addition: " + Integer.toBinaryString(this.getStatus()) + " = " + this.getStatus());
		System.out.println("Status: Stressed = " + this.isStressed() + ", Thirsty = " + this.isThirsty() + ", Wandering = " + this.isWandering());
		*/
		return super.interact(player);
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound compound) {
		super.writeEntityToNBT(compound);
		compound.setInteger("Status", this.getStatus());
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound compound) {
		super.readEntityFromNBT(compound);
		this.setStatus(compound.getInteger("Status"));
	}
}
