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
    
    public FlyingParameters(int heightMin, int heightMax, float speedMod, int rateY, int rateXZ, int rateSpeed, int flightTimeMin, int flightTimeMax, int flapRate, String landingMaterial)
    {
        flyHeightMin = heightMin;
        flyHeightMax = heightMax;
        flySpeedModifier = speedMod;
        flyRefreshRateY = rateY;
        flyRefreshRateXZ = rateXZ;
        flyRefreshRateSpeed = rateSpeed;
        this.flightTimeMin = flightTimeMin;
        this.flightTimeMax = flightTimeMax;
        this.flapRate = flapRate / 4;
        
        landingMaterial = landingMaterial.toLowerCase();
        
        Material grass = null;
        Material leaves = null;
        
        if(landingMaterial.contains("grass"))
        {
            grass = Material.grass;
        }
        
        if(landingMaterial.contains("leaves"))
        {
            leaves = Material.leaves;
        }
        
        this.landingMaterial = new Material[]{grass, leaves};
    }
    
    public boolean willLandInMaterial(Material m)
    {
        if (landingMaterial != null)
        {
            for (Material mat : landingMaterial)
            {
                if (m == mat)
                {
                    return true;
                }
            }
        }
        
        return false;
    }
}
