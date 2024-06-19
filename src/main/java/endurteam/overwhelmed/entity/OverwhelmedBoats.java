package endurteam.overwhelmed.entity;

import com.terraformersmc.terraform.boat.api.TerraformBoatType;
import com.terraformersmc.terraform.boat.api.TerraformBoatTypeRegistry;
import endurteam.overwhelmed.Overwhelmed;
import endurteam.overwhelmed.block.OverwhelmedBlocks;
import endurteam.overwhelmed.item.OverwhelmedItems;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class OverwhelmedBoats {
    public static final Identifier WILLOW_BOAT_ID = new Identifier(Overwhelmed.MOD_ID, "willow_boat");
    public static final Identifier WILLOW_CHEST_BOAT_ID = new Identifier(Overwhelmed.MOD_ID, "willow_chest_boat");

    public static final RegistryKey<TerraformBoatType> WILLOW_BOAT_KEY = TerraformBoatTypeRegistry.createKey(WILLOW_BOAT_ID);

    public static void registerBoats() {
        TerraformBoatType willowBoat = new TerraformBoatType.Builder()
                .item(OverwhelmedItems.WILLOW_BOAT)
                .chestItem(OverwhelmedItems.WILLOW_CHEST_BOAT)
                .planks(OverwhelmedBlocks.WILLOW_PLANKS.asItem())
                .build();

        Registry.register(TerraformBoatTypeRegistry.INSTANCE, WILLOW_BOAT_KEY, willowBoat);
    }
}
