package net.ilexiconn.jurassicraft;

import cpw.mods.fml.common.registry.GameRegistry;
import net.ilexiconn.jurassicraft.annotation.IgnoreRegistration;
import net.ilexiconn.jurassicraft.block.*;
import net.ilexiconn.jurassicraft.block.fence.BlockSecurityFenceLowBase;
import net.ilexiconn.jurassicraft.block.fence.BlockSecurityFenceLowCorner;
import net.ilexiconn.jurassicraft.block.fence.BlockSecurityFenceLowGrid;
import net.ilexiconn.jurassicraft.block.fence.BlockSecurityFenceLowPole;
import net.ilexiconn.jurassicraft.content.IContentHandler;
import net.ilexiconn.jurassicraft.dimension.core.BlockDinoPortal;
import net.ilexiconn.jurassicraft.dimension.core.BlockKeyStone;
import net.ilexiconn.jurassicraft.dimension.core.plants.FernPlant;
import net.ilexiconn.jurassicraft.dimension.core.plants.OrontiumPlant;
import net.ilexiconn.jurassicraft.item.ItemBlockCultivate;
import net.ilexiconn.jurassicraft.item.ItemBlockFossilClayOre;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

import java.lang.reflect.Field;

public class ModBlocks implements IContentHandler
{
    @IgnoreRegistration
    public static Block clayFossilOre;
    @IgnoreRegistration
    public static Fluid cultivateFluid;
    @IgnoreRegistration
    public static Block cultivateLiquid;
    @IgnoreRegistration
    public static Block cultivateBottomOff;
    @IgnoreRegistration
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

    public static Block securityFenceLowCorner;
    public static Block securityFenceLowPole;
    public static Block securityFenceLowBase;
    public static Block securityFenceLowGrid;

    //Portal Blocks
    
    public static Block DinoPortal;
    
    public static Block KeyStone;

    //Dimension Plants

    public static Block fernPlant;
    public static Block Orontium;

    /*
    public static Block securityFenceMediumCorner;
    public static Block securityFenceMediumPole;
    public static Block securityFenceMediumBase;
    public static Block securityFenceMediumGrid;
    
    public static Block securityFenceHighCorner;
    public static Block securityFenceHighPole;
    public static Block securityFenceHighBase;
    public static Block securityFenceHighGrid;
    */

    public void init()
    {
        fernPlant = new FernPlant("fernplant");
        Orontium = new OrontiumPlant("orontiumplant");
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
        securityFenceLowCorner = new BlockSecurityFenceLowCorner();
        securityFenceLowPole = new BlockSecurityFenceLowPole();
        securityFenceLowBase = new BlockSecurityFenceLowBase();
        securityFenceLowGrid = new BlockSecurityFenceLowGrid();
        /*
        securityFenceMediumCorner = new BlockSecurityFenceMediumCorner();
        securityFenceMediumPole = new BlockSecurityFenceMediumPole();
        securityFenceMediumBase = new BlockSecurityFenceMediumBase();
        securityFenceMediumGrid = new BlockSecurityFenceMediumGrid();

        securityFenceHighCorner = new BlockSecurityFenceHighCorner();
        securityFenceHighPole = new BlockSecurityFenceHighPole();
        securityFenceHighBase = new BlockSecurityFenceHighBase();
        securityFenceHighGrid = new BlockSecurityFenceHighGrid();
        */
        
        DinoPortal = new BlockDinoPortal(0).setBlockName("portal").setBlockTextureName("jurassicraft:textures/blocks/portal.png");
        KeyStone = new BlockKeyStone().setBlockName("KeyStone").setBlockTextureName("jurassicraft:keystone");
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
                if (!field.isAnnotationPresent(IgnoreRegistration.class))
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
