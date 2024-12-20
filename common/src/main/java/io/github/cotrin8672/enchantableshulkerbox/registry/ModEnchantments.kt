package io.github.cotrin8672.enchantableshulkerbox.registry

import io.github.cotrin8672.enchantableshulkerbox.EnchantableShulkerBox
import net.minecraft.enchantment.Enchantment
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys

object ModEnchantments {
    val REFILL: RegistryKey<Enchantment> = RegistryKey.of(RegistryKeys.ENCHANTMENT, EnchantableShulkerBox.of("refill"))
}
