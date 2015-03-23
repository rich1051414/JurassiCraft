package net.ilexiconn.jurassicraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.entity.Creature;
import net.ilexiconn.jurassicraft.tile.TileCultivate;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

@SideOnly(Side.CLIENT)
public class GuiCultivateProcess extends GuiScreen
{
    
    private TileCultivate cultivator;
    private int xSize;
    private int ySize;
    private int guiLeft;
    private int guiTop;
    
    public GuiCultivateProcess(TileCultivate entity)
    {
        super();
        this.cultivator = entity;
        this.xSize = 176;
        this.ySize = 107;
    }
    
    @Override
    public void updateScreen()
    {
        if (!this.cultivator.isHatching())
        {
            this.mc.thePlayer.closeScreen();
        }
    }
    
    @Override
    public void onGuiClosed()
    {
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
            this.mc.thePlayer.closeScreen();
        }
    }
    
    @Override
    public void initGui()
    {
        super.initGui();
        this.buttonList.clear();
        this.guiLeft = (int) ((this.width - this.xSize) / 2);
        this.guiTop = (int) ((this.height - this.ySize) / 2);
        this.buttonList.add(new GuiButton(0, this.guiLeft + (this.xSize - 100) / 2, this.guiTop + 70, 100, 20, StatCollector.translateToLocal("container.cultivator.stopCultivating")));
    }
    
    @Override
    public void actionPerformed(GuiButton button)
    {
        if (button.id == 0)
        {
            float progress = (float) this.cultivator.getcultivateTimeProgressScaled(100) / 100.0F;
            this.cultivator.cancelHatching(progress);
            this.mc.thePlayer.closeScreen();
        }
    }
    
    @Override
    public void drawScreen(int x, int y, float f)
    {
        this.drawDefaultBackground();
        this.mc.renderEngine.bindTexture(new ResourceLocation(JurassiCraft.getModId() + "textures/gui/guiCultivateProgress.png"));
        this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
        this.drawTexturedModalRect(this.guiLeft + 13, this.guiTop + 49, 0, 107, this.cultivator.getcultivateTimeProgressScaled(150), 9);
        Creature creature = this.cultivator.getCreature();
        
        String name;
        
        if (creature != null)
        {
            name = creature.getCreatureName();
        }
        else
        {
            name = "Unknown";
        }
        
        this.fontRendererObj.drawString(StatCollector.translateToLocal("container.cultivator.cultivating") + ": " + name, this.guiLeft + (this.xSize - this.fontRendererObj.getStringWidth(StatCollector.translateToLocal("container.cultivator.cultivating") + ": " + name)) / 2, this.guiTop + 10, 4210752);
        this.fontRendererObj.drawString(StatCollector.translateToLocal("container.cultivator.progress") + ": " + this.cultivator.getcultivateTimeProgressScaled(100) + "%", this.guiLeft + (this.xSize - this.fontRendererObj.getStringWidth(StatCollector.translateToLocal("container.cultivator.progress") + ": " + this.cultivator.getcultivateTimeProgressScaled(100) + "%")) / 2, this.guiTop + 30, 4210752);
        
        super.drawScreen(x, y, f);
    }
}
