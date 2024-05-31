package endurteam.overwhelmed.datagen;

import endurteam.overwhelmed.entity.OverwhelmedEntities;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.entity.EntityType;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class OverwhelmedEntityTypeTagProvider extends FabricTagProvider.EntityTypeTagProvider {

    public static final TagKey<EntityType<?>> HORNET_PREY = TagKey.of(RegistryKeys.ENTITY_TYPE, new Identifier("overwhelmed:hornet_prey"));

    public OverwhelmedEntityTypeTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(HORNET_PREY)
                .add(EntityType.SPIDER)
                .add(EntityType.CAVE_SPIDER)
                .add(EntityType.BEE)
//                .add(OverwhelmedEntities.SNAIL)
                .add(EntityType.RABBIT);
    }
}
