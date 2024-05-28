package endurteam.overwhelmed.datagen;

import endurteam.overwhelmed.block.OverwhelmedBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class OverwhelmedItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public static final TagKey<Item> WILLOW_LOGS = TagKey.of(RegistryKeys.ITEM, new Identifier("overwhelmed:willow_logs"));

    public OverwhelmedItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ItemTags.SMALL_FLOWERS)
                .add(OverwhelmedBlocks.FLOFF.asItem())
                .add(OverwhelmedBlocks.PAINE.asItem())
                .add(OverwhelmedBlocks.PINK_LAVATERA.asItem())
                .add(OverwhelmedBlocks.WHITE_LAVATERA.asItem())
                .add(OverwhelmedBlocks.SQUIRL.asItem())
                .add(OverwhelmedBlocks.RINGOT.asItem())
                .add(OverwhelmedBlocks.SNOWDROP.asItem())
                .add(OverwhelmedBlocks.BELL_SUNFLOWER.asItem());
        getOrCreateTagBuilder(ItemTags.TALL_FLOWERS)
                .add(OverwhelmedBlocks.WIDOW.asItem())
                .add(OverwhelmedBlocks.WHITE_ALLIUM.asItem());
        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(OverwhelmedBlocks.WILLOW_PLANKS.asItem());
        getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN)
                .add(OverwhelmedBlocks.WILLOW_LOG.asItem())
                .add(OverwhelmedBlocks.WILLOW_WOOD.asItem())
                .add(OverwhelmedBlocks.STRIPPED_WILLOW_LOG.asItem())
                .add(OverwhelmedBlocks.STRIPPED_WILLOW_WOOD.asItem());
        getOrCreateTagBuilder(WILLOW_LOGS)
                .add(OverwhelmedBlocks.WILLOW_LOG.asItem())
                .add(OverwhelmedBlocks.WILLOW_WOOD.asItem())
                .add(OverwhelmedBlocks.STRIPPED_WILLOW_LOG.asItem())
                .add(OverwhelmedBlocks.STRIPPED_WILLOW_WOOD.asItem());
    }
}