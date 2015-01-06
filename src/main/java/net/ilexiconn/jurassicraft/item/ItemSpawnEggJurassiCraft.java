package net.ilexiconn.jurassicraft.item;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map.Entry;

import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.ModCreativeTabs;
import net.ilexiconn.jurassicraft.entity.Creature;
import net.ilexiconn.jurassicraft.entity.CreatureManager;
import net.ilexiconn.jurassicraft.entity.EntityJurassiCraftCreature;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.Facing;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemSpawnEggJurassiCraft extends Item {

	public ItemSpawnEggJurassiCraft() {
		this.setUnlocalizedName("spawnEgg");
		this.setTextureName(JurassiCraft.getModId() + "egg_Generic");
		this.setCreativeTab(ModCreativeTabs.spawnEggs);
		this.setHasSubtypes(true);
	}

	@Override
	public void addInformation(ItemStack egg, EntityPlayer player, List list, boolean flag) {
		if (egg.hasTagCompound()) {
			if (egg.getTagCompound().hasKey("SpawnBaby")) {
				if (egg.getTagCompound().getBoolean("SpawnBaby")) {
					list.add(EnumChatFormatting.GRAY + StatCollector.translateToLocal("item.egg.info.spawnBaby"));
					list.add(EnumChatFormatting.GRAY + StatCollector.translateToLocal("item.egg.info.changeToAdult"));
				} else {
					list.add(EnumChatFormatting.GRAY + StatCollector.translateToLocal("item.egg.info.spawnAdult"));
					list.add(EnumChatFormatting.GRAY + StatCollector.translateToLocal("item.egg.info.changeToBaby"));
				}
			}
		} else {
			list.add(EnumChatFormatting.GRAY + StatCollector.translateToLocal("item.egg.info.spawnAdult"));
			list.add(EnumChatFormatting.GRAY + StatCollector.translateToLocal("item.egg.info.changeToBaby"));
		}
	}

	@Override
	public ItemStack onItemRightClick(ItemStack egg, World world, EntityPlayer player) {
		if (egg.hasTagCompound()) {
			if (egg.getTagCompound().hasKey("SpawnBaby")) {
				boolean flag = egg.getTagCompound().getBoolean("SpawnBaby");
				egg.getTagCompound().removeTag("SpawnBaby");
				egg.getTagCompound().setBoolean("SpawnBaby", !flag);
				if (egg.getTagCompound().getBoolean("SpawnBaby")) {
					if (!world.isRemote) {
						player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("item.egg.info.spawnSetToBaby")));
					}
				} else {
					if (!world.isRemote) {
						player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("item.egg.info.spawnSetToAdult")));
					}
				}
			} else {
				egg.getTagCompound().setBoolean("SpawnBaby", true);
				if (!world.isRemote) {
					player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("item.egg.info.spawnSetToBaby")));
				}
			}
		} else {
			NBTTagCompound compound = new NBTTagCompound();
			compound.setBoolean("SpawnBaby", true);
			egg.setTagCompound(compound);
			if (egg.getTagCompound().getBoolean("SpawnBaby")) {
				if (!world.isRemote) {
					player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("item.egg.info.spawnSetToBaby")));
				}
			} else {
				if (!world.isRemote) {
					player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("item.egg.info.spawnSetToAdult")));
				}
			}
		}
		return egg;
	}

	@Override
	public String getItemStackDisplayName(ItemStack itemStack) {
		return StatCollector.translateToLocal(this.getUnlocalizedName() + "_" + CreatureManager.getCreatureFromId(itemStack.getItemDamage()).getCreatureName() + ".name").trim();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getColorFromItemStack(ItemStack itemStack, int metadata) {
		return 0;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item item, CreativeTabs tab, List list) {
		for (Entry<Class<?>, Creature> creature : CreatureManager.getCreatures().entrySet()) {
			list.add(new ItemStack(item, 1, creature.getValue().getCreatureID()));
		}
	}

	@Override
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int hitX, float hitY, float hitZ, float metadata) {
		if (!world.isRemote) {
			return true;
		} else {
			Block block = world.getBlock(x, y, z);
			x += Facing.offsetsXForSide[hitX];
			y += Facing.offsetsYForSide[hitX];
			z += Facing.offsetsZForSide[hitX];
			double yTranslation = 0.0D;
			if (hitX == 1 && block.getRenderType() == 11) {
				yTranslation = 0.5D;
			}
			EntityJurassiCraftCreature creature = (EntityJurassiCraftCreature) spawnCreature(world, player, itemStack, (double) x + 0.5D, (double) y + yTranslation, (double) z + 0.5D);
			if (creature != null) {
				if (creature instanceof EntityLivingBase && itemStack.hasDisplayName()) {
					((EntityLiving) creature).setCustomNameTag(itemStack.getDisplayName());
				}
				if (!player.capabilities.isCreativeMode) {
					itemStack.stackSize--;
					if (itemStack.stackSize <= 0) {
						itemStack = (ItemStack) null;
					}
				}
				world.spawnEntityInWorld(creature);
				creature.playLivingSound();
			}
			return true;
		}
	}

	public static EntityJurassiCraftCreature spawnCreature(World world, EntityPlayer player, ItemStack egg, double x, double y, double z) {
		Class creatureClass = CreatureManager.getCreatureClass(egg.getItemDamage());
		try {
			Entity creatureToSpawn = (Entity) creatureClass.getConstructor(World.class).newInstance(player.worldObj);
			if (creatureToSpawn instanceof EntityJurassiCraftCreature) {
				EntityJurassiCraftCreature creature = (EntityJurassiCraftCreature) creatureToSpawn;
				creature.setGenetics(100, JurassiCraftDNAHandler.createDefaultDNA());
				creature.setPosition(x, y, z);
				creature.setLocationAndAngles(x, y, z, MathHelper.wrapAngleTo180_float(world.rand.nextFloat() * 360.0F), 0.0F);
				creature.rotationYawHead = creature.rotationYaw;
				creature.renderYawOffset = creature.rotationYaw;
				if (egg.hasTagCompound()) {
					if (egg.getTagCompound().hasKey("SpawnBaby")) {
						if (!egg.getTagCompound().getBoolean("SpawnBaby")) {
							creature.setFullGrowth();
						}
					} else {
						creature.setFullGrowth();
					}
				} else {
					creature.setFullGrowth();
				}
				return creature;
			}
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		return (EntityJurassiCraftCreature) null;
	}
}
