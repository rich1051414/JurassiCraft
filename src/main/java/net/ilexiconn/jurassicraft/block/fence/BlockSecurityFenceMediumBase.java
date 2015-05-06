package net.ilexiconn.jurassicraft.block.fence;

import net.ilexiconn.jurassicraft.ModCreativeTabs;
import net.ilexiconn.jurassicraft.interfaces.IFenceBase;
import net.ilexiconn.jurassicraft.tile.fence.TileSecurityFenceMediumBase;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockSecurityFenceMediumBase extends BlockSecurityFence implements IFenceBase
{
    public BlockSecurityFenceMediumBase()
    {
        super(10.0F, 150.0F, 2, "low_Security_Fence_Base");
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
        this.setCreativeTab(ModCreativeTabs.blocks);
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
    public TileEntity createNewTileEntity(World world, int metadata)
    {
        return new TileSecurityFenceMediumBase();
    }
}
