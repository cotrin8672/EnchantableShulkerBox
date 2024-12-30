package io.github.cotrin8672.enchantableshulkerbox.mixin;

import io.github.cotrin8672.enchantableshulkerbox.mixinimpl.ItemStackMixinImpl;
import io.github.cotrin8672.enchantableshulkerbox.registry.ModTags;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemStack.class)
public class ItemStackMixin {
    @Inject(method = "decrementUnlessCreative", at = @At("HEAD"), cancellable = true)
    private void shulkerboxutility$decrementUnlessCreative(
            int amount,
            LivingEntity entity,
            CallbackInfo ci
    ) {
        if (!((ItemStack) (Object) this).isIn(ModTags.getSHULKER_BOXES())) {
            if (entity instanceof PlayerEntity player && !(player.isCreative() || player.isSpectator())) {
                ItemStackMixinImpl.decrementUnlessCreative(((ItemStack) (Object) this), amount, player, ci);
            }
        }
    }
}
