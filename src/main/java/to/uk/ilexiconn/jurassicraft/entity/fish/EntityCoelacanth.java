package to.uk.ilexiconn.jurassicraft.entity.fish;

import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import to.uk.ilexiconn.jurassicraft.Util;
import to.uk.ilexiconn.jurassicraft.entity.EntitySwimming;

public class EntityCoelacanth extends EntitySwimming
{

    public EntityCoelacanth(World world)
    {
        super(world, (byte) Util.classToId(EntityCoelacanth.class));
        this.swimRadius = 8.0F;
        this.swimRadiusHeight = 4.0F;
        this.swimSpeed = 0.4F;
        this.jumpOnLand = false;

        this.setCreatureExperiencePoints(50);
    }

    @Override
    protected Entity findEntityToAttack()
    {
        return null;
    }

    @Override
    protected String getLivingSound()
    {
        return null;
    }

    @Override
    protected String getHurtSound()
    {
        return null;
    }

    @Override
    protected String getDeathSound()
    {
        return null;
    }

    @Override
    public Item getDropItem()
    {
        return Util.getMeat(Util.getCreatureFromId(this.getCreatureID()));
    }

	@Override
	protected void dropFewItems(boolean recentlyBeenHit, int enchantBonus) 
	{
		 this.dropItem(Util.getMeat(Util.getCreatureFromId(this.getCreatureID())), 1);
	}
}
