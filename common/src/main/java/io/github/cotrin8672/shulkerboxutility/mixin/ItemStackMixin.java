package io.github.cotrin8672.shulkerboxutility.mixin;

import io.github.cotrin8672.shulkerboxutility.mixinimpl.ItemStackMixinImpl;
import net.minecraft.entity.LivingEntity;
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
        ItemStackMixinImpl.decrementUnlessCreative(((ItemStack) (Object) this), amount, entity, ci);
    }
}
