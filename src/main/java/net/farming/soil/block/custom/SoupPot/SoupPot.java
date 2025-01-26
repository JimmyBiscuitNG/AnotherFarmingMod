package net.farming.soil.block.custom.SoupPot;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

public class SoupPot extends BlockWithEntity {
    public static final BooleanProperty HAS_WATER = BooleanProperty.of("has_water");
    public SoupPot(Settings settings) {
        super(settings);
        setDefaultState(this.getDefaultState()
                .with(HAS_WATER, Boolean.FALSE));
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return createCodec(SoupPot::new);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(HAS_WATER);
    }

    @Override
    protected ActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        boolean water = state.get(HAS_WATER);
        Item item = stack.getItem();
        if (!world.isClient) {




            if (stack.isOf(Items.WATER_BUCKET) && !water) {
                player.setStackInHand(hand, ItemUsage.exchangeStack(stack, player, new ItemStack(Items.BUCKET)));
                player.incrementStat(Stats.USED.getOrCreateStat(item));
                world.setBlockState(pos, state.cycle(HAS_WATER));
                world.playSound(null, pos, SoundEvents.ITEM_BUCKET_EMPTY, SoundCategory.BLOCKS, 1.0F, 1.0f);
                world.emitGameEvent(null, GameEvent.FLUID_PLACE, pos);
                return ActionResult.SUCCESS;
            }

        }

        if (stack.isOf(Items.BUCKET) && water){
            player.setStackInHand(hand, ItemUsage.exchangeStack(stack, player, new ItemStack(Items.WATER_BUCKET)));
            player.incrementStat(Stats.USED.getOrCreateStat(item));
            world.setBlockState(pos, state.cycle(HAS_WATER));
            world.playSound(null, pos, SoundEvents.ITEM_BUCKET_FILL, SoundCategory.BLOCKS, 1.0F, 1.0f);
            world.emitGameEvent(null, GameEvent.FLUID_PLACE, pos);
            return ActionResult.SUCCESS;
        }

        if (stack.isEmpty() && water) {
            world.playSound(null, pos, SoundEvents.BLOCK_LANTERN_HIT, SoundCategory.BLOCKS, 0.6F, 0.6F);
            return ActionResult.SUCCESS;
        }
        if (stack.isEmpty() && !water) {
            world.playSound(null, pos, SoundEvents.BLOCK_LANTERN_HIT, SoundCategory.BLOCKS, 0.6F, 1F);
            return ActionResult.SUCCESS;
        }

        return ActionResult.SUCCESS;
    }

    @Override
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return super.getTicker(world, state, type);
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new SoupPotEntity(pos, state);
    }
}
