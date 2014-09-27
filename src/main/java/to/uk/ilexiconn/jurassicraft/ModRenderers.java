package to.uk.ilexiconn.jurassicraft;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import to.uk.ilexiconn.jurassicraft.entity.RenderDinoEgg;
import to.uk.ilexiconn.jurassicraft.entity.entity.EntityDinoEgg;
import to.uk.ilexiconn.jurassicraft.tile.render.RenderCultivateItem;
import to.uk.ilexiconn.jurassicraft.tile.render.RenderDNACombinatorItem;
import to.uk.ilexiconn.jurassicraft.tile.render.RenderDNAExtractorItem;
import to.uk.ilexiconn.llib.content.ContentHandler;
import to.uk.ilexiconn.llib.content.ContentType;

@SideOnly(Side.CLIENT)
@ContentHandler(modid = "jurassicraft", type = ContentType.UNDEFINED, priority = EventPriority.LOW)
public class ModRenderers
{
    public void init()
    {
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.cultivateBottomOff), new RenderCultivateItem());
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.dnaExtractor), new RenderDNAExtractorItem());
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.dnaCombinator), new RenderDNACombinatorItem());

        RenderingRegistry.registerEntityRenderingHandler(EntityDinoEgg.class, new RenderDinoEgg());
    }
}