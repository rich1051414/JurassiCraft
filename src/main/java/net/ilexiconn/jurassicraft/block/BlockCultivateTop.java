package net.ilexiconn.jurassicraft.block;

import java.util.List;
import java.util.Random;

import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.ModBlocks;
import net.ilexiconn.jurassicraft.tile.TileCultivate;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockCultivateTop extends Block
{
    @SideOnly(Side.CLIENT)
    public static final IIcon[] icons = new IIcon[ItemDye.field_150921_b.length];
    public boolean isLit;

    public BlockCultivateTop(boolean lit)
    {
        super(Material.cactus);
        this.setBlockName("cultivate_top_" + (lit ? "lit" : "idle"));
        this.setBlockTextureName(JurassiCraft.getModId() + "cultivate");
        this.setCreativeTab(null);
        this.setHardness(2.0F);
        this.setBlockBounds(0.0F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        if (lit) setLightLevel(1.0F);
        this.isLit = lit;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int metadata)
    {
        return this.icons[metadata % this.icons.length];
    }

    public static int getColor(int metadata)
    {
        return ~metadata & 15;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        for (int i = 0; i < this.icons.length; i++)
            this.icons[i] = iconRegister.registerIcon(this.getTextureName() + "_" + ItemDye.field_150921_b[this.getColor(i)]);
    }

    @Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    @Override
    public int getRenderType()
    {
        return -1;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass()
    {
        return 1;
    }

    @Override
    public Item getItemDropped(int metadata, Random random, int fortune)
    {
        return Item.getItemFromBlock(ModBlocks.cultivateBottomOff);
    }

    @Override
    public void breakBlock(World world, int x, int y, int z, Block block, int metadata)
    {
        TileEntity tileEntity = world.getTileEntity(x, y, z);
        if (tileEntity instanceof TileCultivate)
        {
            TileCultivate tileCultivate = (TileCultivate) tileEntity;
            if (tileCultivate.hasItems())
            {
                for (int i = 0; i < tileCultivate.getSizeInventory(); i++)
                {
                    ItemStack itemstack = tileCultivate.getStackInSlot(i);
                    if (itemstack != null)
                    {
                        float f = world.rand.nextFloat() * 0.8F + 0.1F;
                        float f1 = world.rand.nextFloat() * 0.8F + 0.1F;
                        float f2 = world.rand.nextFloat() * 0.8F + 0.1F;
                        while (itemstack.stackSize > 0)
                        {
                            int j = world.rand.nextInt(21) + 10;
                            if (j > itemstack.stackSize)
                            {
                                j = itemstack.stackSize;
                            }
                            itemstack.stackSize -= j;
                            EntityItem item = new EntityItem(world, (double) ((float) x + f), (double) ((float) y + f1), (double) ((float) z + f2), new ItemStack(itemstack.getItem(), j, itemstack.getItemDamage()));
                            if (itemstack.hasTagCompound())
                            {
                                item.getEntityItem().setTagCompound((NBTTagCompound) itemstack.getTagCompound().copy());
                            }
                            world.spawnEntityInWorld(item);
                        }
                    }
                }
                world.func_147453_f(x, y, z, block);
            }
        }
        super.breakBlock(world, x, y, z, block, metadata);
    }

    @Override
    public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int meta)
    {
        world.setBlockToAir(x, y - 1, z);
        world.removeTileEntity(x, y - 1, z);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Item getItem(World world, int x, int y, int z)
    {
        return Item.getItemFromBlock(ModBlocks.cultivateBottomOff);
    }

    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }

    @Override
    public int damageDropped(int i)
    {
        return i;
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int metadata, float t, float h, float k)
    {
        if (world.isRemote)
        {
            return true;
        }
        else if (!player.isSneaking())
        {
            TileEntity tileEntity = world.getTileEntity(x, y - 1, z);
            if (tileEntity instanceof TileCultivate)
            {
                TileCultivate tileCultivate = (TileCultivate) tileEntity;
                if (tileCultivate.isUseableByPlayer(player) && !tileCultivate.isHatching())
                {
                    player.openGui(JurassiCraft.instance, 0, world, x, y - 1, z);
                    return true;
                }
                else
                {
                	player.openGui(JurassiCraft.instance, 1, world, x, y - 1, z);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB box, List list, Entity entity)
    {
        AxisAlignedBB[] aabbs = BlockCultivate.boxes[0];
        for (AxisAlignedBB aabb : aabbs)
        {
            AxisAlignedBB aabbTmp = aabb.getOffsetBoundingBox(x, y, z);
            if (box.intersectsWith(aabbTmp)) list.add(aabbTmp);
        }
    }

    @Override
    public MovingObjectPosition collisionRayTrace(World world, int x, int y, int z, Vec3 origin, Vec3 direction)
    {
        AxisAlignedBB[] aabbs = BlockCultivate.boxes[0];
        MovingObjectPosition closest = null;
        for (AxisAlignedBB aabb : aabbs)
        {
            MovingObjectPosition mop = aabb.getOffsetBoundingBox(x, y, z).calculateIntercept(origin, direction);
            if (mop != null)
            {
                if (closest != null && mop.hitVec.distanceTo(origin) < closest.hitVec.distanceTo(origin)) closest = mop;
                else closest = mop;
            }
        }
        if (closest != null)
        {
            closest.blockX = x;
            closest.blockY = y;
            closest.blockZ = z;
        }
        return closest;
    }
}
