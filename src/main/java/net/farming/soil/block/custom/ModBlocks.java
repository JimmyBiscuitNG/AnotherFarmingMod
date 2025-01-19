package net.farming.soil.block.custom;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.farming.soil.AnotherFarmerMod;
import net.farming.soil.item.FarmerItemGroup;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.client.render.item.tint.GrassTintSource;
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
    public static void initialize() {}

    public static final RegistryKey<Block> STRAWBERRY_BUSH_KEY = RegistryKey.of(
            RegistryKeys.BLOCK,
            Identifier.of(AnotherFarmerMod.MOD_ID, "strawberry_bush")
    );

    public static final Block STRAWBERRY_BUSH = register(
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.DARK_GREEN).nonOpaque().burnable().registryKey(STRAWBERRY_BUSH_KEY).sounds(BlockSoundGroup.GRASS)),
            STRAWBERRY_BUSH_KEY,
            true


    );
    public static void registerBlockItems() {
        ItemGroupEvents.modifyEntriesEvent(FarmerItemGroup.FARMER_MISC_KEY).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(STRAWBERRY_BUSH);
        });
    }
}

