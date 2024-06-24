package endurteam.overwhelmed.datagen;

import endurteam.overwhelmed.block.OverwhelmedBlockFamilies;
import endurteam.overwhelmed.block.OverwhelmedBlocks;
import endurteam.overwhelmed.item.OverwhelmedItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.util.Identifier;

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
        generateFamily(exporter, OverwhelmedBlockFamilies.WILLOW_FAMILY);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, OverwhelmedBlocks.WILLOW_STAIRS,
                OverwhelmedBlocks.WILLOW_PLANKS);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, OverwhelmedBlocks.WILLOW_SLAB,
                OverwhelmedBlocks.WILLOW_PLANKS, 2);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, OverwhelmedBlocks.GARDEN_SNAIL_SHELL_BRICKS, 4)
                .pattern("#S")
                .pattern("S#")
                .input('#', OverwhelmedItems.GARDEN_SNAIL_SHELL)
                .input('S', OverwhelmedBlocks.SOIL)
                .criterion(hasItem(OverwhelmedItems.GARDEN_SNAIL_SHELL), conditionsFromItem(OverwhelmedItems.GARDEN_SNAIL_SHELL))
                .criterion(hasItem(OverwhelmedBlocks.SOIL), conditionsFromItem(OverwhelmedBlocks.SOIL))
                .offerTo(exporter, new Identifier(getRecipeName(OverwhelmedBlocks.GARDEN_SNAIL_SHELL_BRICKS)));
        generateFamily(exporter, OverwhelmedBlockFamilies.SNAIL_SHELL_FAMILY);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS,
                OverwhelmedBlocks.GARDEN_SNAIL_SHELL_BRICK_STAIRS, OverwhelmedBlocks.GARDEN_SNAIL_SHELL_BRICKS);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS,
                OverwhelmedBlocks.GARDEN_SNAIL_SHELL_BRICK_SLAB, OverwhelmedBlocks.GARDEN_SNAIL_SHELL_BRICKS, 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, OverwhelmedBlocks.GARDEN_SNAIL_SHELL_BRICK_WALL,
                OverwhelmedBlocks.GARDEN_SNAIL_SHELL_BRICKS);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, OverwhelmedBlocks.CHISELED_GARDEN_SNAIL_SHELL_BRICKS,
                OverwhelmedBlocks.GARDEN_SNAIL_SHELL_BRICKS);

        generateFamily(exporter, OverwhelmedBlockFamilies.ALTAIR_FAMILY);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS,
                OverwhelmedBlocks.ALTAIR_STAIRS, OverwhelmedBlocks.ALTAIR);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS,
                OverwhelmedBlocks.ALTAIR_SLAB, OverwhelmedBlocks.ALTAIR, 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS,
                OverwhelmedBlocks.ALTAIR_WALL, OverwhelmedBlocks.ALTAIR);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, OverwhelmedBlocks.POLISHED_ALTAIR,
                OverwhelmedBlocks.ALTAIR);

        generateFamily(exporter, OverwhelmedBlockFamilies.POLISHED_ALTAIR_FAMILY);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, OverwhelmedBlocks.POLISHED_ALTAIR_STAIRS,
                OverwhelmedBlocks.POLISHED_ALTAIR);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, OverwhelmedBlocks.POLISHED_ALTAIR_SLAB,
                OverwhelmedBlocks.POLISHED_ALTAIR, 2);

        generateFamily(exporter, OverwhelmedBlockFamilies.FIZZYROCK_FAMILY);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, OverwhelmedBlocks.FIZZYROCK_STAIRS,
                OverwhelmedBlocks.FIZZYROCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, OverwhelmedBlocks.FIZZYROCK_SLAB,
                OverwhelmedBlocks.FIZZYROCK, 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, OverwhelmedBlocks.FIZZYROCK_WALL,
                OverwhelmedBlocks.FIZZYROCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, OverwhelmedBlocks.CHISELED_FIZZYROCK,
                OverwhelmedBlocks.FIZZYROCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, OverwhelmedBlocks.POLISHED_FIZZYROCK,
                OverwhelmedBlocks.FIZZYROCK);

        generateFamily(exporter, OverwhelmedBlockFamilies.POLISHED_FIZZYROCK_FAMILY);
        offerPolishedStoneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, OverwhelmedBlocks.FIZZYROCK_BRICKS,
                OverwhelmedBlocks.POLISHED_FIZZYROCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, OverwhelmedBlocks.POLISHED_FIZZYROCK_STAIRS,
                OverwhelmedBlocks.POLISHED_FIZZYROCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, OverwhelmedBlocks.POLISHED_FIZZYROCK_SLAB,
                OverwhelmedBlocks.POLISHED_FIZZYROCK, 2);

        generateFamily(exporter, OverwhelmedBlockFamilies.FIZZYROCK_BRICKS_FAMILY);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, OverwhelmedBlocks.FIZZYROCK,
                OverwhelmedBlocks.FIZZYROCK_BRICKS);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, OverwhelmedBlocks.POLISHED_FIZZYROCK,
                OverwhelmedBlocks.FIZZYROCK_BRICKS);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, OverwhelmedBlocks.FIZZYROCK_BRICK_STAIRS,
                OverwhelmedBlocks.FIZZYROCK_BRICKS);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, OverwhelmedBlocks.FIZZYROCK_BRICK_SLAB,
                OverwhelmedBlocks.FIZZYROCK_BRICKS, 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, OverwhelmedBlocks.FIZZYROCK_BRICK_WALL,
                OverwhelmedBlocks.FIZZYROCK_BRICKS);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, OverwhelmedBlocks.CHISELED_FIZZYROCK_BRICKS,
                OverwhelmedBlocks.FIZZYROCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, OverwhelmedBlocks.CHISELED_FIZZYROCK_BRICKS,
                OverwhelmedBlocks.POLISHED_FIZZYROCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, OverwhelmedBlocks.CHISELED_FIZZYROCK_BRICKS,
                OverwhelmedBlocks.FIZZYROCK_BRICKS);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.MAGENTA_DYE)
                .input(OverwhelmedBlocks.FLOFF);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.CYAN_DYE)
                .input(OverwhelmedBlocks.PAINE);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.PINK_DYE)
                .input(OverwhelmedBlocks.PINK_LAVATERA);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.WHITE_DYE)
                .input(OverwhelmedBlocks.WHITE_LAVATERA);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.CYAN_DYE)
                .input(OverwhelmedBlocks.SQUIRL);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.MAGENTA_DYE)
                .input(OverwhelmedBlocks.RINGOT);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.WHITE_DYE)
                .input(OverwhelmedBlocks.SNOWDROP);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.YELLOW_DYE)
                .input(OverwhelmedBlocks.BELL_SUNFLOWER);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.BLUE_DYE, 2)
                .input(OverwhelmedBlocks.WIDOW);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.WHITE_DYE, 2)
                .input(OverwhelmedBlocks.WHITE_ALLIUM);


        offer2x2CompactingRecipe(exporter, RecipeCategory.MISC, Items.RAW_GOLD, OverwhelmedBlocks.GOLD_BEAD);
        offer2x2CompactingRecipe(exporter, RecipeCategory.MISC, Blocks.ICE, OverwhelmedBlocks.ICE_CUBE);
        offer2x2CompactingRecipe(exporter, RecipeCategory.MISC, Blocks.COBBLESTONE, OverwhelmedBlocks.PEBBLE);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, OverwhelmedBlocks.GOLD_BEAD, 4)
                .input(Items.RAW_GOLD);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, OverwhelmedBlocks.ICE_CUBE, 4)
                .input(Blocks.ICE);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, OverwhelmedBlocks.PEBBLE, 4)
                .input(Items.COBBLESTONE);

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

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, OverwhelmedItems.VANILLA_COOKIE, 8)
                .pattern(" M ")
                .pattern("W#W")
                .input('#', OverwhelmedItems.VANILLA_BEANS)
                .input('W', Items.WHEAT)
                .input('M', Items.MILK_BUCKET)
                .criterion(hasItem(OverwhelmedItems.VANILLA_BEANS), conditionsFromItem(OverwhelmedItems.VANILLA_BEANS))
                .criterion(hasItem(Items.WHEAT), conditionsFromItem(Items.WHEAT))
                .criterion(hasItem(Items.MILK_BUCKET), conditionsFromItem(Items.MILK_BUCKET))
                .offerTo(exporter, new Identifier(getRecipeName(OverwhelmedItems.VANILLA_COOKIE)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, OverwhelmedItems.PEPPERMINT, 8)
                .pattern("M#")
                .pattern("##")
                .input('M', OverwhelmedItems.MINT_LEAF)
                .input('#', Items.SUGAR)
                .criterion(hasItem(OverwhelmedItems.MINT_LEAF), conditionsFromItem(OverwhelmedItems.MINT_LEAF))
                .criterion(hasItem(Items.SUGAR), conditionsFromItem(Items.SUGAR))
                .offerTo(exporter, new Identifier(getRecipeName(OverwhelmedItems.PEPPERMINT)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, OverwhelmedItems.VANILLA_ICE_CREAM)
                .input(Items.BOWL)
                .input(Items.SNOWBALL, 3)
                .input(Items.MILK_BUCKET)
                .input(OverwhelmedItems.VANILLA_BEANS);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, OverwhelmedItems.MINT_ICE_CREAM)
                .input(Items.BOWL)
                .input(Items.SNOWBALL, 3)
                .input(Items.MILK_BUCKET)
                .input(OverwhelmedItems.MINT_LEAF);

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, OverwhelmedItems.SNAIL_STEW)
                .pattern("SSS")
                .pattern("###")
                .pattern(" B ")
                .input('S', OverwhelmedItems.COOKED_SNAIL)
                .input('#', OverwhelmedItems.GOO_BALL)
                .input('B', Items.BOWL)
                .criterion(hasItem(OverwhelmedItems.COOKED_SNAIL), conditionsFromItem(OverwhelmedItems.COOKED_SNAIL))
                .criterion(hasItem(OverwhelmedItems.GOO_BALL), conditionsFromItem(OverwhelmedItems.GOO_BALL))
                .criterion(hasItem(Items.BOWL), conditionsFromItem(Items.BOWL))
                .offerTo(exporter, new Identifier(getRecipeName(OverwhelmedItems.SNAIL_STEW)));

    }

    private static void generateFamily(RecipeExporter exporter, BlockFamily family) {
        generateFamily(exporter, family, FeatureSet.of(FeatureFlags.VANILLA));
    }

    public static void offerStairsRecipe(RecipeExporter exporter, ItemConvertible output, ItemConvertible input) {
        createStairsRecipe(output, Ingredient.ofItems(input)).criterion(hasItem(input),
                conditionsFromItem(input)).offerTo(exporter);
    }
    public static void offerFenceRecipe(RecipeExporter exporter, ItemConvertible output, ItemConvertible input) {
        createFenceRecipe(output, Ingredient.ofItems(input)).criterion(hasItem(input),
                conditionsFromItem(input)).offerTo(exporter);
    }
    public static void offerFenceGateRecipe(RecipeExporter exporter, ItemConvertible output, ItemConvertible input) {
        createFenceGateRecipe(output, Ingredient.ofItems(input)).criterion(hasItem(input),
                conditionsFromItem(input)).offerTo(exporter);
    }
    public static void offerDoorRecipe(RecipeExporter exporter, ItemConvertible output, ItemConvertible input) {
        createDoorRecipe(output, Ingredient.ofItems(input)).criterion(hasItem(input),
                conditionsFromItem(input)).offerTo(exporter);
    }
    public static void offerTrapdoorRecipe(RecipeExporter exporter, ItemConvertible output, ItemConvertible input) {
        createTrapdoorRecipe(output, Ingredient.ofItems(input)).criterion(hasItem(input),
                conditionsFromItem(input)).offerTo(exporter);
    }

}