package endurteam.overwhelmed;

import endurteam.overwhelmed.block.OverwhelmedBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class OverwhelmedClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(OverwhelmedBlocks.WILLOW_LEAVES, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(OverwhelmedBlocks.FLOFF, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(OverwhelmedBlocks.PAINE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(OverwhelmedBlocks.PINK_LAVATERA, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(OverwhelmedBlocks.WHITE_LAVATERA, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(OverwhelmedBlocks.SQUIRL, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(OverwhelmedBlocks.RINGOT, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(OverwhelmedBlocks.SNOWDROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(OverwhelmedBlocks.BELL_SUNFLOWER, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(OverwhelmedBlocks.POTTED_FLOFF, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(OverwhelmedBlocks.POTTED_PAINE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(OverwhelmedBlocks.POTTED_PINK_LAVATERA, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(OverwhelmedBlocks.POTTED_WHITE_LAVATERA, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(OverwhelmedBlocks.POTTED_SQUIRL, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(OverwhelmedBlocks.POTTED_RINGOT, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(OverwhelmedBlocks.POTTED_SNOWDROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(OverwhelmedBlocks.POTTED_BELL_SUNFLOWER, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(OverwhelmedBlocks.GOO_BLOCK, RenderLayer.getTranslucent());
    }
}