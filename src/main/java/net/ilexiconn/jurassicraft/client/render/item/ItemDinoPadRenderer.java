package net.ilexiconn.jurassicraft.client.render.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.ilexiconn.jurassicraft.client.render.tile.TileDinoPadRenderer;
import net.ilexiconn.jurassicraft.tile.TileDinoPad;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class ItemDinoPadRenderer implements IItemRenderer
{
    private TileEntitySpecialRenderer render = new TileDinoPadRenderer();
    private TileEntity tileEntity = new TileDinoPad();

    public ItemDinoPadRenderer()
    {

    }

    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type)
    {
        return true;
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper)
    {
        return true;
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data)
    {
        if (type == IItemRenderer.ItemRenderType.INVENTORY)
        {
            GL11.glRotatef(-90F, 0.0F, 1.0F, 0.1F);
            GL11.glTranslatef(-0.5F, 0.15F, -1.0F);
            GL11.glScalef(1.5F, 1.5F, 1.5F);
        }
        else if (type == IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON)
        {
            GL11.glRotatef(90F, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(60F, 0.0F, 1.0F, 0.0F);
            GL11.glTranslatef(-1F, -1.0F, -1F);
            GL11.glScalef(3.0F, 3.0F, 3.0F);
        }
        else if (type == IItemRenderer.ItemRenderType.EQUIPPED)
        {
            GL11.glRotatef(150F, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(90F, 1.0F, 0.0F, 0.0F);
            GL11.glTranslatef(-0.5F, 0.75F, 0.0F);
            GL11.glScalef(1.5F, 1.5F, 1.5F);
        }
        else if (type == IItemRenderer.ItemRenderType.ENTITY)
        {
            GL11.glRotatef(-90F, 1.0F, 0.5F, 0.0F);
            GL11.glTranslatef(-0.5F, 0.0F, -0.5F);
        }
        this.render.renderTileEntityAt(this.tileEntity, 0.0D, 0.0D, 0.0D, 0.0F);
    }
}
