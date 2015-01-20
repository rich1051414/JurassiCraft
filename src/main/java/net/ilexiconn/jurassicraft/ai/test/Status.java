package net.ilexiconn.jurassicraft.ai.test;

public class Status {

	/** SOCIALIZING represents whether the creature is socializing. (000000001) */
	public static final int SOCIALIZING = 1;
	/** DEFENDING represents whether the creature is defending itself. (000000010) */
	public static final int DEFENDING = 2;
	/** STRESSED represents whether the creature is afraid of something. (000000100) */
	public static final int STRESSED = 4;
	/** SLEEPY represents whether the creature is sleeping. (000001000) */
	public static final int SLEEPING = 8;
	/** SITTING represents whether the creature is sitting. (000010000) */
	public static final int SITTING = 16;
	/** THIRSTY represents whether the creature is thirsty. (000100000) */
	public static final int THIRSTY = 32;
	/** INJURY represents whether the creature is injured. (001000000) */
	public static final int INJURED = 64;
	/** HUNGRY represents whether the creature is hungry. (010000000) */
	public static final int HUNGRY = 128;
	/** WANDERING represents whether the creature is tamed or not. (100000000) */
	public static final int TAMED = 256;

}
