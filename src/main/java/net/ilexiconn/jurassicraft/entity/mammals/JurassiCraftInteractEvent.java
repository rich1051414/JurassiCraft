package net.ilexiconn.jurassicraft.entity.mammals;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.EntityInteractEvent;
import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.client.gui.GuiPregnancyProgress;
import net.ilexiconn.jurassicraft.item.ItemDinoPad;

public class JurassiCraftInteractEvent 
{

	@SubscribeEvent
	public void onEntityInteract(EntityInteractEvent event) 
	{
		if (event.entity instanceof EntityPlayer) 
		{
			if (event.target != null) 
			{
				EntityPlayer player = (EntityPlayer) event.entity;
				ItemStack heldItem = player.getHeldItem();
				if (!event.target.worldObj.isRemote && heldItem != (ItemStack) null && heldItem.getItem() instanceof ItemDinoPad) 
				{
					this.showStatus(event);
				}
			}
		}
		
	}
	
    @SideOnly(Side.CLIENT)
    public void showStatus(EntityInteractEvent event)
    {
    	if (event.target instanceof EntityCow) {
	    	GuiPregnancyProgress.creatureToAnalyze = (Object) event.target;
	        FMLClientHandler.instance().getClient().thePlayer.openGui(JurassiCraft.instance, 13, event.target.worldObj, 0, 0, 0);
		} else if (event.target instanceof EntityPig) {
	    	GuiPregnancyProgress.creatureToAnalyze = (Object) event.target;
	        FMLClientHandler.instance().getClient().thePlayer.openGui(JurassiCraft.instance, 13, event.target.worldObj, 0, 0, 0);
		} else if (event.target instanceof EntityHorse) {
	    	GuiPregnancyProgress.creatureToAnalyze = (Object) event.target;
	        FMLClientHandler.instance().getClient().thePlayer.openGui(JurassiCraft.instance, 13, event.target.worldObj, 0, 0, 0);
		} else if (event.target instanceof EntitySheep) {
	    	GuiPregnancyProgress.creatureToAnalyze = (Object) event.target;
	        FMLClientHandler.instance().getClient().thePlayer.openGui(JurassiCraft.instance, 13, event.target.worldObj, 0, 0, 0);
		}
	}
}