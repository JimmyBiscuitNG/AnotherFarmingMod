package net.farming.soil;

import net.fabricmc.api.ModInitializer;
import net.farming.soil.item.FarmerItemGroup;
import net.farming.soil.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AnotherFarmerMod implements ModInitializer {
	public static final String MOD_ID = "anotherfarmermod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		FarmerItemGroup.registerItemGroups();
		ModItems.registerModItems();
	}
}