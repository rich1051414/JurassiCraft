package net.ilexiconn.jurassicraft.item;

import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.ModCreativeTabs;
import net.ilexiconn.jurassicraft.block.BlockFossilOre;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ToolFossilBreaker extends ItemPickaxe
{

    public ToolFossilBreaker(ToolMaterial material, String toolName, int durability)
    {
        super(material);
        this.setMaxDamage(durability);
        this.setMaxStackSize(1);
        setUnlocalizedName(toolName);
        setTextureName(JurassiCraft.getModId() + toolName);
        setCreativeTab(ModCreativeTabs.items);
    }

    @Override
    public boolean onBlockDestroyed(ItemStack itemStack, World world, Block block, int x, int y, int z, EntityLivingBase entity)
    {
        if (!world.isRemote)
        {
            if (itemStack != null)
            {
                if (world.getBlock(x, y, z) instanceof BlockFossilOre)
                {
                    /*
					 * TileEntity tileentity = world.getTileEntity(x, y, z); if
					 * (tileentity instanceof TileEntityEncasedFossilBlock) {
					 * TileEntityEncasedFossilBlock tileEntityfossil =
					 * (TileEntityEncasedFossilBlock) tileentity; ItemStack
					 * fossil = new ItemStack(FHItems.itemDEXEncasedFossil, 1,
					 * (tileEntityfossil.getFossilID())); Entity fossilEntity =
					 * new EntityItem(world, x, y, z, fossil);
					 * world.spawnEntityInWorld(fossilEntity);
					 * world.removeTileEntity(x, y, z); world.setBlockToAir(x,
					 * y, z); if (itemStack.getItemDamage() >=
					 * itemStack.getMaxDamage()) { itemStack.stackSize--; } else
					 * { itemStack.setItemDamage(itemStack.getItemDamage() + 1);
					 * } return true; }
					 */
                }
                else if (world.getBlock(x, y, z) instanceof Block)
                {
                    if (itemStack.getItemDamage() >= itemStack.getMaxDamage())
                    {
                        itemStack.stackSize--;
                    }
                    else
                    {
                        itemStack.setItemDamage(itemStack.getItemDamage() + 1);
                    }
                    return true;
                }
            }
        }
        return false;
    }
}
