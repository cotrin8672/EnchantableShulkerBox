package io.github.cotrin8672.enchantableshulkerbox.mixinimpl

import io.github.cotrin8672.enchantableshulkerbox.registry.ModEnchantments
import io.github.cotrin8672.enchantableshulkerbox.registry.ModTags
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
        player: PlayerEntity,
        ci: CallbackInfo,
    ) {
        val enchantedShulkerList = player.inventory.main.filter {
            it.isIn(ModTags.SHULKER_BOXES) &&
                    it.enchantments.getLevel(
                        player.world.registryManager.createRegistryLookup().getOptionalEntry(
                            ModEnchantments.REFILL.registryRef,
                            ModEnchantments.REFILL
                        ).get()
                    ) > 0
        }

        for (shulker in enchantedShulkerList) {
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
