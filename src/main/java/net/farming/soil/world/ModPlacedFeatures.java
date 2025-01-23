package net.farming.soil.world;

import net.farming.soil.AnotherFarmerMod;
import net.farming.soil.world.gen.ModOrePlacement;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;

import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class ModPlacedFeatures {
    public static final RegistryKey<PlacedFeature> STRAWBERRY_BUSH_PLACED = registryKey("strawberry_bush_placed");
    public static final RegistryKey<PlacedFeature> TOMATO_BUSH_PLACED = registryKey("tomato_bush_placed");
    public static final RegistryKey<PlacedFeature> PEANUT_PLANT_PLACED = registryKey("peanut_plant_placed");
    public static final RegistryKey<PlacedFeature> SALT_ORE_PLACED = registryKey("salt_ore_placed");


    public static void bootstrap(Registerable<PlacedFeature> context){
        var configuredFeatures = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, SALT_ORE_PLACED, configuredFeatures.getOrThrow(ModConfiguredFeatures.SALT_ORE_KEY),
                ModOrePlacement.modifiersWithCount(17, HeightRangePlacementModifier.trapezoid(YOffset.fixed(-25), YOffset.fixed(105))));

        register(context, STRAWBERRY_BUSH_PLACED, configuredFeatures.getOrThrow(ModConfiguredFeatures.STRAWBERRY_BUSH_KEY), CountPlacementModifier.of(2),
                RarityFilterPlacementModifier.of(65), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());

        register(context, TOMATO_BUSH_PLACED, configuredFeatures.getOrThrow(ModConfiguredFeatures.TOMATO_BUSH_KEY), CountPlacementModifier.of(3),
                RarityFilterPlacementModifier.of(50), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());

        register(context, PEANUT_PLANT_PLACED, configuredFeatures.getOrThrow(ModConfiguredFeatures.PEANUT_PLANT_KEY), CountPlacementModifier.of(3),
                RarityFilterPlacementModifier.of(45), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());
    }



    public static RegistryKey<PlacedFeature> registryKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(AnotherFarmerMod.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>>
                                 configuration, List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }


    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context,
                                                                                   RegistryKey<PlacedFeature> key,
                                                                                   RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                                                                   PlacementModifier... modifiers) {
        context.register(key, new PlacedFeature(configuration, List.of(modifiers)));
    }
}
