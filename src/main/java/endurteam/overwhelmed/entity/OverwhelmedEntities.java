package endurteam.overwhelmed.entity;

import endurteam.overwhelmed.Overwhelmed;
import endurteam.overwhelmed.entity.projectile.PebbleProjectileEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.Heightmap;

public class OverwhelmedEntities {

    public static final EntityType<PebbleProjectileEntity> PEBBLE_PROJECTILE = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(Overwhelmed.MOD_ID, "pebble_projectile"),
            FabricEntityTypeBuilder.<PebbleProjectileEntity>create(SpawnGroup.MISC, PebbleProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F)).build());

    public static final EntityType<ButterflyEntity> BUTTERFLY = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(Overwhelmed.MOD_ID, "butterfly"),
            FabricEntityTypeBuilder.createMob()
                    .spawnGroup(SpawnGroup.CREATURE)
                    .entityFactory(ButterflyEntity::new)
                    .dimensions(EntityDimensions.fixed(1.0F, 1.0F))
                    .spawnRestriction(SpawnLocationTypes.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, ButterflyEntity::isValidNaturalSpawn)
                    .build());
    public static final EntityType<SnailEntity> SNAIL = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(Overwhelmed.MOD_ID, "snail"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, SnailEntity::new)
                    .dimensions(EntityDimensions.fixed(1.0F, 1.0F)).build());
    public static final EntityType<MothEntity> MOTH = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(Overwhelmed.MOD_ID, "moth"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, MothEntity::new)
                    .dimensions(EntityDimensions.fixed(1.0F, 1.0F)).build());
    public static final EntityType<HornetEntity> HORNET = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(Overwhelmed.MOD_ID, "hornet"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, HornetEntity::new)
                    .dimensions(EntityDimensions.fixed(1.0F, 1.0F)).build());


}
