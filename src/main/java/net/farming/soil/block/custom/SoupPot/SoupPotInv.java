package net.farming.soil.block.custom.SoupPot;

import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;

public interface SoupPotInv extends Inventory {
    DefaultedList<ItemStack> getItems();

    static SoupPotInv of(DefaultedList<ItemStack> items){
        return null;
    }

    static SoupPotInv ofSize(int size) {
        return of(DefaultedList.ofSize(2, ItemStack.EMPTY));
    }

    @Override
    default int size() {
        return getItems().size();
    }


}
