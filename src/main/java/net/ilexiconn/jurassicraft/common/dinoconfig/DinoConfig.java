package net.ilexiconn.jurassicraft.common.dinoconfig;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import net.ilexiconn.jurassicraft.common.entity.JsonEntityParser;

import java.io.InputStreamReader;
import java.util.Collection;

public class DinoConfig
{
    public static void loadDinoConfig(JsonEntityParser parser)
    {
        try
        {
            parser.dinos = new Gson().fromJson(new InputStreamReader(DinoConfig.class.getResourceAsStream("/assets/jurassicraft/json/dinos.json")), new TypeToken<Collection<JsonCreatureDefinition>>()
            {
            }.getType());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void loadReptileConfig(JsonEntityParser parser)
    {
        try
        {
            parser.reptiles = new Gson().fromJson(new InputStreamReader(DinoConfig.class.getResourceAsStream("/assets/jurassicraft/json/reptiles.json")), new TypeToken<Collection<JsonCreatureDefinition>>()
            {
            }.getType());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void loadMammalConfig(JsonEntityParser parser)
    {
        try
        {
            parser.mammals = new Gson().fromJson(new InputStreamReader(DinoConfig.class.getResourceAsStream("/assets/jurassicraft/json/mammals.json")), new TypeToken<Collection<JsonCreatureDefinition>>()
            {
            }.getType());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void loadBirdConfig(JsonEntityParser parser)
    {
        try
        {
            parser.birds = new Gson().fromJson(new InputStreamReader(DinoConfig.class.getResourceAsStream("/assets/jurassicraft/json/birds.json")), new TypeToken<Collection<JsonCreatureDefinition>>()
            {
            }.getType());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void loadFishConfig(JsonEntityParser parser)
    {
        try
        {
            parser.fish = new Gson().fromJson(new InputStreamReader(DinoConfig.class.getResourceAsStream("/assets/jurassicraft/json/fish.json")), new TypeToken<Collection<JsonCreatureDefinition>>()
            {
            }.getType());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void loadCephalopodConfig(JsonEntityParser parser)
    {
        try
        {
            parser.cephalopods = new Gson().fromJson(new InputStreamReader(DinoConfig.class.getResourceAsStream("/assets/jurassicraft/json/cephalopods.json")), new TypeToken<Collection<JsonCreatureDefinition>>()
            {
            }.getType());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void loadArthropodConfig(JsonEntityParser parser)
    {
        try
        {
            parser.arthropods = new Gson().fromJson(new InputStreamReader(DinoConfig.class.getResourceAsStream("/assets/jurassicraft/json/arthropods.json")), new TypeToken<Collection<JsonCreatureDefinition>>()
            {
            }.getType());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
