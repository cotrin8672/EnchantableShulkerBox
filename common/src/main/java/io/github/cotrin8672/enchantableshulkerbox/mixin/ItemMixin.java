package io.github.cotrin8672.enchantableshulkerbox.mixin;

import io.github.cotrin8672.enchantableshulkerbox.registry.ModTags;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Item.class)
public class ItemMixin {
    @Inject(method = "getEnchantability", at = @At("HEAD"), cancellable = true)
    private void enchantableshulkerbox$getEnchantability(CallbackInfoReturnable<Integer> cir) {
        Item item = (Item) (Object) this;
        if (new ItemStack(item).isIn(ModTags.getSHULKER_BOXES())) {
            cir.setReturnValue(1);
            cir.cancel();
        }
    }

    @Inject(method = "isEnchantable", at = @At("HEAD"), cancellable = true)
    private void enchantableshulkerbox$isEnchantable(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        if (stack.isIn(ModTags.getSHULKER_BOXES())) {
            cir.setReturnValue(true);
            cir.cancel();
        }
    }
}
