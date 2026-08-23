package com.skd.cataclysmbosses.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParam;
import net.minecraft.world.level.storage.loot.predicates.LootItemEntityPropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import java.util.function.Predicate;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mixin(LootItemEntityPropertyCondition.class)
public abstract class MixinLootItemEntityPropertyCondition implements LootItemCondition {
    private static final Logger LOGGER = LoggerFactory.getMixinLogger("MixinLootItemEntityPropertyCondition");
    private static final AtomicBoolean isConfigLoaded = new AtomicBoolean(false);
    private static final AtomicBoolean isCuriosLootPredicateFixEnabled = new AtomicBoolean(false);
    private static final AtomicInteger firstOccurrenceLogged = new AtomicInteger(0);
    private static final int LOG_COOLDOWN = 5; // Log every 5 occurrences to prevent spam

    // Constructor and other methods would be here

    @Inject(method = "test", at = @At("HEAD"), cancellable = true)
    private void injectTestMethod(ItemStack stack, Entity entity, LootContext context, CallbackInfoReturnable<Boolean> cir) {
        try {
            // Original test logic would go here - we let it run normally
            // Return value will be set by the original method unless we cancel it
        } catch (IllegalStateException e) {
            if (isCuriosLootPredicateFixEnabled()) {
                // Log first occurrence or throttled occurrences
                if (firstOccurrenceLogged.getAndIncrement() == 0) {
                    LOGGER.warn("First occurrence of IllegalStateException in LootItemEntityPropertyCondition.test: {}", e.getMessage());
                } else if (firstOccurrenceLogged.get() % LOG_COOLDOWN == 0) {
                    LOGGER.warn("IllegalStateException in LootItemEntityPropertyCondition.test (occurrence #{}): {}", firstOccurrenceLogged.get(), e.getMessage());
                }
                // Return false and cancel the original method to prevent the exception from propagating
                cir.setReturnValue(false);
                cir.cancel();
            } else {
                // Don't cancel, let the original exception propagate
                throw e;
            }
        }
    }
}