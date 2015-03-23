package net.ilexiconn.jurassicraft.entity.fish;

import net.ilexiconn.jurassicraft.client.model.modelbase.ChainBuffer;
import net.ilexiconn.jurassicraft.entity.CreatureManager;
import net.ilexiconn.jurassicraft.entity.EntitySwimmingBase;
import net.ilexiconn.jurassicraft.interfaces.IFish;
import net.ilexiconn.jurassicraft.interfaces.IPiscivore;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityOrthacanthus extends EntitySwimmingBase implements IFish, IPiscivore
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
    
    @Override
    public void onUpdate()
    {
        super.onUpdate();
        this.tailBuffer.calculateChainSwingBuffer(65.0F, 3, 4.0F, this);
    }
    
    @Override
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
