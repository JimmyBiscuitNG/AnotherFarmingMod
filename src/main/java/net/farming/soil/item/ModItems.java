package net.farming.soil.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.farming.soil.AnotherFarmerMod;
import net.farming.soil.block.ModBlocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;


public class ModItems {
    public static Item register(String id, Item item, RegistryKey<Item> registryKey) {
        Item registeredItem = Registry.register(Registries.ITEM, registryKey.getValue(), item);

        return registeredItem;
    }

    public static Item registerBlock(String id, BlockItem blockItem, Item item, RegistryKey<Item> registryKey) {

        Item registeredItem = Registry.register(Registries.ITEM, registryKey.getValue(), item);

        return registeredItem;
    }

    //Keys
    public static final RegistryKey<Item> COOKED_CARROT_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(AnotherFarmerMod.MOD_ID,"cooked_carrot"));
    public static final RegistryKey<Item> CUCUMBER_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(AnotherFarmerMod.MOD_ID, "cucumber"));
    public static final RegistryKey<Item> TOMATO_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(AnotherFarmerMod.MOD_ID, "tomato"));
    public static final RegistryKey<Item> TOMATO_SAUCE_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(AnotherFarmerMod.MOD_ID, "tomato_sauce"));
    public static final RegistryKey<Item> GRAPES_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(AnotherFarmerMod.MOD_ID, "grapes"));
    public static final RegistryKey<Item> NOODLES_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(AnotherFarmerMod.MOD_ID, "noodles"));
    public static final RegistryKey<Item> SPAGHETTI_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(AnotherFarmerMod.MOD_ID, "spaghetti"));
    public static final RegistryKey<Item> STRAWBERRY_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(AnotherFarmerMod.MOD_ID,"strawberry"));
    public static final RegistryKey<Item> STRAWBERRY_JAM_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(AnotherFarmerMod.MOD_ID, "strawberry_jam"));
    public static final RegistryKey<Item> PEANUTS_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(AnotherFarmerMod.MOD_ID, "peanuts"));
    public static final RegistryKey<Item> PEANUT_BUTTER_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(AnotherFarmerMod.MOD_ID, "peanut_butter"));
    public static final RegistryKey<Item> PBNJ_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(AnotherFarmerMod.MOD_ID, "pbnj"));
    public static final RegistryKey<Item> MACNOODLE_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(AnotherFarmerMod.MOD_ID, "macnoodle"));


    //Food
    public static final Item COOKED_CARROT = register("cooked_carrot", new Item(new Item.Settings().food(ModFoodComponents.COOKED_CARROT).
            registryKey(COOKED_CARROT_KEY)), COOKED_CARROT_KEY);
    public static final Item CUCUMBER = register("cucumber", new Item(new Item.Settings().food(ModFoodComponents.CUCUMBER).
            registryKey(CUCUMBER_KEY)), CUCUMBER_KEY);
    public static final Item TOMATO = registerBlock("tomato", new BlockItem(ModBlocks.TOMATO_BUSH, new Item.Settings().useItemPrefixedTranslationKey()),
            new Item(new Item.Settings().food(ModFoodComponents.TOMATO).registryKey(TOMATO_KEY)), TOMATO_KEY);
    public static final Item TOMATO_SAUCE = register("tomato_sauce", new Item(new Item.Settings().registryKey(TOMATO_SAUCE_KEY)), TOMATO_SAUCE_KEY);
    public static final Item GRAPES = register("grapes", new Item(new Item.Settings().food(ModFoodComponents.GRAPES).registryKey(GRAPES_KEY)), GRAPES_KEY);
    public static final Item NOODLES = register("noodles", new Item(new Item.Settings().registryKey(NOODLES_KEY)), NOODLES_KEY);
    public static final Item SPAGHETTI = register("spaghetti", new Item(new Item.Settings().food(ModFoodComponents.SPAGHETTI).maxCount(1).registryKey(SPAGHETTI_KEY)), SPAGHETTI_KEY);
    public static final Item STRAWBERRY = registerBlock("strawberry", new BlockItem(ModBlocks.STRAWBERRY_BUSH, new Item.Settings().useItemPrefixedTranslationKey()),
            new Item(new Item.Settings().food(ModFoodComponents.STRAWBERRY).registryKey(STRAWBERRY_KEY)), STRAWBERRY_KEY);
    public static final Item STRAWBERRY_JAM = register("strawberry_jam", new Item(new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE).maxCount(16)
            .registryKey(STRAWBERRY_JAM_KEY)), STRAWBERRY_JAM_KEY);
    public static final Item PEANUTS = register("peanuts", new Item(new Item.Settings().food(ModFoodComponents.PEANUTS)
            .registryKey(PEANUTS_KEY)), PEANUTS_KEY);
    public static final Item PEANUT_BUTTER = register("peanut_butter", new Item(new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE).maxCount(16)
            .registryKey(PEANUT_BUTTER_KEY)), PEANUT_BUTTER_KEY);
    public static final Item PBNJ = register("pbnj", new Item(new Item.Settings().food(ModFoodComponents.PBNJ).maxCount(16).registryKey(PBNJ_KEY)), PBNJ_KEY);
    public static final Item MACNOODLE = register("macnoodle", new Item(new Item.Settings().registryKey(MACNOODLE_KEY)), MACNOODLE_KEY);

    public static void registerModItems() {
        AnotherFarmerMod.LOGGER.info("registering mod items for " + AnotherFarmerMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(FarmerItemGroup.FARMER_INGREDIENTS_KEY).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(CUCUMBER);
            fabricItemGroupEntries.add(GRAPES);
            fabricItemGroupEntries.add(MACNOODLE);
            fabricItemGroupEntries.add(NOODLES);
            fabricItemGroupEntries.add(PEANUTS);
            fabricItemGroupEntries.add(PEANUT_BUTTER);
            fabricItemGroupEntries.add(STRAWBERRY);
            fabricItemGroupEntries.add(STRAWBERRY_JAM);
            fabricItemGroupEntries.add(TOMATO);
            fabricItemGroupEntries.add(TOMATO_SAUCE);
        });

        ItemGroupEvents.modifyEntriesEvent(FarmerItemGroup.FARMER_ITEMS_KEY).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(COOKED_CARROT);
            fabricItemGroupEntries.add(SPAGHETTI);
            fabricItemGroupEntries.add(PBNJ);
        });
    }
}

