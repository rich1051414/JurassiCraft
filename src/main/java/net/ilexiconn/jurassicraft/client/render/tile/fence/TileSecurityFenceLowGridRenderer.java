package net.ilexiconn.jurassicraft.client.render.tile.fence;

import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.client.model.block.ModelLowSecurityFenceGrid;
import net.ilexiconn.jurassicraft.common.tileentity.fence.TileSecurityFenceLowGrid;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class TileSecurityFenceLowGridRenderer extends TileEntitySpecialRenderer
{
    private static final ResourceLocation texture = new ResourceLocation(JurassiCraft.getModId() + "textures/blocks/fence/low_security_fence_grid.png");
    private static final ModelLowSecurityFenceGrid model = new ModelLowSecurityFenceGrid();

    public TileSecurityFenceLowGridRenderer()
    {

    }

    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float f)
    {
        if (tileEntity instanceof TileSecurityFenceLowGrid)
        {
            TileSecurityFenceLowGrid tileEntityModel = (TileSecurityFenceLowGrid) tileEntity;
            int angle = 0;
            if (tileEntityModel.getWorldObj() != null)
            {
                int direction = tileEntityModel.getBlockMetadata();
                switch (direction)
                {
                    case 0:
                    case 4:
                        angle = -180;
                        break;
                    case 1:
                    case 5:
                        angle = -90;
                        break;
                    case 2:
                    case 6:
                        angle = 0;
                        break;
                    case 3:
                    case 7:
                        angle = -270;
                        break;
                }
            }
            GL11.glPushMatrix();
            GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
            GL11.glScalef(1.0F, 1.0F, 1.0F);
            GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(angle, 0.0F, 1.0F, 0F);
            Minecraft.getMinecraft().renderEngine.bindTexture(texture);
            model.render(null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
            GL11.glPopMatrix();
        }
    }
}