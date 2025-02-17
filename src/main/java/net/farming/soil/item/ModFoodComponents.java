package net.farming.soil.item;

import net.minecraft.component.type.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent COOKED_CARROT = new FoodComponent.Builder().nutrition(5).saturationModifier(0.7f).build();
    public static final FoodComponent CUCUMBER = new FoodComponent.Builder().nutrition(3).saturationModifier(0.4f).build();
    public static final FoodComponent TOMATO = new FoodComponent.Builder().nutrition(3).saturationModifier(0.4f).build();
    public static final FoodComponent GRAPES = new FoodComponent.Builder().nutrition(4).saturationModifier(0.4f).build();
    public static final FoodComponent SPAGHETTI = new FoodComponent.Builder().nutrition(13).saturationModifier(0.5f).build();
    public static final FoodComponent STRAWBERRY = new FoodComponent.Builder().nutrition(2).saturationModifier(1f).build();
    public static final FoodComponent GOLDEN_STRAWBERRY = new FoodComponent.Builder().nutrition(2).saturationModifier(2.5f).build();
    public static final FoodComponent PEANUTS = new FoodComponent.Builder().nutrition(1).saturationModifier(0.5f).build();
    public static final FoodComponent PBNJ = new FoodComponent.Builder().nutrition(7).saturationModifier(0.5f).build();
    public static final FoodComponent ONION = new FoodComponent.Builder().nutrition(3).saturationModifier(0.5f).build();
    public static final FoodComponent PB_COOKIE = new FoodComponent.Builder().nutrition(4).saturationModifier(0.5f).build();
    public static final FoodComponent CHEESE = new FoodComponent.Builder().nutrition(6).saturationModifier(0.6f).build();
    public static final FoodComponent SALT = new FoodComponent.Builder().nutrition(1).saturationModifier(0.0f).alwaysEdible().build();
    public static final FoodComponent MANGO = new FoodComponent.Builder().nutrition(6).saturationModifier(0.7F).build();
    public static final FoodComponent GOLDEN_MANGO = new FoodComponent.Builder().alwaysEdible().nutrition(6).saturationModifier(0.7F).build();
    public static final FoodComponent E_GOLDEN_MANGO = new FoodComponent.Builder().alwaysEdible().nutrition(6).saturationModifier(0.7F).build();
}
