package net.farming.soil.item;

import net.minecraft.component.type.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent WILD_CARROT = new FoodComponent.Builder().nutrition(2).saturationModifier(0.1f).build();
    public static final FoodComponent COOKED_WILD_CARROT = new FoodComponent.Builder().nutrition(4).saturationModifier(0.5f).build();
    public static final FoodComponent CUCUMBER = new FoodComponent.Builder().nutrition(3).saturationModifier(0.3f).build();

}
