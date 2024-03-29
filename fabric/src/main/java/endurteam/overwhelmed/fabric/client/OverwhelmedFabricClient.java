/**
 *  Overwhelmed, a Minecraft overhauling and adding new features to the Overworld's surface!<br>
 *  Copyright (C) 2023-2024 Endurteam<br>
 *  <br>
 *  This program is free software: you can redistribute it and/or modify<br>
 *  it under the terms of the GNU General Public License as published by<br>
 *  the Free Software Foundation, either version 3 of the License, or<br>
 *  any later version.<br>
 *  <br>
 *  This program is distributed in the hope that it will be useful,<br>
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of<br>
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the<br>
 *  GNU General Public License for more details.<br>
 *  <br>
 *  You should have received a copy of the GNU General Public License with<br>
 *  the Minecraft Linking Exception<br>
 *  along with this program.  If not, see <https://www.gnu.org/licenses/> and<br>
 *  <https://gist.github.com/triphora/588f353802a3b0ea649e4fc85f75e583/>
 */

package endurteam.overwhelmed.fabric.client;

import endurteam.overwhelmed.client.color.items.ButterflySpawnEggItemColor;
import endurteam.overwhelmed.client.color.items.SnailSpawnEggItemColor;
import endurteam.overwhelmed.client.particle.FizzyBubbleParticle;
import endurteam.overwhelmed.client.particle.FizzyBubblePopParticle;
import endurteam.overwhelmed.client.particle.LiverwortSporeParticle;
import endurteam.overwhelmed.client.renderer.entity.*;
import endurteam.overwhelmed.core.particles.OverwhelmedParticleTypes;
import endurteam.overwhelmed.fabric.client.model.geom.OverwhelmedFabricModelLayers;
import endurteam.overwhelmed.world.entity.OverwhelmedEntityTypes;
import endurteam.overwhelmed.world.item.OverwhelmedItems;
import endurteam.overwhelmed.world.level.block.OverwhelmedBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.renderer.RenderType;

import static endurteam.overwhelmed.client.OverwhelmedClient.*;

@Environment(EnvType.CLIENT)
public class OverwhelmedFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(OverwhelmedEntityTypes.SLEEPY_BUTTERFLY, ButterflyRenderer::new);
        EntityRendererRegistry.register(OverwhelmedEntityTypes.CABBAGE_BUTTERFLY, ButterflyRenderer::new);
        EntityRendererRegistry.register(OverwhelmedEntityTypes.MORPHO_BUTTERFLY, ButterflyRenderer::new);
        EntityRendererRegistry.register(OverwhelmedEntityTypes.CHERRY_BUTTERFLY, ButterflyRenderer::new);
        EntityRendererRegistry.register(OverwhelmedEntityTypes.MONARCH_BUTTERFLY, ButterflyRenderer::new);
        EntityRendererRegistry.register(OverwhelmedEntityTypes.LIVERWORT_BUTTERFLY, ButterflyRenderer::new);
        EntityRendererRegistry.register(OverwhelmedEntityTypes.PEBBLE, PebbleRenderer::new);
        EntityRendererRegistry.register(OverwhelmedEntityTypes.PAPER_BULLET, PaperBulletRenderer::new);
        EntityRendererRegistry.register(OverwhelmedEntityTypes.FLAT_SNAIL, FlatSnailRenderer::new);
        EntityRendererRegistry.register(OverwhelmedEntityTypes.GARDEN_SNAIL, GardenSnailRenderer::new);
        EntityRendererRegistry.register(OverwhelmedEntityTypes.GARY_SNAIL, GarySnailRenderer::new);
        EntityRendererRegistry.register(OverwhelmedEntityTypes.GLASS_SNAIL, GlassSnailRenderer::new);
        EntityRendererRegistry.register(OverwhelmedEntityTypes.LIMESTONE_SNAIL, LimestoneSnailRenderer::new);
        EntityRendererRegistry.register(OverwhelmedEntityTypes.LIVERWORT_SNAIL, LiverwortSnailRenderer::new);
        EntityRendererRegistry.register(OverwhelmedEntityTypes.ROMAN_SNAIL, RomanSnailRenderer::new);
        EntityRendererRegistry.register(OverwhelmedEntityTypes.MOTH, MothRenderer::new);
        EntityRendererRegistry.register(OverwhelmedEntityTypes.HORNET, HornetRenderer::new);
        OverwhelmedFabricModelLayers.registerModelLayers();
        ColorProviderRegistry.ITEM.register(snailSpawnEggItemColor = new SnailSpawnEggItemColor(),
                OverwhelmedItems.SNAIL_SPAWN_EGG);
        ColorProviderRegistry.ITEM.register(butterflySpawnEggItemColor = new ButterflySpawnEggItemColor(),
                OverwhelmedItems.BUTTERFLY_SPAWN_EGG);
        BlockRenderLayerMap.INSTANCE.putBlock(OverwhelmedBlocks.WOODED_SEREIBA_TRAPDOOR, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(OverwhelmedBlocks.FLOFF, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(OverwhelmedBlocks.PAINE, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(OverwhelmedBlocks.PINK_LAVATERA, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(OverwhelmedBlocks.WHITE_LAVATERA, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(OverwhelmedBlocks.SQUIRL, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(OverwhelmedBlocks.RINGOT, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(OverwhelmedBlocks.SNOWDROP, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(OverwhelmedBlocks.BELL_SUNFLOWER, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(OverwhelmedBlocks.POTTED_FLOFF, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(OverwhelmedBlocks.POTTED_PAINE, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(OverwhelmedBlocks.POTTED_PINK_LAVATERA, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(OverwhelmedBlocks.POTTED_WHITE_LAVATERA, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(OverwhelmedBlocks.POTTED_SQUIRL, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(OverwhelmedBlocks.POTTED_RINGOT, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(OverwhelmedBlocks.POTTED_SNOWDROP, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(OverwhelmedBlocks.POTTED_BELL_SUNFLOWER, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(OverwhelmedBlocks.WIDOW, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(OverwhelmedBlocks.WHITE_ALLIUM, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(OverwhelmedBlocks.MINT, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(OverwhelmedBlocks.GOO_BLOCK, RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(OverwhelmedBlocks.PEBBLE, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(OverwhelmedBlocks.ICE_CUBE, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(OverwhelmedBlocks.GOLD_BEAD, RenderType.cutout());
        ParticleFactoryRegistry.getInstance().register(
                OverwhelmedParticleTypes.LIVERWORT_SPORE,
                LiverwortSporeParticle.Provider::new);
        ParticleFactoryRegistry.getInstance().register(
                OverwhelmedParticleTypes.FIZZY_BUBBLE,
                FizzyBubbleParticle.Provider::new);
        ParticleFactoryRegistry.getInstance().register(
                OverwhelmedParticleTypes.FIZZY_BUBBLE_POP,
                FizzyBubblePopParticle.Provider::new);
    }
}
