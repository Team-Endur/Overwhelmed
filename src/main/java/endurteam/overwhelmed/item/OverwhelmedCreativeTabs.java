package endurteam.overwhelmed.item;

import endurteam.overwhelmed.Overwhelmed;
import endurteam.overwhelmed.block.OverwhelmedBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class OverwhelmedCreativeTabs {
    public static final ItemGroup OVERWHELMED = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Overwhelmed.MOD_ID, "snail_shell"),
            FabricItemGroup.builder().displayName(Text.translatable("category.overwhelmed"))
                    .icon(() -> new ItemStack(OverwhelmedItems.SNAIL_SHELL)).entries((displayContext, entries) -> {
                        entries.add(OverwhelmedBlocks.WILLOW_LOG);
                        entries.add(OverwhelmedBlocks.WILLOW_WOOD);
                        entries.add(OverwhelmedBlocks.STRIPPED_WILLOW_LOG);
                        entries.add(OverwhelmedBlocks.STRIPPED_WILLOW_WOOD);
                        entries.add(OverwhelmedBlocks.WILLOW_PLANKS);
                        entries.add(OverwhelmedBlocks.WILLOW_STAIRS);
                        entries.add(OverwhelmedBlocks.WILLOW_SLAB);
                        entries.add(OverwhelmedBlocks.WILLOW_FENCE);
                        entries.add(OverwhelmedBlocks.WILLOW_FENCE_GATE);
                        entries.add(OverwhelmedBlocks.WILLOW_DOOR);
                        entries.add(OverwhelmedBlocks.WILLOW_TRAPDOOR);
                        entries.add(OverwhelmedBlocks.WILLOW_PRESSURE_PLATE);
                        entries.add(OverwhelmedBlocks.WILLOW_BUTTON);
                        entries.add(OverwhelmedBlocks.WILLOW_LEAVES);
                        entries.add(OverwhelmedBlocks.WILLOW_VINES);
                        entries.add(OverwhelmedBlocks.SNAIL_SHELL_BRICKS);
                        entries.add(OverwhelmedBlocks.SNAIL_SHELL_BRICK_STAIRS);
                        entries.add(OverwhelmedBlocks.SNAIL_SHELL_BRICK_SLAB);
                        entries.add(OverwhelmedBlocks.SNAIL_SHELL_BRICK_WALL);
                        entries.add(OverwhelmedBlocks.CHISELED_SNAIL_SHELL_BRICKS);
                        entries.add(OverwhelmedBlocks.ALTAIR);
                        entries.add(OverwhelmedBlocks.ALTAIR_STAIRS);
                        entries.add(OverwhelmedBlocks.ALTAIR_SLAB);
                        entries.add(OverwhelmedBlocks.ALTAIR_WALL);
                        entries.add(OverwhelmedBlocks.POLISHED_ALTAIR);
                        entries.add(OverwhelmedBlocks.POLISHED_ALTAIR_STAIRS);
                        entries.add(OverwhelmedBlocks.POLISHED_ALTAIR_SLAB);
                        entries.add(OverwhelmedBlocks.FIZZYROCK);
                        entries.add(OverwhelmedBlocks.FIZZYROCK_STAIRS);
                        entries.add(OverwhelmedBlocks.FIZZYROCK_SLAB);
                        entries.add(OverwhelmedBlocks.FIZZYROCK_WALL);
                        entries.add(OverwhelmedBlocks.CHISELED_FIZZYROCK);
                        entries.add(OverwhelmedBlocks.POLISHED_FIZZYROCK);
                        entries.add(OverwhelmedBlocks.POLISHED_FIZZYROCK_STAIRS);
                        entries.add(OverwhelmedBlocks.POLISHED_FIZZYROCK_SLAB);
                        entries.add(OverwhelmedBlocks.FIZZYROCK_BRICKS);
                        entries.add(OverwhelmedBlocks.FIZZYROCK_BRICK_STAIRS);
                        entries.add(OverwhelmedBlocks.FIZZYROCK_BRICK_SLAB);
                        entries.add(OverwhelmedBlocks.FIZZYROCK_BRICK_WALL);
                        entries.add(OverwhelmedBlocks.CHISELED_FIZZYROCK_BRICKS);
                        entries.add(OverwhelmedBlocks.FIZZYROCK_GEYSER);
                        entries.add(OverwhelmedBlocks.SOIL);
                        entries.add(OverwhelmedBlocks.CHARCOAL_ORE);
                        entries.add(OverwhelmedBlocks.FLOFF);
                        entries.add(OverwhelmedBlocks.PAINE);
                        entries.add(OverwhelmedBlocks.PINK_LAVATERA);
                        entries.add(OverwhelmedBlocks.WHITE_LAVATERA);
                        entries.add(OverwhelmedBlocks.SQUIRL);
                        entries.add(OverwhelmedBlocks.RINGOT);
                        entries.add(OverwhelmedBlocks.SNOWDROP);
                        entries.add(OverwhelmedBlocks.BELL_SUNFLOWER);
//                        entries.add(OverwhelmedItems.WIDOW);
//                        entries.add(OverwhelmedItems.WHITE_ALLIUM);
                        entries.add(OverwhelmedBlocks.GOLD_BEAD);
                        entries.add(OverwhelmedBlocks.ICE_CUBE);
                        entries.add(OverwhelmedBlocks.PEBBLE);
//                        entries.add(OverwhelmedItems.MINT_SEEDS);
//                        entries.add(OverwhelmedItems.VANILLA_BEANS);
                        entries.add(OverwhelmedBlocks.GOO_BLOCK);
//                        entries.add(OverwhelmedItems.BLOWGUN);
//                        entries.add(OverwhelmedItems.PAPER_BULLET);
//                        entries.add(OverwhelmedItems.SNAIL);
//                        entries.add(OverwhelmedItems.COOKED_SNAIL);
//                        entries.add(OverwhelmedItems.SNAIL_STEW);
//                        entries.add(OverwhelmedItems.VANILLA_COOKIE);
//                        entries.add(OverwhelmedItems.MINT_CAKE);
//                        entries.add(OverwhelmedItems.VANILLA_CAKE);
//                        entries.add(OverwhelmedItems.MINT_ICE_CREAM);
//                        entries.add(OverwhelmedItems.VANILLA_ICE_CREAM);
//                        entries.add(OverwhelmedItems.PEPPERMINT);
//                        entries.add(OverwhelmedItems.GOO_BALL);
//                        entries.add(OverwhelmedItems.SNAIL_SHELL);
//                        entries.add(OverwhelmedItems.MINT_LEAF);
//                        entries.add(OverwhelmedItems.BUTTERFLY_SPAWN_EGG);
//                        entries.add(OverwhelmedItems.HORNET_SPAWN_EGG);
//                        entries.add(OverwhelmedItems.MOTH_SPAWN_EGG);
//                        entries.add(OverwhelmedItems.SNAIL_SPAWN_EGG);


                    }).build());


    public static void registerItemTabs() {}
}