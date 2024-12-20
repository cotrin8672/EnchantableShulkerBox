package io.github.cotrin8672.shulkerboxutility.config

import io.github.cotrin8672.shulkerboxutility.ShulkerBoxUtility
import me.shedaniel.autoconfig.AutoConfig
import me.shedaniel.autoconfig.ConfigData
import me.shedaniel.autoconfig.annotation.Config
import net.minecraft.client.gui.screen.Screen

@Config(name = ShulkerBoxUtility.MOD_ID)
class ModConfig : ConfigData {
    var enableRefillFeature = true

    companion object {
        fun getConfigScreen(parent: Screen): Screen = AutoConfig.getConfigScreen(ModConfig::class.java, parent).get()
    }
}
