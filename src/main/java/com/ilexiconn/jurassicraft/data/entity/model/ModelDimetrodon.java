// Date: 14.06.2014 19:41:52
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX






package com.ilexiconn.jurassicraft.data.entity.model;

import org.lwjgl.opengl.GL11;

import net.minecraft.entity.Entity;

public class ModelDimetrodon extends MowzieModelBase
{
  //fields
    MowzieModelRenderer Head;
    MowzieModelRenderer BackHead;
    MowzieModelRenderer Jaw;
    MowzieModelRenderer Neck;
    MowzieModelRenderer Torso;
    MowzieModelRenderer Lower_Body;
    MowzieModelRenderer Tail1;
    MowzieModelRenderer Tail2;
    MowzieModelRenderer Thigh1;
    MowzieModelRenderer Thigh2;
    MowzieModelRenderer Thigh3;
    MowzieModelRenderer Thigh4;
    MowzieModelRenderer Leg1;
    MowzieModelRenderer Leg2;
    MowzieModelRenderer Leg3;
    MowzieModelRenderer Leg4;
    MowzieModelRenderer MiniSail1;
    MowzieModelRenderer Sail1;
    MowzieModelRenderer Sail2;
    MowzieModelRenderer Sail3;
    MowzieModelRenderer Sail4;
    MowzieModelRenderer MiniSail2;
    MowzieModelRenderer Teeth;
  
  public ModelDimetrodon()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      Head = new MowzieModelRenderer(this, 0, 0);
      Head.addBox(0F, 0F, 0F, 5, 5, 7);
      Head.setRotationPoint(-2F, 9F, -24F);
      Head.setTextureSize(64, 64);
      Head.mirror = true;
      setRotation(Head, 0.1396263F, 0F, 0F);
      BackHead = new MowzieModelRenderer(this, 31, 0);
      BackHead.addBox(0F, 0F, 0F, 6, 6, 5);
      BackHead.setRotationPoint(-2.5F, 8F, -18F);
      BackHead.setTextureSize(64, 64);
      BackHead.mirror = true;
      setRotation(BackHead, 0F, 0F, 0F);
      Jaw = new MowzieModelRenderer(this, 18, 5);
      Jaw.addBox(0F, 0F, 0F, 3, 1, 7);
      Jaw.setRotationPoint(-1F, 13F, -23F);
      Jaw.setTextureSize(64, 64);
      Jaw.mirror = true;
      setRotation(Jaw, 0F, 0F, 0F);
      Neck = new MowzieModelRenderer(this, 0, 12);
      Neck.addBox(0F, 0F, 0F, 5, 6, 8);
      Neck.setRotationPoint(-2F, 9F, -14F);
      Neck.setTextureSize(64, 64);
      Neck.mirror = true;
      setRotation(Neck, -0.5585054F, 0F, 0F);
      Torso = new MowzieModelRenderer(this, 30, 11);
      Torso.addBox(0F, 0F, 0F, 9, 7, 8);
      Torso.setRotationPoint(-4F, 12.5F, -11F);
      Torso.setTextureSize(64, 64);
      Torso.mirror = true;
      setRotation(Torso, 0F, 0F, 0F);
      Lower_Body = new MowzieModelRenderer(this, 0, 26);
      Lower_Body.addBox(0F, 0F, 0F, 7, 6, 10);
      Lower_Body.setRotationPoint(-3F, 13.5F, -4F);
      Lower_Body.setTextureSize(64, 64);
      Lower_Body.mirror = true;
      setRotation(Lower_Body, -0.1745329F, 0F, 0F);
      Tail1 = new MowzieModelRenderer(this, 34, 26);
      Tail1.addBox(0F, 0F, 0F, 4, 4, 8);
      Tail1.setRotationPoint(-1.5F, 16F, 4F);
      Tail1.setTextureSize(64, 64);
      Tail1.mirror = true;
      setRotation(Tail1, 0F, 0F, 0F);
      Tail2 = new MowzieModelRenderer(this, 36, 38);
      Tail2.addBox(0F, 0F, 0F, 2, 2, 12);
      Tail2.setRotationPoint(-0.5F, 17F, 12F);
      Tail2.setTextureSize(64, 64);
      Tail2.mirror = true;
      setRotation(Tail2, 0F, 0F, 0F);
      Thigh1 = new MowzieModelRenderer(this, 12, 42);
      Thigh1.addBox(0F, 0F, 0F, 4, 4, 4);
      Thigh1.setRotationPoint(5F, 17F, -10F);
      Thigh1.setTextureSize(64, 64);
      Thigh1.mirror = true;
      setRotation(Thigh1, 0.0698132F, 0F, 0F);
      Thigh2 = new MowzieModelRenderer(this, 12, 42);
      Thigh2.addBox(0F, 0F, 0F, 4, 4, 4);
      Thigh2.setRotationPoint(4F, 17F, -1F);
      Thigh2.setTextureSize(64, 64);
      Thigh2.mirror = true;
      setRotation(Thigh2, 0.0698132F, 0F, 0F);
      Thigh3 = new MowzieModelRenderer(this, 12, 42);
      Thigh3.addBox(0F, 0F, 0F, 4, 4, 4);
      Thigh3.setRotationPoint(-7F, 17F, -1F);
      Thigh3.setTextureSize(64, 64);
      Thigh3.mirror = true;
      setRotation(Thigh3, 0.0698132F, 0F, 0F);
      Thigh4 = new MowzieModelRenderer(this, 12, 42);
      Thigh4.addBox(0F, 0F, 0F, 4, 4, 4);
      Thigh4.setRotationPoint(-8F, 17F, -10F);
      Thigh4.setTextureSize(64, 64);
      Thigh4.mirror = true;
      setRotation(Thigh4, 0.0698132F, 0F, 0F);
      Leg1 = new MowzieModelRenderer(this, 0, 42);
      Leg1.addBox(0F, 0F, 0F, 3, 4, 3);
      Leg1.setRotationPoint(7F, 20F, -8F);
      Leg1.setTextureSize(64, 64);
      Leg1.mirror = true;
      setRotation(Leg1, 0F, 0F, 0F);
      Leg2 = new MowzieModelRenderer(this, 0, 42);
      Leg2.addBox(0F, 0F, 0F, 3, 4, 3);
      Leg2.setRotationPoint(7F, 20F, 1F);
      Leg2.setTextureSize(64, 64);
      Leg2.mirror = true;
      setRotation(Leg2, 0F, 0F, 0F);
      Leg3 = new MowzieModelRenderer(this, 0, 42);
      Leg3.addBox(0F, 0F, 0F, 3, 4, 3);
      Leg3.setRotationPoint(-9F, 20F, 1F);
      Leg3.setTextureSize(64, 64);
      Leg3.mirror = true;
      setRotation(Leg3, 0F, 0F, 0F);
      Leg4 = new MowzieModelRenderer(this, 0, 42);
      Leg4.addBox(0F, 0F, 0F, 3, 4, 3);
      Leg4.setRotationPoint(-9F, 20F, -8F);
      Leg4.setTextureSize(64, 64);
      Leg4.mirror = true;
      setRotation(Leg4, 0F, 0F, 0F);
      MiniSail1 = new MowzieModelRenderer(this, 28, 42);
      MiniSail1.addBox(0F, -8F, 0F, 1, 9, 3);
      MiniSail1.setRotationPoint(0F, 13F, -11F);
      MiniSail1.setTextureSize(64, 64);
      MiniSail1.mirror = true;
      setRotation(MiniSail1, 0F, 0F, 0F);
      Sail1 = new MowzieModelRenderer(this, 28, 42);
      Sail1.addBox(0F, -11F, 0F, 1, 15, 3);
      Sail1.setRotationPoint(0F, 13F, -8F);
      Sail1.setTextureSize(64, 64);
      Sail1.mirror = true;
      setRotation(Sail1, 0F, 0F, 0F);
      Sail2 = new MowzieModelRenderer(this, 28, 42);
      Sail2.addBox(0F, -14F, 0F, 1, 15, 3);
      Sail2.setRotationPoint(0F, 14F, -5F);
      Sail2.setTextureSize(64, 64);
      Sail2.mirror = true;
      setRotation(Sail2, 0F, 0F, 0F);
      Sail3 = new MowzieModelRenderer(this, 28, 42);
      Sail3.addBox(0F, -15F, 0F, 1, 15, 3);
      Sail3.setRotationPoint(0F, 15F, -2F);
      Sail3.setTextureSize(64, 64);
      Sail3.mirror = true;
      setRotation(Sail3, 0F, 0F, 0F);
      Sail4 = new MowzieModelRenderer(this, 28, 42);
      Sail4.addBox(0F, -13F, 0F, 1, 15, 3);
      Sail4.setRotationPoint(0F, 15F, 1F);
      Sail4.setTextureSize(64, 64);
      Sail4.mirror = true;
      setRotation(Sail4, 0F, 0F, 0F);
      MiniSail2 = new MowzieModelRenderer(this, 28, 42);
      MiniSail2.addBox(0F, -11F, 0F, 1, 12, 3);
      MiniSail2.setRotationPoint(0F, 17F, 4F);
      MiniSail2.setTextureSize(64, 64);
      MiniSail2.mirror = true;
      setRotation(MiniSail2, 0F, 0F, 0F);
      Teeth = new MowzieModelRenderer(this, 0, 50);
      Teeth.addBox(0F, 0F, 0F, 5, 1, 7);
      Teeth.setRotationPoint(-2F, 13.9F, -23.3F);
      Teeth.setTextureSize(64, 64);
      Teeth.mirror = true;
      setRotation(Teeth, 0.1396263F, 0F, 0F);
      
      addChildTo(Head, BackHead);
      addChildTo(Jaw, BackHead);
      addChildTo(Teeth, BackHead);
      addChildTo(BackHead, Neck);

      addChildTo(Sail1, MiniSail1);
      addChildTo(Sail2, Sail1);
      addChildTo(Sail3, Sail2);
      addChildTo(Sail4, Sail3);
      addChildTo(MiniSail2, Sail4);
      
      addChildTo(Tail2, Tail1);
      addChildTo(Tail1, Lower_Body);
 
      addChildTo(Leg1, Thigh1);
      addChildTo(Leg2, Thigh2);
      addChildTo(Leg3, Thigh3);
      addChildTo(Leg4, Thigh4);
      
      Head.setInitValuesToCurrentPose();
      BackHead.setInitValuesToCurrentPose();
      Jaw.setInitValuesToCurrentPose();
      Neck.setInitValuesToCurrentPose();
      Torso.setInitValuesToCurrentPose();
      Lower_Body.setInitValuesToCurrentPose();
      Tail1.setInitValuesToCurrentPose();
      Tail2.setInitValuesToCurrentPose();
      Thigh1.setInitValuesToCurrentPose();
      Thigh2.setInitValuesToCurrentPose();
      Thigh3.setInitValuesToCurrentPose();
      Thigh4.setInitValuesToCurrentPose();
      Leg1.setInitValuesToCurrentPose();
      Leg2.setInitValuesToCurrentPose();
      Leg3.setInitValuesToCurrentPose();
      Leg4.setInitValuesToCurrentPose();
      MiniSail1.setInitValuesToCurrentPose();
      Sail1.setInitValuesToCurrentPose();
      Sail2.setInitValuesToCurrentPose();
      Sail3.setInitValuesToCurrentPose();
      Sail4.setInitValuesToCurrentPose();
      MiniSail2.setInitValuesToCurrentPose();
      Teeth.setInitValuesToCurrentPose();
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    if (isChild)
    {
        float var8 = 2.0F;
        GL11.glPushMatrix();
        GL11.glTranslatef(0.0F, 5.0F * f5, 2.0F * f5);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glScalef(1.0F / var8, 1.0F / var8, 1.0F / var8);
        GL11.glTranslatef(0.0F, 24.0F * f5, 0.0F);

    Neck.render(f5);
    Torso.render(f5);
    Lower_Body.render(f5);

    Thigh1.render(f5);
    Thigh2.render(f5);
    Thigh3.render(f5);
    Thigh4.render(f5);

    MiniSail1.render(f5);

    Teeth.render(f5);
    GL11.glPopMatrix();
}
else
{
	//Lol
}
  }
  
  private void setRotation(MowzieModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}
