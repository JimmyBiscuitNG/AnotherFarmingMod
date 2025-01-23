package net.farming.soil.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.farming.soil.block.ModBlocks;
import net.farming.soil.block.custom.StrawberryBush;
import net.farming.soil.block.custom.TomatoBush;
import net.farming.soil.item.ModItems;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {

        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerTintableCrossBlockStateWithStages(ModBlocks.STRAWBERRY_BUSH,
                BlockStateModelGenerator.CrossType.NOT_TINTED, StrawberryBush.AGE, 0, 1, 2, 3);
        blockStateModelGenerator.registerTintableCrossBlockStateWithStages(ModBlocks.TOMATO_BUSH,
                BlockStateModelGenerator.CrossType.NOT_TINTED, TomatoBush.AGE, 0, 1, 2, 3);
        blockStateModelGenerator.registerTintableCross(ModBlocks.PEANUT_PLANT, BlockStateModelGenerator.CrossType.TINTED);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SALT_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SALT_ORE);
    }


    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.COOKED_CARROT, Models.GENERATED);
        itemModelGenerator.register(ModItems.CUCUMBER, Models.GENERATED);
        itemModelGenerator.register(ModItems.TOMATO_SAUCE, Models.GENERATED);
        itemModelGenerator.register(ModItems.GRAPES, Models.GENERATED);
        itemModelGenerator.register(ModItems.NOODLES, Models.GENERATED);
        itemModelGenerator.register(ModItems.SALT, Models.GENERATED);
        itemModelGenerator.register(ModItems.SPAGHETTI, Models.GENERATED);
        itemModelGenerator.register(ModItems.STRAWBERRY_JAM, Models.GENERATED);
        itemModelGenerator.register(ModItems.PEANUTS, Models.GENERATED);
        itemModelGenerator.register(ModItems.PEANUT_BUTTER, Models.GENERATED);
        itemModelGenerator.register(ModItems.PBNJ, Models.GENERATED);
        itemModelGenerator.register(ModItems.RENNET, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHEESE, Models.GENERATED);


    }
}
