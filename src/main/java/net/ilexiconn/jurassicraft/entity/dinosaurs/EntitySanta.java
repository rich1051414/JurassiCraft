package net.ilexiconn.jurassicraft.entity.dinosaurs;

import net.ilexiconn.jurassicraft.ai.JurassiCraftAIEatDroppedFood;
import net.ilexiconn.jurassicraft.ai.JurassiCraftAIFollowFoodCoward;
import net.ilexiconn.jurassicraft.ai.JurassiCraftAIWander;
import net.ilexiconn.jurassicraft.entity.CreatureManager;
import net.ilexiconn.jurassicraft.entity.EntityJurassiCraftRidable;
import net.ilexiconn.jurassicraft.interfaces.IDinosaur;
import net.minecraft.block.material.Material;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntitySanta extends EntityJurassiCraftRidable
{
    public EntitySanta(World world)
    {
        super(world, CreatureManager.classToCreature(EntitySanta.class));
        this.getNavigator().setAvoidsWater(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(2, this.aiSit);
        this.tasks.addTask(3, new EntityAIAvoidEntity(this, EntityHerrerasaurus.class, 16.0F, 1.0D * this.getCreatureSpeed(), 1.2D * this.getCreatureSpeed()));
        this.tasks.addTask(4, new JurassiCraftAIFollowFoodCoward(this, 1.1D * this.getCreatureSpeed()));
        this.tasks.addTask(4, new JurassiCraftAIEatDroppedFood(this, 16.0D));
        this.tasks.addTask(5, new JurassiCraftAIWander(this, 0.8D * this.getCreatureSpeed()));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(6, new EntityAILookIdle(this));

        this.setCreatureExperiencePoints(800);
    }

    @Override
    public int getTalkInterval()
    {
        return 350;
    }


    @Override
    public void onLivingUpdate()
    {
        super.onLivingUpdate();

        int i = MathHelper.floor_double(this.posX);
        int j = MathHelper.floor_double(this.posY);
        int k = MathHelper.floor_double(this.posZ);

        for (int l = 0; l < 4; ++l)
        {
            i = MathHelper.floor_double(this.posX + (double) ((float) (l % 2 * 2 - 1) * 0.25F));
            j = MathHelper.floor_double(this.posY);
            k = MathHelper.floor_double(this.posZ + (double) ((float) (l / 2 % 2 * 2 - 1) * 0.25F));

            if ((this.worldObj.getBlock(i, j, k).getMaterial() == Material.air || this.worldObj.getBlock(i, j, k).getMaterial() == Material.grass) && Blocks.snow_layer.canPlaceBlockAt(this.worldObj, i, j, k))
            {
                this.worldObj.setBlock(i, j, k, Blocks.snow_layer);
                this.worldObj.setBlock(i + 1, j, k, Blocks.snow_layer);
                this.worldObj.setBlock(i + 1, j, k + 1, Blocks.snow_layer);
                this.worldObj.setBlock(i + 1, j, k - 1, Blocks.snow_layer);
                this.worldObj.setBlock(i, j, k - 1, Blocks.snow_layer);
                this.worldObj.setBlock(i, j, k + 1, Blocks.snow_layer);
                this.worldObj.setBlock(i - 1, j, k + 1, Blocks.snow_layer);
                this.worldObj.setBlock(i - 1, j, k - 1, Blocks.snow_layer);
                this.worldObj.setBlock(i - 1, j, k, Blocks.snow_layer);
            }
        }
    }
}