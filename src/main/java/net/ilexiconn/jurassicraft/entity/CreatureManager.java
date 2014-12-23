package net.ilexiconn.jurassicraft.entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.Util;
import net.ilexiconn.jurassicraft.config.JsonCreatureDefinition;
import net.ilexiconn.jurassicraft.item.ItemDNA;
import net.minecraft.client.renderer.entity.RenderLiving;

public class CreatureManager
{
	private static Map<Class<?>, Creature> creatures = new HashMap<Class<?>, Creature>();

	public static Map<Class<?>, Creature> getCreatures()
	{
		return creatures;
	}

	public static Creature getCreatureFromId(int creatureID) 
	{
		for (Entry<Class<?>, Creature> creature : creatures.entrySet())
		{
			if(creature.getValue().getCreatureID() == creatureID)
			{
				return creature.getValue();
			}
		}

		return null;
	}

	public static int getCreatureIdFromName(String name)
	{
		for (Entry<Class<?>, Creature> creature : creatures.entrySet())
		{
			if(creature.getValue().getCreatureName().equalsIgnoreCase(name))
			{
				return creature.getValue().getCreatureID();
			}
		}

		return -1;
	}

	public static Creature classToCreature(Class class1)
	{
		return creatures.get(class1);
	}

	public static Creature getCreatureFromDNA(ItemDNA itemDNA)
	{
		for (Entry<Class<?>, Creature> creature : creatures.entrySet())
		{
			if(creature.getValue().getDNA().equals(itemDNA))
			{
				return creature.getValue();
			}
		}

		return null;
	}

	public static Creature getCreatureFromName(String name)
	{
		for (Entry<Class<?>, Creature> creature : creatures.entrySet())
		{
			if(creature.getValue().getCreatureName().equalsIgnoreCase(name))
			{
				return creature.getValue();
			}
		}

		return null;
	}

	public static Class getCreatureClass(String name) 
	{
		for (Entry<Class<?>, Creature> creature : creatures.entrySet())
		{
			if(creature.getValue().getCreatureName().equalsIgnoreCase(name))
			{
				return creature.getKey();
			}
		}
		
		return null;
	}
	
	public static Class getCreatureClass(int id) 
	{
		for (Entry<Class<?>, Creature> ccreature : creatures.entrySet())
		{
			if(ccreature.getValue().getCreatureID() == id)
			{
				return ccreature.getKey();
			}
		}

		return null;
	}
	
    public static void addCreature(JsonCreatureDefinition creature, String category)
    {
        try
        {
            String creatureName = creature.creatureName;
			
            Class entity = Class.forName("net.ilexiconn.jurassicraft.entity." + category + ".Entity" + creatureName);
            creatures.put(entity, new Creature(category, creature));
            int entityId = EntityRegistry.findGlobalUniqueEntityId();
            EntityRegistry.registerGlobalEntityID(entity, creatureName, entityId, 0, 0);
            EntityRegistry.registerModEntity(entity, creatureName, entityId, JurassiCraft.instance, 64, 1, true);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
	}
    

    @SideOnly(Side.CLIENT)
    public static void addCreatureRenderer(JsonCreatureDefinition dino, String category)
    {
        try
        {
            RenderLiving renderer = (RenderLiving) Class.forName("net.ilexiconn.jurassicraft.entity.render." + category + ".Render" + dino.creatureName).getDeclaredConstructor(Creature.class).newInstance(getCreatureFromName(dino.creatureName));
            Class entity = Class.forName("net.ilexiconn.jurassicraft.entity." + category + ".Entity" + dino.creatureName);
            Util.proxy.renderEntity(entity, renderer);
        }
        catch (Exception e)
        {
        	e.printStackTrace();
        }
    }
}
