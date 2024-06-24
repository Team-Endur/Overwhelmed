package endurteam.overwhelmed.block;

import com.terraformersmc.terraform.sign.block.TerraformHangingSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformWallHangingSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformWallSignBlock;
import endurteam.overwhelmed.Overwhelmed;
import endurteam.overwhelmed.sound.OverwhelmedSounds;
import endurteam.overwhelmed.util.OverwhelmedBlockSetType;
import endurteam.overwhelmed.util.OverwhelmedWoodType;
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
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_LOG)
                    .mapColor(MapColor.LICHEN_GREEN)));
    public static final Block WILLOW_WOOD = registerBlock("willow_wood",
            new PillarBlock(AbstractBlock.Settings.copy(WILLOW_LOG)));
    public static final Block STRIPPED_WILLOW_LOG = registerBlock("stripped_willow_log",
            new PillarBlock(AbstractBlock.Settings.copy(WILLOW_LOG)));
    public static final Block STRIPPED_WILLOW_WOOD = registerBlock("stripped_willow_wood",
            new PillarBlock(AbstractBlock.Settings.copy(WILLOW_LOG)));
    public static final Block WILLOW_PLANKS = registerBlock("willow_planks",
            new Block(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)
                    .mapColor(MapColor.LICHEN_GREEN)));
    public static final Block WILLOW_STAIRS = registerBlock("willow_stairs",
            new StairsBlock(OverwhelmedBlocks.WILLOW_PLANKS.getDefaultState(),
                    AbstractBlock.Settings.copy(OverwhelmedBlocks.WILLOW_PLANKS)));
    public static final Block WILLOW_SLAB = registerBlock("willow_slab",
            new SlabBlock(AbstractBlock.Settings.copy(WILLOW_PLANKS)));
    public static final Block WILLOW_FENCE = registerBlock("willow_fence",
            new FenceBlock(AbstractBlock.Settings.copy(WILLOW_PLANKS)));
    public static final Block WILLOW_FENCE_GATE = registerBlock("willow_fence_gate",
            new FenceGateBlock(OverwhelmedWoodType.WILLOW, AbstractBlock.Settings.copy(Blocks.OAK_FENCE_GATE)
                    .mapColor(WILLOW_PLANKS.getDefaultMapColor())));
    public static final Block WILLOW_DOOR = registerBlock("willow_door",
            new DoorBlock(OverwhelmedBlockSetType.WILLOW, AbstractBlock.Settings.copy(Blocks.OAK_DOOR)
                    .mapColor(WILLOW_PLANKS.getDefaultMapColor())));
    public static final Block WILLOW_TRAPDOOR = registerBlock("willow_trapdoor",
            new TrapdoorBlock(OverwhelmedBlockSetType.WILLOW, AbstractBlock.Settings.copy(Blocks.OAK_TRAPDOOR)
                    .mapColor(MapColor.LICHEN_GREEN)));
    public static final Block WILLOW_PRESSURE_PLATE = registerBlock("willow_pressure_plate",
            new PressurePlateBlock(OverwhelmedBlockSetType.WILLOW, AbstractBlock.Settings.copy(Blocks.OAK_PRESSURE_PLATE)
                    .mapColor(WILLOW_PLANKS.getDefaultMapColor())));
    public static final Block WILLOW_BUTTON = registerBlock("willow_button",
            new ButtonBlock(OverwhelmedBlockSetType.WILLOW, 30, AbstractBlock.Settings.copy(Blocks.OAK_BUTTON)));

    public static final Identifier WILLOW_SIGN_TEXT_ID = new Identifier(Overwhelmed.MOD_ID, "entity/signs/willow");
    public static final Identifier WILLOW_HANGING_SIGN_TEXT_ID = new Identifier(Overwhelmed.MOD_ID, "entity/signs/hanging/willow");
    public static final Identifier WILLOW_HANGING_GUI_TEXT_ID = new Identifier(Overwhelmed.MOD_ID, "textures/gui/hanging_signs/willow");

    public static final Block WILLOW_SIGN = Registry.register(Registries.BLOCK,
            new Identifier(Overwhelmed.MOD_ID, "willow_sign"),
            new TerraformSignBlock(WILLOW_SIGN_TEXT_ID, AbstractBlock.Settings.copy(Blocks.OAK_SIGN)
                    .mapColor(WILLOW_LOG.getDefaultMapColor())));
    public static final Block WILLOW_WALL_SIGN = Registry.register(Registries.BLOCK,
            new Identifier(Overwhelmed.MOD_ID, "willow_wall_sign"),
            new TerraformWallSignBlock(WILLOW_SIGN_TEXT_ID, AbstractBlock.Settings.copy(Blocks.OAK_WALL_SIGN)
                    .mapColor(WILLOW_LOG.getDefaultMapColor())
                    .dropsLike(WILLOW_SIGN)));
    public static final Block WILLOW_HANGING_SIGN = Registry.register(Registries.BLOCK,
            new Identifier(Overwhelmed.MOD_ID, "willow_hanging_sign"),
            new TerraformHangingSignBlock(WILLOW_HANGING_SIGN_TEXT_ID, WILLOW_HANGING_GUI_TEXT_ID, AbstractBlock.Settings.copy(Blocks.OAK_HANGING_SIGN)
                    .mapColor(WILLOW_LOG.getDefaultMapColor())));
    public static final Block WILLOW_HANGING_WALL_SIGN = Registry.register(Registries.BLOCK,
            new Identifier(Overwhelmed.MOD_ID, "willow_hanging_wall_sign"),
            new TerraformWallHangingSignBlock(WILLOW_HANGING_SIGN_TEXT_ID, WILLOW_HANGING_GUI_TEXT_ID, AbstractBlock.Settings.copy(Blocks.OAK_WALL_HANGING_SIGN)
                    .mapColor(WILLOW_LOG.getDefaultMapColor())
                    .dropsLike(WILLOW_HANGING_SIGN)));

    public static final Block WILLOW_LEAVES = registerBlock("willow_leaves",
            new Block(AbstractBlock.Settings.copy(Blocks.OAK_LEAVES)));
    public static final Block WILLOW_VINES = registerBlock("willow_vines",
            new WeepingVinesBlock(AbstractBlock.Settings.copy(Blocks.VINE)
                    .mapColor(MapColor.LICHEN_GREEN)));

    public static final Block DESERT_SNAIL_SHELL_BRICKS = registerBlock("desert_snail_shell_bricks",
            new Block(AbstractBlock.Settings.create()
                    .mapColor(MapColor.PALE_YELLOW)
                    .strength(3.0F, 12.0F)
                    .instrument(Instrument.BASEDRUM)
                    .requiresTool()));
    public static final Block DESERT_SNAIL_SHELL_BRICK_STAIRS = registerBlock("desert_snail_shell_brick_stairs",
            new StairsBlock(OverwhelmedBlocks.DESERT_SNAIL_SHELL_BRICKS.getDefaultState(),
                    AbstractBlock.Settings.copy(DESERT_SNAIL_SHELL_BRICKS)));
    public static final Block DESERT_SNAIL_SHELL_BRICK_SLAB = registerBlock("desert_snail_shell_brick_slab",
            new SlabBlock(AbstractBlock.Settings.copy(DESERT_SNAIL_SHELL_BRICKS)));
    public static final Block DESERT_SNAIL_SHELL_BRICK_WALL = registerBlock("desert_snail_shell_brick_wall",
            new WallBlock(AbstractBlock.Settings.copy(DESERT_SNAIL_SHELL_BRICKS)));
    public static final Block CHISELED_DESERT_SNAIL_SHELL_BRICKS = registerBlock("chiseled_desert_snail_shell_bricks",
            new Block(AbstractBlock.Settings.copy(DESERT_SNAIL_SHELL_BRICKS)));

    public static final Block GARDEN_SNAIL_SHELL_BRICKS = registerBlock("garden_snail_shell_bricks",
            new Block(AbstractBlock.Settings.create()
                    .mapColor(MapColor.DIRT_BROWN)
                    .strength(3.0F, 12.0F)
                    .instrument(Instrument.BASEDRUM)
                    .requiresTool()));
    public static final Block GARDEN_SNAIL_SHELL_BRICK_STAIRS = registerBlock("garden_snail_shell_brick_stairs",
            new StairsBlock(OverwhelmedBlocks.GARDEN_SNAIL_SHELL_BRICKS.getDefaultState(),
                    AbstractBlock.Settings.copy(GARDEN_SNAIL_SHELL_BRICKS)));
    public static final Block GARDEN_SNAIL_SHELL_BRICK_SLAB = registerBlock("garden_snail_shell_brick_slab",
            new SlabBlock(AbstractBlock.Settings.copy(GARDEN_SNAIL_SHELL_BRICKS)));
    public static final Block GARDEN_SNAIL_SHELL_BRICK_WALL = registerBlock("garden_snail_shell_brick_wall",
            new WallBlock(AbstractBlock.Settings.copy(GARDEN_SNAIL_SHELL_BRICKS)));
    public static final Block CHISELED_GARDEN_SNAIL_SHELL_BRICKS = registerBlock("chiseled_garden_snail_shell_bricks",
            new Block(AbstractBlock.Settings.copy(GARDEN_SNAIL_SHELL_BRICKS)));
    public static final Block SNOW_SNAIL_SHELL_BRICKS = registerBlock("snow_snail_shell_bricks",
            new Block(AbstractBlock.Settings.create()
                    .mapColor(MapColor.WHITE)
                    .strength(3.0F, 12.0F)
                    .instrument(Instrument.BASEDRUM)
                    .requiresTool()));
    public static final Block SNOW_SNAIL_SHELL_BRICK_STAIRS = registerBlock("snow_snail_shell_brick_stairs",
            new StairsBlock(OverwhelmedBlocks.SNOW_SNAIL_SHELL_BRICKS.getDefaultState(),
                    AbstractBlock.Settings.copy(SNOW_SNAIL_SHELL_BRICKS)));
    public static final Block SNOW_SNAIL_SHELL_BRICK_SLAB = registerBlock("snow_snail_shell_brick_slab",
            new SlabBlock(AbstractBlock.Settings.copy(SNOW_SNAIL_SHELL_BRICKS)));
    public static final Block SNOW_SNAIL_SHELL_BRICK_WALL = registerBlock("snow_snail_shell_brick_wall",
            new WallBlock(AbstractBlock.Settings.copy(SNOW_SNAIL_SHELL_BRICKS)));
    public static final Block CHISELED_SNOW_SNAIL_SHELL_BRICKS = registerBlock("chiseled_snow_snail_shell_bricks",
            new Block(AbstractBlock.Settings.copy(SNOW_SNAIL_SHELL_BRICKS)));


    public static final Block ALTAIR = registerBlock("altair",
            new Block(AbstractBlock.Settings.create()
                    .mapColor(MapColor.BLACK)
                    .strength(1.5F, 6.0F)
                    .instrument(Instrument.BASEDRUM)
                    .requiresTool()));
    public static final Block ALTAIR_STAIRS = registerBlock("altair_stairs",
            new StairsBlock(OverwhelmedBlocks.ALTAIR.getDefaultState(), AbstractBlock.Settings.copy(ALTAIR)));
    public static final Block ALTAIR_SLAB = registerBlock("altair_slab",
            new SlabBlock(AbstractBlock.Settings.copy(ALTAIR)));
    public static final Block ALTAIR_WALL = registerBlock("altair_wall",
            new WallBlock(AbstractBlock.Settings.copy(ALTAIR)));
    public static final Block POLISHED_ALTAIR = registerBlock("polished_altair",
            new Block(AbstractBlock.Settings.copy(ALTAIR)));
    public static final Block POLISHED_ALTAIR_STAIRS = registerBlock("polished_altair_stairs",
            new StairsBlock(OverwhelmedBlocks.POLISHED_ALTAIR.getDefaultState(), AbstractBlock.Settings.copy(ALTAIR)));
    public static final Block POLISHED_ALTAIR_SLAB = registerBlock("polished_altair_slab",
            new SlabBlock(AbstractBlock.Settings.copy(ALTAIR)));

    public static final Block FIZZYROCK = registerBlock("fizzyrock",
            new Block(AbstractBlock.Settings.create()
                    .mapColor(MapColor.LIGHT_GRAY)
                    .strength(1.5F, 6.0F)
                    .instrument(Instrument.BASEDRUM)
                    .requiresTool()
                    .sounds(BlockSoundGroup.DEEPSLATE)));
    public static final Block FIZZYROCK_STAIRS = registerBlock("fizzyrock_stairs",
            new StairsBlock(OverwhelmedBlocks.FIZZYROCK.getDefaultState(), AbstractBlock.Settings.copy(FIZZYROCK)));
    public static final Block FIZZYROCK_SLAB = registerBlock("fizzyrock_slab",
            new SlabBlock(AbstractBlock.Settings.copy(FIZZYROCK)));
    public static final Block FIZZYROCK_WALL = registerBlock("fizzyrock_wall",
            new WallBlock(AbstractBlock.Settings.copy(FIZZYROCK)));
    public static final Block CHISELED_FIZZYROCK = registerBlock("chiseled_fizzyrock",
            new Block(AbstractBlock.Settings.copy(FIZZYROCK)));
    public static final Block POLISHED_FIZZYROCK = registerBlock("polished_fizzyrock",
            new Block(AbstractBlock.Settings.create()
                    .mapColor(MapColor.LIGHT_GRAY)
                    .strength(1.5F, 6.0F)
                    .instrument(Instrument.BASEDRUM)
                    .requiresTool()
                    .sounds(BlockSoundGroup.POLISHED_DEEPSLATE)));
    public static final Block POLISHED_FIZZYROCK_STAIRS = registerBlock("polished_fizzyrock_stairs",
            new StairsBlock(OverwhelmedBlocks.POLISHED_FIZZYROCK.getDefaultState(),
                    AbstractBlock.Settings.copy(POLISHED_FIZZYROCK)));
    public static final Block POLISHED_FIZZYROCK_SLAB = registerBlock("polished_fizzyrock_slab",
            new SlabBlock(AbstractBlock.Settings.copy(POLISHED_FIZZYROCK)));
    public static final Block FIZZYROCK_BRICKS = registerBlock("fizzyrock_bricks",
            new Block(AbstractBlock.Settings.create()
                    .mapColor(MapColor.LIGHT_GRAY)
                    .strength(1.5F, 6.0F)
                    .instrument(Instrument.BASEDRUM)
                    .requiresTool()
                    .sounds(BlockSoundGroup.DEEPSLATE_BRICKS)));
    public static final Block FIZZYROCK_BRICK_STAIRS = registerBlock("fizzyrock_brick_stairs",
            new StairsBlock(OverwhelmedBlocks.FIZZYROCK_BRICKS.getDefaultState(),
                    AbstractBlock.Settings.copy(FIZZYROCK_BRICKS)));
    public static final Block FIZZYROCK_BRICK_SLAB = registerBlock("fizzyrock_brick_slab",
            new SlabBlock(AbstractBlock.Settings.copy(FIZZYROCK_BRICKS)));
    public static final Block FIZZYROCK_BRICK_WALL = registerBlock("fizzyrock_brick_wall",
            new WallBlock(AbstractBlock.Settings.copy(FIZZYROCK_BRICKS)));
    public static final Block CHISELED_FIZZYROCK_BRICKS = registerBlock("chiseled_fizzyrock_bricks",
            new Block(AbstractBlock.Settings.copy(FIZZYROCK_BRICKS)));
    public static final Block FIZZYROCK_GEYSER = registerBlock("fizzyrock_geyser",
            new Block(AbstractBlock.Settings.copy(FIZZYROCK)));

    public static final Block FIRN = registerBlock("firn",
            new Block(AbstractBlock.Settings.create()
                    .mapColor(MapColor.WHITE)
                    .strength(0.5F)
                    .sounds(BlockSoundGroup.SNOW)));
    public static final Block SOIL = registerBlock("soil",
            new Block(AbstractBlock.Settings.create()
            .mapColor(MapColor.DIRT_BROWN)
            .strength(0.5F)
            .sounds(BlockSoundGroup.ROOTED_DIRT)));
    public static final Block CHARCOAL_ORE = registerBlock("charcoal_ore",
            new Block(AbstractBlock.Settings.create()
            .mapColor(MapColor.DIRT_BROWN)
            .strength(0.7F)
            .sounds(BlockSoundGroup.ROOTED_DIRT)));
    public static final Block VERDIGRAIN = registerBlock("verdigrain",
            new Block(AbstractBlock.Settings.create()
                    .mapColor(MapColor.PALE_YELLOW)
                    .strength(0.5F)
                    .sounds(BlockSoundGroup.SAND)));

    public static final Block FLOFF = registerBlock("floff",
            new FlowerBlock(StatusEffects.REGENERATION, 4, AbstractBlock.Settings.create()
                    .mapColor(MapColor.DARK_GREEN)
                    .sounds(BlockSoundGroup.GRASS)
                    .noCollision()
                    .breakInstantly()
                    .offset(AbstractBlock.OffsetType.XZ)
                    .pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block PAINE = registerBlock("paine", new FlowerBlock(StatusEffects.POISON, 8,
            AbstractBlock.Settings.copy(FLOFF)));
    public static final Block PINK_LAVATERA = registerBlock("pink_lavatera",
            new FlowerBlock(StatusEffects.POISON, 6, AbstractBlock.Settings.copy(FLOFF)));
    public static final Block WHITE_LAVATERA = registerBlock("white_lavatera",
            new FlowerBlock(StatusEffects.WEAKNESS, 5, AbstractBlock.Settings.copy(FLOFF)));
    public static final Block SQUIRL = registerBlock("squirl",
            new FlowerBlock(StatusEffects.JUMP_BOOST, 10, AbstractBlock.Settings.copy(FLOFF)));
    public static final Block RINGOT = registerBlock("ringot",
            new FlowerBlock(StatusEffects.BLINDNESS, 5, AbstractBlock.Settings.copy(FLOFF)));
    public static final Block SNOWDROP = registerBlock("snowdrop",
            new FlowerBlock(StatusEffects.WEAKNESS, 7, AbstractBlock.Settings.copy(FLOFF)));
    public static final Block BELL_SUNFLOWER = registerBlock("bell_sunflower",
            new FlowerBlock(StatusEffects.FIRE_RESISTANCE, 10, AbstractBlock.Settings.copy(FLOFF)));

    public static final Block POTTED_FLOFF = registerBlock("potted_floff",
            new FlowerPotBlock(FLOFF, AbstractBlock.Settings.create()
                    .breakInstantly()
                    .nonOpaque()
                    .pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block POTTED_PAINE = registerBlock("potted_paine",
            new FlowerPotBlock(PAINE, AbstractBlock.Settings.copy(POTTED_FLOFF)));
    public static final Block POTTED_PINK_LAVATERA = registerBlock("potted_lavatera",
            new FlowerPotBlock(PINK_LAVATERA, AbstractBlock.Settings.copy(POTTED_FLOFF)));
    public static final Block POTTED_WHITE_LAVATERA = registerBlock("potted_white_lavatera",
            new FlowerPotBlock(WHITE_LAVATERA, AbstractBlock.Settings.copy(POTTED_FLOFF)));
    public static final Block POTTED_SQUIRL = registerBlock("potted_squirl",
            new FlowerPotBlock(SQUIRL, AbstractBlock.Settings.copy(POTTED_FLOFF)));
    public static final Block POTTED_RINGOT = registerBlock("potted_ringot",
            new FlowerPotBlock(RINGOT, AbstractBlock.Settings.copy(POTTED_FLOFF)));
    public static final Block POTTED_SNOWDROP = registerBlock("potted_snowdrop",
            new FlowerPotBlock(SNOWDROP, AbstractBlock.Settings.copy(POTTED_FLOFF)));
    public static final Block POTTED_BELL_SUNFLOWER = registerBlock("potted_bell_sunflower",
            new FlowerPotBlock(BELL_SUNFLOWER, AbstractBlock.Settings.copy(POTTED_FLOFF)));

    public static final Block WIDOW = registerBlock("widow",
            new TallFlowerBlock(AbstractBlock.Settings.create()
                    .mapColor(MapColor.DARK_GREEN)
                    .noCollision()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.GRASS)
                    .offset(AbstractBlock.OffsetType.XZ)
                    .burnable()
                    .pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block WHITE_ALLIUM = registerBlock("white_allium",
            new TallFlowerBlock(AbstractBlock.Settings.copy(WIDOW)));

    public static final Block VANILLA = Registry.register(Registries.BLOCK, new Identifier(Overwhelmed.MOD_ID, "vanilla"),
            new VanillaBlock(AbstractBlock.Settings.create()
                    .mapColor(MapColor.DARK_GREEN)
                    .noCollision()
                    .ticksRandomly()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.CROP)
                    .pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block MINT = Registry.register(Registries.BLOCK, new Identifier(Overwhelmed.MOD_ID, "mint"),
            new MintBlock(AbstractBlock.Settings.copy(VANILLA)));

    public static final Block GOLD_BEAD = registerClotBlock("gold_bead",
            new ClotBlock(AbstractBlock.Settings.create()
                    .noCollision()
                    .breakInstantly()
                    .offset(AbstractBlock.OffsetType.XZ)
                    .pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block ICE_CUBE = registerClotBlock("ice_cube",
            new ClotBlock(AbstractBlock.Settings.copy(GOLD_BEAD)));
    public static final Block PEBBLE = registerPebbleBlock("pebble",
            new ClotBlock(AbstractBlock.Settings.copy(GOLD_BEAD)));

    public static final Block PAPER_NEST = registerBlock("paper_nest",
            new Block(AbstractBlock.Settings.create()
                    .mapColor(MapColor.YELLOW)
                    .instrument(Instrument.BASS)
                    .strength(0.3F)
                    .sounds(BlockSoundGroup.WOOD)
                    .burnable()));

    public static final Block GOO_BLOCK = registerBlock("goo_block",
            new GooBlock(AbstractBlock.Settings.create()
                    .mapColor(MapColor.PALE_YELLOW)
                    .velocityMultiplier(0.4F)
                    .jumpVelocityMultiplier(0.5F)
                    .nonOpaque()
                    .sounds(OverwhelmedSounds.GOO_BLOCK)));


    public static final Block VANILLA_CAKE = registerBlock("vanilla_cake",
            new VanillaCakeBlock(AbstractBlock.Settings.create()
                    .solid()
                    .strength(0.5F)
                    .sounds(BlockSoundGroup.WOOL)
                    .pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block MINT_CAKE = registerBlock("mint_cake",
            new MintCakeBlock(AbstractBlock.Settings.create()
                    .solid()
                    .strength(0.5f)
                    .sounds(BlockSoundGroup.WOOL)
                    .pistonBehavior(PistonBehavior.DESTROY)));



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