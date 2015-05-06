package net.ilexiconn.jurassicraft.entity;

import cpw.mods.fml.common.ObfuscationReflectionHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.ilexiconn.jurassicraft.ai.JCPathNavigate;
import net.ilexiconn.jurassicraft.ai.States;
import net.ilexiconn.jurassicraft.item.ItemDinoPad;
import net.ilexiconn.jurassicraft.item.ItemGrowthSerum;
import net.ilexiconn.jurassicraft.item.ItemOnAStick;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
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

import java.util.ArrayList;
import java.util.List;

/**
 * This class holds many states of the creature, such as sitting, taming, sleeping, and other
 * behaviors. Every state is set by using bit flags.
 *
 * @author RafaMv
 */
public class EntityJurassiCraftSmart extends EntityJurassiCraftCreature implements IEntityOwnable
{
    
    protected int angryTicks;
    protected int numberOfAllies;
    public EntityLivingBase creatureToAttack;
    
    public EntityJurassiCraftSmart(World world)
    {
        super(world);
        this.numberOfAllies = 0;
        JCPathNavigate nav = new JCPathNavigate(this, world);
        ObfuscationReflectionHelper.setPrivateValue(EntityLiving.class, this, nav, 6);
    }
    
    @Override
    protected void entityInit()
    {
        super.entityInit();
        this.dataWatcher.addObject(15, Integer.valueOf((int) 0));
        this.dataWatcher.addObject(16, "");
    }
    
    @Override
    public boolean interact(EntityPlayer player)
    {
        ItemStack heldItemStack = player.getHeldItem();
        if (heldItemStack != null)
        {
            if (!(heldItemStack.getItem() instanceof ItemGrowthSerum) && !(heldItemStack.getItem() instanceof ItemDinoPad) && !(heldItemStack.getItem() instanceof ItemOnAStick))
            {
                if (this.getCreature().isFavoriteFood(heldItemStack.getItem()))
                {
                    boolean shouldDecreaceItemStack = false;
                    if ((double) (this.getHealth() + 3.0F) <= this.getCreatureHealth())
                    {
                        shouldDecreaceItemStack = true;
                        this.heal(3.0F);
                    }
                    if (!this.isTamed() && !this.worldObj.isRemote)
                    {
                        shouldDecreaceItemStack = true;
                        if (this.rand.nextInt(4) == 0)
                        {
                            this.setTamed(true, player);
                        }
                        else
                        {
                            this.worldObj.setEntityState(this, (byte) 6);
                        }
                    }
                    if (shouldDecreaceItemStack)
                    {
                        if (!player.capabilities.isCreativeMode)
                        {
                            heldItemStack.stackSize--;
                            if (heldItemStack.stackSize <= 0)
                                player.inventory.setInventorySlotContents(player.inventory.currentItem, (ItemStack) null);
                        }
                    }
                }
                else if (this.isTamed() && this.isOwner(player) && !this.worldObj.isRemote)
                {
                    this.setSitting(!this.isSitting(), null);
                }
            }
        }
        else
        {
            if (this.isTamed() && this.isOwner(player) && !this.worldObj.isRemote)
            {
                this.setSitting(!this.isSitting(), null);
            }
        }
        return super.interact(player);
    }
    
    /**
     * Sets the states of the creature. It uses bitwise language.
     *
     * @param states is an integer representing one or more states that are true.
     */
    public void setStatus(int states)
    {
        this.dataWatcher.updateObject(15, Integer.valueOf((int) states));
    }
    
    /**
     * Returns the states of the creature. It uses bitwise language.
     */
    public int getStatus()
    {
        return (int) this.dataWatcher.getWatchableObjectInt(15);
    }
    
    /**
     * Returns true if the creature is swimming.
     */
    public boolean isTakingOff()
    {
        return (this.getStatus() & States.TAKINGOFF) == States.TAKINGOFF;
    }
    
    /**
     * Sets if the creature is swimming.
     */
    public void setTakingOff(boolean flag)
    {
        if (flag && !this.isSitting() && !this.isSleeping() && !this.isEating() && !this.isDrinking() && !this.isPlaying() && !this.isBreeding() && !this.isFlying())
        {
            this.setStatus(this.getStatus() | States.TAKINGOFF);
        }
        else
        {
            this.setStatus(this.getStatus() & ~States.TAKINGOFF);
        }
    }
    
    /**
     * Sets incompatible states false to set swimming state.
     */
    public void forceTakingOff(boolean flag)
    {
        this.setStatus(this.getStatus() & ~States.SITTING);
        this.setStatus(this.getStatus() & ~States.SLEEPING);
        this.setStatus(this.getStatus() & ~States.EATING);
        this.setStatus(this.getStatus() & ~States.DRINKING);
        this.setStatus(this.getStatus() & ~States.PLAYING);
        this.setStatus(this.getStatus() & ~States.BREEDING);
        this.setStatus(this.getStatus() & ~States.FLYING);
        this.setStatus(this.getStatus() | States.TAKINGOFF);
    }
    
    /**
     * Returns true if the creature is flying.
     */
    public boolean isFlying()
    {
        return (this.getStatus() & States.FLYING) == States.FLYING;
    }
    
    /**
     * Sets if the creature is flying.
     */
    public void setFlying(boolean flag)
    {
        if (flag && !this.isSitting() && !this.isSleeping() && !this.isEating() && !this.isDrinking() && !this.isPlaying() && !this.isBreeding() && this.isTakingOff())
        {
            this.setStatus(this.getStatus() | States.FLYING);
        }
        else
        {
            this.setStatus(this.getStatus() & ~States.FLYING);
        }
    }
    
    /**
     * Sets incompatible states false to set flying state.
     */
    public void forceFlying(boolean flag)
    {
        this.setStatus(this.getStatus() & ~States.SITTING);
        this.setStatus(this.getStatus() & ~States.SLEEPING);
        this.setStatus(this.getStatus() & ~States.EATING);
        this.setStatus(this.getStatus() & ~States.DRINKING);
        this.setStatus(this.getStatus() & ~States.PLAYING);
        this.setStatus(this.getStatus() & ~States.BREEDING);
        this.setStatus(this.getStatus() & ~States.TAKINGOFF);
        this.setStatus(this.getStatus() | States.FLYING);
    }
    
    /**
     * Returns true if the creature is tamed.
     */
    public boolean isTamed()
    {
        return (this.getStatus() & States.TAMED) == States.TAMED;
    }
    
    /**
     * Sets if the creature is wandering.
     */
    public void setTamed(boolean flag, EntityPlayer player)
    {
        if (flag)
        {
            this.setStatus(this.getStatus() | States.TAMED);
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
        }
        else
        {
            this.setStatus(this.getStatus() & ~States.TAMED);
        }
    }
    
    /**
     * Returns true if the creature is sitting.
     */
    public boolean isSitting()
    {
        return (this.getStatus() & States.SITTING) == States.SITTING;
    }
    
    /**
     * Sets if the creature is sitting.
     *
     * @param flag   is the next state that the creature will be (true/false).
     * @param player is the EntityPlayer that will receive the sitting text. Set null to not send the message.
     */
    public void setSitting(boolean flag, EntityPlayer player)
    {
        if (flag && !this.isDefending() && !this.isEating() && !this.isAttacking() && !this.isDrinking() && !this.isPlaying() && !this.isBreeding() && !this.isTakingOff() && !this.isFlying())
        {
            this.setStatus(this.getStatus() | States.SITTING);
            this.isJumping = false;
            this.setPathToEntity((PathEntity) null);
            this.setTarget((Entity) null);
            this.setAttackTarget((EntityLivingBase) null);
            this.handleSittingText(player);
        }
        else
        {
            this.setStatus(this.getStatus() & ~States.SITTING);
            this.handleSittingText(player);
        }
    }
    
    /**
     * Sets true for the sitting state and false for the stressed and defending states.
     */
    public void forceSitting(EntityPlayer player)
    {
        this.setStatus(this.getStatus() & ~States.DEFENDING);
        this.setStatus(this.getStatus() & ~States.ATTACKING);
        this.setStatus(this.getStatus() & ~States.EATING);
        this.setStatus(this.getStatus() & ~States.DRINKING);
        this.setStatus(this.getStatus() & ~States.PLAYING);
        this.setStatus(this.getStatus() & ~States.BREEDING);
        this.setStatus(this.getStatus() & ~States.TAKINGOFF);
        this.setStatus(this.getStatus() & ~States.FLYING);
        this.setStatus(this.getStatus() | States.SITTING);
        this.isJumping = false;
        this.setPathToEntity((PathEntity) null);
        this.setTarget((Entity) null);
        this.setAttackTarget((EntityLivingBase) null);
        this.handleSittingText(player);
    }
    
    /**
     * Shows a text about the sitting state of the creature.
     */
    public void handleSittingText(EntityPlayer player)
    {
        if (player != null)
        {
            if (this.isSitting())
            {
                if (this.hasCustomNameTag())
                {
                    player.addChatMessage(new ChatComponentText(this.getCustomNameTag() + " (" + StatCollector.translateToLocal("entity." + this.getCreature().getCreatureName() + ".name") + ") " + StatCollector.translateToLocal("entity.interaction.isSitting")));
                }
                else
                {
                    player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("entity." + this.getCreature().getCreatureName() + ".name") + " " + StatCollector.translateToLocal("entity.interaction.isSitting")));
                }
            }
            else
            {
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
    
    /**
     * Returns true if the creature is sleeping.
     */
    public boolean isSleeping()
    {
        return (this.getStatus() & States.SLEEPING) == States.SLEEPING;
    }
    
    /**
     * Sets if the creature is sleeping.
     */
    public void setSleeping(boolean flag)
    {
        if (flag && this.isSitting() && !this.isDefending() && !this.isAttacking() && !this.isEating() && !this.isDrinking() && !this.isPlaying() && !this.isBreeding() && !this.isTakingOff() && !this.isFlying())
        {
            this.setStatus(this.getStatus() | States.SLEEPING);
        }
        else
        {
            this.setStatus(this.getStatus() & ~States.SLEEPING);
        }
    }
    
    /**
     * Returns true if the creature is hungry.
     */
    public boolean isHungry()
    {
        return (this.getStatus() & States.HUNGRY) == States.HUNGRY;
    }
    
    /**
     * Sets if the creature is hungry.
     */
    public void setHunger(boolean flag)
    {
        if (flag)
        {
            this.setStatus(this.getStatus() | States.HUNGRY);
        }
        else
        {
            this.setStatus(this.getStatus() & ~States.HUNGRY);
        }
    }
    
    /**
     * Returns true if the creature is stressed.
     */
    public boolean isEating()
    {
        return (this.getStatus() & States.EATING) == States.EATING;
    }
    
    /**
     * Sets if the creature is stressed.
     */
    public void setEating(boolean flag)
    {
        if (flag && !this.isSleeping() && !this.isDefending() && !this.isAttacking() && !this.isSitting() && !this.isDrinking() && !this.isPlaying() && !this.isBreeding() && !this.isTakingOff() && !this.isFlying())
        {
            this.setStatus(this.getStatus() | States.EATING);
        }
        else
        {
            this.setStatus(this.getStatus() & ~States.EATING);
        }
    }
    
    /**
     * Returns true if the creature is thirsty.
     */
    public boolean isThirsty()
    {
        return (this.getStatus() & States.THIRSTY) == States.THIRSTY;
    }
    
    /**
     * Sets if the creature is thirsty.
     */
    public void setThirsty(boolean flag)
    {
        if (flag)
        {
            this.setStatus(this.getStatus() | States.THIRSTY);
        }
        else
        {
            this.setStatus(this.getStatus() & ~States.THIRSTY);
        }
    }
    
    /**
     * Returns true if the creature is stressed.
     */
    public boolean isDrinking()
    {
        return (this.getStatus() & States.DRINKING) == States.DRINKING;
    }
    
    /**
     * Sets if the creature is stressed.
     */
    public void setDrinking(boolean flag)
    {
        if (flag && !this.isSleeping() && !this.isSitting() && !this.isDefending() && !this.isAttacking() && !this.isEating() && !this.isPlaying() && !this.isBreeding() && !this.isTakingOff() && !this.isFlying())
        {
            this.setStatus(this.getStatus() | States.DRINKING);
        }
        else
        {
            this.setStatus(this.getStatus() & ~States.DRINKING);
        }
    }
    
    /**
     * Returns true if the creature is injured.
     */
    public boolean isInjured()
    {
        return (this.getStatus() & States.INJURED) == States.INJURED;
    }
    
    /**
     * Sets if the creature is injured.
     */
    public void setInjured(boolean flag)
    {
        if (flag)
        {
            this.setStatus(this.getStatus() | States.INJURED);
        }
        else
        {
            this.setStatus(this.getStatus() & ~States.INJURED);
        }
    }
    
    /**
     * Returns true if the creature is socializing.
     */
    public boolean isSocializing()
    {
        return (this.getStatus() & States.SOCIALIZING) == States.SOCIALIZING;
    }
    
    /**
     * Sets if the creature is socializing.
     */
    public void setSocializing(boolean flag)
    {
        if (flag && !this.isSleeping() && !this.isDefending() && !this.isAttacking() && !this.isBreeding())
        {
            this.setStatus(this.getStatus() | States.SOCIALIZING);
        }
        else
        {
            this.setStatus(this.getStatus() & ~States.SOCIALIZING);
        }
    }
    
    /**
     * Returns true if the creature is defending itself from some threat.
     */
    public boolean isDefending()
    {
        return (this.getStatus() & States.DEFENDING) == States.DEFENDING;
    }
    
    /**
     * Sets if the creature is defending itself from some threat.
     */
    public void setDefending(boolean flag)
    {
        if (flag && !this.isSleeping())
        {
            this.setStatus(this.getStatus() | States.DEFENDING);
        }
        else
        {
            this.setStatus(this.getStatus() & ~States.DEFENDING);
        }
    }
    
    /**
     * Sets the required number of creature of the same type to attack as group.
     */
    public void setNumberOfAllies(int numberOfAllies)
    {
        this.numberOfAllies = numberOfAllies;
    }
    
    /**
     * Returns the required number of creature of the same type to attack as group.
     */
    public int getNumberOfAllies()
    {
        return this.numberOfAllies;
    }
    
    /**
     * Returns true if the creature is attacking.
     */
    public boolean isAttacking()
    {
        return (this.getStatus() & States.ATTACKING) == States.ATTACKING;
    }
    
    /**
     * Sets if the creature is attacking.
     */
    public void setAttacking(boolean flag)
    {
        if (flag && !this.isSleeping())
        {
            this.setStatus(this.getStatus() | States.ATTACKING);
        }
        else
        {
            this.setStatus(this.getStatus() & ~States.ATTACKING);
        }
    }
    
    /**
     * Returns true if the creature is attacking.
     */
    public boolean isAngry()
    {
        return (this.getStatus() & States.ANGRY) == States.ANGRY;
    }
    
    /**
     * Sets if the creature is attacking.
     */
    public void setAngry(boolean flag)
    {
        if (flag && !this.isSleeping() && !this.isFleeing())
        {
            this.setStatus(this.getStatus() | States.ANGRY);
        }
        else
        {
            this.setStatus(this.getStatus() & ~States.ANGRY);
        }
    }
    
    /**
     * Sets the angry ticks of the creature. When it is positive, it can be reduced each tick
     * using some AI.
     */
    public void setAngerLevel(int angryTicks)
    {
        this.angryTicks = angryTicks;
    }
    
    /**
     * Returns the angry ticks of the creature. Higher than zero means that the creature is
     * attacking.
     */
    public int getAngerLevel()
    {
        return this.angryTicks;
    }
    
    /**
     * Sets the angry level of this creature.
     */
    protected void setCreatureAngry(EntityJurassiCraftAggressive creature, Entity attacker)
    {
        if (attacker instanceof EntityLivingBase)
            creature.becomeAngry((EntityLivingBase) attacker, 0.0F);
    }
    
    /**
     * Sets this creature to attack a target if it has a proper age. If it is also tamed, this will
     * check if the target is tamed by the owner of this creature.
     */
    protected void becomeAngry(EntityLivingBase target, float agePercentage)
    {
        if (this.isCreatureOlderThan(agePercentage))
        {
            if (this.isTamed())
            {
                if (this.checkTargetBeforeAttacking(target))
                {
                    if (this.isSitting())
                        this.setSitting(false, null);
                    this.setAttackTarget(target);
                    this.setAngry(true);
                }
            }
            else
            {
                if (this.isSitting())
                    this.setSitting(false, null);
                this.setAttackTarget(target);
                this.setAngry(true);
            }
        }
    }
    
    /**
     * Returns true if the creature is defending itself from some threat.
     */
    public boolean isFleeing()
    {
        return (this.getStatus() & States.FLEEING) == States.FLEEING;
    }
    
    /**
     * Sets if the creature is defending itself from some threat.
     */
    public void setFleeing(boolean flag)
    {
        if (flag && !this.isSleeping())
        {
            this.setStatus(this.getStatus() | States.FLEEING);
        }
        else
        {
            this.setStatus(this.getStatus() & ~States.FLEEING);
        }
    }
    
    /**
     * Sets the fleeing tick value of the creature. When it is positive, it can be reduced each tick
     * using some AI.
     */
    public void setFleeingTick(int value)
    {
        this.fleeingTick = value;
    }
    
    /**
     * Returns the fleeing ticks of the creature. Higher than zero means that the creature was
     * attacked and it is fleeing.
     */
    public int getFleeingTick()
    {
        return fleeingTick;
    }
    
    /**
     * Sets the creature to flee.
     */
    protected void startFleeing()
    {
        if (this.isSitting())
            this.setSitting(false, null);
        this.setAttackTarget((EntityLivingBase) null);
        this.setFleeing(true);
    }
    
    /**
     * Returns true if the creature was damaged recently.
     */
    public boolean hasBeenHurt()
    {
        return this.hurtTime > 0;
    }
    
    /**
     * Returns true if the creature is defending itself from some threat.
     */
    public boolean isPlaying()
    {
        return (this.getStatus() & States.PLAYING) == States.PLAYING;
    }
    
    /**
     * Sets if the creature is defending itself from some threat.
     */
    public void setPlaying(boolean flag)
    {
        if (flag && !this.isSleeping() && !this.isEating() && !this.isDrinking() && !this.isDefending() && !this.isAttacking() && !this.isTakingOff())
        {
            
            this.setStatus(this.getStatus() | States.PLAYING);
        }
        else
        {
            this.setStatus(this.getStatus() & ~States.PLAYING);
        }
    }
    
    /**
     * Returns true if the creature is defending itself from some threat.
     */
    public boolean isStalking()
    {
        return (this.getStatus() & States.STALKING) == States.STALKING;
    }
    
    /**
     * Sets if the creature is defending itself from some threat.
     */
    public void setStalking(boolean flag)
    {
        if (flag && !this.isSitting() && !this.isSleeping() && !this.isEating() && !this.isDrinking() && !this.isDefending() && !this.isTakingOff() && !this.isFlying())
        {
            this.setStatus(this.getStatus() | States.STALKING);
        }
        else
        {
            this.setStatus(this.getStatus() & ~States.STALKING);
        }
    }
    
    /**
     * Returns true if the creature is defending itself from some threat.
     */
    public boolean isBreeding()
    {
        return (this.getStatus() & States.BREEDING) == States.BREEDING;
    }
    
    /**
     * Sets if the creature is defending itself from some threat.
     */
    public void setBreeding(boolean flag)
    {
        if (flag && !this.isSitting() && !this.isSleeping() && !this.isDefending() && !this.isAttacking() && !this.isEating() && !this.isDrinking() && !this.isTakingOff() && !this.isFlying())
        {
            this.setStatus(this.getStatus() | States.BREEDING);
        }
        else
        {
            this.setStatus(this.getStatus() & ~States.BREEDING);
        }
    }
    
    /**
     * Returns true if the creature is defending itself from some threat.
     */
    public boolean isInLove()
    {
        return (this.getStatus() & States.INLOVE) == States.INLOVE;
    }
    
    /**
     * Sets if the creature is defending itself from some threat.
     */
    public void setInLove(boolean flag)
    {
        if (flag && !this.isSleeping())
        {
            this.setStatus(this.getStatus() | States.INLOVE);
        }
        else
        {
            this.setStatus(this.getStatus() & ~States.INLOVE);
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
    
    /**
     * Clear all states from this creature, except for the injury and tamed state.
     */
    public void clearStatus()
    {
        this.setStatus(this.getStatus() & ~States.SITTING);
        this.setStatus(this.getStatus() & ~States.SLEEPING);
        this.setStatus(this.getStatus() & ~States.HUNGRY);
        this.setStatus(this.getStatus() & ~States.THIRSTY);
        this.setStatus(this.getStatus() & ~States.EATING);
        this.setStatus(this.getStatus() & ~States.DRINKING);
        this.setStatus(this.getStatus() & ~States.SOCIALIZING);
        this.setStatus(this.getStatus() & ~States.DEFENDING);
        this.setStatus(this.getStatus() & ~States.ATTACKING);
        this.setStatus(this.getStatus() & ~States.FLEEING);
        this.setStatus(this.getStatus() & ~States.PLAYING);
        this.setStatus(this.getStatus() & ~States.STALKING);
        this.setStatus(this.getStatus() & ~States.INLOVE);
    }
    
    public EntityJurassiCraftAggressive getClosestEntityAggressive(EntityLivingBase creature, double x, double y, double z)
    {
        List<Entity> list = creature.worldObj.getEntitiesWithinAABBExcludingEntity(creature, creature.boundingBox.expand(x, y, z));
        ArrayList<EntityJurassiCraftAggressive> listOfTargets = new ArrayList<EntityJurassiCraftAggressive>();
        for (Entity entity : list)
        {
            if (entity instanceof EntityJurassiCraftAggressive)
            {
                listOfTargets.add((EntityJurassiCraftAggressive) entity);
            }
        }
        if (!listOfTargets.isEmpty())
        {
            EntityJurassiCraftAggressive closestAggressive = null;
            double distanceSq = x * x + y * y + z * z;
            for (EntityJurassiCraftAggressive closeTarget : listOfTargets)
            {
                double nextDistance = creature.getDistanceSqToEntity(closeTarget);
                if (nextDistance < distanceSq)
                {
                    distanceSq = nextDistance;
                    closestAggressive = closeTarget;
                }
            }
            return closestAggressive;
        }
        return null;
    }
    
    public ArrayList<EntityJurassiCraftAggressive> getClosestEntityAggressiveList(EntityLivingBase creature, double x, double y, double z)
    {
        List<Entity> list = creature.worldObj.getEntitiesWithinAABBExcludingEntity(creature, creature.boundingBox.expand(x, y, z));
        ArrayList<EntityJurassiCraftAggressive> listOfTargets = new ArrayList<EntityJurassiCraftAggressive>();
        for (Entity entity : list)
        {
            if (entity instanceof EntityJurassiCraftAggressive)
                listOfTargets.add((EntityJurassiCraftAggressive) entity);
        }
        return listOfTargets;
    }
    
    public EntityJurassiCraftProtective getClosestEntityProtective(EntityLivingBase creature, double x, double y, double z)
    {
        List<Entity> list = creature.worldObj.getEntitiesWithinAABBExcludingEntity(creature, creature.boundingBox.expand(x, y, z));
        ArrayList<EntityJurassiCraftProtective> listOfTargets = new ArrayList<EntityJurassiCraftProtective>();
        for (Entity entity : list)
        {
            if (entity instanceof EntityJurassiCraftProtective)
            {
                listOfTargets.add((EntityJurassiCraftProtective) entity);
            }
        }
        if (!listOfTargets.isEmpty())
        {
            EntityJurassiCraftProtective closestProtective = null;
            double distanceSq = x * x + y * y + z * z;
            for (EntityJurassiCraftProtective closeTarget : listOfTargets)
            {
                double nextDistance = creature.getDistanceSqToEntity(closeTarget);
                if (nextDistance < distanceSq)
                {
                    distanceSq = nextDistance;
                    closestProtective = closeTarget;
                }
            }
            return closestProtective;
        }
        return null;
    }
    
    public ArrayList<EntityJurassiCraftProtective> getClosestEntityProtectiveList(EntityLivingBase creature, double x, double y, double z)
    {
        List<Entity> list = creature.worldObj.getEntitiesWithinAABBExcludingEntity(creature, creature.boundingBox.expand(x, y, z));
        ArrayList<EntityJurassiCraftProtective> listOfTargets = new ArrayList<EntityJurassiCraftProtective>();
        System.out.println("list " + list);
        for (Entity entity : list)
        {
            if (entity instanceof EntityJurassiCraftProtective)
                listOfTargets.add((EntityJurassiCraftProtective) entity);
        }
        return listOfTargets;
    }
    
    public EntityJurassiCraftCoward getClosestEntityCoward(EntityLivingBase creature, double x, double y, double z)
    {
        List<Entity> list = creature.worldObj.getEntitiesWithinAABBExcludingEntity(creature, creature.boundingBox.expand(x, y, z));
        ArrayList<EntityJurassiCraftCoward> listOfTargets = new ArrayList<EntityJurassiCraftCoward>();
        for (Entity entity : list)
        {
            if (entity instanceof EntityJurassiCraftCoward)
                listOfTargets.add((EntityJurassiCraftCoward) entity);
        }
        if (!listOfTargets.isEmpty())
        {
            EntityJurassiCraftCoward closestCoward = null;
            double distanceSq = x * x + y * y + z * z;
            for (EntityJurassiCraftCoward closeTarget : listOfTargets)
            {
                double nextDistance = creature.getDistanceSqToEntity(closeTarget);
                if (nextDistance < distanceSq)
                {
                    distanceSq = nextDistance;
                    closestCoward = closeTarget;
                }
            }
            return closestCoward;
        }
        return null;
    }
    
    public ArrayList<EntityJurassiCraftCoward> getClosestEntityCowardList(EntityLivingBase creature, double x, double y, double z)
    {
        List<Entity> list = creature.worldObj.getEntitiesWithinAABBExcludingEntity(creature, creature.boundingBox.expand(x, y, z));
        ArrayList<EntityJurassiCraftCoward> listOfTargets = new ArrayList<EntityJurassiCraftCoward>();
        for (Entity entity : list)
        {
            if (entity instanceof EntityJurassiCraftCoward)
                listOfTargets.add((EntityJurassiCraftCoward) entity);
        }
        return listOfTargets;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void handleHealthUpdate(byte flag)
    {
        if (flag == 7)
        {
            this.playTameEffect(true);
        }
        else if (flag == 6)
        {
            this.playTameEffect(false);
        }
        else
        {
            super.handleHealthUpdate(flag);
        }
    }
    
    /**
     * Spawns particles depending on the flag. It is used in vanilla creatures when they are being tamed.
     *
     * @param flag true spawns heart particles, whereas false spawns smoke particles.
     */
    protected void playTameEffect(boolean flag)
    {
        for (int i = 0; i < 7; i++)
        {
            double d0 = this.rand.nextGaussian() * 0.02D;
            double d1 = this.rand.nextGaussian() * 0.02D;
            double d2 = this.rand.nextGaussian() * 0.02D;
            this.worldObj.spawnParticle(flag ? "heart" : "smoke", this.posX + (double) (this.rand.nextFloat() * this.width * 2.0F) - (double) this.width, this.posY + 0.5D + (double) (this.rand.nextFloat() * this.height), this.posZ + (double) (this.rand.nextFloat() * this.width * 2.0F) - (double) this.width, d0, d1, d2);
        }
    }
    
    public String getOwnerName()
    {
        return this.dataWatcher.getWatchableObjectString(16);
    }
    
    public void setOwner(String owner)
    {
        this.dataWatcher.updateObject(16, owner);
    }
    
    /**
     * Returns true if the entity is the creature owner.
     */
    public boolean isOwner(Entity possibleOwner)
    {
        return possibleOwner == this.getOwner();
    }
    
    @Override
    public boolean allowLeashing()
    {
        return !this.getLeashed() && this.isTamed() && !this.isTakingOff() && !this.isFlying();
    }
    
    @Override
    public EntityLivingBase getOwner()
    {
        return this.worldObj.getPlayerEntityByName(this.getOwnerName());
    }
    
    @Override
    public Team getTeam()
    {
        if (this.isTamed())
        {
            EntityLivingBase owner = this.getOwner();
            if (owner != null)
                return owner.getTeam();
        }
        return super.getTeam();
    }
    
    @Override
    public boolean isOnSameTeam(EntityLivingBase creature)
    {
        if (this.isTamed())
        {
            EntityLivingBase owner = this.getOwner();
            if (creature == owner)
                return true;
            if (owner != null)
                return owner.isOnSameTeam(creature);
        }
        return super.isOnSameTeam(creature);
    }
    
    @Override
    public String func_152113_b()
    {
        return null;
    }
    
    /**
     * Returns true if the target of this creature is not the owner or other creature from the same
     * owner or same species or riding or being ridden by this creature.
     */
    public boolean checkTargetBeforeAttacking(EntityLivingBase target)
    {
        if (target.riddenByEntity == this || this.riddenByEntity == target || target.ridingEntity != null)
            return false;
        
        if (target == (Entity) null || target == this || target == this.getOwner())
        {
            if (target instanceof EntityJurassiCraftSmart)
            {
                return !this.isOwner(((EntityJurassiCraftSmart) target).getOwner());
            }
            else
            {
                return true;
            }
        }
        return false;
    }
    
    /**
     * This is a separated entity living base that can be set in order to add attacks or animations.
     *
     * @param creature is the target;
     */
    public void setCreatureToAttack(EntityLivingBase creature)
    {
        if (creature != this)
            this.creatureToAttack = creature;
    }
    
    /**
     * This is a separated entity living base that can be set in order to add attacks or animations
     */
    public EntityLivingBase getCreatureToAttack()
    {
        return this.creatureToAttack;
    }
    
    @Override
    public void writeEntityToNBT(NBTTagCompound compound)
    {
        super.writeEntityToNBT(compound);
        compound.setInteger("Status", this.getStatus());
        compound.setInteger("FleeingTick", this.getFleeingTick());
        compound.setInteger("AngerLevel", this.getAngerLevel());
        if (this.getOwnerName() != null)
        {
            compound.setString("Owner", this.getOwnerName());
        }
        else
        {
            compound.setString("Owner", "");
        }
    }
    
    @Override
    public void readEntityFromNBT(NBTTagCompound compound)
    {
        super.readEntityFromNBT(compound);
        if (compound.hasKey("Status"))
            this.setStatus(compound.getInteger("Status"));
        if (compound.hasKey("FleeingTick"))
            this.setFleeingTick(compound.getInteger("FleeingTick"));
        if (compound.hasKey("AngerLevel"))
            this.setAngerLevel(compound.getInteger("AngerLevel"));
        if (compound.hasKey("Owner"))
        {
            String ownerName = compound.getString("Owner");
            if (ownerName != null && ownerName.length() > 0)
            {
                this.setOwner(ownerName);
            }
        }
        else
        {
            this.setOwner("");
        }
    }
}
