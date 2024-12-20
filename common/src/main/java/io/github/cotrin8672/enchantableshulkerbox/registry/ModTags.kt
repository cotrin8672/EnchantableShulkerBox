package io.github.cotrin8672.enchantableshulkerbox.registry

import io.github.cotrin8672.enchantableshulkerbox.EnchantableShulkerBox
import net.minecraft.item.Item
import net.minecraft.registry.RegistryKeys
import net.minecraft.registry.tag.TagKey
import net.minecraft.util.Identifier

object ModTags {
    @JvmStatic
    val SHULKER_BOXES: TagKey<Item> = TagKey.of(RegistryKeys.ITEM, Identifier.of("c", "shulker_boxes"))

    private fun bind(name: String): TagKey<Item> = TagKey.of(RegistryKeys.ITEM, EnchantableShulkerBox.of(name))
}
