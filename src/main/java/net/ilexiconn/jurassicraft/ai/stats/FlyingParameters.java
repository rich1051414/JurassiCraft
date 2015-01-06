package net.ilexiconn.jurassicraft.ai.stats;

import net.minecraft.block.material.Material;

public class FlyingParameters
{
    public int flyHeightMin;
    public int flyHeightMax;
    public float flySpeedModifier;
    public int flyRefreshRateY;
    public int flyRefreshRateXZ;
    public int flyRefreshRateSpeed;
    public int flightTimeMin;
    public int flightTimeMax;
    public int flapRate;
    public Material[] landingMaterial;

    public FlyingParameters(int heightMin, int heightMax, float speedMod, int rateY, int rateXZ, int rateSpeed, int flightTimeMin, int flightTimeMax, int flapRate, String landingMaterial) {
        flyHeightMin = heightMin;
        flyHeightMax = heightMax;
        flySpeedModifier = speedMod;
        flyRefreshRateY = rateY;
        flyRefreshRateXZ = rateXZ;
        flyRefreshRateSpeed = rateSpeed;
        this.flightTimeMin = flightTimeMin;
        this.flightTimeMax = flightTimeMax;
        this.flapRate = flapRate / 4;
        if(landingMaterial.equalsIgnoreCase("grassandleaves")) this.landingMaterial = new Material[] { Material.leaves, Material.grass };
        else if(landingMaterial.equalsIgnoreCase("leaves")) this.landingMaterial = new Material[] { Material.leaves };
        else this.landingMaterial = null;
    }

    public boolean willLandInMaterial(Material m) {
        for(Material mat : landingMaterial) {
            if(m == mat) return true;
        }
        return false;
    }
}
