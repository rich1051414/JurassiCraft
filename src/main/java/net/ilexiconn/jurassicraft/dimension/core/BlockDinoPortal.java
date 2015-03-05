package net.ilexiconn.jurassicraft.dimension.core;

import java.util.Random;

import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.ModBlocks;
import net.ilexiconn.jurassicraft.ModCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.BlockPortal;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.Direction;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockDinoPortal extends BlockBreakable
{
	public static final int[][] field_150001_a = new int[][] {new int[0], {3, 1}, {2, 0}};

	public BlockDinoPortal()
	{
		super("", Material.portal, false);
		this.setTickRandomly(true);
		this.setCreativeTab(ModCreativeTabs.blocks);
	}

	/**
	 * Ticks the block if it's been scheduled
	 */
	public void updateTick(World world, int x, int y, int z, Random rand)
	{
		super.updateTick(world, x, y, z, rand);

		if (world.provider.isSurfaceWorld() && world.getGameRules().getGameRuleBooleanValue("doMobSpawning") && rand.nextInt(2000) < world.difficultySetting.getDifficultyId())
		{
			int l;

			for (l = y; !World.doesBlockHaveSolidTopSurface(world, x, l, z) && l > 0; --l)
			{
				;
			}

			if (l > 0 && !world.getBlock(x, l + 1, z).isNormalCube())
			{
				Entity entity = ItemMonsterPlacer.spawnCreature(world, 57, (double)x + 0.5D, (double)l + 1.1D, (double)z + 0.5D);

				if (entity != null)
				{
					entity.timeUntilPortal = entity.getPortalCooldown();
				}
			}
		}
	}

	/**
	 * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
	 * cleared to be reused)
	 */
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
	{
		return null;
	}

	/**
	 * Updates the blocks bounds based on its current state. Args: world, x, y, z
	 */
	public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z)
	{
		int rot = getRotation(world.getBlockMetadata(x, y, z));

		if (rot == 0)
		{
			if (world.getBlock(x - 1, y, z) != this && world.getBlock(x + 1, y, z) != this)
			{
				rot = 2;
			}
			else
			{
				rot = 1;
			}

			if (world instanceof World && !((World)world).isRemote)
			{
				((World)world).setBlockMetadataWithNotify(x, y, z, rot, 2);
			}
		}

		float f = 0.125F;
		float f1 = 0.125F;

		if (rot == 1)
		{
			f = 0.5F;
		}

		if (rot == 2)
		{
			f1 = 0.5F;
		}

		this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f1, 0.5F + f, 1.0F, 0.5F + f1);
	}

	/**
	 * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
	 */
	public boolean renderAsNormalBlock()
	{
		return false;
	}

	/**
	 * Returns true if the given side of this block type should be rendered, if the adjacent block is at the given
	 * coordinates.  Args: blockAccess, x, y, z, side
	 */
	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockAccess world, int x, int y, int z, int side)
	{
		int i1 = 0;

		if (world.getBlock(x, y, z) == this)
		{
			i1 = getRotation(world.getBlockMetadata(x, y, z));

			if (i1 == 0)
			{
				return false;
			}

			if (i1 == 2 && side != 5 && side != 4)
			{
				return false;
			}

			if (i1 == 1 && side != 3 && side != 2)
			{
				return false;
			}
		}

		boolean flag = world.getBlock(x - 1, y, z) == this && world.getBlock(x - 2, y, z) != this;
		boolean flag1 = world.getBlock(x + 1, y, z) == this && world.getBlock(x + 2, y, z) != this;
		boolean flag2 = world.getBlock(x, y, z - 1) == this && world.getBlock(x, y, z - 2) != this;
		boolean flag3 = world.getBlock(x, y, z + 1) == this && world.getBlock(x, y, z + 2) != this;
		boolean flag4 = flag || flag1 || i1 == 1;
		boolean flag5 = flag2 || flag3 || i1 == 2;

		return flag4 && side == 4 ? true : (flag4 && side == 5 ? true : (flag5 && side == 2 ? true : flag5 && side == 3));
	}

	/**
	 * Returns the quantity of items to drop on block destruction.
	 */
	public int quantityDropped(Random rand)
	{
		return 0;
	}

	/**
	 * Triggered whenever an entity collides with this block (enters into the block). Args: world, x, y, z, entity
	 */
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
	{
		Random rand = new Random();
		
		int transport = rand.nextInt(1000);
		
		if(transport == 1)
		{
			if (entity.ridingEntity == null && entity.riddenByEntity == null)
			{
				if (entity instanceof EntityPlayerMP)
				{
					EntityPlayerMP thePlayer = (EntityPlayerMP) entity;
					if (entity.dimension != JurassiCraft.dimensionID)
					{
						thePlayer.mcServer.getConfigurationManager().transferPlayerToDimension(thePlayer, JurassiCraft.dimensionID, new TeleporterDino(thePlayer.mcServer.worldServerForDimension(JurassiCraft.dimensionID)));
					}
					else
					{
						thePlayer.mcServer.getConfigurationManager().transferPlayerToDimension(thePlayer, 0, new TeleporterDino(thePlayer.mcServer.worldServerForDimension(0)));
					}
				}
			}
		}
		else
		{
			double d0 = (double)((float)x + rand.nextFloat());
			double d1 = (double)((float)y + rand.nextFloat());
			double d2 = (double)((float)z + rand.nextFloat());
			double d3 = 0.0D;
			double d4 = 0.0D;
			double d5 = 0.0D;
			int i1 = rand.nextInt(2) * 2 - 1;
			d3 = ((double)rand.nextFloat() - 0.5D) * 0.5D;
			d4 = ((double)rand.nextFloat() - 0.5D) * 0.5D;
			d5 = ((double)rand.nextFloat() - 0.5D) * 0.5D;
			world.spawnParticle("enchantmenttable", d0, d1, d2, d3, d4, d5);
			world.spawnParticle("enchantmenttable", d0, d1+1, d2, d3, d4, d5);
			world.spawnParticle("enchantmenttable", d0, d1+1, d2, d3, d4, d5);
			world.spawnParticle("enchantmenttable", d0, d1+1, d2, d3, d4, d5);
			world.spawnParticle("enchantmenttable", d0, d1, d2, d3, d4, d5);
			world.spawnParticle("enchantmenttable", d0, d1, d2, d3, d4, d5);
			world.spawnParticle("enchantmenttable", d0, d1, d2, d3, d4, d5);
			world.spawnParticle("enchantmenttable", d0, d1+1, d2, d3, d4, d5);
			world.spawnParticle("enchantmenttable", d0, d1+1, d2, d3, d4, d5);
			world.spawnParticle("enchantmenttable", d0, d1+1, d2, d3, d4, d5);
			world.spawnParticle("enchantmenttable", d0, d1, d2, d3, d4, d5);
			world.spawnParticle("enchantmenttable", d0, d1, d2, d3, d4, d5);
		}
	}

	/**
	 * Returns which pass should this block be rendered on. 0 for solids and 1 for alpha
	 */
	@SideOnly(Side.CLIENT)
	public int getRenderBlockPass()
	{
		return 1;
	}

	/**
	 * A randomly called display update to be able to add particles or other items for display
	 */
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World p_149734_1_, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random p_149734_5_)
	{
		if (p_149734_5_.nextInt(100) == 0)
		{
			p_149734_1_.playSound((double)p_149734_2_ + 0.5D, (double)p_149734_3_ + 0.5D, (double)p_149734_4_ + 0.5D, "lom:trexlive", 10.5F, p_149734_5_.nextFloat() * 0.4F + 0.8F, false);
		}

		for (int l = 0; l < 4; ++l)
		{
			double d0 = (double)((float)p_149734_2_ + p_149734_5_.nextFloat());
			double d1 = (double)((float)p_149734_3_ + p_149734_5_.nextFloat());
			double d2 = (double)((float)p_149734_4_ + p_149734_5_.nextFloat());
			double d3 = 0.0D;
			double d4 = 0.0D;
			double d5 = 0.0D;
			int i1 = p_149734_5_.nextInt(2) * 2 - 1;
			d3 = ((double)p_149734_5_.nextFloat() - 0.5D) * 9.5D;
			d4 = ((double)p_149734_5_.nextFloat() - 0.5D) * 9.5D;
			d5 = ((double)p_149734_5_.nextFloat() - 0.5D) * 9.5D;

			if (p_149734_1_.getBlock(p_149734_2_ - 1, p_149734_3_, p_149734_4_) != this && p_149734_1_.getBlock(p_149734_2_ + 1, p_149734_3_, p_149734_4_) != this)
			{
				d0 = (double)p_149734_2_ + 0.5D + 0.25D * (double)i1;
				d3 = (double)(p_149734_5_.nextFloat() * 2.0F * (float)i1);
			}
			else
			{
				d2 = (double)p_149734_4_ + 0.5D + 0.25D * (double)i1;
				d5 = (double)(p_149734_5_.nextFloat() * 2.0F * (float)i1);
			}

			//   p_149734_1_.spawnParticle("reddust", d0 +1 , d1, d2 +1, d3, d4, d5);
			//  p_149734_1_.spawnParticle("reddust", d0 -1 , d1, d2 -1, d3, d4, d5);
		}
	}

	public static int getRotation(int p_149999_0_)
	{
		return p_149999_0_ & 3;
	}

	/**
	 * Gets an item for the block being called on. Args: world, x, y, z
	 */
	@SideOnly(Side.CLIENT)
	public Item getItem(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_)
	{
		return Item.getItemById(0);
	}

	public static class Size
	{
		private final World field_150867_a;
		private final int field_150865_b;
		private final int field_150866_c;
		private final int field_150863_d;
		private int field_150864_e = 0;
		private ChunkCoordinates field_150861_f;
		private int field_150862_g;
		private int field_150868_h;
		private static final String __OBFID = "CL_00000285";

		public Size(World p_i45415_1_, int p_i45415_2_, int p_i45415_3_, int p_i45415_4_, int p_i45415_5_)
		{
			this.field_150867_a = p_i45415_1_;
			this.field_150865_b = p_i45415_5_;
			this.field_150863_d = BlockPortal.field_150001_a[p_i45415_5_][0];
			this.field_150866_c = BlockPortal.field_150001_a[p_i45415_5_][1];

			for (int i1 = p_i45415_3_; p_i45415_3_ > i1 - 21 && p_i45415_3_ > 0 && this.func_150857_a(p_i45415_1_.getBlock(p_i45415_2_, p_i45415_3_ - 1, p_i45415_4_)); --p_i45415_3_)
			{
				;
			}

			int j1 = this.func_150853_a(p_i45415_2_, p_i45415_3_, p_i45415_4_, this.field_150863_d) - 1;

			if (j1 >= 0)
			{
				this.field_150861_f = new ChunkCoordinates(p_i45415_2_ + j1 * Direction.offsetX[this.field_150863_d], p_i45415_3_, p_i45415_4_ + j1 * Direction.offsetZ[this.field_150863_d]);
				this.field_150868_h = this.func_150853_a(this.field_150861_f.posX, this.field_150861_f.posY, this.field_150861_f.posZ, this.field_150866_c);

				if (this.field_150868_h < 2 || this.field_150868_h > 21)
				{
					this.field_150861_f = null;
					this.field_150868_h = 0;
				}
			}

			if (this.field_150861_f != null)
			{
				this.field_150862_g = this.func_150858_a();
			}
		}

		protected int func_150853_a(int p_150853_1_, int p_150853_2_, int p_150853_3_, int p_150853_4_)
		{
			int j1 = Direction.offsetX[p_150853_4_];
			int k1 = Direction.offsetZ[p_150853_4_];
			int i1;
			Block block;

			for (i1 = 0; i1 < 22; ++i1)
			{
				block = this.field_150867_a.getBlock(p_150853_1_ + j1 * i1, p_150853_2_, p_150853_3_ + k1 * i1);

				if (!this.func_150857_a(block))
				{
					break;
				}

				Block block1 = this.field_150867_a.getBlock(p_150853_1_ + j1 * i1, p_150853_2_ - 1, p_150853_3_ + k1 * i1);

				if (block1 != Blocks.stonebrick)
				{
					break;
				}
			}

			block = this.field_150867_a.getBlock(p_150853_1_ + j1 * i1, p_150853_2_, p_150853_3_ + k1 * i1);
			return block == Blocks.stonebrick ? i1 : 0;
		}

		protected int func_150858_a()
		{
			int i;
			int j;
			int k;
			int l;
			label56:

				for (this.field_150862_g = 0; this.field_150862_g < 21; ++this.field_150862_g)
				{
					i = this.field_150861_f.posY + this.field_150862_g;

					for (j = 0; j < this.field_150868_h; ++j)
					{
						k = this.field_150861_f.posX + j * Direction.offsetX[BlockPortal.field_150001_a[this.field_150865_b][1]];
						l = this.field_150861_f.posZ + j * Direction.offsetZ[BlockPortal.field_150001_a[this.field_150865_b][1]];
						Block block = this.field_150867_a.getBlock(k, i, l);

						if (!this.func_150857_a(block))
						{
							break label56;
						}

						if (block == ModBlocks.dinoPortal)
						{
							++this.field_150864_e;
						}

						if (j == 0)
						{
							block = this.field_150867_a.getBlock(k + Direction.offsetX[BlockPortal.field_150001_a[this.field_150865_b][0]], i, l + Direction.offsetZ[BlockPortal.field_150001_a[this.field_150865_b][0]]);

							if (block != Blocks.stonebrick)
							{
								break label56;
							}
						}
						else if (j == this.field_150868_h - 1)
						{
							block = this.field_150867_a.getBlock(k + Direction.offsetX[BlockPortal.field_150001_a[this.field_150865_b][1]], i, l + Direction.offsetZ[BlockPortal.field_150001_a[this.field_150865_b][1]]);

							if (block != Blocks.stonebrick)
							{
								break label56;
							}
						}
					}
				}

			for (i = 0; i < this.field_150868_h; ++i)
			{
				j = this.field_150861_f.posX + i * Direction.offsetX[BlockPortal.field_150001_a[this.field_150865_b][1]];
				k = this.field_150861_f.posY + this.field_150862_g;
				l = this.field_150861_f.posZ + i * Direction.offsetZ[BlockPortal.field_150001_a[this.field_150865_b][1]];

				if (this.field_150867_a.getBlock(j, k, l) != Blocks.stonebrick)
				{
					this.field_150862_g = 0;
					break;
				}
			}

			if (this.field_150862_g <= 21 && this.field_150862_g >= 3)
			{
				return this.field_150862_g;
			}
			else
			{
				this.field_150861_f = null;
				this.field_150868_h = 0;
				this.field_150862_g = 0;
				return 0;
			}
		}

		protected boolean func_150857_a(Block p_150857_1_)
		{
			return p_150857_1_.getMaterial() == Material.air || p_150857_1_ == Blocks.fire || p_150857_1_ == ModBlocks.dinoPortal;
		}

		public boolean func_150860_b()
		{
			return this.field_150861_f != null && this.field_150868_h >= 2 && this.field_150868_h <= 21 && this.field_150862_g >= 3 && this.field_150862_g <= 21;
		}

		public void func_150859_c()
		{
			for (int i = 0; i < this.field_150868_h; ++i)
			{
				int j = this.field_150861_f.posX + Direction.offsetX[this.field_150866_c] * i;
				int k = this.field_150861_f.posZ + Direction.offsetZ[this.field_150866_c] * i;

				for (int l = 0; l < this.field_150862_g; ++l)
				{
					int i1 = this.field_150861_f.posY + l;
					this.field_150867_a.setBlock(j, i1, k, ModBlocks.dinoPortal, this.field_150865_b, 2);
				}
			}
		}
	}
	public boolean tryToCreatePortal(World par1World, int par2, int par3, int par4)
	{
		byte b0 = 0;
		byte b1 = 0;
		if (par1World.getBlock(par2 - 1, par3, par4) == Blocks.stonebrick || par1World.getBlock(par2 + 1, par3, par4) == Blocks.stonebrick)
		{
			b0 = 1;
		}
		if (par1World.getBlock(par2, par3, par4 - 1) == Blocks.stonebrick || par1World.getBlock(par2, par3, par4 + 1) == Blocks.stonebrick)
		{
			b1 = 1;
		}
		if (b0 == b1)
		{
			return false;
		}
		else
		{
			if (par1World.getBlock(par2 - b0, par3, par4 - b1) == Blocks.air)
			{
				par2 -= b0;
				par4 -= b1;
			}
			int l;
			int i1;
			for (l = -1; l <= 2; ++l)
			{
				for (i1 = -1; i1 <= 3; ++i1)
				{
					boolean flag = l == -1 || l == 2 || i1 == -1 || i1 == 3;
					if (l != -1 && l != 2 || i1 != -1 && i1 != 3)
					{
						Block j1 = par1World.getBlock(par2 + b0 * l, par3 + i1, par4 + b1 * l);
						if (flag)
						{
							if (j1 != Blocks.stonebrick)
							{
								return false;
							}
						}
						else if (j1 != Blocks.air && j1 != ModBlocks.keyStone)
						{
							return false;
						}
					}
				}
			}
			for (l = 0; l < 2; ++l)
			{
				for (i1 = 0; i1 < 3; ++i1)
				{
					par1World.setBlock(par2 + b0 * l, par3 + i1, par4 + b1 * l, ModBlocks.dinoPortal, 0, 2);
				}
			}
			return true;
		}
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister)
	{

		blockIcon = iconRegister.registerIcon(JurassiCraft.getModId() + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
	}

}