package net.farming.soil.recipe;

import net.farming.soil.item.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.AbstractCookingRecipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.book.CookingRecipeCategory;
import net.minecraft.recipe.book.RecipeBookCategory;

public class SoupPotCookingRecipe extends AbstractCookingRecipe {
    public SoupPotCookingRecipe(String group, CookingRecipeCategory category, Ingredient ingredient, ItemStack result, float experience, int cookingTime) {
        super(group, category, ingredient, result, experience, cookingTime);
    }

    @Override
    public RecipeSerializer<? extends AbstractCookingRecipe> getSerializer() {
        return null;
    }

    @Override
    public RecipeType<? extends AbstractCookingRecipe> getType() {
        return null;
    }

    @Override
    public RecipeBookCategory getRecipeBookCategory() {
        return null;
    }

    @Override
    protected Item getCookerItem() {
        return ModItems.SOUP_POT;
    }
}
