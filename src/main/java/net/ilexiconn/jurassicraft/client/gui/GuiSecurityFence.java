package net.ilexiconn.jurassicraft.client.gui;

import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.container.ContainerSecurityFence;
import net.ilexiconn.jurassicraft.packet.MessageFenceBuilding;
import net.ilexiconn.jurassicraft.packet.MessageFenceCrafting;
import net.ilexiconn.jurassicraft.packet.MessageFenceFixing;
import net.ilexiconn.jurassicraft.tile.TileSecurityFence;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

import java.util.HashMap;

public class GuiSecurityFence extends GuiContainer
{

    private TileSecurityFence fence;
    private int[] requiredMaterials = new int[3];
    private HashMap<Integer, int[]> fenceMap = new HashMap<Integer, int[]>();

    public GuiSecurityFence(InventoryPlayer inventoryPlayer, TileSecurityFence entity)
    {
        super(new ContainerSecurityFence(inventoryPlayer, entity));
        this.xSize = 256;
        this.ySize = 256;
        this.fence = entity;
    }

    @Override
    public void initGui()
    {
        super.initGui();
        this.buttonList.clear();
        /** Direction buttons. */
        this.buttonList.add(new GuiButtonFenceGeneric(0, this.guiLeft + 54, this.guiTop + 126, 15, 45, 15, 10));
        this.buttonList.add(new GuiButtonFenceGeneric(1, this.guiLeft + 10, this.guiTop + 78, 15, 0, 10, 15));
        this.buttonList.add(new GuiButtonFenceGeneric(2, this.guiLeft + 54, this.guiTop + 34, 0, 45, 15, 10));
        this.buttonList.add(new GuiButtonFenceGeneric(3, this.guiLeft + 102, this.guiTop + 78, 25, 0, 10, 15));

        /** Craft buttons. */
        this.buttonList.add(new GuiButtonFenceGeneric(4, this.guiLeft + 122, this.guiTop + 79, 50, 0, 7, 7));
        this.buttonList.add(new GuiButtonFenceGeneric(5, this.guiLeft + 122, this.guiTop + 96, 50, 0, 7, 7));
        this.buttonList.add(new GuiButtonFenceGeneric(6, this.guiLeft + 122, this.guiTop + 113, 50, 0, 7, 7));
        this.buttonList.add(new GuiButtonFenceGeneric(7, this.guiLeft + 237, this.guiTop + 79, 57, 0, 11, 7));
        this.buttonList.add(new GuiButtonFenceGeneric(8, this.guiLeft + 237, this.guiTop + 96, 57, 0, 11, 7));
        this.buttonList.add(new GuiButtonFenceGeneric(9, this.guiLeft + 237, this.guiTop + 113, 57, 0, 11, 7));

        /** Update button. */
        this.buttonList.add(new GuiButtonFenceGeneric(10, this.guiLeft + 23, this.guiTop + 142, 35, 0, 15, 15));

        /** Upgrade button. */
        this.buttonList.add(new GuiButtonFenceGeneric(11, this.guiLeft + 186, this.guiTop + 11, 0, 0, 15, 15));

        /** Fixing button. */
        this.buttonList.add(new GuiButton(12, this.guiLeft + 138, this.guiTop + 130, 80, 20, StatCollector.translateToLocal("container.fixFence")));
        this.fenceMap = this.fence.getAllMainBlocks();
        this.refreshFixButton();
        this.refreshUpgradeButton();
    }

    @Override
    public void updateScreen()
    {
        switch (this.fence.getDirection())
        {
            case 0:
                ((GuiButton) this.buttonList.get(0)).enabled = false;
                ((GuiButton) this.buttonList.get(1)).enabled = true;
                ((GuiButton) this.buttonList.get(2)).enabled = true;
                ((GuiButton) this.buttonList.get(3)).enabled = true;
                break;
            case 1:
                ((GuiButton) this.buttonList.get(0)).enabled = true;
                ((GuiButton) this.buttonList.get(1)).enabled = false;
                ((GuiButton) this.buttonList.get(2)).enabled = true;
                ((GuiButton) this.buttonList.get(3)).enabled = true;
                break;
            case 2:
                ((GuiButton) this.buttonList.get(0)).enabled = true;
                ((GuiButton) this.buttonList.get(1)).enabled = true;
                ((GuiButton) this.buttonList.get(2)).enabled = false;
                ((GuiButton) this.buttonList.get(3)).enabled = true;
                break;
            case 3:
                ((GuiButton) this.buttonList.get(0)).enabled = true;
                ((GuiButton) this.buttonList.get(1)).enabled = true;
                ((GuiButton) this.buttonList.get(2)).enabled = true;
                ((GuiButton) this.buttonList.get(3)).enabled = false;
                break;
        }
        if (this.fence.canCraftBases(1))
        {
            ((GuiButton) this.buttonList.get(4)).enabled = true;
            if (this.fence.canCraftBases(3))
            {
                ((GuiButton) this.buttonList.get(7)).enabled = true;
            }
            else
            {
                ((GuiButton) this.buttonList.get(7)).enabled = false;
            }
        }
        else
        {
            ((GuiButton) this.buttonList.get(4)).enabled = false;
            ((GuiButton) this.buttonList.get(7)).enabled = false;
        }
        if (this.fence.canCraftGrids(1))
        {
            ((GuiButton) this.buttonList.get(5)).enabled = true;
            if (this.fence.canCraftGrids(3))
            {
                ((GuiButton) this.buttonList.get(8)).enabled = true;
            }
            else
            {
                ((GuiButton) this.buttonList.get(8)).enabled = false;
            }
        }
        else
        {
            ((GuiButton) this.buttonList.get(5)).enabled = false;
            ((GuiButton) this.buttonList.get(8)).enabled = false;
        }
        if (this.fence.canCraftPoles(1))
        {
            ((GuiButton) this.buttonList.get(6)).enabled = true;
            if (this.fence.canCraftPoles(3))
            {
                ((GuiButton) this.buttonList.get(9)).enabled = true;
            }
            else
            {
                ((GuiButton) this.buttonList.get(9)).enabled = false;
            }
        }
        else
        {
            ((GuiButton) this.buttonList.get(6)).enabled = false;
            ((GuiButton) this.buttonList.get(9)).enabled = false;
        }
    }

    @Override
    public void actionPerformed(GuiButton button)
    {
        switch (button.id)
        {
            case 0:
                this.fence.setDirection((byte) 0);
                this.refreshFixButton();
                this.refreshUpgradeButton();
                break;
            case 1:
                this.fence.setDirection((byte) 1);
                this.refreshFixButton();
                this.refreshUpgradeButton();
                break;
            case 2:
                this.fence.setDirection((byte) 2);
                this.refreshFixButton();
                this.refreshUpgradeButton();
                break;
            case 3:
                this.fence.setDirection((byte) 3);
                this.refreshFixButton();
                this.refreshUpgradeButton();
                break;
            case 4:
                this.fence.tryToIncreaseFenceBases(1);
                JurassiCraft.network.sendToServer(new MessageFenceCrafting(0, this.fence.xCoord, this.fence.yCoord, this.fence.zCoord, 1));
                this.refreshUpgradeButton();
                break;
            case 5:
                this.fence.tryToIncreaseFenceGrids(1);
                JurassiCraft.network.sendToServer(new MessageFenceCrafting(1, this.fence.xCoord, this.fence.yCoord, this.fence.zCoord, 1));
                this.refreshUpgradeButton();
                break;
            case 6:
                this.fence.tryToIncreaseFencePoles(1);
                JurassiCraft.network.sendToServer(new MessageFenceCrafting(2, this.fence.xCoord, this.fence.yCoord, this.fence.zCoord, 1));
                this.refreshUpgradeButton();
                break;
            case 7:
                this.fence.tryToIncreaseFenceBases(3);
                JurassiCraft.network.sendToServer(new MessageFenceCrafting(3, this.fence.xCoord, this.fence.yCoord, this.fence.zCoord, 3));
                this.refreshUpgradeButton();
                break;
            case 8:
                this.fence.tryToIncreaseFenceGrids(3);
                JurassiCraft.network.sendToServer(new MessageFenceCrafting(4, this.fence.xCoord, this.fence.yCoord, this.fence.zCoord, 3));
                this.refreshUpgradeButton();
                break;
            case 9:
                this.fence.tryToIncreaseFencePoles(3);
                JurassiCraft.network.sendToServer(new MessageFenceCrafting(5, this.fence.xCoord, this.fence.yCoord, this.fence.zCoord, 3));
                this.refreshUpgradeButton();
                break;
            case 10:
                this.fenceMap = this.fence.getAllMainBlocks();
                this.refreshFixButton();
                this.refreshUpgradeButton();
                break;
            case 11:
                JurassiCraft.network.sendToServer(new MessageFenceBuilding(this.fence.xCoord, this.fence.yCoord, this.fence.zCoord, this.fence.getSecurityLevel(this.fence.getDirection()), this.fence.getDirection(), this.fence.calculateDistanceToNextPole(this.fence.getDirection()), this.fence.getHeightPlanned(this.fence.getSecurityLevel(this.fence.getDirection()))));
                ((GuiButton) this.buttonList.get(11)).enabled = false;
                break;
            case 12:
                JurassiCraft.network.sendToServer(new MessageFenceFixing(this.fence.xCoord, this.fence.yCoord, this.fence.zCoord, this.fence.getSecurityLevel(this.fence.getDirection()) - 1, this.fence.getDirection(), this.fence.calculateDistanceToNextPole(this.fence.getDirection()), this.fence.getHeightPlanned(this.fence.getSecurityLevel(this.fence.getDirection()) - 1), this.requiredMaterials[0], this.requiredMaterials[1], this.requiredMaterials[2]));
                ((GuiButton) this.buttonList.get(12)).visible = false;
                requiredMaterials = new int[]{0, 0, 0};
                break;
        }
    }

    @Override
    public void onGuiClosed()
    {
        super.onGuiClosed();
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int i, int j)
    {
        this.fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 48, 163, 4210752);
        String text = "";
        if ((requiredMaterials[0] == 0 && requiredMaterials[1] == 0 && requiredMaterials[2] == 0) || !this.fence.isFenceBuilt(this.fence.getDirection()))
        {
            this.drawMaterialsToBuild();
        }
        else
        {
            this.drawMaterialsToFix();
        }
        switch (this.fence.getSecurityLevel(this.fence.getDirection()))
        {
            case 0:
                text = StatCollector.translateToLocal("container.securityFenceInexistent");
                break;
            case 1:
                text = StatCollector.translateToLocal("container.securityFenceLow");
                break;
            case 2:
                text = StatCollector.translateToLocal("container.securityFenceMedium");
                break;
            case 3:
                text = StatCollector.translateToLocal("container.securityFenceHigh");
                break;
        }
        this.fontRendererObj.drawString(text, 116 - this.fontRendererObj.getStringWidth(text) / 2, 15, 4210752);
        switch (this.fence.getDirection())
        {
            case 0:
                text = StatCollector.translateToLocal("container.directionSouth");
                break;
            case 1:
                text = StatCollector.translateToLocal("container.directionWest");
                break;
            case 2:
                text = StatCollector.translateToLocal("container.directionNorth");
                break;
            case 3:
                text = StatCollector.translateToLocal("container.directionEast");
                break;
            default:
                text = StatCollector.translateToLocal("container.directionInexistent");
                break;
        }
        this.fontRendererObj.drawString(text, 71 - this.fontRendererObj.getStringWidth(text) / 2, 146, 4210752);
    }

    private void drawMaterialsToFix()
    {
        String text = "";
        text = StatCollector.translateToLocal("container.fencebasesblocks") + ": " + this.fence.getFenceBasesStored() + "/" + requiredMaterials[0];
        this.fontRendererObj.drawString(text, 184 - this.fontRendererObj.getStringWidth(text) / 2, 79, 4210752);
        text = StatCollector.translateToLocal("container.fencegridsblocks") + ": " + this.fence.getFenceGridsStored() + "/" + requiredMaterials[1];
        this.fontRendererObj.drawString(text, 184 - this.fontRendererObj.getStringWidth(text) / 2, 96, 4210752);
        text = StatCollector.translateToLocal("container.fencepolesblocks") + ": " + this.fence.getFencePolesStored() + "/" + requiredMaterials[2];
        this.fontRendererObj.drawString(text, 184 - this.fontRendererObj.getStringWidth(text) / 2, 113, 4210752);
    }

    private void drawMaterialsToBuild()
    {
        String text = "";
        if (this.fence.getSecurityLevel(this.fence.getDirection()) < 3)
        {
            int distance = this.fence.calculateDistanceToNextPole(this.fence.getDirection());
            int requiredMaterial = 0;
            if ((distance - 1) > -1)
            {
                requiredMaterial = distance - 1;
            }
            else
            {
                requiredMaterial = 0;
            }
            text = StatCollector.translateToLocal("container.fencebasesblocks") + ": " + this.fence.getFenceBasesStored() + "/" + ((requiredMaterial > 0) ? requiredMaterial : "--");
            this.fontRendererObj.drawString(text, 178 - this.fontRendererObj.getStringWidth(text) / 2, 79, 4210752);
            if ((this.fence.getHeightPlanned(this.fence.getSecurityLevel(this.fence.getDirection())) * (distance - 1)) > -1)
            {
                requiredMaterial = this.fence.getHeightPlanned(this.fence.getSecurityLevel(this.fence.getDirection())) * (distance - 1);
            }
            else
            {
                requiredMaterial = 0;
            }
            text = StatCollector.translateToLocal("container.fencegridsblocks") + ": " + this.fence.getFenceGridsStored() + "/" + ((requiredMaterial > 0) ? requiredMaterial : "--");
            this.fontRendererObj.drawString(text, 178 - this.fontRendererObj.getStringWidth(text) / 2, 96, 4210752);
            if ((distance - 1) > -1)
            {
                requiredMaterial = ((this.fence.getSecurityLevel(this.fence.getDirection()) == 0 || this.fence.getSecurityLevel(this.fence.getDirection()) == 2) ? 4 : 2);
            }
            else
            {
                requiredMaterial = 0;
            }
            text = StatCollector.translateToLocal("container.fencepolesblocks") + ": " + this.fence.getFencePolesStored() + "/" + ((requiredMaterial > 0) ? requiredMaterial : "--");
            this.fontRendererObj.drawString(text, 178 - this.fontRendererObj.getStringWidth(text) / 2, 113, 4210752);
        }
        else
        {
            text = StatCollector.translateToLocal("container.fencebasesblocks") + ": " + this.fence.getFenceBasesStored() + "/--";
            this.fontRendererObj.drawString(text, 178 - this.fontRendererObj.getStringWidth(text) / 2, 79, 4210752);
            text = StatCollector.translateToLocal("container.fencegridsblocks") + ": " + this.fence.getFenceGridsStored() + "/--";
            this.fontRendererObj.drawString(text, 178 - this.fontRendererObj.getStringWidth(text) / 2, 96, 4210752);
            text = StatCollector.translateToLocal("container.fencepolesblocks") + ": " + this.fence.getFencePolesStored() + "/--";
            this.fontRendererObj.drawString(text, 178 - this.fontRendererObj.getStringWidth(text) / 2, 113, 4210752);
        }
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3)
    {
        GL11.glColor4f(1F, 1F, 1F, 1F);
        this.mc.renderEngine.bindTexture(new ResourceLocation(JurassiCraft.getModId() + "textures/gui/guiSecurityFence.png"));
        this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
        this.mc.renderEngine.bindTexture(new ResourceLocation(JurassiCraft.getModId() + "textures/gui/guiSecurityFenceWidgets.png"));
        switch (this.fence.getDirection())
        {
            case 0:
                this.drawTexturedModalRect(this.guiLeft + 59, this.guiTop + 83, 70, 0, 4, 37);
                break;
            case 1:
                this.drawTexturedModalRect(this.guiLeft + 26, this.guiTop + 83, 70, 0, 37, 4);
                break;
            case 2:
                this.drawTexturedModalRect(this.guiLeft + 59, this.guiTop + 50, 70, 0, 4, 37);
                break;
            case 3:
                this.drawTexturedModalRect(this.guiLeft + 59, this.guiTop + 83, 70, 0, 37, 4);
                break;
        }
        if (!this.fenceMap.isEmpty())
        {
            for (int i = 0; i < this.fenceMap.size(); i++)
            {
                this.drawTexturedModalRect(this.guiLeft + 60 + 3 * this.fenceMap.get(i)[0], this.guiTop + 84 + 3 * this.fenceMap.get(i)[1], 68, 0, 2, 2);
            }
        }
    }

    private void refreshFixButton()
    {
        if (this.fence.isFenceBuilt(this.fence.getDirection()))
        {
            this.requiredMaterials = this.fence.getBlocksToRepair(this.fence.getSecurityLevel(this.fence.getDirection()), this.fence.getDirection(), this.fence.calculateDistanceToNextPole(this.fence.getDirection()));
            if (requiredMaterials[0] == 0 && requiredMaterials[1] == 0 && requiredMaterials[2] == 0)
            {
                ((GuiButton) this.buttonList.get(12)).visible = false;
            }
            else
            {
                ((GuiButton) this.buttonList.get(12)).visible = this.fence.canRepair(this.fence.getSecurityLevel(this.fence.getDirection()), this.fence.getDirection());
            }
        }
        else
        {
            ((GuiButton) this.buttonList.get(12)).visible = false;
        }
    }

    private void refreshUpgradeButton()
    {
        if (this.fence.canBuildFence(this.fence.getSecurityLevel(this.fence.getDirection()), this.fence.getDirection(), this.fence.calculateDistanceToNextPole(this.fence.getDirection()), this.fence.getHeightPlanned(this.fence.getSecurityLevel(this.fence.getDirection()))))
        {
            this.requiredMaterials = this.fence.getBlocksToRepair(this.fence.getSecurityLevel(this.fence.getDirection()), this.fence.getDirection(), this.fence.calculateDistanceToNextPole(this.fence.getDirection()));
            if (requiredMaterials[0] == 0 && requiredMaterials[1] == 0 && requiredMaterials[2] == 0)
            {
                ((GuiButton) this.buttonList.get(11)).enabled = true;
            }
            else
            {
                ((GuiButton) this.buttonList.get(11)).enabled = false;
            }
        }
        else
        {
            ((GuiButton) this.buttonList.get(11)).enabled = false;
        }
    }
}
