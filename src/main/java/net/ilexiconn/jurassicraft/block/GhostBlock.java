package net.ilexiconn.jurassicraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.Util;

import java.util.Random;

public class GhostBlock extends Block
{
    public int[] blocksToBreak;
    public int guiToOpen, guiId;
    public boolean openGui;
    public Block block;

    public GhostBlock(String name, Block block, float hardness, int[] blocks)
    {
        super(Material.cloth);
        this.block = block;
        setBlockName(name);
        setBlockTextureName(Util.getModId() + name);
        blocksToBreak = blocks;
        setCreativeTab(null);
        setHardness(hardness);
    }

    public GhostBlock(String name, Block block, float hardness, int[] blocks, int guiBlock, int guiID)
    {
        this(name, block, hardness, blocks);
        guiToOpen = guiBlock;
        guiId = guiID;
        openGui = true;
    }

    public GhostBlock(String name, Block block, float hardness, int[] blocks, float x, float y, float z, float x1, float y1, float z1)
    {
        this(name, block, hardness, blocks);
        setBlockBounds(x, y, z, x1, y1, z1);
    }

    public GhostBlock(String name, Block block, float hardness, int[] blocks, int guiBlock, int guiID, float x, float y, float z, float x1, float y1, float z1)
    {
        this(name, block, hardness, blocks, guiBlock, guiID);
        setBlockBounds(x, y, z, x1, y1, z1);
    }

    public Item getItemDropped(int x, Random random, int z)
    {
        return Item.getItemFromBlock(block);
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }

    public int getRenderType()
    {
        return -1;
    }

    public void breakBlock(World world, int x, int y, int z, Block block, int side)
    {
        for (int thing : blocksToBreak)
        {
            world.setBlockToAir(x, y + thing, z);
            if (world.getTileEntity(x, y + thing, z) != null) world.removeTileEntity(x, y + thing, z);
        }
        super.breakBlock(world, x, y, z, block, side);
    }

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int o, float i, float d, float k)
    {
        if (!openGui) return false;
        player.openGui(JurassiCraft.instance, guiId, world, x, y + guiToOpen, z);
        return true;
    }
}
