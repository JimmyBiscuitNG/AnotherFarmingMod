package net.farming.soil.block.custom.SoupPot;

import net.farming.soil.block.ModBlocks;
import net.farming.soil.item.ModItems;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public class WaterSoupPot extends Block {
    public static final IntProperty FoodsAmount = IntProperty.of("foodsamount", 0, 2);
    public static final BooleanProperty HasChicken = BooleanProperty.of("haschicken");
    public static final BooleanProperty HasNoodles = BooleanProperty.of("hasnoodles");
    public static final BooleanProperty HasOnion = BooleanProperty.of("hasonion");
    public static final BooleanProperty HasTomato = BooleanProperty.of("hastomato");

    public WaterSoupPot(Settings settings) {
        super(settings);
        setDefaultState(this.getDefaultState()
                .with(FoodsAmount, 0)
                .with(HasChicken, Boolean.FALSE)
                .with(HasNoodles, Boolean.FALSE)
                .with(HasOnion, Boolean.FALSE)
                .with(HasTomato, Boolean.FALSE)
        );
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FoodsAmount);

        builder.add(HasChicken);
        builder.add(HasNoodles);
        builder.add(HasOnion);
        builder.add(HasTomato);
    }

    @Override
    protected ActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        int foods = state.get(FoodsAmount);

        //checks if food is in pot or not
        boolean chicken = state.get(HasChicken);
        boolean noodles = state.get(HasNoodles);
        boolean onion = state.get(HasOnion);
        boolean tomato = state.get(HasTomato);

        Item item = stack.getItem();
        if (!world.isClient) {

            //stewables
            if (CampfireBlock.isLitCampfireInRange(world, pos)
                    && !chicken && foods < 2 && stack.isOf(Items.CHICKEN)) {

                stack.decrementUnlessCreative(1, player);
                player.incrementStat(Stats.USED.getOrCreateStat(item));
                world.setBlockState(pos, state.cycle(HasChicken).cycle(FoodsAmount));
                world.playSound(null, pos,
                        SoundEvents.ITEM_BUCKET_EMPTY, SoundCategory.BLOCKS, 0.5F, 0.7F);
            }

            if (CampfireBlock.isLitCampfireInRange(world, pos)
                    && !noodles && foods < 2 && stack.isOf(ModItems.NOODLES)) {

                stack.decrementUnlessCreative(1, player);
                player.incrementStat(Stats.USED.getOrCreateStat(item));
                world.setBlockState(pos, state.cycle(HasNoodles).cycle(FoodsAmount));
                world.playSound(null, pos,
                        SoundEvents.ITEM_BUCKET_EMPTY, SoundCategory.BLOCKS, 0.5F, 0.6F);
            }

            if (CampfireBlock.isLitCampfireInRange(world, pos)
                    && !tomato && foods < 2 && stack.isOf(ModItems.TOMATO)) {

                stack.decrementUnlessCreative(1, player);
                player.incrementStat(Stats.USED.getOrCreateStat(item));
                world.setBlockState(pos, state.cycle(HasTomato).cycle(FoodsAmount));
                world.playSound(null, pos,
                        SoundEvents.ITEM_BUCKET_EMPTY, SoundCategory.BLOCKS, 0.5F, 0.6F);
            }

            if (CampfireBlock.isLitCampfireInRange(world, pos)
                    && !onion && foods < 2 && stack.isOf(ModItems.ONION)) {

                stack.decrementUnlessCreative(1, player);
                player.incrementStat(Stats.USED.getOrCreateStat(item));
                world.setBlockState(pos, state.cycle(HasOnion).cycle(FoodsAmount));
                world.playSound(null, pos,
                        SoundEvents.ITEM_BUCKET_EMPTY, SoundCategory.BLOCKS, 0.5F, 0.6F);
            }


            //remove water
            if (stack.isOf(Items.BUCKET)) {
                player.setStackInHand(hand, ItemUsage.exchangeStack(stack, player, new ItemStack(Items.WATER_BUCKET)));
                player.incrementStat(Stats.USED.getOrCreateStat(item));
                world.setBlockState(pos, ModBlocks.SOUP_POT.getDefaultState());
                world.playSound(null, pos, SoundEvents.ITEM_BUCKET_FILL, SoundCategory.BLOCKS, 1F, 1f);
                world.emitGameEvent(null, GameEvent.FLUID_PICKUP, pos);

            }
            if (stack.isOf(Items.BOWL)){
                foodFinished(stack, state, world, pos, player);
            }
        }

        return ActionResult.SUCCESS;
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        world.playSound(null, pos, SoundEvents.BLOCK_LANTERN_STEP, SoundCategory.BLOCKS, 0.6F, 0.6f);
        return ActionResult.SUCCESS;
    }

    public static void foodFinished(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player) {

        //checks what food is in the pot
        boolean template = false;
        boolean chicken = state.get(HasChicken);
        boolean noodles = state.get(HasNoodles);
        boolean onion = state.get(HasOnion);
        boolean tomato = state.get(HasTomato);

        //Template
            if (template && template) {
                stack.decrementUnlessCreative(1, player);
                player.giveItemStack(new ItemStack(Items.SPONGE));
                world.setBlockState(pos, state.cycle(HasChicken).cycle(HasNoodles).cycle(FoodsAmount));
                world.setBlockState(pos, ModBlocks.SOUP_POT.getDefaultState());
            }

            //chicken recipes
            if (chicken && noodles) {
                stack.decrementUnlessCreative(1, player);
                player.giveItemStack(new ItemStack(Items.SPONGE));
                world.setBlockState(pos, state.cycle(HasChicken).cycle(HasNoodles).cycle(FoodsAmount));
                world.setBlockState(pos, ModBlocks.SOUP_POT.getDefaultState());
            }
            if (chicken && onion) {
                stack.decrementUnlessCreative(1, player);
                player.giveItemStack(new ItemStack(Items.SPONGE));
                world.setBlockState(pos, state.cycle(HasChicken).cycle(HasOnion).cycle(FoodsAmount));
                world.setBlockState(pos, ModBlocks.SOUP_POT.getDefaultState());
            }
            if (chicken && tomato) {
                stack.decrementUnlessCreative(1, player);
                player.giveItemStack(new ItemStack(Items.SPONGE));
                world.setBlockState(pos, state.cycle(HasChicken).cycle(HasTomato).cycle(FoodsAmount));
                world.setBlockState(pos, ModBlocks.SOUP_POT.getDefaultState());
            }

            //noodles and vegetable recipes
            if (noodles && tomato) {
                stack.decrementUnlessCreative(1, player);
                player.giveItemStack(new ItemStack(Items.SPONGE));
                world.setBlockState(pos, state.cycle(HasNoodles).cycle(HasTomato).cycle(FoodsAmount));
                world.setBlockState(pos, ModBlocks.SOUP_POT.getDefaultState());
            }
            if (noodles && onion) {
                stack.decrementUnlessCreative(1, player);
                player.giveItemStack(new ItemStack(Items.SPONGE));
                world.setBlockState(pos, state.cycle(HasNoodles).cycle(HasOnion).cycle(FoodsAmount));
                world.setBlockState(pos, ModBlocks.SOUP_POT.getDefaultState());
            }

            //vegetable + vegetable recipes

            if (tomato && onion) {
                stack.decrementUnlessCreative(1, player);
                player.giveItemStack(new ItemStack(Items.SPONGE));
                world.setBlockState(pos, state.cycle(HasOnion).cycle(HasTomato).cycle(FoodsAmount));
                world.setBlockState(pos, ModBlocks.SOUP_POT.getDefaultState());
            }
        }
    }


