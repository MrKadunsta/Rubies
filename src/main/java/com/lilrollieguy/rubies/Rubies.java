package com.lilrollieguy.rubies;

import com.lilrollieguy.rubies.item.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.lilrollieguy.rubies.item.ModItems.*;

public class Rubies implements ModInitializer {
	public static final String MOD_ID = "rubies";
	public static final String GAME = "minecraft";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// Register custom item under the ID "minecraft:ruby"
		ModItems.registerModItems();

		// Register the built-in resource pack
		FabricLoader.getInstance().getModContainer(MOD_ID).ifPresent(modContainer -> {
			ResourceManagerHelper.registerBuiltinResourcePack(
					Identifier.of(MOD_ID, "rubies_pack"),
					modContainer,
					ResourcePackActivationType.ALWAYS_ENABLED
			);
		});

		// On each server tick, check all players' inventories for the substitute items
		ServerTickEvents.END_SERVER_TICK.register(server -> {
			for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {
				for (int i = 0; i < player.getInventory().size(); i++) {
					ItemStack stack = player.getInventory().getStack(i);

					if (stack.getItem() == RUBY) {
						ItemStack emeraldStack = new ItemStack(Items.EMERALD, stack.getCount());
						player.getInventory().setStack(i, emeraldStack);
					} else if (stack.getItem() == BLOCK_OF_RUBY) {
						ItemStack emerald_blockStack = new ItemStack(Items.EMERALD_BLOCK, stack.getCount());
						player.getInventory().setStack(i, emerald_blockStack);
					} else if (stack.getItem() == RUBY_ORE) {
						ItemStack ruby_oreStack = new ItemStack(Items.EMERALD_ORE, stack.getCount());
						player.getInventory().setStack(i, ruby_oreStack);
					} else if (stack.getItem() == DEEPSLATE_RUBY_ORE) {
						ItemStack deepslate_ruby_oreStack = new ItemStack(Items.DEEPSLATE_EMERALD_ORE, stack.getCount());
						player.getInventory().setStack(i, deepslate_ruby_oreStack);
					}
				}
			}
		});
	}
}
