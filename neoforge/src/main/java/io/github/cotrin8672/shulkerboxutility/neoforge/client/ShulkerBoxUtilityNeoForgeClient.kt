package io.github.cotrin8672.shulkerboxutility.neoforge.client

import io.github.cotrin8672.shulkerboxutility.ShulkerBoxUtility
import io.github.cotrin8672.shulkerboxutility.neoforge.config.ConfigScreenFactory
import net.neoforged.api.distmarker.Dist
import net.neoforged.fml.ModContainer
import net.neoforged.fml.common.Mod
import net.neoforged.neoforge.client.gui.IConfigScreenFactory

@Mod(ShulkerBoxUtility.MOD_ID, dist = [Dist.CLIENT])
class ShulkerBoxUtilityNeoForgeClient(container: ModContainer) {
    init {
        ShulkerBoxUtility.init()
        container.registerExtensionPoint(IConfigScreenFactory::class.java, ConfigScreenFactory)
    }
}
