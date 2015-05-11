package net.ilexiconn.jurassicraft.client.gui;

import cpw.mods.fml.common.network.IGuiHandler;
import net.ilexiconn.jurassicraft.common.container.*;
import net.ilexiconn.jurassicraft.common.tileentity.TileCultivate;
import net.ilexiconn.jurassicraft.common.tileentity.TileDNACombinator;
import net.ilexiconn.jurassicraft.common.tileentity.TileDNAExtractor;
import net.ilexiconn.jurassicraft.common.tileentity.fence.TileSecurityFenceLowCorner;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler
{
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        if (ID == 69)
            return new ContainerDinoPad(world.getEntityByID(x));
        if (ID == 51)
            return new ContainerDinoPadEgg(world.getEntityByID(x));
        if (ID == 13)
            return new ContainerDinoPadPregnancy(world.getEntityByID(x));

        TileEntity tileEntity = world.getTileEntity(x, y, z);
        if (tileEntity instanceof TileCultivate && ID == 0)
            return new ContainerCultivate(player.inventory, (TileCultivate) tileEntity);
        if (tileEntity instanceof TileDNAExtractor)
            return new ContainerDNAExtractor(player.inventory, (TileDNAExtractor) tileEntity);
        if (tileEntity instanceof TileDNACombinator)
            return new ContainerDNACombinator(player.inventory, (TileDNACombinator) tileEntity);
        if (tileEntity instanceof TileSecurityFenceLowCorner)
            return new ContainerSecurityFenceLow(player.inventory, (TileSecurityFenceLowCorner) tileEntity);
        return null;
    }

    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        if (ID == 69)
            return new GuiDinoPad(new ContainerDinoPad(world.getEntityByID(x)));
        if (ID == 51)
            return new GuiDinoPadEgg(new ContainerDinoPadEgg(world.getEntityByID(x)));
        if (ID == 13)
            return new GuiDinoPadPregnancy(new ContainerDinoPadPregnancy(world.getEntityByID(x)));

        TileEntity tileEntity = world.getTileEntity(x, y, z);
        if (tileEntity instanceof TileCultivate && ID == 0)
            return new GuiCultivate(player.inventory, (TileCultivate) tileEntity);
        if (tileEntity instanceof TileCultivate && ID == 1)
            return new GuiCultivateProcess((TileCultivate) tileEntity);
        if (tileEntity instanceof TileDNAExtractor)
            return new GuiDNAExtractor(player.inventory, (TileDNAExtractor) tileEntity);
        if (tileEntity instanceof TileDNACombinator)
            return new GuiDNACombinator(player.inventory, (TileDNACombinator) tileEntity);
        if (tileEntity instanceof TileSecurityFenceLowCorner)
            return new GuiSecurityFenceLow(player.inventory, (TileSecurityFenceLowCorner) tileEntity);
        return null;
    }
}
