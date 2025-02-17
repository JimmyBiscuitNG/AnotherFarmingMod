package net.farming.soil.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.farming.soil.AnotherFarmerMod;
import net.farming.soil.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class FarmerItemGroup {
    public static final RegistryKey<ItemGroup> FARMER_ITEMS_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(AnotherFarmerMod.MOD_ID, "farmer_items"));
    public static final ItemGroup FARMER_ITEMS = FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.SPAGHETTI))
                    .displayName(Text.translatable("itemgroup.anotherfarmermod.farmer_items"))
                    .build();
    public static final RegistryKey<ItemGroup> FARMER_INGREDIENTS_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(AnotherFarmerMod.MOD_ID, "farmer_ingredients"));
    public static final ItemGroup FARMER_INGREDIENTS = FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.TOMATO))
            .displayName(Text.translatable("itemgroup.anotherfarmermod.farmer_ingredients"))
            .build();

    public static final RegistryKey<ItemGroup> FARMER_BLOCKS_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(AnotherFarmerMod.MOD_ID, "farmer_blocks"));
    public static final ItemGroup FARMER_BLOCKS = FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.SALT_BLOCK))
            .displayName(Text.translatable("itemgroup.anotherfarmermod.farmer_blocks"))
            .build();


    public static void registerItemGroups() {
        Registry.register(Registries.ITEM_GROUP, FARMER_INGREDIENTS_KEY, FARMER_INGREDIENTS);
        Registry.register(Registries.ITEM_GROUP, FARMER_ITEMS_KEY, FARMER_ITEMS);
        Registry.register(Registries.ITEM_GROUP, FARMER_BLOCKS_KEY, FARMER_BLOCKS);
        AnotherFarmerMod.LOGGER.info("Item Groups for " + AnotherFarmerMod.MOD_ID);
    }

}
