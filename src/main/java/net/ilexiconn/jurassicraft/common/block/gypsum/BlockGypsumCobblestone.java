package net.ilexiconn.jurassicraft.common.block.gypsum;

import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.common.creativetab.ModCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockGypsumCobblestone extends Block
{
    public BlockGypsumCobblestone()
    {
        super(Material.rock);
        this.setHardness(1.2f);
        this.setResistance(2.5f);
        setBlockName("block_Gypsum_CobbleStone");
        this.setStepSound(soundTypeStone);
        this.setHarvestLevel("pickaxe", 0);
        setCreativeTab(ModCreativeTabs.blocks);
        setBlockTextureName(JurassiCraft.getModId() + "gypsum_cobblestone");
    }
}
