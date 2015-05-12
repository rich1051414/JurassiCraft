package net.ilexiconn.jurassicraft.common.entity;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.io.InputStreamReader;
import java.util.Collection;

public class JsonEntityParser
{
    public Collection<CreatureJsonDef> dinos;
    public Collection<CreatureJsonDef> mammals;
    public Collection<CreatureJsonDef> cephalopods;
    public Collection<CreatureJsonDef> arthropods;
    public Collection<CreatureJsonDef> fish;
    public Collection<CreatureJsonDef> reptiles;
    public Collection<CreatureJsonDef> birds;

    public void parseServerEntities()
    {
        loadJsons();

        for (CreatureJsonDef dino : dinos) CreatureManager.addCreature(dino, "dinosaurs");
        for (CreatureJsonDef creature : reptiles) CreatureManager.addCreature(creature, "reptiles");
        for (CreatureJsonDef creature : mammals) CreatureManager.addCreature(creature, "mammals");
        for (CreatureJsonDef creature : birds) CreatureManager.addCreature(creature, "birds");
        for (CreatureJsonDef creature : fish) CreatureManager.addCreature(creature, "fish");
        for (CreatureJsonDef creature : cephalopods) CreatureManager.addCreature(creature, "cephalopods");
        for (CreatureJsonDef creature : arthropods) CreatureManager.addCreature(creature, "arthropods");
    }

    @SideOnly(Side.CLIENT)
    public void parseClientEntities() throws Exception
    {
        loadJsons();

        for (CreatureJsonDef creature : dinos) CreatureManager.addCreatureRenderer(creature, "dinosaurs");
        for (CreatureJsonDef creature : reptiles) CreatureManager.addCreatureRenderer(creature, "reptiles");
        for (CreatureJsonDef creature : mammals) CreatureManager.addCreatureRenderer(creature, "mammals");
        for (CreatureJsonDef creature : birds) CreatureManager.addCreatureRenderer(creature, "birds");
        for (CreatureJsonDef creature : fish) CreatureManager.addCreatureRenderer(creature, "fish");
        for (CreatureJsonDef creature : cephalopods) CreatureManager.addCreatureRenderer(creature, "cephalopods");
        for (CreatureJsonDef creature : arthropods) CreatureManager.addCreatureRenderer(creature, "arthropods");
    }

    public void loadJsons()
    {
        dinos = new Gson().fromJson(new InputStreamReader(JsonEntityParser.class.getResourceAsStream("/assets/jurassicraft/json/dinos.json")), new TypeToken<Collection<CreatureJsonDef>>(){}.getType());
        reptiles = new Gson().fromJson(new InputStreamReader(JsonEntityParser.class.getResourceAsStream("/assets/jurassicraft/json/reptiles.json")), new TypeToken<Collection<CreatureJsonDef>>(){}.getType());
        mammals = new Gson().fromJson(new InputStreamReader(JsonEntityParser.class.getResourceAsStream("/assets/jurassicraft/json/mammals.json")), new TypeToken<Collection<CreatureJsonDef>>(){}.getType());
        birds = new Gson().fromJson(new InputStreamReader(JsonEntityParser.class.getResourceAsStream("/assets/jurassicraft/json/birds.json")), new TypeToken<Collection<CreatureJsonDef>>(){}.getType());
        fish = new Gson().fromJson(new InputStreamReader(JsonEntityParser.class.getResourceAsStream("/assets/jurassicraft/json/fish.json")), new TypeToken<Collection<CreatureJsonDef>>(){}.getType());
        cephalopods = new Gson().fromJson(new InputStreamReader(JsonEntityParser.class.getResourceAsStream("/assets/jurassicraft/json/cephalopods.json")), new TypeToken<Collection<CreatureJsonDef>>(){}.getType());
        arthropods = new Gson().fromJson(new InputStreamReader(JsonEntityParser.class.getResourceAsStream("/assets/jurassicraft/json/arthropods.json")), new TypeToken<Collection<CreatureJsonDef>>(){}.getType());
    }
}
