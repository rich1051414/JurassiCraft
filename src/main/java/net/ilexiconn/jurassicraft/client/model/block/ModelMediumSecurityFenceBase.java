package net.ilexiconn.jurassicraft.client.model.block;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelMediumSecurityFenceBase extends ModelBase
{
    ModelRenderer Bottom;
    ModelRenderer Bottom1;
    ModelRenderer Bottom2;

    public ModelMediumSecurityFenceBase()
    {
        Bottom = new ModelRenderer( this, 0, 1 );
        Bottom.setTextureSize( 64, 32 );
        Bottom.addBox( -8F, -3.5F, -4.5F, 16, 7, 9);
        Bottom.setRotationPoint( 0F, 21F, 0F );
        Bottom1 = new ModelRenderer( this, 0, 17 );
        Bottom1.setTextureSize( 64, 32 );
        Bottom1.addBox( -8F, -1F, -1F, 16, 2, 2);
        Bottom1.setRotationPoint( 0F, 21F, -5F );
        Bottom2 = new ModelRenderer( this, 0, 17 );
        Bottom2.setTextureSize( 64, 32 );
        Bottom2.addBox( -8F, -1F, -1F, 16, 2, 2);
        Bottom2.setRotationPoint( 0F, 21F, 5F );
    }

   public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
   {
        Bottom.rotateAngleX = 0F;
        Bottom.rotateAngleY = 0F;
        Bottom.rotateAngleZ = 0F;
        Bottom.renderWithRotation(par7);

        Bottom1.rotateAngleX = 0F;
        Bottom1.rotateAngleY = 0F;
        Bottom1.rotateAngleZ = 0F;
        Bottom1.renderWithRotation(par7);

        Bottom2.rotateAngleX = 0F;
        Bottom2.rotateAngleY = 0F;
        Bottom2.rotateAngleZ = 0F;
        Bottom2.renderWithRotation(par7);
    }
}