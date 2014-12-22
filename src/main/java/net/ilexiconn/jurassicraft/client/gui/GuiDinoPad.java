package net.ilexiconn.jurassicraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;
import net.ilexiconn.jurassicraft.Util;
import net.ilexiconn.jurassicraft.entity.EntityJurassiCraftTameable;

import java.util.HashMap;

@SideOnly(Side.CLIENT)
public class GuiDinoPad extends GuiScreen {

	public static Object creatureToAnalyze;
	private EntityJurassiCraftTameable creature;
	private int xSize;
	private int ySize;
	private int guiLeft;
	private int guiTop;
	private float renderRotation;
	private int pageNumber;
	private HashMap<Integer, String[]> dinoInfo = new HashMap<Integer, String[]>();

	public GuiDinoPad() 
	{
		super();
		if (this.creatureToAnalyze instanceof EntityJurassiCraftTameable) 
		{
			this.creature = (EntityJurassiCraftTameable) this.creatureToAnalyze;
			this.xSize = 256;
			this.ySize = 176;
		}
	}

	@Override
	public void initGui() 
	{
		this.buttonList.clear();
		this.dinoInfo.clear();
		for (int numberOfPages = 1; numberOfPages <= Util.getCreatureFromId(this.creature.getCreatureID()).numberOfInfoPages; numberOfPages++) {
			this.dinoInfo.put(numberOfPages, this.getCreatureInformation(numberOfPages));
		}
		this.renderRotation = 0.0F;
		this.pageNumber = 0;
		this.guiLeft = (int) ((this.width - this.xSize) / 2);
		this.guiTop = (int) ((this.height - this.ySize) / 2);
        this.buttonList.add(new GuiButtonDinopad(0, this.guiLeft + (this.xSize - 18) / 2, this.guiTop + 146, 0, 210, 18, 18));
        this.buttonList.add(new GuiButtonDinopad(1, this.guiLeft + (this.xSize - 18) / 2 - 14, this.guiTop + 146, 36, 210, 12, 18));
        this.buttonList.add(new GuiButtonDinopad(2, this.guiLeft + (this.xSize - 18) / 2 + 20, this.guiTop + 146, 60, 210, 12, 18));
	}

	@Override
	public boolean doesGuiPauseGame() 
	{
		return false;
	}

	@Override
	public void onGuiClosed() 
	{
		super.onGuiClosed();
	}

	@Override
	protected void keyTyped(char keyChar, int key) 
	{
		if (key == 1 || key == this.mc.gameSettings.keyBindInventory.getKeyCode()) 
		{
			this.mc.thePlayer.closeScreen();
		}
	}

	@Override
	public void updateScreen() 
	{
		this.renderRotation++;
		if (!this.creature.isEntityAlive()) 
		{
			this.mc.thePlayer.closeScreen();
		}
	}

    @Override
    public void actionPerformed(GuiButton button)
    {
    	if (button.id == 0)
        {
			this.pageNumber = 0;
        }
    	if (button.id == 1)
        {
    		if (this.pageNumber > 0) {
    			this.pageNumber--;
    		} else {
    			this.pageNumber = Util.getCreatureFromId(this.creature.getCreatureID()).numberOfInfoPages;
    		}
        }
    	if (button.id == 2)
        {
    		if (this.pageNumber < Util.getCreatureFromId(this.creature.getCreatureID()).numberOfInfoPages) {
    			this.pageNumber++;
    		} else {
    			this.pageNumber = 0;
    		}
        }
    }

	@Override
	public void drawScreen(int x, int y, float f) 
	{
		drawDefaultBackground();
		mc.renderEngine.bindTexture(new ResourceLocation(Util.getModId() + "textures/gui/guiDinoPad.png"));
		drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		switch (this.pageNumber) {
			case 0:
				this.renderEmptyBars();
				this.renderStatusBars();

				if (this.creature.getCreatureID() >= 0 && this.creature.getCreatureLength() > this.creature.getCreatureHeight()) {
					this.renderCreature((float) (this.guiLeft + 67), (float) (this.guiTop + 108), (float) ((55.0F / creature.getCreatureLength()) * (0.4F + 0.6F * this.creature.getCreatureLength() / Util.getCreatureFromId(this.creature.getCreatureID()).maxLength)));
				} else {
					this.renderCreature((float) (this.guiLeft + 67), (float) (this.guiTop + 108), (float) ((55.0F / creature.getCreatureHeight()) * (0.4F + 0.6F * this.creature.getCreatureHeight() / Util.getCreatureFromId(this.creature.getCreatureID()).maxHeight)));
				}

				this.renderNameGenderStrings();
				this.renderStatusStrings();
				this.renderTamedStrings();
				break;
			default:
				this.renderNameGenderStrings();
				this.renderCreatureInformation(this.pageNumber);
				break;
		}
		super.drawScreen(x, y, f);
	}

	private void renderEmptyBars() 
	{
		this.drawTexturedModalRect(this.guiLeft + 140, this.guiTop + 55, 0, 202, 98, 8);
		this.drawTexturedModalRect(this.guiLeft + 140, this.guiTop + 80, 0, 202, 98, 8);
		this.drawTexturedModalRect(this.guiLeft + 140, this.guiTop + 105, 0, 202, 98, 8);
	}

	private void renderStatusBars() 
	{
		this.drawTexturedModalRect(this.guiLeft + 141, this.guiTop + 56, 1, 177, this.creature.getCreatureHealthScaled(95), 5);
		this.drawTexturedModalRect(this.guiLeft + 141, this.guiTop + 81, 1, 182, this.creature.getCreatureAttackScaled(95), 5);
		this.drawTexturedModalRect(this.guiLeft + 141, this.guiTop + 106, 1, 187, this.creature.getCreatureSpeedScaled(95), 5);
	}

	private void renderNameGenderStrings() 
	{
		this.fontRendererObj.drawString(StatCollector.translateToLocal("container.pad.creature") + ": " + this.creature.getCreatureName(), this.guiLeft + 127 - this.fontRendererObj.getStringWidth(StatCollector.translateToLocal("container.pad.creature") + ": " + this.creature.getCreatureName()) / 2, this.guiTop + 11, 14737632);
		this.fontRendererObj.drawString(this.creature.getCreatureAgeString() + ", " + this.creature.getCreatureGenderString(), this.guiLeft + 127 - this.fontRendererObj.getStringWidth(this.creature.getCreatureAgeString() + ", " + this.creature.getCreatureGenderString()) / 2, this.guiTop + 19, 14737632);
	}

	private void renderStatusStrings() 
	{
		this.fontRendererObj.drawString(StatCollector.translateToLocal("container.pad.health") + ": " + String.valueOf(this.creature.getCreatureCurrentHealth() + "/" + this.creature.getCreatureHealth()), this.guiLeft + 192 - this.fontRendererObj.getStringWidth(StatCollector.translateToLocal("container.pad.health") + String.valueOf(this.creature.getCreatureCurrentHealth() + "/" + this.creature.getCreatureHealth())) / 2, this.guiTop + 45, 14737632);
		this.fontRendererObj.drawString(StatCollector.translateToLocal("container.pad.attack") + ": " + String.valueOf(this.creature.getCreatureAttack()), this.guiLeft + 192 - this.fontRendererObj.getStringWidth(StatCollector.translateToLocal("container.pad.attack") + String.valueOf(this.creature.getCreatureAttack())) / 2, this.guiTop + 70, 14737632);
		this.fontRendererObj.drawString(StatCollector.translateToLocal("container.pad.speed") + ": " + String.valueOf(this.creature.getCreatureSpeed()), this.guiLeft + 192 - this.fontRendererObj.getStringWidth(StatCollector.translateToLocal("container.pad.speed") + String.valueOf(this.creature.getCreatureSpeed())) / 2, this.guiTop + 95, 14737632);
		this.fontRendererObj.drawString(StatCollector.translateToLocal("container.pad.height") + ": " + String.valueOf(this.creature.getCreatureHeight()), this.guiLeft + 192 - this.fontRendererObj.getStringWidth(StatCollector.translateToLocal("container.pad.height") + String.valueOf(this.creature.getCreatureHeight())) / 2, this.guiTop + 116, 14737632);
		this.fontRendererObj.drawString(StatCollector.translateToLocal("container.pad.length") + ": " + String.valueOf(this.creature.getCreatureLength()), this.guiLeft + 192 - this.fontRendererObj.getStringWidth(StatCollector.translateToLocal("container.pad.length") + String.valueOf(this.creature.getCreatureLength())) / 2, this.guiTop + 126, 14737632);
	}

	private void renderTamedStrings() 
	{
		if (creature.isTamed()) 
		{
			if (Util.getCreatureFromId(creature.getCreatureID()).isRidable && this.creature.isCreatureAdult())
			{
				this.fontRendererObj.drawString(StatCollector.translateToLocal("container.pad.owner") + ": " + ((EntityJurassiCraftTameable) creature).getOwnerName(), this.guiLeft + 67 - this.fontRendererObj.getStringWidth(StatCollector.translateToLocal("container.pad.owner") + ((EntityJurassiCraftTameable) creature).getOwnerName()) / 2, this.guiTop + 112, 14737632);
				this.fontRendererObj.drawString(StatCollector.translateToLocal("container.pad.ridable"), this.guiLeft + 67 - this.fontRendererObj.getStringWidth("Ridable") / 2, this.guiTop + 122, 14737632);
			} 
			else 
			{
				this.fontRendererObj.drawString(StatCollector.translateToLocal("container.pad.owner") + ": "  + ((EntityJurassiCraftTameable) creature).getOwnerName(), this.guiLeft + 67 - this.fontRendererObj.getStringWidth(StatCollector.translateToLocal("container.pad.owner") + ": "  + ((EntityJurassiCraftTameable) creature).getOwnerName()) / 2, this.guiTop + 122, 14737632);
			}
		}
		else 
		{
			this.fontRendererObj.drawString(StatCollector.translateToLocal("container.pad.owner") + ": " + StatCollector.translateToLocal("container.pad.none"), this.guiLeft + 67 - this.fontRendererObj.getStringWidth(StatCollector.translateToLocal("container.pad.owner") + ": " + StatCollector.translateToLocal("container.pad.none")) / 2, this.guiTop + 122, 14737632);
		}
	}

	private String[] getCreatureInformation(int page) 
	{
		String info = StatCollector.translateToLocal("container.pad.info" + Util.getCreatureFromId(this.creature.getCreatureID()).creatureName + ".page" + page);
		String[] pageInfo = new String[8];
		if (info != null && info != "") {
			int line = 0;
			int index = 0;
			for (int infoSize = info.length(); infoSize >= 43; line++) {
				index = 43;
				while (!String.valueOf(info.substring(0, index).charAt(index - 1)).equals(" ")) {
					index--;
				}
				pageInfo[line] = info.substring(0, index - 1);
				info = info.substring(index, infoSize);
				infoSize = info.length();
			}
			pageInfo[line] = info;
		}
		return pageInfo;
	}
	
	private void renderCreatureInformation(int page) 
	{
		if (this.dinoInfo.containsKey(page)) {
			for (int line = 0; line < this.dinoInfo.get(page).length; line++) 
			{
				this.fontRendererObj.drawString(this.dinoInfo.get(page)[line], this.guiLeft + 128 - this.fontRendererObj.getStringWidth(this.dinoInfo.get(page)[line]) / 2, this.guiTop + 45 + 12 * line, 14737632);
			}
		} else {
			this.fontRendererObj.drawString("Page missing! This is a bug!", this.guiLeft + 128 - this.fontRendererObj.getStringWidth("Page missing! This is a bug!") / 2, this.guiTop + 45, 14737632);
		}
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
