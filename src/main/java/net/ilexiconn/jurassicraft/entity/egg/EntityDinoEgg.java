package net.ilexiconn.jurassicraft.entity.egg;

import io.netty.buffer.ByteBuf;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Random;

import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.client.gui.GuiDinoPadEgg;
import net.ilexiconn.jurassicraft.entity.Creature;
import net.ilexiconn.jurassicraft.entity.CreatureManager;
import net.ilexiconn.jurassicraft.entity.EntityJurassiCraftCreature;
import net.ilexiconn.jurassicraft.entity.EntityJurassiCraftTameable;
import net.ilexiconn.jurassicraft.item.ItemDinoPad;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public class EntityDinoEgg extends Entity implements IEntityAdditionalSpawnData
{
    public Creature creature;
    public int spawnTime;
    public int currentSpawnTime;
    public boolean froze;
    public boolean dried;
    public int quality;
    private String dnaSequence;
    public int rockAmount;

    public EntityDinoEgg(World world)
    {
        super(world);
        this.setSize(0.5F, 0.5F);
        this.stepHeight = 1F;
    }

    public EntityDinoEgg(World world, Creature creature, int spawnTime)
    {
        this(world);
        this.creature = creature;
        this.spawnTime = spawnTime;
    }

    public EntityDinoEgg(World world, Creature creature, int quality, String dna, int spawnTime, double x, double y, double z)
    {
        this(world, creature, spawnTime);
        this.setPosition(x + 0.5F, y, z + 0.5F);
        this.quality = quality;
        this.dnaSequence = dna;
    }

    public boolean attackEntityFrom(DamageSource damage, float amount)
    {
        if (!this.isEntityInvulnerable())
        {
            if (this.worldObj.isRemote)
            {
                if (amount > 0)
                {
                    Minecraft mc = Minecraft.getMinecraft();

                    Random random = new Random();

                    for (int currentParticle = 0; currentParticle < 50; ++currentParticle)
                    {
                        float f3 = MathHelper.randomFloatClamp(random, 0.0F, ((float) Math.PI * 2F));
                        double d5 = (double) MathHelper.randomFloatClamp(random, 0.75F, 1.0F);
                        double velY = 0.20000000298023224D + 1 / 100.0D;
                        double velX = (double) (MathHelper.cos(f3) * 0.2F) * d5 * d5 * (1 + 0.2D);
                        double velZ = (double) (MathHelper.sin(f3) * 0.2F) * d5 * d5 * (1 + 0.2D);
                        mc.theWorld.spawnParticle("blockdust_" + Block.getIdFromBlock(Blocks.sandstone) + "_0", (double) ((float) this.posX), (double) ((float) this.posY), (double) ((float) this.posZ), velX, velY, velZ);
                    }
                }
            }
            this.setDead();
        }
        return super.attackEntityFrom(damage, amount);
    }

    /**
     * Returns a boundingBox used to collide the entity with other entities and blocks. This enables the entity to be
     * pushable on contact, like boats or minecarts.
     */
    public AxisAlignedBB getCollisionBox(Entity entity)
    {
        return entity.boundingBox;
    }

    /**
     * returns the bounding box for this entity
     */
    public AxisAlignedBB getBoundingBox()
    {
        return null;
    }

    public boolean canBePushed()
    {
        return true;
    }

    public boolean canBeCollidedWith()
    {
        return !this.isDead;
    }

    protected boolean canTriggerWalking()
    {
        return false;
    }

    public void onUpdate()
    {
        super.onUpdate();

        if (!this.isDead)
        {
        	if (this.worldObj.isRemote)
            {
                if (this.dataWatcher.getWatchableObjectInt(25) == 0)
                {
                	this.froze = false;
                }
                else
                {
                	this.froze = true;
                }

                if (this.dataWatcher.getWatchableObjectInt(26) == 0)
                {
                	this.dried = false;
                }
                else
                {
                	this.dried = true;
                }

                this.currentSpawnTime = this.dataWatcher.getWatchableObjectInt(27);
            }

            if (!this.onGround)
            {
                this.motionY -= 0.05F;
            }

            if (this.motionY < -0.8F)
            {
                this.motionY = -0.8F;
            }

            if (this.onGround)
            {
                this.motionX *= 0.5F;
                this.motionZ *= 0.5F;
            }
            else
            {
                this.motionX *= 0.7F;
                this.motionZ *= 0.7F;
            }

            if (!this.worldObj.isRemote)
            {
                int amountToIncrease = 0;

                List<EggEnviroment> enviroments = EggEnviroment.getEnviroments(this);

                boolean wet = enviroments.contains(EggEnviroment.WET);

                boolean warm = enviroments.contains(EggEnviroment.WARM);

                boolean overheat = enviroments.contains(EggEnviroment.OVERHEAT);

                boolean cold = enviroments.contains(EggEnviroment.COLD);
                
				if (this.creature.isWaterCreature())
                {
                    if (!wet)
                    {
                        if (overheat)
                        {
                            amountToIncrease = -2;
                        }
                        else
                        {
                            amountToIncrease = -1;
                        }
                    }
                    else
                    {
                        amountToIncrease = 2;
                    }
                }
                else
                {
                    if (warm && !wet)
                    {
                        amountToIncrease = 1;
                    }
                    else
                    {
                        if (cold && wet)
                        {
                            amountToIncrease = -2;
                        }
                        else
                        {
                            amountToIncrease = -1;
                        }
                    }
                }

				this.currentSpawnTime += amountToIncrease;

                if (this.currentSpawnTime < -500)
                {
                    if (this.creature.isWaterCreature())
                    {
                    	this.dried = true;
                    }
                    else
                    {
                    	this.froze = true;
                    }
                }

                if (this.currentSpawnTime >= this.spawnTime)
                {
                    Class dinoToSpawnClass = CreatureManager.getCreatureClass(this.creature.getCreatureID());

                    try
                    {
                        Entity dinoToSpawn = (Entity) dinoToSpawnClass.getConstructor(World.class).newInstance(this.worldObj);
                        if (dinoToSpawn instanceof EntityJurassiCraftCreature)
                        {
                        	EntityJurassiCraftCreature baby = (EntityJurassiCraftCreature) dinoToSpawn;
                        	baby.setGenetics(this.quality, this.dnaSequence);
                        	if (dinoToSpawn instanceof EntityJurassiCraftTameable && ((EntityJurassiCraftTameable) baby).canBeTamedUponSpawning()) {
                        		EntityPlayer owner = this.worldObj.getClosestPlayerToEntity(this, 6.0F);
                            	if (owner != null) {
                            		((EntityJurassiCraftTameable) baby).setTamed(true);
                        			((EntityJurassiCraftTameable) baby).setOwner(owner.getCommandSenderName());
                                    this.worldObj.setEntityState((EntityJurassiCraftTameable) baby, (byte) 7);
                                }
                            }
                            baby.setPosition(this.posX, this.posY, this.posZ);
                            this.worldObj.spawnEntityInWorld(baby);
  //                          baby.setNoGrowth();
                            this.currentSpawnTime = 0;
                            this.setDead();
                        }
                    }
                    catch (InstantiationException e)
                    {
                        e.printStackTrace();
                    }
                    catch (IllegalAccessException e)
                    {
                        e.printStackTrace();
                    }
                    catch (IllegalArgumentException e)
                    {
                        e.printStackTrace();
                    }
                    catch (InvocationTargetException e)
                    {
                        e.printStackTrace();
                    }
                    catch (NoSuchMethodException e)
                    {
                        e.printStackTrace();
                    }
                    catch (SecurityException e)
                    {
                        e.printStackTrace();
                    }
                }
            }

            if (this.currentSpawnTime < (this.spawnTime - 100))
            {
                if (!this.dried && !this.froze)
                {
                    if (this.rotationPitch >= 5)
                    {
                    	this.rockAmount = -1;
                    }
                    else if (this.rotationPitch <= -5)
                    {
                    	this.rockAmount = 1;
                    }

                    this.rotationPitch += (this.rockAmount / 2.0F);
                }
            }

            if (!this.worldObj.isRemote)
            {
                this.dataWatcher.updateObject(25, this.froze ? 1 : 0);
                this.dataWatcher.updateObject(26, this.dried ? 1 : 0);
                this.dataWatcher.updateObject(27, this.currentSpawnTime);
            }

            this.moveEntity(this.motionX, this.motionY, this.motionZ);
        }
    }

    public void fall(float fallDistance)
    {
        super.fall(fallDistance);

        if (fallDistance > 10 && this.onGround)
        {
            attackEntityFrom(DamageSource.fall, 1F);
        }
    }

    @Override
    protected void entityInit()
    {
        this.dataWatcher.addObject(25, 0);
        this.dataWatcher.addObject(26, 0);
        this.dataWatcher.addObject(27, this.rockAmount);
    }

    @Override
	public void readEntityFromNBT(NBTTagCompound nbt)
    {
        this.spawnTime = nbt.getInteger("SpawnTime");
        this.currentSpawnTime = nbt.getInteger("CurrentSpawnTime");
        this.creature = CreatureManager.getCreatureFromId(nbt.getInteger("CreatureID"));
        this.froze = nbt.getBoolean("Froze");
        this.dried = nbt.getBoolean("Dried");
        this.quality = nbt.getInteger("Quality");
        this.dnaSequence = nbt.getString("DNASequence");
    }

    @Override
	public void writeEntityToNBT(NBTTagCompound nbt)
    {
        nbt.setInteger("SpawnTime", this.spawnTime);
        nbt.setInteger("CurrentSpawnTime", this.currentSpawnTime);
        nbt.setInteger("CreatureID", this.creature.getCreatureID());
        nbt.setBoolean("Froze", this.froze);
        nbt.setBoolean("Dried", this.dried);
        nbt.setInteger("Quality", this.quality);
        nbt.setString("DNASequence", this.dnaSequence);
    }

    public ResourceLocation getTexture()
    {
        return new ResourceLocation(JurassiCraft.getModId() + "textures/eggs/egg" + this.creature.getCreatureName() + ".png");
    }

    public int getHatchingProgressScaled(int i)
    {
    	if (this.spawnTime > 0) {
			return (int) (i * this.currentSpawnTime / this.spawnTime);
    	}
        return 0;
    }

    public boolean isHatchingDone()
    {
        return (this.currentSpawnTime >= this.spawnTime);
    }

    public int getDNAQuality()
    {
        return this.quality;
    }

    public String getDNASequence()
    {
        return this.dnaSequence;
    }

    @Override
    public boolean interactFirst(EntityPlayer player)
    {
		if (player.getHeldItem() != (ItemStack) null)
		{
			if (player.getHeldItem().getItem() instanceof ItemDinoPad) 
			{
				this.showStatus();
			}
		} else {
            ItemStack itemStack = new ItemStack(this.creature.getEgg());
            if (!player.worldObj.isRemote) {
                NBTTagCompound compound = new NBTTagCompound();
                compound.setInteger("EggQuality", this.quality);
                compound.setString("EggDNA", this.dnaSequence);
                itemStack.setTagCompound(compound);
                if (player.inventory.addItemStackToInventory(itemStack))
                {
                    this.worldObj.playSoundAtEntity(player, "random.pop", 0.2F, ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.7F + 1.0F) * 2.0F);
                    this.setDead();
                }
            }
		}
        return true;
    }

	@SideOnly(Side.CLIENT)
	private void showStatus()
	{
		GuiDinoPadEgg.eggToAnalyze = this;
		FMLClientHandler.instance().getClient().thePlayer.openGui(JurassiCraft.instance, 51, this.worldObj, 0, 0, 0);
	}

    @Override
    public void writeSpawnData(ByteBuf buffer)
    {
        buffer.writeInt(this.creature.getCreatureID());
    }

    @Override
    public void readSpawnData(ByteBuf additionalData)
    {
    	this.creature = CreatureManager.getCreatureFromId(additionalData.readInt());
    }
}
