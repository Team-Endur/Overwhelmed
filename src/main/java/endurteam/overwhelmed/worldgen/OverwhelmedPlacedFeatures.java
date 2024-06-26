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

public class OverwhelmedPlacedFeatures {
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

    public static final RegistryKey<PlacedFeature> CLOT_PEBBLE = key("clot_pebble");
    public static final RegistryKey<PlacedFeature> CLOT_ICE_CUBE = key("clot_ice_cube");
    public static final RegistryKey<PlacedFeature> CLOT_GOLD_BEAD = key("clot_gold_bead");

    public static void bootstrap(Registerable<PlacedFeature> registerable) {
        RegistryEntryLookup<ConfiguredFeature<?, ?>> registryEntryLookup = registerable.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(registerable,
                FLOWER_FLOWER_FOREST,
                registryEntryLookup.getOrThrow(OverwhelmedConfiguredFeatures.FLOWER_FLOWER_FOREST),
                CountPlacementModifier.of(3),
                RarityFilterPlacementModifier.of(2),
                SquarePlacementModifier.of(),
                PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                BiomePlacementModifier.of());

        register(registerable,
                FLOWER_MEADOW,
                registryEntryLookup.getOrThrow(OverwhelmedConfiguredFeatures.FLOWER_MEADOW),
                SquarePlacementModifier.of(),
                PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                BiomePlacementModifier.of());

        registerSimpleFlowerFeature(registerable, FLOWER_TAIGA, OverwhelmedConfiguredFeatures.FLOWER_TAIGA);
        registerSimpleFlowerFeature(registerable, FLOWER_SNOWY_TAIGA, OverwhelmedConfiguredFeatures.FLOWER_SNOWY_TAIGA);
        registerSimpleFlowerFeature(registerable, FLOWER_OLD_GROWTH_PINE_TAIGA, OverwhelmedConfiguredFeatures.FLOWER_OLD_GROWTH_PINE_TAIGA);
        registerSimpleFlowerFeature(registerable, FLOWER_OLD_GROWTH_SPRUCE_TAIGA, OverwhelmedConfiguredFeatures.FLOWER_OLD_GROWTH_SPRUCE_TAIGA);
        registerSimpleFlowerFeature(registerable, FLOWER_SUNFLOWER_PLAINS, OverwhelmedConfiguredFeatures.FLOWER_SUNFLOWER_PLAINS);
        registerSimpleFlowerFeature(registerable, FLOWER_PLAINS, OverwhelmedConfiguredFeatures.FLOWER_PLAINS);
        registerSimpleFlowerFeature(registerable, FLOWER_SNOWY_PLAINS, OverwhelmedConfiguredFeatures.FLOWER_SNOWY_PLAINS);
        registerSimpleFlowerFeature(registerable, FLOWER_GROVE, OverwhelmedConfiguredFeatures.FLOWER_GROVE);
        registerSimpleFlowerFeature(registerable, FLOWER_DARK_FOREST, OverwhelmedConfiguredFeatures.FLOWER_DARK_FOREST);
        registerSimpleFlowerFeature(registerable, FLOWER_BEACH, OverwhelmedConfiguredFeatures.FLOWER_BEACH);
        registerSimpleFlowerFeature(registerable, FLOWER_SNOWY_BEACH, OverwhelmedConfiguredFeatures.FLOWER_SNOWY_BEACH);

        registerClotFeature(registerable, CLOT_PEBBLE, OverwhelmedConfiguredFeatures.CLOT_PEBBLE);
        registerClotFeature(registerable, CLOT_ICE_CUBE, OverwhelmedConfiguredFeatures.CLOT_ICE_CUBE);
        registerClotFeature(registerable, CLOT_GOLD_BEAD, OverwhelmedConfiguredFeatures.CLOT_GOLD_BEAD);
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

    private static void registerClotFeature(Registerable<PlacedFeature> registerable, RegistryKey<PlacedFeature> key, RegistryKey<ConfiguredFeature<?, ?>> configuredFeatureKey) {
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
