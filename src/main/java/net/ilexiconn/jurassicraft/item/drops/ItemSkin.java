package net.ilexiconn.jurassicraft.item.drops;

import java.util.List;

import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.ModCreativeTabs;
import net.ilexiconn.jurassicraft.item.ItemDNA;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemSkin extends ItemGenericDNASource
{
	@SideOnly(Side.CLIENT)
	IIcon[] icons = new IIcon[2];
	
    public ItemSkin(String name)
    {
        super(name, "Skin");
        this.setCreativeTab(ModCreativeTabs.items);
		this.setHasSubtypes(true);
    }

    public ItemDNA getCorrespondingDNA()
    {
        return this.getCorrespondingDNA("Skin");
    }

	@Override
	public String getItemStackDisplayName(ItemStack itemStack) 
	{
		return StatCollector.translateToLocal(itemStack.getUnlocalizedName() + (itemStack.getItemDamage() == 0 ? "_Male.name" : "_Female.name")).trim();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int i)
	{
		return this.icons[i];
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item item, CreativeTabs tab, List list) 
	{
		list.add(new ItemStack(item, 1, 0));
		//list.add(new ItemStack(item, 1, 1));
	}

	@Override
	@SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iIconRegister)
    {
		this.icons[0] = iIconRegister.registerIcon(JurassiCraft.getModId() + "creature/" + this.getUnlocalizedName().substring(5, this.getUnlocalizedName().length()) + "_Male");
		//this.icons[1] = iIconRegister.registerIcon(JurassiCraft.getModId() + "creature/" + this.getUnlocalizedName().substring(5, this.getUnlocalizedName().length()) + "_Female");
    }
}
