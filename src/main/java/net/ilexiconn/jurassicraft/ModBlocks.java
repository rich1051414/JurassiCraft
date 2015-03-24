package net.ilexiconn.jurassicraft;

import cpw.mods.fml.common.registry.GameRegistry;
import net.ilexiconn.jurassicraft.annotation.IgnoreRegistration;
import net.ilexiconn.jurassicraft.block.*;
import net.ilexiconn.jurassicraft.block.carboniferous.*;
import net.ilexiconn.jurassicraft.block.fence.BlockSecurityFenceLowBase;
import net.ilexiconn.jurassicraft.block.fence.BlockSecurityFenceLowCorner;
import net.ilexiconn.jurassicraft.block.fence.BlockSecurityFenceLowGrid;
import net.ilexiconn.jurassicraft.block.fence.BlockSecurityFenceLowPole;
import net.ilexiconn.jurassicraft.content.IContentHandler;
import net.ilexiconn.jurassicraft.item.ItemBlockCultivate;
import net.ilexiconn.jurassicraft.item.ItemBlockFossilClayOre;
import net.ilexiconn.jurassicraft.world.core.plants.HeliconiaPlant;
import net.ilexiconn.jurassicraft.world.feature.FernPlant;
import net.ilexiconn.jurassicraft.world.feature.OrontiumPlant;
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
    
    // Security Fences
    public static Block securityFenceLowCorner;
    public static Block securityFenceLowPole;
    public static Block securityFenceLowBase;
    public static Block securityFenceLowGrid;
    
    // Dimension Plants
    public static Block fernPlant;
    public static Block orontium;
    public static Block heliconia;
    
    // Carboniferous Blocks WIP
    public static Block grass;
    public static Block dirt;
    public static Block multiBlock1;
    public static Block multiBlock2;
    public static Block multiBlock3;
    public static Block timeBox;
    public static Block portal;
    public static Block grinder;
    public static Block logs_1;
    public static Block leaves_1;
    public static Block saplings_1;
    public static Block planks_1;
    public static BlockPlanksSlab woodDoubleSlab;
    public static BlockPlanksSlab woodSingleSlab;
    public static Block wallShell;
    public static Block stairsLepidodendron;
    public static Block stairsCalamites;
    public static Block stairsCordaites;
    public static Block stairsSigillaria;
    public static Block stairsLimestoneBrick;
    public static Block stairsGraniteBrick;
    public static Block waterPlant;
    public static Block antHill;
    public static Block sand;
    public static Block clearGlass;
    public static Block wallsRock;
    public static Block pillars;
    public static Block vines;
    public static Block fern;
    public static Block doorLepidodendron;
    public static Block doorCalamites;
    public static Block doorCordaites;
    public static Block doorSigillaria;
    public static Block doorAmphibian;
    public static Block coral;
    public static Block compressor;
    public static Block tilledEarth;
    
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
        initCarboniferousBlocks();
        initJurassiCraftBlocks();
     
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
        
        gameRegistry();
    }

    private void initJurassiCraftBlocks()
    {
        heliconia = new HeliconiaPlant("heliconiaplant");
        fernPlant = new FernPlant("fernplant");
        orontium = new OrontiumPlant("orontiumplant");
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
    }

    private void initCarboniferousBlocks()
    {
        woodSingleSlab = (BlockPlanksSlab) (new BlockPlanksSlab(false)).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood).setBlockName("carbon.woodSingleSlab");
        grass = new BlockGrass().setHardness(0.6F).setStepSound(Block.soundTypeGrass).setBlockName("carbon.grass");
        dirt = new BlockDirt().setHardness(0.5F).setStepSound(Block.soundTypeGravel).setBlockName("carbon.dirt");
        multiBlock1 = new BlockMultipleBlocks().setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypeStone).setBlockName("carbon.multiBlock1");
        multiBlock2 = new BlockMultipleBlocks2().setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypeStone).setBlockName("carbon.multiBlock2");
        multiBlock3 = new BlockMultipleBlocks3().setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypeStone).setBlockName("carbon.multiBlock3");
        timeBox = new BlockTimeBox().setHardness(2.0F).setResistance(5F).setBlockName("carbon.timeBox");
        portal = new BlockPortal("ph_portal").setHardness(-1.0F).setStepSound(Block.soundTypeGlass).setLightLevel(0.75F).setBlockName("carbon.portal");
        grinder = new BlockGrinder().setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood).setBlockName("carbon.grinder");
        logs_1 = new BlockLog(new String[] { "logLepidodendron", "logCalamites", "logCordaites", "logSigillaria" }, new String[] { "log_oak_top", "log_oak_top", "log_oak_top", "log_oak_top" }).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood).setBlockName("carbon.wood");
        leaves_1 = new BlockLeaves(new String[][] { { "leaves_Lepidodendron", "leaves_Calamites", "leaves_Cordaites", "leaves_Sigillaria" }, { "leaves_Lepidodendron_o", "leaves_Calamites_o", "leaves_Cordaites_o", "leaves_Sigillaria_o" } }).setHardness(0.2F).setLightOpacity(1).setStepSound(Block.soundTypeGrass).setBlockName("carbon.leaves.1");
        saplings_1 = new BlockSapling().setHardness(0.0F).setStepSound(Block.soundTypeGrass).setBlockName("carbon.sapling");
        planks_1 = new BlockPlanks().setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood).setBlockName("carbon.planks");
        woodDoubleSlab = (BlockPlanksSlab) (new BlockPlanksSlab(true)).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood).setBlockName("carbon.woodSlab");
        wallShell = new BlockWallShell().setBlockName("carbon.wallShell");
        stairsLepidodendron = new BlockCarboniferousStairs(planks_1, 0).setBlockName("carbon.stairsLepidodendron");
        stairsCalamites = new BlockCarboniferousStairs(planks_1, 1).setBlockName("carbon.stairsCalamites");
        stairsCordaites = new BlockCarboniferousStairs(planks_1, 2).setBlockName("carbon.stairsCordaites");
        stairsSigillaria = new BlockCarboniferousStairs(planks_1, 3).setBlockName("carbon.stairsSigillaria");
        stairsGraniteBrick = new BlockCarboniferousStairs(multiBlock1, 2).setBlockName("carbon.stairsGraniteBrick");
        stairsLimestoneBrick = new BlockCarboniferousStairs(multiBlock1, 4).setBlockName("carbon.stairsLimestoneBrick");
        waterPlant = new BlockWaterPlant().setBlockName("carbon.waterPlant");
        antHill = new BlockAntHill().setBlockName("carbon.antHill").setHardness(1.0F);
        sand = new BlockCarboniferousSand().setHardness(0.5F).setStepSound(Block.soundTypeSand).setBlockName("carbon.sand");
        clearGlass = new BlockCustomGlass().setResistance(1.5F).setHardness(0.6F).setStepSound(Block.soundTypeGlass).setBlockName("carbon.clearGlass");
        wallsRock = new BlockWall(multiBlock1).setBlockName("carbon.wallsRock");
        pillars = new BlockPillar(new String[] { "graniteColumn_side", "limestonePillar_side", "basaltPillar_side" }, new String[] { "graniteColumn_top", "limestonePillar_top", "basaltPillar_top" }).setBlockName("carbon.pillars").setStepSound(Block.soundTypeStone).setHardness(0.8F);
        fern = new BlockCustomTallGrass().setHardness(0.0F).setStepSound(Block.soundTypeGrass).setBlockName("carbon.tallgrass");
        vines = new BlockVine().setHardness(0.3F).setStepSound(Block.soundTypeGrass).setBlockName("carbon.vine");
        doorLepidodendron = new BlockCustomDoor(0).setBlockName("carbon.doorLepidodendron").setHardness(3.0F).setStepSound(Block.soundTypeWood);
        doorCalamites = new BlockCustomDoor(1).setBlockName("carbon.doorCalamites").setHardness(3.0F).setStepSound(Block.soundTypeWood);
        doorCordaites = new BlockCustomDoor(2).setBlockName("carbon.doorCordaites").setHardness(3.0F).setStepSound(Block.soundTypeWood);
        doorSigillaria = new BlockCustomDoor(3).setBlockName("carbon.doorSigillaria").setHardness(3.0F).setStepSound(Block.soundTypeWood);
        doorAmphibian = new BlockCustomDoor(4).setBlockName("carbon.doorAmphibian").setHardness(3.0F).setStepSound(Block.soundTypeWood);
        coral = new BlockCoral().setHardness(0.0F).setBlockName("carbon.coral");
        compressor = new BlockCompressor().setBlockName("carbon.compressor");
        tilledEarth = new BlockTilledDirt().setHardness(0.6F).setStepSound(Block.soundTypeGravel).setBlockName("carbon.tilledDirt");
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
