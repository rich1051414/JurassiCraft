package to.uk.ilexiconn.jurassicraft.data.entity.render;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import to.uk.ilexiconn.jurassicraft.JurassiCraft;
import to.uk.ilexiconn.jurassicraft.data.entity.Dinosaur;
import to.uk.ilexiconn.jurassicraft.data.entity.RenderDinosaur;
import to.uk.ilexiconn.jurassicraft.data.entity.entity.EntityTyrannosaurus;
import to.uk.ilexiconn.jurassicraft.data.entity.model.ModelTyrannosaurus;

@SideOnly(Side.CLIENT)
public class RenderTyrannosaurus extends RenderDinosaur
{
    public RenderTyrannosaurus(Dinosaur dino)
    {
        super(new ModelTyrannosaurus(), dino, 0.8F);
    }

    public ResourceLocation getEntityTexture(Entity var1)
    {
        EntityTyrannosaurus dino = (EntityTyrannosaurus) var1;
        switch (dino.getCreatureTexture())
        {
            case 1:
            default:
                return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/tyrannosaurus1.png");
            case 0:
                return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/tyrannosaurus2.png");
        }
    }
}
