package endurteam.overwhelmed.datagen;

import endurteam.overwhelmed.block.OverwhelmedBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;

import java.util.concurrent.CompletableFuture;

@SuppressWarnings("unchecked")
public class OverwhelmedBlockTagProvider extends FabricTagProvider.BlockTagProvider {

    public OverwhelmedBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        addToTags(OverwhelmedBlocks.WILLOW_PLANKS, BlockTags.AXE_MINEABLE);
        addToTags(OverwhelmedBlocks.WILLOW_SLAB, BlockTags.AXE_MINEABLE);
        addToTags(OverwhelmedBlocks.WILLOW_STAIRS, BlockTags.AXE_MINEABLE);
        addToTags(OverwhelmedBlocks.WILLOW_BUTTON, BlockTags.AXE_MINEABLE);
        addToTags(OverwhelmedBlocks.WILLOW_PRESSURE_PLATE, BlockTags.AXE_MINEABLE);
        addToTags(OverwhelmedBlocks.WILLOW_DOOR, BlockTags.AXE_MINEABLE);
        addToTags(OverwhelmedBlocks.WILLOW_TRAPDOOR, BlockTags.AXE_MINEABLE);
        addToTags(OverwhelmedBlocks.WILLOW_FENCE, BlockTags.AXE_MINEABLE, BlockTags.FENCES, BlockTags.WOODEN_FENCES);
        addToTags(OverwhelmedBlocks.WILLOW_FENCE_GATE, BlockTags.AXE_MINEABLE, BlockTags.FENCE_GATES);
        addToTags(OverwhelmedBlocks.WILLOW_SIGN, BlockTags.AXE_MINEABLE, BlockTags.STANDING_SIGNS);
        addToTags(OverwhelmedBlocks.WILLOW_WALL_SIGN, BlockTags.AXE_MINEABLE, BlockTags.WALL_SIGNS);
        addToTags(OverwhelmedBlocks.WILLOW_HANGING_SIGN, BlockTags.AXE_MINEABLE, BlockTags.CEILING_HANGING_SIGNS);
        addToTags(OverwhelmedBlocks.WILLOW_HANGING_WALL_SIGN, BlockTags.AXE_MINEABLE, BlockTags.WALL_HANGING_SIGNS);

        addToTags(OverwhelmedBlocks.PAPER_NEST, BlockTags.AXE_MINEABLE);

        addToTags(OverwhelmedBlocks.GARDEN_SNAIL_SHELL_BRICKS, BlockTags.PICKAXE_MINEABLE);
        addToTags(OverwhelmedBlocks.GARDEN_SNAIL_SHELL_BRICK_STAIRS, BlockTags.PICKAXE_MINEABLE);
        addToTags(OverwhelmedBlocks.GARDEN_SNAIL_SHELL_BRICK_SLAB, BlockTags.PICKAXE_MINEABLE);
        addToTags(OverwhelmedBlocks.GARDEN_SNAIL_SHELL_BRICK_WALL, BlockTags.PICKAXE_MINEABLE, BlockTags.WALLS);
        addToTags(OverwhelmedBlocks.CHISELED_GARDEN_SNAIL_SHELL_BRICKS, BlockTags.PICKAXE_MINEABLE);

        addToTags(OverwhelmedBlocks.ALTAIR, BlockTags.PICKAXE_MINEABLE);
        addToTags(OverwhelmedBlocks.ALTAIR_STAIRS, BlockTags.PICKAXE_MINEABLE);
        addToTags(OverwhelmedBlocks.ALTAIR_SLAB, BlockTags.PICKAXE_MINEABLE);
        addToTags(OverwhelmedBlocks.ALTAIR_WALL, BlockTags.PICKAXE_MINEABLE, BlockTags.WALLS);

        addToTags(OverwhelmedBlocks.POLISHED_ALTAIR, BlockTags.PICKAXE_MINEABLE);
        addToTags(OverwhelmedBlocks.POLISHED_ALTAIR_STAIRS, BlockTags.PICKAXE_MINEABLE);
        addToTags(OverwhelmedBlocks.POLISHED_ALTAIR_SLAB, BlockTags.PICKAXE_MINEABLE);

        addToTags(OverwhelmedBlocks.FIZZYROCK_GEYSER, BlockTags.PICKAXE_MINEABLE);

        addToTags(OverwhelmedBlocks.FIZZYROCK, BlockTags.PICKAXE_MINEABLE);
        addToTags(OverwhelmedBlocks.FIZZYROCK_STAIRS, BlockTags.PICKAXE_MINEABLE);
        addToTags(OverwhelmedBlocks.FIZZYROCK_SLAB, BlockTags.PICKAXE_MINEABLE);
        addToTags(OverwhelmedBlocks.FIZZYROCK_WALL, BlockTags.PICKAXE_MINEABLE, BlockTags.WALLS);
        addToTags(OverwhelmedBlocks.CHISELED_FIZZYROCK, BlockTags.PICKAXE_MINEABLE);

        addToTags(OverwhelmedBlocks.POLISHED_FIZZYROCK, BlockTags.PICKAXE_MINEABLE);
        addToTags(OverwhelmedBlocks.POLISHED_FIZZYROCK_STAIRS, BlockTags.PICKAXE_MINEABLE);
        addToTags(OverwhelmedBlocks.POLISHED_FIZZYROCK_SLAB, BlockTags.PICKAXE_MINEABLE);

        addToTags(OverwhelmedBlocks.FIZZYROCK_BRICKS, BlockTags.PICKAXE_MINEABLE);
        addToTags(OverwhelmedBlocks.FIZZYROCK_BRICK_STAIRS, BlockTags.PICKAXE_MINEABLE);
        addToTags(OverwhelmedBlocks.FIZZYROCK_BRICK_SLAB, BlockTags.PICKAXE_MINEABLE);
        addToTags(OverwhelmedBlocks.FIZZYROCK_BRICK_WALL, BlockTags.PICKAXE_MINEABLE, BlockTags.WALLS);
        addToTags(OverwhelmedBlocks.CHISELED_FIZZYROCK_BRICKS, BlockTags.PICKAXE_MINEABLE);

        addToTags(OverwhelmedBlocks.FIZZYROCK_GEYSER);

        addToTags(OverwhelmedBlocks.SOIL, BlockTags.SHOVEL_MINEABLE, BlockTags.CONVERTABLE_TO_MUD, BlockTags.DIRT);

        addToTags(OverwhelmedBlocks.CHARCOAL_ORE, BlockTags.SHOVEL_MINEABLE);

        addToTags(OverwhelmedBlocks.FLOFF, BlockTags.SMALL_FLOWERS);
        addToTags(OverwhelmedBlocks.PAINE, BlockTags.SMALL_FLOWERS);
        addToTags(OverwhelmedBlocks.PINK_LAVATERA, BlockTags.SMALL_FLOWERS);
        addToTags(OverwhelmedBlocks.WHITE_LAVATERA, BlockTags.SMALL_FLOWERS);
        addToTags(OverwhelmedBlocks.SQUIRL, BlockTags.SMALL_FLOWERS);
        addToTags(OverwhelmedBlocks.RINGOT, BlockTags.SMALL_FLOWERS);
        addToTags(OverwhelmedBlocks.SNOWDROP, BlockTags.SMALL_FLOWERS);
        addToTags(OverwhelmedBlocks.BELL_SUNFLOWER, BlockTags.SMALL_FLOWERS);

        addToTags(OverwhelmedBlocks.POTTED_FLOFF, BlockTags.FLOWER_POTS);
        addToTags(OverwhelmedBlocks.POTTED_PAINE, BlockTags.FLOWER_POTS);
        addToTags(OverwhelmedBlocks.POTTED_PINK_LAVATERA, BlockTags.FLOWER_POTS);
        addToTags(OverwhelmedBlocks.POTTED_WHITE_LAVATERA, BlockTags.FLOWER_POTS);
        addToTags(OverwhelmedBlocks.POTTED_SQUIRL, BlockTags.FLOWER_POTS);
        addToTags(OverwhelmedBlocks.POTTED_RINGOT, BlockTags.FLOWER_POTS);
        addToTags(OverwhelmedBlocks.POTTED_SNOWDROP, BlockTags.FLOWER_POTS);
        addToTags(OverwhelmedBlocks.POTTED_BELL_SUNFLOWER, BlockTags.FLOWER_POTS);

        addToTags(OverwhelmedBlocks.WIDOW, BlockTags.TALL_FLOWERS);
        addToTags(OverwhelmedBlocks.WHITE_ALLIUM, BlockTags.TALL_FLOWERS);

        addToTags(OverwhelmedBlocks.WILLOW_LOG, BlockTags.LOGS_THAT_BURN, BlockTags.OVERWORLD_NATURAL_LOGS);
        addToTags(OverwhelmedBlocks.WILLOW_WOOD, BlockTags.LOGS_THAT_BURN);
        addToTags(OverwhelmedBlocks.STRIPPED_WILLOW_LOG, BlockTags.LOGS_THAT_BURN);
        addToTags(OverwhelmedBlocks.STRIPPED_WILLOW_WOOD, BlockTags.LOGS_THAT_BURN);

        addToTags(OverwhelmedBlocks.GOO_BLOCK, BlockTags.CLIMBABLE);

    }

    // Adds block to all tags pass to it
    private void addToTags(Block block, TagKey<Block>... tags) {
        for(TagKey<Block> tag: tags) {
            getOrCreateTagBuilder(tag)
                    .add(block);
        }
    }
}