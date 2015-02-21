package net.ilexiconn.jurassicraft;

import cpw.mods.fml.common.registry.GameRegistry;
import net.ilexiconn.jurassicraft.block.BlockCultivateBottom;
import net.ilexiconn.jurassicraft.content.IContentHandler;
import net.ilexiconn.jurassicraft.entity.Creature;
import net.ilexiconn.jurassicraft.entity.CreatureManager;
import net.ilexiconn.jurassicraft.item.ItemMeat;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ModRecipes implements IContentHandler
{
    public void init()
    {
        GameRegistry.addSmelting(ModBlocks.gypsumCobblestone, new ItemStack(ModBlocks.gypsumBlock, 1), 5);

        for (int i = 0; i < BlockCultivateBottom.iconVariationsNames.length; i++)
        {
            int correction = BlockCultivateBottom.iconVariationsNames.length - i - 1;
            GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.cultivateBottomOff, 1, i), "GIG", "G G", "III", 'I', Items.iron_ingot, 'G', new ItemStack(Blocks.stained_glass_pane, 1, correction));
        }

        for (Creature creature : CreatureManager.getCreatures())
        {
            ItemMeat meat = creature.getMeat();
            if (meat != null)
            {
                GameRegistry.addShapelessRecipe(new ItemStack(ModItems.growthSerum, 1), new ItemStack(Items.dye, 1, 2), new ItemStack(Items.golden_carrot, 1), new ItemStack(Items.water_bucket, 1), new ItemStack(meat, 1));
            }
        }

        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.securityFenceLowCorner, 1), "SSS", "SIS", "SSS", 'I', Blocks.iron_block, 'S', Blocks.stone);
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.securityFenceLowBase, 1), "SSS", "III", 'I', Items.iron_ingot, 'S', Blocks.stone);
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.securityFenceLowPole, 1), "SIS", "SIS", "SIS", 'I', Items.iron_ingot, 'S', Blocks.stone);
        /*
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.securityFenceMediumCorner, 1), "ISI", "SBS", "ISI", 'B', ModBlocks.securityFenceLowCorner, 'I', Items.iron_ingot, 'S', Blocks.stone);
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.securityFenceMediumBase, 1), "SSS", "IBI",  'B', ModBlocks.securityFenceLowBase, 'I', Items.iron_ingot, 'S', Blocks.stone);
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.securityFenceMediumPole, 1), "SIS", "IBI", "SIS", 'B', ModBlocks.securityFenceLowPole, 'I', Items.iron_ingot, 'S', Blocks.stone);
        
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.securityFenceHighCorner, 1), "III", "IBI", "FFF", 'B', ModBlocks.securityFenceMediumCorner, 'I', Items.iron_ingot, 'F', Blocks.iron_block);
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.securityFenceHighBase, 1), "III", "IBI",  'B', ModBlocks.securityFenceMediumBase, 'I', Items.iron_ingot);
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.securityFenceHighPole, 1), "III", "IBI", "III", 'B', ModBlocks.securityFenceMediumPole, 'I', Items.iron_ingot);
        */
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.dnaCombinator, 1), "III", "IRI", "III", 'I', Items.iron_ingot, 'R', Items.redstone);
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.dnaExtractor, 1), "IIG", "IRG", "III", 'G', Blocks.glass, 'I', Items.iron_ingot, 'R', Items.redstone);
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.dinoPad, 1), "III", "RGR", "III", 'I', Items.iron_ingot, 'G', Items.glowstone_dust, 'R', Items.redstone);

        GameRegistry.addShapedRecipe(new ItemStack(ModItems.gypsumPowder, 2), "TG", 'T', Items.stone_pickaxe.setContainerItem(Items.stone_pickaxe), 'G', ModBlocks.gypsumCobblestone);
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.gypsumPowder, 2), "TG", 'T', Items.iron_pickaxe.setContainerItem(Items.iron_pickaxe), 'G', ModBlocks.gypsumCobblestone);
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.gypsumPowder, 2), "TG", 'T', Items.diamond_pickaxe.setContainerItem(Items.diamond_pickaxe), 'G', ModBlocks.gypsumCobblestone);
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.gypsumBrick, 1), "BB", "BB", 'B', ModBlocks.gypsumBlock);

        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.growthSerum, 1), new ItemStack(Items.dye, 1, 2), new ItemStack(Items.golden_carrot, 1), new ItemStack(Items.water_bucket, 1), new ItemStack(Items.beef, 1));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.growthSerum, 1), new ItemStack(Items.dye, 1, 2), new ItemStack(Items.golden_carrot, 1), new ItemStack(Items.water_bucket, 1), new ItemStack(Items.fish, 1));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.growthSerum, 1), new ItemStack(Items.dye, 1, 2), new ItemStack(Items.golden_carrot, 1), new ItemStack(Items.water_bucket, 1), new ItemStack(Items.porkchop, 1));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.growthSerum, 1), new ItemStack(Items.dye, 1, 2), new ItemStack(Items.golden_carrot, 1), new ItemStack(Items.water_bucket, 1), new ItemStack(Items.chicken, 1));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.growthSerum, 1), new ItemStack(Items.dye, 1, 2), new ItemStack(Items.golden_carrot, 1), new ItemStack(Items.water_bucket, 1), new ItemStack(Items.cooked_beef, 1));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.growthSerum, 1), new ItemStack(Items.dye, 1, 2), new ItemStack(Items.golden_carrot, 1), new ItemStack(Items.water_bucket, 1), new ItemStack(Items.cooked_fished, 1));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.growthSerum, 1), new ItemStack(Items.dye, 1, 2), new ItemStack(Items.golden_carrot, 1), new ItemStack(Items.water_bucket, 1), new ItemStack(Items.cooked_chicken, 1));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.growthSerum, 1), new ItemStack(Items.dye, 1, 2), new ItemStack(Items.golden_carrot, 1), new ItemStack(Items.water_bucket, 1), new ItemStack(Items.cooked_porkchop, 1));
    }
}
