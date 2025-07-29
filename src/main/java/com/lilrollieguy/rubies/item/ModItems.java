package com.lilrollieguy.rubies.item;

import com.lilrollieguy.rubies.Rubies;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item RUBY = registerItem("ruby", new Item(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Rubies.GAME, "ruby")))));
    public static final Item BLOCK_OF_RUBY = registerItem("ruby_block", new Item(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Rubies.GAME, "ruby_block")))));
    public static final Item RUBY_ORE = registerItem("ruby_ore", new Item(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Rubies.GAME, "ruby_ore")))));
    public static final Item DEEPSLATE_RUBY_ORE = registerItem("deepslate_ruby_ore", new Item(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Rubies.GAME, "deepslate_ruby_ore")))));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Rubies.GAME, name), item);
    }

    public static void registerModItems() {
        Rubies.LOGGER.info("Registering Mod Items for " + Rubies.GAME);

    }
}