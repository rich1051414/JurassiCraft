package net.ilexiconn.jurassicraft.item;

import net.ilexiconn.jurassicraft.ModItems;
import net.ilexiconn.jurassicraft.api.Properties;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemFood;
import net.minecraft.util.IIcon;

public class ItemAnt extends ItemFood
{
    public ItemAnt(int par2, float par3)
    {
        super(par2, par3, false);
        this.setCreativeTab(null);
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IIconRegister par1IconRegister)
    {
        if (this == ModItems.cookedAnt)
        {
            this.itemIcon = par1IconRegister.registerIcon(Properties.TEX_PACKAGE + "cookedAnt");
        }
        else
        {
            this.itemIcon = par1IconRegister.registerIcon(Properties.TEX_PACKAGE + "ant");
        }
    }
    
    @Override
    public IIcon getIconFromDamage(int meta)
    {
        return this.itemIcon;
    }
}
