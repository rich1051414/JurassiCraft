package net.ilexiconn.jurassicraft.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.ilexiconn.jurassicraft.api.Properties;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

/**
 * @author ProPercivalalb
 **/
public class ItemGrindingStones extends Item
{
    public static IIcon grindingStone;
    public static IIcon ironGrindingBall;
    
    public ItemGrindingStones()
    {
        super();
        this.setCreativeTab(null);
        this.setMaxStackSize(1);
        this.setHasSubtypes(true);
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IIconRegister iconRegister)
    {
        this.grindingStone = iconRegister.registerIcon(Properties.TEX_PACKAGE + "GrindingStone");
        this.ironGrindingBall = iconRegister.registerIcon(Properties.TEX_PACKAGE + "IronGrindingBall");
    }
    
    public IIcon getIconFromDamage(int damage)
    {
        switch (damage)
        {
            case 0:
                return this.grindingStone;
            case 1:
                return this.ironGrindingBall;
            default:
                return null;
        }
    }
    
    @Override
    public String getUnlocalizedName(ItemStack stack)
    {
        return super.getUnlocalizedName() + "." + stack.getItemDamage();
    }
}
