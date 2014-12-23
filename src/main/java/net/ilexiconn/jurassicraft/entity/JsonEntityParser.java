package net.ilexiconn.jurassicraft.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.ilexiconn.jurassicraft.Util;

import java.util.Collection;

public class JsonEntityParser extends Util
{
    public Collection<Entities> dinos;
    public Collection<Entities> mammals;
    public Collection<Entities> cephalopods;
    public Collection<Entities> arthropods;
    public Collection<Entities> fish;
    public Collection<Entities> reptiles;
    public Collection<Entities> birds;

    public void parseServerEntities()
    {
        DinoConfig.loadDinoConfig(this);
        for (Entities dino : dinos)
        {
            addDinoEntity(dino);
            if (dino.addEgg)
                addEgg(dino);
            if (dino.addSyringe)
                addSyringe(dino);
            if (dino.addMeat)
                addMeat(dino);
            if (dino.addDNA)
                addDNA(dino);
		}
        
        DinoConfig.loadReptileConfig(this);
        for (Entities creature : reptiles)
        {
            addReptileEntity(creature);
            if (creature.addEgg)
                addEgg(creature);
            if (creature.addSyringe)
                addSyringe(creature);
            if (creature.addMeat)
                addMeat(creature);
            if (creature.addDNA)
                addDNA(creature);
        }

        DinoConfig.loadMammalConfig(this);
        for (Entities creature : mammals)
        {
            addMammalEntity(creature);
            if (creature.addEgg)
                addEgg(creature);
            if (creature.addSyringe)
                addSyringe(creature);
            if (creature.addMeat)
                addMeat(creature);
            if (creature.addDNA)
                addDNA(creature);
        }

        DinoConfig.loadBirdConfig(this);
        for (Entities creature : birds)
        {
            addBirdEntity(creature);
            if (creature.addEgg)
                addEgg(creature);
            if (creature.addSyringe)
                addSyringe(creature);
            if (creature.addMeat)
                addMeat(creature);
            if (creature.addDNA)
                addDNA(creature);
        }

        DinoConfig.loadFishConfig(this);
        for (Entities creature : fish)
        {
            addFishEntity(creature);
            if (creature.addEgg)
                addEgg(creature);
            if (creature.addSyringe)
                addSyringe(creature);
            if (creature.addMeat)
                addMeat(creature);
            if (creature.addDNA)
                addDNA(creature);
        }

        DinoConfig.loadCephalopodConfig(this);
        for (Entities creature : cephalopods)
        {
            addCephalopodaEntity(creature);
            if (creature.addEgg)
                addEgg(creature);
            if (creature.addSyringe)
                addSyringe(creature);
            if (creature.addMeat)
                addMeat(creature);
            if (creature.addDNA)
                addDNA(creature);
        }

        DinoConfig.loadArthropodConfig(this);
        for (Entities creature : arthropods)
        {
            addArthropodEntity(creature);
            if (creature.addEgg)
                addEgg(creature);
            if (creature.addSyringe)
                addSyringe(creature);
            if (creature.addMeat)
                addMeat(creature);
            if (creature.addDNA)
                addDNA(creature);
        }
    }

    @SideOnly(Side.CLIENT)
    public void parseClientEntities()
    {
        DinoConfig.loadDinoConfig(this);
        for (Entities creature : dinos)
        {
            addDinoEntityRenderer(creature);
        }

        DinoConfig.loadReptileConfig(this);
        for (Entities creature : reptiles)
        {
            addReptileEntityRenderer(creature);
        }

        DinoConfig.loadMammalConfig(this);
        for (Entities creature : mammals)
        {
            addMammalEntityRenderer(creature);
        }

        DinoConfig.loadBirdConfig(this);
        for (Entities creature : birds)
        {
            addBirdEntityRenderer(creature);
        }

        DinoConfig.loadFishConfig(this);
        for (Entities creature : fish)
        {
            addFishEntityRenderer(creature);
        }

        DinoConfig.loadCephalopodConfig(this);
        for (Entities creature : cephalopods)
        {
            addCephalopodaEntityRenderer(creature);
        }

        DinoConfig.loadArthropodConfig(this);
        for (Entities creature : arthropods)
        {
            addArthropodEntityRenderer(creature);
        }
    }
}
