package net.farming.soil.block;



import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.farming.soil.AnotherFarmerMod;
import net.farming.soil.block.custom.SoupPot.SoupPotEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntityTypes {
    public static <T extends BlockEntityType<?>> T register(String path, T blockEntityType) {
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(AnotherFarmerMod.MOD_ID, path), blockEntityType);
    }
    public static final BlockEntityType<SoupPotEntity> SOUP_POT_ENTITY = register("soup_pot_entity",
            FabricBlockEntityTypeBuilder.create(SoupPotEntity::new, ModBlocks.SOUP_POT_ENTITY).build());


    public static void initialize() {
    }
}
