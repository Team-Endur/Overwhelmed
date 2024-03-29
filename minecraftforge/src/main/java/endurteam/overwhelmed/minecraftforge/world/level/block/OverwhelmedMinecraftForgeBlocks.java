package endurteam.overwhelmed.minecraftforge.world.level.block;

import endurteam.overwhelmed.Overwhelmed;
import endurteam.overwhelmed.world.level.block.*;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;

public class OverwhelmedMinecraftForgeBlocks {

    public static void registerBlocks(RegisterEvent.RegisterHelper<Block> helper) {
        //Must register Blocks first
        OverwhelmedBlocks.SNAIL_SHELL_BRICKS = registerGenericBlock("snail_shell_bricks",
                BlockBehaviour.Properties.of()
                .mapColor(MapColor.COLOR_BROWN)
                .strength(3.0f, 12.0f)
                .requiresCorrectToolForDrops(), helper);
        OverwhelmedBlocks.SNAIL_SHELL_BRICK_STAIRS = registerGenericStairBlock
                (OverwhelmedBlocks.SNAIL_SHELL_BRICKS.defaultBlockState(),
                "snail_shell_brick_stairs",
                        BlockBehaviour.Properties.ofFullCopy(OverwhelmedBlocks.SNAIL_SHELL_BRICKS), helper);
        OverwhelmedBlocks.SNAIL_SHELL_BRICK_SLAB = registerGenericSlabBlock("snail_shell_brick_slab",
                BlockBehaviour.Properties.ofFullCopy(OverwhelmedBlocks.SNAIL_SHELL_BRICKS), helper);
        OverwhelmedBlocks.SNAIL_SHELL_BRICK_WALL = registerGenericWallBlock("snail_shell_brick_wall",
                BlockBehaviour.Properties.ofFullCopy(OverwhelmedBlocks.SNAIL_SHELL_BRICKS), helper);
        OverwhelmedBlocks.CHISELED_SNAIL_SHELL_BRICKS = registerGenericBlock("chiseled_snail_shell_bricks",
                BlockBehaviour.Properties.of()
                        .mapColor(MapColor.COLOR_BROWN)
                        .strength(3.0f, 12.0f)
                        .requiresCorrectToolForDrops(), helper);
        OverwhelmedBlocks.BLACK_GRANITE = registerGenericBlock("black_granite",
                BlockBehaviour.Properties.of()
                        .mapColor(MapColor.COLOR_BLACK)
                        .instrument(NoteBlockInstrument.BASEDRUM)
                        .requiresCorrectToolForDrops()
                        .strength(1.5F, 6.0F), helper);
        OverwhelmedBlocks.BLACK_GRANITE_STAIRS = registerGenericStairBlock
                (OverwhelmedBlocks.BLACK_GRANITE.defaultBlockState(),
                        "black_granite_stairs", BlockBehaviour.Properties.ofFullCopy(OverwhelmedBlocks.BLACK_GRANITE), helper);
        OverwhelmedBlocks.BLACK_GRANITE_SLAB = registerGenericSlabBlock("black_granite_slab",
                BlockBehaviour.Properties.ofFullCopy(OverwhelmedBlocks.BLACK_GRANITE), helper);
        OverwhelmedBlocks.BLACK_GRANITE_WALL = registerGenericWallBlock("black_granite_wall",
                BlockBehaviour.Properties.ofFullCopy(OverwhelmedBlocks.BLACK_GRANITE), helper);
        OverwhelmedBlocks.POLISHED_BLACK_GRANITE = registerGenericBlock("polished_black_granite",
                BlockBehaviour.Properties.of()
                        .mapColor(MapColor.COLOR_BLACK)
                        .instrument(NoteBlockInstrument.BASEDRUM)
                        .requiresCorrectToolForDrops().strength(1.5F, 6.0F), helper);
        OverwhelmedBlocks.POLISHED_BLACK_GRANITE_STAIRS = registerGenericStairBlock
                (OverwhelmedBlocks.POLISHED_BLACK_GRANITE.defaultBlockState(),
                        "polished_black_granite_stairs",
                        BlockBehaviour.Properties.ofFullCopy(OverwhelmedBlocks.POLISHED_BLACK_GRANITE), helper);
        OverwhelmedBlocks.POLISHED_BLACK_GRANITE_SLAB = registerGenericSlabBlock("polished_black_granite_slab",
                BlockBehaviour.Properties.ofFullCopy(OverwhelmedBlocks.POLISHED_BLACK_GRANITE), helper);
        OverwhelmedBlocks.FIZZYROCK = registerGenericBlock("fizzyrock",
                BlockBehaviour.Properties.of()
                        .mapColor(MapColor.STONE)
                        .instrument(NoteBlockInstrument.BASEDRUM)
                        .requiresCorrectToolForDrops()
                        .strength(1.5f, 6.0f)
                        .sound(SoundType.DEEPSLATE), helper);
        OverwhelmedBlocks.FIZZYROCK_STAIRS = registerGenericStairBlock
                (OverwhelmedBlocks.FIZZYROCK.defaultBlockState(),
                        "fizzyrock_stairs", BlockBehaviour.Properties.ofFullCopy(OverwhelmedBlocks.FIZZYROCK), helper);
        OverwhelmedBlocks.FIZZYROCK_SLAB = registerGenericSlabBlock("fizzyrock_slab",
                BlockBehaviour.Properties.ofFullCopy(OverwhelmedBlocks.FIZZYROCK), helper);
        OverwhelmedBlocks.FIZZYROCK_WALL = registerGenericWallBlock("fizzyrock_wall",
                BlockBehaviour.Properties.ofFullCopy(OverwhelmedBlocks.FIZZYROCK), helper);
        OverwhelmedBlocks.CHISELED_FIZZYROCK = registerGenericBlock("chiseled_fizzyrock",
                BlockBehaviour.Properties.ofFullCopy(OverwhelmedBlocks.FIZZYROCK), helper);
        OverwhelmedBlocks.POLISHED_FIZZYROCK = registerGenericBlock("polished_fizzyrock",
                BlockBehaviour.Properties.of()
                        .mapColor(MapColor.STONE)
                        .instrument(NoteBlockInstrument.BASEDRUM)
                        .requiresCorrectToolForDrops().strength(1.5f, 6.0f)
                        .sound(SoundType.POLISHED_DEEPSLATE), helper);
        OverwhelmedBlocks.POLISHED_FIZZYROCK_STAIRS = registerGenericStairBlock
                (OverwhelmedBlocks.POLISHED_FIZZYROCK.defaultBlockState(),
                        "polished_fizzyrock_stairs",
                        BlockBehaviour.Properties.ofFullCopy(OverwhelmedBlocks.POLISHED_FIZZYROCK), helper);
        OverwhelmedBlocks.POLISHED_FIZZYROCK_SLAB = registerGenericSlabBlock("polished_fizzyrock_slab",
                BlockBehaviour.Properties.ofFullCopy(OverwhelmedBlocks.POLISHED_FIZZYROCK), helper);
        OverwhelmedBlocks.FIZZYROCK_BRICKS = registerGenericBlock("fizzyrock_bricks",
                BlockBehaviour.Properties.of()
                        .mapColor(MapColor.STONE)
                        .instrument(NoteBlockInstrument.BASEDRUM)
                        .requiresCorrectToolForDrops()
                        .strength(1.5f, 6.0f)
                        .sound(SoundType.DEEPSLATE_BRICKS), helper);
        OverwhelmedBlocks.FIZZYROCK_BRICK_STAIRS = registerGenericStairBlock
                (OverwhelmedBlocks.FIZZYROCK_BRICKS.defaultBlockState(),
                        "fizzyrock_brick_stairs",
                        BlockBehaviour.Properties.ofFullCopy(OverwhelmedBlocks.FIZZYROCK_BRICKS), helper);
        OverwhelmedBlocks.FIZZYROCK_BRICK_SLAB = registerGenericSlabBlock("fizzyrock_brick_slab",
                BlockBehaviour.Properties.ofFullCopy(OverwhelmedBlocks.FIZZYROCK_BRICKS), helper);
        OverwhelmedBlocks.FIZZYROCK_BRICK_WALL = registerGenericWallBlock("fizzyrock_brick_wall",
                BlockBehaviour.Properties.ofFullCopy(OverwhelmedBlocks.FIZZYROCK_BRICKS), helper);
        OverwhelmedBlocks.CHISELED_FIZZYROCK_BRICKS = registerGenericBlock("chiseled_fizzyrock_bricks",
                BlockBehaviour.Properties.ofFullCopy(OverwhelmedBlocks.FIZZYROCK_BRICKS), helper);
        OverwhelmedBlocks.FIZZYROCK_GEYSER = Registry.register(BuiltInRegistries.BLOCK,
                new ResourceLocation(Overwhelmed.MOD_ID, "fizzyrock_geyser"),
                new FizzyrockGeyserBlock(BlockBehaviour.Properties.of()
                        .mapColor(MapColor.STONE)
                        .requiresCorrectToolForDrops()
                        .strength(1.3f, 5.0f)
                        .sound(SoundType.DEEPSLATE)));
        OverwhelmedBlocks.SOIL = registerGenericBlock("soil", BlockBehaviour.Properties.of()
                .mapColor(MapColor.COLOR_BROWN)
                .strength(0.5f, 0.5f)
                .sound(SoundType.ROOTED_DIRT), helper);
        OverwhelmedBlocks.CHARCOAL_ORE = registerGenericBlock("charcoal_ore", BlockBehaviour.Properties.of()
                .mapColor(MapColor.COLOR_BROWN)
                .strength(0.6f, 0.6f)
                .sound(SoundType.ROOTED_DIRT), helper);
        OverwhelmedBlocks.GOLD_BEAD = registerGenericClotBlock("gold_bead", BlockBehaviour.Properties.of()
                .mapColor(MapColor.GOLD)
                .strength(0f, 6f)
                .noCollission()
                .sound(SoundType.STONE)
                .noOcclusion(), helper);
        OverwhelmedBlocks.ICE_CUBE = registerGenericClotBlock("ice_cube", BlockBehaviour.Properties.of()
                .mapColor(MapColor.ICE)
                .strength(0f, 6f)
                .noCollission()
                .sound(SoundType.STONE)
                .noOcclusion(), helper);
        helper.register(new ResourceLocation(Overwhelmed.MOD_ID, "pebble"),
                OverwhelmedBlocks.PEBBLE = new PebbleBlock(BlockBehaviour.Properties.of()
                        .mapColor(MapColor.STONE)
                        .strength(0f, 6f)
                        .noCollission()
                        .sound(SoundType.STONE)
                        .noOcclusion()));
        OverwhelmedBlocks.FLOFF = registerGenericFlowerBlock(MobEffects.REGENERATION, 4, "floff",
                BlockBehaviour.Properties.of()
                .mapColor(MapColor.PLANT)
                .noCollission()
                .instabreak()
                .sound(SoundType.GRASS)
                .offsetType(BlockBehaviour.OffsetType.XZ)
                .pushReaction(PushReaction.DESTROY), helper);
        OverwhelmedBlocks.PAINE = registerGenericFlowerBlock(MobEffects.POISON, 8, "paine",
                BlockBehaviour.Properties.of()
                        .mapColor(MapColor.PLANT)
                        .noCollission()
                        .instabreak()
                        .sound(SoundType.GRASS)
                        .offsetType(BlockBehaviour.OffsetType.XZ)
                        .pushReaction(PushReaction.DESTROY), helper);
        OverwhelmedBlocks.PINK_LAVATERA = registerGenericFlowerBlock(MobEffects.POISON, 6, "pink_lavatera",
                BlockBehaviour.Properties.of()
                .mapColor(MapColor.PLANT)
                .noCollission()
                .instabreak()
                .sound(SoundType.GRASS)
                .offsetType(BlockBehaviour.OffsetType.XZ)
                .pushReaction(PushReaction.DESTROY), helper);
        OverwhelmedBlocks.WHITE_LAVATERA = registerGenericFlowerBlock(MobEffects.WEAKNESS, 5, "white_lavatera",
                BlockBehaviour.Properties.of()
                        .mapColor(MapColor.PLANT)
                        .noCollission()
                        .instabreak()
                        .sound(SoundType.GRASS)
                        .offsetType(BlockBehaviour.OffsetType.XZ)
                        .pushReaction(PushReaction.DESTROY), helper);
        OverwhelmedBlocks.SQUIRL = registerGenericFlowerBlock(MobEffects.JUMP, 10, "squirl",
                BlockBehaviour.Properties.of()
                .mapColor(MapColor.PLANT)
                .noCollission()
                .instabreak()
                .sound(SoundType.GRASS)
                .offsetType(BlockBehaviour.OffsetType.XZ)
                .pushReaction(PushReaction.DESTROY), helper);
        OverwhelmedBlocks.RINGOT = registerGenericFlowerBlock(MobEffects.BLINDNESS, 5, "ringot",
                BlockBehaviour.Properties.of()
                .mapColor(MapColor.PLANT)
                .noCollission()
                .instabreak()
                .sound(SoundType.GRASS)
                .offsetType(BlockBehaviour.OffsetType.XZ)
                .pushReaction(PushReaction.DESTROY), helper);
        OverwhelmedBlocks.SNOWDROP = registerGenericFlowerBlock(MobEffects.WEAKNESS, 7, "snowdrop",
                BlockBehaviour.Properties.of()
                .mapColor(MapColor.PLANT)
                .noCollission()
                .instabreak()
                .sound(SoundType.GRASS)
                .offsetType(BlockBehaviour.OffsetType.XZ)
                .pushReaction(PushReaction.DESTROY), helper);
        OverwhelmedBlocks.BELL_SUNFLOWER = registerGenericFlowerBlock(MobEffects.FIRE_RESISTANCE, 10, "bell_sunflower",
                BlockBehaviour.Properties.of()
                .mapColor(MapColor.PLANT)
                .noCollission()
                .instabreak()
                .sound(SoundType.GRASS)
                .offsetType(BlockBehaviour.OffsetType.XZ)
                .pushReaction(PushReaction.DESTROY), helper);
        OverwhelmedBlocks.WIDOW = registerGenericTallFlowerBlock("widow", BlockBehaviour.Properties.of()
                .mapColor(MapColor.PLANT)
                .noCollission()
                .instabreak()
                .sound(SoundType.GRASS)
                .offsetType(BlockBehaviour.OffsetType.XZ)
                .ignitedByLava()
                .pushReaction(PushReaction.DESTROY), helper);
        OverwhelmedBlocks.WHITE_ALLIUM = registerGenericTallFlowerBlock("white_allium", BlockBehaviour.Properties.of()
                .mapColor(MapColor.PLANT)
                .noCollission()
                .instabreak()
                .sound(SoundType.GRASS)
                .offsetType(BlockBehaviour.OffsetType.XZ)
                .ignitedByLava()
                .pushReaction(PushReaction.DESTROY), helper);
        OverwhelmedBlocks.POTTED_FLOFF = registerGenericFlowerPotBlock(OverwhelmedBlocks.FLOFF, "potted_floff",
                BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT), helper);
        OverwhelmedBlocks.POTTED_PAINE = registerGenericFlowerPotBlock(OverwhelmedBlocks.PAINE, "potted_paine",
                BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT), helper);
        OverwhelmedBlocks.POTTED_PINK_LAVATERA = registerGenericFlowerPotBlock(OverwhelmedBlocks.PINK_LAVATERA,
                "potted_pink_lavatera",
                BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT), helper);
        OverwhelmedBlocks.POTTED_WHITE_LAVATERA = registerGenericFlowerPotBlock(OverwhelmedBlocks.WHITE_LAVATERA,
                "potted_white_lavatera",
                BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT), helper);
        OverwhelmedBlocks.POTTED_SQUIRL = registerGenericFlowerPotBlock(OverwhelmedBlocks.SQUIRL, "potted_squirl",
                BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT), helper);
        OverwhelmedBlocks.POTTED_RINGOT = registerGenericFlowerPotBlock(OverwhelmedBlocks.RINGOT, "potted_ringot",
                BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT), helper);
        OverwhelmedBlocks.POTTED_SNOWDROP = registerGenericFlowerPotBlock(OverwhelmedBlocks.SNOWDROP,
                "potted_snowdrop", BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT), helper);
        OverwhelmedBlocks.POTTED_BELL_SUNFLOWER = registerGenericFlowerPotBlock(OverwhelmedBlocks.BELL_SUNFLOWER,
                "potted_bell_sunflower",
                BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT), helper);
        helper.register(new ResourceLocation(Overwhelmed.MOD_ID, "mint"),
                OverwhelmedBlocks.MINT = new CropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT)));
        helper.register(new ResourceLocation(Overwhelmed.MOD_ID, "goo_block"),
                OverwhelmedBlocks.GOO_BLOCK = new GooBlock(BlockBehaviour.Properties.of()
                        .mapColor(MapColor.COLOR_YELLOW)
                        .friction(0.6f)
                        .friction(0.8f)
                        .sound(SoundType.HONEY_BLOCK)
                        .noOcclusion()
                        .jumpFactor(0.5f)
                        .speedFactor(0.4f)));
        helper.register(new ResourceLocation(Overwhelmed.MOD_ID, "mint_cake"),
                OverwhelmedBlocks.MINT_CAKE = new MintCakeBlock(BlockBehaviour.Properties.of()
                        .forceSolidOn()
                        .strength(0.5f)
                        .sound(SoundType.WOOL)
                        .pushReaction(PushReaction.DESTROY)));
        helper.register(new ResourceLocation(Overwhelmed.MOD_ID, "vanilla_cake"),
                OverwhelmedBlocks.VANILLA_CAKE = new VanillaCakeBlock(BlockBehaviour.Properties.of()
                        .forceSolidOn()
                        .strength(0.5f)
                        .sound(SoundType.WOOL)
                        .pushReaction(PushReaction.DESTROY)));

    }
    private static Block registerGenericBlock(String name,
                                              Block.Properties properties,
                                              RegisterEvent.RegisterHelper<Block> helper) {
        Block result;
        helper.register(new ResourceLocation(Overwhelmed.MOD_ID, name),
                result = new Block(properties));
        return result;
    }

    @SuppressWarnings("SameParameterValue")
    private static WallBlock registerGenericWallBlock(String name,
                                                      Block.Properties properties,
                                                      RegisterEvent.RegisterHelper<Block> helper) {
        WallBlock result;
        helper.register(new ResourceLocation(Overwhelmed.MOD_ID, name),
                result = new WallBlock(properties));
        return result;
    }

    @SuppressWarnings("SameParameterValue")
    private static StairBlock registerGenericStairBlock(BlockState blockState,
                                                        String name,
                                                        Block.Properties properties,
                                                        RegisterEvent.RegisterHelper<Block> helper) {
        StairBlock result;
        helper.register(new ResourceLocation(Overwhelmed.MOD_ID, name),
                result = new StairBlock(blockState, properties));
        return result;
    }

    @SuppressWarnings("SameParameterValue")
    private static SlabBlock registerGenericSlabBlock(String name,
                                                      Block.Properties properties,
                                                      RegisterEvent.RegisterHelper<Block> helper) {
        SlabBlock result;
        helper.register(new ResourceLocation(Overwhelmed.MOD_ID, name),
                result = new SlabBlock(properties));
        return result;
    }

    @SuppressWarnings("SameParameterValue")
    private static FlowerBlock registerGenericFlowerBlock(MobEffect mobEffect,
                                                          int i,
                                                          String name,
                                                          BlockBehaviour.Properties properties,
                                                          RegisterEvent.RegisterHelper<Block> helper) {
        FlowerBlock result;
        helper.register(new ResourceLocation(Overwhelmed.MOD_ID, name),
                result = new FlowerBlock(mobEffect, i, properties));
        return result;
    }

    @SuppressWarnings("SameParameterValue")
    private static FlowerPotBlock registerGenericFlowerPotBlock(Block block,
                                                          String name,
                                                          BlockBehaviour.Properties properties,
                                                                RegisterEvent.RegisterHelper<Block> helper) {
        FlowerPotBlock result;
        helper.register(new ResourceLocation(Overwhelmed.MOD_ID, name),
                result = new FlowerPotBlock(() ->
                        (FlowerPotBlock) ForgeRegistries.BLOCKS.getDelegateOrThrow(Blocks.FLOWER_POT).get(),
                        () -> ForgeRegistries.BLOCKS.getDelegateOrThrow(block).get(), properties));
        ((FlowerPotBlock)Blocks.FLOWER_POT).addPlant(new ResourceLocation(Overwhelmed.MOD_ID, name), () -> result);
        return result;
    }

    @SuppressWarnings("SameParameterValue")
    private static TallFlowerBlock registerGenericTallFlowerBlock(String name,
                                                                  Block.Properties properties,
                                                                  RegisterEvent.RegisterHelper<Block> helper) {
        TallFlowerBlock result;
        helper.register(new ResourceLocation(Overwhelmed.MOD_ID, name),
                result = new TallFlowerBlock(properties));
        return result;
    }

    @SuppressWarnings("SameParameterValue")
    private static CropBlock registerGenericCropBlock(String name,
                                                                  Block.Properties properties,
                                                                  RegisterEvent.RegisterHelper<Block> helper) {
        CropBlock result;
        helper.register(new ResourceLocation(Overwhelmed.MOD_ID, name),
                result = new CropBlock(properties));
        return result;
    }

    private static ClotBlock registerGenericClotBlock(String name,
                                                      Block.Properties properties,
                                                      RegisterEvent.RegisterHelper<Block> helper) {
        ClotBlock result;
        helper.register(new ResourceLocation(Overwhelmed.MOD_ID, name),
                result = new ClotBlock(properties));
        return result;
    }

}
