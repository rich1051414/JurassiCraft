package net.ilexiconn.jurassicraft.ai.animation;

import net.ilexiconn.jurassicraft.ai.AIAnimation;
import net.ilexiconn.jurassicraft.entity.EntityJurassiCraftSmart;
import net.ilexiconn.jurassicraft.enums.JurassiCraftAnimationIDs;

public class AnimationAITailWhip extends AIAnimation
{
	private int duration;

	public AnimationAITailWhip(EntityJurassiCraftSmart creature, int duration)
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
