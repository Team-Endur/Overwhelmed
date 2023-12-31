package endurteam.overwhelmed.neoforge.world.item;

import endurteam.overwhelmed.Overwhelmed;
import endurteam.overwhelmed.world.entity.OverwhelmedEntityTypes;
import endurteam.overwhelmed.world.food.OverwhelmedFoods;
import endurteam.overwhelmed.world.item.BlowgunItem;
import endurteam.overwhelmed.world.item.MultiSpawnEggItem;
import endurteam.overwhelmed.world.item.PebbleBlockItem;
import endurteam.overwhelmed.world.level.block.OverwhelmedBlocks;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.RegisterEvent;

import static endurteam.overwhelmed.world.item.OverwhelmedItems.*;

public class OverwhelmedNeoForgeItems {
    public static void registerItems(RegisterEvent.RegisterHelper<Item> helper) {
        SOIL = registerGenericBlockItem("soil", OverwhelmedBlocks.SOIL, helper);
        SNAIL_SHELL_BRICKS = registerGenericBlockItem("snail_shell_bricks",
                OverwhelmedBlocks.SNAIL_SHELL_BRICKS, helper);
        SNAIL_SHELL_BRICK_STAIRS = registerGenericBlockItem(
                "snail_shell_brick_stairs",
                OverwhelmedBlocks.SNAIL_SHELL_BRICK_STAIRS, helper);
        SNAIL_SHELL_BRICK_SLAB = registerGenericBlockItem(
                "snail_shell_brick_slab",
                OverwhelmedBlocks.SNAIL_SHELL_BRICK_SLAB, helper);
        SNAIL_SHELL_BRICK_WALL = registerGenericBlockItem(
                "snail_shell_brick_wall",
                OverwhelmedBlocks.SNAIL_SHELL_BRICK_WALL, helper);
        CHISELED_SNAIL_SHELL_BRICKS = registerGenericBlockItem(
                "chiseled_snail_shell_bricks",
                OverwhelmedBlocks.CHISELED_SNAIL_SHELL_BRICKS, helper);
        helper.register(new ResourceLocation(Overwhelmed.MOD_ID, "floff"),
                FLOFF = new BlockItem(OverwhelmedBlocks.FLOFF,
                        new Item.Properties()));
        helper.register(new ResourceLocation(Overwhelmed.MOD_ID, "paine"),
                PAINE = new BlockItem(OverwhelmedBlocks.PAINE,
                        new Item.Properties()));
        helper.register(new ResourceLocation(Overwhelmed.MOD_ID, "pink_lavatera"),
                PINK_LAVATERA = new BlockItem(OverwhelmedBlocks.PINK_LAVATERA,
                        new Item.Properties()));
        helper.register(new ResourceLocation(Overwhelmed.MOD_ID, "white_lavatera"),
                WHITE_LAVATERA = new BlockItem(OverwhelmedBlocks.WHITE_LAVATERA,
                        new Item.Properties()));
        helper.register(new ResourceLocation(Overwhelmed.MOD_ID, "squirl"),
                SQUIRL = new BlockItem(OverwhelmedBlocks.SQUIRL,
                        new Item.Properties()));
        helper.register(new ResourceLocation(Overwhelmed.MOD_ID, "ringot"),
                RINGOT = new BlockItem(OverwhelmedBlocks.RINGOT,
                        new Item.Properties()));
        helper.register(new ResourceLocation(Overwhelmed.MOD_ID, "snowdrop"),
                SNOWDROP = new BlockItem(OverwhelmedBlocks.SNOWDROP,
                        new Item.Properties()));
        helper.register(new ResourceLocation(Overwhelmed.MOD_ID, "bell_sunflower"),
                BELL_SUNFLOWER = new BlockItem(OverwhelmedBlocks.BELL_SUNFLOWER,
                        new Item.Properties()));
        helper.register(new ResourceLocation(Overwhelmed.MOD_ID, "widow"),
                WIDOW = new DoubleHighBlockItem(OverwhelmedBlocks.WIDOW,
                        new Item.Properties()));
        GOLD_BEAD = registerGenericBlockItem("gold_bead", OverwhelmedBlocks.GOLD_BEAD, helper);
        ICE_CUBE  = registerGenericBlockItem("ice_cube", OverwhelmedBlocks.ICE_CUBE, helper);
        helper.register(new ResourceLocation(Overwhelmed.MOD_ID, "pebble"),
                PEBBLE = new PebbleBlockItem(OverwhelmedBlocks.PEBBLE,
                        new Item.Properties()));
        GOO_BLOCK = registerGenericBlockItem("goo_block", OverwhelmedBlocks.GOO_BLOCK, helper);
        helper.register(new ResourceLocation(Overwhelmed.MOD_ID, "blowgun"),
                BLOWGUN = new BlowgunItem(new Item.Properties()
                        .stacksTo(1)
                        .rarity(Rarity.COMMON)
                        .durability(20)));
        PAPER_BULLET = registerGenericItem("paper_bullet", 64, Rarity.COMMON, helper);
        helper.register(new ResourceLocation(Overwhelmed.MOD_ID, "snail"),
                SNAIL = new Item(new Item.Properties()
                        .stacksTo(64)
                        .rarity(Rarity.COMMON)
                        .food(OverwhelmedFoods.SNAIL)));
        helper.register(new ResourceLocation(Overwhelmed.MOD_ID, "cooked_snail"),
                COOKED_SNAIL = new Item(new Item.Properties()
                        .stacksTo(64)
                        .rarity(Rarity.COMMON)
                        .food(OverwhelmedFoods.COOKED_SNAIL)));
        helper.register(new ResourceLocation(Overwhelmed.MOD_ID, "snail_stew"),
                SNAIL_STEW = new BowlFoodItem(new Item.Properties()
                        .stacksTo(1)
                        .rarity(Rarity.COMMON)
                        .food(OverwhelmedFoods.SNAIL_STEW)));
        GOO_BALL = registerGenericItem("goo_ball", 64, Rarity.COMMON, helper);
        SNAIL_SHELL = registerGenericItem("snail_shell", 64, Rarity.COMMON, helper);
        helper.register(new ResourceLocation(Overwhelmed.MOD_ID,
                        "butterfly_spawn_egg"), BUTTERFLY_SPAWN_EGG =
                new MultiSpawnEggItem(new Item.Properties(), (random) -> {
                    switch (random.nextIntBetweenInclusive(1, 6)) {
                        case 1 -> {
                            return OverwhelmedEntityTypes.CABBAGE_BUTTERFLY;
                        }
                        case 2 -> {
                            return OverwhelmedEntityTypes.CHERRY_BUTTERFLY;
                        }
                        case 3 -> {
                            return OverwhelmedEntityTypes.LIVERWORT_BUTTERFLY;
                        }
                        case 4 -> {
                            return OverwhelmedEntityTypes.MONARCH_BUTTERFLY;
                        }
                        case 5 -> {
                            return OverwhelmedEntityTypes.MORPHO_BUTTERFLY;
                        }
                        case 6 -> {
                            return OverwhelmedEntityTypes.SLEEPY_BUTTERFLY;
                        }
                    }
                    throw new IncompatibleClassChangeError();
                }
                )
        );
        helper.register(new ResourceLocation(Overwhelmed.MOD_ID,
                        "snail_spawn_egg"), SNAIL_SPAWN_EGG =
                new MultiSpawnEggItem(new Item.Properties(), (random) -> {
                    switch (random.nextIntBetweenInclusive(1, 6)) {
                        case 1 -> {
                            return OverwhelmedEntityTypes.FLAT_SNAIL;
                        }
                        case 2 -> {
                            return OverwhelmedEntityTypes.GARDEN_SNAIL;
                        }
                        case 3 -> {
                            return OverwhelmedEntityTypes.GLASS_SNAIL;
                        }
                        case 4 -> {
                            return OverwhelmedEntityTypes.LIMESTONE_SNAIL;
                        }
                        case 5 -> {
                            return OverwhelmedEntityTypes.LIVERWORT_SNAIL;
                        }
                        case 6 -> {
                            return OverwhelmedEntityTypes.ROMAN_SNAIL;
                        }
                    }
                    throw new IncompatibleClassChangeError();
                }
                )
        );
    }

    @SuppressWarnings("SameParameterValue")
    private static Item registerGenericItem(String name, int stackSize, Rarity rarity,
                                            RegisterEvent.RegisterHelper<Item> helper) {
        Item result;
        helper.register(new ResourceLocation(Overwhelmed.MOD_ID, name),
                result = new Item(new Item.Properties()
                        .stacksTo(stackSize)
                        .rarity(rarity)));
        return result;
    }

    private static BlockItem registerGenericBlockItem(String name, Block block,
                                                      RegisterEvent.RegisterHelper<Item> helper) {
        BlockItem result;
        helper.register(new ResourceLocation(Overwhelmed.MOD_ID, name),
                result = new BlockItem(block, new Item.Properties()));
        return result;
    }
}
