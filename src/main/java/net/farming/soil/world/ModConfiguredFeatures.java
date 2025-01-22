package net.farming.soil.world;

import net.farming.soil.AnotherFarmerMod;
import net.farming.soil.block.ModBlocks;
import net.farming.soil.block.custom.StrawberryBush;
import net.minecraft.block.Blocks;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

import java.util.List;


public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> STRAWBERRY_BUSH_KEY = registryKey("strawberry_bush");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TOMATO_BUSH_KEY = registryKey("tomato_bush");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PEANUT_PLANT_KEY = registryKey("peanut_plant_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SALT_ORE_KEY = registryKey("salt_ore_key");


    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context){
        RuleTest stoneReplacables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);

        List<OreFeatureConfig.Target> overworldSaltOres =
                List.of(OreFeatureConfig.createTarget(stoneReplacables, ModBlocks.SALT_ORE.getDefaultState()));

        register(context, SALT_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldSaltOres, 8));


        register(context, STRAWBERRY_BUSH_KEY, Feature.FLOWER,
                ConfiguredFeatures.createRandomPatchFeatureConfig(
                        Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.STRAWBERRY_BUSH.getDefaultState().
                                with(StrawberryBush.AGE, 3))),
                        List.of(Blocks.GRASS_BLOCK, Blocks.PODZOL)));

        register(context, TOMATO_BUSH_KEY, Feature.FLOWER,
                ConfiguredFeatures.createRandomPatchFeatureConfig(
                        Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.TOMATO_BUSH.getDefaultState().
                                with(StrawberryBush.AGE, 3))),
                        List.of(Blocks.GRASS_BLOCK)));

        register(context, PEANUT_PLANT_KEY,
                Feature.FLOWER,
                ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.PEANUT_PLANT))));
    }



    public static RegistryKey<ConfiguredFeature<?, ?>> registryKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(AnotherFarmerMod.MOD_ID, name));
    }



    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature,
                                                                                   FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }

}
