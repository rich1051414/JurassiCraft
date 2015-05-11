package net.ilexiconn.jurassicraft.common.api;

public class RandomRyanShit
{
    public static boolean checkForClass(String className)
    {
        try
        {
            Class.forName(className);
            return true;
        }
        catch (ClassNotFoundException exception)
        {
            return false;
        }
    }
}
