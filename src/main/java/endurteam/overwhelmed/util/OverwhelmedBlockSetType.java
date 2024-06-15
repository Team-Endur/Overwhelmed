package endurteam.overwhelmed.util;

import it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap;
import net.minecraft.block.BlockSetType;
import net.minecraft.registry.Registry;

import java.util.Map;

public class OverwhelmedBlockSetType {
    private static final Map<String, BlockSetType> VALUES = new Object2ObjectArrayMap();
    public static final BlockSetType WILLOW = registerBlockSetType(new BlockSetType("willow"));

    private static BlockSetType registerBlockSetType(BlockSetType blockSetType) {
        VALUES.put(blockSetType.name(), blockSetType);
        return blockSetType;
    }

}