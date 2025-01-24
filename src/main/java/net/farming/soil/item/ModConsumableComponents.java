package net.farming.soil.item;

import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;

import java.util.List;

public class ModConsumableComponents extends ConsumableComponents {

    public static final ConsumableComponent SALT = food().consumeSeconds(2.3F).consumeEffect(
            new ApplyEffectsConsumeEffect(
                    new StatusEffectInstance(
                            StatusEffects.NAUSEA, 450, 0), 0.8F))
            .consumeEffect(
                    new ApplyEffectsConsumeEffect(
                        new StatusEffectInstance(
                            StatusEffects.HUNGER, 500, 0), 0.7F)).build();

    public static final ConsumableComponent STRAWBERRY = food().consumeSeconds(0.9F).consumeEffect(
            new ApplyEffectsConsumeEffect(
                    new StatusEffectInstance(
                            StatusEffects.REGENERATION, 50, 0), 0.8F)).build();

    public static final ConsumableComponent GOLDEN_STRAWBERRY = food().consumeSeconds(0.9F).consumeEffect(
            new ApplyEffectsConsumeEffect(
                    new StatusEffectInstance(
                            StatusEffects.REGENERATION, 150, 1), 1.0F)).build();

    public static final ConsumableComponent PEANUTS = food().consumeSeconds(0.75F).build();

    public static final ConsumableComponent MANGO = food().consumeSeconds(1.3F).consumeEffect(
            new ApplyEffectsConsumeEffect(
                    new StatusEffectInstance(
                            StatusEffects.ABSORPTION, 100, 0), 0.5F)).build();

    public static final ConsumableComponent GOLDEN_MANGO = food().consumeSeconds(1.3F).consumeEffect(
            new ApplyEffectsConsumeEffect(
                   List.of(new StatusEffectInstance(StatusEffects.REGENERATION, 100, 1),
                           new StatusEffectInstance(StatusEffects.ABSORPTION, 2400, 0))
                    )).build();

    public static final ConsumableComponent E_GOLDEN_MANGO = food().consumeSeconds(1.3F).consumeEffect(
            new ApplyEffectsConsumeEffect(
                    List.of(
                            new StatusEffectInstance(StatusEffects.REGENERATION, 400, 1),
                            new StatusEffectInstance(StatusEffects.RESISTANCE, 6000, 0),
                            new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 6000, 0),
                            new StatusEffectInstance(StatusEffects.ABSORPTION, 2400, 3)
            ))).build();

    public static final ConsumableComponent PBNJ = food().consumeSeconds(1.3F).consumeEffect(
            new ApplyEffectsConsumeEffect(
                    new StatusEffectInstance(
                            StatusEffects.REGENERATION, 100, 1), 1.0F)).build();
}
