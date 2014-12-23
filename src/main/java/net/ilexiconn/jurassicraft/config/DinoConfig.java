package net.ilexiconn.jurassicraft.config;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class DinoConfig
{
	public static File loadDinoConfig()
	{
		File file = new File("json");
		
		try
		{
			File tempFile = File.createTempFile("dinos", ".json", file);
			tempFile.deleteOnExit();
			InputStream in = DinoConfig.class.getResourceAsStream("/json/dinos.json");
			FileOutputStream out = new FileOutputStream(tempFile);
			org.apache.commons.io.IOUtils.copy(in, out);
			return tempFile;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public static File loadReptileConfig()
	{
		try
		{
			File tempFile = File.createTempFile("reptiles", ".json", new File("json"));
			tempFile.deleteOnExit();
			InputStream in = DinoConfig.class.getResourceAsStream("/json/reptiles.json");
			FileOutputStream out = new FileOutputStream(tempFile);
			org.apache.commons.io.IOUtils.copy(in, out);
			return tempFile;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public static File loadMammalConfig()
	{
		try
		{
			File tempFile = File.createTempFile("mammals", ".json", new File("json"));
			tempFile.deleteOnExit();
			InputStream in = DinoConfig.class.getResourceAsStream("/json/mammals.json");
			FileOutputStream out = new FileOutputStream(tempFile);
			org.apache.commons.io.IOUtils.copy(in, out);
			return tempFile;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}


	public static File loadBirdConfig()
	{
		try
		{
			File tempFile = File.createTempFile("birds", ".json", new File("json"));
			tempFile.deleteOnExit();
			InputStream in = DinoConfig.class.getResourceAsStream("/json/birds.json");
			FileOutputStream out = new FileOutputStream(tempFile);
			org.apache.commons.io.IOUtils.copy(in, out);
			return tempFile;
		}
		catch (Exception e)
		{
			return null;
		}
	}


	public static File loadFishConfig()
	{
		try
		{
			File tempFile = File.createTempFile("fish", ".json", new File("json"));
			tempFile.deleteOnExit();
			InputStream in = DinoConfig.class.getResourceAsStream("/json/fish.json");
			FileOutputStream out = new FileOutputStream(tempFile);
			org.apache.commons.io.IOUtils.copy(in, out);
			return tempFile;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public static File loadCephalopodConfig()
	{
		try
		{
			File tempFile = File.createTempFile("cephalopods", ".json", new File("json"));
			tempFile.deleteOnExit();
			InputStream in = DinoConfig.class.getResourceAsStream("/json/cephalopods.json");
			FileOutputStream out = new FileOutputStream(tempFile);
			org.apache.commons.io.IOUtils.copy(in, out);
			return tempFile;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public static File loadArthropodConfig()
	{
		try
		{
			File tempFile = File.createTempFile("arthropods", ".json", new File("json"));
			tempFile.deleteOnExit();
			InputStream in = DinoConfig.class.getResourceAsStream("/json/arthropods.json");
			FileOutputStream out = new FileOutputStream(tempFile);
			org.apache.commons.io.IOUtils.copy(in, out);
			return tempFile;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
}
