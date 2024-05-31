package endurteam.overwhelmed;

import endurteam.overwhelmed.block.OverwhelmedBlocks;
import endurteam.overwhelmed.entity.HornetEntity;
import endurteam.overwhelmed.entity.OverwhelmedEntities;
import endurteam.overwhelmed.item.OverwhelmedCreativeTabs;
import endurteam.overwhelmed.item.OverwhelmedItems;
import endurteam.overwhelmed.sound.OverwhelmedSounds;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;

public class Overwhelmed implements ModInitializer {
	public static final String MOD_ID = "overwhelmed";

	@Override
	public void onInitialize() {
		OverwhelmedCreativeTabs.registerItemTabs();
		OverwhelmedItems.registerItems();
		OverwhelmedBlocks.registerBlocks();
		OverwhelmedSounds.registerSounds();

		StrippableBlockRegistry.register(OverwhelmedBlocks.WILLOW_LOG, OverwhelmedBlocks.STRIPPED_WILLOW_LOG);
		StrippableBlockRegistry.register(OverwhelmedBlocks.WILLOW_WOOD, OverwhelmedBlocks.STRIPPED_WILLOW_WOOD);
		FlammableBlockRegistry.getDefaultInstance().add(OverwhelmedBlocks.WILLOW_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(OverwhelmedBlocks.WILLOW_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(OverwhelmedBlocks.STRIPPED_WILLOW_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(OverwhelmedBlocks.STRIPPED_WILLOW_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(OverwhelmedBlocks.WILLOW_PLANKS, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(OverwhelmedBlocks.WILLOW_LEAVES, 30, 60);

		FabricDefaultAttributeRegistry.register(OverwhelmedEntities.HORNET, HornetEntity.createHornetAttributes());

	}
}