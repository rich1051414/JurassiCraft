package net.ilexiconn.jurassicraft.entity;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityJurassiCraftRidableFlying extends EntityJurassiCraftRidable {

	private static int MAX_TAKEOFF_TIME = 60;
	private int takeOffTimer;
	private float prevRearingAmount;
	private float extra;

	public EntityJurassiCraftRidableFlying(World world, Creature creature) {
		super(world, creature);
	}

	@Override
	protected void entityInit() {
		super.entityInit();
	}

	@Override
	public void onLivingUpdate() {
		super.onLivingUpdate();
	}

	@Override
	public void moveEntityWithHeading(float movementStrafing, float movementForward) {
		if (this.isFlying()) {
			this.motionX *= 0.6F;
			this.motionZ *= 0.6F;
			if (this.onGround) {
				this.setFlying(false);
			}
		}
		if (this.riddenByEntity != null && this.riddenByEntity instanceof EntityPlayer) {
			EntityPlayer playerFlying = (EntityPlayer) this.riddenByEntity;
			if (playerFlying.getHeldItem() != (ItemStack) null && this.checkRidingItem(playerFlying.getHeldItem())) {

				if (!this.worldObj.isRemote) {
					System.out
							.println("Server: getTakeOffTimer() " + this.getTakeOffTimer() + " isTakingOff? " + this.isTakingOff() + " isFlying? " + this.isFlying() + " isCollidedHorizontall? " + this.isCollidedHorizontally + " MAX_TAKEOFF_TIME " + this.MAX_TAKEOFF_TIME + " onGround: " + this.onGround + " inWater: " + this.inWater);
				}

				if (!this.worldObj.isRemote) {
					if (!this.isFlying() && Minecraft.getMinecraft().gameSettings.keyBindJump.getIsKeyPressed() && Minecraft.getMinecraft().gameSettings.keyBindForward.getIsKeyPressed()) {
						this.increaseTakeOffTimer();
						if (!this.isTakingOff())
							this.setTakingOff(true);
					} else {
						this.decreaseTakeOffTimer(2);
						if (this.isTakingOff())
							this.setTakingOff(false);
					}
				}

				if (this.isCollidedHorizontally) {
					this.setTakingOff(false);
					this.setFlying(false);
				}

				if (this.isTakingOff()) {
					this.stepHeight = 0.5F;
					this.jumpMovementFactor = this.getAIMoveSpeed() * 0.1F;
					if (this.worldObj.isRemote) {
						this.onUpdateTakingOffClient();
					} else {
						this.onUpdateTakingOffServer();
					}
					return;
				}

				if (this.isFlying()) {
					this.stepHeight = 1.25F;
					this.jumpMovementFactor = this.getAIMoveSpeed() * 0.1F;
					if (this.worldObj.isRemote) {
						this.onUpdateFlyingClient();
					} else {
						this.onUpdateFlyingServer();
					}
					return;
				}
			}
		}
		if (this.isTakingOff())
			this.setTakingOff(false);
		super.moveEntityWithHeading(movementStrafing, movementForward);
	}

	private void onUpdateTakingOffClient() {
		this.rotationYaw = this.prevRotationYaw;
		this.rotationPitch = this.prevRotationPitch;
		this.setRotation(this.rotationYaw, this.rotationPitch);
		this.rotationYawHead = this.renderYawOffset = this.rotationYaw;
		this.handleLimbMovement();
	}

	private void onUpdateTakingOffServer() {
		double motionAccelerationY = 0.025;
		double motionAccelerationXZ = 0.01;
		float newAngleYaw = 0.01745329251F * this.rotationYaw + 1.57079632679F;

		this.motionX += motionAccelerationXZ * Math.cos(newAngleYaw);
		this.motionZ += motionAccelerationXZ * Math.sin(newAngleYaw);
		this.motionY += motionAccelerationY * this.getTakingOffMotionY();

		System.out.println("this.motionX " + this.motionX + " this.motionY " + this.motionY + " this.motionZ " + this.motionZ);

		this.moveEntity(this.motionX, this.motionY, this.motionZ);

		if (this.getTakeOffProgress() >= 1.0F) {
			this.setFlying(true);
			this.setTakingOff(false);
			this.motionY = -0.1F;
		}
	}

	private void onUpdateFlyingClient() {
		float adjustPitch = 0.0F;
		float adjustYaw = 0.0F;
		this.stepHeight = 0.0F;
		if (Minecraft.getMinecraft().gameSettings.keyBindRight.getIsKeyPressed()) {
			adjustYaw = adjustYaw + 1.0F;
		}
		if (Minecraft.getMinecraft().gameSettings.keyBindLeft.getIsKeyPressed()) {
			adjustYaw = adjustYaw - 1.0F;
		}
		if (this.rotationPitch <= 60.0F && Minecraft.getMinecraft().gameSettings.keyBindBack.getIsKeyPressed()) {
			adjustPitch = adjustPitch + 1.0F;
		}
		if (this.rotationPitch >= -60.0F && Minecraft.getMinecraft().gameSettings.keyBindForward.getIsKeyPressed()) {
			adjustPitch = adjustPitch - 1.0F;
		}

		this.rotationYaw = this.prevRotationYaw;
		this.rotationPitch = this.prevRotationPitch;
		this.setRotation(this.rotationYaw, this.rotationPitch);
		this.rotationYawHead = this.renderYawOffset = this.rotationYaw;
		
		
		
		this.prevRotationYaw = this.rotationYaw;
		this.prevRotationPitch = this.rotationPitch;
		this.rotationYaw = MathHelper.wrapAngleTo180_float(this.rotationYaw + adjustYaw);
		this.rotationPitch = MathHelper.wrapAngleTo180_float(this.rotationPitch + adjustPitch);
		this.setRotation(this.rotationYaw, this.rotationPitch);
		this.handleLimbMovement();
	}

	private void onUpdateFlyingServer() {
		float newAngleYaw = 0.01745329251F * this.rotationYaw + 1.57079632679F;
		this.motionX = 2.0F * this.getMountingSpeed() * Math.cos(newAngleYaw);
		this.motionZ = 2.0F * this.getMountingSpeed() * Math.sin(newAngleYaw);
		System.out.println("this.rotationYaw " + newAngleYaw + " this.motionX " + this.motionX + " this.motionY " + this.motionY + " this.motionZ " + this.motionZ);
		this.moveEntity(this.motionX, this.motionY, this.motionZ);
	}

	public boolean isCreatureFlyable() {
		return this.getCreature().isFlyingCreature();
	}

	public void setMaximumTakeOffTime(int maxTime) {
		this.MAX_TAKEOFF_TIME = maxTime;
	}

	protected int getMaximumTakeOffTime() {
		return MAX_TAKEOFF_TIME;
	}

	private void setTakeOffTimer(int time) {
		this.takeOffTimer = time;
	}

	private void increaseTakeOffTimer() {
		if (this.getTakeOffTimer() < this.getMaximumTakeOffTime())
			this.takeOffTimer++;
	}

	private void decreaseTakeOffTimer() {
		if (this.getTakeOffTimer() > 0)
			this.takeOffTimer--;
	}

	private void decreaseTakeOffTimer(int value) {
		if (this.getTakeOffTimer() - value > 0)
			this.takeOffTimer -= value;
	}

	private void resetTakeOffTimer() {
		this.takeOffTimer = 0;
	}

	public int getTakeOffTimer() {
		return this.takeOffTimer;
	}

	public float getTakeOffProgress() {
		return (float) (this.getTakeOffTimer() / this.getMaximumTakeOffTime());
	}

	public float getTakingOffMotionY() {
		float result = MathHelper.sin(1.57079632679F * this.getTakeOffTimer() / this.getMaximumTakeOffTime());
		return result * result;
	}

	private void handleLimbMovement() {
		this.prevLimbSwingAmount = this.limbSwingAmount;
		double point1 = this.posX - this.prevPosX;
		double point2 = this.posZ - this.prevPosZ;
		float distance = MathHelper.sqrt_double(point1 * point1 + point2 * point2) * 4.0F;
		if (distance > 1.0F) {
			distance = 1.0F;
		}
		this.limbSwingAmount += (distance - this.limbSwingAmount) * 0.4F;
		this.limbSwing += this.limbSwingAmount;
	}

	@Override
	protected void handleMouseControlledRiding() {
		if (!this.isFlying())
			super.handleMouseControlledRiding();
	}

	@Override
	protected void handleFastItemControlledRiding() {
		if (!this.isFlying())
			super.handleFastItemControlledRiding();
	}

	@Override
	protected void handleSlowItemControlledRiding() {
		if (!this.isFlying())
			super.handleSlowItemControlledRiding();
	}

	@Override
	protected void handleVerySlowItemControlledRiding() {
		if (!this.isFlying())
			super.handleVerySlowItemControlledRiding();
	}

	@Override
	public boolean isOnLadder() {
		return false;
	}

	@Override
	protected void fall(float f) {

	}

	@Override
	protected void updateFallState(double distanceFallen, boolean onGround) {

	}

	@Override
	public void writeEntityToNBT(NBTTagCompound compound) {
		super.writeEntityToNBT(compound);
		compound.setInteger("TakeOffTimer", this.getTakeOffTimer());
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound compound) {
		super.readEntityFromNBT(compound);
		this.setTakeOffTimer(compound.getInteger("TakeOffTimer"));
	}
}
