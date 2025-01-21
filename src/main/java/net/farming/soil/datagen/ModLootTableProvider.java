package net.farming.soil.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.farming.soil.block.ModBlocks;
import net.farming.soil.block.custom.StrawberryBush;
import net.farming.soil.block.custom.TomatoBush;
import net.farming.soil.item.ModItems;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.LootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.NumberRange;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.state.property.IntProperty;

import java.util.concurrent.CompletableFuture;
import java.util.random.RandomGenerator;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        RegistryWrapper.Impl<Enchantment> impl = this.registries.getOrThrow(RegistryKeys.ENCHANTMENT);

        this.addDrop(
                ModBlocks.STRAWBERRY_BUSH,
                block -> this.applyExplosionDecay(
                        block,
                        LootTable.builder()
                                .pool(
                                        LootPool.builder()
                                                .conditionally(
                                                        BlockStatePropertyLootCondition.builder(ModBlocks.STRAWBERRY_BUSH)
                                                                .properties(StatePredicate.Builder.create().exactMatch(StrawberryBush.AGE, 3))
                                                )
                                                .with(ItemEntry.builder(ModItems.STRAWBERRY))
                                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0F, 3.0F)))
                                                .apply(ApplyBonusLootFunction.uniformBonusCount(impl.getOrThrow(Enchantments.FORTUNE)))
                                )
                                .pool(
                                        LootPool.builder()
                                                .conditionally(
                                                        BlockStatePropertyLootCondition.builder(ModBlocks.STRAWBERRY_BUSH)
                                                                .properties(StatePredicate.Builder.create().exactMatch(StrawberryBush.AGE, 2))
                                                )
                                                .with(ItemEntry.builder(ModItems.STRAWBERRY))
                                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 2.0F)))
                                                .apply(ApplyBonusLootFunction.uniformBonusCount(impl.getOrThrow(Enchantments.FORTUNE)))
                                )));


        this.addDrop(
                ModBlocks.TOMATO_BUSH,
                block -> this.applyExplosionDecay(
                        block,
                        LootTable.builder()
                                .pool(
                                        LootPool.builder()
                                                .conditionally(
                                                        BlockStatePropertyLootCondition.builder(ModBlocks.TOMATO_BUSH)
                                                                .properties(StatePredicate.Builder.create().exactMatch(TomatoBush.AGE, 3))
                                                )
                                                .with(ItemEntry.builder(ModItems.TOMATO))
                                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0F, 3.0F)))
                                                .apply(ApplyBonusLootFunction.uniformBonusCount(impl.getOrThrow(Enchantments.FORTUNE)))
                                )
                                .pool(
                                        LootPool.builder()
                                                .conditionally(
                                                        BlockStatePropertyLootCondition.builder(ModBlocks.TOMATO_BUSH)
                                                                .properties(StatePredicate.Builder.create().exactMatch(TomatoBush.AGE, 2))
                                                )
                                                .with(ItemEntry.builder(ModItems.TOMATO))
                                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 2.0F)))
                                                .apply(ApplyBonusLootFunction.uniformBonusCount(impl.getOrThrow(Enchantments.FORTUNE)))
                                )));

        addDrop(ModBlocks.PEANUT_PLANT, drops(ModItems.PEANUTS, UniformLootNumberProvider.create(1.0f, 3.0F)));
    }
}