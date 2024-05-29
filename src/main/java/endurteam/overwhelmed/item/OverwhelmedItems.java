package endurteam.overwhelmed.item;

import endurteam.overwhelmed.Overwhelmed;
import endurteam.overwhelmed.block.OverwhelmedBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
public class OverwhelmedItems {
    public static final Item PEBBLE = registerItem("pebble",
            new PebbleBlockItem(OverwhelmedBlocks.PEBBLE, new Item.Settings()
                    .maxCount(16)));
    public static final Item MINT_SEEDS = registerItem("mint_seeds",
            new AliasedBlockItem(OverwhelmedBlocks.MINT, new Item.Settings()));
    public static final Item VANILLA_BEANS = registerItem("vanilla_beans",
            new AliasedBlockItem(OverwhelmedBlocks.VANILLA, new Item.Settings()));
    public static Item BLOWGUN = registerItem("blowgun", new Item(new Item.Settings()));
    public static Item PAPER_BULLET = registerItem("paper_bullet", new Item(new Item.Settings()));
    public static Item SNAIL = registerItem("snail", new Item(new Item.Settings().food(OverwhelmedFoodComponents.SNAIL)));
    public static Item COOKED_SNAIL = registerItem("cooked_snail",
            new Item(new Item.Settings()
                    .food(OverwhelmedFoodComponents.COOKED_SNAIL)));
    public static Item VANILLA_COOKIE = registerItem("vanilla_cookie",
            new Item(new Item.Settings()
                    .food(OverwhelmedFoodComponents.VANILLA_COOKIE)));
    public static Item PEPPERMINT = registerItem("peppermint",
            new Item(new Item.Settings()
                    .food(OverwhelmedFoodComponents.PEPPERMINT)));
    public static Item MINT_CAKE;
    public static Item VANILLA_CAKE;
    public static Item VANILLA_ICE_CREAM = registerItem("vanilla_ice_cream",
            new Item(new Item.Settings()
                    .food(OverwhelmedFoodComponents.VANILLA_ICE_CREAM)
                    .maxCount(1)
                    .recipeRemainder(Items.BOWL)));
    public static Item MINT_ICE_CREAM = registerItem("mint_ice_cream",
            new Item(new Item.Settings()
                    .food(OverwhelmedFoodComponents.MINT_ICE_CREAM)
                    .maxCount(1)
                    .recipeRemainder(Items.BOWL)));
    public static Item SNAIL_STEW = registerItem("snail_stew",
            new Item(new Item.Settings()
                    .food(OverwhelmedFoodComponents.SNAIL_STEW)
                    .maxCount(1)
                    .recipeRemainder(Items.BOWL)));
    public static Item GOO_BALL = registerItem("goo_ball", new Item(new Item.Settings()));
    public static Item SNAIL_SHELL= registerItem("snail_shell", new Item(new Item.Settings()));
    public static Item MINT_LEAF= registerItem("mint_leaf", new Item(new Item.Settings()));
    public static SpawnEggItem BUTTERFLY_SPAWN_EGG;
    public static SpawnEggItem HORNET_SPAWN_EGG;
    public static SpawnEggItem HORNET_LARVA_SPAWN_EGG;
    public static SpawnEggItem MOTH_SPAWN_EGG;
    public static SpawnEggItem SNAIL_SPAWN_EGG;

    private static void addItemsToCombatItemGroup(FabricItemGroupEntries entries) {
        entries.add(BLOWGUN);
    }

    private static Item registerItem(String string, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Overwhelmed.MOD_ID, string), item);
    }

    public static void registerItems() {

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(OverwhelmedItems::addItemsToCombatItemGroup);

    }
}