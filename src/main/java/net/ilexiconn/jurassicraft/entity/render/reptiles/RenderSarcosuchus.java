package net.ilexiconn.jurassicraft.entity.render.reptiles;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.client.model.entity.ModelSarcosuchus;
import net.ilexiconn.jurassicraft.config.JsonCreatureDefinition;
import net.ilexiconn.jurassicraft.entity.render.RenderReptile;
import net.ilexiconn.jurassicraft.entity.reptiles.EntitySarcosuchus;

@SideOnly(Side.CLIENT)
public class RenderSarcosuchus extends RenderReptile
{
    public RenderSarcosuchus(JsonCreatureDefinition reptile)
    {
        super(new ModelSarcosuchus(), reptile, 0.5F);
    }

    @Override
    public ResourceLocation getEntityTexture(Entity entity)
    {
    	EntitySarcosuchus reptile = (EntitySarcosuchus) entity;
        if (reptile.isMale())
        {
            switch (reptile.getCreatureTexture()) {
            	case 0:
            		return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Sarcosuchus_Wetlands_Male_1.png");
            	case 1:
            		return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Sarcosuchus_Arid_Male_1.png");
            	default:
            		return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Sarcosuchus_Wetlands_Male_1.png");
            }
        } 
        else 
        {
        	switch (reptile.getCreatureTexture()) {
            	case 0:
            		return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Sarcosuchus_Wetlands_Female_1.png");
            	case 1:
            		return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Sarcosuchus_Arid_Female_1.png");
            	default:
            		return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Sarcosuchus_Wetlands_Female_1.png");
            }
        }
    }
}
