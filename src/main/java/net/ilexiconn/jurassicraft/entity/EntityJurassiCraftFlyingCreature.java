package net.ilexiconn.jurassicraft.entity;

import net.ilexiconn.jurassicraft.ai.stats.FlyingParameters;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityJurassiCraftFlyingCreature extends EntityJurassiCraftRidable
{
    public FlyingParameters flyingParameters;
    private String landingMaterial;

    public EntityJurassiCraftFlyingCreature(World world, String landingMaterial)
    {
        super(world);
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
                this.setFlying(true);
            }

            if (this.onGround && this.isFlying()) this.setFlying(false);
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
        compound.setString("LandingMaterial", this.landingMaterial);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound compound)
    {
        super.readEntityFromNBT(compound);
        this.setLandingMaterial(compound.getString("LandingMaterial"));
        this.setFlyingParameters(new FlyingParameters(63, 80, 10, 10, 10, 10, 10, 10, 10, compound.getString("LandingMaterial")));
    }
}
