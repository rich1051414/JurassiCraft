package net.ilexiconn.jurassicraft.block;

import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.ModItems;
import net.ilexiconn.jurassicraft.tile.TileDinoPad;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import java.util.Random;

public class BlockDinoPad extends Block implements ITileEntityProvider
{
    
    public BlockDinoPad()
    {
        super(Material.iron);
        this.setTickRandomly(true);
        this.setBlockName("dinoPad");
        this.setHardness(0.0F);
        this.setResistance(0.0F);
        this.setStepSound(Block.soundTypeStone);
        this.setBlockBounds(0.1F, 0.0F, 0.1F, 0.9F, 0.2F, 0.9F);
        this.setBlockTextureName(JurassiCraft.getModId() + "dnaExtractorBreakingParticles");
    }
    
    @Override
    public boolean hasTileEntity(int metadata)
    {
        return true;
    }
    
    @Override
    public int getRenderType()
    {
        return -1;
    }
    
    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }
    
    @Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }
    
    @Override
    public int quantityDropped(int metadata, int fortune, Random random)
    {
        return 0;
    }
    
    @Override
    public void breakBlock(World world, int x, int y, int z, Block block, int metadata)
    {
        TileEntity tileentity = (TileEntity) world.getTileEntity(x, y, z);
        if (tileentity instanceof TileDinoPad)
        {
            TileDinoPad dinopad = (TileDinoPad) tileentity;
            float x1 = world.rand.nextFloat() * 0.8F + 0.1F;
            float y1 = world.rand.nextFloat() * 0.8F + 0.1F;
            float z1 = world.rand.nextFloat() * 0.8F + 0.1F;
            ItemStack itemStack = new ItemStack(ModItems.dinoPad);
            EntityItem entityPlanks = new EntityItem(world, (double) ((float) x + x1), (double) ((float) y + y1), (double) ((float) z + z1), itemStack);
            world.spawnEntityInWorld(entityPlanks);
        }
        super.breakBlock(world, x, y, z, block, metadata);
    }
    
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int hitX, float hitY, float hitZ, float f)
    {
        if (player.getHeldItem() != null)
        {
            return false;
        }
        else
        {
            world.removeTileEntity(x, y, z);
            world.setBlockToAir(x, y, z);
            player.inventory.addItemStackToInventory(new ItemStack(ModItems.dinoPad, 1));
            return true;
        }
    }
    
    @Override
    public void updateTick(World world, int x, int y, int z, Random rand)
    {
        this.canBlockStay(world, x, y, z);
    }
    
    @Override
    public boolean canPlaceBlockAt(World world, int x, int y, int z)
    {
        return !super.canPlaceBlockAt(world, x, y, z) ? false : this.canBlockStay(world, x, y, z);
    }
    
    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block)
    {
        if (!this.canBlockStay(world, x, y, z))
        {
            world.spawnEntityInWorld(new EntityItem(world, x, y, z, new ItemStack(ModItems.dinoPad, 1)));
            world.removeTileEntity(x, y, z);
            world.setBlockToAir(x, y, z);
        }
    }
    
    @Override
    public boolean canBlockStay(World world, int x, int y, int z)
    {
        return world.getBlock(x, y - 1, z).getMaterial().isSolid();
    }
    
    @Override
    public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z)
    {
        return new ItemStack(ModItems.dinoPad, 1);
    }
    
    @Override
    public TileEntity createNewTileEntity(World world, int metadata)
    {
        try
        {
            return new TileDinoPad();
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
}
