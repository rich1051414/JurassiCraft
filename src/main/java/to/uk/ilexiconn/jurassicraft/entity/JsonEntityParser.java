package to.uk.ilexiconn.jurassicraft.entity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import to.uk.ilexiconn.jurassicraft.Util;

import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.Collection;

public class JsonEntityParser extends Util
{
    public Collection<Entities> dinos;
    private Collection<Entities> mammals;
    private Collection<Entities> cephalopods;
    private Collection<Entities> arthropods;
    private Collection<Entities> Fish;
    private Collection<Entities> reptiles;
    private Collection<Entities> birds;

    public void parseServerEntities()
    {
        loadConfig(DinoConfig.loadDinoConfig());
        loadConfig(DinoConfig.loadArthropodConfig());
        loadConfig(DinoConfig.loadBirdConfig());
        loadConfig(DinoConfig.loadCephalopodConfig());
        loadConfig(DinoConfig.loadFishConfig());
        loadConfig(DinoConfig.loadMammalConfig());
        loadConfig(DinoConfig.loadReptileConfig());

        for (Entities dino : dinos)
        {
            addDinoEntity(dino);
            if (dino.addEgg)
                addEgg(dino.creatureName);
            if (dino.addSyringe)
                addSyringe(dino.creatureName);
            if (dino.addMeat)
                addMeat(dino.creatureName);
            if (dino.addDNA)
                addDNA(dino.creatureName);
		}
        
        for (Entities creature : reptiles)
        {
            addReptileEntity(creature);
            if (creature.addEgg)
                addEgg(creature.creatureName);
            if (creature.addSyringe)
                addSyringe(creature.creatureName);
            if (creature.addMeat)
                addMeat(creature.creatureName);
            if (creature.addDNA)
                addDNA(creature.creatureName);
        }

        loadConfig(DinoConfig.loadMammalConfig());
        for (Entities creature : mammals)
        {
            addMammalEntity(creature);
            if (creature.addEgg)
                addEgg(creature.creatureName);
            if (creature.addSyringe)
                addSyringe(creature.creatureName);
            if (creature.addMeat)
                addMeat(creature.creatureName);
            if (creature.addDNA)
                addDNA(creature.creatureName);
        }

        loadConfig(DinoConfig.loadBirdConfig());
        for (Entities creature : birds)
        {
            addBirdEntity(creature);
            if (creature.addEgg)
                addEgg(creature.creatureName);
            if (creature.addSyringe)
                addSyringe(creature.creatureName);
            if (creature.addMeat)
                addMeat(creature.creatureName);
            if (creature.addDNA)
                addDNA(creature.creatureName);
        }

        loadConfig(DinoConfig.loadFishConfig());
        for (Entities creature : Fish)
        {
            addFishEntity(creature);
            if (creature.addEgg)
                addEgg(creature.creatureName);
            if (creature.addSyringe)
                addSyringe(creature.creatureName);
            if (creature.addMeat)
                addMeat(creature.creatureName);
            if (creature.addDNA)
                addDNA(creature.creatureName);
        }

        loadConfig(DinoConfig.loadCephalopodConfig());
        for (Entities creature : cephalopods)
        {
            addCephalopodaEntity(creature);
            if (creature.addEgg)
                addEgg(creature.creatureName);
            if (creature.addSyringe)
                addSyringe(creature.creatureName);
            if (creature.addMeat)
                addMeat(creature.creatureName);
            if (creature.addDNA)
                addDNA(creature.creatureName);
        }

        loadConfig(DinoConfig.loadArthropodConfig());
        for (Entities creature : arthropods)
        {
            addArthropodEntity(creature);
            if (creature.addEgg)
                addEgg(creature.creatureName);
            if (creature.addSyringe)
                addSyringe(creature.creatureName);
            if (creature.addMeat)
                addMeat(creature.creatureName);
            if (creature.addDNA)
                addDNA(creature.creatureName);
        }
    }

    @SideOnly(Side.CLIENT)
    public void parseClientEntities()
    {
        loadConfig(DinoConfig.loadDinoConfig());
        for (Entities creature : dinos)
        {
            addDinoEntityRenderer(creature);
        }

        loadConfig(DinoConfig.loadReptileConfig());
        for (Entities creature : reptiles)
        {
            addReptileEntityRenderer(creature);
        }

        loadConfig(DinoConfig.loadMammalConfig());
        for (Entities creature : mammals)
        {
            addMammalEntityRenderer(creature);
        }

        loadConfig(DinoConfig.loadBirdConfig());
        for (Entities creature : birds)
        {
            addBirdEntityRenderer(creature);
        }

        loadConfig(DinoConfig.loadFishConfig());
        for (Entities creature : Fish)
        {
            addFishEntityRenderer(creature);
        }

        loadConfig(DinoConfig.loadCephalopodConfig());
        for (Entities creature : cephalopods)
        {
            addCephalopodaEntityRenderer(creature);
        }

        loadConfig(DinoConfig.loadArthropodConfig());
        for (Entities creature : arthropods)
        {
            addBirdEntityRenderer(creature);
        }
    }

    private void loadConfig(File config)
    {
        try
        {
            if (config.toString().contains("dino"))
            {
                Type collectionType = new TypeToken<Collection<Entities>>()
                {
                }.getType();

                dinos = new Gson().fromJson(new FileReader(config), collectionType);
            }

            if (config.toString().contains("reptile"))
            {
                Type collectionType = new TypeToken<Collection<Entities>>()
                {
                }.getType();

                reptiles = new Gson().fromJson(new FileReader(config), collectionType);
            }

            if (config.toString().contains("mammal"))
            {
                Type collectionType = new TypeToken<Collection<Entities>>()
                {
                }.getType();

                mammals = new Gson().fromJson(new FileReader(config), collectionType);
            }

            if (config.toString().contains("bird"))
            {
                Type collectionType = new TypeToken<Collection<Entities>>()
                {
                }.getType();

                birds = new Gson().fromJson(new FileReader(config), collectionType);
            }

            if (config.toString().contains("fish"))
            {
                Type collectionType = new TypeToken<Collection<Entities>>()
                {
                }.getType();

                Fish = new Gson().fromJson(new FileReader(config), collectionType);
            }

            if (config.toString().contains("cephalopod"))
            {
                Type collectionType = new TypeToken<Collection<Entities>>()
                {
                }.getType();

                cephalopods = new Gson().fromJson(new FileReader(config), collectionType);
            }

            if (config.toString().contains("arthropod"))
            {
                Type collectionType = new TypeToken<Collection<Entities>>()
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
