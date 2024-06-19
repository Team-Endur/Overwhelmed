package endurteam.overwhelmed.block;

import net.minecraft.data.family.BlockFamilies;
import net.minecraft.data.family.BlockFamily;

public class OverwhelmedBlockFamilies {
    public static final BlockFamily WILLOW_FAMILY = BlockFamilies.register(OverwhelmedBlocks.WILLOW_PLANKS)
            .slab(OverwhelmedBlocks.WILLOW_SLAB)
            .stairs(OverwhelmedBlocks.WILLOW_STAIRS)
            .button(OverwhelmedBlocks.WILLOW_BUTTON)
            .pressurePlate(OverwhelmedBlocks.WILLOW_PRESSURE_PLATE)
            .door(OverwhelmedBlocks.WILLOW_DOOR)
            .trapdoor(OverwhelmedBlocks.WILLOW_TRAPDOOR)
            .fence(OverwhelmedBlocks.WILLOW_FENCE)
            .fenceGate(OverwhelmedBlocks.WILLOW_FENCE_GATE)
            .sign(OverwhelmedBlocks.WILLOW_SIGN, OverwhelmedBlocks.WILLOW_WALL_SIGN)
            .build();

    public static final BlockFamily SNAIL_SHELL_FAMILY = BlockFamilies.register(OverwhelmedBlocks.SNAIL_SHELL_BRICKS)
            .stairs(OverwhelmedBlocks.SNAIL_SHELL_BRICK_STAIRS)
            .slab(OverwhelmedBlocks.SNAIL_SHELL_BRICK_SLAB)
            .wall(OverwhelmedBlocks.SNAIL_SHELL_BRICK_WALL)
            .chiseled(OverwhelmedBlocks.CHISELED_SNAIL_SHELL_BRICKS)
            .group("building")
            .build();

    public static final BlockFamily ALTAIR_FAMILY = BlockFamilies.register(OverwhelmedBlocks.ALTAIR)
            .stairs(OverwhelmedBlocks.ALTAIR_STAIRS)
            .slab(OverwhelmedBlocks.ALTAIR_SLAB)
            .wall(OverwhelmedBlocks.ALTAIR_WALL)
            .polished(OverwhelmedBlocks.POLISHED_ALTAIR)
            .group("building")
            .build();

    public static final BlockFamily POLISHED_ALTAIR_FAMILY = BlockFamilies.register(OverwhelmedBlocks.POLISHED_ALTAIR)
            .stairs(OverwhelmedBlocks.POLISHED_ALTAIR_STAIRS)
            .slab(OverwhelmedBlocks.POLISHED_ALTAIR_SLAB)
            .group("building")
            .build();

    public static final BlockFamily FIZZYROCK_FAMILY = BlockFamilies.register(OverwhelmedBlocks.FIZZYROCK)
            .stairs(OverwhelmedBlocks.FIZZYROCK_STAIRS)
            .slab(OverwhelmedBlocks.FIZZYROCK_SLAB)
            .wall(OverwhelmedBlocks.FIZZYROCK_WALL)
            .polished(OverwhelmedBlocks.POLISHED_FIZZYROCK)
            .chiseled(OverwhelmedBlocks.CHISELED_FIZZYROCK)
            .build();

    public static final BlockFamily POLISHED_FIZZYROCK_FAMILY = BlockFamilies.register(OverwhelmedBlocks.POLISHED_FIZZYROCK)
            .stairs(OverwhelmedBlocks.POLISHED_FIZZYROCK_STAIRS)
            .slab(OverwhelmedBlocks.POLISHED_FIZZYROCK_SLAB)
            .build();

    public static final BlockFamily FIZZYROCK_BRICKS_FAMILY = BlockFamilies.register(OverwhelmedBlocks.FIZZYROCK_BRICKS)
            .stairs(OverwhelmedBlocks.FIZZYROCK_BRICK_STAIRS)
            .slab(OverwhelmedBlocks.FIZZYROCK_BRICK_SLAB)
            .wall(OverwhelmedBlocks.FIZZYROCK_BRICK_WALL)
            .chiseled(OverwhelmedBlocks.CHISELED_FIZZYROCK_BRICKS)
            .build();
}
