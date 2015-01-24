package net.ilexiconn.jurassicraft.client.animation;

public enum JurassiCraftAnimationIDs
{
	ANIMATION_BITE((byte) 1),
	ANIMATION_HEADBUTT((byte) 2),
	ANIMATION_PECK((byte) 3),
	ANIMATION_TAIL_SLAM((byte) 4),
	ANIMATION_TAIL_WHIP((byte) 5),
	ANIMATION_SCRATCH((byte) 6),
	ANIMATION_TRUMPET((byte) 7),
	ANIMATION_CHARGE((byte) 8),
	ANIMATION_LEAP((byte) 9),
	ANIMATION_TWITCH_HEAD((byte) 10),
	ANIMATION_WALK_ROAR((byte) 11),
	ANIMATION_ROAR((byte) 12),
	ANIMATION_BEING_EATEN((byte) 13),
	ANIMATION_EATING((byte) 14),
	ANIMATION_PLAYING((byte) 15);

	private JurassiCraftAnimationIDs(byte id)
	{
		animationID = id;
	}

	public int getAnimationID()
	{
		return (int) this.animationID;
	}

	public int animID()
	{
		return (int) this.animationID;
	}

	private final byte animationID;
}
