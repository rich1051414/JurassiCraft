package to.uk.ilexiconn.jurassicraft.entity.entity;

import net.minecraft.entity.ai.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.world.World;
import to.uk.ilexiconn.jurassicraft.Util;
import to.uk.ilexiconn.jurassicraft.entity.EntityJurassiCraftLandProtective;
import to.uk.ilexiconn.jurassicraft.entity.IDinosaur;

public class EntityBrachiosaur extends EntityJurassiCraftLandProtective implements IDinosaur
{

    public EntityBrachiosaur(World world)
    {
        super(world, (byte) 1, 1);
        this.getNavigator().setAvoidsWater(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(2, this.aiSit);
        // tasks.addTask(2, new EntityAIMate(this, 1.0D));
        tasks.addTask(4, new EntityAITempt(this, this.getCreatureSpeed(), Items.wheat, false));
        // tasks.addTask(4, new EntityAIFollowParent(this, 1.25D));
        this.tasks.addTask(5, new EntityAIWander(this, this.getCreatureSpeed()));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 12.0F));
        this.tasks.addTask(6, new EntityAILookIdle(this));
    }

    @Override
    public double getMountedYOffset()
    {
        return (double) this.getYBouningBox() * 0.95D;
    }

    @Override
    public int getTalkInterval()
    {
        return 350;
    }

    @Override
    public String getLivingSound()
    {
        if (this.rand.nextInt(2) == 0)
        {
            return Util.getDinoByID(this.getCreatureID()).livingSound1;
        }
        else
        {
            return Util.getDinoByID(this.getCreatureID()).livingSound2;
        }
    }

    @Override
    public String getHurtSound()
    {
        return Util.getDinoByID(this.getCreatureID()).hurtSound;
    }

    @Override
    public String getDeathSound()
    {
        return Util.getDinoByID(this.getCreatureID()).deathSound;
    }
}