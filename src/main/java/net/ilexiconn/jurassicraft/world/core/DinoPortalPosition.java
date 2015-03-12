package net.ilexiconn.jurassicraft.world.core;

import net.minecraft.util.ChunkCoordinates;

public class DinoPortalPosition extends ChunkCoordinates
{
	public long field_85087_d;
	final TeleporterDino teleporter;
	
	public DinoPortalPosition(TeleporterDino teleporter, int par2, int par3, int par4, long par5)
	{
		super(par2, par3, par4);
		this.teleporter = teleporter;
		this.field_85087_d = par5;
	}
}