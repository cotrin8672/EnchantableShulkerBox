package io.github.cotrin8672.shulkerboxutility.registry

import io.github.cotrin8672.shulkerboxutility.ShulkerBoxUtility
import net.minecraft.item.Item
import net.minecraft.registry.RegistryKeys
import net.minecraft.registry.tag.TagKey
import net.minecraft.util.Identifier

object ModTags {
    @JvmStatic
    val SHULKER_BOXES = TagKey.of(RegistryKeys.ITEM, Identifier.of("c", "shulker_boxes"))

    private fun bind(name: String): TagKey<Item> = TagKey.of(RegistryKeys.ITEM, ShulkerBoxUtility.of(name))
}
