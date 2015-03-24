package net.ilexiconn.jurassicraft.inventory;

import net.ilexiconn.jurassicraft.recipe.CarboniferousRecipes;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotGrindingStone extends Slot
{
    public SlotGrindingStone(IInventory inventory, int par3, int par4, int par5)
    {
        super(inventory, par3, par4, par5);
    }
    
    @Override
    public boolean isItemValid(ItemStack stack)
    {
        if (stack == null)
            return false;
        
        int durability = CarboniferousRecipes.getComponentDurability(stack);
      
        if (durability != -1 || durability != 0)
        {
            return true;
        }
        
        return false;
    }
}
