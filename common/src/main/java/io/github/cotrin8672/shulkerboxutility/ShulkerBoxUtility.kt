package io.github.cotrin8672.shulkerboxutility

import io.github.cotrin8672.shulkerboxutility.config.ModConfig
import me.shedaniel.autoconfig.AutoConfig
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer
import net.minecraft.util.Identifier

object ShulkerBoxUtility {
    const val MOD_ID = "shulkerboxutility"
    val CONFIG by lazy { AutoConfig.getConfigHolder(ModConfig::class.java).config }

    @JvmStatic
    fun init() {
        AutoConfig.register(ModConfig::class.java, ::Toml4jConfigSerializer)
    }

    fun clientInit() {
        
    }

    fun of(name: String): Identifier = Identifier.of(MOD_ID, name)
}
