package net.ilexiconn.jurassicraft.config;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collection;

import net.ilexiconn.jurassicraft.entity.JsonEntityParser;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

public class DinoConfig
{
	public static void loadDinoConfig(JsonEntityParser parser)
	{
		File file = new File("json");
		
		try
		{
			parser.dinos = new Gson().fromJson(new InputStreamReader(DinoConfig.class.getResourceAsStream("/json/dinos.json")), new 
			TypeToken<Collection<JsonCreatureDefinition>>(){}.getType());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void loadReptileConfig(JsonEntityParser parser)	{
		try
		{
			parser.reptiles = new Gson().fromJson(new InputStreamReader(DinoConfig.class.getResourceAsStream("/json/reptiles.json")), 
					new TypeToken<Collection<JsonCreatureDefinition>>(){}.getType());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void loadMammalConfig(JsonEntityParser parser)	{
		try
		{
			parser.mammals = new Gson().fromJson(new InputStreamReader(DinoConfig.class.getResourceAsStream("/json/mammals.json")), 
					new TypeToken<Collection<JsonCreatureDefinition>>(){}.getType());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}


	public static void loadBirdConfig(JsonEntityParser parser)	{
		try
		{
			parser.birds = new Gson().fromJson(new InputStreamReader(DinoConfig.class.getResourceAsStream("/json/birds.json")), 
					new TypeToken<Collection<JsonCreatureDefinition>>(){}.getType());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}


	public static void loadFishConfig(JsonEntityParser parser)	{
		try
		{
			parser.fish = new Gson().fromJson(new InputStreamReader(DinoConfig.class.getResourceAsStream("/json/fish.json")), 
					new TypeToken<Collection<JsonCreatureDefinition>>(){}.getType());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void loadCephalopodConfig(JsonEntityParser parser)	{
		try
		{
			parser.cephalopods = new Gson().fromJson(new InputStreamReader(DinoConfig.class.getResourceAsStream("/json/cephalopods.json")), 
					new TypeToken<Collection<JsonCreatureDefinition>>(){}.getType());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void loadArthropodConfig(JsonEntityParser parser)	{
		try
		{
			parser.arthropods = new Gson().fromJson(new InputStreamReader(DinoConfig.class.getResourceAsStream("/json/arthropods.json")), 
					new TypeToken<Collection<JsonCreatureDefinition>>(){}.getType());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
