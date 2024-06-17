package endurteam.overwhelmed.util;

import net.fabricmc.fabric.api.object.builder.v1.block.type.BlockSetTypeBuilder;
import net.minecraft.block.BlockSetType;
import net.minecraft.util.Identifier;

import java.util.Map;

public class OverwhelmedBlockSetType {
    public static BlockSetType WILLOW = BlockSetTypeBuilder.copyOf(BlockSetType.MANGROVE).register(
            new Identifier("overwhelmed:willow"));

}