package endurteam.overwhelmed.datagen;

import endurteam.overwhelmed.block.OverwhelmedBlocks;
import endurteam.overwhelmed.item.OverwhelmedItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

@SuppressWarnings("unchecked")
public class OverwhelmedItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public static final TagKey<Item> HORNET_FOOD = TagKey.of(RegistryKeys.ITEM, new Identifier("overwhelmed:hornet_food"));
    public static final TagKey<Item> WILLOW_LOGS = TagKey.of(RegistryKeys.ITEM, new Identifier("overwhelmed:willow_logs"));

    public OverwhelmedItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        addToTags(Items.SPIDER_EYE, HORNET_FOOD);
        addToTags(Items.HONEY_BOTTLE, HORNET_FOOD);
        addToTags(OverwhelmedItems.SNAIL, HORNET_FOOD);
        addToTags(Items.RABBIT, HORNET_FOOD);
        addToTags(Items.RABBIT_FOOT, HORNET_FOOD);

        addToTags(OverwhelmedBlocks.FLOFF, ItemTags.SMALL_FLOWERS);
        addToTags(OverwhelmedBlocks.PAINE, ItemTags.SMALL_FLOWERS);
        addToTags(OverwhelmedBlocks.PINK_LAVATERA, ItemTags.SMALL_FLOWERS);
        addToTags(OverwhelmedBlocks.WHITE_LAVATERA, ItemTags.SMALL_FLOWERS);
        addToTags(OverwhelmedBlocks.SQUIRL, ItemTags.SMALL_FLOWERS);
        addToTags(OverwhelmedBlocks.RINGOT, ItemTags.SMALL_FLOWERS);
        addToTags(OverwhelmedBlocks.SNOWDROP, ItemTags.SMALL_FLOWERS);
        addToTags(OverwhelmedBlocks.BELL_SUNFLOWER, ItemTags.SMALL_FLOWERS);

        addToTags(OverwhelmedBlocks.WIDOW, ItemTags.TALL_FLOWERS);
        addToTags(OverwhelmedBlocks.WHITE_ALLIUM, ItemTags.TALL_FLOWERS);

        addToTags(OverwhelmedBlocks.WILLOW_PLANKS, ItemTags.PLANKS);

        addToTags(OverwhelmedBlocks.WILLOW_LOG, ItemTags.LOGS_THAT_BURN, WILLOW_LOGS);
        addToTags(OverwhelmedBlocks.WILLOW_WOOD, ItemTags.LOGS_THAT_BURN, WILLOW_LOGS);
        addToTags(OverwhelmedBlocks.STRIPPED_WILLOW_LOG, ItemTags.LOGS_THAT_BURN, WILLOW_LOGS);
        addToTags(OverwhelmedBlocks.STRIPPED_WILLOW_WOOD, ItemTags.LOGS_THAT_BURN, WILLOW_LOGS);
    }

    private void addToTags(Block block, TagKey<Item>... tags) {
        addToTags(block.asItem(), tags);
    }

    private void addToTags(Item item, TagKey<Item>... tags) {
        for(TagKey<Item> tag: tags){
            getOrCreateTagBuilder(tag)
                    .add(item);
        }
    }
}