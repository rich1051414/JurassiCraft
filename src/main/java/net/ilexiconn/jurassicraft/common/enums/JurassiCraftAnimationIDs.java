package net.ilexiconn.jurassicraft.common.enums;

public enum JurassiCraftAnimationIDs
{
    BITE(1), HEADBUTT(2), PECK(3), TAIL_SLAM(4), TAIL_WHIP(5), SCRATCH(6), TRUMPET(7), CHARGE(8), LEAP(9), TWITCH_HEAD(10), WALK_ROAR(11), ROAR(12), BEING_EATEN(13), EATING(14), PLAYING(15), SOCIALIZING(15), SPITTING(16);

    private int animationID;

    JurassiCraftAnimationIDs(int id)
    {
        animationID = id;
    }

    public int animID()
    {
        return animationID;
    }
}
