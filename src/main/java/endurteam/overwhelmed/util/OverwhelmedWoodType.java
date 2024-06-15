package endurteam.overwhelmed.util;

import it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap;
import net.minecraft.block.WoodType;

import java.util.Map;

public class OverwhelmedWoodType {

    private static final Map<String, WoodType> VALUES = new Object2ObjectArrayMap();

    public static final WoodType WILLOW = registerWoodType(
            new WoodType("willow", OverwhelmedBlockSetType.WILLOW));

    private static WoodType registerWoodType(WoodType type) {
        VALUES.put(type.name(), type);
        return type;
    }

}