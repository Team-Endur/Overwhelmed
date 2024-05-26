package endurteam.overwhelmed.item;

import endurteam.overwhelmed.Overwhelmed;
import endurteam.overwhelmed.block.OverwhelmedBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.awt.dnd.InvalidDnDOperationException;

public class OverwhelmedItems {
    public static PebbleBlockItem PEBBLE = Registry.register(Registries.ITEM, new Identifier(Overwhelmed.MOD_ID, "pebble"),new PebbleBlockItem(OverwhelmedBlocks.PEBBLE, new Item.Settings()));
    public static BlockItem MINT_SEEDS;
    public static Item VANILLA_BEANS;
    public static Item BLOWGUN = registerItem("blowgun", new Item(new Item.Settings()));
    public static Item PAPER_BULLET = registerItem("paper_bullet", new Item(new Item.Settings()));
    public static Item SNAIL;
    public static Item COOKED_SNAIL;
    public static Item SNAIL_STEW;
    public static Item VANILLA_COOKIE;
    public static Item MINT_CAKE;
    public static Item VANILLA_CAKE;
    public static Item MINT_ICE_CREAM;
    public static Item VANILLA_ICE_CREAM;
    public static Item PEPPERMINT;
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