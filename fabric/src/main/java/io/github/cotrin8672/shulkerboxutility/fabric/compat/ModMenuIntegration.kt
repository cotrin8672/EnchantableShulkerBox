package io.github.cotrin8672.shulkerboxutility.fabric.compat

import com.terraformersmc.modmenu.api.ConfigScreenFactory
import com.terraformersmc.modmenu.api.ModMenuApi
import io.github.cotrin8672.shulkerboxutility.config.ModConfig

class ModMenuIntegration : ModMenuApi {
    override fun getModConfigScreenFactory(): ConfigScreenFactory<*> {
        return ConfigScreenFactory(ModConfig.Companion::getConfigScreen)
    }
}
