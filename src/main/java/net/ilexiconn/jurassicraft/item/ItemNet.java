package net.ilexiconn.jurassicraft.item;

import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.texture.*;
import cpw.mods.fml.relauncher.*;
import net.ilexiconn.jurassicraft.*;

public class ItemNet extends Item
{
    public static IIcon iconNet;

    public ItemNet() {
        super();
        this.setMaxDamage(60);
        setUnlocalizedName("net");
        setTextureName(net.ilexiconn.jurassicraft.Util.getModId() + "net");
        setCreativeTab(ModCreativeTabs.items);
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(final IIconRegister par1IconRegister) {
        ItemNet.iconNet = par1IconRegister.registerIcon("jurassicraft:net");
    }

    public IIcon getIconFromDamage(final int par1) {
        return ItemNet.iconNet;
    }

    public boolean isRepairable() {
        return true;
    }
}
