package net.ilexiconn.jurassicraft;

import java.lang.reflect.Field;

import net.ilexiconn.jurassicraft.block.BlockAmberOre;
import net.ilexiconn.jurassicraft.block.BlockCultivateBottom;
import net.ilexiconn.jurassicraft.block.BlockCultivateTop;
import net.ilexiconn.jurassicraft.block.BlockDNACombinator;
import net.ilexiconn.jurassicraft.block.BlockDNAExtractor;
import net.ilexiconn.jurassicraft.block.BlockDinoPad;
import net.ilexiconn.jurassicraft.block.BlockFossilClayOre;
import net.ilexiconn.jurassicraft.block.BlockFossilOre;
import net.ilexiconn.jurassicraft.block.BlockFossilSandstoneOre;
import net.ilexiconn.jurassicraft.block.BlockGypsumBlock;
import net.ilexiconn.jurassicraft.block.BlockGypsumBrick;
import net.ilexiconn.jurassicraft.block.BlockGypsumCobblestone;
import net.ilexiconn.jurassicraft.block.BlockStuffFluid;
import net.ilexiconn.jurassicraft.block.fence.BlockSecurityFenceLowBase;
import net.ilexiconn.jurassicraft.block.fence.BlockSecurityFenceLowGrid;
import net.ilexiconn.jurassicraft.block.fence.BlockSecurityFenceLowMain;
import net.ilexiconn.jurassicraft.block.fence.BlockSecurityFenceLowPole;
import net.ilexiconn.jurassicraft.content.IContentHandler;
import net.ilexiconn.jurassicraft.item.ItemBlockCultivate;
import net.ilexiconn.jurassicraft.item.ItemBlockFossilClayOre;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModBlocks implements IContentHandler
{
    @Deprecated
    public static Block clayFossilOre;
    @Deprecated
    public static Fluid cultivateFluid;
    @Deprecated
    public static Block cultivateLiquid;
    @Deprecated
    public static Block cultivateBottomOff;
    @Deprecated
    public static Block cultivateBottomOn;
    public static Block cultivateTopOff;
    public static Block cultivateTopOn;
    public static Block dnaExtractor;
    public static Block dnaCombinator;
    public static Block gypsumBlock;
    public static Block gypsumBrick;
    public static Block gypsumCobblestone;
    public static Block amberOre;
    public static Block fossilOre;
    public static Block sandstoneFossilOre;
    public static Block dinoPad;
    
    public static Block securityFenceLowMain;
    public static Block securityFenceLowPole;
    public static Block securityFenceLowBase;
    public static Block securityFenceLowGrid;

    public void init()
    {
        cultivateBottomOff = new BlockCultivateBottom(false);
        cultivateTopOff = new BlockCultivateTop(false);
        cultivateBottomOn = new BlockCultivateBottom(true);
        cultivateTopOn = new BlockCultivateTop(true);
        dnaExtractor = new BlockDNAExtractor();
        dnaCombinator = new BlockDNACombinator();
        gypsumBlock = new BlockGypsumBlock();
        gypsumBrick = new BlockGypsumBrick();
        gypsumCobblestone = new BlockGypsumCobblestone();
        amberOre = new BlockAmberOre();
        fossilOre = new BlockFossilOre();
        sandstoneFossilOre = new BlockFossilSandstoneOre();
        clayFossilOre = new BlockFossilClayOre();
        dinoPad = new BlockDinoPad();
        securityFenceLowMain = new BlockSecurityFenceLowMain();
        securityFenceLowPole = new BlockSecurityFenceLowPole();
        securityFenceLowBase = new BlockSecurityFenceLowBase();
        securityFenceLowGrid = new BlockSecurityFenceLowGrid();
        gameRegistry();
    }

    public void gameRegistry()
    {
        GameRegistry.registerBlock(cultivateBottomOff, ItemBlockCultivate.class, "cultivateOff");
        GameRegistry.registerBlock(cultivateBottomOn, ItemBlockCultivate.class, "cultivateOn");
        GameRegistry.registerBlock(clayFossilOre, ItemBlockFossilClayOre.class, "clayFossilOre");

        cultivateFluid = new Fluid("cultivate").setLuminosity(5).setViscosity(1);
        FluidRegistry.registerFluid(cultivateFluid);

        cultivateLiquid = new BlockStuffFluid(cultivateFluid, Material.water).setBlockName("culivateFluid").setCreativeTab(null);
        GameRegistry.registerBlock(cultivateLiquid, "culivateFluid");

        for (Field field : getClass().getFields())
        {
            try
            {
                if (field.getAnnotations().length == 0)
                {
                    Block block = (Block) field.get(this);
                    GameRegistry.registerBlock(block, block.getUnlocalizedName());
                }
            }
            catch (IllegalAccessException e)
            {
                e.printStackTrace();
            }
        }
    }
}
