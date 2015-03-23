package net.ilexiconn.jurassicraft.block.carboniferous;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.ilexiconn.jurassicraft.api.Properties;
import net.minecraft.block.BlockSand;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

/**
 * @author ProPercivalalb
 **/
public class BlockCarboniferousSand extends BlockSand
{
    
    public BlockCarboniferousSand()
    {
        super();
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int metadata)
    {
        return this.blockIcon;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        this.blockIcon = iconRegister.registerIcon(Properties.TEX_PACkAGE + "sand");
    }
}
