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

        // Carboniferous Items

        multiItems = new ItemMultipleItems().setUnlocalizedName("carbon.multipleItems");
        grindingStones =  new ItemGrindingStones().setUnlocalizedName("carbon.grindingStones");
        rawAnt = new ItemAnt(1, 0.3F).setUnlocalizedName("carbon.rawAnt");
        cookedAnt = new ItemAnt(3, 0.4F).setUnlocalizedName("carbon.cookedAnt");
        rawDragonfly = new ItemCustomFood(3, 0.1F, false).setUnlocalizedName("carbon.rawDragonfly");
        cookedDragonfly = new ItemCustomFood(4, 0.2F, false).setUnlocalizedName("carbon.cookedDragonfly");
        rawAmphibian = new ItemCustomFood(4, 0.7F, true).setUnlocalizedName("carbon.rawAmphibian");
        cookedAmphibian = new ItemCustomFood(6, 1.1F, true).setUnlocalizedName("carbon.cookedAmphibian");

        for (Creature creature : CreatureManager.getCreatures())
        {
            switch (creature.getAddedItemTypes())
            {
                case 0:
                    /** Creature not implemented yet  */
                    break;
                case 1:
                    /** DNA + Egg */
                    creature.addDNA();
                    creature.addEgg();
                    break;
                case 2:
                    /** DNA + Syringe */
                    creature.addDNA();
                    creature.addSyringe();
                    break;
                case 3:
                    /** DNA + Egg + Meat */
                    creature.addDNA();
                    creature.addEgg();
                    creature.addMeat();
                    break;
                case 4:
                    /** DNA + Syringe + Meat */
                    creature.addDNA();
                    creature.addSyringe();
                    creature.addMeat();
                    break;
                case 5:
                    /** DNA + Egg + Meat + Skull */
                    creature.addDNA();
                    creature.addEgg();
                    creature.addMeat();
                    creature.addSkull();
                    break;
                case 6:
                    /** DNA + Syringe + Meat + Skull */
                    creature.addDNA();
                    creature.addSyringe();
                    creature.addMeat();
                    creature.addSkull();
                    break;
                case 7:
                    /** DNA + Egg + Meat + Skin */
                    creature.addDNA();
                    creature.addEgg();
                    creature.addMeat();
                    creature.addSkin();
                    break;
                case 8:
                    /** DNA + Syringe + Meat + Fur */
                    creature.addDNA();
                    creature.addSyringe();
                    creature.addMeat();
                    creature.addFur();
                    break;
                case 9:
                    /** DNA + Egg + Meat + Skull + Skin */
                    creature.addDNA();
                    creature.addEgg();
                    creature.addMeat();
                    creature.addSkull();
                    creature.addSkin();
                    break;
                case 10:
                    /** DNA + Syringe + Meat + Skin */
                    creature.addDNA();
                    creature.addSyringe();
                    creature.addMeat();
                    creature.addSkin();
                    break;
            }
        }

        gameRegistry();
    }

    public void gameRegistry()
    {
        for (Field field : getClass().getFields())
        {
            try
            {
                Item item = (Item) field.get(this);
                if (field.getAnnotations().length == 0) GameRegistry.registerItem(item, item.getUnlocalizedName());
            }
            catch (IllegalAccessException e)
            {
                e.printStackTrace();
            }
        }
    }
}
