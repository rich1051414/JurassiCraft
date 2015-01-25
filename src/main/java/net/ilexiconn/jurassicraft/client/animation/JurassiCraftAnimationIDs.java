package net.ilexiconn.jurassicraft.client.animation;

public enum JurassiCraftAnimationIDs
{
	BITE((byte) 1),
	HEADBUTT((byte) 2),
	PECK((byte) 3),
	TAIL_SLAM((byte) 4),
	TAIL_WHIP((byte) 5),
	SCRATCH((byte) 6),
	TRUMPET((byte) 7),
	CHARGE((byte) 8),
	LEAP((byte) 9),
	TWITCH_HEAD((byte) 10),
	WALK_ROAR((byte) 11),
	ROAR((byte) 12),
	BEING_EATEN((byte) 13),
	EATING((byte) 14),
	PLAYING((byte) 15);

	private JurassiCraftAnimationIDs(byte id)
	{
		animationID = id;
	}

	public int animID()
	{
		return (int) this.animationID;
	}

	private final byte animationID;
}
