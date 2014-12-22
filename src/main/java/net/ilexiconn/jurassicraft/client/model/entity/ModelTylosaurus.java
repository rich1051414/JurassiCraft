// Date: 26/07/2014 3:26:14 PM
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX
package net.ilexiconn.jurassicraft.client.model.entity;


import net.minecraft.entity.Entity;
import net.ilexiconn.jurassicraft.entity.reptiles.EntityTylosaurus;
import to.uk.ilexiconn.llib.client.model.MowzieModelBase;
import to.uk.ilexiconn.llib.client.model.MowzieModelRenderer;

public class ModelTylosaurus extends MowzieModelBase
{
    //fields
    MowzieModelRenderer Head;
    MowzieModelRenderer Upper_Jaw;
    MowzieModelRenderer Lower_Jaw;
    MowzieModelRenderer Neck_;
    MowzieModelRenderer Body_Section_1;
    MowzieModelRenderer Body_Section_2;
    MowzieModelRenderer Body_Section_3;
    MowzieModelRenderer Tail_Section_1;
    MowzieModelRenderer Tail_Section_2;
    MowzieModelRenderer Tail_Section_3;
    MowzieModelRenderer Tail_Section_4;
    MowzieModelRenderer Fluke_Section_1;
    MowzieModelRenderer Fluke_Section_2;
    MowzieModelRenderer Fluke_Section_3;
    MowzieModelRenderer Fluke_Section_4;
    MowzieModelRenderer Fluke_Section_5;
    MowzieModelRenderer Fluke_Section_6;
    MowzieModelRenderer Right_Front_Flipper;
    MowzieModelRenderer Left_Front_Flipper;
    MowzieModelRenderer Right_Back_Flipper;
    MowzieModelRenderer Left_Back_Flipper;
    MowzieModelRenderer Upper_Knob_1_Neck;
    MowzieModelRenderer Upper_Knob_2_Neck;
    MowzieModelRenderer Upper_Knob_3_Neck;
    MowzieModelRenderer Upper_Knob_4_Neck;
    MowzieModelRenderer Upper_Knob_5_Body_1;
    MowzieModelRenderer Upper_Knob_6_Body_1;
    MowzieModelRenderer Upper_Knob_7_Body_1;
    MowzieModelRenderer Upper_Knob_8_Fluke_1_Top;
    MowzieModelRenderer Upper_Knob_9_Fluke_1_Top;
    MowzieModelRenderer Upper_Knob_10_Fluke_3_Top;
    MowzieModelRenderer Upper_Knob_11_Fluke_3_Top;
    MowzieModelRenderer Upper_Knob_12_Fluke_3_Top;
    MowzieModelRenderer Upper_Knob_13_Fluke_3_Top;
    MowzieModelRenderer Upper_Knob_19_Fluke_4_Top;
    MowzieModelRenderer Upper_Knob_20_Fluke_4_Top;
    MowzieModelRenderer Lower_Knob_1_Fluke_2_Bottom;
    MowzieModelRenderer Lower_Knob_2_Fluke_2_Bottom;
    MowzieModelRenderer Lower_Knob_3_Fluke_3_Bottom;
    MowzieModelRenderer Lower_Knob_4_Fluke_3_Bottom;
    MowzieModelRenderer Lower_Knob_5_Fluke_3_Bottom;
    MowzieModelRenderer Lower_Knob_6_Fluke_3_Bottom;
    MowzieModelRenderer Lower_Knob_7_Fluke_3_Bottom;
    MowzieModelRenderer Lower_Knob_8_Fluke_6_Bottom;
    MowzieModelRenderer Lower_Knob_9_Fluke_6_Bottom;
    MowzieModelRenderer Teeth;

  public ModelTylosaurus()
  {
    textureWidth = 256;
    textureHeight = 128;
    
    Head = new MowzieModelRenderer(this, 0, 0);
    Head.addBox(-4F, -4F, -8F, 8, 8, 8);
    Head.setRotationPoint(0F, 17F, -25F);
    Head.setTextureSize(256, 128);
    Head.mirror = true;
    setRotation(Head, 0F, 0F, 0F);
    Upper_Jaw = new MowzieModelRenderer(this, 0, 23);
    Upper_Jaw.addBox(-2.5F, 0F, -10F, 5, 4, 10);
    Upper_Jaw.setRotationPoint(0F, 14.5F, -32F);
    Upper_Jaw.setTextureSize(256, 128);
    Upper_Jaw.mirror = true;
    setRotation(Upper_Jaw, 0F, 0F, 0F);
    Lower_Jaw = new MowzieModelRenderer(this, 0, 42);
    Lower_Jaw.addBox(-2F, 0F, -10F, 4, 2, 10);
    Lower_Jaw.setRotationPoint(0F, 18.5F, -31F);
    Lower_Jaw.setTextureSize(256, 128);
    Lower_Jaw.mirror = true;
    setRotation(Lower_Jaw, 0F, 0F, 0F);
    Neck_ = new MowzieModelRenderer(this, 0, 60);
    Neck_.addBox(-4.5F, 0F, 0F, 9, 10, 12);
    Neck_.setRotationPoint(0F, 12.4F, -26.5F);
    Neck_.setTextureSize(256, 128);
    Neck_.mirror = true;
    setRotation(Neck_, 0.1115409F, 0F, 0F);
    Body_Section_1 = new MowzieModelRenderer(this, 61, 15);
    Body_Section_1.addBox(-5.5F, -6F, 0F, 11, 12, 9);
    Body_Section_1.setRotationPoint(0F, 16.5F, -18F);
    Body_Section_1.setTextureSize(256, 128);
    Body_Section_1.mirror = true;
    setRotation(Body_Section_1, 0F, 0F, 0F);
    Body_Section_2 = new MowzieModelRenderer(this, 61, 15);
    Body_Section_2.addBox(-5.5F, -6F, 0F, 11, 12, 9);
    Body_Section_2.setRotationPoint(0F, 16.5F, -10F);
    Body_Section_2.setTextureSize(256, 128);
    Body_Section_2.mirror = true;
    setRotation(Body_Section_2, 0F, 0F, 0F);
    Body_Section_3 = new MowzieModelRenderer(this, 62, 15);
    Body_Section_3.addBox(-5.5F, -0.5F, 0F, 11, 12, 8);
    Body_Section_3.setRotationPoint(0F, 11F, -2F);
    Body_Section_3.setTextureSize(256, 128);
    Body_Section_3.mirror = true;
    setRotation(Body_Section_3, 0F, 0F, 0F);
    Tail_Section_1 = new MowzieModelRenderer(this, 46, 40);
    Tail_Section_1.addBox(-5F, 0F, 0F, 10, 10, 10);
    Tail_Section_1.setRotationPoint(0F, 11F, 3F);
    Tail_Section_1.setTextureSize(256, 128);
    Tail_Section_1.mirror = true;
    setRotation(Tail_Section_1, -0.0349066F, 0F, 0F);
    Tail_Section_2 = new MowzieModelRenderer(this, 46, 65);
    Tail_Section_2.addBox(-4F, 0F, 0F, 8, 8, 9);
    Tail_Section_2.setRotationPoint(0F, 12F, 10F);
    Tail_Section_2.setTextureSize(256, 128);
    Tail_Section_2.mirror = true;
    setRotation(Tail_Section_2, -0.0610865F, 0F, 0F);
    Tail_Section_3 = new MowzieModelRenderer(this, 46, 87);
    Tail_Section_3.addBox(-3F, 0F, 0F, 6, 6, 8);
    Tail_Section_3.setRotationPoint(0F, 13.5F, 17F);
    Tail_Section_3.setTextureSize(256, 128);
    Tail_Section_3.mirror = true;
    setRotation(Tail_Section_3, -0.0610865F, 0F, 0F);
    Tail_Section_4 = new MowzieModelRenderer(this, 57, 115);
    Tail_Section_4.addBox(-2F, 0F, 0F, 4, 5, 8);
    Tail_Section_4.setRotationPoint(0F, 14.5F, 24F);
    Tail_Section_4.setTextureSize(256, 128);
    Tail_Section_4.mirror = true;
    setRotation(Tail_Section_4, -0.0436332F, 0F, 0F);
    Fluke_Section_1 = new MowzieModelRenderer(this, 101, 86);
    Fluke_Section_1.addBox(-1F, -2F, 0F, 2, 4, 6);
    Fluke_Section_1.setRotationPoint(0F, 16.6F, 30.9F);
    Fluke_Section_1.setTextureSize(256, 128);
    Fluke_Section_1.mirror = true;
    setRotation(Fluke_Section_1, 0.3065147F, 0F, 0F);
    Fluke_Section_2 = new MowzieModelRenderer(this, 101, 70);
    Fluke_Section_2.addBox(-1F, -0.9F, 0F, 2, 4, 6);
    Fluke_Section_2.setRotationPoint(0F, 16.6F, 30.9F);
    Fluke_Section_2.setTextureSize(256, 128);
    Fluke_Section_2.mirror = true;
    setRotation(Fluke_Section_2, -0.2047271F, 0F, 0F);
    Fluke_Section_3 = new MowzieModelRenderer(this, 101, 102);
    Fluke_Section_3.addBox(-1F, -4F, 0F, 2, 8, 12);
    Fluke_Section_3.setRotationPoint(0F, 16.8F, 36F);
    Fluke_Section_3.setTextureSize(256, 128);
    Fluke_Section_3.mirror = true;
    setRotation(Fluke_Section_3, 0.0090932F, 0F, 0F);
    Fluke_Section_4 = new MowzieModelRenderer(this, 128, 70);
    Fluke_Section_4.addBox(-1F, -4F, 0F, 2, 4, 6);
    Fluke_Section_4.setRotationPoint(0F, 16.6F, 46.8F);
    Fluke_Section_4.setTextureSize(256, 128);
    Fluke_Section_4.mirror = true;
    setRotation(Fluke_Section_4, -0.2837905F, 0F, 0F);
    Fluke_Section_5 = new MowzieModelRenderer(this, 134, 105);
    Fluke_Section_5.addBox(-1F, -2F, 1F, 2, 5, 6);
    Fluke_Section_5.setRotationPoint(0F, 16.6F, 46.8F);
    Fluke_Section_5.setTextureSize(256, 128);
    Fluke_Section_5.mirror = true;
    setRotation(Fluke_Section_5, 0F, 0F, 0F);
    Fluke_Section_6 = new MowzieModelRenderer(this, 128, 86);
    Fluke_Section_6.addBox(-1F, -4.2F, -6F, 2, 4, 6);
    Fluke_Section_6.setRotationPoint(0F, 16.6F, 46.8F);
    Fluke_Section_6.setTextureSize(256, 128);
    Fluke_Section_6.mirror = true;
    setRotation(Fluke_Section_6, -2.965192F, 0F, 0F);
    Right_Front_Flipper = new MowzieModelRenderer(this, 160, 14);
    Right_Front_Flipper.addBox(-6F, 0F, -3F, 6, 1, 12);
    Right_Front_Flipper.setRotationPoint(-5F, 21F, -11F);
    Right_Front_Flipper.setTextureSize(256, 128);
    Right_Front_Flipper.mirror = true;
    setRotation(Right_Front_Flipper, -0.296706F, -1.161831F, 0F);
    Left_Front_Flipper = new MowzieModelRenderer(this, 122, 14);
    Left_Front_Flipper.addBox(0F, 0F, -3F, 6, 1, 12);
    Left_Front_Flipper.setRotationPoint(5F, 21F, -11F);
    Left_Front_Flipper.setTextureSize(256, 128);
    Left_Front_Flipper.mirror = true;
    setRotation(Left_Front_Flipper, -0.296706F, 1.161831F, 0F);
    Right_Back_Flipper = new MowzieModelRenderer(this, 160, 27);
    Right_Back_Flipper.addBox(-6F, 0F, -2F, 6, 1, 13);
    Right_Back_Flipper.setRotationPoint(-4F, 21F, 5F);
    Right_Back_Flipper.setTextureSize(256, 128);
    Right_Back_Flipper.mirror = true;
    setRotation(Right_Back_Flipper, -0.296706F, -1.161831F, 0F);
    Left_Back_Flipper = new MowzieModelRenderer(this, 121, 27);
    Left_Back_Flipper.addBox(0F, 0F, -2F, 6, 1, 13);
    Left_Back_Flipper.setRotationPoint(4F, 21F, 5F);
    Left_Back_Flipper.setTextureSize(256, 128);
    Left_Back_Flipper.mirror = true;
    setRotation(Left_Back_Flipper, -0.296706F, 1.161831F, 0F);
    Upper_Knob_1_Neck = new MowzieModelRenderer(this, 36, 4);
    Upper_Knob_1_Neck.addBox(-0.5F, -1.7F, 0.8F, 1, 2, 1);
    Upper_Knob_1_Neck.setRotationPoint(0F, 12.4F, -26.5F);
    Upper_Knob_1_Neck.setTextureSize(256, 128);
    Upper_Knob_1_Neck.mirror = true;
    setRotation(Upper_Knob_1_Neck, -0.4089647F, 0F, 0F);
    Upper_Knob_2_Neck = new MowzieModelRenderer(this, 36, 4);
    Upper_Knob_2_Neck.addBox(-0.5F, -2.7F, 2.5F, 1, 2, 1);
    Upper_Knob_2_Neck.setRotationPoint(0F, 12.4F, -26.5F);
    Upper_Knob_2_Neck.setTextureSize(256, 128);
    Upper_Knob_2_Neck.mirror = true;
    setRotation(Upper_Knob_2_Neck, -0.4089647F, 0F, 0F);
    Upper_Knob_3_Neck = new MowzieModelRenderer(this, 36, 4);
    Upper_Knob_3_Neck.addBox(-0.5F, -3.8F, 4.2F, 1, 2, 1);
    Upper_Knob_3_Neck.setRotationPoint(0F, 12.4F, -26.5F);
    Upper_Knob_3_Neck.setTextureSize(256, 128);
    Upper_Knob_3_Neck.mirror = true;
    setRotation(Upper_Knob_3_Neck, -0.4089647F, 0F, 0F);
    Upper_Knob_4_Neck = new MowzieModelRenderer(this, 36, 4);
    Upper_Knob_4_Neck.addBox(-0.5F, -5F, 6F, 1, 2, 1);
    Upper_Knob_4_Neck.setRotationPoint(0F, 12.4F, -26.5F);
    Upper_Knob_4_Neck.setTextureSize(256, 128);
    Upper_Knob_4_Neck.mirror = true;
    setRotation(Upper_Knob_4_Neck, -0.4089647F, 0F, 0F);
    Upper_Knob_5_Body_1 = new MowzieModelRenderer(this, 36, 4);
    Upper_Knob_5_Body_1.addBox(-0.5F, -6.6F, -1.9F, 1, 2, 1);
    Upper_Knob_5_Body_1.setRotationPoint(0F, 16.5F, -18F);
    Upper_Knob_5_Body_1.setTextureSize(256, 128);
    Upper_Knob_5_Body_1.mirror = true;
    setRotation(Upper_Knob_5_Body_1, -0.4089647F, 0F, 0F);
    Upper_Knob_6_Body_1 = new MowzieModelRenderer(this, 36, 4);
    Upper_Knob_6_Body_1.addBox(-0.5F, -7.3F, -0.1F, 1, 2, 1);
    Upper_Knob_6_Body_1.setRotationPoint(0F, 16.5F, -18F);
    Upper_Knob_6_Body_1.setTextureSize(256, 128);
    Upper_Knob_6_Body_1.mirror = true;
    setRotation(Upper_Knob_6_Body_1, -0.4089647F, 0F, 0F);
    Upper_Knob_7_Body_1 = new MowzieModelRenderer(this, 36, 4);
    Upper_Knob_7_Body_1.addBox(-0.5F, -8F, 1.7F, 1, 2, 1);
    Upper_Knob_7_Body_1.setRotationPoint(0F, 16.5F, -18F);
    Upper_Knob_7_Body_1.setTextureSize(256, 128);
    Upper_Knob_7_Body_1.mirror = true;
    setRotation(Upper_Knob_7_Body_1, -0.4089647F, 0F, 0F);
    Upper_Knob_8_Fluke_1_Top = new MowzieModelRenderer(this, 36, 4);
    Upper_Knob_8_Fluke_1_Top.addBox(-0.5F, -4.2F, 0F, 1, 2, 1);
    Upper_Knob_8_Fluke_1_Top.setRotationPoint(0F, 16.6F, 30.9F);
    Upper_Knob_8_Fluke_1_Top.setTextureSize(256, 128);
    Upper_Knob_8_Fluke_1_Top.mirror = true;
    setRotation(Upper_Knob_8_Fluke_1_Top, -0.4833219F, 0F, 0F);
    Upper_Knob_9_Fluke_1_Top = new MowzieModelRenderer(this, 36, 4);
    Upper_Knob_9_Fluke_1_Top.addBox(-0.5F, -6.2F, 2F, 1, 2, 1);
    Upper_Knob_9_Fluke_1_Top.setRotationPoint(0F, 16.6F, 30.9F);
    Upper_Knob_9_Fluke_1_Top.setTextureSize(256, 128);
    Upper_Knob_9_Fluke_1_Top.mirror = true;
    setRotation(Upper_Knob_9_Fluke_1_Top, -0.4833219F, 0F, 0F);
    Upper_Knob_10_Fluke_3_Top = new MowzieModelRenderer(this, 36, 4);
    Upper_Knob_10_Fluke_3_Top.addBox(-0.5F, -5.6F, -0.5F, 1, 2, 1);
    Upper_Knob_10_Fluke_3_Top.setRotationPoint(0F, 16.8F, 36F);
    Upper_Knob_10_Fluke_3_Top.setTextureSize(256, 128);
    Upper_Knob_10_Fluke_3_Top.mirror = true;
    setRotation(Upper_Knob_10_Fluke_3_Top, -0.5356818F, 0F, 0F);
    Upper_Knob_11_Fluke_3_Top = new MowzieModelRenderer(this, 36, 4);
    Upper_Knob_11_Fluke_3_Top.addBox(-0.5F, -7F, 2F, 1, 2, 1);
    Upper_Knob_11_Fluke_3_Top.setRotationPoint(0F, 16.8F, 36F);
    Upper_Knob_11_Fluke_3_Top.setTextureSize(256, 128);
    Upper_Knob_11_Fluke_3_Top.mirror = true;
    setRotation(Upper_Knob_11_Fluke_3_Top, -0.5356818F, 0F, 0F);
    Upper_Knob_12_Fluke_3_Top = new MowzieModelRenderer(this, 36, 4);
    Upper_Knob_12_Fluke_3_Top.addBox(-0.5F, -8.4F, 4.5F, 1, 2, 1);
    Upper_Knob_12_Fluke_3_Top.setRotationPoint(0F, 16.8F, 36F);
    Upper_Knob_12_Fluke_3_Top.setTextureSize(256, 128);
    Upper_Knob_12_Fluke_3_Top.mirror = true;
    setRotation(Upper_Knob_12_Fluke_3_Top, -0.5356818F, 0F, 0F);
    Upper_Knob_13_Fluke_3_Top = new MowzieModelRenderer(this, 36, 4);
    Upper_Knob_13_Fluke_3_Top.addBox(-0.5F, -9.8F, 7F, 1, 2, 1);
    Upper_Knob_13_Fluke_3_Top.setRotationPoint(0F, 16.8F, 36F);
    Upper_Knob_13_Fluke_3_Top.setTextureSize(256, 128);
    Upper_Knob_13_Fluke_3_Top.mirror = true;
    setRotation(Upper_Knob_13_Fluke_3_Top, -0.5356818F, 0F, 0F);
    Upper_Knob_19_Fluke_4_Top = new MowzieModelRenderer(this, 36, 4);
    Upper_Knob_19_Fluke_4_Top.addBox(-0.5F, -5F, 0.3F, 1, 2, 1);
    Upper_Knob_19_Fluke_4_Top.setRotationPoint(0F, 16.6F, 46.8F);
    Upper_Knob_19_Fluke_4_Top.setTextureSize(256, 128);
    Upper_Knob_19_Fluke_4_Top.mirror = true;
    setRotation(Upper_Knob_19_Fluke_4_Top, -0.5356818F, 0F, 0F);
    Upper_Knob_20_Fluke_4_Top = new MowzieModelRenderer(this, 36, 4);
    Upper_Knob_20_Fluke_4_Top.addBox(-0.5F, -5.4F, 2.8F, 1, 2, 1);
    Upper_Knob_20_Fluke_4_Top.setRotationPoint(0F, 16.6F, 46.8F);
    Upper_Knob_20_Fluke_4_Top.setTextureSize(256, 128);
    Upper_Knob_20_Fluke_4_Top.mirror = true;
    setRotation(Upper_Knob_20_Fluke_4_Top, -0.5356818F, 0F, 0F);
    Lower_Knob_1_Fluke_2_Bottom = new MowzieModelRenderer(this, 36, 4);
    Lower_Knob_1_Fluke_2_Bottom.addBox(-0.5F, 3F, -1F, 1, 2, 1);
    Lower_Knob_1_Fluke_2_Bottom.setRotationPoint(0F, 16.6F, 30.9F);
    Lower_Knob_1_Fluke_2_Bottom.setTextureSize(256, 128);
    Lower_Knob_1_Fluke_2_Bottom.mirror = true;
    setRotation(Lower_Knob_1_Fluke_2_Bottom, 0.5356765F, 0F, 0F);
    Lower_Knob_2_Fluke_2_Bottom = new MowzieModelRenderer(this, 36, 4);
    Lower_Knob_2_Fluke_2_Bottom.addBox(-0.5F, 4.7F, 1F, 1, 2, 1);
    Lower_Knob_2_Fluke_2_Bottom.setRotationPoint(0F, 16.6F, 30.9F);
    Lower_Knob_2_Fluke_2_Bottom.setTextureSize(256, 128);
    Lower_Knob_2_Fluke_2_Bottom.mirror = true;
    setRotation(Lower_Knob_2_Fluke_2_Bottom, 0.5356765F, 0F, 0F);
    Lower_Knob_3_Fluke_3_Bottom = new MowzieModelRenderer(this, 36, 4);
    Lower_Knob_3_Fluke_3_Bottom.addBox(-0.5F, 3.4F, -1.1F, 1, 2, 1);
    Lower_Knob_3_Fluke_3_Bottom.setRotationPoint(0F, 16.8F, 36F);
    Lower_Knob_3_Fluke_3_Bottom.setTextureSize(256, 128);
    Lower_Knob_3_Fluke_3_Bottom.mirror = true;
    setRotation(Lower_Knob_3_Fluke_3_Bottom, 0.5356765F, 0F, 0F);
    Lower_Knob_4_Fluke_3_Bottom = new MowzieModelRenderer(this, 36, 4);
    Lower_Knob_4_Fluke_3_Bottom.addBox(-0.5F, 4.6F, 1F, 1, 2, 1);
    Lower_Knob_4_Fluke_3_Bottom.setRotationPoint(0F, 16.8F, 36F);
    Lower_Knob_4_Fluke_3_Bottom.setTextureSize(256, 128);
    Lower_Knob_4_Fluke_3_Bottom.mirror = true;
    setRotation(Lower_Knob_4_Fluke_3_Bottom, 0.5356765F, 0F, 0F);
    Lower_Knob_5_Fluke_3_Bottom = new MowzieModelRenderer(this, 36, 4);
    Lower_Knob_5_Fluke_3_Bottom.addBox(-0.5333334F, 5.8F, 3.2F, 1, 2, 1);
    Lower_Knob_5_Fluke_3_Bottom.setRotationPoint(0F, 16.8F, 36F);
    Lower_Knob_5_Fluke_3_Bottom.setTextureSize(256, 128);
    Lower_Knob_5_Fluke_3_Bottom.mirror = true;
    setRotation(Lower_Knob_5_Fluke_3_Bottom, 0.5356765F, 0F, 0F);
    Lower_Knob_6_Fluke_3_Bottom = new MowzieModelRenderer(this, 36, 4);
    Lower_Knob_6_Fluke_3_Bottom.addBox(-0.5F, 6.9F, 5.3F, 1, 2, 1);
    Lower_Knob_6_Fluke_3_Bottom.setRotationPoint(0F, 16.8F, 36F);
    Lower_Knob_6_Fluke_3_Bottom.setTextureSize(256, 128);
    Lower_Knob_6_Fluke_3_Bottom.mirror = true;
    setRotation(Lower_Knob_6_Fluke_3_Bottom, 0.5356765F, 0F, 0F);
    Lower_Knob_7_Fluke_3_Bottom = new MowzieModelRenderer(this, 36, 4);
    Lower_Knob_7_Fluke_3_Bottom.addBox(-0.5F, 8F, 7.4F, 1, 2, 1);
    Lower_Knob_7_Fluke_3_Bottom.setRotationPoint(0F, 16.8F, 36F);
    Lower_Knob_7_Fluke_3_Bottom.setTextureSize(256, 128);
    Lower_Knob_7_Fluke_3_Bottom.mirror = true;
    setRotation(Lower_Knob_7_Fluke_3_Bottom, 0.5356765F, 0F, 0F);
    Lower_Knob_8_Fluke_6_Bottom = new MowzieModelRenderer(this, 36, 4);
    Lower_Knob_8_Fluke_6_Bottom.addBox(-0.5F, 3.5F, 0F, 1, 2, 1);
    Lower_Knob_8_Fluke_6_Bottom.setRotationPoint(0F, 16.6F, 46.8F);
    Lower_Knob_8_Fluke_6_Bottom.setTextureSize(256, 128);
    Lower_Knob_8_Fluke_6_Bottom.mirror = true;
    setRotation(Lower_Knob_8_Fluke_6_Bottom, 0.5356765F, 0F, 0F);
    Lower_Knob_9_Fluke_6_Bottom = new MowzieModelRenderer(this, 36, 4);
    Lower_Knob_9_Fluke_6_Bottom.addBox(-0.5F, 4F, 2F, 1, 2, 1);
    Lower_Knob_9_Fluke_6_Bottom.setRotationPoint(0F, 16.6F, 46.8F);
    Lower_Knob_9_Fluke_6_Bottom.setTextureSize(256, 128);
    Lower_Knob_9_Fluke_6_Bottom.mirror = true;
    setRotation(Lower_Knob_9_Fluke_6_Bottom, 0.5356765F, 0F, 0F);
    Teeth = new MowzieModelRenderer(this, 0, 83);
    Teeth.addBox(-2.5F, 0F, -10F, 5, 1, 10);
    Teeth.setRotationPoint(0F, 18.5F, -32F);
    Teeth.setTextureSize(256, 128);
    Teeth.mirror = true;
    setRotation(Teeth, 0F, 0F, 0F);
    
    addChildTo(Upper_Knob_19_Fluke_4_Top, Fluke_Section_4);
    addChildTo(Upper_Knob_20_Fluke_4_Top, Fluke_Section_4);

    addChildTo(Fluke_Section_4, Fluke_Section_6);
    addChildTo(Fluke_Section_5, Fluke_Section_6);
    
    addChildTo(Lower_Knob_8_Fluke_6_Bottom, Fluke_Section_6);
    addChildTo(Lower_Knob_9_Fluke_6_Bottom, Fluke_Section_6);
    
    addChildTo(Fluke_Section_6, Fluke_Section_3);
    
    addChildTo(Upper_Knob_10_Fluke_3_Top, Fluke_Section_3);
    addChildTo(Upper_Knob_11_Fluke_3_Top, Fluke_Section_3);
    addChildTo(Upper_Knob_12_Fluke_3_Top, Fluke_Section_3);
    addChildTo(Upper_Knob_13_Fluke_3_Top, Fluke_Section_3);    
    addChildTo(Lower_Knob_3_Fluke_3_Bottom, Fluke_Section_3);
    addChildTo(Lower_Knob_4_Fluke_3_Bottom, Fluke_Section_3);
    addChildTo(Lower_Knob_5_Fluke_3_Bottom, Fluke_Section_3);
    addChildTo(Lower_Knob_6_Fluke_3_Bottom, Fluke_Section_3);
    addChildTo(Lower_Knob_7_Fluke_3_Bottom, Fluke_Section_3);

    addChildTo(Fluke_Section_3, Fluke_Section_1);
    
    addChildTo(Lower_Knob_1_Fluke_2_Bottom, Fluke_Section_2);
    addChildTo(Lower_Knob_2_Fluke_2_Bottom, Fluke_Section_2);
    
    addChildTo(Fluke_Section_2, Fluke_Section_1);
    
    addChildTo(Upper_Knob_8_Fluke_1_Top, Fluke_Section_1);
    addChildTo(Upper_Knob_9_Fluke_1_Top, Fluke_Section_1);
    
    addChildTo(Fluke_Section_1, Tail_Section_4);
    addChildTo(Tail_Section_4, Tail_Section_3);
    addChildTo(Tail_Section_3, Tail_Section_2);
    addChildTo(Tail_Section_2, Tail_Section_1);
    addChildTo(Tail_Section_1, Body_Section_3);
    
    addChildTo(Right_Back_Flipper, Body_Section_3);
    addChildTo(Left_Back_Flipper, Body_Section_3);
    
    addChildTo(Body_Section_3, Body_Section_2);
    addChildTo(Body_Section_2, Body_Section_1);
    
    addChildTo(Right_Front_Flipper, Body_Section_1);
    addChildTo(Left_Front_Flipper, Body_Section_1);
    
    addChildTo(Body_Section_1, Neck_);
    
    addChildTo(Upper_Knob_1_Neck, Neck_);
    addChildTo(Upper_Knob_2_Neck, Neck_);
    addChildTo(Upper_Knob_3_Neck, Neck_);
    addChildTo(Upper_Knob_4_Neck, Neck_);

    addChildTo(Neck_, Head);
    addChildTo(Lower_Jaw, Head);
    addChildTo(Teeth, Upper_Jaw);
    addChildTo(Upper_Jaw, Head);
    
    addChildTo(Upper_Knob_5_Body_1, Body_Section_1);
    addChildTo(Upper_Knob_6_Body_1, Body_Section_1);
    addChildTo(Upper_Knob_7_Body_1, Body_Section_1);
    
    //Corrections
    Fluke_Section_4.setRotationPoint(0, 0, 0);
    Fluke_Section_5.setRotationPoint(0, 0, 0);
    Fluke_Section_2.setRotationPoint(0, 0, 0);
    Upper_Knob_8_Fluke_1_Top.setRotationPoint(0, 0, 0);
    Upper_Knob_9_Fluke_1_Top.setRotationPoint(0, 0, 0);
    Upper_Knob_10_Fluke_3_Top.setRotationPoint(0, 0, 0);
    Upper_Knob_11_Fluke_3_Top.setRotationPoint(0, 0, 0);
    Upper_Knob_12_Fluke_3_Top.setRotationPoint(0, 0, 0);
    Upper_Knob_13_Fluke_3_Top.setRotationPoint(0, 0, 0);
    Upper_Knob_19_Fluke_4_Top.setRotationPoint(0, 0, 0);
    Upper_Knob_20_Fluke_4_Top.setRotationPoint(0, 0, 0);
    Lower_Knob_1_Fluke_2_Bottom.setRotationPoint(0, 0, 0);
    Lower_Knob_2_Fluke_2_Bottom.setRotationPoint(0, 0, 0);
    Lower_Knob_3_Fluke_3_Bottom.setRotationPoint(0, 0, 0);
    Lower_Knob_4_Fluke_3_Bottom.setRotationPoint(0, 0, 0);
    Lower_Knob_5_Fluke_3_Bottom.setRotationPoint(0, 0, 0);
    Lower_Knob_6_Fluke_3_Bottom.setRotationPoint(0, 0, 0);
    Lower_Knob_7_Fluke_3_Bottom.setRotationPoint(0, 0, 0);
    Lower_Knob_8_Fluke_6_Bottom.setRotationPoint(0, 0, 0);
    Lower_Knob_9_Fluke_6_Bottom.setRotationPoint(0, 0, 0);
    Upper_Knob_1_Neck.setRotationPoint(0, 0, 0);
    Upper_Knob_2_Neck.setRotationPoint(0, 0, 0);
    Upper_Knob_3_Neck.setRotationPoint(0, 0, 0);
    Upper_Knob_4_Neck.setRotationPoint(0, 0, 0);
    Upper_Knob_5_Body_1.setRotationPoint(0, 0, 0);
    Upper_Knob_6_Body_1.setRotationPoint(0, 0, 0);
    Upper_Knob_7_Body_1.setRotationPoint(0, 0, 0);
    
    Fluke_Section_6.rotationPointZ += 21.5;
    Fluke_Section_6.rotationPointY -= 0.25;
    Body_Section_3.rotationPointZ += 17;
    Body_Section_3.rotationPointY -= 11;
    Body_Section_2.rotationPointZ += 1;
    Neck_.rotationPointY -= 9.4;
    Neck_.rotationPointZ -= 3;
    Upper_Jaw.rotationPointY -= 5;
    Upper_Jaw.rotationPointZ -= 14;
    
    Head.rotationPointZ += 35;
    
    Head.setInitValuesToCurrentPose();
    Upper_Jaw.setInitValuesToCurrentPose();
    Lower_Jaw.setInitValuesToCurrentPose();
    Neck_.setInitValuesToCurrentPose();
    Body_Section_1.setInitValuesToCurrentPose();
    Body_Section_2.setInitValuesToCurrentPose();
    Body_Section_3.setInitValuesToCurrentPose();
    Tail_Section_1.setInitValuesToCurrentPose();
    Tail_Section_2.setInitValuesToCurrentPose();
    Tail_Section_3.setInitValuesToCurrentPose();
    Tail_Section_4.setInitValuesToCurrentPose();
    Fluke_Section_1.setInitValuesToCurrentPose();
    Fluke_Section_2.setInitValuesToCurrentPose();
    Fluke_Section_3.setInitValuesToCurrentPose();
    Fluke_Section_4.setInitValuesToCurrentPose();
    Fluke_Section_5.setInitValuesToCurrentPose();
    Fluke_Section_6.setInitValuesToCurrentPose();
    Right_Front_Flipper.setInitValuesToCurrentPose();
    Left_Front_Flipper.setInitValuesToCurrentPose();
    Right_Back_Flipper.setInitValuesToCurrentPose();
    Left_Back_Flipper.setInitValuesToCurrentPose();
    Upper_Knob_1_Neck.setInitValuesToCurrentPose();
    Upper_Knob_2_Neck.setInitValuesToCurrentPose();
    Upper_Knob_3_Neck.setInitValuesToCurrentPose();
    Upper_Knob_4_Neck.setInitValuesToCurrentPose();
    Upper_Knob_5_Body_1.setInitValuesToCurrentPose();
    Upper_Knob_6_Body_1.setInitValuesToCurrentPose();
    Upper_Knob_7_Body_1.setInitValuesToCurrentPose();
    Upper_Knob_8_Fluke_1_Top.setInitValuesToCurrentPose();
    Upper_Knob_9_Fluke_1_Top.setInitValuesToCurrentPose();
    Upper_Knob_10_Fluke_3_Top.setInitValuesToCurrentPose();
    Upper_Knob_11_Fluke_3_Top.setInitValuesToCurrentPose();
    Upper_Knob_12_Fluke_3_Top.setInitValuesToCurrentPose();
    Upper_Knob_13_Fluke_3_Top.setInitValuesToCurrentPose();
    Upper_Knob_19_Fluke_4_Top.setInitValuesToCurrentPose();
    Upper_Knob_20_Fluke_4_Top.setInitValuesToCurrentPose();
    Lower_Knob_1_Fluke_2_Bottom.setInitValuesToCurrentPose();
    Lower_Knob_2_Fluke_2_Bottom.setInitValuesToCurrentPose();
    Lower_Knob_3_Fluke_3_Bottom.setInitValuesToCurrentPose();
    Lower_Knob_4_Fluke_3_Bottom.setInitValuesToCurrentPose();
    Lower_Knob_5_Fluke_3_Bottom.setInitValuesToCurrentPose();
    Lower_Knob_6_Fluke_3_Bottom.setInitValuesToCurrentPose();
    Lower_Knob_7_Fluke_3_Bottom.setInitValuesToCurrentPose();
    Lower_Knob_8_Fluke_6_Bottom.setInitValuesToCurrentPose();
    Lower_Knob_9_Fluke_6_Bottom.setInitValuesToCurrentPose();
    Teeth.setInitValuesToCurrentPose();
  }
  
  private void resetPose() {
	  Head.setCurrentPoseToInitValues();
	    Upper_Jaw.setCurrentPoseToInitValues();
	    Lower_Jaw.setCurrentPoseToInitValues();
	    Neck_.setCurrentPoseToInitValues();
	    Body_Section_1.setCurrentPoseToInitValues();
	    Body_Section_2.setCurrentPoseToInitValues();
	    Body_Section_3.setCurrentPoseToInitValues();
	    Tail_Section_1.setCurrentPoseToInitValues();
	    Tail_Section_2.setCurrentPoseToInitValues();
	    Tail_Section_3.setCurrentPoseToInitValues();
	    Tail_Section_4.setCurrentPoseToInitValues();
	    Fluke_Section_1.setCurrentPoseToInitValues();
	    Fluke_Section_2.setCurrentPoseToInitValues();
	    Fluke_Section_3.setCurrentPoseToInitValues();
	    Fluke_Section_4.setCurrentPoseToInitValues();
	    Fluke_Section_5.setCurrentPoseToInitValues();
	    Fluke_Section_6.setCurrentPoseToInitValues();
	    Right_Front_Flipper.setCurrentPoseToInitValues();
	    Left_Front_Flipper.setCurrentPoseToInitValues();
	    Right_Back_Flipper.setCurrentPoseToInitValues();
	    Left_Back_Flipper.setCurrentPoseToInitValues();
	    Upper_Knob_1_Neck.setCurrentPoseToInitValues();
	    Upper_Knob_2_Neck.setCurrentPoseToInitValues();
	    Upper_Knob_3_Neck.setCurrentPoseToInitValues();
	    Upper_Knob_4_Neck.setCurrentPoseToInitValues();
	    Upper_Knob_5_Body_1.setCurrentPoseToInitValues();
	    Upper_Knob_6_Body_1.setCurrentPoseToInitValues();
	    Upper_Knob_7_Body_1.setCurrentPoseToInitValues();
	    Upper_Knob_8_Fluke_1_Top.setCurrentPoseToInitValues();
	    Upper_Knob_9_Fluke_1_Top.setCurrentPoseToInitValues();
	    Upper_Knob_10_Fluke_3_Top.setCurrentPoseToInitValues();
	    Upper_Knob_11_Fluke_3_Top.setCurrentPoseToInitValues();
	    Upper_Knob_12_Fluke_3_Top.setCurrentPoseToInitValues();
	    Upper_Knob_13_Fluke_3_Top.setCurrentPoseToInitValues();
	    Upper_Knob_19_Fluke_4_Top.setCurrentPoseToInitValues();
	    Upper_Knob_20_Fluke_4_Top.setCurrentPoseToInitValues();
	    Lower_Knob_1_Fluke_2_Bottom.setCurrentPoseToInitValues();
	    Lower_Knob_2_Fluke_2_Bottom.setCurrentPoseToInitValues();
	    Lower_Knob_3_Fluke_3_Bottom.setCurrentPoseToInitValues();
	    Lower_Knob_4_Fluke_3_Bottom.setCurrentPoseToInitValues();
	    Lower_Knob_5_Fluke_3_Bottom.setCurrentPoseToInitValues();
	    Lower_Knob_6_Fluke_3_Bottom.setCurrentPoseToInitValues();
	    Lower_Knob_7_Fluke_3_Bottom.setCurrentPoseToInitValues();
	    Lower_Knob_8_Fluke_6_Bottom.setCurrentPoseToInitValues();
	    Lower_Knob_9_Fluke_6_Bottom.setCurrentPoseToInitValues();
	    Teeth.setCurrentPoseToInitValues();
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {	  
	  super.render(entity, f, f1, f2, f3, f4, f5);
      setRotationAngles(entity, f, f1, f2, f3, f4, f5);
      	Head.render(f5);
//	    Upper_Jaw.render(f5);
//	    Lower_Jaw.render(f5);
//	    Neck_.render(f5);
//	    Body_Section_1.render(f5);
/*	    Body_Section_2.render(f5);
	    Body_Section_3.render(f5);
	    Tail_Section_1.render(f5);
	    Tail_Section_2.render(f5);
	    Tail_Section_3.render(f5);
	    Tail_Section_4.render(f5);
	    Fluke_Section_1.render(f5);
	    Fluke_Section_2.render(f5);
	    Fluke_Section_3.render(f5);
	    Fluke_Section_4.render(f5);
	    Fluke_Section_5.render(f5);
	    Fluke_Section_6.render(f5);*/
//	    Right_Front_Flipper.render(f5);
//	    Left_Front_Flipper.render(f5);
//	    Right_Back_Flipper.render(f5);
//	    Left_Back_Flipper.render(f5);
/*	    Upper_Knob_1_Neck.render(f5);
	    Upper_Knob_2_Neck.render(f5);
	    Upper_Knob_3_Neck.render(f5);
	    Upper_Knob_4_Neck.render(f5);
	    Upper_Knob_5_Body_1.render(f5);
	    Upper_Knob_6_Body_1.render(f5);
	    Upper_Knob_7_Body_1.render(f5);*/
/*	    Upper_Knob_8_Fluke_1_Top.render(f5);
	    Upper_Knob_9_Fluke_1_Top.render(f5);
	    Upper_Knob_10_Fluke_3_Top.render(f5);
	    Upper_Knob_11_Fluke_3_Top.render(f5);
	    Upper_Knob_12_Fluke_3_Top.render(f5);
	    Upper_Knob_13_Fluke_3_Top.render(f5);
	    Upper_Knob_19_Fluke_4_Top.render(f5);
	    Upper_Knob_20_Fluke_4_Top.render(f5);
	    Lower_Knob_1_Fluke_2_Bottom.render(f5);
	    Lower_Knob_2_Fluke_2_Bottom.render(f5);
	    Lower_Knob_3_Fluke_3_Bottom.render(f5);
	    Lower_Knob_4_Fluke_3_Bottom.render(f5);
	    Lower_Knob_5_Fluke_3_Bottom.render(f5);
	    Lower_Knob_6_Fluke_3_Bottom.render(f5);
	    Lower_Knob_7_Fluke_3_Bottom.render(f5);
	    Lower_Knob_8_Fluke_6_Bottom.render(f5);
	    Lower_Knob_9_Fluke_6_Bottom.render(f5);*/
//	    Teeth.render(f5);
  }
  
  private void setRotation(MowzieModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    resetPose();
    EntityTylosaurus tylo = (EntityTylosaurus) entity; 
/*    f = tylo.frame;
    f1 = 1F;*/
    float scaleFactor = 0.3F;
    float mouthOpenDivider = Math.abs(tylo.distanceFromTarget);
//	System.out.println(tylo.distanceFromTarget);
    if (mouthOpenDivider < 1) mouthOpenDivider = 1;
    Lower_Jaw.rotateAngleX += 1/mouthOpenDivider;
    MowzieModelRenderer[] bodyParts = {this.Head, this.Neck_, this.Body_Section_1, this.Body_Section_2, this.Body_Section_3, this.Tail_Section_1, this.Tail_Section_2, this.Tail_Section_3, this.Tail_Section_4, this.Fluke_Section_1, this.Fluke_Section_3, this.Fluke_Section_6};
    tailSwing(bodyParts, 1F * scaleFactor, 0.1F * f1, -3, f);
    Head.rotationPointX -= 3*f1*Math.sin(f*scaleFactor);    walk(Right_Front_Flipper, 1 * scaleFactor, 0.3F, false, 0F, 0F, f, f1);
    walk(Left_Front_Flipper, 1 * scaleFactor, 0.3F, false, 0F, 0F, f, f1);
    walk(Right_Front_Flipper, 1 * scaleFactor, 0.3F, false, 0F, 0F, f, f1);
    walk(Left_Back_Flipper, 1 * scaleFactor, 0.3F, false, -1F, 0F, f, f1);
    walk(Right_Back_Flipper, 1 * scaleFactor, 0.3F, false, -1F, 0F, f, f1);
/*    for (int i = 0; i < bodyParts.length; i++) {
    	bodyParts[i].rotateAngleY += tylo.deltaAngle*(Math.PI/180);
    }*/
  }
  
}