package net.ilexiconn.jurassicraft.block;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.ModBlocks;
import net.ilexiconn.jurassicraft.ModCreativeTabs;
import net.ilexiconn.jurassicraft.tile.TileCultivate;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

public class BlockCultivateBottom extends BlockContainer
{
    public static String[] colors = {"black", "red", "green", "brown", "blue", "purple", "cyan", "light_gray", "gray", "pink", "lime", "yellow", "light_blue", "magenta", "orange", "white"};
    @SideOnly(Side.CLIENT)
    public IIcon[] icons;
    public boolean isLit;

    public BlockCultivateBottom(boolean lit)
    {
        super(Material.cactus); // Yes..., Cactus xD
        setBlockName("cultivate_bottom_" + (lit ? "lit" : "idle"));
        setBlockTextureName(JurassiCraft.getModId() + "cultivate");
        setCreativeTab(lit ? null : ModCreativeTabs.blocks);
        setHardness(2f);
        setBlockBounds(0f, 0f, 0f, 1f, 2f, 1f);
        if (lit) setLightLevel(1.0f);
        isLit = lit;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {
        if (meta < 0 || meta >= colors.length) meta = 0;
        return icons[meta];
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs tab, List list)
    {
        for (int i = 0; i < colors.length; i++)
            list.add(new ItemStack(item, 1, i));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        icons = new IIcon[colors.length];

        for (int i = 0; i < colors.length; i++)
        {
            String name = getTextureName();

            if (colors[i] != null) name = name + "_" + colors[i];

            icons[i] = iconRegister.registerIcon(name);
        }
    }

    @Override
    public int damageDropped(int meta)
    {
        return meta;
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
    public boolean isOpaqueCube()
    {
        return false;
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
            TileEntity tileEntity = world.getTileEntity(x, y, z);
            if (tileEntity instanceof TileCultivate)
            {
                TileCultivate tileCultivate = (TileCultivate) tileEntity;
                if (tileCultivate.isUseableByPlayer(player))
                {
                    player.openGui(JurassiCraft.instance, 0, world, x, y, z);
                    return true;
                }
                else
                {
                    FMLClientHandler.instance().getClient().thePlayer.openGui(JurassiCraft.instance, 1, world, x, y, z);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Item getItemDropped(int meta, Random random, int fortune)
    {
        return Item.getItemFromBlock(ModBlocks.cultivateBottomOff);
    }

    @Override
    public void breakBlock(World world, int x, int y, int z, Block oldblock, int oldMetadata)
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
                world.func_147453_f(x, y, z, oldblock);
            }
        }
        world.setBlockToAir(x, y + 1, z);
        super.breakBlock(world, x, y, z, oldblock, oldMetadata);
    }

    @Override
    public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int meta)
    {
        world.setBlockToAir(x, y + 1, z);
        world.removeTileEntity(x, y + 1, z);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Item getItem(World world, int x, int y, int z)
    {
        return Item.getItemFromBlock(ModBlocks.cultivateBottomOff);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta)
    {
        return new TileCultivate();
    }

    @Override
    public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB box, List list, Entity entity)
    {
        AxisAlignedBB[] aabbs = BlockCultivate.boxes[1];
        for (AxisAlignedBB aabb : aabbs)
        {
            AxisAlignedBB aabbTmp = aabb.getOffsetBoundingBox(x, y, z);
            if (box.intersectsWith(aabbTmp)) list.add(aabbTmp);
        }
    }

    @Override
    public MovingObjectPosition collisionRayTrace(World world, int x, int y, int z, Vec3 origin, Vec3 direction)
    {
        AxisAlignedBB[] aabbs = BlockCultivate.boxes[1];
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
