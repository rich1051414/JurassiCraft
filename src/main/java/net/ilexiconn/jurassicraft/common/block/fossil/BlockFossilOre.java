package net.ilexiconn.jurassicraft.common.block.fossil;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.common.creativetab.JCCreativeTabRegistry;
import net.ilexiconn.jurassicraft.common.item.JCItemRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.Random;

public class BlockFossilOre extends Block
{
    @SideOnly(Side.CLIENT)
    public IIcon icon_0;
    @SideOnly(Side.CLIENT)
    public IIcon icon_1;
    @SideOnly(Side.CLIENT)
    public IIcon icon_2;
    @SideOnly(Side.CLIENT)
    public IIcon icon_3;
    @SideOnly(Side.CLIENT)
    public IIcon icon_4;
    @SideOnly(Side.CLIENT)
    public IIcon icon_5;

    public BlockFossilOre()
    {
        super(Material.rock);
        setBlockName("fossil_ore");
        setBlockTextureName(JurassiCraft.getModId() + "fossil_ore");
        setHardness(3.0F);
        setResistance(5.0F);
        setCreativeTab(JCCreativeTabRegistry.blocks);
        setStepSound(Block.soundTypeStone);
        setHarvestLevel("pickaxe", 2);
    }

    public Item getItemDropped(int value, Random random, int thing)
    {
        float rand = random.nextFloat();
        if (rand < 0.20F)
        {
            return Item.getItemFromBlock(Blocks.stone);
        }
        else if (rand < 0.5F)
        {
            return Item.getItemFromBlock(Blocks.cobblestone);
        }
        else if (rand < 0.70F)
        {
            return Items.bone;
        }
        else
        {
            return JCItemRegistry.fossil;
        }
    }

    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack itemStack)
    {
        world.setBlockMetadataWithNotify(x, y, z, new Random().nextInt(6), 2);
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        icon_0 = iconRegister.registerIcon(JurassiCraft.getModId() + "fossil/fossil_side_0");
        icon_1 = iconRegister.registerIcon(JurassiCraft.getModId() + "fossil/fossil_side_1");
        icon_2 = iconRegister.registerIcon(JurassiCraft.getModId() + "fossil/fossil_side_2");
        icon_3 = iconRegister.registerIcon(JurassiCraft.getModId() + "fossil/fossil_side_3");
        icon_4 = iconRegister.registerIcon(JurassiCraft.getModId() + "fossil/fossil_side_4");
        icon_5 = iconRegister.registerIcon(JurassiCraft.getModId() + "fossil/fossil_side_5");
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int metadata)
    {
        switch (metadata)
        {
            case 0:
                return icon_0;
            case 1:
                return icon_1;
            case 2:
                return icon_2;
            case 3:
                return icon_3;
            case 4:
                return icon_4;
            case 5:
                return icon_5;
            default:
                return icon_0;
        }
    }
}
