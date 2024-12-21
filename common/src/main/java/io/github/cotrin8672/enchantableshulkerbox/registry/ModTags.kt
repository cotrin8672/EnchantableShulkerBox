package io.github.cotrin8672.enchantableshulkerbox.registry

import io.github.cotrin8672.enchantableshulkerbox.EnchantableShulkerBox
import net.minecraft.item.Item
import net.minecraft.registry.RegistryKeys
import net.minecraft.registry.tag.TagKey

object ModTags {
    @JvmStatic
    val SHULKER_BOXES: TagKey<Item> = bind("shulker_boxes")

    private fun bind(name: String): TagKey<Item> = TagKey.of(RegistryKeys.ITEM, EnchantableShulkerBox.of(name))
}
