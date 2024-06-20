package endurteam.overwhelmed.worldgen;

import endurteam.overwhelmed.Overwhelmed;
import endurteam.overwhelmed.block.OverwhelmedBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.util.dynamic.Range;
import net.minecraft.util.math.noise.DoublePerlinNoiseSampler;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;
import net.minecraft.world.gen.stateprovider.DualNoiseBlockStateProvider;
import net.minecraft.world.gen.stateprovider.NoiseBlockStateProvider;

import java.util.List;

public class OverwhelmedFlowerPlacedFeatures {
    public static final RegistryKey<PlacedFeature> FLOWER_FLOWER_FOREST = key("flower_flower_forest");
    public static final RegistryKey<PlacedFeature> FLOWER_MEADOW = key("flower_meadow");

    public static void bootstrap(Registerable<PlacedFeature> registerable) {
        RegistryEntryLookup<ConfiguredFeature<?, ?>> registryEntryLookup = registerable.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(registerable,
                FLOWER_FLOWER_FOREST,
                registryEntryLookup.getOrThrow(OverwhelmedFlowerConfiguredFeatures.FLOWER_FLOWER_FOREST),
                CountPlacementModifier.of(3),
                RarityFilterPlacementModifier.of(2),
                SquarePlacementModifier.of(),
                PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                BiomePlacementModifier.of());

        register(registerable,
                FLOWER_MEADOW,
                registryEntryLookup.getOrThrow(OverwhelmedFlowerConfiguredFeatures.FLOWER_MEADOW),
                SquarePlacementModifier.of(),
                PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                BiomePlacementModifier.of());
    }

    public static RegistryKey<PlacedFeature> key(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(Overwhelmed.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> registerable, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration, PlacementModifier... modifiers) {
        registerable.register(key, new PlacedFeature(configuration, List.of(modifiers)));
    }
}
