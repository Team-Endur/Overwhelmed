package endurteam.overwhelmed.worldgen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;

public class OverwhelmedBiomeModifications {
    public static void addFeatures() {
        addFeature(OverwhelmedFlowerPlacedFeatures.FLOWER_FLOWER_FOREST, BiomeKeys.FLOWER_FOREST);
        addFeature(OverwhelmedFlowerPlacedFeatures.FLOWER_MEADOW, BiomeKeys.MEADOW);
        addFeature(OverwhelmedFlowerPlacedFeatures.FLOWER_TAIGA, BiomeKeys.TAIGA);
        addFeature(OverwhelmedFlowerPlacedFeatures.FLOWER_SNOWY_TAIGA, BiomeKeys.SNOWY_TAIGA);
        addFeature(OverwhelmedFlowerPlacedFeatures.FLOWER_OLD_GROWTH_PINE_TAIGA, BiomeKeys.OLD_GROWTH_PINE_TAIGA);
        addFeature(OverwhelmedFlowerPlacedFeatures.FLOWER_OLD_GROWTH_SPRUCE_TAIGA, BiomeKeys.OLD_GROWTH_SPRUCE_TAIGA);
        addFeature(OverwhelmedFlowerPlacedFeatures.FLOWER_SUNFLOWER_PLAINS, BiomeKeys.SUNFLOWER_PLAINS);
        addFeature(OverwhelmedFlowerPlacedFeatures.FLOWER_PLAINS, BiomeKeys.PLAINS);
        addFeature(OverwhelmedFlowerPlacedFeatures.FLOWER_SNOWY_PLAINS, BiomeKeys.SNOWY_PLAINS);
        addFeature(OverwhelmedFlowerPlacedFeatures.FLOWER_GROVE, BiomeKeys.GROVE);
        addFeature(OverwhelmedFlowerPlacedFeatures.FLOWER_DARK_FOREST, BiomeKeys.DARK_FOREST);
        addFeature(OverwhelmedFlowerPlacedFeatures.FLOWER_SNOWY_BEACH, BiomeKeys.SNOWY_BEACH);
        addFeature(OverwhelmedFlowerPlacedFeatures.FLOWER_BEACH, BiomeKeys.BEACH);
    }

    private static void addFeature(RegistryKey<PlacedFeature> feature, RegistryKey<Biome>... tags) {
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(tags),
                GenerationStep.Feature.VEGETAL_DECORATION,
                feature);
    }
}
