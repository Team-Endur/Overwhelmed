package endurteam.overwhelmed.datagen;

import endurteam.overwhelmed.block.OverwhelmedBlocks;
import endurteam.overwhelmed.item.OverwhelmedItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class OverwhelmedRecipeProvider extends FabricRecipeProvider {

    public OverwhelmedRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, OverwhelmedBlocks.WILLOW_WOOD, 4)
                .pattern("##")
                .pattern("##")
                .input('#', OverwhelmedBlocks.WILLOW_LOG)
                .criterion(hasItem(OverwhelmedBlocks.WILLOW_LOG), conditionsFromItem(OverwhelmedBlocks.WILLOW_LOG))
                .offerTo(exporter, new Identifier(getRecipeName(OverwhelmedBlocks.WILLOW_WOOD)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, OverwhelmedBlocks.STRIPPED_WILLOW_WOOD, 1)
                .pattern("##")
                .pattern("##")
                .input('#', OverwhelmedBlocks.STRIPPED_WILLOW_LOG)
                .criterion(hasItem(OverwhelmedBlocks.STRIPPED_WILLOW_LOG),
                        conditionsFromItem(OverwhelmedBlocks.STRIPPED_WILLOW_LOG))
                .offerTo(exporter, new Identifier(getRecipeName(OverwhelmedBlocks.STRIPPED_WILLOW_WOOD)));
        offerPlanksRecipe(exporter, OverwhelmedBlocks.WILLOW_PLANKS, OverwhelmedItemTagProvider.WILLOW_LOGS, 4);
        offerStairsRecipe(exporter, OverwhelmedBlocks.WILLOW_STAIRS, OverwhelmedBlocks.WILLOW_PLANKS);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, OverwhelmedBlocks.WILLOW_STAIRS,
                OverwhelmedBlocks.WILLOW_PLANKS);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, OverwhelmedBlocks.WILLOW_SLAB,
                OverwhelmedBlocks.WILLOW_PLANKS);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, OverwhelmedBlocks.WILLOW_SLAB,
                OverwhelmedBlocks.WILLOW_PLANKS, 2);
        offerFenceRecipe(exporter, OverwhelmedBlocks.WILLOW_FENCE, OverwhelmedBlocks.WILLOW_PLANKS);
        offerFenceGateRecipe(exporter, OverwhelmedBlocks.WILLOW_FENCE_GATE, OverwhelmedBlocks.WILLOW_PLANKS);
        offerDoorRecipe(exporter, OverwhelmedBlocks.WILLOW_DOOR, OverwhelmedBlocks.WILLOW_PLANKS);
        offerTrapdoorRecipe(exporter, OverwhelmedBlocks.WILLOW_TRAPDOOR, OverwhelmedBlocks.WILLOW_PLANKS);
        offerPressurePlateRecipe(exporter, OverwhelmedBlocks.WILLOW_PRESSURE_PLATE, OverwhelmedBlocks.WILLOW_PLANKS);
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, OverwhelmedBlocks.WILLOW_BUTTON, 1)
                .pattern("#")
                .input('#', OverwhelmedBlocks.WILLOW_PLANKS)
                .criterion(hasItem(OverwhelmedBlocks.WILLOW_PLANKS), conditionsFromItem(OverwhelmedBlocks.WILLOW_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(OverwhelmedBlocks.WILLOW_BUTTON)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, OverwhelmedBlocks.SNAIL_SHELL_BRICKS, 4)
                .pattern("#S")
                .pattern("S#")
                .input('#', OverwhelmedItems.SNAIL_SHELL)
                .input('S', OverwhelmedBlocks.SOIL)
                .criterion(hasItem(OverwhelmedItems.SNAIL_SHELL), conditionsFromItem(OverwhelmedItems.SNAIL_SHELL))
                .criterion(hasItem(OverwhelmedBlocks.SOIL), conditionsFromItem(OverwhelmedBlocks.SOIL))
                .offerTo(exporter, new Identifier(getRecipeName(OverwhelmedBlocks.SNAIL_SHELL_BRICKS)));
        offerStairsRecipe(exporter, OverwhelmedBlocks.SNAIL_SHELL_BRICK_STAIRS, OverwhelmedBlocks.SNAIL_SHELL_BRICKS);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS,
                OverwhelmedBlocks.SNAIL_SHELL_BRICK_STAIRS, OverwhelmedBlocks.SNAIL_SHELL_BRICKS);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, OverwhelmedBlocks.SNAIL_SHELL_BRICK_SLAB,
                OverwhelmedBlocks.SNAIL_SHELL_BRICKS);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS,
                OverwhelmedBlocks.SNAIL_SHELL_BRICK_SLAB, OverwhelmedBlocks.SNAIL_SHELL_BRICKS, 2);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, OverwhelmedBlocks.SNAIL_SHELL_BRICK_WALL,
                OverwhelmedBlocks.SNAIL_SHELL_BRICKS);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, OverwhelmedBlocks.SNAIL_SHELL_BRICK_WALL,
                OverwhelmedBlocks.SNAIL_SHELL_BRICKS);
        offerChiseledBlockRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, OverwhelmedBlocks.CHISELED_SNAIL_SHELL_BRICKS,
                OverwhelmedBlocks.SNAIL_SHELL_BRICK_SLAB);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, OverwhelmedBlocks.CHISELED_SNAIL_SHELL_BRICKS,
                OverwhelmedBlocks.SNAIL_SHELL_BRICKS);

        offerStairsRecipe(exporter, OverwhelmedBlocks.ALTAIR_STAIRS, OverwhelmedBlocks.ALTAIR);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS,
                OverwhelmedBlocks.ALTAIR_STAIRS, OverwhelmedBlocks.ALTAIR);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, OverwhelmedBlocks.ALTAIR_SLAB,
                OverwhelmedBlocks.ALTAIR);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS,
                OverwhelmedBlocks.ALTAIR_SLAB, OverwhelmedBlocks.ALTAIR, 2);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, OverwhelmedBlocks.ALTAIR_WALL,
                OverwhelmedBlocks.ALTAIR);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS,
                OverwhelmedBlocks.ALTAIR_WALL, OverwhelmedBlocks.ALTAIR);
        offerPolishedStoneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, OverwhelmedBlocks.POLISHED_ALTAIR,
                OverwhelmedBlocks.ALTAIR);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, OverwhelmedBlocks.POLISHED_ALTAIR,
                OverwhelmedBlocks.ALTAIR);
        offerStairsRecipe(exporter, OverwhelmedBlocks.POLISHED_ALTAIR_STAIRS, OverwhelmedBlocks.POLISHED_ALTAIR);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, OverwhelmedBlocks.POLISHED_ALTAIR_STAIRS,
                OverwhelmedBlocks.POLISHED_ALTAIR);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, OverwhelmedBlocks.POLISHED_ALTAIR_SLAB,
                OverwhelmedBlocks.POLISHED_ALTAIR);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, OverwhelmedBlocks.POLISHED_ALTAIR_SLAB,
                OverwhelmedBlocks.POLISHED_ALTAIR, 2);

        offerStairsRecipe(exporter, OverwhelmedBlocks.FIZZYROCK_STAIRS, OverwhelmedBlocks.FIZZYROCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, OverwhelmedBlocks.FIZZYROCK_STAIRS,
                OverwhelmedBlocks.FIZZYROCK);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, OverwhelmedBlocks.FIZZYROCK_SLAB, OverwhelmedBlocks.FIZZYROCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, OverwhelmedBlocks.FIZZYROCK_SLAB,
                OverwhelmedBlocks.FIZZYROCK, 2);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, OverwhelmedBlocks.FIZZYROCK_WALL, OverwhelmedBlocks.FIZZYROCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, OverwhelmedBlocks.FIZZYROCK_WALL,
                OverwhelmedBlocks.FIZZYROCK);
        offerChiseledBlockRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, OverwhelmedBlocks.CHISELED_FIZZYROCK,
                OverwhelmedBlocks.FIZZYROCK_SLAB);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, OverwhelmedBlocks.CHISELED_FIZZYROCK,
                OverwhelmedBlocks.FIZZYROCK);
        offerPolishedStoneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, OverwhelmedBlocks.POLISHED_FIZZYROCK,
                OverwhelmedBlocks.FIZZYROCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, OverwhelmedBlocks.POLISHED_FIZZYROCK,
                OverwhelmedBlocks.FIZZYROCK);
        offerStairsRecipe(exporter, OverwhelmedBlocks.POLISHED_FIZZYROCK_STAIRS, OverwhelmedBlocks.POLISHED_FIZZYROCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, OverwhelmedBlocks.POLISHED_FIZZYROCK_STAIRS,
                OverwhelmedBlocks.POLISHED_FIZZYROCK);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, OverwhelmedBlocks.POLISHED_FIZZYROCK_SLAB,
                OverwhelmedBlocks.POLISHED_FIZZYROCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, OverwhelmedBlocks.POLISHED_FIZZYROCK_SLAB,
                OverwhelmedBlocks.POLISHED_FIZZYROCK, 2);
        offerPolishedStoneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, OverwhelmedBlocks.FIZZYROCK_BRICKS,
                OverwhelmedBlocks.POLISHED_FIZZYROCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, OverwhelmedBlocks.FIZZYROCK,
                OverwhelmedBlocks.FIZZYROCK_BRICKS);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, OverwhelmedBlocks.POLISHED_FIZZYROCK,
                OverwhelmedBlocks.FIZZYROCK_BRICKS);
        offerStairsRecipe(exporter, OverwhelmedBlocks.FIZZYROCK_BRICK_STAIRS, OverwhelmedBlocks.FIZZYROCK_BRICKS);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, OverwhelmedBlocks.FIZZYROCK_BRICK_STAIRS,
                OverwhelmedBlocks.FIZZYROCK_BRICKS);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, OverwhelmedBlocks.FIZZYROCK_BRICK_SLAB,
                OverwhelmedBlocks.FIZZYROCK_BRICKS);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, OverwhelmedBlocks.FIZZYROCK_BRICK_SLAB,
                OverwhelmedBlocks.FIZZYROCK_BRICKS, 2);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, OverwhelmedBlocks.FIZZYROCK_BRICK_WALL,
                OverwhelmedBlocks.FIZZYROCK_BRICKS);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, OverwhelmedBlocks.FIZZYROCK_BRICK_WALL,
                OverwhelmedBlocks.FIZZYROCK_BRICKS);
        offerChiseledBlockRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, OverwhelmedBlocks.CHISELED_FIZZYROCK_BRICKS,
                OverwhelmedBlocks.FIZZYROCK_BRICK_SLAB);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, OverwhelmedBlocks.CHISELED_FIZZYROCK_BRICKS,
                OverwhelmedBlocks.FIZZYROCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, OverwhelmedBlocks.CHISELED_FIZZYROCK_BRICKS,
                OverwhelmedBlocks.POLISHED_FIZZYROCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, OverwhelmedBlocks.CHISELED_FIZZYROCK_BRICKS,
                OverwhelmedBlocks.FIZZYROCK_BRICKS);

        offer2x2CompactingRecipe(exporter, RecipeCategory.MISC, Items.RAW_GOLD, OverwhelmedBlocks.GOLD_BEAD);
        offer2x2CompactingRecipe(exporter, RecipeCategory.MISC, Blocks.ICE, OverwhelmedBlocks.ICE_CUBE);
        offer2x2CompactingRecipe(exporter, RecipeCategory.MISC, Blocks.COBBLESTONE, OverwhelmedBlocks.PEBBLE);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, OverwhelmedBlocks.GOLD_BEAD, 4)
                .pattern("#")
                .input('#', Items.RAW_GOLD)
                .criterion(hasItem(Items.RAW_GOLD), conditionsFromItem(Items.RAW_GOLD))
                .offerTo(exporter, new Identifier(getRecipeName(OverwhelmedBlocks.GOLD_BEAD)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, OverwhelmedBlocks.ICE_CUBE, 4)
                .pattern("#")
                .input('#', Blocks.ICE)
                .criterion(hasItem(Blocks.ICE), conditionsFromItem(Blocks.ICE))
                .offerTo(exporter, new Identifier(getRecipeName(OverwhelmedBlocks.ICE_CUBE)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, OverwhelmedBlocks.PEBBLE, 4)
                .pattern("#")
                .input('#', Blocks.COBBLESTONE)
                .criterion(hasItem(Blocks.COBBLESTONE), conditionsFromItem(Blocks.COBBLESTONE))
                .offerTo(exporter, new Identifier(getRecipeName(OverwhelmedBlocks.PEBBLE)));

        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, OverwhelmedItems.GOO_BALL,
        RecipeCategory.MISC,OverwhelmedBlocks.GOO_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, OverwhelmedItems.PAPER_BULLET, 4)
                .pattern(" P ")
                .pattern("P#P")
                .pattern(" P ")
                .input('#', OverwhelmedItems.GOO_BALL)
                .input('P', Items.PAPER)
                .criterion(hasItem(OverwhelmedItems.GOO_BALL), conditionsFromItem(OverwhelmedItems.GOO_BALL))
                .criterion(hasItem(Items.PAPER), conditionsFromItem(Items.PAPER))
                .offerTo(exporter, new Identifier(getRecipeName(OverwhelmedItems.PAPER_BULLET)));


    }



    public static void offerStairsRecipe(RecipeExporter exporter, ItemConvertible output, ItemConvertible input) {
        createStairsRecipe(output, Ingredient.ofItems(new ItemConvertible[]{input})).criterion(hasItem(input),
                conditionsFromItem(input)).offerTo(exporter);
    }
    public static void offerFenceRecipe(RecipeExporter exporter, ItemConvertible output, ItemConvertible input) {
        createFenceRecipe(output, Ingredient.ofItems(new ItemConvertible[]{input})).criterion(hasItem(input),
                conditionsFromItem(input)).offerTo(exporter);
    }
    public static void offerFenceGateRecipe(RecipeExporter exporter, ItemConvertible output, ItemConvertible input) {
        createFenceGateRecipe(output, Ingredient.ofItems(new ItemConvertible[]{input})).criterion(hasItem(input),
                conditionsFromItem(input)).offerTo(exporter);
    }
    public static void offerDoorRecipe(RecipeExporter exporter, ItemConvertible output, ItemConvertible input) {
        createDoorRecipe(output, Ingredient.ofItems(new ItemConvertible[]{input})).criterion(hasItem(input),
                conditionsFromItem(input)).offerTo(exporter);
    }
    public static void offerTrapdoorRecipe(RecipeExporter exporter, ItemConvertible output, ItemConvertible input) {
        createTrapdoorRecipe(output, Ingredient.ofItems(new ItemConvertible[]{input})).criterion(hasItem(input),
                conditionsFromItem(input)).offerTo(exporter);
    }
}