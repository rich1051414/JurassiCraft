package net.ilexiconn.jurassicraft.common.entity.fish;

import net.ilexiconn.jurassicraft.client.model.base.ChainBuffer;
import net.ilexiconn.jurassicraft.common.entity.EntitySwimmingBase;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityOrthacanthus extends EntitySwimmingBase
{
    public ChainBuffer tailBuffer = new ChainBuffer(6);

    public EntityOrthacanthus(World world)
    {
        super(world);

        this.swimSpeed = 2.2F;
        huntingInterval = 200;
        this.setHungry(huntingInterval);

        this.setCreatureExperiencePoints(50);
    }

    public void onUpdate()
    {
        super.onUpdate();
        this.tailBuffer.calculateChainSwingBuffer(65.0F, 3, 4.0F, this);
    }

    protected void dropFewItems(boolean recentlyBeenHit, int enchantBonus)
    {
        this.dropItemStackWithGenetics(new ItemStack(this.getCreature().getMeat(), 1));
    }

    public EntityLivingBase getTargetPriority(EntityLivingBase Target, EntityLivingBase entity1)
    {
        if (Target != null)
        {
            if (entity1 instanceof EntitySquid) //Goes for squid first
                return entity1;
            else if (entity1 instanceof EntityPlayer) //Then players
                return entity1;
            else
                return Target; //Then if Orthacanthus is only entity around. Boo cannibalism
        }
        else if (entity1 instanceof EntitySquid || entity1 instanceof EntityPlayer || entity1 instanceof EntityOrthacanthus)
            return entity1;
        return null;
    }
}
