package net.ilexiconn.jurassicraft.ai;

import com.google.common.collect.Lists;
import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.entity.EntityJurassiCraftCreature;
import net.ilexiconn.jurassicraft.interfaces.IHerbivore;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.init.Blocks;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.ArrayList;
import java.util.List;

public class JurassiCraftAIEatLeaves extends EntityAIBase
{

    private EntityJurassiCraftCreature creature;
    private double speed;
    private int maxDist;
    private World world;
    private long lastTimeExecuted;
    private int leavesX;
    private int leavesY;
    private int leavesZ;
    private boolean foundLeaves;
    private long maxTime;
    private double damage;

    public JurassiCraftAIEatLeaves(EntityJurassiCraftCreature creature, double speed)
    {
        this(creature, speed, 32);
    }

    public JurassiCraftAIEatLeaves(EntityJurassiCraftCreature creature, double speed, int maxDist)
    {
        this(creature, speed, maxDist, 0); // 2 (minute) times 60 (seconds) times 20 (ticks per second)
    }

    public JurassiCraftAIEatLeaves(EntityJurassiCraftCreature creature, double speed, int maxDist, long maxTime)
    {
        if (!(creature instanceof IHerbivore))
            JurassiCraft.instance.logger.error("You tried to make a non-herbivore creature eat leaves. It won't like it, do not try it, plz.");
        this.maxDist = maxDist;
        this.creature = creature;
        this.speed = speed;
        this.world = creature.worldObj;
        this.maxTime = maxTime;
    }

    public void startExecuting()
    {
        ArrayList<Vec3> leavesBlocks = Lists.newArrayList();
        int startX = (int) Math.floor(creature.posX);
        int startY = (int) Math.floor(creature.posY + creature.height);
        int startZ = (int) Math.floor(creature.posZ);
        for (int x = -maxDist / 2 + startX; x < maxDist / 2 + startX; x++)
        {
            for (int y = -maxDist / 2 + startY; y < maxDist / 2 + startY; y++)
            {
                for (int z = -maxDist / 2 + startZ; z < maxDist / 2 + startZ; z++)
                {
                    if (world.getBlock(x, y, z) == Blocks.leaves || world.getBlock(x, y, z) == Blocks.leaves2)
                    {
                        leavesBlocks.add(Vec3.createVectorHelper(x, y, z));
                    }
                }
            }
        }
        // Now that we have all the blocks of leaves around the creature, we sort them to get blobs of leaves and then get their center

        List<List<Vec3>> blobsList = Lists.newArrayList();
        blocksList:
        for (Vec3 leavesPos : leavesBlocks)
        {
            for (List<Vec3> list : blobsList)
            {
                for (Vec3 pos : list)
                {
                    if (isNextTo(pos, leavesPos))
                    {
                        list.add(leavesPos);
                        continue blocksList;
                    }
                }
            }
            // If we are here, that means no blocks where found near this block

            List<Vec3> blob = Lists.newArrayList();
            blob.add(leavesPos);
            blobsList.add(blob);
        }

        // Then we merge blobs that are next to each other because the previous algorithm might separate some

        List<List<Vec3>> finalList = Lists.newArrayList();
        finalList.addAll(blobsList);
        blobList:
        for (List<Vec3> blob : blobsList)
        {
            for (Vec3 pos : blob)
            {
                for (List<Vec3> otherBlob : blobsList)
                {
                    for (Vec3 otherPos : otherBlob)
                    {
                        if (isNextTo(pos, otherPos) && finalList.contains(blob) && finalList.contains(otherBlob))
                        {
                            List<Vec3> mergedBlob = Lists.newArrayList();
                            mergedBlob.addAll(blob);
                            mergedBlob.addAll(otherBlob);
                            finalList.add(mergedBlob);
                            finalList.remove(blob);
                            finalList.remove(otherBlob);
                            continue blobList;
                        }
                    }
                }
            }
        }
        // Finally, we calculate the center of each pool and get the nearest one.
        List<Vec3> nearestBlob = null;
        for (List<Vec3> blob : finalList)
        {
            double centerX = 0;
            double centerY = 0;
            double centerZ = 0;

            for (Vec3 pos : blob)
            {
                centerX += pos.xCoord;
                centerY += pos.yCoord;
                centerZ += pos.zCoord;
            }

            centerX /= blob.size();
            centerY /= blob.size();
            centerZ /= blob.size();

            if (creature.getDistance(centerX, centerY, centerZ) <= creature.getDistance(leavesX, leavesY, leavesZ) || leavesY <= 0)
            {
                nearestBlob = blob;
                lastTimeExecuted = world.getWorldTime(); // TODO: Check if path is possible
                this.foundLeaves = true;
            }
        }
        if (nearestBlob != null)
        {
            Vec3 leavesLoc = nearestBlob.get((int) (Math.random() * nearestBlob.size())); // We choose a random block from the blob
            leavesX = (int) Math.floor(leavesLoc.xCoord);
            leavesY = (int) Math.floor(leavesLoc.yCoord);
            leavesZ = (int) Math.floor(leavesLoc.zCoord);
        }
    }

    public boolean continueExecuting()
    {
        if (!foundLeaves || leavesY < 0) return false;
        if (world.getBlock(leavesX, leavesY, leavesZ) != Blocks.leaves && world.getBlock(leavesX, leavesY, leavesZ) != Blocks.leaves2)
        {
            // We have eaten the block. Or an evil player destroyed it. ;-(
            return false;
        }
        double dist = creature.getDistance(leavesX, leavesY, leavesZ);
        if (dist <= creature.height + creature.width * 2)
        {
            damage += 0.025;
            world.destroyBlockInWorldPartially(creature.getEntityId(), leavesX, leavesY, leavesZ, (int) (damage * 10));
            JurassiCraft.instance.logger.info("damage: " + damage);
            if (damage >= 1.0)
            {
                damage = 0.0;
                world.setBlockToAir(leavesX, leavesY, leavesZ);
                world.playSound(leavesX, leavesY, leavesZ, Blocks.leaves.stepSound.soundName, 1.0f, 1.0f, false);
            }
        }
        else
        {
            int y = getFirstSolidUnder(leavesX, leavesY, leavesZ);
            if (y < 0) return false;
            PathEntity path = creature.getNavigator().getPathToXYZ(leavesX, y, leavesZ);
            if (path != null)
            {
                creature.getNavigator().setPath(path, speed * 2);
            }
            else if (path == null && creature.onGround && !creature.isInWater())
            {
                return false; // Path is impossible
            }
        }
        return true;
    }

    private int getFirstSolidUnder(int x, int y, int z)
    {
        for (; y >= 0; y--)
            if (world.getBlock(x, y, z).isSideSolid(world, x, y, z, ForgeDirection.UP)) return y;
        return -1;
    }

    public boolean isInterruptible()
    {
        return true;
    }

    private boolean isNextTo(Vec3 a, Vec3 b)
    {
        double dx = a.xCoord - b.xCoord;
        double dy = a.yCoord - b.yCoord;
        double dz = a.zCoord - b.zCoord;
        return (dx + dy + dz) == 1f;
    }

    @Override
    public void resetTask()
    {
        super.resetTask();
        this.foundLeaves = false;
        this.leavesX = 0;
        this.leavesY = -64;
        this.leavesZ = 0;
        damage = 0.0;
        lastTimeExecuted = world.getWorldTime();
    }

    @Override
    public boolean shouldExecute()
    {
        return world.getWorldTime() - lastTimeExecuted >= maxTime && Math.random() < 1.10;
    }

}
