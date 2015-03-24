package net.ilexiconn.jurassicraft.block.carboniferous;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.api.Properties;
import net.ilexiconn.jurassicraft.tile.TileEntityCompressor;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

/**
 * @author ProPercivalalb
 **/
public class BlockCompressor extends BlockTileEntity
{
    public static IIcon iconSideGrinder;
    
    public BlockCompressor()
    {
        super(Material.rock);
        this.setCreativeTab(null);
    }
    
    @Override
    public TileEntity createNewTileEntity(World world, int meta)
    {
        return new TileEntityCompressor();
    }
    
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
    {
        if (world.isRemote)
        {
            return true;
        }
        else
        {
            TileEntityCompressor tileentitygrinder = (TileEntityCompressor) world.getTileEntity(x, y, z);
            
            if (tileentitygrinder != null)
            {
                player.openGui(JurassiCraft.instance, Properties.GUI_ID_COMPRESSER, world, x, y, z);
            }
            
            return true;
        }
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(int side, int metadata)
    {
        if (side == 1)
        {
            return this.blockIcon;
        }
        
        return this.iconSideGrinder;
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon(Properties.TEX_PACKAGE + "topGrinder");
        this.iconSideGrinder = par1IconRegister.registerIcon(Properties.TEX_PACKAGE + "sideGrinder");
    }
    
    @Override
    public int getRenderType()
    {
        return Properties.RENDER_GRINDER;
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
    
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLiving player, ItemStack stack)
    {
        super.onBlockPlacedBy(world, x, y, z, player, stack);
       
        int side = MathHelper.floor_double((double) (player.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
        
        if (side == 0)
        {
            world.setBlockMetadataWithNotify(x, y, z, 2, 2);
        }
        
        if (side == 1)
        {
            world.setBlockMetadataWithNotify(x, y, z, 5, 2);
        }
        
        if (side == 2)
        {
            world.setBlockMetadataWithNotify(x, y, z, 3, 2);
        }
        
        if (side == 3)
        {
            world.setBlockMetadataWithNotify(x, y, z, 4, 2);
        }
    }
}
