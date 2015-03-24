package net.ilexiconn.jurassicraft.utility.handlers;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

import net.ilexiconn.jurassicraft.ModBlocks;
import net.ilexiconn.jurassicraft.utility.teleporters.TeleportClient;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.util.IIcon;
import net.minecraftforge.client.event.RenderGameOverlayEvent;

/**
 * @author ProPercivalalb
 **/
public class PortalRenderOverlayHandler
{
    @SubscribeEvent
    public void onPreRenderGameOverlay(RenderGameOverlayEvent.Pre event)
    {
        Minecraft mc = Minecraft.getMinecraft();
       
        if (mc.thePlayer != null)
        {
            if (event.type == RenderGameOverlayEvent.ElementType.HELMET)
            {
                int width = event.resolution.getScaledWidth();
                int height = event.resolution.getScaledHeight();
               
                float time = TeleportClient.prevTimeInPortal + (TeleportClient.timeInPortal - TeleportClient.prevTimeInPortal) * event.partialTicks;
                
                if (time > 0.0F)
                {
                    this.renderPortalOverlay(time, width, height);
                }
            }
        }
    }
    
    private void renderPortalOverlay(float time, int width, int height)
    {
        if (time < 1.0F)
        {
            time *= time;
            time *= time;
            time = time * 0.8F + 0.2F;
        }
        
        GL11.glDisable(GL11.GL_ALPHA_TEST);
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        GL11.glDepthMask(false);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, time);
        Minecraft.getMinecraft().getTextureManager().bindTexture(TextureMap.locationBlocksTexture);
     
        IIcon icon = ModBlocks.portal.getBlockTextureFromSide(1);
       
        float minU = icon.getMinU();
        float minV = icon.getMinV();
        float maxU = icon.getMaxU();
        float maxV = icon.getMaxV();
      
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(0.0D, (double) height, -90.0D, (double) minU, (double) maxV);
        tessellator.addVertexWithUV((double) width, (double) height, -90.0D, (double) maxU, (double) maxV);
        tessellator.addVertexWithUV((double) width, 0.0D, -90.0D, (double) maxU, (double) minV);
        tessellator.addVertexWithUV(0.0D, 0.0D, -90.0D, (double) minU, (double) minV);
        tessellator.draw();
        
        GL11.glDepthMask(true);
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        GL11.glEnable(GL11.GL_ALPHA_TEST);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    }
}
