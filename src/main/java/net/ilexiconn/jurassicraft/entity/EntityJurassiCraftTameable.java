package net.ilexiconn.jurassicraft.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.ilexiconn.jurassicraft.ai.JurassiCraftEntityAISit;
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
import net.minecraft.world.World;

public class EntityJurassiCraftTameable extends EntityJurassiCraftCreature implements IEntityOwnable
{

    protected JurassiCraftEntityAISit aiSit = new JurassiCraftEntityAISit(this);
    //DataWatchers: Owner = 14, Tamed Related = 15;

    public EntityJurassiCraftTameable(World world, Creature creature)
    {
        super(world, creature);
        this.setTamed(false);
    }

    @Override
    protected void entityInit()
    {
        super.entityInit();
        this.dataWatcher.addObject(15, Byte.valueOf((byte) 0));
        this.dataWatcher.addObject(14, "");
    }

    @Override
    protected boolean canDespawn()
    {
        return false;
    }

    @Override
    public boolean interact(EntityPlayer player)
    {
        ItemStack heldItemStack = player.inventory.getCurrentItem();
        if (heldItemStack != null && !(heldItemStack.getItem() instanceof ItemGrowthSerum) && !(heldItemStack.getItem() instanceof ItemDinoPad) && !(heldItemStack.getItem() instanceof ItemOnAStick))
        {
            if (this.getCreature().isFavoriteFood(heldItemStack.getItem()))
            {
                if ((double) (this.getHealth() + 3.0F) <= this.getCreatureHealth())
                {
                    if (!player.capabilities.isCreativeMode)
                    {
                        heldItemStack.stackSize--;
                    }
                    if (heldItemStack.stackSize <= 0)
                    {
                        player.inventory.setInventorySlotContents(player.inventory.currentItem, (ItemStack) null);
                    }
                    this.heal(3.0F);
                }
                else
                {
                    if (!this.isTamed() && !this.worldObj.isRemote)
                    {
                        if (!player.capabilities.isCreativeMode)
                        {
                            heldItemStack.stackSize--;
                        }
                        if (heldItemStack.stackSize <= 0)
                        {
                            player.inventory.setInventorySlotContents(player.inventory.currentItem, (ItemStack) null);
                        }
                        if (this.rand.nextInt(4) == 0)
                        {
                            this.setTamed(true);
                            this.setPathToEntity((PathEntity) null);
                            this.setAttackTarget((EntityLivingBase) null);
                            this.aiSit.setSitting(true);
                            this.setOwner(player.getCommandSenderName());
                            this.playTameEffect(true);
                            this.worldObj.setEntityState(this, (byte) 7);
                            player.addChatMessage(new ChatComponentText("You tamed this creature!"));
                            player.addChatMessage(new ChatComponentText(this.getCreature().getCreatureName() + " is sitting."));
                        }
                        else
                        {
                            this.playTameEffect(true);
                            this.worldObj.setEntityState(this, (byte) 6);
                        }
                    }
                }
            }
            else if (this.isTamed() && this.isOwner(player) && !this.worldObj.isRemote)
            {
                if (!this.isSitting())
                {
                    this.isJumping = false;
                    this.setPathToEntity((PathEntity) null);
                    this.setTarget((Entity) null);
                    this.setAttackTarget((EntityLivingBase) null);
                    this.aiSit.setSitting(true);
                    this.setSitting(true);
                    player.addChatMessage(new ChatComponentText(this.getCreature().getCreatureName() + " is sitting."));
                }
                else
                {
                    this.aiSit.setSitting(false);
                    this.setSitting(false);
                    player.addChatMessage(new ChatComponentText(this.getCreature().getCreatureName() + " is not sitting anymore."));
                }
            }
            return super.interact(player);
        }
        else if (heldItemStack == null && this.isTamed() && this.isOwner(player) && !this.worldObj.isRemote)
        {
            if (!this.isSitting())
            {
                this.isJumping = false;
                this.setPathToEntity((PathEntity) null);
                this.setTarget((Entity) null);
                this.setAttackTarget((EntityLivingBase) null);
                this.aiSit.setSitting(true);
                this.setSitting(true);
                player.addChatMessage(new ChatComponentText(this.getCreature().getCreatureName() + " is sitting."));
            }
            else
            {
                this.aiSit.setSitting(false);
                this.setSitting(false);
                player.addChatMessage(new ChatComponentText((this.getCreature().getCreatureName() + " is not sitting anymore.")));
            }
        }
        return super.interact(player);
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

    protected void playTameEffect(boolean flag)
    {
        String s = "heart";
        if (!flag)
        {
            s = "smoke";
        }
        for (int i = 0; i < 7; ++i)
        {
            double d0 = this.rand.nextGaussian() * 0.02D;
            double d1 = this.rand.nextGaussian() * 0.02D;
            double d2 = this.rand.nextGaussian() * 0.02D;
            this.worldObj.spawnParticle(s, this.posX + (double) (this.rand.nextFloat() * this.width * 2.0F) - (double) this.width, this.posY + 0.5D + (double) (this.rand.nextFloat() * this.height), this.posZ + (double) (this.rand.nextFloat() * this.width * 2.0F) - (double) this.width, d0, d1, d2);
        }
    }

    public boolean canBeTamedUponSpawning()
    {
        return this.getCreature().canBeTamedUponSpawning();
    }

    public boolean isTamed()
    {
        return (this.dataWatcher.getWatchableObjectByte(15) & 4) != 0;
    }

    public void setTamed(boolean shouldTame)
    {
        byte b0 = this.dataWatcher.getWatchableObjectByte(15);
        if (shouldTame)
        {
            this.dataWatcher.updateObject(15, Byte.valueOf((byte) (b0 | 4)));
        }
        else
        {
            this.dataWatcher.updateObject(15, Byte.valueOf((byte) (b0 & -5)));
        }
    }

    public JurassiCraftEntityAISit getAiSit()
    {
        return this.aiSit;
    }

    public boolean isSitting()
    {
        return (this.dataWatcher.getWatchableObjectByte(15) & 1) != 0;
    }

    public void setSitting(boolean shouldSit)
    {
        byte b0 = this.dataWatcher.getWatchableObjectByte(15);

        if (shouldSit)
        {
            this.dataWatcher.updateObject(15, Byte.valueOf((byte) (b0 | 1)));
        }
        else
        {
            this.dataWatcher.updateObject(15, Byte.valueOf((byte) (b0 & -2)));
        }
    }

    public String getOwnerName()
    {
        return this.dataWatcher.getWatchableObjectString(14);
    }

    public void setOwner(String owner)
    {
        this.dataWatcher.updateObject(14, owner);
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
        return !this.getLeashed() && this.isTamed();
    }

    /**
     * Returns true if the target is not the owner of this creature or other creature from the same owner.
     */
    public boolean checkTarget(Entity target)
    {
        if (target != (Entity) null && target != this && target != this.getOwner())
        {
            if (target instanceof EntityJurassiCraftTameable)
            {
                return ((EntityJurassiCraftTameable) target).getOwner() != this.getOwner();
            }
            else
            {
                return true;
            }
        }
        else
        {
            return false;
        }
    }

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
            {
                return owner.getTeam();
            }
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
            {
                return true;
            }
            if (owner != null)
            {
                return owner.isOnSameTeam(creature);
            }
        }
        return super.isOnSameTeam(creature);
    }

    @Override
    public String func_152113_b()
    {
        return null;
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound compound)
    {
        super.writeEntityToNBT(compound);
        if (this.getOwnerName() == null)
        {
            compound.setString("Owner", "");
        }
        else
        {
            compound.setString("Owner", this.getOwnerName());
        }
        compound.setBoolean("Sitting", this.isSitting());
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound compound)
    {
        super.readEntityFromNBT(compound);
        String s = compound.getString("Owner");
        if (s.length() > 0)
        {
            this.setOwner(s);
            this.setTamed(true);
        }
        this.aiSit.setSitting(compound.getBoolean("Sitting"));
        this.setSitting(compound.getBoolean("Sitting"));
    }
}