package net.farming.soil.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.ShortPlantBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class PeanutPlant extends ShortPlantBlock {
    public PeanutPlant(Settings settings) {
        super(settings);

    }

    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state) {
        return super.isFertilizable(world, pos, state);
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return false;
    }
}
