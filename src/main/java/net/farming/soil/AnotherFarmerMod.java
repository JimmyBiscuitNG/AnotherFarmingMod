package net.farming.soil;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.farming.soil.block.ModBlocks;
import net.farming.soil.item.FarmerItemGroup;
import net.farming.soil.item.ModItems;
import net.farming.soil.world.gen.ModWorldGeneration;
import net.minecraft.client.render.RenderLayer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AnotherFarmerMod implements ModInitializer {
	public static final String MOD_ID = "anotherfarmermod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		//item block groups
		FarmerItemGroup.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerBlockItems();
		ModWorldGeneration.generateModWorldGen();

		//strawberry block
		ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> {
			return 0xBFFFD7;
		}, ModBlocks.STRAWBERRY_BUSH);
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.STRAWBERRY_BUSH, RenderLayer.getCutout());
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRAWBERRY_BUSH, 60, 30);

		//Tomato bush


		//composting
		CompostingChanceRegistry.INSTANCE.add(ModItems.WILD_CARROT, 0.35f);
		CompostingChanceRegistry.INSTANCE.add(ModItems.TOMATO, 0.65f);
		CompostingChanceRegistry.INSTANCE.add(ModItems.GRAPES, 0.2f);
		CompostingChanceRegistry.INSTANCE.add(ModItems.STRAWBERRY, 0.35f);
		CompostingChanceRegistry.INSTANCE.add(ModItems.PEANUTS, 0.1f);
	}
}