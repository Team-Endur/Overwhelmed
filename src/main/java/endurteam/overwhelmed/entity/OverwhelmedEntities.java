package endurteam.overwhelmed.entity;

import endurteam.overwhelmed.Overwhelmed;
import endurteam.overwhelmed.entity.projectile.PebbleProjectileEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class OverwhelmedEntities {

    public static final EntityType<PebbleProjectileEntity> PEBBLE_PROJECTILE = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(Overwhelmed.MOD_ID, "pebble_projectile"),
            FabricEntityTypeBuilder.<PebbleProjectileEntity>create(SpawnGroup.MISC, PebbleProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25f, 0.25f)).build());

}
