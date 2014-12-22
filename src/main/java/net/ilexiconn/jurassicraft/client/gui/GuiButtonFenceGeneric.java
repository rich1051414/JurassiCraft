package net.ilexiconn.jurassicraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import net.ilexiconn.jurassicraft.Util;

@SideOnly(Side.CLIENT)
public class GuiButtonFenceGeneric extends GuiButton 
{
    public int xguiPos;
    public int yguiPos;
	
	public GuiButtonFenceGeneric(int id, int xPos, int yPos, int xguiPosition, int yguiPosition, int width, int height) 
	{
		super(id, xPos, yPos, width, height, "");
		this.xguiPos = xguiPosition;
		this.yguiPos = yguiPosition;
	}

	@Override
	public void drawButton(Minecraft mc, int x, int y) 
    {
		if (this.visible)
        {
			mc.renderEngine.bindTexture(new ResourceLocation(Util.getModId() + "textures/gui/guiSecurityFenceWidgets.png"));
			if (this.enabled)
	        {
	            FontRenderer fontrenderer = mc.fontRenderer;
	            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	            GL11.glEnable(GL11.GL_BLEND);
	            OpenGlHelper.glBlendFunc(770, 771, 1, 0);
	            GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
	            if (x >= this.xPosition && y >= this.yPosition && x < this.xPosition + this.width && y < this.yPosition + this.height) 
	            {
	            	this.drawTexturedModalRect(this.xPosition, this.yPosition, xguiPos, yguiPos + this.height, this.width, this.height);
	            } 
	            else 
	            {
	            	this.drawTexturedModalRect(this.xPosition, this.yPosition, xguiPos, yguiPos, this.width, this.height);
	            }
	            this.mouseDragged(mc, x, y);
	        } else {
	        	FontRenderer fontrenderer = mc.fontRenderer;
	            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	            GL11.glEnable(GL11.GL_BLEND);
	            OpenGlHelper.glBlendFunc(770, 771, 1, 0);
				GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
				this.drawTexturedModalRect(this.xPosition, this.yPosition, xguiPos, yguiPos + 2 * this.height, this.width, this.height);
				this.mouseDragged(mc, x, y);
	        }
        }
    }
}