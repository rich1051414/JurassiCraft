package net.ilexiconn.jurassicraft;

import cpw.mods.fml.common.registry.GameRegistry;
import net.ilexiconn.jurassicraft.content.IContentHandler;
import net.ilexiconn.jurassicraft.entity.Creature;
import net.ilexiconn.jurassicraft.entity.CreatureManager;
import net.ilexiconn.jurassicraft.item.*;
import net.minecraft.item.Item;

import java.lang.reflect.Field;

public class ModItems implements IContentHandler
{
    public static Item amber;
    public static Item fossil;
    public static Item dinoPad;
    public static Item dinoBone;
    public static Item growthSerum;
    public static Item gypsumPowder;
    public static Item appleOnAStick;
    public static Item beefOnAStick;
    public static Item carrotOnAStick;
    public static Item fishOnAStick;
    public static Item porkOnAStick;
    public static Item wheatOnAStick;
    public static Item net;
    public static Item spawnEgg;
    
    // Carboniferous Items
    
    public static Item multiItems;
    public static Item grindingStones;
    public static Item rawAnt;
    public static Item cookedAnt;
    public static Item rawDragonfly;
    public static Item cookedDragonfly;
    public static Item rawAmphibian;
    public static Item cookedAmphibian;
    
    public void init()
    {
        initJurassicraftItems();
        initCarboniferousItems();
        
        registerCreatureItems();
        
        gameRegistry();
    }

    private boolean isEven(int i)
    {
        return ((int) i / 2) == ((float) i / 2);
    }
    
    private void registerCreatureItems()
    {
        for (Creature creature : CreatureManager.getCreatures())
        {
            int itemTypes = creature.getAddedItemTypes();
            
            if(itemTypes > 0)
            {
                creature.addDNA();
                
                if(isEven(itemTypes))
                    creature.addSyringe();
                else
                    creature.addEgg();
                
                if(itemTypes >= 3)
                    creature.addMeat();
                
                if(itemTypes == 5 || itemTypes == 6 || itemTypes == 9)
                    creature.addSkull();
                
                if(itemTypes == 7 || itemTypes == 9 || itemTypes == 10)
                    creature.addSkin();
                
                if(itemTypes == 8)
                    creature.addFur();
            }
        }
    }

    private void initJurassicraftItems()
    {
        amber = new ItemAmber();
        fossil = new ItemFossil();
        dinoBone = new ItemDinoBone();
        growthSerum = new ItemGrowthSerum();
        gypsumPowder = new ItemGypsumPowder();
        dinoPad = new ItemDinoPad();
        appleOnAStick = new ItemOnAStick("Apple");
        beefOnAStick = new ItemOnAStick("Beef");
        carrotOnAStick = new ItemOnAStick("Carrot");
        fishOnAStick = new ItemOnAStick("Fish");
        porkOnAStick = new ItemOnAStick("Pork");
        wheatOnAStick = new ItemOnAStick("Wheat");
        spawnEgg = new ItemSpawnEggJurassiCraft();
        net = new ItemNet();
    }

    private void initCarboniferousItems()
    {
        multiItems = new ItemMultipleItems().setUnlocalizedName("carbon.multipleItems");
        grindingStones = new ItemGrindingStones().setUnlocalizedName("carbon.grindingStones");
        rawAnt = new ItemAnt(1, 0.3F).setUnlocalizedName("carbon.rawAnt");
        cookedAnt = new ItemAnt(3, 0.4F).setUnlocalizedName("carbon.cookedAnt");
        rawDragonfly = new ItemCustomFood(3, 0.1F, false).setUnlocalizedName("carbon.rawDragonfly");
        cookedDragonfly = new ItemCustomFood(4, 0.2F, false).setUnlocalizedName("carbon.cookedDragonfly");
        rawAmphibian = new ItemCustomFood(4, 0.7F, true).setUnlocalizedName("carbon.rawAmphibian");
        cookedAmphibian = new ItemCustomFood(6, 1.1F, true).setUnlocalizedName("carbon.cookedAmphibian");
    }
    
    public void gameRegistry()
    {
        for (Field field : getClass().getFields())
        {
            try
            {
                Item item = (Item) field.get(this);
                
                if (field.getAnnotations().length == 0)
                {
                    GameRegistry.registerItem(item, item.getUnlocalizedName());
                }
            }
            catch (IllegalAccessException e)
            {
                e.printStackTrace();
            }
        }
    }
}
