package net.farming.soil.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.farming.soil.AnotherFarmerMod;
import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item WILD_CARROT = registerItem("wild_carrot", new Item(new Item.Settings().food(ModFoodComponents.WILD_CARROT).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(AnotherFarmerMod.MOD_ID,"wild_carrot")))));
    public static final Item COOKED_WILD_CARROT = registerItem("cooked_wild_carrot", new Item(new Item.Settings().food(ModFoodComponents.COOKED_WILD_CARROT).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(AnotherFarmerMod.MOD_ID,"cooked_wild_carrot")))));
    public static final Item CUCUMBER = registerItem("cucumber", new Item(new Item.Settings().food(ModFoodComponents.CUCUMBER).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(AnotherFarmerMod.MOD_ID,"cucumber")))));



    public static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(AnotherFarmerMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        AnotherFarmerMod.LOGGER.info("registering mod items for " + AnotherFarmerMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(FarmerItemGroup.FARMER_ITEMS_KEY).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(WILD_CARROT);
            fabricItemGroupEntries.add(COOKED_WILD_CARROT);
            fabricItemGroupEntries.add(CUCUMBER);
        });
    }
}
