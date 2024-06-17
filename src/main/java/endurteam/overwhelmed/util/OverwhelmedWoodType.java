package endurteam.overwhelmed.util;

import net.fabricmc.fabric.api.object.builder.v1.block.type.WoodTypeBuilder;
import net.minecraft.block.WoodType;
import net.minecraft.util.Identifier;

import java.util.Map;

public class OverwhelmedWoodType {

    public static WoodType WILLOW = WoodTypeBuilder.copyOf(WoodType.OAK).register(
            new Identifier("overwhelmed:willow"), OverwhelmedBlockSetType.WILLOW);

}