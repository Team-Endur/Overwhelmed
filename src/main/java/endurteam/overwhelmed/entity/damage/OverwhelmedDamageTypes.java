package endurteam.overwhelmed.entity.damage;

import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class OverwhelmedDamageTypes implements DamageTypes {

    public static final RegistryKey<DamageType> PEBBLE = RegistryKey.of(RegistryKeys.DAMAGE_TYPE,
            new Identifier("overwhelmed", "pebble"));

}
