package endurteam.overwhelmed;

import endurteam.overwhelmed.datagen.*;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
public class OverwhelmedDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(OverwhelmedBlockTagProvider::new);
		pack.addProvider(OverwhelmedItemTagProvider::new);
		pack.addProvider(OverwhelmedLootTableProvider::new);
		pack.addProvider(OverwhelmedModelProvider::new);
		pack.addProvider(OverwhelmedRecipeProvider::new);
	}
}