package endurteam.overwhelmed.block.entity;

import endurteam.overwhelmed.Overwhelmed;
import endurteam.overwhelmed.block.OverwhelmedBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.HangingSignBlockEntity;
import net.minecraft.block.entity.SignBlockEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class OverwhelmedBlockEntities {

    public static final BlockEntityType<SignBlockEntity> SIGN_BLOCK_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE,
            new Identifier(Overwhelmed.MOD_ID, "sign_entity"),
            FabricBlockEntityTypeBuilder.create(SignBlockEntity::new,
                    OverwhelmedBlocks.WILLOW_SIGN, OverwhelmedBlocks.WILLOW_WALL_SIGN).build());
    public static final BlockEntityType<HangingSignBlockEntity> HANGING_SIGN_BLOCK_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(Overwhelmed.MOD_ID, "hanging_sign_entity"),
            FabricBlockEntityTypeBuilder.create(HangingSignBlockEntity::new,
                    OverwhelmedBlocks.WILLOW_HANGING_SIGN, OverwhelmedBlocks.WILLOW_HANGING_WALL_SIGN).build());

    public static void registerBlockEntities() {}

}
