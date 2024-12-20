package io.github.cotrin8672.enchantableshulkerbox

import net.minecraft.util.Identifier

object EnchantableShulkerBox {
    const val MOD_ID = "enchantableshulkerbox"

    @JvmStatic
    fun init() {
    }

    fun of(name: String): Identifier = Identifier.of(MOD_ID, name)
}
