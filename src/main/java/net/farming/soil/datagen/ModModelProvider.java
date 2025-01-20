package net.farming.soil.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.farming.soil.block.ModBlocks;
import net.farming.soil.block.custom.TomatoBush;
import net.farming.soil.item.ModItems;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;
import net.minecraft.client.data.TexturedModel;
import net.minecraft.client.render.item.tint.TintSource;
import net.minecraft.client.render.item.tint.TintSourceTypes;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {

        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.STRAWBERRY_BUSH);
        blockStateModelGenerator.registerTintableCrossBlockStateWithStages(ModBlocks.TOMATO_BUSH,
                BlockStateModelGenerator.CrossType.NOT_TINTED, TomatoBush.AGE, 0, 1, 2, 3);
    }


    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.WILD_CARROT, Models.GENERATED);
        itemModelGenerator.register(ModItems.COOKED_WILD_CARROT, Models.GENERATED);
        itemModelGenerator.register(ModItems.CUCUMBER, Models.GENERATED);
        itemModelGenerator.register(ModItems.TOMATO_SAUCE, Models.GENERATED);
        itemModelGenerator.register(ModItems.GRAPES, Models.GENERATED);
        itemModelGenerator.register(ModItems.NOODLES, Models.GENERATED);
        itemModelGenerator.register(ModItems.MACNOODLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.SPAGHETTI, Models.GENERATED);
        itemModelGenerator.register(ModItems.STRAWBERRY, Models.GENERATED);
        itemModelGenerator.register(ModItems.STRAWBERRY_JAM, Models.GENERATED);
        itemModelGenerator.register(ModItems.PEANUTS, Models.GENERATED);
        itemModelGenerator.register(ModItems.PEANUT_BUTTER, Models.GENERATED);
        itemModelGenerator.register(ModItems.PBNJ, Models.GENERATED);

    }
}
