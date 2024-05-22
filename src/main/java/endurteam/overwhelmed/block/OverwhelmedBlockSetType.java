package endurteam.overwhelmed.block;

import it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap;
import net.minecraft.block.BlockSetType;

import java.util.Map;

public class OverwhelmedBlockSetType {
    private static final Map<String, BlockSetType> VALUES = new Object2ObjectArrayMap();
    public static BlockSetType WILLOW;

    private static BlockSetType register(BlockSetType blockSetType) {
        VALUES.put(blockSetType.name(), blockSetType);
        return blockSetType;
    }

    static {
        WILLOW = register(new BlockSetType("willow"));
    }
}