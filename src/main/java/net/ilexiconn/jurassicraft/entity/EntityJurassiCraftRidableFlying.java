package net.ilexiconn.jurassicraft.entity;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityJurassiCraftRidableFlying extends EntityJurassiCraftRidable
{
	private static int MAX_TAKEOFF_TIME = 60;
	private int takeOffTimer;
	private float prevRearingAmount;
	private float extra;

	public EntityJurassiCraftRidableFlying(World world, Creature creature)
	{
		super(world, creature);
	}

	@Override
	protected void entityInit()
	{
		super.entityInit();
	}

	@Override
	public void onLivingUpdate()
	{
		super.onLivingUpdate();
	}

	@Override
	public void moveEntityWithHeading(float movementStrafing, float movementForward)
	{
		if (this.riddenByEntity != null && this.riddenByEntity instanceof EntityPlayer)
		{
			EntityPlayer playerFlying = (EntityPlayer) this.riddenByEntity;
			if (this.isFlying() || (playerFlying.getHeldItem() != (ItemStack) null && this.checkRidingItem(playerFlying.getHeldItem())))
			{
				/** There is a valid rider. */
				
				/** This starts the taking off. Player should jump and move forward. After some ticks, the state will change from taking off to flying */
				if (!this.worldObj.isRemote)
				{
					if ((this.isTakingOff() || !this.isFlying()) && Minecraft.getMinecraft().gameSettings.keyBindJump.getIsKeyPressed() && Minecraft.getMinecraft().gameSettings.keyBindForward.getIsKeyPressed())
					{
						this.increaseTakeOffTimer();
						if (!this.isTakingOff())
							this.setTakingOff(true);
					}
					else
					{
						this.decreaseTakeOffTimer(2);
						if (this.isTakingOff())
						{
							this.setTakingOff(false);
							this.resetTakeOffTimer();
						}
					}
				}

				/** If creature collided with a wall, it should stop flying and taking off. */
				if (this.isCollidedHorizontally)
				{
					this.setTakingOff(false);
					this.setFlying(false);
					this.resetTakeOffTimer();
				}

				/** SET MOVEMENTS AND ROTATIONS DEPENDING ON THE CREATURE STATE (TAKING OFF/FLYING). */
				if (this.isTakingOff())
				{
					this.stepHeight = 0.5F;
					this.jumpMovementFactor = this.getAIMoveSpeed() * 0.1F;
					//SERVER AND CLIENT CHECK LATER
					this.onUpdateTakingOffClient();
					this.onUpdateTakingOffServer();
					/** END METHOD HERE IF TAKING OFF. */
					return;
				}

				if (this.isFlying())
				{
					/**
					 * If creature collided with the ground while flying, it should stop flying and
					 * taking off, and also reduce its speed.
					 */
					if (this.onGround)
					{
						this.motionX *= 0.7F;
						this.motionZ *= 0.7F;
						this.setTakingOff(false);
						this.setFlying(false);
						this.resetTakeOffTimer();
					}
					
					this.stepHeight = 1.25F;
					this.jumpMovementFactor = this.getAIMoveSpeed() * 0.1F;
					//SERVER AND CLIENT CHECK LATER
					this.onUpdateFlyingClient();
					this.onUpdateFlyingServer();
					/** END METHOD HERE IF FLYING. */
					return;
				}
			}
			else
			{
				/** There is a invalid rider (no riding item). Decrease speed slowly. */
				if (this.isFlying())
				{
					if (this.onGround)
						this.setFlying(false);
				}
			}
		}
		/**
		 * If there is no rider and creature is flying, decrease motion slowly and remove flying
		 * state if true.
		 */
		if (this.isFlying())
		{
			if (this.onGround)
				this.setFlying(false);
		}
		/** Remove takingOff state if true and there is no rider. */
		if (this.isTakingOff())
		{
			this.setTakingOff(false);
			this.resetTakeOffTimer();
		}
		/** No rider normal moveEntityWithHeading(). */
		super.moveEntityWithHeading(movementStrafing, movementForward);
	}

	private void onUpdateTakingOffClient()
	{
		this.rotationYaw = this.prevRotationYaw;
		this.rotationPitch = this.prevRotationPitch;
		this.setRotation(this.rotationYaw, this.rotationPitch);
		this.rotationYawHead = this.renderYawOffset = this.rotationYaw;
		this.handleLimbMovement();
	}

	private void onUpdateTakingOffServer()
	{
		float newAngleYaw = 0.01745329251F * this.rotationYaw + 1.57079632679F;

		this.motionY += 0.025D * (double) this.getTakingOffMotionY();
		this.motionX += 0.01D * Math.cos(newAngleYaw);
		this.motionZ += 0.01D * Math.sin(newAngleYaw);

		this.moveEntity(this.motionX, this.motionY, this.motionZ);

		if (this.getTakeOffProgress() >= 1.0F)
		{
			this.setFlying(true);
			this.setTakingOff(false);
			this.resetTakeOffTimer();
			this.motionY = -0.1F;
		}
	}

	private void onUpdateFlyingClient()
	{
		float adjustYaw = 0.0F;
		this.stepHeight = 0.0F;
		if (Minecraft.getMinecraft().gameSettings.keyBindRight.getIsKeyPressed())
		{
			adjustYaw += 2.5F;
		}
		if (Minecraft.getMinecraft().gameSettings.keyBindLeft.getIsKeyPressed())
		{
			adjustYaw -= 2.5F;
		}
		this.rotationYaw = MathHelper.wrapAngleTo180_float(this.rotationYaw + adjustYaw);
		this.prevRotationYaw = this.rotationYaw;
		this.prevRotationPitch = this.rotationPitch;
		this.setRotation(this.rotationYaw, this.rotationPitch);
		this.handleLimbMovement();
	}

	private void onUpdateFlyingServer()
	{
		if (this.motionY <= 2.0F * this.getMountingSpeed() && Minecraft.getMinecraft().gameSettings.keyBindForward.getIsKeyPressed())
		{
			this.motionY += 0.02D;
		}
		if (this.motionY >= -2.0F * this.getMountingSpeed() && Minecraft.getMinecraft().gameSettings.keyBindBack.getIsKeyPressed())
		{
			this.motionY -= 0.02D;
		}
		this.motionX = (double) (2.0F * this.getMountingSpeed() * MathHelper.cos(0.01745329251F * this.rotationPitch) * MathHelper.sin(3.14159265359F + 0.01745329251F * this.rotationYaw));
		this.motionZ = (double) (2.0F * this.getMountingSpeed() * MathHelper.cos(0.01745329251F * this.rotationPitch) * MathHelper.cos(0.01745329251F * this.rotationYaw));
		this.moveEntity(this.motionX, this.motionY + 0.05D, this.motionZ);
	}

	private void handleLimbMovement()
	{
		this.prevLimbSwingAmount = this.limbSwingAmount;
		double pointX = this.posX - this.prevPosX;
		double pointZ = this.posZ - this.prevPosZ;
		float distance = MathHelper.sqrt_double(pointX * pointX + pointZ * pointZ) * 4.0F;
		if (distance > 1.0F)
		{
			distance = 1.0F;
		}
		this.limbSwingAmount += (distance - this.limbSwingAmount) * 0.4F;
		this.limbSwing += this.limbSwingAmount;
	}

	public boolean isCreatureFlyable()
	{
		return this.getCreature().isFlyingCreature();
	}

	public void setMaximumTakeOffTime(int maxTime)
	{
		this.MAX_TAKEOFF_TIME = maxTime;
	}

	protected int getMaximumTakeOffTime()
	{
		return MAX_TAKEOFF_TIME;
	}

	private void setTakeOffTimer(int time)
	{
		this.takeOffTimer = time;
	}

	private void increaseTakeOffTimer()
	{
		if (this.getTakeOffTimer() <= this.getMaximumTakeOffTime())
			this.takeOffTimer++;
	}

	private void decreaseTakeOffTimer()
	{
		if (this.getTakeOffTimer() >= 0)
			this.takeOffTimer--;
	}

	private void decreaseTakeOffTimer(int value)
	{
		if (this.getTakeOffTimer() - value >= 0)
			this.takeOffTimer -= value;
	}

	private void resetTakeOffTimer()
	{
		this.takeOffTimer = 0;
	}

	public int getTakeOffTimer()
	{
		return this.takeOffTimer;
	}

	public float getTakeOffProgress()
	{
		return (float) (this.getTakeOffTimer() / this.getMaximumTakeOffTime());
	}

	public float getTakingOffMotionY()
	{
		float result = MathHelper.sin(1.57079632679F * this.getTakeOffTimer() / this.getMaximumTakeOffTime());
		return result * result;
	}

	@Override
	public void collideWithEntity(Entity target)
	{
		super.collideWithEntity(target);
		if (this.isFlying()) {
			double deltaX = target.posX - target.posX;
			double deltaZ = target.posZ - target.posZ;
			double angleYaw = (float) Math.atan2(deltaZ, deltaX);
			target.motionX += Math.cos(angleYaw);
			target.motionZ += Math.sin(angleYaw);
			target.motionY += 0.2;
		}
	}

	@Override
	public boolean isOnLadder()
	{
		return false;
	}

	@Override
	protected void fall(float f)
	{

	}

	@Override
	protected void updateFallState(double distanceFallen, boolean onGround)
	{

	}

	@Override
	public void writeEntityToNBT(NBTTagCompound compound)
	{
		super.writeEntityToNBT(compound);
		compound.setInteger("TakeOffTimer", this.getTakeOffTimer());
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound compound)
	{
		super.readEntityFromNBT(compound);
		this.setTakeOffTimer(compound.getInteger("TakeOffTimer"));
	}
}
