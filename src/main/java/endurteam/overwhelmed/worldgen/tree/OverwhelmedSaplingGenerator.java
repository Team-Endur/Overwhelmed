package endurteam.overwhelmed.worldgen.tree;

import endurteam.overwhelmed.Overwhelmed;
import endurteam.overwhelmed.worldgen.OverwhelmedConfiguredFeatures;
import net.minecraft.block.SaplingGenerator;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.TreeConfiguredFeatures;

import java.util.Optional;

public class OverwhelmedSaplingGenerator {

    public static final SaplingGenerator WILLOW;


    public SaplingGenerator register(String name, Optional<RegistryKey<ConfiguredFeature<?, ?>>> megaVariant, Optional<RegistryKey<ConfiguredFeature<?, ?>>> regularVariant, Optional<RegistryKey<ConfiguredFeature<?, ?>>> beesVariant){
        return new SaplingGenerator(name, megaVariant, regularVariant, beesVariant);
    }
    static {
        WILLOW = new SaplingGenerator("willow", Optional.empty(), Optional.of(OverwhelmedConfiguredFeatures.WILLOW_KEY), Optional.empty());
    }
}
