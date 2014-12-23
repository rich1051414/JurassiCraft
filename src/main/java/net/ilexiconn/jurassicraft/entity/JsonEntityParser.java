package net.ilexiconn.jurassicraft.entity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.ilexiconn.jurassicraft.Util;
import net.ilexiconn.jurassicraft.config.DinoConfig;
import net.ilexiconn.jurassicraft.config.JsonCreatureDefinition;

import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.Collection;

public class JsonEntityParser extends Util
{
    private Collection<JsonCreatureDefinition> dinos;
    private Collection<JsonCreatureDefinition> mammals;
    private Collection<JsonCreatureDefinition> cephalopods;
    private Collection<JsonCreatureDefinition> arthropods;
    private Collection<JsonCreatureDefinition> fish;
    private Collection<JsonCreatureDefinition> reptiles;
    private Collection<JsonCreatureDefinition> birds;

    public void parseServerEntities()
    {
        loadConfig(DinoConfig.loadDinoConfig());
        for (JsonCreatureDefinition dino : dinos)
        {
        	CreatureManager.addCreature(dino, "dinosaurs");
		}
        
        loadConfig(DinoConfig.loadReptileConfig());
        for (JsonCreatureDefinition creature : reptiles)
        {
        	CreatureManager.addCreature(creature, "reptiles");
        }

        loadConfig(DinoConfig.loadMammalConfig());
        for (JsonCreatureDefinition creature : mammals)
        {
        	CreatureManager.addCreature(creature, "mammals");
        }

        loadConfig(DinoConfig.loadBirdConfig());
        for (JsonCreatureDefinition creature : birds)
        {
        	CreatureManager.addCreature(creature, "birds");
        }

        loadConfig(DinoConfig.loadFishConfig());
        for (JsonCreatureDefinition creature : fish)
        {
        	CreatureManager.addCreature(creature, "fish");
        }

        loadConfig(DinoConfig.loadCephalopodConfig());
        for (JsonCreatureDefinition creature : cephalopods)
        {
        	CreatureManager.addCreature(creature, "cephalopods");
        }

        loadConfig(DinoConfig.loadArthropodConfig());
        for (JsonCreatureDefinition creature : arthropods)
        {
        	CreatureManager.addCreature(creature, "arthropods");
        }
    }

	@SideOnly(Side.CLIENT)
    public void parseClientEntities()
    {
        loadConfig(DinoConfig.loadDinoConfig());
        for (JsonCreatureDefinition creature : dinos)
        {
        	CreatureManager.addCreatureRenderer(creature, "dinosaurs");
        }

        loadConfig(DinoConfig.loadReptileConfig());
        for (JsonCreatureDefinition creature : reptiles)
        {
        	CreatureManager.addCreatureRenderer(creature, "reptiles");
        }

        loadConfig(DinoConfig.loadMammalConfig());
        for (JsonCreatureDefinition creature : mammals)
        {
        	CreatureManager.addCreatureRenderer(creature, "mammals");
        }

        loadConfig(DinoConfig.loadBirdConfig());
        for (JsonCreatureDefinition creature : birds)
        {
        	CreatureManager.addCreatureRenderer(creature, "birds");
        }

        loadConfig(DinoConfig.loadFishConfig());
        for (JsonCreatureDefinition creature : fish)
        {
        	CreatureManager.addCreatureRenderer(creature, "fish");
        }

        loadConfig(DinoConfig.loadCephalopodConfig());
        for (JsonCreatureDefinition creature : cephalopods)
        {
        	CreatureManager.addCreatureRenderer(creature, "cephalopods");
        }

        loadConfig(DinoConfig.loadArthropodConfig());
        for (JsonCreatureDefinition creature : arthropods)
        {
        	CreatureManager.addCreatureRenderer(creature, "arthropods");
        }
    }

    private void loadConfig(File config)
    {
        try
        {
            if (config.toString().contains("dino"))
            {
                Type collectionType = new TypeToken<Collection<JsonCreatureDefinition>>()
                {
                }.getType();

                dinos = new Gson().fromJson(new FileReader(config), collectionType);
            }

            if (config.toString().contains("reptile"))
            {
                Type collectionType = new TypeToken<Collection<JsonCreatureDefinition>>()
                {
                }.getType();

                reptiles = new Gson().fromJson(new FileReader(config), collectionType);
            }

            if (config.toString().contains("mammal"))
            {
                Type collectionType = new TypeToken<Collection<JsonCreatureDefinition>>()
                {
                }.getType();

                mammals = new Gson().fromJson(new FileReader(config), collectionType);
            }

            if (config.toString().contains("bird"))
            {
                Type collectionType = new TypeToken<Collection<JsonCreatureDefinition>>()
                {
                }.getType();

                birds = new Gson().fromJson(new FileReader(config), collectionType);
            }

            if (config.toString().contains("fish"))
            {
                Type collectionType = new TypeToken<Collection<JsonCreatureDefinition>>()
                {
                }.getType();

                fish = new Gson().fromJson(new FileReader(config), collectionType);
            }

            if (config.toString().contains("cephalopod"))
            {
                Type collectionType = new TypeToken<Collection<JsonCreatureDefinition>>()
                {
                }.getType();

                cephalopods = new Gson().fromJson(new FileReader(config), collectionType);
            }

            if (config.toString().contains("arthropod"))
            {
                Type collectionType = new TypeToken<Collection<JsonCreatureDefinition>>()
                {
                }.getType();

                arthropods = new Gson().fromJson(new FileReader(config), collectionType);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
