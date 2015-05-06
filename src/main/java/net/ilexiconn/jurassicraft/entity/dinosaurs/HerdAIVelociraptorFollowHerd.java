package net.ilexiconn.jurassicraft.entity.dinosaurs;

import net.ilexiconn.jurassicraft.ai.herds.CreatureHerd;
import net.ilexiconn.jurassicraft.ai.herds.HerdAIFollowHerd;
import net.ilexiconn.jurassicraft.ai.herds.VelociraptorHerd;
import net.ilexiconn.jurassicraft.entity.EntityJurassiCraftCreature;

public class HerdAIVelociraptorFollowHerd extends HerdAIFollowHerd
{
    public HerdAIVelociraptorFollowHerd(EntityJurassiCraftCreature creature, double speed)
    {
        super(creature, true, speed);
    }

    protected CreatureHerd createHerd()
    {
        return new VelociraptorHerd();
    }

}
