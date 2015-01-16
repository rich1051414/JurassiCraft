package net.ilexiconn.jurassicraft.ai;

import java.util.Random;

import net.ilexiconn.jurassicraft.entity.EntityJurassiCraftFlyingCreature;
import net.minecraft.block.material.Material;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;

public class JurassiCraftAIFlying extends EntityAIBase
{
    private final long OWNER_FIND_INTERVAL = 5000L;
    private final long SITTINGSPOT_REACHTIME = 3000L;
    private final double OWNER_DISTANCE_TO_TAKEOFF = 100D;
    private final EntityJurassiCraftFlyingCreature creature;
    private ChunkCoordinates currentFlightTarget;
    private Random rand;
    private long nextOwnerCheckTime;
    private long sittingSpotAbortTime;

    public JurassiCraftAIFlying(EntityJurassiCraftFlyingCreature entity) {
        creature = entity;
        rand = entity.getRNG();
        nextOwnerCheckTime = System.currentTimeMillis();
        sittingSpotAbortTime = -1L;
        setMutexBits(1);
    }

    @Override
    public boolean shouldExecute() {
        if(!creature.onGround || creature.flyingParameters == null)
            return false;
        return checkTakeOffConditions();
    }

    @Override
    public boolean continueExecuting() {
        return !creature.onGround;
    }

    @Override
    public void startExecuting() {
        takeOff();
    }

    @Override
    public void resetTask() {
        super.resetTask();
    }

    private boolean takingOff = false;

    @Override
    public void updateTask() {
        flightTicks++;
        if (flightTicks > 30 && takingOff || (takingOff && creature.posY >= targetHeight)) {
            takingOff = false;
            flightTicks = 0;
        }
        if (takingOff) {
            creature.moveEntityWithHeading(creature.flyingParameters.flySpeedModifier / 500f, 0);
            creature.motionY = takeOffSpeed;
        }
        checkForLandingSpot();
        MovingObjectPosition mop = creature.worldObj.rayTraceBlocks(Vec3.createVectorHelper(creature.posX, creature.boundingBox.minY, creature.posZ),
                Vec3.createVectorHelper(creature.posX + creature.motionX * 100, creature.boundingBox.minY, creature.posZ + creature.motionZ * 100));
        if (mop == null)
            mop = creature.worldObj.rayTraceBlocks(Vec3.createVectorHelper(creature.posX, creature.boundingBox.maxY, creature.posZ),
                    Vec3.createVectorHelper(creature.posX + creature.motionX * 100, creature.boundingBox.maxY, creature.posZ + creature.motionZ * 100));

        if (hasLandingSpot()) {
            if (mop == null) {
                double d0;
                double d1;
                double d2;
                d0 = (double) this.currentFlightTarget.posX + 0.5D - creature.posX;
                d1 = (double) this.currentFlightTarget.posY + 0.1D - creature.posY;
                d2 = (double) this.currentFlightTarget.posZ + 0.5D - creature.posZ;
                creature.motionX += (Math.signum(d0) * 1D - creature.motionX) * 0.10000000149011612D;
                creature.motionY += (Math.signum(d1) * 0.699999988079071D - creature.motionY) * 0.10000000149011612D;
                creature.motionZ += (Math.signum(d2) * 1D - creature.motionZ) * 0.10000000149011612D;
                float f = (float) (Math.atan2(creature.motionZ, creature.motionX) * 180.0D / Math.PI) - 90.0F;
                float f1 = MathHelper.wrapAngleTo180_float(f - creature.rotationYaw);
                creature.setMoveForward(0.5F);
                creature.rotationYaw += f1;
            }
        } else {
            maintainFlight(mop != null);
        }

        super.updateTask();
    }

    private void checkForLandingSpot() {
        if (this.currentFlightTarget != null
                && (!creature.worldObj.isAirBlock(this.currentFlightTarget.posX, this.currentFlightTarget.posY, this.currentFlightTarget.posZ) || this.currentFlightTarget.posY < 1)) {
            this.currentFlightTarget = null;
        }

        if (this.currentFlightTarget == null || this.rand.nextInt(30) == 0) {
            this.currentFlightTarget = new ChunkCoordinates((int) (creature.posX + creature.motionX * 200 + this.rand.nextInt(10) - 5), 0, (int) (creature.posZ + creature.motionZ * 200
                    + this.rand.nextInt(10) - 5));

            currentFlightTarget.posY = creature.worldObj.getTopSolidOrLiquidBlock(currentFlightTarget.posX, currentFlightTarget.posZ) + 1;
            Material m = creature.worldObj.getBlock(currentFlightTarget.posX, currentFlightTarget.posY - 1, currentFlightTarget.posZ).getMaterial();
            if (creature.flyingParameters != null && !creature.flyingParameters.willLandInMaterial(m)
                    || !creature.worldObj.isAirBlock(this.currentFlightTarget.posX, this.currentFlightTarget.posY, this.currentFlightTarget.posZ))
                this.currentFlightTarget = null;
        }
    }

    private boolean hasLandingSpot() {
        return currentFlightTarget != null;
    }

    private int nextWingBeat = 10;
    private int wingBeatTick = 0;

    private void maintainFlight(boolean hasObstacle) {
        wingBeatTick++;
        if (hasObstacle || wingBeatTick >= nextWingBeat) {
            pickDirection(hasObstacle);
            nextWingBeat = creature.flyingParameters.flapRate
                    + (int) (Math.random() * 0.4 * creature.flyingParameters.flapRate - 0.2 * creature.flyingParameters.flapRate);
            creature.moveEntityWithHeading(0, 4.0f + creature.flyingParameters.flySpeedModifier / 100f * creature.flyingParameters.flySpeedModifier);
            creature.motionY = (creature.flyingParameters.flapRate + 1) * 0.01;
            wingBeatTick = 0;
        }
    }

    boolean lastChangeDirection;

    public void pickDirection(boolean useLastChangeDirection) {
        double rotAmt;
        if (useLastChangeDirection) {
            rotAmt = creature.getRNG().nextInt(5) + 5;
            if (lastChangeDirection)
                rotAmt *= -1;
            String extra = creature.getAttackTarget() != null ? " has target" : " no target";
        } else {
            rotAmt = creature.getRNG().nextInt(10) - 5;
            if (rotAmt > 0)
                lastChangeDirection = true;
            else
                lastChangeDirection = false;
        }
        creature.rotationYaw += rotAmt;

    }

    private void lookForOwnerEntity() {
        if (System.currentTimeMillis() > nextOwnerCheckTime) {
            nextOwnerCheckTime = System.currentTimeMillis() + OWNER_FIND_INTERVAL;
        }
    }

    private boolean checkTakeOffConditions() {
        EntityPlayer nearest = creature.worldObj.getClosestPlayerToEntity(creature, 6.0D);
        if (nearest != null) {
            return true;
        }
        if (Math.random() < 0.015)
            return true;
        return false;
    }

    private void land() {
        sittingSpotAbortTime = -1L;
        creature.setPosition(currentFlightTarget.posX + 0.5D, currentFlightTarget.posY + 0.5D, currentFlightTarget.posZ + 0.5D);
    }

    int flightTicks = 0;
    double takeOffSpeed = 0;
    int targetHeight = 0;

    private void takeOff() {
        creature.isFlying = true;
        takingOff = true;
        flightTicks = 0;
        targetHeight = (int) creature.posY + (int) (Math.random() * (creature.flyingParameters.flyHeightMax - creature.flyingParameters.flyHeightMin))
                + creature.flyingParameters.flyHeightMin;
        creature.setPosition(creature.posX, creature.posY - 1D, creature.posZ);
        creature.worldObj.playAuxSFXAtEntity((EntityPlayer) null, 1015, (int) creature.posX, (int) creature.posY, (int) creature.posZ, 0);
        takeOffSpeed = 0.22 + creature.flyingParameters.flySpeedModifier / 300f;
        creature.moveEntity(creature.getRNG().nextDouble() - 0.5, takeOffSpeed, creature.getRNG().nextDouble() - 0.5);
    }
}
