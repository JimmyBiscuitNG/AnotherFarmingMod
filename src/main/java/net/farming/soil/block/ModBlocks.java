package net.farming.soil.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.farming.soil.AnotherFarmerMod;
import net.farming.soil.block.custom.PeanutPlant;
import net.farming.soil.block.custom.StrawberryBush;
import net.farming.soil.block.custom.TomatoBush;
import net.farming.soil.item.FarmerItemGroup;
import net.farming.soil.item.ModItems;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModBlocks {
    public static Block registerBlock(String path, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        final RegistryKey<Block> registryKey = RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(AnotherFarmerMod.MOD_ID, path));
        return Blocks.register(registryKey, factory, settings);
    }

    public static Block registerBlockItem(String path, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        final RegistryKey<Block> registryKey = RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(AnotherFarmerMod.MOD_ID, path));
        final Block block = Blocks.register(registryKey, factory, settings);
        Items.register(block);
        return block;
    }


    public static final Block TOMATO_BUSH = registerBlock("tomato_bush", TomatoBush::new, AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH));
    public static final Block STRAWBERRY_BUSH = registerBlock("strawberry_bush", StrawberryBush::new, AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH));
    public static final Block PEANUT_PLANT = registerBlock("peanut_plant", PeanutPlant::new, AbstractBlock.Settings.create()
            .mapColor(MapColor.DARK_GREEN).pistonBehavior(PistonBehavior.DESTROY).sounds(BlockSoundGroup.GRASS).noCollision());
    public static final Block SALT_ORE = registerBlockItem("salt_ore", Block::new, AbstractBlock.Settings.create()
            .mapColor(MapColor.GRAY).sounds(BlockSoundGroup.STONE).instrument(NoteBlockInstrument.COW_BELL).requiresTool().strength(1.5F, 6.0F));
    public static final Block SALT_BLOCK = registerBlockItem("salt_block", Block::new, AbstractBlock.Settings.create()
            .mapColor(MapColor.GRAY).sounds(BlockSoundGroup.STONE).instrument(NoteBlockInstrument.COW_BELL).requiresTool().strength(2.5F, 7.0F));


    public static void registerBlockItems() {
        ItemGroupEvents.modifyEntriesEvent(FarmerItemGroup.FARMER_BLOCKS_KEY).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(ModBlocks.SALT_ORE);
            fabricItemGroupEntries.add(ModBlocks.SALT_BLOCK);
        });
    }
}

