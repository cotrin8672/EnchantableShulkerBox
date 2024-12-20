package io.github.cotrin8672.shulkerboxutility.neoforge.config

import io.github.cotrin8672.shulkerboxutility.config.ModConfig
import net.minecraft.client.gui.screen.Screen
import net.neoforged.fml.ModContainer
import net.neoforged.neoforge.client.gui.IConfigScreenFactory

object ConfigScreenFactory : IConfigScreenFactory {
    override fun createScreen(modContainer: ModContainer, arg: Screen): Screen {
        return ModConfig.getConfigScreen(arg)
    }
}
