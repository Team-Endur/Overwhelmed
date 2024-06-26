package endurteam.overwhelmed;

import endurteam.overwhelmed.block.OverwhelmedBlocks;
import endurteam.overwhelmed.entity.*;
import endurteam.overwhelmed.item.OverwhelmedCreativeTabs;
import endurteam.overwhelmed.item.OverwhelmedItems;
import endurteam.overwhelmed.sound.OverwhelmedSounds;
import endurteam.overwhelmed.worldgen.OverwhelmedBiomeModifications;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Overwhelmed implements ModInitializer {
	public static final String MOD_ID = "overwhelmed";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final RegistryKey<PlacedFeature> ALTAIR_ORE_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE,
			new Identifier("overwhelmed","ore_altair"));

	@Override
	public void onInitialize() {
		OverwhelmedCreativeTabs.registerItemTabs();
		OverwhelmedItems.registerItems();
		OverwhelmedBlocks.registerBlocks();
		OverwhelmedSounds.registerSounds();
		OverwhelmedBoats.registerBoats();

		StrippableBlockRegistry.register(OverwhelmedBlocks.WILLOW_LOG, OverwhelmedBlocks.STRIPPED_WILLOW_LOG);
		StrippableBlockRegistry.register(OverwhelmedBlocks.WILLOW_WOOD, OverwhelmedBlocks.STRIPPED_WILLOW_WOOD);
		FlammableBlockRegistry.getDefaultInstance().add(OverwhelmedBlocks.WILLOW_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(OverwhelmedBlocks.WILLOW_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(OverwhelmedBlocks.STRIPPED_WILLOW_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(OverwhelmedBlocks.STRIPPED_WILLOW_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(OverwhelmedBlocks.WILLOW_PLANKS, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(OverwhelmedBlocks.WILLOW_LEAVES, 30, 60);

		FabricDefaultAttributeRegistry.register(OverwhelmedEntities.BUTTERFLY, ButterflyEntity.createButterflyAttributes());
		FabricDefaultAttributeRegistry.register(OverwhelmedEntities.SNAIL, SnailEntity.createSnailAttributes());
		FabricDefaultAttributeRegistry.register(OverwhelmedEntities.MOTH, MothEntity.createMothAttributes());
		FabricDefaultAttributeRegistry.register(OverwhelmedEntities.HORNET, HornetEntity.createHornetAttributes());

		BiomeModifications.addFeature(BiomeSelectors.tag(BiomeTags.IS_MOUNTAIN),
				GenerationStep.Feature.UNDERGROUND_ORES, ALTAIR_ORE_PLACED_KEY);
		OverwhelmedBiomeModifications.addFeatures();

	}
}