package net.ilexiconn.jurassicraft.client.animation;

import net.ilexiconn.jurassicraft.ai.AIAnimation;
import net.ilexiconn.jurassicraft.entity.EntityJurassiCraftSmart;

public class AITailWhip extends AIAnimation
{
	private int duration;

	public AITailWhip(EntityJurassiCraftSmart creature, int duration)
	{
		super(creature);
		this.duration = duration;
	}

	@Override
	public int getAnimationId()
	{
		return JurassiCraftAnimationIDs.TAIL_WHIP.animID();
	}

	@Override
	public boolean isAutomatic()
	{
		return true;
	}

	@Override
	public int getDuration()
	{
		return this.duration;
	}
}
