package endurteam.overwhelmed.worldgen;

import endurteam.overwhelmed.Overwhelmed;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class OverwhelmedFlowerPlacedFeatures {
    public static final RegistryKey<PlacedFeature> FLOWER_FLOWER_FOREST = key("flower_flower_forest");
    public static final RegistryKey<PlacedFeature> FLOWER_MEADOW = key("flower_meadow");
    public static final RegistryKey<PlacedFeature> FLOWER_TAIGA = key("flower_taiga");
    public static final RegistryKey<PlacedFeature> FLOWER_SNOWY_TAIGA = key("flower_snowy_taiga");
    public static final RegistryKey<PlacedFeature> FLOWER_OLD_GROWTH_PINE_TAIGA = key("flower_old_growth_pine_taiga");
    public static final RegistryKey<PlacedFeature> FLOWER_OLD_GROWTH_SPRUCE_TAIGA = key("flower_old_growth_spruce_taiga");
    public static final RegistryKey<PlacedFeature> FLOWER_SUNFLOWER_PLAINS = key("flower_sunflower_plains");
    public static final RegistryKey<PlacedFeature> FLOWER_PLAINS = key("flower_plains");
    public static final RegistryKey<PlacedFeature> FLOWER_SNOWY_PLAINS = key("flower_snowy_plains");
    public static final RegistryKey<PlacedFeature> FLOWER_GROVE = key("flower_grove");
    public static final RegistryKey<PlacedFeature> FLOWER_DARK_FOREST = key("flower_dark_forest");
    public static final RegistryKey<PlacedFeature> FLOWER_BEACH = key("flower_beach");
    public static final RegistryKey<PlacedFeature> FLOWER_SNOWY_BEACH = key("flower_snowy_beach");

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

        registerSimpleFlowerFeature(registerable, FLOWER_TAIGA, OverwhelmedFlowerConfiguredFeatures.FLOWER_TAIGA);
        registerSimpleFlowerFeature(registerable, FLOWER_SNOWY_TAIGA, OverwhelmedFlowerConfiguredFeatures.FLOWER_SNOWY_TAIGA);
        registerSimpleFlowerFeature(registerable, FLOWER_OLD_GROWTH_PINE_TAIGA, OverwhelmedFlowerConfiguredFeatures.FLOWER_OLD_GROWTH_PINE_TAIGA);
        registerSimpleFlowerFeature(registerable, FLOWER_OLD_GROWTH_SPRUCE_TAIGA, OverwhelmedFlowerConfiguredFeatures.FLOWER_OLD_GROWTH_SPRUCE_TAIGA);
        registerSimpleFlowerFeature(registerable, FLOWER_SUNFLOWER_PLAINS, OverwhelmedFlowerConfiguredFeatures.FLOWER_SUNFLOWER_PLAINS);
        registerSimpleFlowerFeature(registerable, FLOWER_PLAINS, OverwhelmedFlowerConfiguredFeatures.FLOWER_PLAINS);
        registerSimpleFlowerFeature(registerable, FLOWER_SNOWY_PLAINS, OverwhelmedFlowerConfiguredFeatures.FLOWER_SNOWY_PLAINS);
        registerSimpleFlowerFeature(registerable, FLOWER_GROVE, OverwhelmedFlowerConfiguredFeatures.FLOWER_GROVE);
        registerSimpleFlowerFeature(registerable, FLOWER_DARK_FOREST, OverwhelmedFlowerConfiguredFeatures.FLOWER_DARK_FOREST);
        registerSimpleFlowerFeature(registerable, FLOWER_BEACH, OverwhelmedFlowerConfiguredFeatures.FLOWER_BEACH);
        registerSimpleFlowerFeature(registerable, FLOWER_SNOWY_BEACH, OverwhelmedFlowerConfiguredFeatures.FLOWER_SNOWY_BEACH);
    }

    private static void registerSimpleFlowerFeature(Registerable<PlacedFeature> registerable, RegistryKey<PlacedFeature> key, RegistryKey<ConfiguredFeature<?, ?>> configuredFeatureKey) {
        register(registerable,
                key,
                registerable.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE).getOrThrow(configuredFeatureKey),
                CountPlacementModifier.of(2),
                SquarePlacementModifier.of(),
                PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                BiomePlacementModifier.of());
    }

    private static RegistryKey<PlacedFeature> key(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(Overwhelmed.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> registerable, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration, PlacementModifier... modifiers) {
        registerable.register(key, new PlacedFeature(configuration, List.of(modifiers)));
    }
}
