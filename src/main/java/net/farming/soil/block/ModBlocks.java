package net.farming.soil.block;

import net.farming.soil.AnotherFarmerMod;
import net.farming.soil.block.custom.PeanutPlant;
import net.farming.soil.block.custom.StrawberryBush;
import net.farming.soil.block.custom.TomatoBush;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
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
    public static Item registerBlockItem(String path, Function<Item.Settings, Item> factory, Item.Settings settings) {
        final RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(AnotherFarmerMod.MOD_ID, path));
        return Items.register(registryKey, factory, settings);
    }
    public static final Block TOMATO_BUSH = registerBlock("tomato_bush", TomatoBush::new, AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH));
    public static final Block STRAWBERRY_BUSH = registerBlock("strawberry_bush", StrawberryBush::new, AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH));
    public static final Block PEANUT_PLANT = registerBlock("peanut_plant", PeanutPlant::new, AbstractBlock.Settings.create()
            .mapColor(MapColor.DARK_GREEN).pistonBehavior(PistonBehavior.DESTROY).sounds(BlockSoundGroup.GRASS).noCollision());

    public static void registerBlockItems() {
    }
}

