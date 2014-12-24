package net.ilexiconn.jurassicraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.passive.*;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;
import net.ilexiconn.jurassicraft.Util;
import net.ilexiconn.jurassicraft.entity.mammals.EntityPregnantCow;
import net.ilexiconn.jurassicraft.entity.mammals.EntityPregnantHorse;
import net.ilexiconn.jurassicraft.entity.mammals.EntityPregnantPig;
import net.ilexiconn.jurassicraft.entity.mammals.EntityPregnantSheep;

@SideOnly(Side.CLIENT)
public class GuiPregnancyProgress extends GuiScreen
{

	public static Object creatureToAnalyze;
	private EntityAnimal creature;
	private float renderRotation;
    private int xSize;
    private int ySize;
    private int guiLeft;
    private int guiTop;

    public GuiPregnancyProgress()
    {
        super();
		this.renderRotation = 0.0F;
		this.xSize = 256;
		this.ySize = 176;
		if (this.creatureToAnalyze instanceof EntityAnimal && ((EntityAnimal) this.creatureToAnalyze).getGrowingAge() == 0) 
		{
			if (this.creatureToAnalyze instanceof EntityCow) {
				EntityPregnantCow cow = EntityPregnantCow.get(((EntityCow) this.creatureToAnalyze));
				if (cow != null) 
				{
					this.creature = (EntityCow) this.creatureToAnalyze;
				}
			} else if (this.creatureToAnalyze instanceof EntityPig) {
				EntityPregnantPig pig = EntityPregnantPig.get(((EntityPig) this.creatureToAnalyze));
				if (pig != null) 
				{
					this.creature = (EntityPig) this.creatureToAnalyze;
				}
			} else if (this.creatureToAnalyze instanceof EntityHorse) {
				EntityPregnantHorse horse = EntityPregnantHorse.get(((EntityHorse) this.creatureToAnalyze));
				if (horse != null) 
				{
					this.creature = (EntityHorse) this.creatureToAnalyze;
				}
			} else if (this.creatureToAnalyze instanceof EntitySheep) {
				EntityPregnantSheep sheep = EntityPregnantSheep.get(((EntitySheep) this.creatureToAnalyze));
				if (sheep != null) 
				{
					this.creature = (EntitySheep) this.creatureToAnalyze;
				}
			} else {
		    	this.creature = (EntityAnimal) null;
	            this.mc.thePlayer.closeScreen();
			}
		}
    }
    
    @Override
    public void initGui()
    {
        super.initGui();
        this.guiLeft = (int) ((this.width - this.xSize) / 2);
        this.guiTop = (int) ((this.height - this.ySize) / 2);
    }
	
    @Override
    public void onGuiClosed()
    {
    	this.creature = (EntityAnimal) null;
        super.onGuiClosed();
    }

    @Override
    public boolean doesGuiPauseGame()
    {
        return false;
    }

    @Override
    protected void keyTyped(char var1, int key)
    {
        if (key == 1 || key == this.mc.gameSettings.keyBindInventory.getKeyCode())
        {
        	this.creature = (EntityAnimal) null;
            this.mc.thePlayer.closeScreen();
        }
    }
    
	@Override
	public void updateScreen() 
	{
		if (this.creature != null) 
		{
			this.renderRotation++;
			if (!this.creature.isEntityAlive()) 
			{
		    	this.creature = (EntityAnimal) null;
				this.mc.thePlayer.closeScreen();
			}
		} else {
	    	this.creature = (EntityAnimal) null;
			this.mc.thePlayer.closeScreen();
		}
	}
	
    @Override
    public void drawScreen(int x, int y, float f)
    {
    	this.drawDefaultBackground();
		this.mc.renderEngine.bindTexture(new ResourceLocation(Util.getModId() + "textures/gui/guiDinoPadPregnancy.png"));
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		if (this.creature != null && this.creature.isEntityAlive()) 
		{
			if (this.creature instanceof EntityCow) 
			{
				EntityPregnantCow cow = EntityPregnantCow.get(((EntityCow) this.creature));
				if (cow.getPregnancyProgress() >= cow.getPregnancySpeed()) 
				{
					this.drawTexturedModalRect(this.guiLeft + 140, this.guiTop + 80, 0, 202, 98, 8);
					this.fontRendererObj.drawString(StatCollector.translateToLocal("container.pad.pregnancy.cow"), this.guiLeft + 127 - this.fontRendererObj.getStringWidth(StatCollector.translateToLocal("container.pad.pregnancy.cow")) / 2, this.guiTop + 14, 14737632);
					this.fontRendererObj.drawString(cow.getMammalName(), this.guiLeft + 189 - this.fontRendererObj.getStringWidth(cow.getMammalName())/2, this.guiTop + 70, 14737632);
				} 
				else 
				{
					this.drawTexturedModalRect(this.guiLeft + 140, this.guiTop + 80, 0, 202, 98, 8);
					this.drawTexturedModalRect(this.guiLeft + 141, this.guiTop + 81, 1, 182, cow.getPregnancyProgressScaled(95), 5);
					this.fontRendererObj.drawString(StatCollector.translateToLocal("container.pad.pregnancy.pregnantCow"), this.guiLeft + 127 - this.fontRendererObj.getStringWidth(StatCollector.translateToLocal("container.pad.pregnancy.pregnantCow")) / 2, this.guiTop + 14, 14737632);
					this.fontRendererObj.drawString(cow.getMammalName() + ": " + cow.getPregnancyProgressScaled(100) + "%", this.guiLeft + 189 - this.fontRendererObj.getStringWidth(cow.getMammalName() + ": " + cow.getPregnancyProgressScaled(100) + "%")/2, this.guiTop + 70, 14737632);
				}
			} 
			else if (this.creature instanceof EntityPig) 
			{
				EntityPregnantPig pig = EntityPregnantPig.get(((EntityPig) this.creature));
				if (pig.getPregnancyProgress() >= pig.getPregnancySpeed()) 
				{
					this.drawTexturedModalRect(this.guiLeft + 140, this.guiTop + 80, 0, 202, 98, 8);
					this.fontRendererObj.drawString(StatCollector.translateToLocal("container.pad.pregnancy.pig"), this.guiLeft + 127 - this.fontRendererObj.getStringWidth(StatCollector.translateToLocal("container.pad.pregnancy.pig")) / 2, this.guiTop + 14, 14737632);
					this.fontRendererObj.drawString(pig.getMammalName(), this.guiLeft + 189 - this.fontRendererObj.getStringWidth(pig.getMammalName())/2, this.guiTop + 70, 14737632);
				} 
				else 
				{
					this.drawTexturedModalRect(this.guiLeft + 140, this.guiTop + 80, 0, 202, 98, 8);
					this.drawTexturedModalRect(this.guiLeft + 141, this.guiTop + 81, 1, 182, pig.getPregnancyProgressScaled(95), 5);
					this.fontRendererObj.drawString(StatCollector.translateToLocal("container.pad.pregnancy.pregnantPig"), this.guiLeft + 127 - this.fontRendererObj.getStringWidth(StatCollector.translateToLocal("container.pad.pregnancy.pregnantPig")) / 2, this.guiTop + 14, 14737632);
					this.fontRendererObj.drawString(pig.getMammalName() + ": " + pig.getPregnancyProgressScaled(100) + "%", this.guiLeft + 189 - this.fontRendererObj.getStringWidth(pig.getMammalName() + ": " + pig.getPregnancyProgressScaled(100) + "%")/2, this.guiTop + 70, 14737632);
				}
			} 
			else if (this.creature instanceof EntityHorse) 
			{
				EntityPregnantHorse horse = EntityPregnantHorse.get(((EntityHorse) this.creature));
				if (horse.getPregnancyProgress() >= horse.getPregnancySpeed()) 
				{
					this.drawTexturedModalRect(this.guiLeft + 140, this.guiTop + 80, 0, 202, 98, 8);
					this.fontRendererObj.drawString(StatCollector.translateToLocal("container.pad.pregnancy.horse"), this.guiLeft + 127 - this.fontRendererObj.getStringWidth(StatCollector.translateToLocal("container.pad.pregnancy.horse")) / 2, this.guiTop + 14, 14737632);
					this.fontRendererObj.drawString(horse.getMammalName(), this.guiLeft + 189 - this.fontRendererObj.getStringWidth(horse.getMammalName())/2, this.guiTop + 70, 14737632);
				} 
				else 
				{
					this.drawTexturedModalRect(this.guiLeft + 140, this.guiTop + 80, 0, 202, 98, 8);
					this.drawTexturedModalRect(this.guiLeft + 141, this.guiTop + 81, 1, 182, horse.getPregnancyProgressScaled(95), 5);
					this.fontRendererObj.drawString(StatCollector.translateToLocal("container.pad.pregnancy.pregnantHorse"), this.guiLeft + 127 - this.fontRendererObj.getStringWidth(StatCollector.translateToLocal("container.pad.pregnancy.pregnantHorse")) / 2, this.guiTop + 14, 14737632);
					this.fontRendererObj.drawString(horse.getMammalName() + ": " + horse.getPregnancyProgressScaled(100) + "%", this.guiLeft + 189 - this.fontRendererObj.getStringWidth(horse.getMammalName() + ": " + horse.getPregnancyProgressScaled(100) + "%")/2, this.guiTop + 70, 14737632);
				}
			} 
			else if (this.creature instanceof EntitySheep) 
			{
				EntityPregnantSheep sheep = EntityPregnantSheep.get(((EntitySheep) this.creature));
				if (sheep.getPregnancyProgress() >= sheep.getPregnancySpeed()) 
				{
					this.drawTexturedModalRect(this.guiLeft + 140, this.guiTop + 80, 0, 202, 98, 8);
					this.fontRendererObj.drawString(StatCollector.translateToLocal("container.pad.pregnancy.sheep"), this.guiLeft + 127 - this.fontRendererObj.getStringWidth(StatCollector.translateToLocal("container.pad.pregnancy.sheep")) / 2, this.guiTop + 14, 14737632);
					this.fontRendererObj.drawString(sheep.getMammalName(), this.guiLeft + 189 - this.fontRendererObj.getStringWidth(sheep.getMammalName())/2, this.guiTop + 70, 14737632);
				} 
				else 
				{
					this.drawTexturedModalRect(this.guiLeft + 140, this.guiTop + 80, 0, 202, 98, 8);
					this.drawTexturedModalRect(this.guiLeft + 141, this.guiTop + 81, 1, 182, sheep.getPregnancyProgressScaled(95), 5);
					this.fontRendererObj.drawString(StatCollector.translateToLocal("container.pad.pregnancy.pregnantSheep"), this.guiLeft + 127 - this.fontRendererObj.getStringWidth(StatCollector.translateToLocal("container.pad.pregnancy.pregnantSheep")) / 2, this.guiTop + 14, 14737632);
					this.fontRendererObj.drawString(sheep.getMammalName() + ": " + sheep.getPregnancyProgressScaled(100) + "%", this.guiLeft + 189 - this.fontRendererObj.getStringWidth(sheep.getMammalName() + ": " + sheep.getPregnancyProgressScaled(100) + "%")/2, this.guiTop + 70, 14737632);
				}
			}
			this.renderCreature((float) (this.guiLeft + 67), (float) (this.guiTop + 108), 30.0F);
		}
		super.drawScreen(x, y, f);
	}

	private void renderCreature(float posX, float posY, float scale) 
	{
		GL11.glEnable(GL11.GL_COLOR_MATERIAL);
		GL11.glPushMatrix();
		GL11.glTranslatef( posX, posY, 50.0F);
		GL11.glScalef(-scale, scale, scale);
		GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(135.0F, 0.0F, 1.0F, 0.0F);
		RenderHelper.enableStandardItemLighting();
		GL11.glRotatef(-135.0F, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(1.5F * this.renderRotation, 0.0F, 1.0F, 0.0F);
		GL11.glTranslatef(0.0F, creature.yOffset, 0.0F);
		RenderManager.instance.playerViewY = 180.0F;
		RenderManager.instance.renderEntityWithPosYaw(creature, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
		GL11.glPopMatrix();
		RenderHelper.disableStandardItemLighting();
		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		OpenGlHelper.setActiveTexture(OpenGlHelper.lightmapTexUnit);
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		OpenGlHelper.setActiveTexture(OpenGlHelper.defaultTexUnit);
	}
}
