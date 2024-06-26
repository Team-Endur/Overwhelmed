package endurteam.overwhelmed.datagen;

import endurteam.overwhelmed.block.MintBlock;
import endurteam.overwhelmed.block.OverwhelmedBlocks;
import endurteam.overwhelmed.block.VanillaBlock;
import endurteam.overwhelmed.item.OverwhelmedItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.item.Items;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class OverwhelmedLootTableProvider extends FabricBlockLootTableProvider {

    public OverwhelmedLootTableProvider(FabricDataOutput dataOutput,
                                        CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(OverwhelmedBlocks.WILLOW_LOG);
        addDrop(OverwhelmedBlocks.WILLOW_WOOD);
        addDrop(OverwhelmedBlocks.STRIPPED_WILLOW_LOG);
        addDrop(OverwhelmedBlocks.STRIPPED_WILLOW_WOOD);
        addDrop(OverwhelmedBlocks.WILLOW_PLANKS);
        addDrop(OverwhelmedBlocks.WILLOW_STAIRS);
        addDrop(OverwhelmedBlocks.WILLOW_SLAB);
        addDrop(OverwhelmedBlocks.WILLOW_FENCE);
        addDrop(OverwhelmedBlocks.WILLOW_FENCE_GATE);
        addDrop(OverwhelmedBlocks.WILLOW_TRAPDOOR);
        addDrop(OverwhelmedBlocks.WILLOW_PRESSURE_PLATE);
        addDrop(OverwhelmedBlocks.WILLOW_BUTTON);
        addDrop(OverwhelmedBlocks.WILLOW_SIGN);
        addDrop(OverwhelmedBlocks.WILLOW_WALL_SIGN);
        addDrop(OverwhelmedBlocks.WILLOW_HANGING_SIGN);
        addDrop(OverwhelmedBlocks.WILLOW_HANGING_WALL_SIGN);
        addDrop(OverwhelmedBlocks.WILLOW_LEAVES, leavesDrops(OverwhelmedBlocks.WILLOW_LEAVES, OverwhelmedBlocks.WILLOW_SAPLING,
                0.05f));
        addVinePlantDrop(OverwhelmedBlocks.WILLOW_VINES, OverwhelmedBlocks.WILLOW_VINES);
        addDrop(OverwhelmedBlocks.WILLOW_SAPLING);

        addDrop(OverwhelmedBlocks.DESERT_SNAIL_SHELL_BRICKS);
        addDrop(OverwhelmedBlocks.DESERT_SNAIL_SHELL_BRICK_STAIRS);
        addDrop(OverwhelmedBlocks.DESERT_SNAIL_SHELL_BRICK_SLAB);
        addDrop(OverwhelmedBlocks.DESERT_SNAIL_SHELL_BRICK_WALL);
        addDrop(OverwhelmedBlocks.CHISELED_DESERT_SNAIL_SHELL_BRICKS);
        addDrop(OverwhelmedBlocks.GARDEN_SNAIL_SHELL_BRICKS);
        addDrop(OverwhelmedBlocks.GARDEN_SNAIL_SHELL_BRICK_STAIRS);
        addDrop(OverwhelmedBlocks.GARDEN_SNAIL_SHELL_BRICK_SLAB);
        addDrop(OverwhelmedBlocks.GARDEN_SNAIL_SHELL_BRICK_WALL);
        addDrop(OverwhelmedBlocks.CHISELED_GARDEN_SNAIL_SHELL_BRICKS);
        addDrop(OverwhelmedBlocks.SNOW_SNAIL_SHELL_BRICKS);
        addDrop(OverwhelmedBlocks.SNOW_SNAIL_SHELL_BRICK_STAIRS);
        addDrop(OverwhelmedBlocks.SNOW_SNAIL_SHELL_BRICK_SLAB);
        addDrop(OverwhelmedBlocks.SNOW_SNAIL_SHELL_BRICK_WALL);
        addDrop(OverwhelmedBlocks.CHISELED_SNOW_SNAIL_SHELL_BRICKS);

        addDrop(OverwhelmedBlocks.ALTAIR);
        addDrop(OverwhelmedBlocks.ALTAIR_STAIRS);
        addDrop(OverwhelmedBlocks.ALTAIR_SLAB);
        addDrop(OverwhelmedBlocks.ALTAIR_WALL);
        addDrop(OverwhelmedBlocks.POLISHED_ALTAIR);
        addDrop(OverwhelmedBlocks.POLISHED_ALTAIR_STAIRS);
        addDrop(OverwhelmedBlocks.POLISHED_ALTAIR_SLAB);

        addDrop(OverwhelmedBlocks.FIZZYROCK);
        addDrop(OverwhelmedBlocks.FIZZYROCK_STAIRS);
        addDrop(OverwhelmedBlocks.FIZZYROCK_SLAB);
        addDrop(OverwhelmedBlocks.FIZZYROCK_WALL);
        addDrop(OverwhelmedBlocks.CHISELED_FIZZYROCK);
        addDrop(OverwhelmedBlocks.POLISHED_FIZZYROCK);
        addDrop(OverwhelmedBlocks.POLISHED_FIZZYROCK_STAIRS);
        addDrop(OverwhelmedBlocks.POLISHED_FIZZYROCK_SLAB);
        addDrop(OverwhelmedBlocks.FIZZYROCK_BRICK_WALL);
        addDrop(OverwhelmedBlocks.FIZZYROCK_BRICKS);
        addDrop(OverwhelmedBlocks.FIZZYROCK_BRICK_STAIRS);
        addDrop(OverwhelmedBlocks.FIZZYROCK_BRICK_SLAB);
        addDrop(OverwhelmedBlocks.CHISELED_FIZZYROCK_BRICKS);
        addDrop(OverwhelmedBlocks.FIZZYROCK_GEYSER);

        addDrop(OverwhelmedBlocks.SOIL);
        addDrop(OverwhelmedBlocks.CHARCOAL_ORE, oreDrops(OverwhelmedBlocks.CHARCOAL_ORE, Items.CHARCOAL));

        addDrop(OverwhelmedBlocks.FLOFF);
        addDrop(OverwhelmedBlocks.PAINE);
        addDrop(OverwhelmedBlocks.PINK_LAVATERA);
        addDrop(OverwhelmedBlocks.WHITE_LAVATERA);
        addDrop(OverwhelmedBlocks.SQUIRL);
        addDrop(OverwhelmedBlocks.RINGOT);
        addDrop(OverwhelmedBlocks.SNOWDROP);
        addDrop(OverwhelmedBlocks.BELL_SUNFLOWER);

        addPottedPlantDrops(OverwhelmedBlocks.POTTED_FLOFF);
        addPottedPlantDrops(OverwhelmedBlocks.POTTED_PAINE);
        addPottedPlantDrops(OverwhelmedBlocks.POTTED_PINK_LAVATERA);
        addPottedPlantDrops(OverwhelmedBlocks.POTTED_WHITE_LAVATERA);
        addPottedPlantDrops(OverwhelmedBlocks.POTTED_SQUIRL);
        addPottedPlantDrops(OverwhelmedBlocks.POTTED_RINGOT);
        addPottedPlantDrops(OverwhelmedBlocks.POTTED_SNOWDROP);
        addPottedPlantDrops(OverwhelmedBlocks.POTTED_BELL_SUNFLOWER);

        BlockStatePropertyLootCondition.Builder builder = BlockStatePropertyLootCondition.builder(OverwhelmedBlocks.VANILLA)
                .properties(StatePredicate.Builder.create()
                        .exactMatch(VanillaBlock.AGE, 3));
        addDrop(OverwhelmedBlocks.VANILLA, cropDrops(OverwhelmedBlocks.VANILLA, OverwhelmedItems.VANILLA_BEANS,
                OverwhelmedItems.VANILLA_BEANS, builder));

        BlockStatePropertyLootCondition.Builder builder2 = BlockStatePropertyLootCondition.builder(OverwhelmedBlocks.MINT)
                .properties(StatePredicate.Builder.create()
                .exactMatch(MintBlock.AGE, 3));
        addDrop(OverwhelmedBlocks.MINT, cropDrops(OverwhelmedBlocks.MINT, OverwhelmedItems.MINT_LEAF,
                OverwhelmedItems.MINT_SEEDS, builder2));

        addDrop(OverwhelmedBlocks.GOLD_BEAD);
        addDrop(OverwhelmedBlocks.ICE_CUBE);
        addDrop(OverwhelmedBlocks.PEBBLE);

        addDrop(OverwhelmedBlocks.PAPER_NEST, dropsWithSilkTouch(OverwhelmedBlocks.PAPER_NEST));

        addDrop(OverwhelmedBlocks.GOO_BLOCK);
    }
}