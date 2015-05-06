package net.ilexiconn.jurassicraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.ModCreativeTabs;
import net.ilexiconn.jurassicraft.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeEventFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BlockFossilClayOre extends Block
{
    public static final String[] colors = {"", "brown", "orange", "red", "silver", "white", "yellow"};

    @SideOnly(Side.CLIENT)
    public IIcon[] icon_0;
    @SideOnly(Side.CLIENT)
    public IIcon[] icon_1;
    @SideOnly(Side.CLIENT)
    public IIcon[] icon_2;
    @SideOnly(Side.CLIENT)
    public IIcon[] icon_3;
    @SideOnly(Side.CLIENT)
    public IIcon[] icon_4;
    @SideOnly(Side.CLIENT)
    public IIcon[] icon_5;

    public BlockFossilClayOre()
    {
        super(Material.clay);
        setBlockName("fossil_clay_ore");
        setHardness(3.0F);
        setResistance(5.0F);
        setCreativeTab(ModCreativeTabs.blocks);
        setStepSound(Block.soundTypeStone);
        setHarvestLevel("pickaxe", 2);
    }

    @Override
    public void dropBlockAsItemWithChance(World world, int x, int y, int z, int metadata, float f, int side)
    {
        if (!world.isRemote)
        {
            ArrayList<ItemStack> items = getDrops(world, x, y, z, side, metadata);
            /** Sets the correct color for the clay block */
            if (items.get(0).getItem() == Item.getItemFromBlock(Blocks.stained_hardened_clay))
            {
                items.clear();
                switch (metadata)
                {
                    case 0:
                        items.add(new ItemStack(Blocks.stained_hardened_clay, 1, 0));
                        break;
                    case 1:
                        items.add(new ItemStack(Blocks.stained_hardened_clay, 1, 1));
                        break;
                    case 2:
                        items.add(new ItemStack(Blocks.stained_hardened_clay, 1, 2));
                        break;
                    case 3:
                        items.add(new ItemStack(Blocks.stained_hardened_clay, 1, 14));
                        break;
                    case 4:
                        items.add(new ItemStack(Blocks.stained_hardened_clay, 1, 8));
                        break;
                    default:
                        items.add(new ItemStack(Blocks.stained_hardened_clay, 1, 0));
                        break;
                }
            }
            f = ForgeEventFactory.fireBlockHarvesting(items, world, this, x, y, z, side, metadata, f, false, harvesters.get());
            for (ItemStack item : items)
            {
                if (world.rand.nextFloat() <= f)
                {
                    this.dropBlockAsItem(world, x, y, z, item);
                }
            }
        }
    }

    public Item getItemDropped(int metadata, Random random, int thing)
    {
        float rand = random.nextFloat();
        if (rand < 0.5F)
        {
            return Item.getItemFromBlock(Blocks.stained_hardened_clay);
        }
        else if (rand < 0.75F)
        {
            return Items.bone;
        }
        else
        {
            return ModItems.fossil;
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int metadata)
    {
        switch (side)
        {
            case 0:
                return icon_0[metadata];
            case 1:
                return icon_1[metadata];
            case 2:
                return icon_2[metadata];
            case 3:
                return icon_3[metadata];
            case 4:
                return icon_4[metadata];
            case 5:
                return icon_5[metadata];
            default:
                return icon_0[metadata];
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs tab, List list)
    {
        list.add(new ItemStack(item, 1, 0));
        list.add(new ItemStack(item, 1, 1));
        list.add(new ItemStack(item, 1, 2));
        list.add(new ItemStack(item, 1, 3));
        list.add(new ItemStack(item, 1, 4));
        list.add(new ItemStack(item, 1, 5));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister register)
    {
        this.icon_0 = new IIcon[colors.length];
        this.icon_1 = new IIcon[colors.length];
        this.icon_2 = new IIcon[colors.length];
        this.icon_3 = new IIcon[colors.length];
        this.icon_4 = new IIcon[colors.length];
        this.icon_5 = new IIcon[colors.length];

        for (int i = 0; i < this.icon_0.length; ++i)
        {
            if (!(colors[i].equals("")))
            {
                this.icon_0[i] = register.registerIcon(JurassiCraft.getModId() + "fossil_side_0_hardened_clay_stained_" + colors[i]);
                this.icon_1[i] = register.registerIcon(JurassiCraft.getModId() + "fossil_side_1_hardened_clay_stained_" + colors[i]);
                this.icon_2[i] = register.registerIcon(JurassiCraft.getModId() + "fossil_side_2_hardened_clay_stained_" + colors[i]);
                this.icon_3[i] = register.registerIcon(JurassiCraft.getModId() + "fossil_side_3_hardened_clay_stained_" + colors[i]);
                this.icon_4[i] = register.registerIcon(JurassiCraft.getModId() + "fossil_side_4_hardened_clay_stained_" + colors[i]);
                this.icon_5[i] = register.registerIcon(JurassiCraft.getModId() + "fossil_side_5_hardened_clay_stained_" + colors[i]);
            }
            else
            {
                this.icon_0[i] = register.registerIcon(JurassiCraft.getModId() + "fossil_side_0_hardened_clay");
                this.icon_1[i] = register.registerIcon(JurassiCraft.getModId() + "fossil_side_1_hardened_clay");
                this.icon_2[i] = register.registerIcon(JurassiCraft.getModId() + "fossil_side_2_hardened_clay");
                this.icon_3[i] = register.registerIcon(JurassiCraft.getModId() + "fossil_side_3_hardened_clay");
                this.icon_4[i] = register.registerIcon(JurassiCraft.getModId() + "fossil_side_4_hardened_clay");
                this.icon_5[i] = register.registerIcon(JurassiCraft.getModId() + "fossil_side_5_hardened_clay");
            }
        }
    }
}
