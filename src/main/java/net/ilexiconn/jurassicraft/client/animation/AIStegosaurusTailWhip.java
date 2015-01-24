package net.ilexiconn.jurassicraft.client.animation;

import net.ilexiconn.jurassicraft.ai.AIAnimation;
import net.ilexiconn.jurassicraft.entity.dinosaurs.EntityStegosaurus;
import net.minecraft.entity.EntityLiving;

public class AIStegosaurusTailWhip extends AIAnimation
{
	private EntityStegosaurus stegosaurus;
	private EntityLiving attackTarget;

	public AIStegosaurusTailWhip(EntityStegosaurus stegosaurus)
	{
		super(stegosaurus);
		this.stegosaurus = stegosaurus;
		attackTarget = null;
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
		return 30;
	}

	@Override
	public void startExecuting()
	{
		super.startExecuting();
		this.attackTarget = (EntityLiving) stegosaurus.getAttackTarget();
	}

	@Override
	public void updateTask()
	{
		
	}
}
