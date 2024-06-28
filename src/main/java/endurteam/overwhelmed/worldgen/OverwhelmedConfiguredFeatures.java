package endurteam.overwhelmed.worldgen;

import endurteam.overwhelmed.Overwhelmed;
import endurteam.overwhelmed.block.OverwhelmedBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.dynamic.Range;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.noise.DoublePerlinNoiseSampler;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.*;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;

public class OverwhelmedConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> FLOWER_FLOWER_FOREST = key("flower_flower_forest");
    public static final RegistryKey<ConfiguredFeature<?, ?>> FLOWER_MEADOW = key("flower_meadow");
    public static final RegistryKey<ConfiguredFeature<?, ?>> FLOWER_TAIGA = key("flower_taiga");
    public static final RegistryKey<ConfiguredFeature<?, ?>> FLOWER_SNOWY_TAIGA = key("flower_snowy_taiga");
    public static final RegistryKey<ConfiguredFeature<?, ?>> FLOWER_OLD_GROWTH_PINE_TAIGA = key("flower_old_growth_pine_taiga");
    public static final RegistryKey<ConfiguredFeature<?, ?>> FLOWER_OLD_GROWTH_SPRUCE_TAIGA = key("flower_old_growth_spruce_taiga");
    public static final RegistryKey<ConfiguredFeature<?, ?>> FLOWER_SUNFLOWER_PLAINS = key("flower_sunflower_plains");
    public static final RegistryKey<ConfiguredFeature<?, ?>> FLOWER_PLAINS = key("flower_plains");
    public static final RegistryKey<ConfiguredFeature<?, ?>> FLOWER_SNOWY_PLAINS = key("flower_snowy_plains");
    public static final RegistryKey<ConfiguredFeature<?, ?>> FLOWER_GROVE = key("flower_grove");
    public static final RegistryKey<ConfiguredFeature<?, ?>> FLOWER_DARK_FOREST = key("flower_dark_forest");
    public static final RegistryKey<ConfiguredFeature<?, ?>> FLOWER_BEACH = key("flower_beach");
    public static final RegistryKey<ConfiguredFeature<?, ?>> FLOWER_SNOWY_BEACH = key("flower_snowy_beach");

    public static final RegistryKey<ConfiguredFeature<?, ?>> CLOT_PEBBLE = key("clot_pebble");
    public static final RegistryKey<ConfiguredFeature<?, ?>> CLOT_ICE_CUBE = key("clot_ice_cube");
    public static final RegistryKey<ConfiguredFeature<?, ?>> CLOT_GOLD_BEAD = key("clot_gold_bead");

    public static final RegistryKey<ConfiguredFeature<?, ?>> WILLOW_KEY = key("willow");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> registerable) {
        registerSimpleFlowerFeature(registerable,
                FLOWER_FLOWER_FOREST,
                OverwhelmedBlocks.WHITE_ALLIUM.getDefaultState(),
                OverwhelmedBlocks.BELL_SUNFLOWER.getDefaultState(),
                OverwhelmedBlocks.FLOFF.getDefaultState(),
                OverwhelmedBlocks.PINK_LAVATERA.getDefaultState(),
                OverwhelmedBlocks.WHITE_LAVATERA.getDefaultState());

        register(registerable,
                FLOWER_MEADOW,
                Feature.FLOWER,
                new RandomPatchFeatureConfig(
                        48,
                        6,
                        2,
                        PlacedFeatures.createEntry(
                                Feature.SIMPLE_BLOCK,
                                new SimpleBlockFeatureConfig(
                                        new DualNoiseBlockStateProvider(
                                                new Range<>(1, 3),
                                                new DoublePerlinNoiseSampler.NoiseParameters(
                                                        -10,
                                                        1.0),
                                                1.0f,
                                                2345L,
                                                new DoublePerlinNoiseSampler.NoiseParameters(
                                                        -3,
                                                        1.0),
                                                1.0f,
                                                List.of(
                                                        OverwhelmedBlocks.WHITE_ALLIUM.getDefaultState(),
                                                        OverwhelmedBlocks.FLOFF.getDefaultState()))))));

        registerSimpleFlowerFeature(registerable,
                FLOWER_TAIGA,
                OverwhelmedBlocks.FLOFF.getDefaultState(),
                OverwhelmedBlocks.SQUIRL.getDefaultState(),
                OverwhelmedBlocks.RINGOT.getDefaultState());

        registerSimpleFlowerFeature(registerable,
                FLOWER_SNOWY_TAIGA,
                OverwhelmedBlocks.PAINE.getDefaultState(),
                OverwhelmedBlocks.SNOWDROP.getDefaultState());

        registerSimpleFlowerFeature(registerable,
                FLOWER_OLD_GROWTH_PINE_TAIGA,
                OverwhelmedBlocks.FLOFF.getDefaultState(),
                OverwhelmedBlocks.PAINE.getDefaultState(),
                OverwhelmedBlocks.SQUIRL.getDefaultState(),
                OverwhelmedBlocks.RINGOT.getDefaultState());

        registerSimpleFlowerFeature(registerable,
                FLOWER_OLD_GROWTH_SPRUCE_TAIGA,
                OverwhelmedBlocks.FLOFF.getDefaultState(),
                OverwhelmedBlocks.PAINE.getDefaultState(),
                OverwhelmedBlocks.SQUIRL.getDefaultState(),
                OverwhelmedBlocks.RINGOT.getDefaultState());

        registerSimpleFlowerFeature(registerable,
                FLOWER_SUNFLOWER_PLAINS,
                OverwhelmedBlocks.BELL_SUNFLOWER.getDefaultState());

        registerSimpleFlowerFeature(registerable,
                FLOWER_PLAINS,
                OverwhelmedBlocks.BELL_SUNFLOWER.getDefaultState());

        registerSimpleFlowerFeature(registerable,
                FLOWER_SNOWY_PLAINS,
                OverwhelmedBlocks.PAINE.getDefaultState(),
                OverwhelmedBlocks.SNOWDROP.getDefaultState());

        registerSimpleFlowerFeature(registerable,
                FLOWER_GROVE,
                OverwhelmedBlocks.PAINE.getDefaultState(),
                OverwhelmedBlocks.SNOWDROP.getDefaultState());

        register(registerable,
                FLOWER_DARK_FOREST,
                Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(OverwhelmedBlocks.WIDOW)));

        registerSimpleFlowerFeature(registerable,
                FLOWER_BEACH,
                OverwhelmedBlocks.WHITE_LAVATERA.getDefaultState(),
                OverwhelmedBlocks.PINK_LAVATERA.getDefaultState());

        registerSimpleFlowerFeature(registerable,
                FLOWER_SNOWY_BEACH,
                OverwhelmedBlocks.WHITE_LAVATERA.getDefaultState(),
                OverwhelmedBlocks.PINK_LAVATERA.getDefaultState());

        registerClotFeature(registerable,
                CLOT_PEBBLE,
                OverwhelmedBlocks.PEBBLE.getDefaultState());

        registerClotFeature(registerable,
                CLOT_ICE_CUBE,
                OverwhelmedBlocks.ICE_CUBE.getDefaultState());

        registerClotFeature(registerable,
                CLOT_GOLD_BEAD,
                OverwhelmedBlocks.GOLD_BEAD.getDefaultState());

        register(registerable, WILLOW_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(OverwhelmedBlocks.WILLOW_LOG),
                new StraightTrunkPlacer(5, 4, 3),

                BlockStateProvider.of(OverwhelmedBlocks.WILLOW_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(1), 2),

                new TwoLayersFeatureSize(1, 0, 2)).build());
    }

    // Registers a simple flower feature
    private static void registerSimpleFlowerFeature(Registerable<ConfiguredFeature<?, ?>> registerable, RegistryKey<ConfiguredFeature<?, ? >> key, BlockState... states) {
        register(registerable,
                key,
                Feature.FLOWER,
                new RandomPatchFeatureConfig(
                        50,
                        6,
                        2,
                        PlacedFeatures.createEntry(
                                Feature.SIMPLE_BLOCK,
                                new SimpleBlockFeatureConfig(
                                        new NoiseBlockStateProvider(
                                                2345L,
                                                new DoublePerlinNoiseSampler.NoiseParameters(
                                                        0,
                                                        1.0),
                                                0.020833334f,
                                                List.of(states))))));
    }

    private static void registerClotFeature(Registerable<ConfiguredFeature<?, ?>> registerable, RegistryKey<ConfiguredFeature<?, ?>> key, BlockState state) {
        register(registerable,
                key,
                Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(state)));
    }

    private static RegistryKey<ConfiguredFeature<?, ?>> key(String id) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(Overwhelmed.MOD_ID, id));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> registerable, RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        registerable.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
