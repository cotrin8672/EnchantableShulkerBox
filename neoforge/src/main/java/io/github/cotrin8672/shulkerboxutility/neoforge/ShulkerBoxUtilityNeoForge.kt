package io.github.cotrin8672.shulkerboxutility.neoforge

import io.github.cotrin8672.shulkerboxutility.ShulkerBoxUtility
import io.github.cotrin8672.shulkerboxutility.ShulkerBoxUtility.init
import net.neoforged.api.distmarker.Dist
import net.neoforged.fml.common.Mod

@Mod(ShulkerBoxUtility.MOD_ID, dist = [Dist.DEDICATED_SERVER])
class ShulkerBoxUtilityNeoForge {
    init {
        init()
    }
}
