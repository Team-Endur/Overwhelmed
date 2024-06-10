package endurteam.overwhelmed.entity;

import endurteam.overwhelmed.block.OverwhelmedBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.SignBlockEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class OverwhelmedBlockEntityType<T extends BlockEntityType> {

    public static final BlockEntityType<SignBlockEntity> SIGN = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            new Identifier("overwhelmed", "sign"),
            FabricBlockEntityTypeBuilder.create(SignBlockEntity::new, OverwhelmedBlocks.WILLOW_SIGN).build());

}
