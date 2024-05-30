package endurteam.overwhelmed.block;

import endurteam.overwhelmed.Overwhelmed;
import endurteam.overwhelmed.sound.OverwhelmedSounds;
import it.unimi.dsi.fastutil.chars.Char2LongRBTreeMap;
import net.fabricmc.fabric.api.block.v1.FabricBlock;
import net.fabricmc.fabric.api.block.v1.FabricBlockState;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.enums.Instrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class OverwhelmedBlocks {

    public static final Block WILLOW_LOG = registerBlock("willow_log",
            new PillarBlock(FabricBlockSettings.create()
                    .mapColor(MapColor.LICHEN_GREEN)
                    .instrument(Instrument.BASS)
                    .strength(2.0F)
                    .sounds(BlockSoundGroup.WOOD)
                    .burnable()));
    public static final Block WILLOW_WOOD = registerBlock("willow_wood",
            new PillarBlock(FabricBlockSettings.copyOf(WILLOW_LOG)));
    public static final Block STRIPPED_WILLOW_LOG = registerBlock("stripped_willow_log",
            new PillarBlock(FabricBlockSettings.copyOf(WILLOW_LOG)));
    public static final Block STRIPPED_WILLOW_WOOD = registerBlock("stripped_willow_wood",
            new PillarBlock(FabricBlockSettings.copyOf(WILLOW_LOG)));
    public static final Block WILLOW_PLANKS = registerBlock("willow_planks",
            new Block(FabricBlockSettings.create()
                    .mapColor(MapColor.LICHEN_GREEN)
                    .instrument(Instrument.BASS)
                    .strength(2.0F, 3.0F)
                    .sounds(BlockSoundGroup.WOOD)
                    .burnable()));
    public static final Block WILLOW_STAIRS = registerBlock("willow_stairs",
            new StairsBlock(OverwhelmedBlocks.WILLOW_PLANKS.getDefaultState(),
                    FabricBlockSettings.copyShallow(OverwhelmedBlocks.WILLOW_PLANKS)));
    public static final Block WILLOW_SLAB = registerBlock("willow_slab",
            new SlabBlock(FabricBlockSettings.copy(WILLOW_PLANKS)));
    public static final Block WILLOW_FENCE = registerBlock("willow_fence",
            new FenceBlock(FabricBlockSettings.copy(WILLOW_PLANKS)));
    public static final Block WILLOW_FENCE_GATE = registerBlock("willow_fence_gate",
            new FenceGateBlock(OverwhelmedWoodType.WILLOW, FabricBlockSettings.create()
                    .mapColor(WILLOW_PLANKS.getDefaultMapColor())
                    .solid()
                    .instrument(Instrument.BASS)
                    .strength(2.0F, 3.0F)
                    .burnable()));
    public static final Block WILLOW_DOOR = registerBlock("willow_door",
            new DoorBlock(OverwhelmedBlockSetType.WILLOW, FabricBlockSettings.create()
                    .mapColor(WILLOW_PLANKS.getDefaultMapColor())
                    .instrument(Instrument.BASS)
                    .strength(3.0F)
                    .nonOpaque()
                    .burnable()
                    .pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block WILLOW_TRAPDOOR = registerBlock("willow_trapdoor",
            new TrapdoorBlock(OverwhelmedBlockSetType.WILLOW, FabricBlockSettings.create()
                    .mapColor(MapColor.LICHEN_GREEN)
                    .instrument(Instrument.BASS)
                    .strength(3.0F)
                    .nonOpaque()
                    .allowsSpawning(Blocks::never)
                    .burnable()));
    public static final Block WILLOW_PRESSURE_PLATE = registerBlock("willow_pressure_plate",
            new PressurePlateBlock(OverwhelmedBlockSetType.WILLOW, FabricBlockSettings.create()
                    .mapColor(WILLOW_PLANKS.getDefaultMapColor())
                    .solid()
                    .instrument(Instrument.BASS)
                    .noCollision()
                    .strength(0.5F)
                    .burnable()
                    .pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block WILLOW_BUTTON = registerBlock("willow_button",
            new ButtonBlock(OverwhelmedBlockSetType.WILLOW, 30, FabricBlockSettings.create()
                    .noCollision()
                    .strength(0.5F)
                    .pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block WILLOW_LEAVES = registerBlock("willow_leaves",
            new Block(FabricBlockSettings.create()
                    .mapColor(MapColor.DARK_GREEN)
                    .strength(0.2F)
                    .ticksRandomly()
                    .nonOpaque()
                    .allowsSpawning(Blocks::canSpawnOnLeaves)
                    .suffocates(Blocks::never)
                    .blockVision(Blocks::never)
                    .burnable()
                    .pistonBehavior(PistonBehavior.DESTROY)
                    .solidBlock(Blocks::never)));
    public static final Block WILLOW_VINES = registerBlock("willow_vines",
            new WeepingVinesBlock(FabricBlockSettings.create()
                    .mapColor(MapColor.LICHEN_GREEN)
                    .ticksRandomly()
                    .noCollision()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.VINE)
                    .pistonBehavior(PistonBehavior.DESTROY)));

    public static final Block SNAIL_SHELL_BRICKS = registerBlock("snail_shell_bricks",
            new Block(FabricBlockSettings.create()
                    .mapColor(MapColor.DIRT_BROWN)
                    .strength(3.0F, 12.0F)
                    .instrument(Instrument.BASEDRUM)
                    .requiresTool()));
    public static final Block SNAIL_SHELL_BRICK_STAIRS = registerBlock("snail_shell_brick_stair",
            new StairsBlock(OverwhelmedBlocks.SNAIL_SHELL_BRICKS.getDefaultState(),
                    FabricBlockSettings.copyOf(SNAIL_SHELL_BRICKS)));
    public static final Block SNAIL_SHELL_BRICK_SLAB = registerBlock("snail_shell_brick_slab",
            new SlabBlock(FabricBlockSettings.copyOf(SNAIL_SHELL_BRICKS)));
    public static final Block SNAIL_SHELL_BRICK_WALL = registerBlock("snail_shell_brick_wall",
            new WallBlock(FabricBlockSettings.copyOf(SNAIL_SHELL_BRICKS)));
    public static final Block CHISELED_SNAIL_SHELL_BRICKS = registerBlock("chiseled_snail_shell_bricks",
            new Block(FabricBlockSettings.copyOf(SNAIL_SHELL_BRICKS)));

    public static final Block ALTAIR = registerBlock("altair",
            new Block(FabricBlockSettings.create()
                    .mapColor(MapColor.BLACK)
                    .strength(1.5F, 6.0F)
                    .instrument(Instrument.BASEDRUM)
                    .requiresTool()));
    public static final Block ALTAIR_STAIRS = registerBlock("altair_stairs",
            new StairsBlock(OverwhelmedBlocks.ALTAIR.getDefaultState(), FabricBlockSettings.copyOf(ALTAIR)));
    public static final Block ALTAIR_SLAB = registerBlock("altair_slab",
            new SlabBlock(FabricBlockSettings.copyOf(ALTAIR)));
    public static final Block ALTAIR_WALL = registerBlock("altair_wall",
            new WallBlock(FabricBlockSettings.copyOf(ALTAIR)));
    public static final Block POLISHED_ALTAIR = registerBlock("polished_altair",
            new Block(FabricBlockSettings.copyOf(ALTAIR)));
    public static final Block POLISHED_ALTAIR_STAIRS = registerBlock("polished_altair_stairs",
            new StairsBlock(OverwhelmedBlocks.POLISHED_ALTAIR.getDefaultState(), FabricBlockSettings.copyOf(ALTAIR)));
    public static final Block POLISHED_ALTAIR_SLAB = registerBlock("polished_altair_slab",
            new SlabBlock(FabricBlockSettings.copyOf(ALTAIR)));

    public static final Block FIZZYROCK = registerBlock("fizzyrock",
            new Block(FabricBlockSettings.create()
                    .mapColor(MapColor.LIGHT_GRAY)
                    .strength(1.5F, 6.0F)
                    .instrument(Instrument.BASEDRUM)
                    .requiresTool()
                    .sounds(BlockSoundGroup.DEEPSLATE)));
    public static final Block FIZZYROCK_STAIRS = registerBlock("fizzyrock_stairs",
            new StairsBlock(OverwhelmedBlocks.FIZZYROCK.getDefaultState(), FabricBlockSettings.copyOf(FIZZYROCK)));
    public static final Block FIZZYROCK_SLAB = registerBlock("fizzyrock_slab",
            new SlabBlock(FabricBlockSettings.copyOf(FIZZYROCK)));
    public static final Block FIZZYROCK_WALL = registerBlock("fizzyrock_wall",
            new WallBlock(FabricBlockSettings.copyOf(FIZZYROCK)));
    public static final Block CHISELED_FIZZYROCK = registerBlock("chiseled_fizzyrock",
            new Block(FabricBlockSettings.copyOf(FIZZYROCK)));
    public static final Block POLISHED_FIZZYROCK = registerBlock("polished_fizzyrock",
            new Block(FabricBlockSettings.create()
                    .mapColor(MapColor.LIGHT_GRAY)
                    .strength(1.5F, 6.0F)
                    .instrument(Instrument.BASEDRUM)
                    .requiresTool()
                    .sounds(BlockSoundGroup.POLISHED_DEEPSLATE)));
    public static final Block POLISHED_FIZZYROCK_STAIRS = registerBlock("polished_fizzyrock_stairs",
            new StairsBlock(OverwhelmedBlocks.POLISHED_FIZZYROCK.getDefaultState(),
                    FabricBlockSettings.copyOf(POLISHED_FIZZYROCK)));
    public static final Block POLISHED_FIZZYROCK_SLAB = registerBlock("polished_fizzyrock_slab",
            new SlabBlock(FabricBlockSettings.copyOf(POLISHED_FIZZYROCK)));
    public static final Block FIZZYROCK_BRICKS = registerBlock("fizzyrock_bricks",
            new Block(FabricBlockSettings.create()
                    .mapColor(MapColor.LIGHT_GRAY)
                    .strength(1.5F, 6.0F)
                    .instrument(Instrument.BASEDRUM)
                    .requiresTool()
                    .sounds(BlockSoundGroup.DEEPSLATE_BRICKS)));
    public static final Block FIZZYROCK_BRICK_STAIRS = registerBlock("fizzyrock_brick_stairs",
            new StairsBlock(OverwhelmedBlocks.FIZZYROCK_BRICKS.getDefaultState(),
                    FabricBlockSettings.copyOf(FIZZYROCK_BRICKS)));
    public static final Block FIZZYROCK_BRICK_SLAB = registerBlock("fizzyrock_brick_slab",
            new SlabBlock(FabricBlockSettings.copyOf(FIZZYROCK_BRICKS)));
    public static final Block FIZZYROCK_BRICK_WALL = registerBlock("fizzyrock_brick_wall",
            new WallBlock(FabricBlockSettings.copyOf(FIZZYROCK_BRICKS)));
    public static final Block CHISELED_FIZZYROCK_BRICKS = registerBlock("chiseled_fizzyrock_bricks",
            new Block(FabricBlockSettings.copyOf(FIZZYROCK_BRICKS)));
    public static final Block FIZZYROCK_GEYSER = registerBlock("fizzyrock_geyser",
            new Block(FabricBlockSettings.copyOf(FIZZYROCK)));

    public static final Block SOIL = registerBlock("soil",
            new Block(FabricBlockSettings.create()
            .mapColor(MapColor.DIRT_BROWN)
            .strength(0.5F)
            .sounds(BlockSoundGroup.ROOTED_DIRT)));
    public static final Block CHARCOAL_ORE = registerBlock("charcoal_ore",
            new Block(FabricBlockSettings.create()
            .mapColor(MapColor.DIRT_BROWN)
            .strength(0.7F)
            .sounds(BlockSoundGroup.ROOTED_DIRT)));

    public static final Block FLOFF = registerBlock("floff",
            new FlowerBlock(StatusEffects.REGENERATION, 4, FabricBlockSettings.create()
                    .mapColor(MapColor.DARK_GREEN)
                    .sounds(BlockSoundGroup.GRASS)
                    .noCollision()
                    .breakInstantly()
                    .offset(AbstractBlock.OffsetType.XZ)
                    .pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block PAINE = registerBlock("paine", new FlowerBlock(StatusEffects.POISON, 8,
            FabricBlockSettings.copyOf(FLOFF)));
    public static final Block PINK_LAVATERA = registerBlock("pink_lavatera",
            new FlowerBlock(StatusEffects.POISON, 6, FabricBlockSettings.copyOf(FLOFF)));
    public static final Block WHITE_LAVATERA = registerBlock("white_lavatera",
            new FlowerBlock(StatusEffects.WEAKNESS, 5, FabricBlockSettings.copyOf(FLOFF)));
    public static final Block SQUIRL = registerBlock("squirl",
            new FlowerBlock(StatusEffects.JUMP_BOOST, 10, FabricBlockSettings.copyOf(FLOFF)));
    public static final Block RINGOT = registerBlock("ringot",
            new FlowerBlock(StatusEffects.BLINDNESS, 5, FabricBlockSettings.copyOf(FLOFF)));
    public static final Block SNOWDROP = registerBlock("snowdrop",
            new FlowerBlock(StatusEffects.WEAKNESS, 7, FabricBlockSettings.copyOf(FLOFF)));
    public static final Block BELL_SUNFLOWER = registerBlock("bell_sunflower",
            new FlowerBlock(StatusEffects.FIRE_RESISTANCE, 10, FabricBlockSettings.copyOf(FLOFF)));

    public static final Block POTTED_FLOFF = registerBlock("potted_floff",
            new FlowerPotBlock(FLOFF, FabricBlockSettings.create()
                    .breakInstantly()
                    .nonOpaque()
                    .pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block POTTED_PAINE = registerBlock("potted_paine",
            new FlowerPotBlock(PAINE, FabricBlockSettings.copyOf(POTTED_FLOFF)));
    public static final Block POTTED_PINK_LAVATERA = registerBlock("potted_lavatera",
            new FlowerPotBlock(PINK_LAVATERA, FabricBlockSettings.copyOf(POTTED_FLOFF)));
    public static final Block POTTED_WHITE_LAVATERA = registerBlock("potted_white_lavatera",
            new FlowerPotBlock(WHITE_LAVATERA, FabricBlockSettings.copyOf(POTTED_FLOFF)));
    public static final Block POTTED_SQUIRL = registerBlock("potted_squirl",
            new FlowerPotBlock(SQUIRL, FabricBlockSettings.copyOf(POTTED_FLOFF)));
    public static final Block POTTED_RINGOT = registerBlock("potted_ringot",
            new FlowerPotBlock(RINGOT, FabricBlockSettings.copyOf(POTTED_FLOFF)));
    public static final Block POTTED_SNOWDROP = registerBlock("potted_snowdrop",
            new FlowerPotBlock(SNOWDROP, FabricBlockSettings.copyOf(POTTED_FLOFF)));
    public static final Block POTTED_BELL_SUNFLOWER = registerBlock("potted_bell_sunflower",
            new FlowerPotBlock(BELL_SUNFLOWER, FabricBlockSettings.copyOf(POTTED_FLOFF)));

    public static final Block WIDOW = registerBlock("widow",
            new TallFlowerBlock(FabricBlockSettings.create()
                    .mapColor(MapColor.DARK_GREEN)
                    .noCollision()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.GRASS)
                    .offset(AbstractBlock.OffsetType.XZ)
                    .burnable()
                    .pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block WHITE_ALLIUM = registerBlock("white_allium",
            new TallFlowerBlock(FabricBlockSettings.copyOf(WIDOW)));

    public static final Block VANILLA = Registry.register(Registries.BLOCK, new Identifier(Overwhelmed.MOD_ID, "vanilla"),
            new VanillaBlock(FabricBlockSettings.create()
                    .mapColor(MapColor.DARK_GREEN)
                    .noCollision()
                    .ticksRandomly()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.CROP)
                    .pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block MINT = Registry.register(Registries.BLOCK, new Identifier(Overwhelmed.MOD_ID, "mint"),
            new MintBlock(FabricBlockSettings.copy(VANILLA)));

    public static final Block GOLD_BEAD = registerClotBlock("gold_bead",
            new ClotBlock(FabricBlockSettings.create()
                    .noCollision()
                    .breakInstantly()
                    .offset(AbstractBlock.OffsetType.XZ)
                    .pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block ICE_CUBE = registerClotBlock("ice_cube",
            new ClotBlock(FabricBlockSettings.copy(GOLD_BEAD)));
    public static final Block PEBBLE = registerPebbleBlock("pebble",
            new ClotBlock(FabricBlockSettings.copy(GOLD_BEAD)));

    public static final Block GOO_BLOCK = registerBlock("goo_block",
            new GooBlock(FabricBlockSettings.create()
                    .mapColor(MapColor.PALE_YELLOW)
                    .velocityMultiplier(0.4F)
                    .jumpVelocityMultiplier(0.5F)
                    .nonOpaque()
                    .sounds(OverwhelmedSounds.GOO_BLOCK)));

    public static final Block VANILLA_CAKE = registerBlock("vanilla_cake",
            new VanillaCakeBlock(FabricBlockSettings.create()
                    .solid()
                    .strength(0.5F)
                    .sounds(BlockSoundGroup.WOOL)
                    .pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block MINT_CAKE = registerBlock("mint_cake",
            new MintCakeBlock(FabricBlockSettings.copyOf(VANILLA_CAKE)));



    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Overwhelmed.MOD_ID, name), block);
    }

    private static Block registerClotBlock(String name, Block block) {
        registerClotBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Overwhelmed.MOD_ID, name), block);
    }

    private static Block registerPebbleBlock(String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(Overwhelmed.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(Overwhelmed.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    private static Item registerClotBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(Overwhelmed.MOD_ID, name),
                new BlockItem(block, new Item.Settings().maxCount(16)));
    }

    public static void registerBlocks() {}
}