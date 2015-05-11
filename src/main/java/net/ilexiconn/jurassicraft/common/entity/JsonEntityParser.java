package net.ilexiconn.jurassicraft.common.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.ilexiconn.jurassicraft.common.dinoconfig.DinoConfig;
import net.ilexiconn.jurassicraft.common.dinoconfig.JsonCreatureDefinition;

import java.util.Collection;

public class JsonEntityParser
{
    public Collection<JsonCreatureDefinition> dinos;
    public Collection<JsonCreatureDefinition> mammals;
    public Collection<JsonCreatureDefinition> cephalopods;
    public Collection<JsonCreatureDefinition> arthropods;
    public Collection<JsonCreatureDefinition> fish;
    public Collection<JsonCreatureDefinition> reptiles;
    public Collection<JsonCreatureDefinition> birds;

    public void parseServerEntities()
    {
        DinoConfig.loadDinoConfig(this);
        for (JsonCreatureDefinition dino : dinos)
        {
            CreatureManager.addCreature(dino, "dinosaurs");
        }

        DinoConfig.loadReptileConfig(this);
        for (JsonCreatureDefinition creature : reptiles)
        {
            CreatureManager.addCreature(creature, "reptiles");
        }

        DinoConfig.loadMammalConfig(this);
        for (JsonCreatureDefinition creature : mammals)
        {
            CreatureManager.addCreature(creature, "mammals");
        }

        DinoConfig.loadBirdConfig(this);
        for (JsonCreatureDefinition creature : birds)
        {
            CreatureManager.addCreature(creature, "birds");
        }

        DinoConfig.loadFishConfig(this);
        for (JsonCreatureDefinition creature : fish)
        {
            CreatureManager.addCreature(creature, "fish");
        }

        DinoConfig.loadCephalopodConfig(this);
        for (JsonCreatureDefinition creature : cephalopods)
        {
            CreatureManager.addCreature(creature, "cephalopods");
        }

        DinoConfig.loadArthropodConfig(this);
        for (JsonCreatureDefinition creature : arthropods)
        {
            CreatureManager.addCreature(creature, "arthropods");
        }
    }

    @SideOnly(Side.CLIENT)
    public void parseClientEntities()
    {
        DinoConfig.loadDinoConfig(this);
        for (JsonCreatureDefinition creature : dinos)
        {
            CreatureManager.addCreatureRenderer(creature, "dinosaurs");
        }

        DinoConfig.loadReptileConfig(this);
        for (JsonCreatureDefinition creature : reptiles)
        {
            CreatureManager.addCreatureRenderer(creature, "reptiles");
        }

        DinoConfig.loadMammalConfig(this);
        for (JsonCreatureDefinition creature : mammals)
        {
            CreatureManager.addCreatureRenderer(creature, "mammals");
        }

        DinoConfig.loadBirdConfig(this);
        for (JsonCreatureDefinition creature : birds)
        {
            CreatureManager.addCreatureRenderer(creature, "birds");
        }

        DinoConfig.loadFishConfig(this);
        for (JsonCreatureDefinition creature : fish)
        {
            CreatureManager.addCreatureRenderer(creature, "fish");
        }

        DinoConfig.loadCephalopodConfig(this);
        for (JsonCreatureDefinition creature : cephalopods)
        {
            CreatureManager.addCreatureRenderer(creature, "cephalopods");
        }

        DinoConfig.loadArthropodConfig(this);
        for (JsonCreatureDefinition creature : arthropods)
        {
            CreatureManager.addCreatureRenderer(creature, "arthropods");
        }
    }
}
