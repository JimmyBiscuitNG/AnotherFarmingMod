package net.farming.soil.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.farming.soil.AnotherFarmerMod;
import net.farming.soil.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;

import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import java.util.function.Function;


public class ModItems extends Items{

    //Raw Foods
    public static final Item CUCUMBER = register("cucumber", Item::new,
            new Item.Settings().food(ModFoodComponents.CUCUMBER));
    public static final Item TOMATO = register("tomato",
            createBlockItemWithUniqueName(ModBlocks.TOMATO_BUSH), new Item.Settings().food(ModFoodComponents.TOMATO));
    public static final Item GRAPES = register("grapes", Item::new,
            new Item.Settings().food(ModFoodComponents.GRAPES));
    public static final Item STRAWBERRY = register("strawberry",
            createBlockItemWithUniqueName(ModBlocks.STRAWBERRY_BUSH), new Item.Settings().food(
                    ModFoodComponents.STRAWBERRY, ModConsumableComponents.STRAWBERRY));
    public static final Item PEANUTS = register("peanuts", Item::new,
            new Item.Settings().food(ModFoodComponents.PEANUTS, ModConsumableComponents.PEANUTS));
    public static final Item ONION = register("onion", Item::new,
            new Item.Settings().food(ModFoodComponents.ONION));
    public static final Item MANGO = register("mango", Item::new,
            new Item.Settings().food(ModFoodComponents.MANGO, ModConsumableComponents.MANGO));
    public static final Item CHEESE = register("cheese", Item::new,
            new Item.Settings().food(ModFoodComponents.CHEESE));

    //Ingredients
    public static final Item TOMATO_SAUCE = register("tomato_sauce", Item::new,
            new Item.Settings());
    public static final Item NOODLES = register("noodles", Item::new,
            new Item.Settings());
    public static final Item STRAWBERRY_JAM = register("strawberry_jam", Item::new,
            new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE));
    public static final Item PEANUT_BUTTER = register("peanut_butter", Item::new,
            new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE));
    public static final Item SALT = register("salt", Item::new,
            new Item.Settings().food(ModFoodComponents.SALT, ModConsumableComponents.SALT));
    public static final Item RENNET = register("rennet", Item::new,
            new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE));


    //Prepared Food
    public static final Item PBNJ = register("pbnj", Item::new,
            new Item.Settings().food(ModFoodComponents.PBNJ, ModConsumableComponents.PBNJ).maxCount(16));
    public static final Item COOKED_CARROT = register("cooked_carrot", Item::new,
            new Item.Settings().food(ModFoodComponents.COOKED_CARROT));
    public static final Item SPAGHETTI = register("spaghetti", Item::new,
            new Item.Settings().food(ModFoodComponents.SPAGHETTI).maxCount(1));
    public static final Item PB_COOKIE = register("pb_cookie", Item::new,
            new Item.Settings().food(ModFoodComponents.PB_COOKIE));
    public static final Item GOLDEN_MANGO = register("golden_mango", Item::new,
            new Item.Settings().food(ModFoodComponents.GOLDEN_MANGO, ModConsumableComponents.GOLDEN_MANGO));
    public static final Item E_GOLDEN_MANGO = register("e_golden_mango", Item::new,
            new Item.Settings().rarity(Rarity.RARE).food(ModFoodComponents.E_GOLDEN_MANGO, ModConsumableComponents.E_GOLDEN_MANGO)
                    .component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true));
    public static final Item GOLDEN_STRAWBERRY = register("golden_strawberry", Item::new,
            new Item.Settings().food(ModFoodComponents.GOLDEN_STRAWBERRY, ModConsumableComponents.GOLDEN_STRAWBERRY));

    public static Item register(String path, Function<Item.Settings, Item> factory, Item.Settings settings) {
        final RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(AnotherFarmerMod.MOD_ID, path));
                return Items.register(registryKey, factory, settings);
    }

    private static Function<Item.Settings, Item> createBlockItemWithUniqueName(Block block) {
        return settings -> new BlockItem(block, settings.useItemPrefixedTranslationKey());
    }
    public static void registerModItems() {
        AnotherFarmerMod.LOGGER.info("registering mod items for " + AnotherFarmerMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(FarmerItemGroup.FARMER_INGREDIENTS_KEY).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(CUCUMBER);
            fabricItemGroupEntries.add(CHEESE);
            fabricItemGroupEntries.add(GRAPES);
            fabricItemGroupEntries.add(MANGO);
            fabricItemGroupEntries.add(NOODLES);
            fabricItemGroupEntries.add(PEANUTS);
            fabricItemGroupEntries.add(PEANUT_BUTTER);
            fabricItemGroupEntries.add(STRAWBERRY);
            fabricItemGroupEntries.add(STRAWBERRY_JAM);
            fabricItemGroupEntries.add(RENNET);
            fabricItemGroupEntries.add(TOMATO);
            fabricItemGroupEntries.add(TOMATO_SAUCE);
            fabricItemGroupEntries.add(ONION);
            fabricItemGroupEntries.add(SALT);

        });

        ItemGroupEvents.modifyEntriesEvent(FarmerItemGroup.FARMER_ITEMS_KEY).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(COOKED_CARROT);
            fabricItemGroupEntries.add(GOLDEN_MANGO);
            fabricItemGroupEntries.add(E_GOLDEN_MANGO);
            fabricItemGroupEntries.add(GOLDEN_STRAWBERRY);
            fabricItemGroupEntries.add(SPAGHETTI);
            fabricItemGroupEntries.add(PB_COOKIE);
            fabricItemGroupEntries.add(PBNJ);


        });
    }
}

