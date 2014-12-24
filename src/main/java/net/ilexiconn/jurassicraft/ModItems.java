package net.ilexiconn.jurassicraft;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.ilexiconn.jurassicraft.content.IContentHandler;
import net.ilexiconn.jurassicraft.item.*;

import java.lang.reflect.Field;

public class ModItems implements IContentHandler
{
    public static Item amber;
    public static Item fossil;
    public static Item dinoPad;
    public static Item dinoBone;
    public static Item growthSerum;
    public static Item gypsumPowder;
    public static Item dinoSteak;
    public static Item appleOnAStick;
    public static Item beefOnAStick;
    public static Item carrotOnAStick;
    public static Item fishOnAStick;
    public static Item porkOnAStick;
    public static Item wheatOnAStick;

    public static Item net;

    public void init()
    {
        amber = new ItemAmber();
        fossil = new ItemFossil();
        dinoBone = new ItemDinoBone();
        growthSerum = new ItemGrowthSerum();
        gypsumPowder = new ItemGypsumPowder();
        dinoPad = new ItemDinoPad();
        dinoSteak = new ItemDinoSteak();
        appleOnAStick = new ItemOnAStick("Apple");
        beefOnAStick = new ItemOnAStick("Beef");
        carrotOnAStick = new ItemOnAStick("Carrot");
        fishOnAStick = new ItemOnAStick("Fish");
        porkOnAStick = new ItemOnAStick("Pork");
        wheatOnAStick = new ItemOnAStick("Wheat");

        net = new ItemNet();

        gameRegistry();
    }

    public void gameRegistry()
    {
        for (Field field : getClass().getFields())
        {
            try
            {
                Item item = (Item) field.get(this);
                if (field.getAnnotations().length == 0)
                    GameRegistry.registerItem(item, item.getUnlocalizedName());
            }
            catch (IllegalAccessException e)
            {
                e.printStackTrace();
            }
        }
    }
}
