package net.ilexiconn.jurassicraft.entity;

import net.ilexiconn.jurassicraft.ai.stats.FlyingParameters;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityJurassiCraftFlyingAggressive extends EntityJurassiCraftAggressive
{
	public FlyingParameters flyingParameters;
	private String landingMaterial;
	public boolean isFlying;

	public EntityJurassiCraftFlyingAggressive(World world, Creature creature, String landingMaterial)
	{
		super(world, creature);
		this.setLandingMaterial(landingMaterial);
		this.setFlyingParameters(new FlyingParameters(63, 80, 10, 10, 10, 10, 10, 10, 10, this.landingMaterial));
		this.setFlying(false);
	}

	@Override
	public void onLivingUpdate()
	{
		if (this.isFlyingCreature())
		{
			if (this.riddenByEntity == null)
			{
				this.motionY += 0.04F + 0.06F * this.flyingParameters.flySpeedModifier / 500.0F;
				this.isFlying = true;
			}

			if (this.onGround && this.isFlying)
				this.isFlying = false;
		}
		super.onLivingUpdate();
	}

	public FlyingParameters getFlyingParameters()
	{
		return flyingParameters;
	}

	public void setFlyingParameters(FlyingParameters flyingParameters)
	{
		this.flyingParameters = flyingParameters;
	}

	public String getLandingMaterial()
	{
		return landingMaterial;
	}

	public void setLandingMaterial(String landingMaterial)
	{
		this.landingMaterial = landingMaterial;
	}

	public boolean isFlying()
	{
		return isFlying;
	}

	public void setFlying(boolean isFlying)
	{
		this.isFlying = isFlying;
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound compound)
	{
		super.writeEntityToNBT(compound);
		compound.setString("LandingMaterial", this.landingMaterial);
		compound.setBoolean("IsFlying", this.isFlying);
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound compound)
	{
		super.readEntityFromNBT(compound);
		this.setLandingMaterial(compound.getString("LandingMaterial"));
		this.setFlyingParameters(new FlyingParameters(63, 80, 10, 10, 10, 10, 10, 10, 10, compound.getString("LandingMaterial")));
		this.setFlying(compound.getBoolean("IsFlying"));
	}
}
