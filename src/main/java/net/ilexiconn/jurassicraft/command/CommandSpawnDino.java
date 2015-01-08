package net.ilexiconn.jurassicraft.command;

import net.ilexiconn.jurassicraft.entity.CreatureManager;
import net.ilexiconn.jurassicraft.entity.EntityJurassiCraftCreature;
import net.ilexiconn.jurassicraft.item.JurassiCraftDNAHandler;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import java.util.List;

public class CommandSpawnDino extends CommandBase
{
    public String getCommandName()
    {
        return "spawndino";
    }

    public int getRequiredPermissionLevel()
    {
        return 2;
    }

    public String getCommandUsage(ICommandSender sender)
    {
        return "commands.spawndino.usage";
    }

    public void processCommand(ICommandSender sender, String[] args)
    {
        if (args.length < 5)
        {
            throw new WrongUsageException("commands.spawndino.usage");
        }
        spawnCreature(sender.getEntityWorld(), parseInt(sender, args[2]), parseInt(sender, args[3]), parseInt(sender, args[4]), args[0], Boolean.parseBoolean(args[1]));
    }

    public List addTabCompletionOptions(ICommandSender sender, String[] args)
    {
        return args.length == 1 ? getListOfStringsMatchingLastWord(args, CreatureManager.getCreatureNames()) : (args.length == 2 ? getListOfStringsMatchingLastWord(args, "true", "false") : null);
    }

    public void spawnCreature(World world, int x, int y, int z, String name, boolean adult)
    {
        Class creatureClass = CreatureManager.getCreatureClass(name);
        try
        {
            Entity creatureToSpawn = (Entity) creatureClass.getConstructor(World.class).newInstance(world);
            if (creatureToSpawn instanceof EntityJurassiCraftCreature)
            {
                EntityJurassiCraftCreature creature = (EntityJurassiCraftCreature) creatureToSpawn;
                creature.setGenetics(100, JurassiCraftDNAHandler.createDefaultDNA());
                creature.setPosition(x, y, z);
                creature.setLocationAndAngles(x, y, z, MathHelper.wrapAngleTo180_float(world.rand.nextFloat() * 360.0F), 0.0F);
                creature.rotationYawHead = creature.rotationYaw;
                creature.renderYawOffset = creature.rotationYaw;
                if (adult) creature.setFullGrowth();
                world.spawnEntityInWorld(creature);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
