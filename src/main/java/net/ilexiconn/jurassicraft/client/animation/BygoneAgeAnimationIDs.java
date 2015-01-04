package net.ilexiconn.jurassicraft.client.animation;

public enum BygoneAgeAnimationIDs
{
	ANIMATION_BITE((byte) 1),
	ANIMATION_HEADBUTT((byte) 2),
	ANIMATION_PECK((byte) 3);

	private final byte animationID;

	private BygoneAgeAnimationIDs(byte id)
	{
		animationID = id;
	}
	
	public int getAnimationID()
	{
		return (int) animationID;
	}
}