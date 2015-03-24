package net.ilexiconn.jurassicraft.entity;

import java.util.ArrayList;
import java.util.List;

import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.client.render.entity.RenderJurassicraftCreature;
import net.ilexiconn.jurassicraft.dinoconfig.JsonCreatureDefinition;
import net.ilexiconn.jurassicraft.item.ItemDNA;
import net.minecraft.client.renderer.entity.RenderLiving;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CreatureManager
{
    private static List<Creature> creatures = new ArrayList<Creature>();
    
    public static List<Creature> getCreatures()
    {
        return creatures;
    }
    
    public static String[] getCreatureNames()
    {
        List<Creature> creatures = getCreatures();
        
        String[] names = new String[creatures.size()];
        
        for (int i = 0; i < creatures.size(); i++)
        {
            names[i] = creatures.get(i).getCreatureName();
        }
        
        return names;
    }
    
    public static Creature getCreatureFromId(int creatureID)
    {
        for (Creature creature : creatures)
        {
            if (creature.getCreatureID() == creatureID)
            {
                return creature;
            }
        }
        
        return null;
    }

    public static String getCategoryFromCreatureName(String name)
    {
        for (Creature creature : creatures)
        {
            if (creature.getCreatureName().equalsIgnoreCase(name))
            {
                return creature.getCreatureCategory();
            }
        }
        
        return null;
    }
    
    public static Creature classToCreature(Class clazz)
    {
        for (Creature creature : creatures)
        {
            if (creature.getCreatureClass().equals(clazz))
            {
                return creature;
            }
        }
        
        return null;
    }
    
    public static Creature getCreatureFromDNA(ItemDNA itemDNA)
    {
        if (itemDNA != null)
        {
            for (Creature creature : creatures)
            {
                ItemDNA currentDNA = creature.getDNA();
                
                if (itemDNA.equals(currentDNA))
                {
                    return creature;
                }
            }
        }
        
        return null;
    }
    
    public static Creature getCreatureFromName(String name)
    {
        for (Creature creature : creatures)
        {
            if (creature.getCreatureName().equalsIgnoreCase(name))
            {
                return creature;
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
            creatures.add(new Creature(category, creature, entity));
          
            int entityId = EntityRegistry.findGlobalUniqueEntityId();
            EntityRegistry.registerGlobalEntityID(entity, creatureName, entityId);
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
            Class entity = Class.forName("net.ilexiconn.jurassicraft.entity." + category + ".Entity" + dino.creatureName);
         
            if (checkForClass("net.ilexiconn.jurassicraft.client.render.entity." + category + ".Render" + dino.creatureName))
            {
                RenderLiving renderer = (RenderLiving) Class.forName("net.ilexiconn.jurassicraft.client.render.entity." + category + ".Render" + dino.creatureName).getDeclaredConstructor(Creature.class).newInstance(getCreatureFromId(dino.creatureID));
                JurassiCraft.proxy.renderEntity(entity, renderer);
            }
            else
            {
                JurassiCraft.proxy.renderEntity(entity, new RenderJurassicraftCreature(dino.creatureName, category, dino.shadowSize));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public static boolean checkForClass(String className)
    {
        try
        {
            Class.forName(className);
            return true;
        }
        catch (ClassNotFoundException exception)
        {
            return false;
        }
    }
}
