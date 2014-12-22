package to.uk.ilexiconn.jurassicraft;

import akka.dispatch.sysmsg.Create;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.item.Item;
import to.uk.ilexiconn.jurassicraft.entity.Entities;
import to.uk.ilexiconn.jurassicraft.entity.JsonEntityParser;
import to.uk.ilexiconn.jurassicraft.item.ItemDNA;
import to.uk.ilexiconn.jurassicraft.item.ItemDinoEgg;
import to.uk.ilexiconn.jurassicraft.item.ItemMammalSyringe;
import to.uk.ilexiconn.jurassicraft.item.ItemMeat;
import to.uk.ilexiconn.jurassicraft.proxy.ServerProxy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @deprecated Start using LLib's Content Handler System instead
 */
@Deprecated
public class Util
{
    /**
     * Stuff
     */
    private static final JsonEntityParser entityParser = new JsonEntityParser();
    @SidedProxy(clientSide = "to.uk.ilexiconn.jurassicraft.proxy.ClientProxy", serverSide = "to.uk.ilexiconn.jurassicraft.proxy.ServerProxy")
    public static ServerProxy proxy;
    private static Item[] items = new Item[512];
    private static ArrayList<ItemDNA> dnas = new ArrayList<ItemDNA>();
    private static ArrayList<ItemDinoEgg> eggs = new ArrayList<ItemDinoEgg>();
    private static ArrayList<ItemMammalSyringe> syringes = new ArrayList<ItemMammalSyringe>();

    private static Map<Entities, Class<?>> creatures = new HashMap<Entities, Class<?>>();

    private static Map<Entities, ItemMeat> meat = new HashMap<Entities, ItemMeat>();

    public static byte creatureId = 0;

    /**
     * Getters
     */
    public static Class<?> getCreatureClass(String name)
    {
    	for (Entry<Entities, Class<?>> creature : creatures.entrySet())
    	{
			if(creature.getKey().creatureName.equalsIgnoreCase(name))
			{
				return creature.getValue();
			}
		}

        return null;
    }


    public static Item getItem(int id)
    {
        return items[id];
    }

    public static ArrayList<ItemDNA> getDNAArray()
    {
        return dnas;
    }

    public static ArrayList<ItemDinoEgg> getEggArray()
    {
        return eggs;
    }

    public static ArrayList<ItemMammalSyringe> getSyringeArray()
    {
        return syringes;
    }
    
    public static String getModId()
    {
        return "jurassicraft:";
    }

    public static JsonEntityParser getEntityParser()
    {
        return entityParser;
    }

    public static Map<Entities, Class<?>> getCreatures() {
        return creatures;
    }

    public static Map<Entities, ItemMeat> getDinoMeats()
    {
        return meat;
    }

    public static Item getMeat(Entities creature)
    {
        return meat.get(creature);
    }

    /**
     *  Adders
     */

    public void addItem(int id, Item item)
    {
        if (id != -1) items[id] = item;
        GameRegistry.registerItem(item, item.getUnlocalizedName());
    }

    public void addDNA(String dinoName)
    {
        ItemDNA item = new ItemDNA(dinoName);
        dnas.add(item);
        GameRegistry.registerItem(item, item.getUnlocalizedName());
    }

    public void addMeat(Entities creature)
    {
        ItemMeat item = new ItemMeat(creature.creatureName);
        meat.put(creature, item);
        addItem(-1, item);
    }

    public void addDinoEntity(Entities dino)
    {
        try
        {
            Class entity = Class.forName("to.uk.ilexiconn.jurassicraft.entity.dinosaurs.Entity" + dino.creatureName);
            creatures.put(dino, entity);
            int entityId = EntityRegistry.findGlobalUniqueEntityId();
            EntityRegistry.registerGlobalEntityID(entity, dino.creatureName, entityId, 0, 0);
            EntityRegistry.registerModEntity(entity, dino.creatureName, entityId, JurassiCraft.instance, 64, 1, true);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void addEgg(final String dinoName)
    {
        ItemDinoEgg egg = new ItemDinoEgg(dinoName);

        eggs.add(egg);

        addItem(-1, egg);
    }

    public void addMammalEntity(Entities mammal)
    {
        try
        {
            Class entity = Class.forName("to.uk.ilexiconn.jurassicraft.entity.mammals.Entity" + mammal.creatureName);
            creatures.put(mammal, entity);
            int entityId = EntityRegistry.findGlobalUniqueEntityId();
            EntityRegistry.registerGlobalEntityID(entity, mammal.creatureName, entityId, 0, 0);
            EntityRegistry.registerModEntity(entity, mammal.creatureName, entityId, JurassiCraft.instance, 64, 1, true);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void addCephalopodaEntity(Entities cephalopoda)
    {
        try
        {
            Class entity = Class.forName("to.uk.ilexiconn.jurassicraft.entity.cephalopods.Entity" + cephalopoda.creatureName);
            creatures.put(cephalopoda, entity);
            int entityId = EntityRegistry.findGlobalUniqueEntityId();
            EntityRegistry.registerGlobalEntityID(entity, cephalopoda.creatureName, entityId, 0, 0);
            EntityRegistry.registerModEntity(entity, cephalopoda.creatureName, entityId, JurassiCraft.instance, 64, 1, true);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void addArthropodEntity(Entities arthropod)
    {
        try
        {
            Class entity = Class.forName("to.uk.ilexiconn.jurassicraft.entity.arthropods.Entity" + arthropod.creatureName);
            creatures.put(arthropod, entity);
            int entityId = EntityRegistry.findGlobalUniqueEntityId();
            EntityRegistry.registerGlobalEntityID(entity, arthropod.creatureName, entityId, 0, 0);
            EntityRegistry.registerModEntity(entity, arthropod.creatureName, entityId, JurassiCraft.instance, 64, 1, true);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void addFishEntity(Entities fish)
    {
        try
        {
            Class entity = Class.forName("to.uk.ilexiconn.jurassicraft.entity.fish.Entity" + fish.creatureName);
            creatures.put(fish, entity);
            int entityId = EntityRegistry.findGlobalUniqueEntityId();
            EntityRegistry.registerGlobalEntityID(entity, fish.creatureName, entityId, 0, 0);
            EntityRegistry.registerModEntity(entity, fish.creatureName, entityId, JurassiCraft.instance, 64, 1, true);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void addReptileEntity(Entities reptile)
    {
        try
        {
            Class entity = Class.forName("to.uk.ilexiconn.jurassicraft.entity.reptiles.Entity" + reptile.creatureName);
            creatures.put(reptile, entity);
            int entityId = EntityRegistry.findGlobalUniqueEntityId();
            EntityRegistry.registerGlobalEntityID(entity, reptile.creatureName, entityId, 0, 0);
            EntityRegistry.registerModEntity(entity, reptile.creatureName, entityId, JurassiCraft.instance, 64, 1, true);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void addBirdEntity(Entities bird)
    {
        try
        {
            Class entity = Class.forName("to.uk.ilexiconn.jurassicraft.entity.birds.Entity" + bird.creatureName);
            creatures.put(bird, entity);
            int entityId = EntityRegistry.findGlobalUniqueEntityId();
            EntityRegistry.registerGlobalEntityID(entity, bird.creatureName, entityId, 0, 0);
            EntityRegistry.registerModEntity(entity, bird.creatureName, entityId, JurassiCraft.instance, 64, 1, true);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void addSyringe(final String mammalName)
    {
    	ItemMammalSyringe syringe = new ItemMammalSyringe(mammalName);

    	syringes.add(syringe);

        addItem(-1, syringe);
    }

    @SideOnly(Side.CLIENT)
    public void addDinoEntityRenderer(Entities dino)
    {
        try
        {
            RenderLiving renderer = (RenderLiving) Class.forName("to.uk.ilexiconn.jurassicraft.entity.render.dinosaurs.Render" + dino.creatureName).getDeclaredConstructor(Entities.class).newInstance(dino);
            Class entity = Class.forName("to.uk.ilexiconn.jurassicraft.entity.dinosaurs.Entity" + dino.creatureName);
            proxy.renderEntity(entity, renderer);
        }
        catch (Exception e)
        {

        }
    }

    @SideOnly(Side.CLIENT)
    public void addMammalEntityRenderer(Entities mammal)
    {
        try
        {
            RenderLiving renderer = (RenderLiving) Class.forName("to.uk.ilexiconn.jurassicraft.entity.render.mammals.Render" + mammal.creatureName).getDeclaredConstructor(Entities.class).newInstance(mammal);
            Class entity = Class.forName("to.uk.ilexiconn.jurassicraft.entity.mammals.Entity" + mammal.creatureName);
            proxy.renderEntity(entity, renderer);
        }
        catch (Exception e)
        {

        }
    }

    @SideOnly(Side.CLIENT)
    public void addCephalopodaEntityRenderer(Entities cephalopoda)
    {
        try
        {
            RenderLiving renderer = (RenderLiving) Class.forName("to.uk.ilexiconn.jurassicraft.entity.render.cephalopods.Render" + cephalopoda.creatureName).getDeclaredConstructor(Entities.class).newInstance(cephalopoda);
            Class entity = Class.forName("to.uk.ilexiconn.jurassicraft.entity.cephalopods.Entity" + cephalopoda.creatureName);
            proxy.renderEntity(entity, renderer);
        }
        catch (Exception e)
        {

        }
    }

    @SideOnly(Side.CLIENT)
    public void addArthropodEntityRenderer(Entities arthropod)
    {
        try
        {
            RenderLiving renderer = (RenderLiving) Class.forName("to.uk.ilexiconn.jurassicraft.entity.render.arthropods.Render" + arthropod.creatureName).getDeclaredConstructor(Entities.class).newInstance(arthropod);
            Class entity = Class.forName("to.uk.ilexiconn.jurassicraft.entity.arthropods.Entity" + arthropod.creatureName);
            proxy.renderEntity(entity, renderer);
        }
        catch (Exception e)
        {

        }
    }

    @SideOnly(Side.CLIENT)
    public void addFishEntityRenderer(Entities fish)
    {
        try
        {
            RenderLiving renderer = (RenderLiving) Class.forName("to.uk.ilexiconn.jurassicraft.entity.render.fish.Render" + fish.creatureName).getDeclaredConstructor(Entities.class).newInstance(fish);
            Class entity = Class.forName("to.uk.ilexiconn.jurassicraft.entity.fish.Entity" + fish.creatureName);
            proxy.renderEntity(entity, renderer);
        }
        catch (Exception e)
        {

        }
    }

    @SideOnly(Side.CLIENT)
    public void addReptileEntityRenderer(Entities reptile)
    {
        try
        {
            RenderLiving renderer = (RenderLiving) Class.forName("to.uk.ilexiconn.jurassicraft.entity.render.reptiles.Render" + reptile.creatureName).getDeclaredConstructor(Entities.class).newInstance(reptile);
            Class entity = Class.forName("to.uk.ilexiconn.jurassicraft.entity.reptiles.Entity" + reptile.creatureName);
            proxy.renderEntity(entity, renderer);
        }
        catch (Exception e)
        {

        }
    }

    @SideOnly(Side.CLIENT)
    public void addBirdEntityRenderer(Entities bird)
    {
        try
        {
            RenderLiving renderer = (RenderLiving) Class.forName("to.uk.ilexiconn.jurassicraft.entity.render.birds.Render" + bird.creatureName).getDeclaredConstructor(Entities.class).newInstance(bird);
            Class entity = Class.forName("to.uk.ilexiconn.jurassicraft.entity.birds.Entity" + bird.creatureName);
            proxy.renderEntity(entity, renderer);
        }
        catch (Exception e)
        {

        }
    }
 
    public static boolean isFavoriteFood(int id, Item heldItem)
    {
    	ArrayList itemList = getCreatureFromId(id).favoriteFoodList;
        return !itemList.isEmpty() && itemList.contains(heldItem.getUnlocalizedName());
    }

    public static boolean isRidingItem(int id, Item heldItem)
    {
    	ArrayList itemList = getCreatureFromId(id).ridingItemList;
        return !itemList.isEmpty() && itemList.contains(heldItem.getUnlocalizedName());
    }

    public static Entities getCreatureFromId(int id)
    {
    	for (Entry<Entities, Class<?>> creature : creatures.entrySet())
    	{
			if(creature.getKey().creatureID == id)
			{
				return creature.getKey();
			}
		}
    	
    	return null;
    }

    public static int getCreatureIdFromName(String name)
    {
    	for (Entry<Entities, Class<?>> creature : creatures.entrySet())
    	{
			if(creature.getKey().creatureName.equalsIgnoreCase(name))
			{
				return creature.getKey().creatureID;
			}
		}

     
        return -1;
    }

    public static int classToId(Class class1)
    {
    	for (Entry<Entities, Class<?>> creature : creatures.entrySet())
    	{
			if(creature.getValue().equals(class1))
			{
				return creature.getKey().creatureID;
			}
		}


        return -1;
    }
}
