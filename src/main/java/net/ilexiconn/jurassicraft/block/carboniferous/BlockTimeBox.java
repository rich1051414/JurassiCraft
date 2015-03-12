package net.ilexiconn.jurassicraft.block.carboniferous;

import net.ilexiconn.jurassicraft.ModCreativeTabs;
import net.ilexiconn.jurassicraft.ModItems;
import net.ilexiconn.jurassicraft.api.Properties;
import net.ilexiconn.jurassicraft.world.core.TeleporterDino;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

/**
 * @author ProPercivalalb
 **/
public class BlockTimeBox extends Block {

	public static IIcon activeIcon;
	
	public BlockTimeBox() {
		super(Material.iron);
		this.setCreativeTab(ModCreativeTabs.Carboniferous);
	}
	
	public IIcon getBlockTexture(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5) {
        if(this.isActive(par1IBlockAccess, par2, par3, par4)) {return activeIcon;}
        return blockIcon;
    }

	@Override
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {
		ItemStack stack = par5EntityPlayer.getCurrentEquippedItem();
		if(stack != null && stack.getItem() == ModItems.multiItems && stack.getItemDamage() == 5) {
			if(this.isActive(par1World, par2, par3, par4)) {
				TeleporterDino.formPortal(par1World, par2, par3 + 1, par4, false);
			}
			else {
				TeleporterDino.formPortal(par1World, par2, par3 + 1, par4, true);
			}
		}
		return true;
	}
	
	public boolean isActive(IBlockAccess par1World, int par2, int par3, int par4) {
		return par1World.getBlockMetadata(par2, par3, par4) == 1;
	}
	
	@Override
	public void registerBlockIcons(IIconRegister par1IconRegister) {
		this.blockIcon = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "timebox0");
		this.activeIcon = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "timebox1");
	}
}
