package endurteam.overwhelmed.datagen;

import endurteam.overwhelmed.block.MintBlock;
import endurteam.overwhelmed.block.OverwhelmedBlocks;
import endurteam.overwhelmed.block.VanillaBlock;
import endurteam.overwhelmed.item.OverwhelmedItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;


public class OverwhelmedModelProvider extends FabricModelProvider {
    public OverwhelmedModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

        blockStateModelGenerator.registerLog(OverwhelmedBlocks.WILLOW_LOG)
                .log(OverwhelmedBlocks.WILLOW_LOG)
                .wood(OverwhelmedBlocks.WILLOW_WOOD);
        blockStateModelGenerator.registerLog(OverwhelmedBlocks.STRIPPED_WILLOW_LOG)
                .log(OverwhelmedBlocks.STRIPPED_WILLOW_LOG)
                .wood(OverwhelmedBlocks.STRIPPED_WILLOW_WOOD);
        BlockStateModelGenerator.BlockTexturePool willowPool = blockStateModelGenerator
                .registerCubeAllModelTexturePool(OverwhelmedBlocks.WILLOW_PLANKS);
        willowPool.stairs(OverwhelmedBlocks.WILLOW_STAIRS);
        willowPool.slab(OverwhelmedBlocks.WILLOW_SLAB);
        willowPool.fence(OverwhelmedBlocks.WILLOW_FENCE);
        willowPool.fenceGate(OverwhelmedBlocks.WILLOW_FENCE_GATE);
        blockStateModelGenerator.registerDoor(OverwhelmedBlocks.WILLOW_DOOR);
        blockStateModelGenerator.registerTrapdoor(OverwhelmedBlocks.WILLOW_TRAPDOOR);
        willowPool.pressurePlate(OverwhelmedBlocks.WILLOW_PRESSURE_PLATE);
        willowPool.button(OverwhelmedBlocks.WILLOW_BUTTON);
        blockStateModelGenerator.registerSimpleCubeAll(OverwhelmedBlocks.WILLOW_LEAVES);
        blockStateModelGenerator.registerTintableCross(OverwhelmedBlocks.WILLOW_VINES,
                BlockStateModelGenerator.TintType.NOT_TINTED);

        BlockStateModelGenerator.BlockTexturePool snailShellBricksPool = blockStateModelGenerator
                .registerCubeAllModelTexturePool(OverwhelmedBlocks.SNAIL_SHELL_BRICKS);
        snailShellBricksPool.stairs(OverwhelmedBlocks.SNAIL_SHELL_BRICK_STAIRS);
        snailShellBricksPool.slab(OverwhelmedBlocks.SNAIL_SHELL_BRICK_SLAB);
        snailShellBricksPool.wall(OverwhelmedBlocks.SNAIL_SHELL_BRICK_WALL);
        blockStateModelGenerator.registerSimpleCubeAll(OverwhelmedBlocks.CHISELED_SNAIL_SHELL_BRICKS);

        BlockStateModelGenerator.BlockTexturePool altairPool = blockStateModelGenerator
                .registerCubeAllModelTexturePool(OverwhelmedBlocks.ALTAIR);
        altairPool.stairs(OverwhelmedBlocks.ALTAIR_STAIRS);
        altairPool.slab(OverwhelmedBlocks.ALTAIR_SLAB);
        altairPool.wall(OverwhelmedBlocks.ALTAIR_WALL);
        BlockStateModelGenerator.BlockTexturePool polishedAltairPool = blockStateModelGenerator
                .registerCubeAllModelTexturePool(OverwhelmedBlocks.POLISHED_ALTAIR);
        polishedAltairPool.stairs(OverwhelmedBlocks.POLISHED_ALTAIR_STAIRS);
        polishedAltairPool.slab(OverwhelmedBlocks.POLISHED_ALTAIR_SLAB);

        BlockStateModelGenerator.BlockTexturePool fizzyrockPool = blockStateModelGenerator
                .registerCubeAllModelTexturePool(OverwhelmedBlocks.FIZZYROCK);
        fizzyrockPool.stairs(OverwhelmedBlocks.FIZZYROCK_STAIRS);
        fizzyrockPool.slab(OverwhelmedBlocks.FIZZYROCK_SLAB);
        fizzyrockPool.wall(OverwhelmedBlocks.FIZZYROCK_WALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(OverwhelmedBlocks.CHISELED_FIZZYROCK);
        BlockStateModelGenerator.BlockTexturePool polishedFizzyrockPool = blockStateModelGenerator
                .registerCubeAllModelTexturePool(OverwhelmedBlocks.POLISHED_FIZZYROCK);
        polishedFizzyrockPool.stairs(OverwhelmedBlocks.POLISHED_FIZZYROCK_STAIRS);
        polishedFizzyrockPool.slab(OverwhelmedBlocks.POLISHED_FIZZYROCK_SLAB);
        BlockStateModelGenerator.BlockTexturePool fizzyrockBricksPool = blockStateModelGenerator
                .registerCubeAllModelTexturePool(OverwhelmedBlocks.FIZZYROCK_BRICKS);
        fizzyrockBricksPool.stairs(OverwhelmedBlocks.FIZZYROCK_BRICK_STAIRS);
        fizzyrockBricksPool.slab(OverwhelmedBlocks.FIZZYROCK_BRICK_SLAB);
        fizzyrockBricksPool.wall(OverwhelmedBlocks.FIZZYROCK_BRICK_WALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(OverwhelmedBlocks.CHISELED_FIZZYROCK_BRICKS);

        blockStateModelGenerator.registerSimpleCubeAll(OverwhelmedBlocks.SOIL);
        blockStateModelGenerator.registerSimpleCubeAll(OverwhelmedBlocks.CHARCOAL_ORE);

        blockStateModelGenerator.registerFlowerPotPlant(OverwhelmedBlocks.FLOFF, OverwhelmedBlocks.POTTED_FLOFF,
                BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(OverwhelmedBlocks.PAINE, OverwhelmedBlocks.POTTED_PAINE,
                BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(OverwhelmedBlocks.PINK_LAVATERA, OverwhelmedBlocks.POTTED_PINK_LAVATERA,
                BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(OverwhelmedBlocks.WHITE_LAVATERA,
                OverwhelmedBlocks.POTTED_WHITE_LAVATERA, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(OverwhelmedBlocks.SQUIRL, OverwhelmedBlocks.POTTED_SQUIRL,
                BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(OverwhelmedBlocks.RINGOT, OverwhelmedBlocks.POTTED_RINGOT,
                BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(OverwhelmedBlocks.SNOWDROP, OverwhelmedBlocks.POTTED_SNOWDROP,
                BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(OverwhelmedBlocks.BELL_SUNFLOWER,
                OverwhelmedBlocks.POTTED_BELL_SUNFLOWER, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerDoubleBlock(OverwhelmedBlocks.WIDOW, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerDoubleBlock(OverwhelmedBlocks.WHITE_ALLIUM,
                BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerCrop(OverwhelmedBlocks.VANILLA, VanillaBlock.AGE, 0, 1, 2, 3);
        blockStateModelGenerator.registerCrop(OverwhelmedBlocks.MINT, MintBlock.AGE, 0, 1, 2, 3);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

        itemModelGenerator.register(OverwhelmedItems.PEBBLE, Models.GENERATED);
        itemModelGenerator.register(OverwhelmedItems.PAPER_BULLET, Models.GENERATED);
        itemModelGenerator.register(OverwhelmedItems.GOO_BALL, Models.GENERATED);
        itemModelGenerator.register(OverwhelmedItems.SNAIL_SHELL, Models.GENERATED);
        itemModelGenerator.register(OverwhelmedItems.MINT_LEAF, Models.GENERATED);

        itemModelGenerator.register(OverwhelmedItems.SNAIL, Models.GENERATED);
        itemModelGenerator.register(OverwhelmedItems.COOKED_SNAIL, Models.GENERATED);
        itemModelGenerator.register(OverwhelmedItems.VANILLA_COOKIE, Models.GENERATED);
        itemModelGenerator.register(OverwhelmedItems.PEPPERMINT, Models.GENERATED);
        itemModelGenerator.register(OverwhelmedItems.VANILLA_ICE_CREAM, Models.GENERATED);
        itemModelGenerator.register(OverwhelmedItems.MINT_ICE_CREAM, Models.GENERATED);
        itemModelGenerator.register(OverwhelmedItems.SNAIL_STEW, Models.GENERATED);


//        itemModelGenerator.register(OverwhelmedItems.HORNET_SPAWN_EGG,
//                new SpawnEggItem(Overwhel));
//        itemModelGenerator.register(OverwhelmedItems.HORNET_LARVA_SPAWN_EGG,
//                new Model(Optional.of(new Identifier("item/hornet_larva_spawn_egg")), Optional.empty()));
//        itemModelGenerator.register(OverwhelmedItems.MOTH_SPAWN_EGG,
//                new Model(Optional.of(new Identifier("item/moth_spawn_egg")), Optional.empty()));
    }
}