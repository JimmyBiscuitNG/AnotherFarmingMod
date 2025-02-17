package net.farming.soil.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.farming.soil.block.ModBlocks;
import net.farming.soil.block.custom.StrawberryBush;
import net.farming.soil.block.custom.TomatoBush;
import net.farming.soil.item.ModItems;
import net.minecraft.block.Blocks;
import net.minecraft.data.loottable.vanilla.VanillaBlockLootTableGenerator;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.condition.TableBonusLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import java.util.concurrent.CompletableFuture;

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

        addDrop(ModBlocks.SOUP_POT_ENTITY);

        addDrop(ModBlocks.SALT_BLOCK, drops(ModBlocks.SALT_BLOCK));

        this.addDrop( ModBlocks.SALT_ORE,
            this.dropsWithSilkTouch(
                ModBlocks.SALT_ORE,
                    this.applyExplosionDecay(
                            ModBlocks.SALT_ORE,
                            ItemEntry.builder(ModItems.SALT)
                                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0F, 4.0f)))
                                    .apply(ApplyBonusLootFunction.uniformBonusCount(impl.getOrThrow(Enchantments.FORTUNE))))));

        this.addDrop(Blocks.JUNGLE_LEAVES,
                this.leavesDrops(Blocks.JUNGLE_LEAVES, Blocks.JUNGLE_SAPLING, VanillaBlockLootTableGenerator.SAPLING_DROP_CHANCE)
                        .pool(
                                LootPool.builder()
                                        .rolls(ConstantLootNumberProvider.create(1.0F))
                                        .conditionally(this.createWithoutShearsOrSilkTouchCondition())
                                        .with(
                                                ((LeafEntry.Builder<?>) this.addSurvivesExplosionCondition(Blocks.JUNGLE_LEAVES, ItemEntry.builder(ModItems.MANGO)))
                                                        .conditionally(TableBonusLootCondition.builder(impl.getOrThrow(Enchantments.FORTUNE), 0.02F, 0.022222223F, 0.025F, 0.033333333F, 0.1F))
                                        ).build()));
        }
    }
