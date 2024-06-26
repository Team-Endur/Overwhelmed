package endurteam.overwhelmed;

import endurteam.overwhelmed.datagen.*;
import endurteam.overwhelmed.worldgen.OverwhelmedConfiguredFeatures;
import endurteam.overwhelmed.worldgen.OverwhelmedPlacedFeatures;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class OverwhelmedDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(OverwhelmedBlockTagProvider::new);
		pack.addProvider(OverwhelmedItemTagProvider::new);
		pack.addProvider(OverwhelmedLootTableProvider::new);
		pack.addProvider(OverwhelmedModelProvider::new);
		pack.addProvider(OverwhelmedRecipeProvider::new);
		pack.addProvider(OverwhelmedWorldGen::new);
	}

	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {
		registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, OverwhelmedConfiguredFeatures::bootstrap);
		registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, OverwhelmedPlacedFeatures::bootstrap);
	}
}