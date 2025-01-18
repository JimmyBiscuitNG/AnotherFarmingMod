package net.farming.soil.item;

import net.minecraft.component.type.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent WILD_CARROT = new FoodComponent.Builder().nutrition(3).saturationModifier(0.4f).build();
    public static final FoodComponent COOKED_WILD_CARROT = new FoodComponent.Builder().nutrition(5).saturationModifier(0.7f).build();
    public static final FoodComponent CUCUMBER = new FoodComponent.Builder().nutrition(3).saturationModifier(0.4f).build();
    public static final FoodComponent TOMATO = new FoodComponent.Builder().nutrition(3).saturationModifier(0.4f).build();
    public static final FoodComponent GRAPES = new FoodComponent.Builder().nutrition(4).saturationModifier(0.4f).build();
    public static final FoodComponent SPAGHETTI = new FoodComponent.Builder().nutrition(13).saturationModifier(0.5f).build();
}
