package endurteam.overwhelmed.worldgen;

import endurteam.overwhelmed.Overwhelmed;
import endurteam.overwhelmed.block.OverwhelmedBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.dynamic.Range;
import net.minecraft.util.math.noise.DoublePerlinNoiseSampler;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.DualNoiseBlockStateProvider;
import net.minecraft.world.gen.stateprovider.NoiseBlockStateProvider;

import java.util.List;

public class OverwhelmedFlowerConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> FLOWER_FLOWER_FOREST = key("flower_flower_forest");
    public static final RegistryKey<ConfiguredFeature<?, ?>> FLOWER_MEADOW = key("flower_meadow");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> registerable) {
        register(registerable,
                FLOWER_FLOWER_FOREST,
                Feature.FLOWER,
                new RandomPatchFeatureConfig(
                        96,
                        6,
                        2,
                        PlacedFeatures.createEntry(
                                Feature.SIMPLE_BLOCK,
                                new SimpleBlockFeatureConfig(
                                        new NoiseBlockStateProvider(
                                                2345L,
                                                new DoublePerlinNoiseSampler.NoiseParameters(
                                                        0,
                                                        1.0,
                                                        new double[0]),
                                                0.020833334f,
                                                List.of(
                                                        OverwhelmedBlocks.WHITE_ALLIUM.getDefaultState()
                                                ))))));
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
                                                new Range<Integer>(1, 3),
                                                new DoublePerlinNoiseSampler.NoiseParameters(
                                                        -10,
                                                        1.0,
                                                        new double[0]),
                                                1.0f,
                                                2345L,
                                                new DoublePerlinNoiseSampler.NoiseParameters(
                                                        -3,
                                                        1.0,
                                                        new double[0]),
                                                1.0f,
                                                List.of(
                                                        OverwhelmedBlocks.WHITE_ALLIUM.getDefaultState()
                                                ))))));
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> key(String id) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(Overwhelmed.MOD_ID, id));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> registerable, RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        registerable.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
