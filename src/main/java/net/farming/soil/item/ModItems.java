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

    //food
    public static final Item WILD_CARROT = registerItem("wild_carrot", new Item(new Item.Settings().food(ModFoodComponents.WILD_CARROT).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(AnotherFarmerMod.MOD_ID,"wild_carrot")))));
    public static final Item COOKED_WILD_CARROT = registerItem("cooked_wild_carrot", new Item(new Item.Settings().food(ModFoodComponents.COOKED_WILD_CARROT).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(AnotherFarmerMod.MOD_ID,"cooked_wild_carrot")))));
    public static final Item CUCUMBER = registerItem("cucumber", new Item(new Item.Settings().food(ModFoodComponents.CUCUMBER).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(AnotherFarmerMod.MOD_ID,"cucumber")))));
    public static final Item TOMATO = registerItem("tomato", new BlockItem(ModBlocks.TOMATO_BUSH, new Item.Settings().food(ModFoodComponents.TOMATO).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(AnotherFarmerMod.MOD_ID,"tomato")))));
    public static final Item TOMATO_SAUCE = registerItem("tomato_sauce", new Item(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(AnotherFarmerMod.MOD_ID,"tomato_sauce")))));
    public static final Item GRAPES = registerItem("grapes", new Item(new Item.Settings().food(ModFoodComponents.GRAPES).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(AnotherFarmerMod.MOD_ID,"grapes")))));
    public static final Item NOODLES = registerItem("noodles", new Item(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(AnotherFarmerMod.MOD_ID,"noodles")))));
    public static final Item SPAGHETTI = registerItem("spaghetti", new Item(new Item.Settings().food(ModFoodComponents.SPAGHETTI).maxCount(1).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(AnotherFarmerMod.MOD_ID,"spaghetti")))));
    public static final Item STRAWBERRY = registerItem("strawberry", new BlockItem(ModBlocks.STRAWBERRY_BUSH, new  Item.Settings().food(ModFoodComponents.STRAWBERRY).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(AnotherFarmerMod.MOD_ID,"strawberry")))));
    public static final Item STRAWBERRY_JAM = registerItem("strawberry_jam", new Item(new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE).maxCount(16).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(AnotherFarmerMod.MOD_ID,"strawberry_jam")))));
    public static final Item PEANUTS = registerItem("peanuts", new Item(new Item.Settings().food(ModFoodComponents.PEANUTS).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(AnotherFarmerMod.MOD_ID,"peanuts")))));
    public static final Item PEANUT_BUTTER = registerItem("peanut_butter", new Item(new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE).maxCount(16).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(AnotherFarmerMod.MOD_ID,"peanut_butter")))));
    public static final Item PBNJ = registerItem("pbnj", new Item(new Item.Settings().food(ModFoodComponents.PBNJ).maxCount(16).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(AnotherFarmerMod.MOD_ID,"pbnj")))));
    public static final Item MACNOODLE = registerItem("macnoodle", new Item(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(AnotherFarmerMod.MOD_ID,"macnoodle")))));

    //tools

    public




    static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(AnotherFarmerMod.MOD_ID, name), item);
    }

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
            fabricItemGroupEntries.add(WILD_CARROT);
        });

        ItemGroupEvents.modifyEntriesEvent(FarmerItemGroup.FARMER_ITEMS_KEY).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(COOKED_WILD_CARROT);
            fabricItemGroupEntries.add(SPAGHETTI);
            fabricItemGroupEntries.add(PBNJ);
        });
    }
}
