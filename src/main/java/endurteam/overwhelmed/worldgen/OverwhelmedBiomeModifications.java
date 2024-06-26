package endurteam.overwhelmed.worldgen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;

import java.util.function.Predicate;

public class OverwhelmedBiomeModifications {
    public static void addFeatures() {
        addVegetalFeature(OverwhelmedPlacedFeatures.FLOWER_FLOWER_FOREST, BiomeKeys.FLOWER_FOREST);
        addVegetalFeature(OverwhelmedPlacedFeatures.FLOWER_MEADOW, BiomeKeys.MEADOW);
        addVegetalFeature(OverwhelmedPlacedFeatures.FLOWER_TAIGA, BiomeKeys.TAIGA);
        addVegetalFeature(OverwhelmedPlacedFeatures.FLOWER_SNOWY_TAIGA, BiomeKeys.SNOWY_TAIGA);
        addVegetalFeature(OverwhelmedPlacedFeatures.FLOWER_OLD_GROWTH_PINE_TAIGA, BiomeKeys.OLD_GROWTH_PINE_TAIGA);
        addVegetalFeature(OverwhelmedPlacedFeatures.FLOWER_OLD_GROWTH_SPRUCE_TAIGA, BiomeKeys.OLD_GROWTH_SPRUCE_TAIGA);
        addVegetalFeature(OverwhelmedPlacedFeatures.FLOWER_SUNFLOWER_PLAINS, BiomeKeys.SUNFLOWER_PLAINS);
        addVegetalFeature(OverwhelmedPlacedFeatures.FLOWER_PLAINS, BiomeKeys.PLAINS);
        addVegetalFeature(OverwhelmedPlacedFeatures.FLOWER_SNOWY_PLAINS, BiomeKeys.SNOWY_PLAINS);
        addVegetalFeature(OverwhelmedPlacedFeatures.FLOWER_GROVE, BiomeKeys.GROVE);
        addVegetalFeature(OverwhelmedPlacedFeatures.FLOWER_DARK_FOREST, BiomeKeys.DARK_FOREST);
        addVegetalFeature(OverwhelmedPlacedFeatures.FLOWER_SNOWY_BEACH, BiomeKeys.SNOWY_BEACH);
        addVegetalFeature(OverwhelmedPlacedFeatures.FLOWER_BEACH, BiomeKeys.BEACH);

        addClotFeature(OverwhelmedPlacedFeatures.CLOT_PEBBLE, BiomeSelectors.excludeByKey(
                BiomeKeys.BADLANDS,
                BiomeKeys.SNOWY_BEACH,
                BiomeKeys.SNOWY_PLAINS,
                BiomeKeys.SNOWY_TAIGA,
                BiomeKeys.SNOWY_SLOPES,
                BiomeKeys.GROVE,
                BiomeKeys.FROZEN_OCEAN,
                BiomeKeys.FROZEN_PEAKS,
                BiomeKeys.DEEP_FROZEN_OCEAN,
                BiomeKeys.JAGGED_PEAKS,
                BiomeKeys.ICE_SPIKES
        ));

        addClotFeature(OverwhelmedPlacedFeatures.CLOT_ICE_CUBE, BiomeSelectors.tag(BiomeTags.SPAWNS_SNOW_FOXES));
        addClotFeature(OverwhelmedPlacedFeatures.CLOT_GOLD_BEAD, BiomeSelectors.tag(BiomeTags.IS_BADLANDS));
    }

    private static void addVegetalFeature(RegistryKey<PlacedFeature> feature, RegistryKey<Biome>... tags) {
        addVegetalFeature(feature, BiomeSelectors.includeByKey(tags));
    }

    private static void addVegetalFeature(RegistryKey<PlacedFeature> feature, Predicate<BiomeSelectionContext> biomeSelection) {
        BiomeModifications.addFeature(biomeSelection,
                GenerationStep.Feature.VEGETAL_DECORATION,
                feature);
    }

    private static void addClotFeature(RegistryKey<PlacedFeature> feature, Predicate<BiomeSelectionContext> biomeSelection) {
        BiomeModifications.addFeature(biomeSelection,
                GenerationStep.Feature.VEGETAL_DECORATION,
                feature);
    }
}
