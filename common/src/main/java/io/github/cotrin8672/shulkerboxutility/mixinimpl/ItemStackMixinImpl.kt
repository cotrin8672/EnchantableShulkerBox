package io.github.cotrin8672.shulkerboxutility.mixinimpl

import io.github.cotrin8672.shulkerboxutility.ShulkerBoxUtility
import io.github.cotrin8672.shulkerboxutility.registry.ModTags
import net.minecraft.component.DataComponentTypes
import net.minecraft.component.type.ContainerComponent
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ItemStack
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo
import java.util.stream.Collectors

object ItemStackMixinImpl {
    @JvmStatic
    fun decrementUnlessCreative(
        stack: ItemStack,
        amount: Int,
        entity: LivingEntity,
        ci: CallbackInfo,
    ) {
        if (!ShulkerBoxUtility.CONFIG.enableRefillFeature) return
        if (entity !is PlayerEntity) return
        if (entity.isSpectator || entity.isCreative) return
        val shulkerList = entity.inventory.main.filter {
            it.isIn(ModTags.SHULKER_BOXES)
        }
        if (shulkerList.isEmpty()) return

        for (shulker in shulkerList) {
            val shulkerInventory = shulker.get(DataComponentTypes.CONTAINER) ?: continue
            val shulkerItems = shulkerInventory.stream().collect(Collectors.toList())
            val matchItem = shulkerItems.firstOrNull { it.item == stack.item } ?: continue
            matchItem.decrement(amount)
            shulker.set(DataComponentTypes.CONTAINER, ContainerComponent.fromStacks(shulkerItems))
            ci.cancel()
            break
        }
    }
}
