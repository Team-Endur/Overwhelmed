package endurteam.overwhelmed.block;

import it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap;
import net.minecraft.block.BlockSetType;
import net.minecraft.block.WoodType;

import java.util.Map;

public class OverwhelmedWoodType{
    private static final Map<String, WoodType> VALUES = new Object2ObjectArrayMap();
    public static final WoodType WILLOW;

    private static WoodType register(WoodType type) {
        VALUES.put(type.name(), type);
        return type;
    }

    static {
        WILLOW = register(new WoodType("willow", OverwhelmedBlockSetType.WILLOW));
    }
}