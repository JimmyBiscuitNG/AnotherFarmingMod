package net.farming.soil.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.farming.soil.AnotherFarmerMod;
import net.farming.soil.block.custom.StrawberryBush;
import net.farming.soil.block.custom.TomatoBush;
import net.farming.soil.item.FarmerItemGroup;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static Block register(Block block, RegistryKey<Block> blockKey, boolean shouldRegisterItem) {
        if (shouldRegisterItem) {

            RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, blockKey.getValue());

            BlockItem blockItem = new BlockItem(block, new Item.Settings().registryKey(itemKey));
            Registry.register(Registries.ITEM, itemKey, blockItem);
        }

        return Registry.register(Registries.BLOCK, blockKey, block);
    }

    public static final RegistryKey<Block> STRAWBERRY_BUSH_KEY = RegistryKey.of(
            RegistryKeys.BLOCK,
            Identifier.of(AnotherFarmerMod.MOD_ID, "strawberry_bush")
    );

    public static final Block STRAWBERRY_BUSH = register(
            new StrawberryBush(AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH).registryKey(STRAWBERRY_BUSH_KEY)),
            STRAWBERRY_BUSH_KEY,
            false


    );

    public static final RegistryKey<Block> TOMATO_BUSH_KEYS = RegistryKey.of(
            RegistryKeys.BLOCK,
            Identifier.of(AnotherFarmerMod.MOD_ID, "tomato_bush")


    );

    public static final Block TOMATO_BUSH = register(
            new TomatoBush(AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH).registryKey(TOMATO_BUSH_KEYS)),
            TOMATO_BUSH_KEYS,
            false


    );

    public static void registerBlockItems() {
    }
}

